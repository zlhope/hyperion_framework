package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class HwyExitScreen extends Screen {
    public BySelector exitLabel = By.res(HFVariables.PACKAGE_NAME + ":id/exitLabel");
    public BySelector atmPOI = By.res(HFVariables.PACKAGE_NAME + ":id/search_atm");
    public BySelector lodgingPOI = By.res(HFVariables.PACKAGE_NAME + ":id/search_lodging");
    public BySelector restaurantPOI = By.res(HFVariables.PACKAGE_NAME + ":id/search_restaurant");
    public BySelector foodPOI = By.res(HFVariables.PACKAGE_NAME + ":id/search_fastFood");
    public BySelector coffeePOI = By.res(HFVariables.PACKAGE_NAME + ":id/search_coffee");
    public BySelector gasPOI = By.res(HFVariables.PACKAGE_NAME + ":id/search_gas");
    public BySelector exitDistance = By.res(HFVariables.PACKAGE_NAME + ":id/exitDistance");
    public BySelector exitTitle = By.res(HFVariables.PACKAGE_NAME + ":id/exitTitle");
    public BySelector shieldIcon = By.res(HFVariables.PACKAGE_NAME + ":id/shieldIcon");
    public BySelector exitContainer = By.res(HFVariables.PACKAGE_NAME + ":id/poiContainer");
    public BySelector exitList = By.res(HFVariables.PACKAGE_NAME + ":id/exitPoiListView");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("HighwayExitList")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
