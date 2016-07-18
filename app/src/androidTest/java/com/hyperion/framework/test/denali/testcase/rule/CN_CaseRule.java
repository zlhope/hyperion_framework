package com.hyperion.framework.test.denali.testcase.rule;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.test.denali.module.cn.CN_NavigationModule;
import com.hyperion.framework.test.denali.module.cn.EXT_SettingModule;

public class CN_CaseRule extends CaseRule {
    public CN_NavigationModule navigationModule;
    public EXT_SettingModule settingModuleExt;

    @Override
    public void initModule()
    {
        navigationModule = new CN_NavigationModule();
        settingModuleExt = new EXT_SettingModule();
    }
}
