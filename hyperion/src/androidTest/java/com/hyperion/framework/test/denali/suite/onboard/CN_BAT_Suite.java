package com.hyperion.framework.test.denali.suite.onboard;
/**
 * Created by Johnny Huang on 2016/1/21
 */
import com.hyperion.framework.test.denali.suite.CN_BAT_TAG;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(CN_BAT_TAG.class)
@Suite.SuiteClasses(
        {
                com.hyperion.framework.test.denali.testcase.cases.common.Route.class,
                com.hyperion.framework.test.denali.testcase.cases.common.Guidance.class,
                com.hyperion.framework.test.denali.testcase.cases.common.Map.class,
                com.hyperion.framework.test.denali.testcase.cases.common.Search.class,
                com.hyperion.framework.test.denali.testcase.cases.cn.Search.class,
                com.hyperion.framework.test.denali.testcase.cases.cn.Audio.class,
                com.hyperion.framework.test.denali.testcase.cases.cn.Guidance.class
        }
)
public class CN_BAT_Suite {
}