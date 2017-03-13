package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class SecretScreen extends Screen {
    public BySelector regionText = By.text("Current Region");
    public BySelector confirmBtn = By.textContains("确定|OK|YES|Yes");
    public BySelector scoutIcon = By.res(HFVariables.PACKAGE_NAME + ":id/splashIcon");
    public BySelector secretScreenIndicator = By.text("Secret Setting");
    //Secret page elements
    public BySelector defaultLocation = By.text("DefaultLocation");
    public BySelector dataPath = By.text("Map Data Path");
    public BySelector GPSConfig = By.text("GPS Config");
    public BySelector kml = By.text("Kml");
    public BySelector alongRouteGPS = By.text("AlongRoute GPS");
    public BySelector DeviceGPS = By.text("DeviceGPS");
    public BySelector logLvl = By.text("Log Level");

    //enable automation mode
    public BySelector EnableAutomation = By.text("Enable Automation");
    public BySelector trueBtn = By.text("true");
    public BySelector falseBtn = By.text("false");
    //Elements on Default location popup
    public BySelector editBox = By.res("android:id/edit");
    public BySelector OK = button1;
    public BySelector logList = By.res("android:id/select_dialog_listview");
    public BySelector mapDataNotFoundMsg = By.res(HFVariables.PACKAGE_NAME+":id/alertDialogContentPanel");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("Secret")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
