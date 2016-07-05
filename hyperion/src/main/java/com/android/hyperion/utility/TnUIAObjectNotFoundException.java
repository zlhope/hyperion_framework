package com.android.hyperion.utility;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import android.support.test.uiautomator.UiObjectNotFoundException;

@SuppressWarnings("serial")
public class TnUIAObjectNotFoundException extends UiObjectNotFoundException {

    public TnUIAObjectNotFoundException(String msg) {
        super(screenShotError(msg));
    }

    private static String screenShotError(String name) {
        String relativePath = TnUIADevice.screenShot(name);
        return relativePath;
    }
}
