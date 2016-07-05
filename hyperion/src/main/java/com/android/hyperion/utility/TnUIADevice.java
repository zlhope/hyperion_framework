package com.android.hyperion.utility;
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

public class TnUIADevice {
    public static Context context = null;
    public static UiDevice mDevice = null;
    public String packageName;
    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
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
    public TnUIADevice(String packageName) {
        this.packageName = packageName;
    }

    public static UiDevice getDevice() {
        if (mDevice == null) {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        }
        return mDevice;
    }

    public static Context getContext() {
        if (context == null) {
            context = InstrumentationRegistry.getContext();
        }
        return context;
    }

    public static void allowWritePermission() {
        String packageName = "com.telenavsoftware.hyperion.framework";
        TnUIADevice device = new TnUIADevice(packageName);
        device.startPackage(packageName);
        //File system allow alert for Android N
        BySelector allowView = By.text("ALLOW");
        if (getDevice().wait(Until.hasObject(allowView), TnUIACommon.WAIT_SHORT)) {
            getDevice().findObject(allowView).click();
        }
    }

    public static String screenShot(String name) {
        File folderPath = new File(TnUIACommon.PATH_IMG);
        if (!folderPath.exists())
            folderPath.mkdirs();
        String ss = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        File filePath = new File(TnUIACommon.PATH_IMG + ss + "_" + name + ".png");
        getDevice().takeScreenshot(filePath, 0.5f, 0);
        return ss + "_" + name + ".png";
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
        if(mDevice.hasObject(oneBoxEditText))
        {
            mDevice.findObject(oneBoxEditText).click();
        }
        return mDevice;
    }

    public void showAppInFront() throws TnUIAObjectNotFoundException{
        Boolean status=mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), TnUIACommon.WAIT_ONE_SECOND);
        if(!status)
        {
            TnUIALog.addRecordToLog("ShowAppInFront Start app!");
            startApp();
        }
        else
        {
            TnUIALog.addRecordToLog("ShowAppInFront app is in front!");
        }
    }

    public UiDevice startApp() throws TnUIAObjectNotFoundException {
        // Initialize UiDevice instance
        Context context = InstrumentationRegistry.getContext();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(packageName);
        try {
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
            context.startActivity(intent);
            // Wait for the app to appear
            Boolean status=mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), 60000);
            if(!status)
            {
                TnUIALog.addRecordToLog("Start up but app does not show!");
                throw new Exception();
            }
            return mDevice;
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Start up has failed once, sleep 20s and try again!");
            //TnUIALog.addRecordToLog(e.getStackTrace());
            //when start app failed then retry once
            try {
                SystemClock.sleep(TnUIACommon.WAIT_LONG*2);
                stopApp();
                context.startActivity(intent);
                // Wait for the app to appear
                Boolean status=mDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), 60000);
                if(!status)
                {
                    TnUIALog.addRecordToLog("Start up but app does not show in retry logic!");
                    stopApp();
                    //startApp();
                    //Avoid endless loop here, just ignore this scenario
                    throw new Exception();
                }
                return mDevice;
            }catch (Exception e1) {
                TnUIALog.addRecordToLog("Start App Failed!");
                TnUIALog.addRecordToLog(e1.getStackTrace());
                throw new TnUIAObjectNotFoundException("Start App Failed!");
            }
        }
    }

    public void stopApp() throws TnUIAObjectNotFoundException{
        suExecute("am force-stop " + packageName);
        SystemClock.sleep(3000);
    }

    public void clearAppData() throws TnUIAObjectNotFoundException{
        suExecute("pm clear " + packageName);
        SystemClock.sleep(3000);
    }

    public void restartApp() throws TnUIAObjectNotFoundException{
        stopApp();
        startApp();
    }

    public void suExecute(String... strings) throws TnUIAObjectNotFoundException{
        try {
            Boolean flag=false;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    for (String s : strings) {
                        getDevice().executeShellCommand(s);
                    }
                }catch (Exception e)
                {
                    TnUIALog.addRecordToLog("ExecuteShellCommand Failed go to common logic!");
                    flag=true;
                }
            }
            if (Build.VERSION.SDK_INT < 21 || flag) {
                Process su = Runtime.getRuntime().exec("su");
                DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
                try {
                    checkPermissionAlert();
                }catch (Exception e)
                {
                    TnUIALog.addRecordToLog("CheckPermissionAlert error!");
                    TnUIALog.addRecordToLog(e.getStackTrace());
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
                    TnUIALog.addRecordToLog("suWaitFor Failed!");
                    TnUIALog.addRecordToLog(e.getStackTrace());
                    e.printStackTrace();
                }
                outputStream.close();
            }
        } catch (Exception e) {
            TnUIALog.addRecordToLog("suExecute Failed try again!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            if(TnUIACommon.RETRY_COUNT>0) {
                TnUIACommon.RETRY_COUNT=TnUIACommon.RETRY_COUNT-1;
                suExecute(strings);
            }
            else {
                TnUIALog.addRecordToLog("suExecute Failed finally!");
            }
        }finally {
            TnUIACommon.RETRY_COUNT=TnUIACommon.RETRY_COUNT_STORE;
        }
    }

    private void checkPermissionAlert() {
        BySelector rememberChoiceView = By.res("com.android.settings:id/remember_forever");
        BySelector allowView = By.res("com.android.settings:id/allow");
        BySelector allowView1 = By.res("com.kingroot.kinguser:id/button_allow");
        if (getDevice().wait(Until.hasObject(rememberChoiceView), TnUIACommon.WAIT_SHORT)) {
            getDevice().findObject(rememberChoiceView).click();
            SystemClock.sleep(5000);
            getDevice().findObject(allowView).click();
        }
        if (getDevice().wait(Until.hasObject(allowView1), TnUIACommon.WAIT_SHORT)) {
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

    public void openSecretActivity() throws TnUIAObjectNotFoundException{
        suExecute("am start -S " + packageName +
                "/com.telenav.arp.module.secret.SecretScreenActivity");
    }

    public boolean shouldAtHome() {
        return mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    public void openAppSettingDetail() throws TnUIAObjectNotFoundException{
        Context context=getContext();
        final Intent intent=new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void pressHomeAndStart() throws TnUIAObjectNotFoundException
    {
        for(int i=0;i<3;i++)
        {
            mDevice.pressHome();
            if(shouldAtHome())
            {
                break;
            }
            else
            {
                TnUIALog.addRecordToLog("PressHomeAndStart press home failed, try:"+(i+1));
            }
        }
        showAppInFront();
    }
}