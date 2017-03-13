package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class ResultListScreen extends Screen {
    public BySelector sortByDistance = By.res(HFVariables.PACKAGE_NAME + ":id/sortingByDistanceItemButton");
    public BySelector sortByRelevance = By.res(HFVariables.PACKAGE_NAME + ":id/sortingByBestMatchItemButton");
    public BySelector itemCategory = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemCategoryTextView");
    public BySelector progressIcon = By.res(HFVariables.PACKAGE_NAME + ":id/searchResultProgress");
    public BySelector emptyTextView = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxSearchEmptyKeywordTextView");
    public BySelector emptyView = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxSearchEmptyView");
    public BySelector sno = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemNumberTextView");
    public BySelector city = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemCityTextView");
    public BySelector street = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemStreetTextView");
    public BySelector distance = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemDistanceTextView");
    public BySelector resultAddress = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemCityTextView");
    public BySelector resultName = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemNameTextView");
    public BySelector mainText = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemMainTextView");
    public BySelector resultContainer = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxSearchResultContainerView");
    public BySelector nearDest = By.res(HFVariables.PACKAGE_NAME + ":id/segmentNearDestination");
    public BySelector alongRoute = By.res(HFVariables.PACKAGE_NAME + ":id/segmentAlongRoute");
    public BySelector sort = By.res(HFVariables.PACKAGE_NAME + ":id/topBarAdditionalButton1");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("Search")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
