package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;

import java.util.HashMap;


public class FavoriteModule extends Module {
    public FavoriteModule(CaseBase caseBase)
    {
        super(caseBase);
    }
    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Search detail page -> FreeMap
     ********************************************************
     **/
    public HashMap<String, String> addFavesBySearch(String keyword , int type , int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Dest pin -> Search detail page -> FreeMap
     ********************************************************
     **/
    public HashMap<String, String> addFavesByRGC() throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Recent -> Search detail page -> FreeMap
     ********************************************************
     **/
    public HashMap<String, String> addFavesByRecents(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Faves -> FreeMap
     ********************************************************
     **/
    public Boolean deleteAllFaves() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Faves -> Search detail page -> FreeMap
     ********************************************************
     **/
    public HashMap<String, String> unFavesBySno(int index) throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Faves
     ********************************************************
     **/
    public Boolean getFavesPage() throws HFObjectNotFoundException {
        return true;
    }
}
