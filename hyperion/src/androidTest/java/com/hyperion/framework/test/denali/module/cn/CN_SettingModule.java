package com.hyperion.framework.test.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;

import com.hyperion.framework.test.denali.module.common.SettingModule;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.CN_TestData;
import com.hyperion.framework.test.denali.testdata.TestData;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;


public class CN_SettingModule extends SettingModule {
    public CN_SettingModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    /**
     * ******************************************************
     * Flow: Navigation/FreeMap -> Map option -> Navigation/FreeMap
     ********************************************************
     **/
    @Override
    public Boolean setSetting(String item, boolean flag) throws HFObjectNotFoundException {
        if(item.equals(TestData.speedCamera)){
            item = CN_TestData.speedCamera;
        }
        moduleHandler.freeMapModule.getMapOption();
        clickIfExist(mapOption.setting);
        enterPrefSetting(item);
        if(item.equals(TestData.clearRecentDest)||item.equals(TestData.clearSearch)){
            clickByDesc(item);
        }else{
            setPref(item, flag);
        }
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        click(mapOption.done);
        return true;
    }
}
