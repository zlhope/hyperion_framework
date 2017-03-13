package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class RouteListScreen extends Screen {
    public BySelector waypointEntryBtn = By.res(HFVariables.PACKAGE_NAME + ":id/mapWayPointButton");
    public BySelector addressView = By.res(HFVariables.PACKAGE_NAME + ":id/RouteListAddressName");
    public BySelector itemView = By.res(HFVariables.PACKAGE_NAME + ":id/route_list");
    public BySelector rlStName = By.res(HFVariables.PACKAGE_NAME + ":id/streetName");
    public BySelector rlStLength = By.res(HFVariables.PACKAGE_NAME + ":id/streetLength");
    public BySelector rlTurnIcon = By.res(HFVariables.PACKAGE_NAME + ":id/turnIcon");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("RouteListView")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
