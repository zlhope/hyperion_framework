import os, sys, threading, subprocess
import urllib
import datetime
  
class Install_Apk:
    def __init__(self, url="DEFAULT"):
        self.url = url
        self.devices = self._get_devices()
        
    def _get_devices(self):
        devices = []
        result = os.popen("adb devices").read()
        for str in result.split("\n"):
            if ("List of devices attached" != str) \
                and ("" != str) and str.endswith("device"):
                device = str.split('\t')[0]
                devices.append(device)
        if len(devices) == 0:
            raise Exception("No devices!!!")
            sys.exit()
        print devices
        return devices
    
    def install_app(self, build_name):
        if not os.path.exists(build_name):
            print "APK file does not exist, install failed!"
            sys.exit()
        try:
            for device in self.devices:
                unstall_command = "adb -s " + device + " uninstall com.telenav.app.denali.na"
                install_command = "adb -s " + device + " install -r " + build_name
                os.system(unstall_command)
                os.system(install_command)
                os.system("adb -s " + device + " shell rm /sdcard/Files/Hyperion/ScreenShot/*")
                os.system("adb -s " + device + " shell rm /sdcard/Files/Hyperion/Gifs/*")
                os.system("adb -s " + device + " shell rm -rf /sdcard/Files/Hyperion/Gifs_Output/*")
                os.system("adb -s " + device + " shell rm /sdcard/Files/Hyperion/Log/*")
        except:
            print "Install APK Failed!"
    
    def pull_images(self):
        os.system(r"mkdir ..\hyperion\build\reports\androidTests\connected\img")
        os.system(r"mkdir ..\hyperion\build\log")
        os.system(r"mkdir ..\hyperion\build\gif_output")
        for device in self.devices:
            os.system("adb -s " + device + r" pull /sdcard/Files/Hyperion/ScreenShot ..\hyperion\build\reports\androidTests\connected\img")
            os.system("adb -s " + device + r" pull /sdcard/Files/Hyperion/Log ..\hyperion\build\log")
            os.system("adb -s " + device + r" pull /sdcard/Files/Hyperion/Gifs_Output ..\hyperion\build\gif_output")
    
        print "Pull images from devices successfully!"
    
    def set_property_to_EC(self , on_off_flag="true"):
        try:
            build_id = self.url.split('/')[-1].split("-")[-2]
        except:
            build_id = "Unknown"
        os.system("ectool setProperty /myJob/buildId " + build_id)
        os.system("ectool setProperty /myJob/dataVersion " + self._get_data_version())
        report_path = r'..\hyperion\build\reports\androidTests\connected\index.html'
        if os.path.exists(report_path):
            linelist = open(report_path).readlines()
            for i in range(len(linelist)):
                if linelist[i].find('<div class="infoBox" id="tests">') != -1:
                    testcount = linelist[i + 1].split("</")[0].split(">")[-1]
                if linelist[i].find('<div class="infoBox" id="failures">') != -1:
                    failures = linelist[i + 1].split("</")[0].split(">")[-1]
                if linelist[i].find('<div class="infoBox" id="duration">') != -1:
                    duration = linelist[i + 1].split("</")[0].split(">")[-1]
                if linelist[i].find('id="successRate">') != -1:
                    successrate = linelist[i + 1].split("</")[0].split(">")[-1]     
        if on_off_flag == "true":
            os.system("ectool setProperty /myJob/off_total " + testcount)
            os.system("ectool setProperty /myJob/off_failures " + failures)
            os.system("ectool setProperty /myJob/off_time " + duration)
            os.system("ectool setProperty /myJob/off_percentage " + successrate)
        else:
            os.system("ectool setProperty /myJob/on_total " + testcount)
            os.system("ectool setProperty /myJob/on_failures " + failures)
            os.system("ectool setProperty /myJob/on_time " + duration)
            os.system("ectool setProperty /myJob/on_percentage " + successrate)
        
    def _urlcallback(self, a, b, c):
        prec = 100.0 * a * b / c
        if 100 < prec:
            prec = 100
        if prec % 10 == 0:
            print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            print "Downloading:%.1f%%" % (prec,)

    def _download_package(self, dest):
        if os.path.exists(dest):
            return
        if self.url == "":
            print "Download URL is empty, skip download step!"
            return
        print "Start downloading from " + self.url + " to " + dest
        urllib.urlretrieve(self.url, dest, self._urlcallback)
        print "Download finished" 
          
    def download_and_install(self):
        try:
            if self.url.upper() == "DEFAULT":
                self.url = self.get_latest_version_download_url()
            if not (self.url.upper() == "IGNORE"):
                apk_name = self.url.split('/')[-1] 
                self._download_package(apk_name)
                self.install_app(apk_name)
        except Exception, e:
            print "Raise exception when you download the file ", e
            return None
    
    def get_latest_version_download_url(self):
        base_url = "http://tar2.telenav.com/repository/telenav/Denali-product1/Scout4cars-Android/"
        xml_data = urllib.urlopen(base_url).readlines()
        latest_version = None
        for data in xml_data:
            if data.find('''<tr><td valign="top"><img src="/icons/folder.gif" alt="[DIR]"></td><td>''') != -1:
                version = data.split('''/">''')[1].split('''/</a>''')[0]
                if version[0:2] == "2.":
                    latest_version = version
        latest_url = base_url + latest_version + "/denali-android/denali-android-" + \
                   latest_version + "-signed.apk"
        print "Find latest build URL: " + latest_url
        return latest_url
    
    def _cmd_run(self, cmd, output):
        p = subprocess.Popen(cmd, stdout=output)
    
    def _get_data_version(self):
        cmd = "adb shell cat /sdcard/TelenavMapData/version.txt"
        results = os.popen(cmd).read().split("\r\n")
        if(len(results) <= 2):
            return "Unknown"
        else:
            return results[0].split("/")[-1].split(".")[0]

    def logcat_collect(self):
        for device in self.devices:
            LOGCAT = open('logcat_'+device+'.txt','w')
            cmd ="adb -s "+device+" logcat *:W"
            print cmd
            try:
                sthread = threading.Thread(target = self._cmd_run, args = (cmd ,LOGCAT))
                sthread.start()
            except:
                LOGCAT.close()
                print "Error: unable to start thread"
    
if __name__ == '__main__':
    #download_url = "http://tar2.telenav.com/repository/telenav/Denali-product1/Scout4cars-Android/1.13.456058/denali-android/denali-android-1.13.456058-signed.apk"
    try:
        download_url = sys.argv[1]
    except:
        download_url = ""
    apk_handler = Install_Apk(download_url)
    apk_handler.download_and_install()
