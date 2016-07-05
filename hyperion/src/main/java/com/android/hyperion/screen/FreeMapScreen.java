package com.android.hyperion.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.android.hyperion.utility.TnUIACommon;
import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIALog;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;

public class FreeMapScreen extends ScreenRoot{
	public BySelector sideBarView = By.res(TnUIACommon.PACKAGE_NAME + ":id/glViewSidebar");
	public BySelector sideBarButton = By.res(TnUIACommon.PACKAGE_NAME + ":id/sideBarSwitchButton");
	public BySelector sideBarIcon = By.res(TnUIACommon.PACKAGE_NAME + ":id/sideBarIcon");
	public BySelector close = By.res(TnUIACommon.PACKAGE_NAME + ":id/OneBoxClose");
	public BySelector oneBoxEditText = By.res(TnUIACommon.PACKAGE_NAME + ":id/commonFilterBoxTextView");
	public BySelector recent = By.res(TnUIACommon.PACKAGE_NAME + ":id/oneBoxRecent");
	public BySelector setting = By.res(TnUIACommon.PACKAGE_NAME + ":id/mapOptionButtonImage");//Yujie
	public BySelector denaliIcon = By.desc("Denali");
	public BySelector mapScreenIndicator = By.res(TnUIACommon.PACKAGE_NAME + ":id/onebox_fragments_container");
	public BySelector zoomIn = By.res(TnUIACommon.PACKAGE_NAME + ":id/zoomInButton");
	public BySelector zoomOut = By.res(TnUIACommon.PACKAGE_NAME + ":id/zoomOutButton");
	public BySelector locateMeButton = By.desc("Current Location");

	public FreeMapScreen(TnUIADevice tud)
	{
		super(tud);
	}

	@Override
	public boolean checkScreen() throws TnUIAObjectNotFoundException {
		TnUIALog.addRecordToLog("FreeMap CheckScreen run!");
		for(int i = 0; i < 3; i++){
			if(getDesc(mapPage).equals("FreeMap")){
				return true;
			} else {
				SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
			}
		}
		return false;
	}
}
