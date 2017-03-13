package com.hyperion.framework.test.denali.testcase.cases.common;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.hyperion.framework.test.denali.suite.CN_BAT_TAG;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Search extends CaseBase {
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
    public void DP_607_AutoSuggestion() throws Exception {
        mainModule.initiateApp(origin);
        freeMapModule.getOnebox();
        oneboxSearchModule.getAutoSuggestion(dest);
        hfAssertTrue("FailToGetAutoSuggestion", objExist(oneBoxSearch.autoSuggestionListView));
        for(String item : oneboxSearchModule.getAutoSuggestionItem()){
            HFLog.logMessage("Checking item: " + item);
            hfAssertTrue("FailToCheckAutoSuggestion", item.contains(dest));
        }
        listObjsClick(oneBoxSearch.autoSuggestItem, 0);
        hfAssertTrue("FailToGoToSearchList", resultList.checkScreen());
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_854_SearchResultDetail() throws Exception {
        mainModule.initiateApp(origin);
        oneboxSearchModule.getResultListBySearch(dest, 2);
        hfAssertTrue("FailToGetResultList", resultList.checkScreen());
        oneboxSearchModule.getDetail(1);
        hfAssertTrue("FailToGoToPOIDetail1", resultDetail.checkScreen());
        hfAssertTrue("FailToGoToPOIDetail2",
                objExist(resultDetail.driveText, HFVariables.WAIT_LONG * 3));
        hfAssertTrue("FailToGoToPOIDetail3", objExist(resultDetail.entityName));
        hfAssertTrue("FailToGoToPOIDetail4", objExist(resultDetail.distanceInCate));
        hfAssertTrue("FailToGoToPOIDetail5", objExist(resultDetail.driveBox));
        hfAssertTrue("FailToGoToPOIDetail6", objExist(resultDetail.address));
        hfAssertTrue("FailToGoToPOIDetail7", objExist(resultDetail.city));
        hfAssertTrue("FailToGoToPOIDetail8", objExist(resultDetail.favoriteText));
        hfAssertTrue("FailToGoToPOIDetail9", objExist(resultDetail.favorite));
        hfAssertTrue("FailToGoToPOIDetail10", objExist(resultDetail.routeOptions));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_863_SearchResultViewRouteOption() throws Exception {
        mainModule.initiateApp(origin);
        oneboxSearchModule.getDetailBySearch(dest, 1, 0);
        routePlannerModule.goToRoutePlanner();
        hfAssertTrue("FailToGoToRoutePlanner", routePlan.checkScreen());
        routePlannerModule.goFromRoutePlanner(1);
        hfAssertTrue("FailToGoNavigation", navigation.checkScreen());
    }

    @Test
    public void DP_558_SearchHistoryKeyword() throws Exception {
        mainModule.initiateApp(origin);
        settingModule.clearHistory();
        oneboxSearchModule.getDetailBySearch(dest, 1, 0);
        hfAssertTrue("FailToGoToPOIDetail", resultDetail.checkScreen());
        click(resultDetail.close);
        hfAssertTrue("FailToGoToFreeMap", freeMap.checkScreen());
        freeMapModule.getOnebox();
        oneboxSearchModule.getAutoSuggestion(dest);
        hfAssertTrue("FailToGetAutoSuggestion1", objExist(oneBoxSearch.autoSuggestionListView));
        hfAssertEqual("FailToGetAutoSuggestion2", oneboxSearchModule.getAutoSuggestionItem().get(0), dest);
    }
}