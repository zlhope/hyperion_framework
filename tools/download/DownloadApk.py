'''
Created on 2013-11-19

@author: sxma
'''

import urllib
import datetime
import os
import sys
import re

def urlcallback(a,b,c):
    prec=100.0*a*b/c
    if 100 < prec:
        prec=100
    if prec%10==0:
        print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        print "Downloading:%.1f%%"%(prec,)

def download_package(build_url, dest):
    if os.path.exists(dest):
        return
    print "Start downloading from " + build_url + " to " + dest
    urllib.urlretrieve(build_url, dest, urlcallback)
    print "Download finished" 
      
def download_build(build_version):
    try:      
        apk_name = 'scout-android-' + build_version + '-prod-release.apk'   
        build_url = 'http://releaseota.telenav.com/release/android/release/' + build_version + '/scout-android-' + build_version + '-prod-release.apk' 
        download_package(build_url, apk_name)
        return apk_name
    except Exception, e:
        print "Raise exception when you download the file ", e
        sys.exit(1)
        
if __name__ == '__main__':
    pass
#    if len(sys.argv) < 1:
#        print "please input the download url"
#        exit(1)
#    else:
#        build_version = sys.argv[1]   
#    try:  	
#        apk_name = 'scout-android-' + build_version + '-prod-release.apk'	
#        print 'a'
#        build_url = 'http://releaseota.telenav.com/release/android/release/' + build_version + '/scout-android-' + build_version + '-prod-release.apk'
#        download_package(build_url, '../' + apk_name)
#    except Exception, e:
#        print "Raise exception when you download the file ", e
#        sys.exit(1)