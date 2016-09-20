import sys, os, time
from report.htmlhandler import HtmlHandler
DIR = r"..\\..\\"
HTML_FILE = r'statistic\statistic.html'
TARGET_FILE = r'..\app\build\reports\androidTests\connected\index.html'
result_list = []
 
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

#get statistic data 
dir_list = os.listdir(DIR)
dir_list.sort(compare)
for item in dir_list:
    try:
        data = {}
        linelist = open(r'..\\..\\' + item + r'\app\build\reports\androidTests\connected\index.html').readlines()
        for i in range(len(linelist)):
            if linelist[i].find('<div class="infoBox" id="tests">') != -1:
                testcount = linelist[i + 1].split("</")[0].split(">")[-1]
            if linelist[i].find('<div class="infoBox" id="failures">') != -1:
                failures = linelist[i + 1].split("</")[0].split(">")[-1]
            if linelist[i].find('id="successRate">') != -1:
                successrate = linelist[i + 1].split("</")[0].split(">")[-1]
        testcount = int(testcount)
        failures = int(failures)
        data["testcount"] = testcount
        data["success"] = testcount - failures
        data["successrate"] = successrate
        data["date"] = get_dir_mtime(item)
        result_list.append(data)
        if len(result_list) > 20:
            break
    except:
        pass
     
def get_rate_data():
    ret = ""
    for item in result_list:
        ret = item["successrate"].replace("%", "") + "," + ret
    return "[" + ret[:-1] + "]"
 
def get_date_data():
    ret = ""
    for item in result_list:
        ret = "\"" + item["date"] + "\"," + ret
    return "[" + ret[:-1] + "]"
 
def get_cases_data():
    ret1 = ""
    ret2 = ""
    for item in result_list:
        ret1 = str(item["success"]) + "," + ret1
        ret2 = str(item["testcount"]) + "," + ret2
    return "[[" + ret1[:-1] + "]" + ",[" + ret2[:-1] + "]]"
 
# write data into statistic statistic report
linelist = open(HTML_FILE).readlines()
for i in range(len(linelist)):
    if linelist[i].find('var data = [') != -1:
        linelist[i] = '    var data = [' + get_rate_data() + '];\n'
    if linelist[i].find('var x = [') != -1:
        linelist[i] = '    var x = ' + get_date_data() + ';\n'
    if linelist[i].find('var data1 = [') != -1:
        linelist[i] = '    var data1 = ' + get_cases_data() + ';\n'
fobj = file(HTML_FILE, "w");
fobj.writelines(linelist);
fobj.close();
if os.path.exists(r"..\app\build\reports\androidTests\connected\index_bk.html"):
    os.system(r"copy ..\app\build\reports\androidTests\connected\index_bk.html "+TARGET_FILE+" /y")
else:
    os.system("copy "+TARGET_FILE+r" ..\app\build\reports\androidTests\connected\index_bk.html /y")
#add statistic report into test report html page
handle1=HtmlHandler(HTML_FILE)
handle2=HtmlHandler(TARGET_FILE)
tags1=handle1.get_tags("script")
tags2=handle1.get_tags("div")
for tag in tags1:
    handle2.insert_tag("head", tag)
handle2.insert_tag("div",tags2[0],False)
handle2.insert_iframe()
#add backlog link into test report html page
handle2.set_backlog_link()
#copy js files
os.system(r"xcopy .\statistic ..\app\build\reports\androidTests\connected\ /s/e/y/q")
sys.exit()
