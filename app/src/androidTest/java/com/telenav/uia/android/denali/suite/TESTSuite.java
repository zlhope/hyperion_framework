package com.telenav.uia.android.denali.suite;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import com.telenav.uia.android.denali.testcase.cn.TestSampleCN;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses(
        {
                TestSampleCN.class
        }
)
public class TESTSuite {
}