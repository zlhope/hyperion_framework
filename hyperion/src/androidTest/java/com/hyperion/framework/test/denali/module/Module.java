package com.hyperion.framework.test.denali.module;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;

import com.hyperion.framework.test.denali.action.ScreenSets;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;
import com.hyperion.framework.test.denali.utils.LogcatUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class Module extends ScreenSets {
    protected HashMap<String, String> moduleDataMap = new HashMap<>();
    protected ArrayList<String> moduleDataList = new ArrayList<>();
    protected CaseBase moduleHandler;
    protected LogcatUtil logcatHandler;
    protected int deviceWidth;
    protected int deviceHeight;

    public Module(CaseBase caseBase)
    {
        moduleHandler = caseBase;
        logcatHandler = new LogcatUtil();
        deviceWidth = HFDevice.getDevice().getDisplayWidth();
        deviceHeight = HFDevice.getDevice().getDisplayHeight();
    }

    /**
     * *************************************************************
     * Param :
     * {
     *  "origin": origin,
     *  "gps": HFVariables.ALONG_ROUTE_GPS|DEVICE_GPS|KML_GPS
     *  "autoResume: "false"|"true"
     * }
     * *************************************************************
     **/
    public void initiateApp(HashMap<String, String> param) throws HFObjectNotFoundException {
        enterSecretPage();
        configSecretOption(param);
        if(!launchAppAndCheck()){
            throw new HFObjectNotFoundException("INIT_APP_FAILED");
        }
        if(!HFVariables.IS_FIRST_RUN_CLOCK){
            HFVariables.IS_FIRST_RUN = false;
        }else{
            HFVariables.IS_FIRST_RUN_CLOCK = false;
        }
        moduleHandler.navigationModule.clearAudioGuidance();
    }

    public void initiateApp(String origin) throws HFObjectNotFoundException {
        HashMap<String, String> param = new HashMap<>();
        param.put("origin", origin);
        initiateApp(param);
    }

    private Boolean launchAppAndCheck() throws HFObjectNotFoundException {
        hfa.restartApp();
        checkAppIfLaunchOK();
        return waitForFreeMap();
    }

    /**
     * *************************************************************
     * Return :
     * {
     *  "poiName": poiName,
     *  "address": address
     *  "city: city
     * }
     * *************************************************************
     **/
    protected HashMap<String, String> getInfoInDetailPage() throws HFObjectNotFoundException {
        HashMap<String, String> dataMap = new HashMap<>();
        try {
            moduleDataMap.clear();

            String poiName = getTextIfExist(resultDetail.entityName);
            String address = getTextIfExist(resultDetail.address);
            String city = getTextIfExist(resultDetail.city);
            dataMap.put("poiName", poiName);
            dataMap.put("address", address);
            dataMap.put("city", city);
        }catch (Exception e)
        {
            HFLog.logMessage("Get info in detail page failed!");
        }
        return dataMap;
    }

    public void clearDenaliAppData() throws HFObjectNotFoundException {
        try{
            hfa.clearAppData();
        }catch (Exception e){
            HFLog.logMessage(e.getStackTrace());
            HFLog.logMessage("Clear app data failed!");
        }finally {
            HFVariables.IS_FIRST_RUN = true;
        }
    }

    public Boolean waitForFreeMap() throws HFObjectNotFoundException {
        for (int i = 0; i < 30; i++) {
            if (objExist(freeMap.mapPage)) {
                if(getDesc(freeMap.mapPage).equals("FreeMap")) {
                    return true;
                }
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }

    private Boolean checkAppIfLaunchOK() throws HFObjectNotFoundException{
        int timeout = HFVariables.WAIT_APP_TIMEOUT;
        long startTime = System.currentTimeMillis();
        while(true){
            if(objExist(freeMap.toastMessage, HFVariables.WAIT_ONE_SECOND / 2)){
                HFDevice.getDevice().click((deviceWidth * 50 / 100),
                        (deviceHeight * 50 / 100));
            }
            if(objExist(freeMap.sdCardPopup, HFVariables.WAIT_ONE_SECOND / 5)){
                if(clearTextIfExist(freeMap.OK)) {
                    HFLog.logMessage("Click SD card popup!");
                }else if(clearTextIfExist(freeMap.NO)){
                    HFLog.logMessage("Click Subscription popup!");
                }
            }
            if(objExist(freeMap.popup, HFVariables.WAIT_ONE_SECOND / 5)){
                //to handle the unexpected system popup
                HFLog.logMessage("Click system popup!");
                clickIfExist(freeMap.button1);
            }
            if(objExist(freeMap.autoUpdate, HFVariables.WAIT_ONE_SECOND / 2)
                    && objIsChecked(freeMap.autoUpdate)){
                HFLog.logMessage("Click auto update checkbox!");
                click(freeMap.autoUpdate);
                click(freeMap.dpButton1);
            }
            if(objExist(freeMap.accept, HFVariables.WAIT_ONE_SECOND / 2)){
                HFLog.logMessage("Click FTUE screen!");
                acceptTerm();
            }
            if(objExist(freeMap.mapOption, HFVariables.WAIT_SHORT)){
                return true;
            }
            long endTime = System.currentTimeMillis();
            if(timeout<(endTime - startTime))
            {
                if(HFVariables.RETRY_COUNT > 0){
                    HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT - 1;
                    HFLog.logMessage("Start App failed, try:" + (HFVariables.RETRY_COUNT));
                    SystemClock.sleep(HFVariables.WAIT_LONG * 2);
                    return launchAppAndCheck();
                }
                else
                {
                    HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT_STORE;
                    HFVariables.IS_FIRST_RUN = true;
                    throw new HFObjectNotFoundException("START_UP_FAILED");
                }
            }
        }
    }

    private void acceptTerm()throws HFObjectNotFoundException{
        clickIfExist(freeMap.TAC);
        clickIfExist(freeMap.Privacy);
        clickIfExist(freeMap.option);
        clickIfExist(freeMap.accept);
        for(int i = 0; i<3 ;i++){
            clickIfExist(freeMap.FTUEArrow);
        }
        clickIfExist(freeMap.predictNavOff);
    }

    private Boolean enterSecretPage() throws HFObjectNotFoundException{
        String cmd = "am start -S " + HFVariables.PACKAGE_NAME +
                HFVariables.SECRET_ACTIVITY;
        HFDevice.suExecute(cmd);
        if(!waitForElement(secret.secretScreenIndicator, HFVariables.WAIT_LONG * 6)){
            HFLog.logMessage("Open Secret Page failed!");
            if(clickIfExist(secret.confirmBtn)){
                HFLog.logMessage("Seems there is a alert, click OK button!");
            }
            pressBack();
            pressHome();
            if(HFVariables.RETRY_COUNT > 0){
                HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT - 1;
                return enterSecretPage();
            }
            else
            {
                HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT_STORE;
                throw new HFObjectNotFoundException("START_SECRET_PAGE_FAILED");
            }
        }
        return true;
    }

    private void configSecretOption(HashMap<String, String> param) throws HFObjectNotFoundException{
        if (HFVariables.IS_FIRST_RUN) {
            setSecretSelectItem("Current Region", HFVariables.REGION.toLowerCase());
            updateDataPath(android.os.Build.MODEL);
        }
        if(param.containsKey("origin")){
            if(!HFVariables.IS_FIRST_RUN){
                //Scroll to speed up configuration
                scrollUp(By.res("android:id/list"), 5200);
                if(!objExist(secret.defaultLocation, HFVariables.WAIT_ONE_SECOND)){
                    scrollDown(By.res("android:id/list"), 5500);
                    SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
                    scrollUp(By.res("android:id/list"), 4000);
                }
            }
            setSecretEditItem("DefaultLocation", param.get("origin"));
        }
        if(param.containsKey("gps")){
            try {
                setSecretSelectItem("GPS Config", param.get("gps"));
            }catch (Exception e){
                HFLog.logMessage(e.getStackTrace());
                HFLog.logMessage("Set gps config failed!");
            }
            finally {
                HFVariables.IS_FIRST_RUN = true;
                HFVariables.IS_FIRST_RUN_CLOCK = true;
            }
        }else if(HFVariables.IS_FIRST_RUN){
            setSecretSelectItem("GPS Config", HFVariables.ALONG_ROUTE_GPS);
            setSecretEditItem("Mock Speed (m/s)", "25");
        }
        if(param.containsKey("autoResume")){
            try {
                setSecretSelectItem("Enable Resume Trip", param.get("autoResume"));
            }catch (Exception e){
                HFLog.logMessage(e.getStackTrace());
                HFLog.logMessage("Set enable resume trip failed!");
            }
            finally {
                HFVariables.IS_FIRST_RUN = true;
                HFVariables.IS_FIRST_RUN_CLOCK = true;
            }
        }else if(HFVariables.IS_FIRST_RUN){
            setSecretSelectItem("Enable Resume Trip", "false");
        }
        if (HFVariables.IS_FIRST_RUN) {
            if (android.os.Build.MODEL.contains(HFVariables.MODEL_GM)) {
                setSecretSelectItem("Disable SDCard Verification", "true");
            }
            if (HFVariables.REGION.equalsIgnoreCase("cn")) {
                setSecretSelectItem("Enable Use Lat and Lon search for CN only", "true");
            }
        }
    }

    private UiObject2 getItemSummaryView(String title) throws HFObjectNotFoundException{
        try {
            UiObject2 obj = HFDevice.getDevice().findObject(By.text(title));
            return obj.getParent().findObject(secret.summary);
        }catch (Exception e){
                throw new HFObjectNotFoundException("FIND_TITLE_IN_SECRET_FAILED");
        }
    }

    private UiObject2 getItemSummaryView(BySelector selector) throws HFObjectNotFoundException{
        try {
            UiObject2 obj = HFDevice.getDevice().findObject(selector);
            return obj.getParent().findObject(secret.summary);
        }catch (Exception e){
            throw new HFObjectNotFoundException("FIND_TITLE_IN_SECRET_FAILED");
        }
    }

    private boolean clickSecretPageItem(String title, String value) throws HFObjectNotFoundException{
        UiObject obj = getSecretPageItemByText(title);
        try {
            if(obj.getText().equals(value)){
                return true;
            }
            obj.click();
            return false;
        }catch (Exception e){
            throw new HFObjectNotFoundException("CLICK_SECRET_PAGE_ITEM_FAILED");
        }
    }

    private void setSecretSelectItem(String title, String value) throws HFObjectNotFoundException{
        if(clickSecretPageItem(title, value)){
            return;
        }
        if(!waitForElement(secret.popup, HFVariables.WAIT_SHORT)){
            throw new HFObjectNotFoundException("SET_SECRET_SELECT_ITEM_FAILED");
        }
        if(!clickIfExist(value)){
            throw new HFObjectNotFoundException("CANNOT_FIND_ITEM_IN_SELECT_DIALOG");
        }
        if(!waitForElement(secret.secretScreenIndicator, HFVariables.WAIT_LONG*2)){
            throw new HFObjectNotFoundException("BACK_TO_SECRET_PAGE_FAILED");
        }
    }

    private void setSecretEditItem(String title, String value) throws HFObjectNotFoundException{
        if(clickSecretPageItem(title, value)){
            return;
        }
        if(!waitForElement(secret.editBox, HFVariables.WAIT_SHORT))
        {
            throw new HFObjectNotFoundException("SET_SECRET_EDIT_ITEM_FAILED");
        }
        clearTextIfExist(secret.editBox);
        setTextIfExist(secret.editBox, value);
        pressEnter();
        if(!clickIfExist(secret.OK)){
            throw new HFObjectNotFoundException("SAVE_SECRET_EDIT_ITEM_FAILED");
        }
        if(!waitForElement(secret.secretScreenIndicator, HFVariables.WAIT_LONG * 2)){
            throw new HFObjectNotFoundException("BACK_TO_SECRET_PAGE_FAILED");
        }
    }

    private void updateDataPath(String str) throws HFObjectNotFoundException{
        String dataPath;
        if(str.contains(HFVariables.MODEL_GM)){
            dataPath = HFVariables.GM_DATA_PATH;
        }
        else if(str.contains("LG")){
            dataPath = HFVariables.LG_DATA_PATH;
        }
        else{
            dataPath = HFVariables.TABLET_DATA_PATH;
        }
        setSecretEditItem("Map Data Path", dataPath);
    }

    public static void checkCaseTimeout() throws HFObjectNotFoundException {
        HFVariables.TIMEOUT_CHECK_END=System.currentTimeMillis();
        int runningTime = (int)(HFVariables.TIMEOUT_CHECK_END -
                HFVariables.TIMEOUT_CHECK_START);
        if(runningTime > 4*60*1000) {
            HFLog.logMessage("Warning: Run time " + runningTime);
        }
        if(runningTime > 5*60*1000){
            throw new HFObjectNotFoundException("TEST_CASE_TIMEOUT");
        }
    }

    /**
     * ******************************************************
     * type = 1: Search progress bar
     * type = 2: Poi detail drive button progress bar
     ********************************************************
     **/
    public void waitForProgressBar(int type) throws HFObjectNotFoundException{
        BySelector selector = resultList.progressIcon;
        if (type == 1){
            selector = resultList.progressIcon;
        }else if(type == 2)
        {
            selector = resultDetail.progressBar;
        }
        for(int i = 0; i<120 ; i++){
            if(!objExist(selector, HFVariables.WAIT_ONE_SECOND)){
                return;
            }
            else
            {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        HFLog.logMessage("Wait for progress bar timeout!");
    }

    public void waitForToastMessage(int count) throws HFObjectNotFoundException{
        Boolean flag;
        for (int i = 0; i < count ; i++){
            flag = waitForElement(navigation.toastMessage ,HFVariables.WAIT_MIDDLE);
            HFDevice.getDevice().click((deviceWidth * 50 / 100),
                    (deviceHeight * 50 / 100));
            waitUtilObjDisappear(navigation.toastMessage ,HFVariables.WAIT_MIDDLE);
            if(!flag){
                return;
            }
        }
    }

    public void tapMapOnSplitScreen() throws HFObjectNotFoundException{
        if(objExist(freeMap.mapPage)){
            HFDevice.getDevice().click((deviceWidth * 75 / 100),
                    (deviceHeight * 50 / 100));
        }else
        {
            throw new HFObjectNotFoundException("TAB_MAP_SPLIT_SCREEN_FAILED");
        }
    }

    public float convertToM(String distance){
        Float distanceValue = Float.valueOf(distance.split(" ")[0]);
        String unit = distance.split(" ")[1];
        switch (unit){
            case "mi":
                return (float) (distanceValue * 1609.344);
            case "ft":
                return (float) (distanceValue * 0.3048);
            case "m":
                return distanceValue;
            case "km":
                return distanceValue * 1000;
            case "米":
                return distanceValue;
            case "千米":
                return distanceValue * 1000;
            case "公里":
                return distanceValue * 1000;
            default:
                return distanceValue;
        }
    }

    public int getFeetNumber(String str) throws HFObjectNotFoundException {
        String unit, value;
        unit = str.split(" ")[1];
        value = str.split(" ")[0];
        switch (unit){
            case "公里":
                return  (int) (Float.valueOf(value).intValue() * 3.28 * 1000);
            case "千米":
                return  (int) (Float.valueOf(value).intValue() * 3.28 * 1000);
            case "米":
                return  (int) (Float.valueOf(value).intValue() * 3.28);
            case "m":
                return  (int) (Float.valueOf(value).intValue() * 3.28);
            case "km":
                return  (int) (Float.valueOf(value).intValue() * 3.28 * 1000);
            case "ft":
                return  Float.valueOf(value).intValue();
            case "mi":
                return  (int) (Float.valueOf(value) * 5280);
            default:
                throw new HFObjectNotFoundException("GET_FEET_NUMBER_FAILED");
        }
    }
}
