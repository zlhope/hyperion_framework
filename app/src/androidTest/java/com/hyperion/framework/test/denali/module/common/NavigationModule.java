package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;


public class NavigationModule extends Module {

    public Boolean goToNavigation1() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("Navigation1!");
        return true;
    }

    public Boolean goToNavigation2() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("Navigation2!");
        return true;
    }
}
