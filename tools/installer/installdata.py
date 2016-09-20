'''
Created on 2015-2-11

@author: sxma
'''

import getopt
import sys
import os
import socket
import urllib
import tarfile
import datetime
import shutil
import csv
import subprocess
import time
from multiprocessing import Pool

MMAP = "map"
MTILES = "tiles"
MSEARCH = "onboard_search"
MJUNCTION = "junction_view"
MTRAFFIC = "traffic"
MLANDMARKS = "landmarks_3_d"
MREGION = "region"
CURRENT = "TelenavMapData"
MAPDATADB = "mapdata.db"
PARTNUMBER = "part_number.bin"
FULLPATH = "FULLPATH"

def execCmd(cmd):
    r = os.popen(cmd)
    text = r.read()
    r.close()
    return text

def index(s, sub, start=0):
    for i in range(start,len(s)):
        p=i
        for j in sub:
            if j==s[p]: p+=1
            else: break
        else:
            idx=i
            break
    else:
        idx=-1
    return idx

def getDeviceList():
    deviceArray = []
    # get the device serial number list from cmd
    cmd = "adb devices"
    result = execCmd(cmd)
    # split result into list
    str_split = result.split("\n")
    # analyze the result and get the device and count
    count = 0
    while count < len(str_split):
        #if ("List of devices attached " != str_split[count]) \
        #    and (index(str_split[count], "* ") == -1) \
        #    and ("" !=str_split[count]):
        if("\t" in str_split[count]):         
            device = str_split[count][0:index(str_split[count], "\t")]
            deviceArray.append(device)
        count = count + 1
    return deviceArray

def checkURLUpdate(version, url):
    if not os.path.exists(version):
        return True
    
    fileObj = open(version)
    for line in fileObj:
        line = line.strip()
        if line.find(url) != -1:
            return False
    fileObj.close()
    return True

