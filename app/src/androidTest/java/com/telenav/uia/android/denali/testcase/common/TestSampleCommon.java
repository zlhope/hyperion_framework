package com.telenav.uia.android.denali.testcase.common;

/**
 * Created by Johnny Huang on 2016/4/21.
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.android.hyperion.utility.TnUIACommon;
import com.telenav.uia.android.denali.module.cn.FreeMapModuleCN;
import com.telenav.uia.android.denali.suite.BATSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestSampleCommon extends CaseRootCommon {
    @Before
    public void testSetup() throws Exception {
        TnUIACommon.TEST_CASE_NAME=testName.getMethodName();
        tud.restartApp();
        freeMapModule.waitForMainPage();
    }

    @After
    public void testTeardown() {
    }

    @Test
    @Category(BATSuite.class)
    public void DP1MY18_1129_SearchHideInStationaryMode() throws Exception {
        clickIfExist(freeMap.sideBarButton);
        uiaAssertTrue("objExist(freeMap.oneBoxEditText)", objExist(freeMap.oneBoxEditText));
        click(freeMap.close);
        waitUtilObjDisappear(freeMap.oneBoxEditText);
        uiaAssertTrue("checkScreen(oneBoxSearch)", freeMapModule.logic1());
        freeMapModule.logic2();
        uiaAssertTrue("checkScreen(oneBoxSearch)", freeMap.checkScreen());
        uiaAssertTrue("checkScreen(oneBoxSearch)", navigationModule.commonLogic());
    }
}