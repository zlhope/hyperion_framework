package com.hyperion.framework.library.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;

public class FreeMapScreen extends Screen {
    public BySelector sideBarView = By.res(HFVariables.PACKAGE_NAME + ":id/glViewSidebar");
    public BySelector sideBarButton = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarSwitchButton");
    public BySelector sideBarIcon = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarIcon");
    public BySelector close = By.res(HFVariables.PACKAGE_NAME + ":id/OneBoxClose");
    public BySelector oneBoxEditText = By.res(HFVariables.PACKAGE_NAME + ":id/commonFilterBoxTextView");
    public BySelector recent = By.res(HFVariables.PACKAGE_NAME + ":id/oneBoxRecent");
    public BySelector setting = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionButtonImage");//Yujie
    public BySelector denaliIcon = By.desc("Denali");
    public BySelector mapScreenIndicator = By.res(HFVariables.PACKAGE_NAME + ":id/onebox_fragments_container");
    public BySelector zoomIn = By.res(HFVariables.PACKAGE_NAME + ":id/zoomInButton");
    public BySelector zoomOut = By.res(HFVariables.PACKAGE_NAME + ":id/zoomOutButton");
    public BySelector locateMeButton = By.desc("Current Location");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("FreeMap CheckScreen run!");
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
