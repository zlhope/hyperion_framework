package com.hyperion.framework.test.denali.suite;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.test.denali.testcase.cases.cn.CN_TestSample;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(BATSuite.class)
@Suite.SuiteClasses(
        {
                CN_TestSample.class
        }
)
public class BATSuite {
}