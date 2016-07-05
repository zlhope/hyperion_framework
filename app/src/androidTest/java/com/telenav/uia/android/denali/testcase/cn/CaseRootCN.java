package com.telenav.uia.android.denali.testcase.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.telenav.uia.android.denali.module.cn.SettingModuleExt;
import com.telenav.uia.android.denali.testcase.CaseRoot;
import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.module.cn.NavigationModuleCN;

public class CaseRootCN extends CaseRoot {
    public NavigationModuleCN navigationModule;
    public SettingModuleExt settingModuleExt;
    public CaseRootCN() {
        TnUIACommon.REGION = "cn";
        navigationModule=new NavigationModuleCN(tud);
        settingModuleExt=new SettingModuleExt(tud);
    }
}
