package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class RecentsScreen extends Screen {
    public BySelector userIcon = By.res(HFVariables.PACKAGE_NAME + ":id/userIcon");
    public BySelector emptyText = By.res(HFVariables.PACKAGE_NAME + ":id/userItemEmptyText");
    public BySelector deleteToast = By.res(HFVariables.PACKAGE_NAME + ":id/toastMessageWithTapButton");
    public BySelector distance = By.res(HFVariables.PACKAGE_NAME + ":id/userItemDistanceTextView");
    public BySelector addr = By.res(HFVariables.PACKAGE_NAME + ":id/userItemSecondaryTextView");
    public BySelector addrText = By.res(HFVariables.PACKAGE_NAME + ":id/userItemAddressTextView");
    public BySelector POIText = By.res(HFVariables.PACKAGE_NAME + ":id/userItemMainTextView");
    public BySelector userItem = By.res(HFVariables.PACKAGE_NAME + ":id/userItem");
    public BySelector resultList = By.res(HFVariables.PACKAGE_NAME + ":id/userItemResultListView");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("RecentList")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
