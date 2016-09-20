
import os, re, sys, time

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
    
#  
def modify_mockTrafficConfig(file_path, offboard):
    file_object = open(file_path,'r')
    file_string = file_object.read()
    
    pDATA_DIR = re.compile('(?<=^UseStaticTraffic=).*', re.MULTILINE)
    file_string = pDATA_DIR.sub(offboard, file_string)

    file_object.close()
    file_object = open(file_path,'w')
    file_object.write(file_string)
    file_object.close()
    
if __name__ == "__main__":
    trafficPath =''
    if len(sys.argv) > 2:
        trafficPath = sys.argv[1]
        
    deviceArray = getDevices()
    
    
    ConfigFile = "TelenavConfig.cfg"
    trafficFile = os.path.join(trafficPath,"static_traffic.json")
    #trafficFile = "mocktraffic.json"
    tragetConfigDir = '/sdcard/Android/data/com.telenav.app.denali.na/files/config_res/'
    #tragetTrafficDir = '/sdcard/Android/data/com.telenav.app.denali.na/files/sdk_tmp/'  
    tragetTrafficDir = '/storage/usb/usb0/vol1/TelenavMapData/traffic/' #2/6/2015: changed after NGX implementation 
    
    for device in deviceArray:
        # update "UseStaticTraffic" will be handled in the test case. comment out below 2 lines, 1/19/2015, Andy
        #os.system('adb -s ' + device + ' pull ' + tragetConfigDir + ConfigFile + " " + ConfigFile)
        #modify_mockTrafficConfig(ConfigFile, sys.argv[2])
        
        os.system('adb -s ' + device + ' shell mkdir -p ' + tragetTrafficDir)
        os.system('adb -s ' + device + ' ls /sdcard/Android/data/com.telenav.app.denali.na/files/')
        os.system('adb -s ' + device + ' push ' + trafficFile + ' ' + tragetTrafficDir )

    time.sleep(5)

