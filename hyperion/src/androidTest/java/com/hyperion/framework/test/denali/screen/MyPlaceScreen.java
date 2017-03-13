package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class MyPlaceScreen extends Screen {
    public BySelector favorite = By.res(HFVariables.PACKAGE_NAME + ":id/favoriteIcon");
    public BySelector previousStreetDis = By.res(HFVariables.PACKAGE_NAME + ":id/previousStreetDistance");
    public BySelector forwardStreetDis = By.res(HFVariables.PACKAGE_NAME + ":id/forwardStreetDistance");
    public BySelector currentStreet = By.res(HFVariables.PACKAGE_NAME + ":id/currentStreet");
    public BySelector currentStreetTitle = By.res(HFVariables.PACKAGE_NAME + ":id/currentStreetTitle");
    public BySelector previousStreet = By.res(HFVariables.PACKAGE_NAME + ":id/previousStreet");
    public BySelector previousStreetTitle = By.res(HFVariables.PACKAGE_NAME + ":id/previousStreetTitle");
    public BySelector forwardStreet = By.res(HFVariables.PACKAGE_NAME + ":id/forwardStreet");
    public BySelector forwardStreetTitle = By.res(HFVariables.PACKAGE_NAME + ":id/forwardStreetTitle");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("Init")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
