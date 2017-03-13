package com.hyperion.framework.test.denali.utils;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

public class HFAppMgr {
    private String packageName;
    private UiDevice mDevice;
    private Context context;

    public HFAppMgr(String packageName) {
        this.packageName = packageName;
        mDevice = HFDevice.getDevice();
        context = HFDevice.getContext();
    }

    private void showAppInFront() throws HFObjectNotFoundException {
        Boolean status = mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), HFVariables.WAIT_ONE_SECOND);
        if (!status) {
            HFLog.logMessage("ShowAppInFront Start app!");
            startApp();
        } else {
            HFLog.logMessage("ShowAppInFront app is in front!");
        }
    }

    private UiDevice startApp() throws HFObjectNotFoundException {
        // Initialize UiDevice instance
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(packageName);
        try {
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
            context.startActivity(intent);
            // Wait for the app to appear
            Boolean status = mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), 60000);
            if (!status) {
                HFLog.logMessage("Start up but app does not show!");
                throw new Exception();
            }
            return mDevice;
        } catch (Exception e) {
            HFLog.logMessage("Start up has failed once, sleep 20s and try again!");
            //when start app failed then retry once
            try {
                SystemClock.sleep(HFVariables.WAIT_LONG * 2);
                stopApp();
                context.startActivity(intent);
                // Wait for the app to appear
                Boolean status = mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), 60000);
                if (!status) {
                    HFLog.logMessage("Start up but app does not show in retry logic!");
                    stopApp();
                    //startApp();
                    //Avoid endless loop here, just ignore this scenario
                    throw new Exception();
                }
                return mDevice;
            } catch (Exception e1) {
                HFLog.logMessage("Start App Failed!");
                HFLog.logMessage(e1.getStackTrace());
                throw new HFObjectNotFoundException("Start App Failed!");
            }
        }
    }

    private void stopApp() throws HFObjectNotFoundException {
        HFDevice.suExecute("am force-stop " + packageName);
        SystemClock.sleep(3000);
    }

    public void clearAppData() throws HFObjectNotFoundException {
        HFDevice.suExecute("pm clear " + packageName);
        SystemClock.sleep(3000);
    }

    public void startActivity(String activity) throws HFObjectNotFoundException {
        HFDevice.suExecute("am start -S " + packageName + activity);
        SystemClock.sleep(3000);
    }

    public void restartApp() throws HFObjectNotFoundException {
        stopApp();
        startApp();
    }

    private boolean shouldAtHome() {
        return mDevice.wait(Until.hasObject(By.pkg(HFDevice.getLauncherPackageName()).depth(0)), 1000);
    }

    public void openAppSettingDetail() throws HFObjectNotFoundException {
        final Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void pressHomeAndStart() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            mDevice.pressHome();
            if (shouldAtHome()) {
                break;
            } else {
                HFLog.logMessage("PressHomeAndStart press home failed, try:" + (i + 1));
            }
        }
        showAppInFront();
    }
}