package com.hyperion.framework.test.denali.utils;

/**
 * Created by Johnny Huang on 2016/1/21
 */
public final class HFVariables {
    public static final String TEST_DATA_PACKAGE = "com.hyperion.framework.test.denali.testdata";
    public static final String TEST_MODULE_PACKAGE = "com.hyperion.framework.test.denali.module";
    public static final String PATH_IMG = "/sdcard/Files/Hyperion/ScreenShot/";
    public static final String REPORT_KEY_SCREEN_SHOT = "ScreenShot=";
    public static final String LOG_FILE_PATH = "/sdcard/Files/Hyperion/Log";
    public static final String FRAMEWORK_APP_PACKAGE_NAME = "com.hyperion.framework.app";
    public static final String FRAMEWORK_TEST_APP_PACKAGE_NAME = "com.hyperion.framework.app.test";
    public static final String START_TEST_APP_CMD = "am start -S "+ FRAMEWORK_APP_PACKAGE_NAME + "/"+ FRAMEWORK_APP_PACKAGE_NAME+ ".MainActivity";
    public static final int WAIT_ONE_SECOND = 1000;
    public static final int WAIT_SHORT = 3000;
    public static final int WAIT_MIDDLE = 6000;
    public static final int WAIT_LONG = 10000;
    public static final String SECRET_ACTIVITY = "/com.telenav.arp.module.secret.SecretScreenActivity";
    public static final String AND = "|";
    public static final String MODEL_GM = "gm";
    public static final String GM_DATA_PATH = "/storage/sdcard/sdcard0/vol1/TelenavMapData";
    public static final String TABLET_DATA_PATH = "/sdcard/TelenavMapData";
    public static final String LG_DATA_PATH = "/storage/external_SD/TelenavMapData";
    public static final String ALONG_ROUTE_GPS = "AlongRoute GPS";
    public static final String DEVICE_GPS = "DeviceGPS";
    public static final String KML_GPS = "Kml";
    public static final String AUDIO_FILER = "Playing audio guidance";
    public static final String AUDIO_FILER2 = "Playing audio guidance\\(the 1st TTS string\\): ";
    public static final String AUDIO_FILER3 = " I AutoSdkNavigationServiceJNI";
    public static final int WAIT_APP_TIMEOUT = 300000;
    public static Boolean SORT_BY_DISTANCE = null;
    public static Boolean RUN_BY_TRIGGER = false;
    public static Boolean IS_FIRST_RUN_CLOCK = false;//Do not modify anyway
    public static long TIMEOUT_CHECK_START;
    public static long TIMEOUT_CHECK_END;
    public static String RUN_TYPE = "NI";
    public static String PACKAGE_NAME = "com.telenav.app.denali.na";
    public static String REGION = "cn";
    public static String TEST_CASE_NAME = "";
    public static int RETRY_COUNT = 3;
    public static int RETRY_COUNT_STORE = 3;
    public static Boolean IS_FIRST_RUN = true;
}
