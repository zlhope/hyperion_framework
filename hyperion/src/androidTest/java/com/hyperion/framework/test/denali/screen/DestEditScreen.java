package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class DestEditScreen extends Screen {
    public BySelector subCategoryNm = By.res(HFVariables.PACKAGE_NAME + ":id/subCategoryName");
    public BySelector wpEntry  = By.res(HFVariables.PACKAGE_NAME+":id/topBarTitleTab2");
    public BySelector editWaypointScreenId = By.res(HFVariables.PACKAGE_NAME+":id/editWayPointContainerView");
    public BySelector wpListView = By.res(HFVariables.PACKAGE_NAME+":id/wayPointListEdit");
    public BySelector vHeadingIcon  = By.res(HFVariables.PACKAGE_NAME+":id/currentLocationIcon");
    public BySelector wpTextView  = By.res(HFVariables.PACKAGE_NAME+":id/wayPointListItemMainTextView");
    public BySelector wpDistAddrView  = By.res(HFVariables.PACKAGE_NAME+":id/wayPointListItemDistanceTextView");
    public BySelector totalView  = By.res(HFVariables.PACKAGE_NAME+":id/waypointLabel");
    public BySelector wpItem  = By.res(HFVariables.PACKAGE_NAME + ":id/dragListItem");
    public BySelector wpDeleteBtn  = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointDeleteButton");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("EditDestinations")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }




}
