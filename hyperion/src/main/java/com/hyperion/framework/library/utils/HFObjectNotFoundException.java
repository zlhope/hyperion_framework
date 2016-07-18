package com.hyperion.framework.library.utils;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.support.test.uiautomator.UiObjectNotFoundException;

@SuppressWarnings("serial")
public class HFObjectNotFoundException extends UiObjectNotFoundException {

    public HFObjectNotFoundException(String msg) {
        super(screenShotError(msg));
    }

    private static String screenShotError(String name) {
        String relativePath = HFDevice.screenShot(name);
        return relativePath;
    }
}
