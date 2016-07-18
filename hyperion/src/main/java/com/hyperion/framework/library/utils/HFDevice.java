package com.hyperion.framework.library.utils;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.support.v4.app.ActivityCompat;

import java.io.DataOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;

public class HFDevice {
    // Storage Permissions
    private static UiDevice mDevice = null;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static Context context = null;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private String packageName;

    public HFDevice(String packageName) {
        this.packageName = packageName;
        getDevice();
    }

    private void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    private Context getContext() {
        if (context == null) {
            context = InstrumentationRegistry.getContext();
        }
        return context;
    }

    private void allowWritePermission() {
        startPackage(HFVariables.FRAMEWORK_APP_PACKAGE_NAME);
        //File system allow alert for Android N
        BySelector allowView = By.text("ALLOW");
        if (getDevice().wait(Until.hasObject(allowView), HFVariables.WAIT_SHORT)) {
            getDevice().findObject(allowView).click();
        }
    }

    private void checkPermissionAlert() {
        BySelector rememberChoiceView = By.res("com.android.settings:id/remember_forever");
        BySelector allowView = By.res("com.android.settings:id/allow");
        BySelector allowView1 = By.res("com.kingroot.kinguser:id/button_allow");
        if (getDevice().wait(Until.hasObject(rememberChoiceView), HFVariables.WAIT_SHORT)) {
            getDevice().findObject(rememberChoiceView).click();
            SystemClock.sleep(5000);
            getDevice().findObject(allowView).click();
        }
        if (getDevice().wait(Until.hasObject(allowView1), HFVariables.WAIT_SHORT)) {
            getDevice().findObject(allowView1).click();
        }
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    public UiDevice getDevice() {
        if (mDevice == null) {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        }
        return mDevice;
    }

    public static String screenShot(String name) {
        File folderPath = new File(HFVariables.PATH_IMG);
        if (!folderPath.exists())
            folderPath.mkdirs();
        String imgPrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        File filePath = new File(HFVariables.PATH_IMG + imgPrefix + "_" + name + ".png");
        if (mDevice == null) {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        }
        mDevice.takeScreenshot(filePath, 0.5f, 0);
        return imgPrefix + "_" + name + ".png";
    }

    public UiDevice startPackage(String packageName) {
        // Initialize UiDevice instance
        BySelector oneBoxEditText = By.text("Allow");
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(packageName);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);
        // Wait for the app to appear
        mDevice.wait(Until.hasObject(oneBoxEditText), 5000);
        if (mDevice.hasObject(oneBoxEditText)) {
            mDevice.findObject(oneBoxEditText).click();
        }
        return mDevice;
    }

    public void showAppInFront() throws HFObjectNotFoundException {
        Boolean status = mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), HFVariables.WAIT_ONE_SECOND);
        if (!status) {
            HFLog.addRecordToLog("ShowAppInFront Start app!");
            startApp();
        } else {
            HFLog.addRecordToLog("ShowAppInFront app is in front!");
        }
    }

    public UiDevice startApp() throws HFObjectNotFoundException {
        // Initialize UiDevice instance
        Context context = InstrumentationRegistry.getContext();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(packageName);
        try {
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
            context.startActivity(intent);
            // Wait for the app to appear
            Boolean status = mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), 60000);
            if (!status) {
                HFLog.addRecordToLog("Start up but app does not show!");
                throw new Exception();
            }
            return mDevice;
        } catch (Exception e) {
            HFLog.addRecordToLog("Start up has failed once, sleep 20s and try again!");
            //HFLog.addRecordToLog(e.getStackTrace());
            //when start app failed then retry once
            try {
                SystemClock.sleep(HFVariables.WAIT_LONG * 2);
                stopApp();
                context.startActivity(intent);
                // Wait for the app to appear
                Boolean status = mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), 60000);
                if (!status) {
                    HFLog.addRecordToLog("Start up but app does not show in retry logic!");
                    stopApp();
                    //startApp();
                    //Avoid endless loop here, just ignore this scenario
                    throw new Exception();
                }
                return mDevice;
            } catch (Exception e1) {
                HFLog.addRecordToLog("Start App Failed!");
                HFLog.addRecordToLog(e1.getStackTrace());
                throw new HFObjectNotFoundException("Start App Failed!");
            }
        }
    }

    public void stopApp() throws HFObjectNotFoundException {
        suExecute("am force-stop " + packageName);
        SystemClock.sleep(3000);
    }

    public void clearAppData() throws HFObjectNotFoundException {
        suExecute("pm clear " + packageName);
        SystemClock.sleep(3000);
    }

    public void restartApp() throws HFObjectNotFoundException {
        stopApp();
        startApp();
    }

    public void suExecute(String... strings) throws HFObjectNotFoundException {
        try {
            Boolean flag = false;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    for (String s : strings) {
                        getDevice().executeShellCommand(s);
                    }
                } catch (Exception e) {
                    HFLog.addRecordToLog("ExecuteShellCommand Failed go to common logic!");
                    flag = true;
                }
            }
            if (Build.VERSION.SDK_INT < 21 || flag) {
                Process su = Runtime.getRuntime().exec("su");
                DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
                try {
                    checkPermissionAlert();
                } catch (Exception e) {
                    HFLog.addRecordToLog("CheckPermissionAlert error!");
                    HFLog.addRecordToLog(e.getStackTrace());
                }
                for (String s : strings) {
                    outputStream.writeBytes(s + "\n");
                    outputStream.flush();
                }
                outputStream.writeBytes("exit\n");
                outputStream.flush();
                try {
                    su.waitFor();
                } catch (InterruptedException e) {
                    HFLog.addRecordToLog("suWaitFor Failed!");
                    HFLog.addRecordToLog(e.getStackTrace());
                    e.printStackTrace();
                }
                outputStream.close();
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("suExecute Failed try again!");
            HFLog.addRecordToLog(e.getStackTrace());
            if (HFVariables.RETRY_COUNT > 0) {
                HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT - 1;
                suExecute(strings);
            } else {
                HFLog.addRecordToLog("suExecute Failed finally!");
            }
        } finally {
            HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT_STORE;
        }
    }



    public void openSecretActivity() throws HFObjectNotFoundException {
        suExecute("am start -S " + packageName +
                "/com.telenav.arp.module.secret.SecretScreenActivity");
    }

    public boolean shouldAtHome() {
        return mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    public void openAppSettingDetail() throws HFObjectNotFoundException {
        Context context = getContext();
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
                HFLog.addRecordToLog("PressHomeAndStart press home failed, try:" + (i + 1));
            }
        }
        showAppInFront();
    }
}