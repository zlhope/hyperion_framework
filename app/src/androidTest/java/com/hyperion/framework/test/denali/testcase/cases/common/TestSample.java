package com.hyperion.framework.test.denali.testcase.cases.common;

/**
 * Created by Johnny Huang on 2016/4/21.
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFVariables;
import com.hyperion.framework.test.denali.suite.BAT_TAG;
import com.hyperion.framework.test.denali.testcase.rule.COM_CaseRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestSample extends COM_CaseRule {
    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
        hfd.restartApp();
        //freeMapModule.waitForFreeMap();
    }

    @After
    public void testTeardown() {
    }

    @Test
    @Category(BAT_TAG.class)
    public void commonCase1() throws Exception {
        HFLog.addRecordToLog("Common case 1");
        uiaAssertTrue("true", true);
    }

    @Test
    @Category(BAT_TAG.class)
    public void commonCase2() throws Exception {
        HFLog.addRecordToLog("Common case 2");
        uiaAssertTrue("true", false);
    }

    @Test
    public void commonCase3() throws Exception {
        HFLog.addRecordToLog("Common case 3");
        uiaAssertTrue("true", false);
    }
}