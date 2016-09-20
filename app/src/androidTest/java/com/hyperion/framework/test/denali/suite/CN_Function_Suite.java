package com.hyperion.framework.test.denali.suite;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.test.denali.testcase.cases.cn.CN_TestSample1;
import com.hyperion.framework.test.denali.testcase.cases.cn.CN_TestSample2;
import com.hyperion.framework.test.denali.testcase.cases.common.TestSample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CN_TestSample1.class,
                CN_TestSample2.class,
                TestSample.class
        }
)

public class CN_Function_Suite {

}