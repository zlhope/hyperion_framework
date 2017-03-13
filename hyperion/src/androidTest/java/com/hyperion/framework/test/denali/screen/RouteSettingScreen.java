package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class RouteSettingScreen extends Screen {
    public BySelector settingList = By.res(HFVariables.PACKAGE_NAME + ":id/routeSettingPreferencesListView");
    public BySelector avoidType = By.res(HFVariables.PACKAGE_NAME + ":id/preferencesCheckItemText");
    public BySelector avoidOnRoute = By.res(HFVariables.PACKAGE_NAME + ":id/topBarAdditionalButton1");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("RouteSetting")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