def checkUpdate(url, dest, region):
    pullVersion4DevicePre = "adb -s "
    pullVersion4DevicePost = " pull /sdcard/TelenavMapData/version.txt " + dest + os.sep + region
    pullVersion4HeadUnitPost = " pull /storage/sdcard/sdcard0/vol1/TelenavMapData/version.txt " + dest + os.sep + region
    deviceDataPath = "/sdcard/TelenavMapData"
    
    deviceArray = getDeviceList()
    ifFound = False
    for index in range(len(deviceArray)):
        device = deviceArray[index]
        '''
        For gm head unit, its device name is ip address, the data path is /storage/sdcard/sdcard0/vol1/TelenavMapData
        '''
        if "." in device:
            print "--- head unit ---"
            deviceDataPath = "/storage/sdcard/sdcard0/vol1/TelenavMapData"
            command = pullVersion4DevicePre + device + pullVersion4HeadUnitPost + os.sep + "version_" + str(index) + ".txt"
            os.system(command)
        else:
            print "--- tablet ---"
            deviceDataPath = "/sdcard/TelenavMapData"
            command = pullVersion4DevicePre + device + pullVersion4DevicePost + os.sep + "version_" + str(index) + ".txt"
            os.system(command)
            # remove true_delta file to avoid incorrect version mapping, causing fail to search, added by Andy Lin 04/04/2016
            command1 = pullVersion4DevicePre + device + " shell rm -rf "+deviceDataPath+"/true_delta"
            os.system(command1)
        ifFound = checkURLUpdate(dest + os.sep + region + os.sep + "version_" + str(index) + ".txt", url)
        
        if ifFound:
            break
    if not ifFound:
        print "No data update on device!"
        if os.path.exists(dest + os.sep + region):
            print " starting remove version.txt ---"
            shutil.rmtree(dest + os.sep + region)
            print "removed version.txt ---"
        return
    
    # delete all the local files
    if os.path.exists(dest + os.sep + region):
        shutil.rmtree(dest + os.sep + region)
    
    # download all data
    downloadPackage(url, dest + os.sep + region, region)
    
    csvFile = dest + os.sep + region + os.sep + "note.csv"
    dirList = os.listdir(dest + os.sep + region + os.sep)
    for eachFile in dirList:
        if eachFile.startswith("note_") == True:
            csvFile = dest + os.sep + region + os.sep + eachFile
            break

    # request version
    versionRequestMap = getData4UrlVersion(csvFile)
    
    # write version txt
    writeVersion(csvFile, dest, region, url)
    
    '''
    push data for each device
    '''
    for index in range(len(deviceArray)):
        device = deviceArray[index]
        '''
        For gm head unit, its device name is ip address, the data path is /storage/sdcard/sdcard0/vol1/TelenavMapData
        '''
        if "." in device:
            print "--- head unit ---"
            deviceDataPath = "/storage/sdcard/sdcard0/vol1/TelenavMapData"
            command = pullVersion4DevicePre + device + pullVersion4HeadUnitPost + os.sep + "version_" + str(index) + ".txt"
            os.system(command)
        else:      
            # For google nexus 7, data path is /sdcard/TelenavMapData/curret, its device name is 09f82c19
            print "--- tablet ---"
            deviceDataPath = "/sdcard/TelenavMapData"
            command = pullVersion4DevicePre + device + pullVersion4DevicePost + os.sep + "version_" + str(index) + ".txt"
            os.system(command)
        
        updateFlag = 0
        if os.path.exists(dest + os.sep + region + os.sep + "version_" + str(index) + ".txt"):
            fileObj = open(dest + os.sep + region + os.sep + "version_" + str(index) + ".txt")
            versionDeviceMap = {}
            for line in fileObj:
                line = line.strip()
                dataVersionArray = line.split(",")
                if dataVersionArray[0] == FULLPATH:
                    continue
                
                if len(dataVersionArray) >= 2:
                    print 'key=>: {0}, value=>:{1}'.format(dataVersionArray[0],dataVersionArray[1])
                    versionDeviceMap[dataVersionArray[0]] = dataVersionArray[1]
            fileObj.close()
            
            os.remove(dest + os.sep + region + os.sep + "version_" + str(index) + ".txt")
            # if there is no expected region on device
            if region.lower() != versionDeviceMap["region"].lower():
                print "--- region doesn't exist on device ---"
                updateFlag = 1
            else:
                # Check the corresponding data on device
                print "--- region exists on device ---"
                updateFlag = 3
        else:
            print "--- no version.txt on device ---"
            updateFlag = 2

        if updateFlag == 1 or updateFlag == 2:
            allComponents = os.listdir(dest + os.sep + region + os.sep + CURRENT)
            os.system(pullVersion4DevicePre + device + " shell rm -fr " + deviceDataPath)
            pool = Pool(processes=6)
            for component in allComponents:
                cmd = pullVersion4DevicePre + device + " push " + dest + os.sep + region + os.sep + CURRENT + os.sep + component + " " + deviceDataPath + "/" + component    
                pool.apply_async(os.system, (cmd,))
            
            pool.close()
            pool.join()
            os.system(pullVersion4DevicePre + device + " push " + dest + os.sep + region + os.sep + "version.txt" + " " + deviceDataPath + "/version.txt")
            
        elif updateFlag == 3:
            checkUpdate4Device(versionRequestMap, dest, region, versionDeviceMap, pullVersion4DevicePre + device, deviceDataPath)
        
        # always change mapdata.db and part_number.bin
        if os.path.exists(dest + os.sep + region + os.sep + CURRENT + os.sep + MAPDATADB):
            os.system(pullVersion4DevicePre + device + " push " + dest + os.sep + region + os.sep + CURRENT + os.sep + MAPDATADB + " " + deviceDataPath + "/" + MAPDATADB)
                
        if os.path.exists(dest + os.sep + region + os.sep + CURRENT + os.sep + PARTNUMBER):
            os.system(pullVersion4DevicePre + device + " push " + dest + os.sep + region + os.sep + CURRENT + os.sep + PARTNUMBER + " " + deviceDataPath + "/" + PARTNUMBER) 
        print "Finished!"
    
    if os.path.exists(dest + os.sep + region):
        shutil.rmtree(dest + os.sep + region)

    os.system("taskkill /f /im adb.exe")
    os.system("adb connect 192.168.1.100")

    #reconnect device after adb kill in above step
    #if "." in deviceArray[0]:
    #    os.system("taskkill /f /im adb.exe")
    #    os.system("adb connect 192.168.1.100")
def checkUpdate4Device(versionRequestMap, dest, region, versionDeviceMap, deviceName, deviceDataPath):
    pool = Pool(processes=6)
    for key in versionRequestMap.keys():
        if key in versionDeviceMap.keys():
            if versionRequestMap[key] != versionDeviceMap[key]:
                os.system(deviceName + " shell rm -fr " + deviceDataPath + "/" + key)
                if key == MTILES:
                    # NGx data structure is different, it map/tiles
                    cmd = deviceName + " push " + dest + os.sep + region + os.sep + CURRENT + os.sep + MMAP + " " + deviceDataPath + "/" + MMAP    
                else:
                    cmd = deviceName + " push " + dest + os.sep + region + os.sep + CURRENT + os.sep + key + " " + deviceDataPath + "/" + key
                
                pool.apply_async(os.system, (cmd,))
            else:
                continue
    pool.close()
    pool.join()
    os.system(deviceName + " push " + dest + os.sep + region + os.sep + "version.txt" + " " + deviceDataPath + "/version.txt")

