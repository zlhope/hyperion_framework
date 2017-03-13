package com.hyperion.framework.test.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;

import com.hyperion.framework.test.denali.module.common.NavigationModule;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.CN_TestData;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

import java.util.HashMap;


public class CN_NavigationModule extends NavigationModule {
    public CN_NavigationModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    @Override
    public Boolean endNavigation() throws HFObjectNotFoundException {
        if(!waitForElement(navigation.endTripIcon, HFVariables.WAIT_LONG))
        {
            throw new HFObjectNotFoundException("CN_END_NAVIGATION_BUTTON_NOT_EXIST");
        }
        return click(navigation.endTripIcon);
    }

    /**
     * ******************************************************
     * Return: {"ETE": ETE , "ETA": ETA}
     * *******************************************************
     **/
    @Override
    public boolean checkETEETAFormat() throws HFObjectNotFoundException {
        HashMap<String, String> data = getTextETEETA();
        return data.get("ETA").matches(CN_TestData.ETA_REG) &&
                data.get("ETE").matches(CN_TestData.ETE_REG);
    }

    @Override
    public boolean compareETERange(int max, int min) throws HFObjectNotFoundException {
        String ete = getTextETEETA().get("ETE");
        int totalMin;
        if(ete.contains("小时")){
            totalMin = Integer.parseInt(ete.split("小时")[0])*60;
            if(ete.contains("分钟")){
                totalMin = totalMin +
                        Integer.parseInt(ete.split("小时")[1].replace("分钟",""));
            }
        }else
        {
            totalMin = Integer.parseInt(ete.split("分钟")[0]);
        }
        HFLog.logMessage("Start checking ETE range: [" + min + "," + max + "], actual time: " + totalMin);
        return totalMin >= min && totalMin <= max;
    }

    @Override
    public boolean waitForDestArrival() throws HFObjectNotFoundException {
        Boolean result = waitForAudioText(CN_TestData.DEST_ARRIVAL_TEXT);
        SystemClock.sleep(HFVariables.WAIT_SHORT);
        return result;
    }
}
