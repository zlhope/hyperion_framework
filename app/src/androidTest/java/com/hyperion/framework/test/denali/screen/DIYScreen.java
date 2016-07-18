package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.library.screen.Screen;
import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;


public class DIYScreen extends Screen {
    public BySelector parentV = By.res(HFVariables.PACKAGE_NAME + ":id/preferenceItem");
    public BySelector avoidLView = By.res(HFVariables.PACKAGE_NAME + ":id/leftCheckPreference");
    public BySelector avoidRView = By.res(HFVariables.PACKAGE_NAME + ":id/rightCheckPreference");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        objExist(parentV);
        HFLog.addRecordToLog("DIYScreen CheckScreen run!");
        return true;
    }
}
