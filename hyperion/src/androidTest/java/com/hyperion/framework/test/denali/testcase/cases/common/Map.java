package com.hyperion.framework.test.denali.testcase.cases.common;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.test.denali.suite.CN_BAT_TAG;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Map extends CaseBase {
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
    public void DP_997_HomeWorkSetup() throws Exception {
        String home = getTestData("tc997home");
        String work = getTestData("tc997work");
        mainModule.initiateApp(origin);
        settingModule.clearHomeWork();
        freeMapModule.setWorkHomeAtFreeMap("home", home);
        freeMapModule.setWorkHomeAtFreeMap("work", work);
        freeMapModule.tapVehicleMenu("home");
        navigationModule.waitForToastMessage(1);
        hfAssertTrue("FailedToGoHome",
                navigation.checkScreen());
        navigationModule.endNavigation();
        freeMapModule.tapVehicleMenu("work");
        navigationModule.waitForToastMessage(1);
        hfAssertTrue("FailedToGoWork",
                navigation.checkScreen());
    }
}