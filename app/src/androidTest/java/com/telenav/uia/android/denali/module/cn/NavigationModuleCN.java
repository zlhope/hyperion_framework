package com.telenav.uia.android.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.module.common.NavigationModule;


public class NavigationModuleCN extends NavigationModule {
    public NavigationModuleCN(TnUIADevice tud)
    {
        super(tud);
    }

    public Boolean goToNavigation1() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("CN Navigation1!");
        return true;
    }

    public Boolean goToNavigation3() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("CN Navigation3!");
        return true;
    }
}
