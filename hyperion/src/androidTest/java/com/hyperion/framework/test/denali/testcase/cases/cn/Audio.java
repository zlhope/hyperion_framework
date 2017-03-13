package com.hyperion.framework.test.denali.testcase.cases.cn;

/**
 * Created by Johnny Huang on 2016/4/21
 */

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
public class Audio extends CaseBase {
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
    public void DP_2138_SchoolAlert() throws Exception {
        mainModule.initiateApp(origin);
        settingModule.setSetting(TestData.speedCamera, false);
        settingModule.setSetting(TestData.roadSafety, true);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("IncorrectAudioGuidance",
                navigationModule.waitForAudioText("前方(.*)有学校"));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2101_CountAudioIntersection() throws Exception {
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("IncorrectAudioGuidance1",
                navigationModule.waitForAudioText("前方(.*)左转进入(.*)然后右转"));
        hfAssertTrue("IncorrectAudioGuidance2",
                navigationModule.waitForAudioText("现在左转然后右转"));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2086_HwyToRdWithExitNm() throws Exception {
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("IncorrectAudioGuidance1",
                navigationModule.waitForAudioText("前方(.*)靠[左|右]行驶准备沿(.*)出口离开高速"));
        hfAssertTrue("IncorrectAudioGuidance2",
                navigationModule.waitForAudioText("前方(.*)靠[左|右]行驶沿(.*)出口离开高速(然后[左|右]转)?"));
        hfAssertTrue("IncorrectAudioGuidance3",
                navigationModule.waitForAudioText("靠[左|右]行驶沿(.*)出口离开高速(然后[左|右]转)?"));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2083_HwyTransKeepRight() throws Exception {
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("IncorrectAudioGuidance1",
                navigationModule.waitForAudioText("前方(.*)准备靠右行驶"));
        hfAssertTrue("IncorrectAudioGuidance2",
                navigationModule.waitForAudioText("前方(.*)靠右往(.*)方向行驶"));
        hfAssertTrue("IncorrectAudioGuidance3",
                navigationModule.waitForAudioText("靠右往(.*)方向行驶"));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2072_LRoundaboutWithRdNmAtExit() throws Exception {
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("IncorrectAudioGuidance1",
                navigationModule.waitForAudioText("前方(.*)准备进入环岛沿(.*)个出口离开(.*)"));
        hfAssertTrue("IncorrectAudioGuidance2",
                navigationModule.waitForAudioText("前方(.*)进入环岛沿(.*)出口离开进入(.*)"));
    }

    @Test
    @Category(CN_BAT_TAG.class)
    public void DP_2061_RightTurn() throws Exception {
        mainModule.initiateApp(origin);
        navigationModule.getNavigationBySearch(dest, 1, 0);
        hfAssertTrue("IncorrectAudioGuidance1",
                navigationModule.waitForAudioText("前方(.*)准备右转(.*)请注意变换车道"));
        hfAssertTrue("IncorrectAudioGuidance2",
                navigationModule.waitForAudioText("前方(.*)右转(.*)进入(.*)"));
        hfAssertTrue("IncorrectAudioGuidance3",
                navigationModule.waitForAudioText("现在右转"));
    }
}