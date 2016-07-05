package com.telenav.uia.android.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIALog;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;
import com.telenav.uia.android.denali.module.ModuleRoot;



public class NavigationModule extends ModuleRoot{

    public NavigationModule(TnUIADevice tud)
    {
        super(tud);
    }

    public Boolean goToNavigation1() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("Navigation1!");
        return true;
    }

    public Boolean goToNavigation2() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("Navigation2!");
        return true;
    }
}
