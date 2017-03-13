package com.hyperion.framework.test.denali.module;

import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFVariables;

import java.lang.reflect.Constructor;

/**
 * Created by Johnny Huang on 2016/1/21
 */

public class ModuleFactory {

    @SuppressWarnings("all")
    public Object reInitModule(Object module , Object param){
        String moduleName = "Unknown";
        try {
            moduleName = module.getClass().getSimpleName();
            Constructor cons[] = getModuleClassByRegion(HFVariables.REGION, moduleName).
                    getConstructors();
            module = cons[0].newInstance(new Object[]{param});
        }catch (Exception e){
            HFLog.logMessage("ReInitModule [" + moduleName + "] failed!");
        }
        return module;
    }

    private Class getModuleClassByRegion(String region, String moduleName) {
        try {
            return Class.forName(HFVariables.TEST_MODULE_PACKAGE + "." +
                    region.toLowerCase() + "." +region.toUpperCase()+"_"+moduleName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            HFLog.logMessage("Get class [" + moduleName + "] failed!");
            return null;
        }
    }
}
