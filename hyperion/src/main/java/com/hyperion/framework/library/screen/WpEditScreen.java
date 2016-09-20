package com.hyperion.framework.library.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.os.SystemClock;

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;

public class WpEditScreen extends Screen {
    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("FreeMap CheckScreen run!");
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("EditDestinations")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
