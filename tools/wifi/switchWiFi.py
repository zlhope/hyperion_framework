import os, re, sys

def getDevices():
    deviceArray = []
    file_object = open("devices.txt");
    try:
        for line in file_object:
            if line != "":
                line = line.strip('\n')
                deviceArray.append(line)
    finally:
        file_object.close()
    return deviceArray

def modify_offboardconfig(file_path, offboard):
    file_object = open(file_path,'r')
    file_string = file_object.read()
    
    pDATA_DIR = re.compile('(?<=^Enable Offboard Features=).*', re.MULTILINE)
    file_string = pDATA_DIR.sub(offboard, file_string)

    file_object.close()
    file_object = open(file_path,'w')
    file_object.write(file_string)
    file_object.close()

    
if __name__ == "__main__":
    
    if len(sys.argv) < 2:
        print "please enter the offboard or onboard value in command line."
        exit(0)
        
    if(sys.argv[1] =='1'):
        os.system('adb shell su -c svc wifi enable')
    else:
        os.system('adb shell su -c svc wifi disable')
        
    
    
