package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class ResultDetailScreen extends Screen {
    public BySelector resultDetailView = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailContainerView");
    public BySelector call = By.res(HFVariables.PACKAGE_NAME + ":id/phoneIcon");
    public BySelector driveText = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailDriveText");
    public BySelector driveBox = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailDriveContainer");
    public BySelector drive = By.res(HFVariables.PACKAGE_NAME + ":id/driveIcon");
    public BySelector itemCategory = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemCategoryTextView");
    public BySelector city = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailCity");
    public BySelector address = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailAddress");
    public BySelector distance = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailDistanceTextView");
    public BySelector distanceInCate = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailDistanceInCategoryLine");
    public BySelector entityName = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailName");
    public BySelector reportIssue = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailFeedbackContainer");
    public BySelector sendIssue = By.res(HFVariables.PACKAGE_NAME + ":id/feedbackSendButton");
    public BySelector openStatus = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailOpenStatus");
    public BySelector catePrice = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailCategoryPrice");
    public BySelector openHour = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailOpenHour");
    public BySelector routeOptions = By.res(HFVariables.PACKAGE_NAME + ":id/routeOptionIcon");
    public BySelector favoriteText = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailFavoriteTextView");
    public BySelector favorite = By.res(HFVariables.PACKAGE_NAME + ":id/favoriteIcon");
    public BySelector callText = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailPhoneTextView");
    public BySelector OK = button3;
    public BySelector reviewText = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailReviewTextView");
    public BySelector wpView = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointButtonContainer");
    public BySelector gasPrice = By.res(HFVariables.PACKAGE_NAME + ":id/gasPriceValue");
    public BySelector parkingPrice = By.res(HFVariables.PACKAGE_NAME + ":id/parkingPrice");
    public BySelector maxWpMsg = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogMessage");
    public BySelector wpETE = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointTimeText");
    public BySelector newETE = By.res(HFVariables.PACKAGE_NAME + ":id/newDestinationTimeText");
    public BySelector totalETE = By.res(HFVariables.PACKAGE_NAME + ":id/entityDetailETA");
    public BySelector newDest = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointMakeNewText");
    public BySelector cancel = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointCancel");
    public BySelector addWp = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointAddText");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("Detail")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
