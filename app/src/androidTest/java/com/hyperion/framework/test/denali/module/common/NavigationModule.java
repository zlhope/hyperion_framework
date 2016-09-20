package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;
import java.util.HashMap;


public class NavigationModule extends Module {

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> getNavigationBySearch(String keyword , int type , int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> getNavigationByFaves(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> getNavigationByRecents(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> getNavigationByRGC() throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> FreeMap
     ********************************************************
     **/
    public Boolean endNavigation() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> RouteList page
     ********************************************************
     **/
    public Boolean goToRouteList() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> RouteList edit page
     ********************************************************
     **/
    public Boolean goToRouteListEdit() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Navigation -> RouteList edit page
     ********************************************************
     **/
    public String goToRouteListEditAndDelete(int i) throws HFObjectNotFoundException {
        return "";
    }
}
