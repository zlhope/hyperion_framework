package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class RoutePlanScreen extends Screen {
    public BySelector routeDistance = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningRouteInfo");
    public BySelector routeETE = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningRouteETE");
    public BySelector routeType = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningRouteType");
    public BySelector go = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningDriveContainer");
    public BySelector option3 = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningOption3Item");
    public BySelector option2 = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningOption2Item");
    public BySelector option1 = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningOption1Item");
    public BySelector plannerGrid = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanInfo");
    public BySelector routePlanningProgress = By.res(HFVariables.PACKAGE_NAME + ":id/routePlanningProgressView");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("RoutePlan")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
