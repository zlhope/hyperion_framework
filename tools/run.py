import os, sys
from installer.installapk import Install_Apk
from report.xmlparser import XmlParser
from report.htmlhandler import HtmlHandler
# from gif import gif
         
if len(sys.argv) < 1:
    print "Args error!"
    exit()
    
try:
    region = sys.argv[1]
except:
    region = "CN"
    
try:
    scope = sys.argv[2]
    testname = sys.argv[3]
except:
    scope = "BAT"
    testname = "NI"
    
try:
    download_url = sys.argv[4]
except:
    download_url = "DEFAULT"
    
try:
    offboard = sys.argv[5]
except:
    offboard = "true"
    
apk_handler = Install_Apk(download_url)
apk_handler.download_and_install()
#os.system("taskkill /f /im adb.exe")
#apk_handler.logcat_collect()

os.system("cd .. &&gradle clean uninstallAll")

gradle_args = "cd .. &&call gradle cC"
extra_args = " -Pandroid.testInstrumentationRunnerArguments.region=" + region
if offboard == "true":
    extra_args = extra_args + " -Pandroid.testInstrumentationRunnerArguments.class=com.hyperion.framework.test.denali.suite.offboard." + region.upper() + "_" + scope + "_Suite"
else:
    extra_args = extra_args + " -Pandroid.testInstrumentationRunnerArguments.class=com.hyperion.framework.test.denali.suite.onboard." + region.upper() + "_" + scope + "_Suite"
print gradle_args + extra_args

os.system(gradle_args + extra_args)

# generate GIF file
# 2016.4.21 by Johnny.H
# gif.create_gif_file()
xml_path = r'..\hyperion\build\outputs\androidTest-results\connected'
html_path = r'..\hyperion\build\reports\androidTests\connected'
try:
    apk_handler.pull_images()
    apk_handler.set_property_to_EC(offboard)
    xp = XmlParser(xml_path)
    data = xp.get_xml_info()
    handler = HtmlHandler(html_path, data)
    handler.insert_screen_shot()
    if offboard == "true":
        title = "MY19" + region.upper() + " Offboard"
    else:
        title = "MY19" + region.upper() + " Onboard"
    handler.set_title(title)
    handler.correct_anchor()
except Exception, e:
    print e
finally:
    os.system("taskkill /f /im adb.exe")
    sys.exit()
