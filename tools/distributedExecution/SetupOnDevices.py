import os,sys

def getDeviceList():
    deviceArray = []
    result = os.popen("adb devices").read()
    str_split = result.split("\n")
    for str in str_split:
        if ("List of devices attached" != str) \
            and ("" !=str) and str.endswith("device"):
            device = str.split('\t')[0]
            deviceArray.append(device)
    if len(deviceArray)==0:
        raise Exception("No devices!!!")
        sys.exit()
    print deviceArray
    return deviceArray

def setupOnDevices(deviceArray, buildFileName):
    for device in deviceArray:
        installApkCommand = "adb install -r " + buildFileName
        os.system(installApkCommand)

def pullImgFromDevices(deviceArray):
    os.system(r"mkdir ..\app\build\reports\androidTests\connected\img")
    os.system(r"mkdir ..\app\build\log")
    for device in deviceArray:
        os.system(r"adb pull /sdcard/img ..\app\build\reports\androidTests\connected\img")
        os.system(r"adb shell rm /sdcard/img/*")
        os.system(r"adb pull /sdcard/Files/Scout ..\app\build\log")
        os.system(r"adb shell rm /sdcard/Files/Scout/*")

    print "Pull images from devices successfully!"

def setPropertyToEc(build_url):
    os.system("ectool setProperty /myJob/buildId " + build_url.split('/')[-1])
    linelist=open(r'..\app\build\reports\androidTests\connected\index.html').readlines()
    for i in range(len(linelist)):
        if linelist[i].find('<div class="infoBox" id="tests">')!=-1:
            testcount= linelist[i+1].split("</")[0].split(">")[-1]
            os.system("ectool setProperty /myJob/testcount " + testcount)
        if linelist[i].find('<div class="infoBox" id="failures">')!=-1:
            failures= linelist[i+1].split("</")[0].split(">")[-1]
            os.system("ectool setProperty /myJob/failures " + failures)
        if linelist[i].find('<div class="infoBox" id="duration">')!=-1:
            duration= linelist[i+1].split("</")[0].split(">")[-1]
            os.system("ectool setProperty /myJob/duration " + duration)
        if linelist[i].find('id="successRate">')!=-1:
            successrate= linelist[i+1].split("</")[0].split(">")[-1]
            os.system("ectool setProperty /myJob/successrate " + successrate)

if __name__ == '__main__':
    pass
