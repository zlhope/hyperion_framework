package com.hyperion.framework.test.denali.testcase.cases.common;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.os.SystemClock;
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
    public void DP_695_DemoRoute() throws Exception {
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("FailedToNavigation1", navigation.checkScreen());
        hfAssertTrue("FailedToNavigation2",
                waitForElement(navigation.navBillboard, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToNavigation3",
                waitForElement(navigation.turnIconNextStView, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToNavigation4", navigationModule.checkRouteStart());
        hfAssertTrue("FailedToCheckETEETA",navigationModule.checkETEETAFormat());
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_418_ETEToDest() throws Exception {
        int minETE = getTestData("tc418minETE");
        int maxETE = getTestData("tc418maxETE");
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("FailedToNavigation", navigation.checkScreen());
        hfAssertTrue("ETEValueIncorrect", navigationModule.compareETERange(maxETE, minETE));
        navigationModule.waitForDestArrival();
        hfAssertTrue("FailedToFreeMap", freeMap.checkScreen());
        hfAssertTrue("ETAStillExist", !objExist(navigation.ETA));
        hfAssertTrue("ETEStillExist", !objExist(navigation.ETE));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_136_JunctionViewDisplay() throws Exception {
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("JunctionViewNotShown",
                waitForElement(navigation.junctionView, HFVariables.WAIT_LONG * 3));
        hfAssertTrue("JunctionViewAlwaysExists",
                waitUtilObjDisappear(navigation.junctionView, HFVariables.WAIT_LONG * 3));
        hfAssertTrue("FailedBackToNavigation1", navigation.checkScreen());
        hfAssertTrue("FailedBackToNavigation2",
                waitForElement(navigation.navBillboard, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedBackToNavigation3",
                waitForElement(navigation.turnIconNextStView, HFVariables.WAIT_LONG));
    }

    @Test
     @Category(CN_BAT_TAG.class)
     public void DP_942_LaneNumber() throws Exception {
        int num = getTestData("tc942number");
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("LaneGuidanceNotShown",
                waitForElement(navigation.laneGuidance, HFVariables.WAIT_LONG * 3));
        hfAssertEqual("LaneNumberIncorrect",
                listObjsGetChildCount(navigation.laneGuidance, navigation.turnIcon), num);
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_362_StartRouteFromOverview() throws Exception {
        mainModule.initiateApp(origin);
        mapData = oneboxSearchModule.getDetailBySearch(dest, 2, 0);
        routePlannerModule.goToRoutePlanner();
        hfAssertTrue("FailedToRoutePlanner", routePlan.checkScreen());
        routePlannerModule.goFromRoutePlanner(2);
        hfAssertTrue("FailedToNavigation", navigationModule.checkRouteStart());
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_635_RouteListDisplay() throws Exception {
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        navigationModule.getRouteList();
        hfAssertTrue("FailedToGetRouteList1", objExist(routeList.itemView));
        hfAssertTrue("FailedToGetRouteList2", objExist(routeList.rlTurnIcon));
        hfAssertTrue("FailedToGetRouteList3", objExist(routeList.rlStName));
        hfAssertTrue("FailedToGetRouteList4", objExist(routeList.rlStLength));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1060_WaypointEditView() throws Exception {
        String wp = getTestData("tc1060wp");
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        mapData = wayPointModule.addWayPointBySearchNearDest(wp, 2, 0);
        wayPointModule.addWayPointBySearchNearDest(wp, 2, 1);
        hfAssertTrue("FailedToNavigation", navigation.checkScreen());
        settingModule.goToDestEdit();
        hfAssertTrue("FailedToDestEdit1",
                waitForElement(destEdit.wpListView, HFVariables.WAIT_LONG));
        hfAssertEqual("FailedToCheckDestCount1",
                listObjsGetChildCount(destEdit.wpListView), 3);
        String wpName = mapData.get("poiName");
        settingModule.moveDestItem(wpName, false);
        SystemClock.sleep(HFVariables.WAIT_SHORT);
        settingModule.moveDestItem(wpName, true);
        SystemClock.sleep(HFVariables.WAIT_SHORT);
        settingModule.backToNavigationFromDestEdit();
        settingModule.deleteDest(wpName);
        settingModule.goToDestEdit();
        hfAssertTrue("FailedToDestEdit2",
                waitForElement(destEdit.wpListView, HFVariables.WAIT_LONG));
        hfAssertEqual("FailedToCheckDestCount2",
                listObjsGetChildCount(destEdit.wpListView), 2);
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_404_SubPanelTightTurn() throws Exception {
        String turnType = getTestData("tc404turnType");
        String street = getTestData("tc404street");
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("FailedToShowTightTurn1",
                waitForElement(navigation.tightTurn, HFVariables.WAIT_LONG * 6));
        hfAssertEqual("FailedToCheckTightTurnType",
                turnType, getDesc(navigation.tightTurn));
        hfAssertEqual("FailedToCheckStreet",
                street, getText(navigation.tightTurnSt));
        hfAssertTrue("FailedToShowDistance1",
                objExist(navigation.tightTurnDis));
        navigationModule.getRouteList();
        hfAssertTrue("FailedToShowTightTurn2",
                waitForElement(navigation.tightTurn, HFVariables.WAIT_LONG));
        hfAssertTrue("FailedToShowDistance2",
                objExist(navigation.tightTurnDis));
        hfAssertTrue("FailedToDismissStreet",
                !objExist(navigation.tightTurnSt));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1018_WpSkipToNext() throws Exception {
        String text = getTestData("tc1018driveTo");
        String wp = getTestData("tc1018wp");
        mainModule.initiateApp(origin);
        mapData = navigationModule.getNavigationBySearch(dest, 1, 0);
        wayPointModule.addWayPointBySearch(wp, 1, 0);
        hfAssertTrue("FailedToShowSkip1",
                waitForElement(navigation.skip, HFVariables.WAIT_LONG));
        click(navigation.skip);
        hfAssertEqual("FailedToShowSkip2",
                getText(navigation.driveTo), text + mapData.get("poiName"));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_921_AutoZoomTimingLocal() throws Exception {
        int metric = TestData.autoZoomMatrix;
        mainModule.initiateApp(origin);
        settingModule.setMapMode(TestData.m2DHeading);
        navigationModule.setZoomLevel(1);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        navigationModule.setZoomLevel(4);
        while(navigationModule.getFeetNumber(getText(navigation.distanceToTurn))> metric){
            SystemClock.sleep(50);
        }
        int zoomLvl = navigationModule.getZoomLevel();
        hfAssertEqual("AutoZoomLevelAfter2ndGuidanceIncorrect", zoomLvl, 3);
        String cs = getText(navigation.currentStreet);
        while(cs.equalsIgnoreCase(getText(navigation.currentStreet))){
            SystemClock.sleep(50);
        }
        zoomLvl = navigationModule.getZoomLevel();
        hfAssertEqual("AutoZoomLevelAfter3rdGuidanceIncorrect", zoomLvl, 4);
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_921_AutoZoomTimingLocal2() throws Exception {
        int metric = TestData.autoZoomMatrix;
        mainModule.initiateApp(origin);
        settingModule.setMapMode(TestData.m3DHeading);
        navigationModule.setZoomLevel(1);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        navigationModule.setZoomLevel(4);
        while(navigationModule.getFeetNumber(getText(navigation.distanceToTurn))> metric){
            SystemClock.sleep(50);
        }
        int zoomLvl = navigationModule.getZoomLevel();
        hfAssertEqual("AutoZoomLevelAfter2ndGuidanceIncorrect", zoomLvl, 2);
        String cs = getText(navigation.currentStreet);
        while(cs.equalsIgnoreCase(getText(navigation.currentStreet))){
            SystemClock.sleep(50);
        }
        zoomLvl = navigationModule.getZoomLevel();
        hfAssertEqual("AutoZoomLevelAfter3rdGuidanceIncorrect", zoomLvl, 4);
    }
}