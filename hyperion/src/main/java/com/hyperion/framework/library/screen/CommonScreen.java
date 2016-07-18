package com.hyperion.framework.library.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;

public class CommonScreen extends Screen {
    public BySelector parentV = By.res(HFVariables.PACKAGE_NAME + ":id/preferenceItem");
    public BySelector avoidLView = By.res(HFVariables.PACKAGE_NAME + ":id/leftCheckPreference");
    public BySelector avoidRView = By.res(HFVariables.PACKAGE_NAME + ":id/rightCheckPreference");
    public BySelector chBox = By.res(HFVariables.PACKAGE_NAME + ":id/preferencesCheckItemBox");
    public BySelector settingSwitch = By.res("android:id/checkbox");
    public BySelector back = By.res(HFVariables.PACKAGE_NAME + ":id/topBarBackButton");
    public BySelector close = By.res(HFVariables.PACKAGE_NAME + ":id/topBarCloseButton");
    public BySelector done = By.res(HFVariables.PACKAGE_NAME + ":id/topBarCloseButton");
    public BySelector crashPanel = By.res("android:id/parentPanel");
    public BySelector crashPanelOk = By.res("android:id/button1");
    public BySelector nextPage = By.res(HFVariables.PACKAGE_NAME + ":id/side_scroll_next_button");
    public BySelector previousPage = By.res(HFVariables.PACKAGE_NAME + ":id/side_scroll_previous_button");
    public BySelector zoomLevel = By.res(HFVariables.PACKAGE_NAME + ":id/commonMapSurfaceView");
    public BySelector zoomIn = By.res(HFVariables.PACKAGE_NAME + ":id/zoomInButton");
    public BySelector zoomOut = By.res(HFVariables.PACKAGE_NAME + ":id/zoomOutButton");
    public BySelector locateMeButton = By.res(HFVariables.PACKAGE_NAME + ":id/mapResetButton");
    public BySelector automationFlag = By.res(HFVariables.PACKAGE_NAME + ":id/automationTestButton");
    public BySelector categoryViewer = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryViewPager");
    public BySelector nonPageViewer = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryNonPagedView");
    public BySelector pageViewer = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryViewPager");
    public BySelector categoryText = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryItemText");
    public BySelector hotCateBoard = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryBoard");
    public BySelector subCategoryView = By.res(HFVariables.PACKAGE_NAME + ":id/hotSubCategoryRightList");
    public BySelector parking = By.desc("poiParking");
    public BySelector TAC = By.res(HFVariables.PACKAGE_NAME + ":id/tacOptionTacCheckBox");
    public BySelector Privacy = By.res(HFVariables.PACKAGE_NAME + ":id/tacOptionPrivacyCheckBox");
    public BySelector option = By.res(HFVariables.PACKAGE_NAME + ":id/tacOptionOptInCheckBox");
    public BySelector accept = By.res(HFVariables.PACKAGE_NAME + ":id/tacAccept");
    public BySelector decline = By.res(HFVariables.PACKAGE_NAME + ":id/tacDecline");
    public BySelector FTUEArrow = By.res(HFVariables.PACKAGE_NAME + ":id/ftueArrow");
    public BySelector predictNavOff = By.res(HFVariables.PACKAGE_NAME + ":id/ftuePredictNavButton2");
    public BySelector autoUpdate = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogCheckBox");
    public BySelector sdCardPopup = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogTopPanel");
    public BySelector confirm = By.res(HFVariables.PACKAGE_NAME + ":id/button3");
    public BySelector alertPopup = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogTopPanel");
    public BySelector No = By.res(HFVariables.PACKAGE_NAME + ":id/button2");
    public BySelector popup = By.res("android:id/parentPanel");
    public BySelector OK = By.res("android:id/button1");
    public BySelector mapOption = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionButton");
    public BySelector places = By.text("Places");
    public BySelector subCategoryNm = By.res(HFVariables.PACKAGE_NAME + ":id/subCategoryName");
    public BySelector progressBar = By.res(HFVariables.PACKAGE_NAME + ":id/calculatingProgressBar");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("Common CheckScreen run!");
        return true;
    }
}
