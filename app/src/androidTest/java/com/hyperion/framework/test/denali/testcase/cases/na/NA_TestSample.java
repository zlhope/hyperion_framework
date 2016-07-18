package com.hyperion.framework.test.denali.testcase.cases.na;

/**
 * Created by Johnny Huang on 2016/4/21.
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.library.utils.HFVariables;
import com.hyperion.framework.test.denali.suite.BATSuite;
import com.hyperion.framework.test.denali.testcase.rule.NA_CaseRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class NA_TestSample extends NA_CaseRule {
    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
        hfd.restartApp();
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
        freeMapModule.logic4();
        uiaAssertTrue("checkScreen(oneBoxSearch)", freeMap.checkScreen());
        uiaAssertTrue("checkScreen(oneBoxSearch)", navigationModule.commonLogic());
    }
}