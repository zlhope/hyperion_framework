package com.hyperion.framework.test.denali.testcase.cases.cn;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.test.denali.suite.CN_BAT_TAG;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.TestData;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Guidance extends CaseBase {
    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
        initTestData();
    }

    @After
    public void testTeardown() {
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2235_ServiceAreaInfo() throws Exception {
        mainModule.initiateApp(origin);
        settingModule.setSetting(TestData.highway, false);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        navigationModule.getHwyExitList();
        hfAssertTrue("FailedToGetHwyExitList1", hwyExit.checkScreen());
        hfAssertTrue("FailedToGetHwyExitList2",
                clickIfExist(hwyExit.gasPOI, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToGetHwyExitList3", objExist(hwyExit.shieldIcon));
        hfAssertTrue("FailedToGetHwyExitList4", objExist(hwyExit.exitDistance));
        hfAssertMatches("FailedToGetHwyExitList5", getText(hwyExit.exitLabel), "服务区|加油站");
        hfAssertTrue("FailedToGetHwyExitList6",
                hwyExit.checkScreen());
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2234_HwyExitInfo() throws Exception {
        mainModule.initiateApp(origin);
        settingModule.setSetting(TestData.highway, false);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        navigationModule.getHwyExitList();
        hfAssertTrue("FailedToGetHwyExitList1", hwyExit.checkScreen());
        hfAssertTrue("FailedToGetHwyExitList2", objExist(hwyExit.shieldIcon));
        hfAssertTrue("FailedToGetHwyExitList3", objExist(hwyExit.exitDistance));
        hfAssertTrue("FailedToGetHwyExitList4", objExist(hwyExit.exitLabel));
        hfAssertTrue("FailedCheckPoiIcon", !objExist(hwyExit.exitContainer));
        hfAssertTrue("FailedToGetHwyExitList5",
                clickIfExist(hwyExit.exitLabel));
        hfAssertTrue("FailedToGetHwyExitList6",
                hwyExit.checkScreen());
    }
}