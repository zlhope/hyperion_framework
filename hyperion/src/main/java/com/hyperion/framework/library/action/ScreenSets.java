package com.hyperion.framework.library.action;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.screen.CommonScreen;
import com.hyperion.framework.library.screen.FreeMapScreen;


public class ScreenSets extends Action {
    protected FreeMapScreen freeMap;
    protected CommonScreen common;

    public ScreenSets() {
        freeMap = new FreeMapScreen();
        common = new CommonScreen();
    }
}