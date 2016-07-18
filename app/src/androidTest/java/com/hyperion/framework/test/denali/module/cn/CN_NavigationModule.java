package com.hyperion.framework.test.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.common.NavigationModule;


public class CN_NavigationModule extends NavigationModule {

    public Boolean goToNavigation1() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("CN Navigation1!");
        return true;
    }

    public Boolean goToNavigation3() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("CN Navigation3!");
        return true;
    }
}
