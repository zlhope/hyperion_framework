package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;

import java.util.ArrayList;


public class SettingModule extends Module {

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option
     ********************************************************
     **/
    public Boolean goToMapOption() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setMapMode() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setRouteType() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean clearHistory() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean clearRecents() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setAlert() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setRouteAvoid() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean setMapColor() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public ArrayList<String> setHomeWork(String home, String work) throws HFObjectNotFoundException {
        return moduleDataList;
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public ArrayList<String> setHomeWorkByCategory(String category1, String category2) throws HFObjectNotFoundException {
        return moduleDataList;
    }

    /**
     * ******************************************************
     * type = 1: Clear home and work
     * type = 2: Clear home
     * type = 3: Clear work
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    public Boolean clearHomeWork(int type) throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Map option -> Dest edit
     ********************************************************
     **/
    public Boolean goToDestEdit() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Map option -> Dest edit -> Navigation
     ********************************************************
     **/
    public Boolean moveDest(int type, String keyword) throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> Map option -> Dest edit -> Navigation
     ********************************************************
     **/
    public Boolean deleteDest(int index, String keyword) throws HFObjectNotFoundException {
        return true;
    }
}
