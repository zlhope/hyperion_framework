package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;

import java.util.HashMap;


public class WayPointModule extends Module {

    /**
     * ******************************************************
     * Flow: Way point add detail page -> Navigation
     ********************************************************
     **/
    public Boolean addWayPoint() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Way point add detail page -> Navigation
     ********************************************************
     **/
    public Boolean addNewDest() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Add way point -> Navigation
     ********************************************************
     **/
    public HashMap<String, String> addWayPointBySearch(String keyword , int type , int index) throws HFObjectNotFoundException {
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
        return moduleDataMap;
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
