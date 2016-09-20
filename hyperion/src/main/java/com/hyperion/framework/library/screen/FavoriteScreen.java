package com.hyperion.framework.library.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;

public class FavoriteScreen extends Screen {
    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("FreeMap CheckScreen run!");
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("FavoriteList")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
