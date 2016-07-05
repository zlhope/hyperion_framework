package com.android.hyperion.action;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import com.android.hyperion.screen.*;
import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.screen.CommonScreen;
import com.android.hyperion.screen.FreeMapScreen;


public class ScreenSets extends Action{
    protected FreeMapScreen freeMap;
    protected CommonScreen common;

    public ScreenSets()
    {
        freeMap=new FreeMapScreen(tud);
        common=new CommonScreen(tud);
    }

    protected void initDevice(TnUIADevice tud) {
        this.tud = tud;
    }
}