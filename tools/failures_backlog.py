import sys, os, time
from report.xmlparser import XmlParser
from report.htmlhandler import HtmlHandler
DIR = r"..\\..\\"
ON_XML_PATH=r"\onboard_report\connected\\"
OFF_XML_PATH=r"\offboard_report\connected\\"
HTML_FILE = r'statistic\backlog.html'
HTML_FILE1 = r'statistic\output.html'
result_list = []

if len(sys.argv) < 1:
    print "Args error!"
    exit()

try:
    offboard = sys.argv[1]
except:
    offboard = "true"

def compare(x, y):
    stat_x = os.stat(DIR + "/" + x)
    stat_y = os.stat(DIR + "/" + y)
    if stat_x.st_mtime < stat_y.st_mtime:
        return 1
    elif stat_x.st_mtime > stat_y.st_mtime:
        return -1
    else:
        return 0
    
def get_dir_mtime(target_dir):
    stat_dir = os.stat(DIR + "/" + target_dir)
    time_str = time.localtime(stat_dir.st_mtime)
    return time.strftime('%m-%d_%H', time_str)

dir_list = os.listdir(DIR)
dir_list.sort(compare)

if offboard == "true":
    XML_PATH = OFF_XML_PATH
else:
    XML_PATH = ON_XML_PATH
    
for item in dir_list:
    try:
        xp=XmlParser(DIR + item + XML_PATH)
        xp.get_statistic_info()
        for item1 in xp.data:
            if result_list==[]:
                result_list.append({"testname":item1["testname"],"failures":1,"failinfo":[{"detail":item1["failinfo"],"count":1}]})
            else:
                for item2 in result_list:
                    flag=False
                    if item1["testname"]==item2["testname"]:
                        flag=True
                        flag1=True
                        item2["failures"]=item2["failures"]+1
                        for item3 in item2["failinfo"]:
                            if item1["failinfo"]==item3["detail"]:
                                item3["count"]=item3["count"]+1
                                flag1=False
                                break
                        if flag1:
                            item2["failinfo"].append({"detail":item1["failinfo"],"count":1})
                        break
                if not flag:
                    result_list.append({"testname":item1["testname"],"failures":1,"failinfo":[{"detail":item1["failinfo"],"count":1}]})
        if dir_list.index(item)>=30:
            break
    except:
        pass
    
result_list=sorted(result_list, key=lambda result: result["failures"],reverse=True)
os.system(r"copy statistic\backlog_template.html statistic\backlog.html /y")
os.system(r"copy statistic\output_template.html statistic\output.html /y")
handle=HtmlHandler(HTML_FILE)
handle1=HtmlHandler(HTML_FILE1)
total_count=0
for item in result_list:
    total_count=total_count+item["failures"]
for i in range(len(result_list)):
    if i>=10:
        break
    result_list[i]["id"]=i+1;
    result_list[i]["percentage"]=str(round(result_list[i]["failures"]/float(total_count)*100,2))+"%";
    handle.excute_staisic(result_list[i])
handle1.generate_output()
os.system("python statistic_report.py " + offboard)
print "Statistic report has been generated successfully!"
os.system("taskkill /f /im adb.exe")
sys.exit(0)
