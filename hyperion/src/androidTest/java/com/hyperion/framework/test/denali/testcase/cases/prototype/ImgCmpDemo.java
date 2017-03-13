package com.hyperion.framework.test.denali.testcase.cases.prototype;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.os.SystemClock;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.TestData;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ImgCmpDemo extends CaseBase {

    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
        initTestData();
    }

    @After
    public void testTeardown() {
    }

    @Test
    public void DP_9999_ImgCmpDemo1() throws Exception {
        mainModule.initiateApp("36.3709535814,79.9939991775");
        settingModule.setSetting(TestData.night, true);
        SystemClock.sleep(3000);
        HFDevice.screenShot("999_DEMO");
        hfAssertImgCmp();
    }

    @Test
    public void DP_9998_ImgCmpDemo2() throws Exception {
        mainModule.initiateApp("36.3709535814,79.9939991775");
        settingModule.setSetting(TestData.night, true);
        SystemClock.sleep(3000);
        HFDevice.specificViewScreenShot("998_DEMO1", 808, 522, 123, 109);
        hfAssertImgCmp();
    }

    @Test
    public void DP_9997_ImgCmpDemo3() throws Exception {
        mainModule.initiateApp("36.3709535814,79.9939991775");
        settingModule.setSetting(TestData.night, true);
        SystemClock.sleep(3000);
        HFDevice.screenShot("997_DEMO1");
        HFDevice.specificViewScreenShot("997_DEMO2", freeMap.currentStreet);
        HFDevice.specificViewScreenShot("997_DEMO3", freeMap.mapOption);
        HFDevice.screenShot("997_DEMO4");
        hfAssertImgCmp();
    }
}