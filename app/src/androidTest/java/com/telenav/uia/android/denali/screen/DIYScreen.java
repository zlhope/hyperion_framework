package com.telenav.uia.android.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.android.hyperion.screen.ScreenRoot;
import com.android.hyperion.utility.*;


public class DIYScreen extends ScreenRoot {
    public BySelector parentV = By.res(TnUIACommon.PACKAGE_NAME + ":id/preferenceItem");
    public BySelector avoidLView = By.res(TnUIACommon.PACKAGE_NAME + ":id/leftCheckPreference");
    public BySelector avoidRView = By.res(TnUIACommon.PACKAGE_NAME + ":id/rightCheckPreference");

    public DIYScreen(TnUIADevice tud)
    {
        super(tud);
    }
    @Override
    public boolean checkScreen() throws TnUIAObjectNotFoundException {
        objExist(parentV);
        TnUIALog.addRecordToLog("DIYScreen CheckScreen run!");
        return true;
    }
}
