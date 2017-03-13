package com.hyperion.framework.test.denali.testcase.cases.prototype;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.util.Xml;

import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Toolkit extends CaseBase {

    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
        initTestData();
    }

    @After
    public void testTeardown() {
    }

    @Test
    public void TK_1_ConfigApp() throws Exception {
        HFVariables.IS_FIRST_RUN = true;
        mainModule.initiateApp(origin);
    }

    @Test
    public void TK_2_ClearAppData() throws Exception {
        hfa.clearAppData();
    }

    @Test
    public void TK_3_GetARouteDynamically() throws Exception {
        HFVariables.IS_FIRST_RUN = false;
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
    }

    //am instrument -e class com.hyperion.framework.test.denali.testcase.cases.prototype.Demo#TK_6666_Censorship -e trigger true -w com.hyperion.framework.app.test/android.support.test.runner.AndroidJUnitRunner
    @Test
    public void TK_6666_Censorship() throws Exception {
        List<Map<String, String>> list = getXMLData();
        for(Map map : list){
            mainModule.initiateApp(map.get("lat") + "," + map.get("lon"));
            navigationModule.setZoomLevel(Integer.parseInt(map.get("level").toString()));
            SystemClock.sleep(HFVariables.WAIT_SHORT);
            HFLog.logMessage("Taking screen shot: [" + map.get("name") + "].");
            screenShot(map.get("name").toString());
        }
    }

    private List<Map<String, String>> getXMLData() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        try {
            File dataFile = new File("/sdcard/data.xml");
            FileInputStream inputStream = new FileInputStream(dataFile);
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(inputStream, "UTF-8");
            int eventType = parser.getEventType();
            while (eventType != XmlResourceParser.END_DOCUMENT) {
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("item")) {
                            map = new HashMap<String, String>();
                        } else if (parser.getName().equals("name")) {
                            map.put("name", parser.nextText());
                        } else if (parser.getName().equals("lon")) {
                            map.put("lon", parser.nextText());
                        } else if (parser.getName().equals("lat")) {
                            map.put("lat", parser.nextText());
                        }else if (parser.getName().equals("level")) {
                            map.put("level", parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            list.add(map);
                            map = null;
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String screenShot(String name) {
        String path = HFVariables.PATH_IMG + "/Censorship/";
        File folderPath = new File(path);
        if (!folderPath.exists())
            folderPath.mkdirs();
        File filePath = new File(path + name + ".png");
        if (filePath.exists()){
            filePath.delete();
        }
        HFDevice.getDevice().takeScreenshot(filePath, 0.5f, 0);
        return name + ".png";
    }
}