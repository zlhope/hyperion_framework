package com.hyperion.framework.test.denali.suite.offboard;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import com.hyperion.framework.test.denali.suite.CN_BAT_TAG;
import com.hyperion.framework.test.denali.testcase.cases.common.Route;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(CN_BAT_TAG.class)
@Suite.SuiteClasses(
        {
                Route.class
        }
)

public class CN_Regression_Suite {

}