package com.hyperion.framework.test.denali.testcase.rule;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.test.denali.module.na.NA_FreeMapModule;

public class NA_CaseRule extends CaseRule {
    public NA_FreeMapModule freeMapModule;

    @Override
    public void initModule()
    {
        freeMapModule = new NA_FreeMapModule();
    }
}
