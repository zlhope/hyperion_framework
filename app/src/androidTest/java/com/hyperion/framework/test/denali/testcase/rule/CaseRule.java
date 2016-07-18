package com.hyperion.framework.test.denali.testcase.rule;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.os.Bundle;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;
import com.hyperion.framework.test.denali.module.common.FreeMapModule;
import com.hyperion.framework.test.denali.module.common.NavigationModule;
import com.hyperion.framework.test.denali.screen.ScreenSetsExt;
import com.hyperion.framework.test.denali.testdata.CN_TestData;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class CaseRule extends ScreenSetsExt {
    public FreeMapModule freeMapModule;
    public NavigationModule navigationModule;
    @Rule
    public TestName testName = new TestName();

    public CaseRule() {
        freeMapModule = new FreeMapModule();
        navigationModule = new NavigationModule();
        initModule();
    }

    public abstract void initModule();

    @BeforeClass
    public static void classSetup() throws Exception {
        setEnv();
        System.out.println("ClassSetup step run!");
    }

    @AfterClass
    public static void classTeardown() throws Exception {
        System.out.println("ClassTeardown step run!");
    }

    public static void setEnv() throws HFObjectNotFoundException, RemoteException {
        Bundle bundle = InstrumentationRegistry.getArguments();
        if (bundle.getString("region") != null) {
            HFVariables.REGION = bundle.getString("region").toLowerCase();
        }
    }

    private Class getTestDataClassByRegion(String region) {
        try {
            return Class.forName(HFVariables.TEST_DATA_PACKAGE + "." +
                    region.toUpperCase() + "_TestData");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return CN_TestData.class;
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getTestData(String field) {
        Class tdc = getTestDataClassByRegion(HFVariables.REGION);
        try {
            return (T) tdc.getField(field).get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
