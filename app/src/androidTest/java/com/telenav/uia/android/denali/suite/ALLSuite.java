package com.telenav.uia.android.denali.suite;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import com.telenav.uia.android.denali.testcase.cn.TestSampleCN;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestSampleCN.class
        }
)

public class ALLSuite {

}