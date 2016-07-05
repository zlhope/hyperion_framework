package com.telenav.uia.android.denali.testcase;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.screen.ScreenSetsExt;
import com.telenav.uia.android.denali.module.common.FreeMapModule;
import com.telenav.uia.android.denali.module.common.NavigationModule;
import com.telenav.uia.android.denali.testdata.TnUIATestDataCN;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public class CaseRoot extends ScreenSetsExt {
    public FreeMapModule freeMapModule;
    public NavigationModule navigationModule;
    public TnUIADevice tud;

    public CaseRoot() {
        tud = new TnUIADevice(TnUIACommon.PACKAGE_NAME);
        TnUIADevice.getDevice();
        super.initDevice(tud);
        freeMapModule = new FreeMapModule(tud);
        navigationModule = new NavigationModule(tud);
    }

    @BeforeClass
    public static void classSetup() throws Exception {
        setEnv();
        if (Build.VERSION.SDK_INT >= 23)
        {
            TnUIADevice.allowWritePermission();
        }
        System.out.println("ClassSetup step!");
    }

    @AfterClass
    public static void classTeardown() throws Exception {
        System.out.println("ClassTeardown step!");
    }

    @Rule
    public TestName testName = new TestName();

    public static void setEnv() throws TnUIAObjectNotFoundException, RemoteException {
        Bundle bundle = InstrumentationRegistry.getArguments();
        if (bundle.getString("region") != null) {
            TnUIACommon.REGION=bundle.getString("region").toLowerCase();
        }
    }

    private Class getTestDataClassByRegion(String region) {
        try {
            return Class.forName(TnUIACommon.TEST_DATA_PACKAGE + region.toUpperCase());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return TnUIATestDataCN.class;
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getTestData(String field) {
        Class tdc = getTestDataClassByRegion(TnUIACommon.REGION);
        try {
            return (T)tdc.getField(field).get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
