package com.android.hyperion.utility;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

public class TnUIALog {
    public static FileHandler logger = null;
    public static File logFile=null;
    private static String fileName = "Android_Automation_Log";
    private static String folderName = TnUIACommon.LOG_FILE_PATH;
    public static String testName=TnUIACommon.TEST_CASE_NAME;
    static boolean isExternalStorageAvailable = false;
    static boolean isExternalStorageWritable = false;
    static String state = Environment.getExternalStorageState();

    public static void mkLogfile()
    {
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // We can read and write the media
            isExternalStorageAvailable = isExternalStorageWritable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            isExternalStorageAvailable = true;
            isExternalStorageWritable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            isExternalStorageAvailable = isExternalStorageWritable = false;
        }

        File dir = new File(folderName);
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            if (!dir.exists()) {
                Log.d("Dir created ", "Dir created ");
                dir.mkdirs();
            }

            logFile = new File(folderName + "/" + fileName + ".log");

            if (!logFile.exists()) {
                try {
                    Log.d("File created ", "File created ");
                    logFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    public static void addRecordToLog(StackTraceElement[] elements) {
        addRecordToLog("[StackTrace Start]");
        for (int i = 0; i < elements.length; i++) {
            addRecordToLog(elements[i].toString());
        }
        addRecordToLog("[StackTrace End]");
    }

    public static String getCaseName()
    {
        if((!testName.equals("Unknown"))&&(!testName.equals("")))
        {
            return testName;
        }
        StackTraceElement te;
        String tmpStr;
        for(int i=1;i<10;i++)
        {
            te = Thread.currentThread().getStackTrace()[i];
            tmpStr = te.getClassName();
            if(tmpStr.contains("testcase"))
            {
                return te.getMethodName();
            }
        }
        return "Unknown";
    }

    public static void addRecordToLog(String message) {
        try {
            mkLogfile();
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            Date now_time = new Date();

            message="["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now_time)+"] "+"["+getCaseName()+"] "+
                    message;
            buf.write(message);
            //buf.append(message);
            buf.newLine();
            buf.flush();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
