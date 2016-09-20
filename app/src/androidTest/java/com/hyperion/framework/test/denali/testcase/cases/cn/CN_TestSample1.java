package com.hyperion.framework.test.denali.testcase.cases.cn;

/**
 * Created by Johnny Huang on 2016/4/21.
 */

import android.os.SystemClock;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFVariables;
import com.hyperion.framework.test.denali.suite.BAT_TAG;
import com.hyperion.framework.test.denali.testcase.rule.CN_CaseRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class CN_TestSample1 extends CN_CaseRule {
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
    public void case1() throws Exception {
        SystemClock.sleep(3000);
        HFLog.addRecordToLog("test case 1");
        uiaAssertTrue("true", true);
    }

    @Test
    @Category(BAT_TAG.class)
    public void case2() throws Exception {
        SystemClock.sleep(3000);
        HFLog.addRecordToLog("test case 2");
        uiaAssertTrue("true", false);
    }
}