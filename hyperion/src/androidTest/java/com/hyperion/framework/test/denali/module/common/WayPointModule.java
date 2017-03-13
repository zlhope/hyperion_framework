package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;

import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

import java.util.HashMap;


public class WayPointModule extends Module {
    public WayPointModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    /**
     * ******************************************************
     * Flow: Way point add detail page -> Navigation
     ********************************************************
     **/
    public void addWayPoint() throws HFObjectNotFoundException {
        getWPAndNewDest(1);
    }

    /**
     * ******************************************************
     * Flow: Way point add detail page -> Navigation
     ********************************************************
     **/
    public void addNewDest() throws HFObjectNotFoundException {
        getWPAndNewDest(2);
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Add way point -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addWayPointBySearch(String keyword , int type , int index) throws HFObjectNotFoundException {
        moduleDataMap = moduleHandler.oneboxSearchModule.getDetailBySearch(keyword, type, index);
        getWPAndNewDest(1);
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Add way point -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addWayPointBySearchNearDest(String keyword , int type , int index) throws HFObjectNotFoundException {
        moduleDataMap = searchNearDest(keyword, type, index);
        getWPAndNewDest(1);
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Add new dest -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addNewDestBySearchNearDest(String keyword , int type , int index) throws HFObjectNotFoundException {
        moduleDataMap = searchNearDest(keyword, type, index);
        getWPAndNewDest(2);
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Add way point
     ********************************************************
     **/
    private HashMap<String, String> searchNearDest(String keyword , int type , int index) throws HFObjectNotFoundException {
        int ret = moduleHandler.oneboxSearchModule.getResultListBySearch(keyword, type);
        if(ret == 0){
            waitNearDestListLoadReady();
            moduleDataMap = moduleHandler.oneboxSearchModule.getDetail(index);
        }else if(ret == 1)
        {
            moduleDataMap = getInfoInDetailPage();
        }else{
            throw new HFObjectNotFoundException("SEARCH_NEAR_DEST_FAILED");
        }
        return moduleDataMap;
    }

    private boolean waitNearDestListLoadReady() throws HFObjectNotFoundException {
        String poiName = getText(resultList.resultName);
        if(!clickIfExist(resultList.nearDest)){
            throw new HFObjectNotFoundException("CLICK_NEAR_DEST_FAILED");
        }
        String tmpStr = "";
        for(int i=0; i<5; i++){
            try {
                tmpStr = getText(resultList.resultName);
            }catch (Exception e){
                HFLog.logMessage(e.getStackTrace());
            }
            if((!tmpStr.equals(""))&&(!poiName.equals(tmpStr))){
                return true;
            }
            SystemClock.sleep(HFVariables.WAIT_SHORT);
        }
        return false;
    }

    /**
     * ******************************************************
     * type = 1: Set address as wp
     * type = 2: Set address as new dest
     * Flow: WP poi detail -> Navigation
     ********************************************************
     **/
    private void getWPAndNewDest(int type) throws HFObjectNotFoundException {
        waitForElement(resultDetail.wpETE, HFVariables.WAIT_LONG);
        if(type == 1){
            click(resultDetail.wpETE);
            HFLog.logMessage("Add WP: ["+ moduleDataMap.get("poiName") +"]");
        }else{
            click(resultDetail.newETE);
            HFLog.logMessage("Add new dest: [" + moduleDataMap.get("poiName") + "]");
        }
        waitForToastMessage(2);
        if (!navigation.checkScreen()) {
            throw new HFObjectNotFoundException("GET_NAVIGATION_FAILED");
        }
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Add way point -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addWayPointByFaves(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Add way point -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addWayPointByRecents(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Add way point -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addWayPointByRGC() throws HFObjectNotFoundException {
        return moduleDataMap;
    }
}
