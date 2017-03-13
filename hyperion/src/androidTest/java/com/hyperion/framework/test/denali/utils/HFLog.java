package com.hyperion.framework.test.denali.utils;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class HFLog {
    private static File LOG_FILE = null;
    private static boolean isExternalStorageAvailable = false;
    private static boolean isExternalStorageWritable = false;
    private static String STATE = Environment.getExternalStorageState();
    private static String FILE_NAME = "Android_Automation_Log";
    private static String FOLDER_NAME = HFVariables.LOG_FILE_PATH;

    private static void mkLogfile(String fileName) {
        if (Environment.MEDIA_MOUNTED.equals(STATE)) {
            // We can read and write the media
            isExternalStorageAvailable = isExternalStorageWritable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(STATE)) {
            // We can only read the media
            isExternalStorageAvailable = true;
            isExternalStorageWritable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            isExternalStorageAvailable = isExternalStorageWritable = false;
        }

        File dir = new File(FOLDER_NAME);
        if (Environment.MEDIA_MOUNTED.equals(STATE)) {
            if (!dir.exists()) {
                Log.d("Dir created ", "Dir created ");
                dir.mkdirs();
            }

            LOG_FILE = new File(FOLDER_NAME + "/" + fileName + ".log");

            if (!LOG_FILE.exists()) {
                try {
                    Log.d("File created ", "File created ");
                    LOG_FILE.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logMessage(StackTraceElement[] elements) {
        logMessage("[StackTrace Start]");
        for (StackTraceElement element : elements) {
            logMessage(element.toString());
        }
        logMessage("[StackTrace End]");
    }

    private static String getCaseName() {
        if ((!HFVariables.TEST_CASE_NAME.equals("Unknown")) &&
                (!HFVariables.TEST_CASE_NAME.equals(""))) {
            return HFVariables.TEST_CASE_NAME;
        }
        StackTraceElement te;
        String tmpStr;
        for (int i = 1; i < 10; i++) {
            te = Thread.currentThread().getStackTrace()[i];
            tmpStr = te.getClassName();
            if (tmpStr.contains("testcase")) {
                return te.getMethodName();
            }
        }
        return "Unknown";
    }

    public static void logMessage(String message) {
        try {
            mkLogfile(FILE_NAME);
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(LOG_FILE, true));
            Date now_time = new Date();

            message = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now_time) + "] " + "[" + getCaseName() + "] " +
                    message;
            buf.write(message);
            buf.newLine();
            buf.flush();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
