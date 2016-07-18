package com.hyperion.framework.test.denali.suite;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.test.denali.testcase.cases.cn.CN_TestSample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CN_TestSample.class
        }
)

public class ALLSuite {

}