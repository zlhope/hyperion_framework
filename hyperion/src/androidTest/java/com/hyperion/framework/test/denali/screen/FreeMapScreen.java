package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class FreeMapScreen extends Screen {

    public BySelector recent = By.res(HFVariables.PACKAGE_NAME + ":id/oneBoxRecent");
    public BySelector setting = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionButtonImage");
    public BySelector denaliIcon = By.desc("Denali");
    public BySelector mapScreenIndicator = By.res(HFVariables.PACKAGE_NAME + ":id/onebox_fragments_container");
    public BySelector OK = button3;
    public BySelector NO = button2;

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("FreeMap")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
