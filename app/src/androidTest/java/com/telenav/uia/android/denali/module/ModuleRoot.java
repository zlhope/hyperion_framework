package com.telenav.uia.android.denali.module;

/**
 * Created by Johnny Huang on 2016/1/21.
 */
import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIALog;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;
import com.telenav.uia.android.denali.screen.ScreenSetsExt;


public class ModuleRoot extends ScreenSetsExt{

    public ModuleRoot(TnUIADevice tud) {
        this.tud=tud;
        super.initDevice(tud);
    }

    public boolean commonLogic() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("Parent logic!");
        return freeMap.checkScreen();
    }
}
