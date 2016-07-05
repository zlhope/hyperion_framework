package com.telenav.uia.android.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.action.ScreenSets;
import com.telenav.uia.android.denali.screen.DIYScreen;

public class ScreenSetsExt extends ScreenSets {
    protected DIYScreen diyScreen;
    public ScreenSetsExt()
    {
        diyScreen=new DIYScreen(tud);
    }
}