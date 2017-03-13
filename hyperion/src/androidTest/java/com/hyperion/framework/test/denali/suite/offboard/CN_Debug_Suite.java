package com.hyperion.framework.test.denali.suite.offboard;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import com.hyperion.framework.test.denali.testcase.cases.prototype.Demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                Demo.class,
        }
)
public class CN_Debug_Suite {
}