def urlcallback(a,b,c):
    prec=100.0*a*b/c
    if 100 < prec:
        prec=100
    print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    print "Downloading:%.2f%%"%(prec,)
    
def getData4UrlVersion(csvFile):
    versionMap = {}
    csvReader = csv.reader(open(csvFile, 'rb'))
    for row in csvReader:
        parameterStr = ','.join(row)     
        parameters = parameterStr.split(',')
        if "URL" == parameters[1]:
            continue
        
        versionMap[parameters[0]] = parameters[1]
    return versionMap
    
def downloadPackage(strUrl, dest, module, timeout=120):
    print strUrl, dest, region, module
    print "--- prepare to download data for " + module
    if not os.path.exists(dest):
        os.makedirs(dest)
    
    socket.setdefaulttimeout(timeout)
    component = strUrl.split("/")[-1]
    componentTar = os.path.splitext(component)[-2]
    try:
        urllib.urlretrieve(strUrl, dest + os.sep + component)
    except socket.error:
        errno, errstr = sys.exc_info()[:2]
        if errno == socket.timeout:
            print "There was a timeout"
            print "--- Download failed ---"
            print "--- Clean the broken data ---"
            os.remove(dest + os.sep + component)
            print "--- Start to retry downloading ---"
            urllib.urlretrieve(strUrl, dest + os.sep + component)
        else:
            print "There was other socket error!"
    except Exception, e:
        print "Other exceptions!", e
        print "--- Download failed ---"
        print "--- Clean the broken data ---"
        os.remove(dest + os.sep + component)
        print "--- Start to retry downloading ---"
        urllib.urlretrieve(strUrl, dest + os.sep + component)
    
    os.system("7z x -o" + dest + " " +  dest + os.sep + component)
    os.system("7z x -o" + dest + " " + dest + os.sep + componentTar)

    print "begin to delete"  
    if(os.path.exists(dest + os.sep + component)):
        print "begin -- delete----------"
        try:
            print "delete " + component
            os.remove(dest + os.sep + component)
            if(os.path.isfile(dest + os.sep + 'md5manifest.txt')):
                os.remove(dest + os.sep + 'md5manifest.txt')
        except Exception, e:
            print "-----------exception------------------"
            print e
    
    if(os.path.isfile(dest + os.sep + component + '.md5')):
        os.remove(dest + os.sep + component + '.md5')
                 
    if(os.path.exists(dest + os.sep + componentTar)):
        try:
            print "delete " + componentTar
            os.remove(dest + os.sep + componentTar)
        except Exception, e:
            print "-----------exception------------------"
            print e

def writeVersion(csvFile, dest, region, url):
    fileObj = open(dest + os.sep + region + os.sep + "version.txt", "w")
    fileObj.write(FULLPATH + "," + url + "\n")
    fileObj.write(MREGION + "," + region + "\n")
    versionMap = getData4UrlVersion(csvFile)
    for key, value in versionMap.iteritems():
        if key == "URL":
            continue
        fileObj.write(key + "," + value + "\n")
    fileObj.close()
    
def usage():
    print '\n\nDownloadData4Url.py usage:'
    print "e.g.: python DownloadData4Url.py --region=na --package=http://d-tempo-01.telenav.com/ec_latest_builds/DENALI_CLIENT/Here_14Q3_NA_20150309/Denali_Here_14Q3_NA_20150309.tar.gz --dest=."
    print "e.g.: python DownloadData4Url.py -r na -p http://d-tempo-01.telenav.com/ec_latest_builds/DENALI_CLIENT/Here_14Q3_NA_20150309/Denali_Here_14Q3_NA_20150309.tar.gz -d ."
    print "e.g.: python DownloadData4Url.py --help"
    
if __name__ == "__main__":
    
    region = "na"
    package = ""
    dest = ""
    
    try:
        shortargs = "hr:p:d:"
        longargs = ["help", "region=", "package=", "dest="]
        opts, args = getopt.getopt(sys.argv[1:], shortargs, longargs)
    except getopt.GetoptError, err:
        print str(err)
        usage()
        sys.exit(0)
    
    for o, a in opts:
        if o in ("-h", "--help"):
            usage()
            sys.exit(0)
        elif o in ("-r", "--region"):
            region = a
        elif o in ("-p", "--package"):
            package = a
        elif o in ("-d", "--dest"):
            dest = a
        else:
            print "unhandled option"
            sys.exit(0)
    checkUpdate(package, dest, region)
    os.system("taskkill /f /im adb.exe")
    sys.exit()