package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;

import java.util.HashMap;


public class RoutePlannerModule extends Module {

    /**
     * ******************************************************
     * Flow: Search detail page -> Route planner
     ********************************************************
     **/
    public Boolean goToRoutePlanner() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Search detail page -> Route planner
     ********************************************************
     **/
    public Boolean getNavigationFromRoutePlanner() throws HFObjectNotFoundException {
        return true;
    }
}
