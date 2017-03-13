package com.hyperion.framework.test.denali.testcase.cases;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;

import com.hyperion.framework.test.denali.action.ScreenSets;
import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.module.ModuleFactory;
import com.hyperion.framework.test.denali.module.common.FavoriteModule;
import com.hyperion.framework.test.denali.module.common.FreeMapModule;
import com.hyperion.framework.test.denali.module.common.NavigationModule;
import com.hyperion.framework.test.denali.module.common.OneBoxSearchModule;
import com.hyperion.framework.test.denali.module.common.RecentsModule;
import com.hyperion.framework.test.denali.module.common.RoutePlannerModule;
import com.hyperion.framework.test.denali.module.common.SettingModule;
import com.hyperion.framework.test.denali.module.common.WayPointModule;
import com.hyperion.framework.test.denali.testdata.CN_TestData;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;
import com.hyperion.framework.test.denali.utils.ServerHandler;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.HashMap;

public class CaseBase extends ScreenSets {
    private static ArrayList<String> results;
    public HashMap<String, String> param = new HashMap<>();
    public HashMap<String, String> mapData = new HashMap<>();
    public String origin, dest;

    public Module mainModule;
    public FreeMapModule freeMapModule;
    public NavigationModule navigationModule;
    public OneBoxSearchModule oneboxSearchModule;
    public FavoriteModule favoriteModule;
    public RecentsModule recentsModule;
    public RoutePlannerModule routePlannerModule;
    public WayPointModule wayPointModule;
    public SettingModule settingModule;

    @Rule
    public TestName testName = new TestName();

    public CaseBase() {
        initModule();
        overrideModuleByRegion();
    }

    private void initModule(){
        mainModule = new Module(this);
        freeMapModule = new FreeMapModule(this);
        navigationModule = new NavigationModule(this);
        oneboxSearchModule = new OneBoxSearchModule(this);
        settingModule = new SettingModule(this);
        favoriteModule = new FavoriteModule(this);
        recentsModule = new RecentsModule(this);
        routePlannerModule = new RoutePlannerModule(this);
        settingModule = new SettingModule(this);
        wayPointModule = new WayPointModule(this);
    }

    private void overrideModuleByRegion(){
        ModuleFactory moduleFactory = new ModuleFactory();
        freeMapModule = (FreeMapModule) moduleFactory.reInitModule(freeMapModule, this);
        oneboxSearchModule = (OneBoxSearchModule) moduleFactory.reInitModule(oneboxSearchModule, this);
        navigationModule = (NavigationModule) moduleFactory.reInitModule(navigationModule, this);
        settingModule = (SettingModule) moduleFactory.reInitModule(settingModule, this);
        routePlannerModule = (RoutePlannerModule) moduleFactory.reInitModule(routePlannerModule, this);
    }

    @BeforeClass
    public static void classSetup() throws Exception {
        results = new ArrayList<>();
        setEnv();
        if (Build.VERSION.SDK_INT >= 23)
        {
            HFDevice.allowWritePermission();
        }
        System.out.println("ClassSetup step run!");
    }

    @AfterClass
    public static void classTeardown() throws Exception {
        ServerHandler.uploadResultByClass(results);
        if(HFVariables.RUN_BY_TRIGGER){
            for(int i = 0; i<5 ; i++){
                SystemClock.sleep(HFVariables.WAIT_SHORT);
                HFDevice.startPackage(HFVariables.FRAMEWORK_APP_PACKAGE_NAME);
                if(HFDevice.showAppInFront(HFVariables.FRAMEWORK_APP_PACKAGE_NAME)){
                    System.out.println("Start Test UI Successfully");
                    break;
                }else{
                    System.out.println("Start Test UI failed, try: " + (i+1));
                }
            }
            SystemClock.sleep(HFVariables.WAIT_LONG);
        }
        System.out.println("ClassTeardown step run!");
    }

    @SuppressWarnings("all")
    private static void setEnv() throws HFObjectNotFoundException, RemoteException {
        Bundle bundle = InstrumentationRegistry.getArguments();
        if (bundle.getString("region") != null) {
            HFVariables.REGION = bundle.getString("region").toLowerCase();
        }
        if (bundle.getString("trigger") != null) {
            HFVariables.RUN_BY_TRIGGER = Boolean.parseBoolean(bundle.getString("trigger"));
            if(HFVariables.RUN_BY_TRIGGER){
                HFVariables.RUN_TYPE = "DEBUG";
            }
        }
        if (bundle.getString("type") != null) {
            HFVariables.RUN_TYPE = bundle.getString("type");
        }
    }

    protected void initTestData() throws Exception{
        param.clear();
        mapData.clear();
        HFVariables.TIMEOUT_CHECK_START=System.currentTimeMillis();
        String caseName = HFVariables.TEST_CASE_NAME;
        String caseID;
        try {
            caseID = caseName.split("_")[1];
        }catch (Exception e){
            HFLog.logMessage("Cannot find case id by case name!");
            throw new HFObjectNotFoundException("INIT_TEST_DATA_FAILED");
        }
        String ret = null;
        HFLog.logMessage("Case id: " + caseID);
        if(caseID.equals("3")) {
            ret = ServerHandler.getTestDataFromServer(caseID);
            HFLog.logMessage("Test data: " + ret);
            if(ret != null){
                origin = ret.split("\\|")[0];
                dest = ret.split("\\|")[1];
                return;
            }
        }
        origin = getTestData("tc" + caseID + "origin");
        dest = getTestData("tc" + caseID + "dest");
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
    public  <T> T getTestData(String field) throws Exception{
        Class tdc = getTestDataClassByRegion(HFVariables.REGION);
        try {
            return (T) tdc.getField(field).get(null);
        } catch (Exception e) {
            HFLog.logMessage("Field [" + field + "] is not found for region [" + HFVariables.REGION + "]!");
        }
        return null;
    }

    @Rule
    public TestWatcher watchman= new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            String detail = e.getMessage();
            if(detail.contains(":ScreenShot=")){
                try {
                    detail = detail.split(":ScreenShot=")[0] +
                            ":ScreenShot=" + detail.split(":ScreenShot=")[1].split("_")[1];
                }catch (Exception ex){
                    HFLog.logMessage("Add case log failed!");
                    HFLog.logMessage(detail);
                }
            }
            String data = getPartData() +
                    "&result=failed&detail=" + detail;
            results.add(data);
        }

        @Override
        protected void succeeded(Description description) {
            String data = getPartData() + "&result=passed";
            results.add(data);
        }

        private String getPartData(){
            return "case_name=" + HFVariables.TEST_CASE_NAME +
                    "&devices=" + Build.SERIAL +
                    "&mode=" + ServerHandler.getTestMode() +
                    "&type=" + HFVariables.RUN_TYPE;
        }
    };
}
