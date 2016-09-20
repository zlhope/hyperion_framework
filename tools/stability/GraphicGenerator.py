import matplotlib # non - inactive, backend
matplotlib.use('Agg') # a backend mode
import matplotlib.pyplot as plt
import sys, os, re


def generateUssPss(fileUssPss, fileVssRss, dest):
    ussPssReader = open(fileUssPss)
    ussPsslLines = ussPssReader.readlines()
    #print ussPsslLines
    vssRssReader = open(fileVssRss)
    vssRsslLines = vssRssReader.readlines()
    #print vssRsslLines    
    total = len(ussPsslLines)
    if len(vssRsslLines) < len(ussPsslLines):
        total = len(vssRsslLines)
    
    Y1 = []
    Y2 = []
    Y3 = []
    Y4 = []
    Y5 = []
    for index in range(total):
        ussPssLine = ussPsslLines[index]
        vssRssLine = vssRsslLines[index]
        
        if index == 0:
            continue
        flag = False
        #print ussPssLine
        matchUssPss = re.match("^\s+TOTAL\s+(\d+)\s+(\d+)\s+", ussPssLine)
        if matchUssPss is not None:
            #print "ac"
            flag = True
            pss = matchUssPss.group(1)
            uss = matchUssPss.group(2)
            Y1.append(int(pss))
            Y2.append(int(uss))
        
        #print vssRssLine       
        matchVssRss = re.match("^\s?\d+\s+\d+\s+(\d+)%\s[SRZN]\s+\d+\s+(\d+)K\s+(\d+)K\s+", vssRssLine)
        if matchVssRss is not None:
            #print "avc"
            cpu = matchVssRss.group(1)
            vss = matchVssRss.group(2)
            rss = matchVssRss.group(3)
             
            if flag == True:
                Y3.append(int(vss))
                Y4.append(int(rss))
                Y5.append(float(cpu))
                flag = False

    X1 = range(0, len(Y1))
    X2 = range(0, len(Y2))
    X3 = range(0, len(Y3))
    X4 = range(0, len(Y4))
    X5 = range(0, len(Y5))
    print len(X1)
    print len(Y1)
    print len(Y2)
    print len(Y3)
    print len(Y4)
    total_Y1 = 0
    total_Y5 = 0
    for index in range(0, len(Y1)):
        total_Y1 += Y1[index]
    for index in range(0, len(Y5)):
        total_Y5 += Y5[index]
    avg_Y1 = total_Y1/len(Y1)
    avg_Y5 = total_Y5/len(Y5)
    print "avg_Y1:" + str(avg_Y1)
    print "avg_Y5:" + str(avg_Y5)
    Fig = plt.figure(figsize=(24,8))      # Create a `figure' instance
    Ax = Fig.add_subplot(111)        # Create a `axes' instance in the figure
    Ax.plot(X1, Y1, label="$PSS$")  # Create a Line2D instance in the axes
    Ax.plot(X2, Y2, label="$USS$")
    Ax.plot(X3, Y3, label="$VSS$")
    Ax.plot(X4, Y4, label="$RSS$")

    plt.xlabel("Time(mins)")
    plt.ylabel("Memory(K)")
    plt.title("Denali PSS/USS/VSS/RSS")
    Ax.legend()

    Fig.savefig(dest + os.sep + "DenaliStability.png")
    
    Fig2 = plt.figure(figsize=(24,8))      # Create a `figure' instance
    Ax2 = Fig2.add_subplot(111)        # Create a `axes' instance in the figure
    Ax2.plot(X5, Y5, label="$CPU%$")
    plt.title("Denali CPU%")
    Ax2.legend()
    Fig2.savefig(dest + os.sep + "DenaliCPU.png")
    
    ussPssReader.close()
    vssRssReader.close()
    
if __name__ == "__main__":
    fileUssPss = ""
    fileVssRss = ""
    dest = "."
    
    if len(sys.argv) < 3:
        print "Please enter the usspss and vssrss file!"
        exit(1)
    
    elif len(sys.argv) == 3:
        fileUssPss = sys.argv[1]
        fileVssRss = sys.argv[2]
    else:
        fileUssPss = sys.argv[1]
        fileVssRss = sys.argv[2]
        dest = sys.argv[3]
        
    generateUssPss(fileUssPss, fileVssRss, dest)
