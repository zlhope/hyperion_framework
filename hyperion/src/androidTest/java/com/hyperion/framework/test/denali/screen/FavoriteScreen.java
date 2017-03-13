package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class FavoriteScreen extends Screen {
    public BySelector favoriteIcon = By.res(HFVariables.PACKAGE_NAME + ":id/favoriteIcon");
    public BySelector addrText = By.res(HFVariables.PACKAGE_NAME + ":id/userItemAddressTextView");
    public BySelector POIAddr = By.res(HFVariables.PACKAGE_NAME + ":id/userItemSecondaryTextView");
    public BySelector POINm = By.res(HFVariables.PACKAGE_NAME + ":id/userItemMainTextView");
    public BySelector rowItem = By.res(HFVariables.PACKAGE_NAME + ":id/userItem");
    public BySelector favoriteList = By.res(HFVariables.PACKAGE_NAME + ":id/userItemResultListView");
    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
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
