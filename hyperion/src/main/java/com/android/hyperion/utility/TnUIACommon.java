package com.android.hyperion.utility;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
public class TnUIACommon {
    public static String PACKAGE_NAME = "com.telenav.app.denali.na";
    public static String IMG_FOLDER = "img";
    public static String HOME_PATH = "/sdcard/";
    public static String PATH_IMG = HOME_PATH + IMG_FOLDER + "/";
    public static String REPORT_KEY_SCREEN_SHOT = "screenshot=";
    public static String REGION  = "cn";
    public static String MODULE_PACKAGE  = "com.telenav.uia.android.denali.module.";
    public static String SCREEN_SETS_PACKAGE  = "ScreenSets";
    public static String TEST_DATA_PACKAGE  = "com.telenav.uia.android.denali.testdata.TnUIATestData";
    public static String LOG_FILE_PATH  = "/sdcard/Files/Hyperion";
    public static String TEST_CASE_NAME = "";

    public static int WAIT_ONE_SECOND = 1000;
    public static int WAIT_TWO_SECONDS = 2000;
    public static int WAIT_SHORT = 3000;
    public static int WAIT_MIDDLE = 6000;
    public static int WAIT_LONG = 10000;
    public static int WAIT_ONE_MIN = WAIT_LONG * 6;
    public static int RETRY_COUNT=3;
    public static int RETRY_COUNT_STORE=3;
}
