import os,sys
from download import DownloadApk
from distributedExecution import SetupOnDevices
from distributedExecution.XmlParser import XmlParser
from distributedExecution.HtmlHandler import HtmlHandler

# carrier=""
# scope="TEST"
# build_url='http://releaseota.telenav.com/release/avengers_carrier/trunk/uscc/NI/5.6.1.5.8405136'
 
if len(sys.argv) < 1:
    print "Args error!"
    exit()
extra_args=""
try:
    scope = sys.argv[1]
    if scope=="BAT":
        extra_args=extra_args+" -Pandroid.testInstrumentationRunnerArguments.class=com.telenav.uia.android.denali.suite.BATSuite"
    elif scope=="TEST":
        extra_args=extra_args+" -Pandroid.testInstrumentationRunnerArguments.class=com.telenav.uia.android.denali.suite.TESTSuite"
    else:
        extra_args=extra_args+" -Pandroid.testInstrumentationRunnerArguments.class=com.telenav.uia.android.denali.suite.ALLSuite"
except:
    scope=""
devices=SetupOnDevices.getDeviceList()
if scope!="TEST":
    os.system("cd .. &&gradle clean uninstallAll")
gradle_args="cd .. &&call gradle cC"
os.system(gradle_args+extra_args)
print gradle_args+extra_args
SetupOnDevices.pullImgFromDevices(devices)
#SetupOnDevices.setPropertyToEc(build_url)
xml_path=r'..\app\build\outputs\androidTest-results\connected'
html_path=r'..\app\build\reports\androidTests\connected'
xp=XmlParser(xml_path)
xp.getXmlInfo()
handle=HtmlHandler(html_path,xp.data,scope)
handle.excute()
handle.correct_anchor()
sys.exit()