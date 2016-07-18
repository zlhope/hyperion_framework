package com.hyperion.framework.test.denali.module.na;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.common.NavigationModule;


public class NA_NavigationModule extends NavigationModule {

    public Boolean goToNavigation() throws HFObjectNotFoundException {
        return false;
    }
}
