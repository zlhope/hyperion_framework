package com.android.hyperion.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.android.hyperion.action.Action;
import com.android.hyperion.utility.TnUIACommon;
import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;

public abstract class ScreenRoot extends Action {
    public BySelector mapPage = By.res(TnUIACommon.PACKAGE_NAME + ":id/mainMapStaticMap");
    public ScreenRoot(TnUIADevice tud) {
        this.tud=tud;
    }
    public abstract boolean checkScreen() throws TnUIAObjectNotFoundException;
}
