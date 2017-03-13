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
public class OffBoard extends CaseBase {
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
    public void DP_1104_GasPrice() throws Exception {
        mainModule.initiateApp(origin);
        oneboxSearchModule.getResultListBySearch(dest, 2);
        hfAssertTrue("FailedToCheckGasPrice",
                oneboxSearchModule.checkResultHasPrice());
    }

    @Test
    public void DP_1101_RichDataPOI() throws Exception {
        mainModule.initiateApp(origin);
        oneboxSearchModule.getDetailBySearch(dest, 1, 0);
        hfAssertTrue("POIDetailTapNextPageFailed",
                clickIfExist(resultDetail.nextPage));
        hfAssertTrue("POIDetailCheckRichDataFailed1",
                waitForElement(resultDetail.openHour, HFVariables.WAIT_LONG));
        hfAssertTrue("POIDetailCheckRichDataFailed1",
                waitForElement(resultDetail.openStatus, HFVariables.WAIT_LONG));
        hfAssertTrue("POIDetailCheckRichDataFailed1",
                waitForElement(resultDetail.catePrice, HFVariables.WAIT_LONG));
    }
}