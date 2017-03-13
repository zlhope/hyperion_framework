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
public class Route extends CaseBase {
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
    public void DP_375_CancelRoute() throws Exception {
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("FailedToStartRoute",
                waitForElement(navigation.navBillboard, HFVariables.WAIT_LONG));
        navigationModule.endNavigation();
        hfAssertTrue("FailedToEndTrip",
                waitUtilObjDisappear(navigation.navBillboard));
        hfAssertTrue("FailedToFreeMap",
                freeMap.checkScreen());
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_300_GetRouteInCity() throws Exception {
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("FailedToNavigation", navigation.checkScreen());
        hfAssertTrue("FailedToStartRoute",
                waitForElement(navigation.navBillboard, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToStartRoute",
                mapData.get("poiName").contains(dest));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_296_RoutePlanner() throws Exception {
        mainModule.initiateApp(origin);
        mapData = oneboxSearchModule.getDetailBySearch(dest, 1, 0);
        routePlannerModule.goToRoutePlanner();
        hfAssertTrue("FailedToRoutePlanner", routePlan.checkScreen());
        hfAssertTrue("FailedToFindFastRoute",
                waitForElement(routePlan.option2, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToFindGo",
                waitForElement(routePlan.go, HFVariables.WAIT_LONG));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_325_GetLongRoute() throws Exception {
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("FailedToNavigation1", navigation.checkScreen());
        hfAssertTrue("FailedToNavigation2",
                waitForElement(navigation.navBillboard, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToNavigation3",
                waitForElement(navigation.turnIconNextStView, HFVariables.WAIT_LONG));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_286_FastestRoute() throws Exception {
        mainModule.initiateApp(origin);
        mapData = oneboxSearchModule.getDetailBySearch(dest, 1, 0);
        routePlannerModule.goToRoutePlanner();
        hfAssertTrue("FailedToRoutePlanner", routePlan.checkScreen());
        hfAssertTrue("FailedToFindFastRoute",
                waitForElement(routePlan.option1, HFVariables.WAIT_LONG));
        routePlannerModule.goFromRoutePlanner(1);
        hfAssertTrue("FailedToGoNavigation",
                navigation.checkScreen());
    }
}