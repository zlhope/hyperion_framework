package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class SettingScreen extends Screen {
    public BySelector autoUpdate = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionSwitchButton_update");
    public BySelector routeOption = By.res(HFVariables.PACKAGE_NAME+":id/route_option");
    public BySelector selectLabel = By.res(HFVariables.PACKAGE_NAME+":id/selectLabelButton");
    public BySelector labelTitle = By.res(HFVariables.PACKAGE_NAME + ":id/titleNameText");
    public BySelector keyAddr = By.res(HFVariables.PACKAGE_NAME + ":id/keyAddress");
    public BySelector save = By.res(HFVariables.PACKAGE_NAME+":id/saveText");
    public BySelector doneAtMyPlace = By.res(HFVariables.PACKAGE_NAME + ":id/topBarAdditionalButton1");

    //Map Content Update
    public BySelector navUpdateRestartDialog = By.text("Restart");
    public BySelector navRollbackRestartDialog = By.text("Restart");
    public BySelector updatePopup = By.text("Your local map content is up to date.");
    public BySelector rollbackToast = By.text("Your local map has been rolled back to the previous version.");
    public BySelector rollbackPopup = By.text("Rollback process requires you to restart the navigation app.");
    public BySelector noPreviousVersion = By.text("There is no previous version in your system.");
    public BySelector mapUpdateIssue = By.res(HFVariables.PACKAGE_NAME + "id:/mapUpdateIssueTextView");
    public BySelector rollback = By.res(HFVariables.PACKAGE_NAME + ":id/rollbackButton");
    public BySelector update = By.res(HFVariables.PACKAGE_NAME + ":id/mapUpdateButton");
    public BySelector updating = By.res(HFVariables.PACKAGE_NAME + ":id/mapUpdatingText");
    public BySelector updateIssue = By.res(HFVariables.PACKAGE_NAME + ":id/mapUpdateIssueTextView");
    public BySelector dialogMsg = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogMessage");
    public BySelector autoMapUpdateSwitch = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionSwitchButton_update");
    public BySelector lastUpdateList = By.res(HFVariables.PACKAGE_NAME + ":id/homeAreaPanel");
    public BySelector clearToastMsg = By.res(HFVariables.PACKAGE_NAME + ":id/toastMessage");
    public BySelector settingContent = By.res(HFVariables.PACKAGE_NAME+":id/setting_content");
    public BySelector clearButton = By.res(HFVariables.PACKAGE_NAME+":id/clearButton");
    public BySelector settingScreenID = By.res(HFVariables.PACKAGE_NAME+":id/settingsScreenLinearLayout");
    public BySelector exitApp = button1;
    public BySelector OK = button3;


    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("Initial")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
