import sys
import subprocess,time, datetime, os

if __name__ == "__main__":
    
    if len(sys.argv) < 2:
        print "Please specify region in command line arguments."
        exit(1)
    region = sys.argv[1]
    
    cmd = 'python ParallelRunner.py Stability config/CasesExecution.cfg false false'
    #os.system(cmd)

    p = subprocess.Popen(cmd,shell=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE)

    now = datetime.datetime.now()
    fileName = str(now).replace('-','').replace(' ','').replace(':','').split('.')[0]
    fUSSPSS = open('report\logUSSPSS'+fileName+'.txt','w')
    fUSSPSS.write('                  Pss      Private  Private Swapped Heap    Heap      Heap\n')
    fUSSPSS.write('                 Total     Dirty     Clean  Dirty   Size    Alloc     Free\n')
    fUSSPSS.flush()

    fDalvik = open('report\logDalvik'+fileName+'.txt','w')
    fDalvik.write('                  Pss      Private   Private Swapped Heap    Heap      Heap\n')
    fDalvik.write('                 Total     Dirty      Clean  Dirty   Size    Alloc     Free\n')
    fDalvik.flush()

    fNavtive = open('report\logNavtive'+fileName+'.txt','w')
    fNavtive.write('                  Pss      Private   Private Swapped Heap    Heap      Heap\n')
    fNavtive.write('                 Total     Dirty      Clean  Dirty   Size    Alloc     Free\n')
    fNavtive.flush()

    fVSSRSS = open('report\logVSSRSS'+fileName+'.txt','w')
    fVSSRSS.write('  PID      CPU% S #THR VSS      RSS    PCY  UID      Name\n')
    fVSSRSS.flush()

    print "before ectool"
    os.system("ectool setProperty /myJob/logUSSPSS " + 'report\logUSSPSS'+fileName+'.txt')
    os.system("ectool setProperty /myJob/logVSSRSS " + 'report\logVSSRSS'+fileName+'.txt')
    os.system("ectool setProperty /myJob/logVSSRSS " + 'report\logDalvik'+fileName+'.txt')
    os.system("ectool setProperty /myJob/logVSSRSS " + 'report\logNavtive'+fileName+'.txt')
    print "after ectool"

    p_1 = None
    p_2 = None
    p_3 = None
    p_4 = None
    p_id1 = ""
    p_id2 = ""
    p_id3 = ""
    p_id4 = ""
    while(p.poll() == None):
        #Get USS/PSS
        #cmd = "adb shell dumpsys meminfo com.telenav.app.denali." + region.lower() + " | grep TOTAL"
        cmd1 = "adb shell dumpsys meminfo com.telenav.app.denali.na | grep TOTAL"
        if p_1 != None and p_1.poll() == None:
            p_1.kill()
        time.sleep(15)
        
        p_1 = subprocess.Popen(cmd1, stdout=fUSSPSS)
        p_id1 = p_1.pid
        print p_id1

        #Get VSS/RSS/CPU%
        #cmd2 = "adb shell top -n 1| grep com.telenav.app.denali." + region.lower()
        cmd2 = "adb shell top -n 1| grep com.telenav.app.denali.na"
        if p_2 != None and p_2.poll() == None:
            p_2.kill()
        time.sleep(15)

        p_2 = subprocess.Popen(cmd2, stdout=fVSSRSS)
        p_id2 = p_2.pid
        print p_id2

        #Get Native Heap
        cmd3 = "adb shell dumpsys meminfo com.telenav.app.denali.na | grep 'Native Heap'"
        if p_3 != None and p_3.poll() == None:
            p_3.kill()
        time.sleep(15)

        p_3 = subprocess.Popen(cmd3, stdout=fNavtive)
        p_id3 = p_3.pid
        print p_id3

        #Get Dalvik Heap
        cmd4 = "adb shell dumpsys meminfo com.telenav.app.denali.na | grep 'Dalvik Heap'"
        if p_4 != None and p_4.poll() == None:
            p_4.kill()
        time.sleep(15)

        p_4 = subprocess.Popen(cmd4, stdout=fDalvik)
        p_id4 = p_4.pid
        print p_id4



    if p_1 != None and p_1.poll() == None:
        p_1.kill()

    if p_2 != None and p_2.poll() == None:
        p_2.kill()

    if p_3 != None and p_3.poll() == None:
        p_3.kill()

    if p_4 != None and p_4.poll() == None:
        p_4.kill()