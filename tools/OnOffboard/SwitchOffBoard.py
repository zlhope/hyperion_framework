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
        
    deviceArray = getDevices()

    for device in deviceArray:
        '''by updating config
        os.system('adb -s ' + device + ' shell am force-stop com.telenav.app.denali.na')

        telenavConfigDir = '/sdcard/Android/data/com.telenav.app.denali.na/files/config_res/'
        telenavConfigFile = 'TelenavConfig.cfg'
         
        os.system('adb -s ' + device + ' pull ' + telenavConfigDir + telenavConfigFile + " " + telenavConfigFile)
        
        # the first parameter could be 0 or 1, 1 is off board, 0 is on board
        modify_offboardconfig(telenavConfigFile, sys.argv[1])

        os.system('adb -s ' + device + ' push ' + telenavConfigFile + ' ' + telenavConfigDir)
        '''
        # by wifi enable/disable
        # the first parameter could be 0 or 1, 1 is off board, 0 is on board
        if(sys.argv[1] =='1'):
            os.system('adb -s ' + device + ' shell su -c svc wifi enable')
        else:
            os.system('adb -s ' + device + ' shell su -c svc wifi disable')
    
    
