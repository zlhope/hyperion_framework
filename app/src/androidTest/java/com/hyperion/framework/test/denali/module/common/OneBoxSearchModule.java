package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;

import java.util.ArrayList;
import java.util.HashMap;


public class OneBoxSearchModule extends Module {

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailBySearch(String keyword , int type , int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailByFaves(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailByRecents(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailByRGC() throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Search list page
     ********************************************************
     **/
    public int getResultListBySearch(String keyword) throws HFObjectNotFoundException {
        return 0;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search list page
     ********************************************************
     **/
    public int getResultListByAutoSuggestion(String keyword) throws HFObjectNotFoundException {
        return 0;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Auto suggestion page
     ********************************************************
     **/
    public ArrayList<String> getAutoSuggestion(String keyword) throws HFObjectNotFoundException {
        return moduleDataList;
    }
}
