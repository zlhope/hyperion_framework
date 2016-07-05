package com.telenav.uia.android.denali.module.na;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.module.common.NavigationModule;


public class NavigationModuleNA extends NavigationModule {

    public NavigationModuleNA(TnUIADevice tud)
    {
        super(tud);
    }

    public Boolean goToNavigation() throws TnUIAObjectNotFoundException {
        return false;
    }
}
