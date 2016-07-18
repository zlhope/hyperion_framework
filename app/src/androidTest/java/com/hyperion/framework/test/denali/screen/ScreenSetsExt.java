package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.action.ScreenSets;

public class ScreenSetsExt extends ScreenSets {
    protected DIYScreen diyScreen;

    public ScreenSetsExt() {
        diyScreen = new DIYScreen();
    }
}