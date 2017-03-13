package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.graphics.Point;
import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;

import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.CN_TestData;
import com.hyperion.framework.test.denali.testdata.TestData;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

import java.util.ArrayList;
import java.util.List;


public class SettingModule extends Module {
    public SettingModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    protected Boolean setPref(String pref, boolean flag) throws HFObjectNotFoundException {
        BySelector item = By.desc(pref);
        if(objExist(item)) {
            UiObject2 box = HFDevice.getDevice().findObject(item).getParent().findObject(setting.checkItemBox);
            if(box == null){
                box = HFDevice.getDevice().findObject(item).getParent().getParent().findObject(setting.checkBox);
            }
            if(box != null){
                if (box.isChecked() ^ flag) {
                    box.click();
                }
                return true;
            }
        }
        throw new HFObjectNotFoundException("SET_PREF_FAILED");
    }

    protected boolean enterPrefSetting(String pref) throws HFObjectNotFoundException{
        if(pref.equals(TestData.fastest)||
                pref.equals(TestData.eco)){
            clickScrollByDesc(TestData.navPref);
            return clickByDesc(TestData.routeType);
        } else if(pref.equals(TestData.highway)||
                pref.equals(TestData.TollRoad)||
                pref.equals(TestData.UnpavedRoad)||
                pref.equals(TestData.Tunnel)||
                pref.equals(TestData.HOVLane)||
                pref.equals(TestData.CountryBorder)||
                pref.equals(TestData.ferry)){
            clickScrollByDesc(TestData.navPref);
            return clickByDesc(TestData.avoidOnRoute);
        }else if (pref.equals(TestData.m3DBuildings) ||
                pref.equals(TestData.m3DLandmarks) ||
                pref.equals(TestData.autoZoom)) {
            return clickScrollByDesc(TestData.mapConfig);
        }else if(pref.equals(CN_TestData.speedCamera)||
                pref.equals(TestData.speedCamera)||
                pref.equals(TestData.roadSafety)){
            return clickScrollByDesc(TestData.alertPref);
        }
        else if(pref.equals(TestData.day)||
                pref.equals(TestData.night)||
                pref.equals(TestData.auto)){
            return clickScrollByDesc(TestData.mapColor);
        }
        return clickScrollByDesc(pref);
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public void setMapMode(String mode) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getMapOption();
        while(!mode.equals(getDesc(mapOption.mapMode))){
            click(mapOption.mapMode);
        }
        if(clickIfExist(mapOption.done)){
            if(freeMap.checkScreen() || navigation.checkScreen()) {
                HFLog.logMessage("Set map mode: [" + mode +"]");
                return;
            }
        }
        throw new HFObjectNotFoundException("FAILED_TO_SHOW_FREE_MAP");
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setSetting(String item, boolean flag) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getMapOption();
        click(mapOption.setting);
        enterPrefSetting(item);
        if(item.equals(TestData.clearRecentDest)||item.equals(TestData.clearSearch)){
            clickByDesc(item);
        }else{
            setPref(item, flag);
        }
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        click(mapOption.done);
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setPOIOnMap(String poi,boolean flag) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getMapOption();
        clickIfExist(mapOption.poiOnMap);
        if(poi.contains(HFVariables.AND)){
            String[] arr = poi.split(HFVariables.AND);
            for (String anArr : arr) {
                BySelector icon = By.desc(anArr);
                if (objIsEnabled(icon) ^ flag) {
                    click(icon);
                }
            }
        }else{
            BySelector icon = By.desc(poi);
            if(objIsEnabled(icon)^flag){
                click(icon);
            }
        }
        click(mapOption.done);

        if(freeMap.checkScreen()) {
            return true;
        }else throw new HFObjectNotFoundException("FAILED_TO_SHOW_FREE_MAP");
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public ArrayList<String> setHomeWork(String type, String addr) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getMapOption();
        clickIfExist(mapOption.setting);
        enterPrefSetting(TestData.homePref);
        if(type.equalsIgnoreCase(TestData.HOME)){
            clickByDesc(TestData.HOME);
        }
        else{
            click(setting.selectLabel);
            clickByDesc(type);
            clickByDesc(TestData.CUSTOM);
        }

        clickIfExist(oneBoxSearch.clearBtn);
        setText(oneBoxSearch.oneBox, addr);
        pressEnter();
        clickIfExist(setting.doneAtMyPlace);
        return moduleDataList;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Map option -> Dest edit -> Navigation
     ********************************************************
     **/
    public void deleteDest(String name) throws HFObjectNotFoundException {
        goToDestEdit();
        int count = listObjsGetChildCount(destEdit.wpListView);
        String destName;
        for (int i = 0; i < count; i++){
            destName = listObjsGetText(destEdit.wpTextView, i);
            HFLog.logMessage("Dest name [" + (i+1) + "]: " + destName);
            if(destName.contains(name)){
                listObjsClick(destEdit.wpDeleteBtn, i);
                click(destEdit.dpButton2);
                backToNavigationFromDestEdit();
                return;
            }
        }
        throw new HFObjectNotFoundException("DELETE_DEST_ITEM_FAILED");
    }

    /**
     * ******************************************************
     * Flow: Dest edit -> Navigation
     ********************************************************
     **/
    public void backToNavigationFromDestEdit() throws HFObjectNotFoundException {
        if(clickIfExist(destEdit.close)){
            waitForToastMessage(2);
            if(navigation.checkScreen()){
                return;
            }
        }
        throw new HFObjectNotFoundException("BACK_TO_FREE_MAP_FAILED");
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Map option -> Dest edit
     ********************************************************
     **/
    public void goToDestEdit() throws HFObjectNotFoundException {
        Boolean enable;
        for(int i = 0; i<10; i++){
            moduleHandler.freeMapModule.getMapOption();
            try{
                enable = objIsEnabled(mapOption.editDestination);
            }catch (Exception e){
                enable = false;
            }
            if(enable){
                click(mapOption.editDestination);
                if(destEdit.checkScreen()){
                    return;
                }
            }else
            {
                HFLog.logMessage("Go to dest edit page failed, try:" + (i + 1));
                clickIfExist(destEdit.close);
            }
        }
        throw new HFObjectNotFoundException("GO_TO_DEST_EDIT_FAILED");
    }

    /**
     * ******************************************************
     * Flow: Dest edit
     ********************************************************
     **/
    public void moveDestItem(String name, Boolean up) throws HFObjectNotFoundException {
        int count = listObjsGetChildCount(destEdit.wpListView);
        String destName;
        List<UiObject2> objs;
        for (int i = 0; i < count; i++){
            destName = listObjsGetText(destEdit.wpTextView, i);
            HFLog.logMessage("Dest name [" + (i + 1) + "]: " + destName);
            if(destName.contains(name)){
                objs = HFDevice.getDevice().findObjects(destEdit.wpItem);
                if(up){
                    HFLog.logMessage("Move up dest : " + destName);
                    int x = objs.get(i).getVisibleBounds().centerX();
                    int y = (objs.get(Math.max(0, (i - 1))).getVisibleBounds().centerY()+
                            objs.get(Math.max(0, (i - 1))).getVisibleBounds().top)/2;
                    objs.get(i).drag(new Point(x,y), 400);
                }else{
                    HFLog.logMessage("Move down dest : " + destName);
                    int x = objs.get(i).getVisibleBounds().centerX();
                    int y = (objs.get(Math.min(objs.size() - 1, (i + 1))).getVisibleBounds().centerY()+
                            objs.get(Math.min(objs.size() - 1, (i + 1))).getVisibleBounds().top)/2;
                    objs.get(i).drag(new Point(x,y), 400);
                }
                return;
            }
        }
        throw new HFObjectNotFoundException("CANNOT_FIND_DEST_WHEN_MOVE");
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Clear Home/Work -> FreeMap
     ********************************************************
     **/
    public void clearHomeWork() throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getMapOption();
        if(clickIfExist(mapOption.setting)) {
            enterPrefSetting(TestData.homePref);
            if(objExist(setting.clearButton)){
                int count = listObjsGetCount(setting.clearButton);
                for (int i = 0; i < count; i++) {
                    click(setting.clearButton);
                }
            }
            click(setting.done2);
            return;
        }
        throw new HFObjectNotFoundException("CLEAR_HOME_WORK_FAILED");
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Clear History -> FreeMap
     ********************************************************
     **/
    public void clearHistory() throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getMapOption();
        if(clickIfExist(mapOption.setting)) {
            enterPrefSetting(TestData.historyPref);
            clickByDesc(TestData.clearSearch);
            waitForToastMessage(1);
            click(setting.close);
            return;
        }
        throw new HFObjectNotFoundException("CLEAR_HISTORY_FAILED");
    }
}
