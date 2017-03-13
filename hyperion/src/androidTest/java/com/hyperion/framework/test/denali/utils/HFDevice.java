package com.hyperion.framework.test.denali.utils;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.support.v4.content.ContextCompat;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class HFDevice {
    // Storage Permissions
    private static UiDevice mDevice = null;
    private static Context context = null;

    public static Context getContext() {
        if(context == null) {
            return InstrumentationRegistry.getContext();
        }
        return context;
    }

    public static String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    public static UiDevice getDevice() {
        if (mDevice == null) {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        }
        return mDevice;
    }

    @SuppressWarnings("all")
    public static String screenShot(String name) {
        File folderPath = new File(HFVariables.PATH_IMG);
        if (!folderPath.exists())
            folderPath.mkdirs();
        String imgPrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        File filePath = new File(HFVariables.PATH_IMG + imgPrefix + "_" + name + ".png");
        getDevice().takeScreenshot(filePath, 0.5f, 0);
        return imgPrefix + "_" + name + ".png";
    }

    @SuppressWarnings("all")
    public static void specificViewScreenShot(String msg, int x, int y, int width, int height){
        try {
            File folderPath = new File(HFVariables.PATH_IMG);
            if(!folderPath.exists())
                folderPath.mkdirs();
            String imgPrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
            File filePathTmp = new File(HFVariables.PATH_IMG + "TMP_SCREENSHOT"  + ".png");
            File filePath = new File(HFVariables.PATH_IMG + imgPrefix + "_" + msg + ".png");
            getDevice().takeScreenshot(filePathTmp, 0.5f, 0);
            InputStream source = new FileInputStream(filePathTmp);
            Bitmap bitmap = BitmapFactory.decodeStream(source);
            bitmap = Bitmap.createBitmap(
                    bitmap,
                    x,
                    y,
                    width,
                    height,
                    null,
                    false
            );
            FileOutputStream out = new FileOutputStream(filePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            HFLog.logMessage("Obj [" + x+","+y + "] screen shot is :" + filePath);
        }catch (Exception e)
        {
            HFLog.logMessage(e.getStackTrace());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("all")
    public static void specificViewScreenShot(String msg, BySelector selector){
        try {
            File folderPath = new File(HFVariables.PATH_IMG);
            if(!folderPath.exists())
                folderPath.mkdirs();
            String imgPrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
            File filePathTmp = new File(HFVariables.PATH_IMG + "TMP_SCREENSHOT"  + ".png");
            File filePath = new File(HFVariables.PATH_IMG + imgPrefix + "_" + msg + ".png");
            getDevice().takeScreenshot(filePathTmp, 0.5f, 0);
            InputStream source = new FileInputStream(filePathTmp);
            Bitmap bitmap = BitmapFactory.decodeStream(source);
            Rect objRect = getDevice().findObject(selector).getVisibleBounds();
            bitmap = Bitmap.createBitmap(
                    bitmap,
                    objRect.left,
                    objRect.top,
                    objRect.width(),
                    objRect.height(),
                    null,
                    false
            );
            FileOutputStream out = new FileOutputStream(filePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            HFLog.logMessage("Obj [" + selector.toString() + "] screen shot is :" + filePath);
        }catch (Exception e)
        {
            HFLog.logMessage(e.getStackTrace());
            e.printStackTrace();
        }
    }

    public static boolean startPackage(String packageName) {
        final Intent intent = getContext().getPackageManager()
                .getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        getContext().startActivity(intent);
        // Wait for the app to appear
        return getDevice().wait(Until.hasObject(By.pkg(packageName).depth(0)), 10000);
    }

    public static void allowWritePermission() {
        int ret = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (ret == PackageManager.PERMISSION_DENIED) {
            startPackage(HFVariables.FRAMEWORK_APP_PACKAGE_NAME);
            //File system allow alert for Android N
            BySelector allowView = By.text(Pattern.compile("ALLOW|允许"));
            if (getDevice().wait(Until.hasObject(allowView), HFVariables.WAIT_SHORT)) {
                getDevice().findObject(allowView).click();
            }
        }
    }

    public static boolean checkPermissionAlert() {
        BySelector allowView = By.text(Pattern.compile("Grant|授权"));
        if (getDevice().wait(Until.hasObject(allowView), HFVariables.WAIT_SHORT)) {
            getDevice().findObject(allowView).click();
            return true;
        }
        return false;
    }

    public static boolean showAppInFront(String packageName) throws HFObjectNotFoundException {
        return getDevice().wait(Until.hasObject(By.pkg(packageName).depth(0)), HFVariables.WAIT_ONE_SECOND);
    }

    public static void stopApp(String packageName) throws HFObjectNotFoundException {
        suExecute("am force-stop " + packageName);
        SystemClock.sleep(3000);
    }

    public static void suExecute(String... strings) throws HFObjectNotFoundException {
        try {
            Boolean flag = false;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    for (String s : strings) {
                        getDevice().executeShellCommand(s);
                    }
                } catch (Exception e) {
                    HFLog.logMessage("ExecuteShellCommand Failed go to common logic!");
                    flag = true;
                }
            }
            if (Build.VERSION.SDK_INT < 21 || flag) {
                Process su = Runtime.getRuntime().exec("su");
                DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
                try {
                    checkPermissionAlert();
                } catch (Exception e) {
                    HFLog.logMessage("CheckPermissionAlert error!");
                    HFLog.logMessage(e.getStackTrace());
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
                    HFLog.logMessage("suWaitFor Failed!");
                    HFLog.logMessage(e.getStackTrace());
                    e.printStackTrace();
                }
                outputStream.close();
            }
        } catch (Exception e) {
            HFLog.logMessage("suExecute Failed try again!");
            HFLog.logMessage(e.getStackTrace());
            if (HFVariables.RETRY_COUNT > 0) {
                HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT - 1;
                suExecute(strings);
            } else {
                HFLog.logMessage("suExecute Failed finally!");
            }
        } finally {
            HFVariables.RETRY_COUNT = HFVariables.RETRY_COUNT_STORE;
        }
    }

    private boolean shouldAtHome() {
        return getDevice().wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    public static void openWifi(){
        Context context = getContext();
        WifiManager wManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (!wManager.isWifiEnabled()) {
            wManager.setWifiEnabled(true);
            for(int i = 0; i < 10; i ++){
                if(!wManager.isWifiEnabled()){
                    SystemClock.sleep(HFVariables.WAIT_SHORT);
                } else {
                    break;
                }
            }
        }
    }

    public static boolean getWifiStatus(){
        WifiManager wManager = (WifiManager) getContext().getSystemService(Context.WIFI_SERVICE);
        return wManager.isWifiEnabled();
    }

    public static void closeWifi(){
        Context context = getContext();
        WifiManager wManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wManager.isWifiEnabled()) {
            wManager.setWifiEnabled(false);
            for(int i = 0; i < 10; i ++){
                if(wManager.isWifiEnabled()){
                    SystemClock.sleep(HFVariables.WAIT_SHORT);
                } else {
                    break;
                }
            }
        }
    }

    public static void notification() throws HFObjectNotFoundException {
        Context context = getContext();
        NotificationManager m_NotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //Intent m_Intent = new Intent(context, Class.forName("com.hyperion.framework.app.MainActivity"));
        //PendingIntent m_PendingIntent = PendingIntent.getActivity(context, 0, m_Intent, 0);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Notification");
        builder.setContentText("Sample Text");
        //builder.setContentIntent(m_PendingIntent);
        m_NotificationManager.notify(0, builder.build());
    }
}