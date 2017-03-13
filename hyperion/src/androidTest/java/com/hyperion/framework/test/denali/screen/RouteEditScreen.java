package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class RouteEditScreen extends Screen {
    public BySelector cancelAvoid = button1;
    public BySelector confirmAvoid = button2;
    public BySelector strName = By.res(HFVariables.PACKAGE_NAME + ":id/streetName");
    public BySelector avoidBtn = By.res(HFVariables.PACKAGE_NAME + ":id/avoidButton");
    public BySelector routeList = By.res(HFVariables.PACKAGE_NAME + ":id/routeListEdit");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("RouteListEdit")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
