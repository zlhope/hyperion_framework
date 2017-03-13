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

import java.util.ArrayList;
import java.util.HashMap;


public class NavigationModule extends Module {
    public NavigationModule(CaseBase caseBase) {
        super(caseBase);
    }

    /**
     * ******************************************************
     * Flow: POI detail page -> Navigation
     * *******************************************************
     **/
    public void getNavigation() throws HFObjectNotFoundException {
        waitForElement(resultDetail.driveText, HFVariables.WAIT_LONG);
        for(int i = 0; i<5; i++){
            if(clickIfExist(resultDetail.driveText)){
                waitForToastMessage(2);
                if (navigation.checkScreen()) {
                    HFLog.logMessage("Start navigation: [" + moduleDataMap.get("poiName") + "]");
                    return;
                }
            }
            else
            {
                HFLog.logMessage("Start navigation failed, try: " + (i+1));
            }
        }
        throw new HFObjectNotFoundException("GET_NAVIGATION_FAILED");
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Navigation
     * *******************************************************
     **/
    public HashMap<String, String> getNavigationByFaves(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Navigation
     * *******************************************************
     **/
    public HashMap<String, String> getNavigationByRecents(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Navigation
     * *******************************************************
     **/
    public HashMap<String, String> getNavigationByRGC() throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Navigation
     * *******************************************************
     **/
    public HashMap<String, String> getNavigationBySearch(String keyword, int type, int index) throws HFObjectNotFoundException {
        moduleDataMap = moduleHandler.oneboxSearchModule.getDetailBySearch(keyword, type, index);
        getNavigation();
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> FreeMap
     * *******************************************************
     **/
    public Boolean endNavigation() throws HFObjectNotFoundException {
        if (!waitForElement(navigation.endTrip, HFVariables.WAIT_LONG)) {
            throw new HFObjectNotFoundException("END_NAVIGATION_BUTTON_NOT_EXIST");
        }
        return click(navigation.endTrip);
    }


    /**
     * ******************************************************
     * Flow: Navigation -> RouteList page
     * *******************************************************
     **/
    public Boolean getRouteList() throws HFObjectNotFoundException {
        for(int i = 0; i<10; i++){
            clickIfExist(navigation.routeListBtn);
            if(routeList.checkScreen()){
                return true;
            }else
            {
                HFLog.logMessage("Get route list failed, try:" + (i+1));
            }
        }
        throw new HFObjectNotFoundException("GET_ROUTE_LIST_FAILED");
    }

    /**
     * ******************************************************
     * Flow: Navigation -> RouteList edit page
     * *******************************************************
     **/
    public Boolean getRouteListEdit() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> RouteList edit page
     * *******************************************************
     **/
    public String goToRouteListEditAndDelete(int i) throws HFObjectNotFoundException {
        return "";
    }

    /**
     * ******************************************************
     * Input: Audio text count
     * Output: Audio text list
     * *******************************************************
     **/
    public ArrayList<String> getAudioGuidance(int count) throws HFObjectNotFoundException {
        ArrayList<String> results;
        ArrayList<String> finalResults = new ArrayList<>();
        ArrayList<String> finalResultsFormat = new ArrayList<>();
        long start = System.currentTimeMillis();
        Boolean containFlag = false;
        while (true) {
            results = logcatHandler.getLogcatOut(HFVariables.AUDIO_FILER);
            for (String result : results) {
                for (String finalResult : finalResults) {
                    if (finalResult.contains(result.split(HFVariables.AUDIO_FILER3)[0])) {
                        containFlag = true;
                        break;
                    }
                    containFlag = false;
                }
                if (!containFlag) {
                    finalResults.add(result);
                    result = result.split(HFVariables.AUDIO_FILER2)[1].
                            split("\\. ")[0].replace(" ", "");
                    finalResultsFormat.add(result);
                    HFLog.logMessage("***Audio[" + finalResults.size() + "]***: " + result);
                    if (finalResults.size() >= count) {
                        return finalResultsFormat;
                    }
                }
            }
            if ((int) (System.currentTimeMillis() - start) >= 120000) {
                throw new HFObjectNotFoundException("GET_AUDIO_GUIDANCE_TIMEOUT");
            }
        }
    }

    /**
     * ******************************************************
     * Input: Audio text you want to wait
     * Output: When target audio text show return true
     *         or return false when timeout
     * *******************************************************
     **/
    public boolean waitForAudioText(String text) throws HFObjectNotFoundException {
        ArrayList<String> results;
        ArrayList<String> finalResults = new ArrayList<>();
        long start = System.currentTimeMillis();
        Boolean containFlag = false;
        while (true) {
            results = logcatHandler.getLogcatOut(HFVariables.AUDIO_FILER);
            for (String result : results) {
                for (String finalResult : finalResults) {
                    if (finalResult.contains(result.split(HFVariables.AUDIO_FILER3)[0])) {
                        containFlag = true;
                        break;
                    }
                    containFlag = false;
                }
                if (!containFlag) {
                    finalResults.add(result);
                    result = result.split(HFVariables.AUDIO_FILER2)[1].
                            split("\\. ")[0].replace(" ", "");
                    HFLog.logMessage("***Audio[" + finalResults.size() + "]***: " + result);
                    if (result.matches(text)) {
                        return true;
                    }
                }
            }
            if ((int) (System.currentTimeMillis() - start) >= 120000) {
                HFLog.logMessage("Wait for audio text timeout!");
                return false;
            }
        }
    }

    public void clearAudioGuidance() throws HFObjectNotFoundException {
        logcatHandler.clearAudioGuidance();
    }

    public boolean checkRouteStart() throws HFObjectNotFoundException {
        Boolean result = getAudioGuidance(2).size() >= 0;
        SystemClock.sleep(HFVariables.WAIT_SHORT);
        return result;
    }

    public boolean checkETEETAFormat() throws HFObjectNotFoundException {
        return true;
    }

    public boolean compareETERange(int max, int min) throws HFObjectNotFoundException {
        return true;
    }

    public HashMap<String, String> getTextETEETA() throws HFObjectNotFoundException {
        String eta;
        String ete;
        moduleDataMap.clear();
        if(objExist(navigation.ETA)){
            eta = getText(navigation.ETA);
            HFLog.logMessage("ETA: " + eta);
            switchETEETA(2);
            ete =  getText(navigation.ETE);
            HFLog.logMessage("ETE: "+ ete);
        }else if(objExist(navigation.ETE)){
            ete = getText(navigation.ETE);
            HFLog.logMessage("ETE: "+ ete);
            switchETEETA(1);
            eta =  getText(navigation.ETA);
            HFLog.logMessage("ETA: "+ eta);
        }else
        {
            throw new HFObjectNotFoundException("CHECK_ETE_ETA_FAILED");
        }
        moduleDataMap.put("ETE",ete);
        moduleDataMap.put("ETA",eta);
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Navigation
     * type = 1 : ETE->ETA
     * type = 2 : ETA->ETE
     * *******************************************************
     **/
    public void switchETEETA(int type) throws HFObjectNotFoundException{
        for(int i = 0; i<30; i++){
            if(type == 1){
                clickIfExist(navigation.ETE);
                if(objExist(navigation.ETA)){
                    return;
                }
            }
            if(type == 2){
                clickIfExist(navigation.ETA);
                if(objExist(navigation.ETE)){
                    return;
                }
            }
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        }
        HFLog.logMessage("Switch ETE ETA failed!");
    }

    public boolean waitForDestArrival() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation
     ********************************************************
     **/
    public void setZoomLevel(int level) throws HFObjectNotFoundException {
        int currentZoomLevel = getZoomLevel();
        HFLog.logMessage("Current zoom level: " + currentZoomLevel);
        if (level >= currentZoomLevel) {
            for (int j = 1; j <= level - currentZoomLevel; j++) {
                tapZoomInOut(false);
            }
        } else {
            for (int j = 1; j <= currentZoomLevel - level; j++)
                tapZoomInOut(true);
        }
        HFLog.logMessage("Level set to: " + level);
    }

    private void tapZoomInOut(Boolean in) throws HFObjectNotFoundException{
        for(int i = 0; i<10 ;i++){
            if(in){
                if(clickIfExist(navigation.zoomIn)){
                    return;
                }
            }else
            {
                if(clickIfExist(navigation.zoomOut)){
                    return;
                }
            }
            HFLog.logMessage("Tap zoom In/Out failed, try:" + (i+1));
            if(objExist(navigation.junctionView)){
                tapMapOnSplitScreen();
                waitUtilObjDisappear(navigation.junctionView, HFVariables.WAIT_LONG);
            }
        }
    }

    /**
     * ******************************************************
     * Flow: Navigation
     ********************************************************
     **/
    public int getZoomLevel() throws HFObjectNotFoundException {
        int level;
        if(objExist(navigation.zoomLevel)){
            String levelStr = getDesc(navigation.zoomLevel);
            if(Integer.valueOf(levelStr.split("\\.")[1])==0){
                level = Integer.valueOf(levelStr.split("\\.")[0]) - 1;
            }else{
                level = Integer.valueOf(levelStr.split("\\.")[0]);
            }
            HFLog.logMessage("Zoom level: " + level);
            return level;
        }
        throw new HFObjectNotFoundException("GET_ZOOM_LEVEL_FAILED");
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Hwy exit list
     ********************************************************
     **/
    public void getHwyExitList() throws HFObjectNotFoundException {
        if(clickIfExist(navigation.hwyExit, HFVariables.WAIT_LONG * 3)){
            if(waitForElement(hwyExit.exitLabel, HFVariables.WAIT_LONG)){
                return;
            }
        }
        throw new HFObjectNotFoundException("GET_HWY_EXIT_FAILED");
    }
}
