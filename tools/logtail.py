# -*- coding: utf-8 -*-
import os 
import time  
import sys
loglength = 0
logstore = []
reload(sys)
sys.setdefaultencoding('utf-8')
while True:
    result = os.popen(r"adb shell cat /sdcard/Files/Hyperion/Log/Android_Automation_Log.log").readlines()
    if len(result) > loglength:
        if logstore == []:
            newline = result[-5:]
        else:
            newline = result[-(len(result)-loglength):]
        for i in newline:
            print i[:-1].strip().encode('GB18030')
    loglength = len(result)
    logstore = result
    time.sleep(3)