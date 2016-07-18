package com.hyperion.framework.library.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.library.action.Action;
import com.hyperion.framework.library.utils.HFDevice;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;

public abstract class Screen extends Action {
    public BySelector mapPage = By.res(HFVariables.PACKAGE_NAME + ":id/mainMapStaticMap");

    public abstract boolean checkScreen() throws HFObjectNotFoundException;
}
