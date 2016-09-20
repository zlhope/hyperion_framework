package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;

import java.util.HashMap;


public class RecentsModule extends Module {

    /**
     * ******************************************************
     * Flow: FreeMap -> Recents -> FreeMap
     ********************************************************
     **/
    public Boolean deleteAllRecents() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Recents
     ********************************************************
     **/
    public Boolean goToRecentsPage() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Add a recent ->FreeMap
     ********************************************************
     **/
    public HashMap<String, String> addRecentBySearch(String keyword , int type , int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }
}
