package com.hyperion.framework.test.denali.testcase.cases.cn;

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
    public void DP_2020_SearchNearDest() throws Exception {
        String input1 = getTestData("tc2020input1");
        String input2 = getTestData("tc2020input2");
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        wayPointModule.addWayPointBySearchNearDest(input1, 2, 0);
        wayPointModule.addNewDestBySearchNearDest(input2, 2, 0);
        hfAssertTrue("FailedToGoNavigation",
                navigation.checkScreen());
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2019_SearchAlongRouteCN() throws Exception {
        String input = getTestData("tc2019input");
        param.put("gps", HFVariables.DEVICE_GPS);
        mainModule.initiateApp(param);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        oneboxSearchModule.getResultListBySearch(input, 2);
        oneboxSearchModule.setResultSortType(true);
        String distance1 = listObjsGetText(resultList.distance, 0);
        String distance2 = listObjsGetText(resultList.distance, 1);
        String distance3 = listObjsGetText(resultList.distance, 2);
        hfAssertTrue("FailedToCheckResultDis1",
                oneboxSearchModule.convertToM(distance1) <=
                        oneboxSearchModule.convertToM(distance2));
        hfAssertTrue("FailedToCheckResultDis2",
                oneboxSearchModule.convertToM(distance2) <=
                        oneboxSearchModule.convertToM(distance3));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1993_SearchXStreetSZM() throws Exception {
        String expect = "(虹梅路吴中路)|(吴中路.*虹梅路.*)#闵行区.*#上海市#";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(dest, 1);
        hfAssertTrue("FailedToCheckSearchResult",
                oneboxSearchModule.checkSearchResult(ret, expect));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1992_SearchXStreet() throws Exception {
        String expect = "(科技二路.*高新六路.*)|(高新六路.*科技二路.*)#雁塔区.*#陕西省西安市#";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(dest, 1);
        hfAssertTrue("FailedToCheckSearchResult",
                oneboxSearchModule.checkSearchResult(ret, expect));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1976_SearchLocalRoadName() throws Exception {
        String expect = "大渡河路.*#普陀区.*#上海市#";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(dest, 1);
        hfAssertTrue("FailedToCheckSearchResult",
                oneboxSearchModule.checkSearchResult(ret, expect));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1967_SearchCityName() throws Exception {
        String expect1 = "杭州市##浙江省杭州市#";
        String expect2 = "苏州市##江苏省苏州市#";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch("杭州", 1);
        hfAssertTrue("FailedToCheckSearchResult",
                oneboxSearchModule.checkSearchResult(ret, expect1));
        click(oneBoxSearch.close);
        ret = oneboxSearchModule.getResultListBySearch("苏州", 1);
        hfAssertTrue("FailedToCheckSearchResult",
                oneboxSearchModule.checkSearchResult(ret, expect2));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1958_SearchCategoryNearBy() throws Exception {
        String expect = ".*停车场.*#长宁区.*#上海市#.*停车场.*";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(dest, 2);
        hfAssertTrue("FailedToCheckSearchResult1",
                oneboxSearchModule.checkSearchResult(ret, expect));
        click(resultList.nextPage);
        hfAssertTrue("FailedToCheckSearchResult2",
                oneboxSearchModule.checkSearchResult(ret, expect));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1957_SearchLandmarksInCountry() throws Exception {
        String input1 = "故宫博物院";
        String input2 = "华山";
        String expect1 = "故宫博物院###.*博物馆.*";
        String expect2 = "华山.*###.*名胜.*";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(input1, 1);
        hfAssertTrue("FailedToCheckSearchResult1",
                oneboxSearchModule.checkSearchResult(ret, expect1));
        click(oneBoxSearch.close);
        ret = oneboxSearchModule.getResultListBySearch(input2, 1);
        hfAssertTrue("FailedToCheckSearchResult2",
                oneboxSearchModule.checkSearchResult(ret, expect2));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1938_SearchBySZM() throws Exception {
        String expect = "东方维京大厦.*##上海.*#";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(dest, 1);
        hfAssertTrue("FailedToCheckSearchResult1",
                oneboxSearchModule.checkSearchResult(ret, expect));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_1935_SearchPOINearBy() throws Exception {
        String expect = "肯德基.*##陕西省西安市.*#快餐";
        mainModule.initiateApp(origin);
        int ret = oneboxSearchModule.getResultListBySearch(dest, 1);
        hfAssertTrue("FailedToCheckSearchResult1",
                oneboxSearchModule.checkSearchResult(ret, expect));
    }
}