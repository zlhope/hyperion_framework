package com.hyperion.framework.test.denali.testcase.cases.prototype;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Demo extends CaseBase {

    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
        //initTestData();
    }

    @After
    public void testTeardown() {
    }

//    @BeforeClass
//    public static void classSetup() throws Exception {
//        CaseBase.classSetup();
//        wifiStatus = HFDevice.openWifi();
//    }
//
//    @AfterClass
//    public static void classTeardown() throws Exception {
//        CaseBase.classTeardown();
//        if(!wifiStatus) {
//            HFDevice.closeWifi();
//        }
//    }

    @Test
    public void Demo1() throws Exception {
        hfAssertTrue("FailedCaseDemo1", false);
    }

    @Test
    public void Demo2() throws Exception {
        HFVariables.IS_FIRST_RUN = true;
    }

    @Test
    public void Demo3() throws Exception {
        hfAssertEqual("FailedCaseDemo2", 1, 0);
    }

    @Test
    public void Demo4() throws Exception {
        click(freeMap.close);
    }
}