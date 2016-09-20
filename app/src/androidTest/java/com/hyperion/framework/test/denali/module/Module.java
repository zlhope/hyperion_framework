package com.hyperion.framework.test.denali.module;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.screen.Screen;
import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.screen.ScreenSetsExt;

import java.util.ArrayList;
import java.util.HashMap;

public class Module extends ScreenSetsExt {
    protected HashMap<String, String> moduleDataMap = new HashMap<String, String>();
    protected ArrayList<String> moduleDataList = new ArrayList<String>();
}
