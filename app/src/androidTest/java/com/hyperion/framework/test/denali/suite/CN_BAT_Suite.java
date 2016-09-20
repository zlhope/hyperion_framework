package com.hyperion.framework.test.denali.suite;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.test.denali.testcase.cases.cn.*;
import com.hyperion.framework.test.denali.testcase.cases.common.*;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(BAT_TAG.class)
@Suite.SuiteClasses(
        {
                CN_TestSample1.class,
                CN_TestSample2.class,
                TestSample.class
        }
)
public class CN_BAT_Suite {
}