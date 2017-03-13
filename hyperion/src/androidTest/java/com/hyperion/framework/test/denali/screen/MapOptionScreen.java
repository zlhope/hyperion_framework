package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class MapOptionScreen extends Screen {

    public BySelector editDestination = By.res(HFVariables.PACKAGE_NAME + ":id/editDestinationsPreferenceView");
    public BySelector avoidTempOnRoute = By.res(HFVariables.PACKAGE_NAME + ":id/routeAvoidancePreferenceView");
    public BySelector showTrafficSwitch = By.res(HFVariables.PACKAGE_NAME + ":id/showTrafficSwitch");
    public BySelector trafficOn = By.desc(TRAFFIC_ON);
    public BySelector traffic = By.desc(TRAFFIC);
    public BySelector poiOnMap = By.desc(POI_ON_MAP);
    public BySelector mapMode = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionItemImage");
    public BySelector m3DLandmarkSwitch = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionSwitchButton_landMark");
    public BySelector m3DBuildingSwitch = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionSwitchButton_3DBuilding");
    public BySelector setting = By.res(HFVariables.PACKAGE_NAME + ":id/moreSettingsPreferenceView");
    public BySelector optionView = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionsScrollView");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("MapOptions")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
