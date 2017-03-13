package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;

import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.TestData;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;


public class FreeMapModule extends Module {
    public FreeMapModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option
     ********************************************************
     **/
    public void getMapOption() throws HFObjectNotFoundException {
        for (int i = 0; i<30; i++){
            clickIfExist(freeMap.mapOption , HFVariables.WAIT_ONE_SECOND);
            if(mapOption.checkScreen()){
                return;
            }else
            {
                HFLog.logMessage("Get map option failed, try:"+(i+1));
            }
        }
        throw new HFObjectNotFoundException("GO_TO_MAP_OPTION_FAILED");
    }

    /**
     * ******************************************************
     * Flow: FreeMap/Navigation -> Onebox page
     ********************************************************
     **/
    public Boolean getOnebox() throws HFObjectNotFoundException {
        for(int i = 0; i<10; i++){
            clickIfExist(oneBoxSearch.oneBox, HFVariables.WAIT_ONE_SECOND);
            clickIfExist(oneBoxSearch.sideBarButton, HFVariables.WAIT_ONE_SECOND);
            if(oneBoxSearch.checkScreen()) {
                return true;
            }else{
                if(i>5) {
                    HFLog.logMessage("Go to onebox failed, try:" + (i + 1));
                }
            }
        }
        throw new HFObjectNotFoundException("GOTO_ONEBOX_FAILED");
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Favorite
     ********************************************************
     **/
    public Boolean getFavorites() throws HFObjectNotFoundException {
        getOnebox();
        moduleHandler.oneboxSearchModule.tapCategory(TestData.Favorite);
        if(favorite.checkScreen()) {
            return true;
        }else{
            throw new HFObjectNotFoundException("GET_FAVORITE_FAILED");
        }

    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Recents
     ********************************************************
     **/
    public Boolean getRecents() throws HFObjectNotFoundException {
        getOnebox();
        moduleHandler.oneboxSearchModule.tapCategory(TestData.Recent);
        if(recents.checkScreen()) {
            return true;
        }else{
            throw new HFObjectNotFoundException("GET_RECENTS_FAILED");
        }

    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Set Home/Work -> FreeMap
     ********************************************************
     **/
    public void setWorkHomeAtFreeMap(String type, String keyword) throws HFObjectNotFoundException {
        tapVehicleMenu(type);
        if(waitForElement(oneBoxSearch.oneBox, HFVariables.WAIT_LONG)){
            moduleHandler.oneboxSearchModule.getResultListByOnebox(keyword);
            if(objExist(oneBoxSearch.resultItem)){
                listObjsClick(oneBoxSearch.resultItem, 1);
            }
            if(clickIfExist(oneBoxSearch.done2, HFVariables.WAIT_LONG))
            {
                if(freeMap.checkScreen()){
                    return;
                }
            }
        }
        throw new HFObjectNotFoundException("SET_HOME_WORK_AT_FREE_MAP_FAILED");
    }

    /**
     * **********************************************************************
     * Flow: FreeMap -> Tap Vehicle Menu -> Home/Work Setting / Navigation
     ************************************************************************
     **/
    public void tapVehicleMenu(String type) throws HFObjectNotFoundException{
        moduleHandler.settingModule.setMapMode(TestData.m2DNorth);
        SystemClock.sleep(3000);
        UiObject2 obj = HFDevice.getDevice().findObject(freeMap.mapPage);
        //Click vehicle icon
        for(int i = 0 ;i<10 ;i++){
            if(objExist(freeMap.mapPage)) {
                obj.swipe(Direction.LEFT, 0.005f, 100);
                click(freeMap.mapPage);
                if(objExist(freeMap.currentStreet, HFVariables.WAIT_ONE_SECOND)){
                    break;
                }else
                {
                    clickIfExist(freeMap.recenter);
                    HFLog.logMessage("Click vehicle button doesn't work, try:" + (i + 1));
                }
            }
        }
        SystemClock.sleep(1000);
        if (type.equals("home")) {
            HFLog.logMessage("Click home menu in free map!");
            HFDevice.getDevice().click(deviceWidth * 50 / 100,
                    deviceHeight * 25 / 100);
        } else {
            HFLog.logMessage("Click work menu in free map!");
            HFDevice.getDevice().click(deviceWidth * 50 / 100,
                    deviceHeight * 40 / 100);
        }
    }
}
