package com.android.hyperion.screen;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import com.android.hyperion.utility.TnUIACommon;
import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIALog;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;

public class CommonScreen extends ScreenRoot{
    public BySelector parentV = By.res(TnUIACommon.PACKAGE_NAME + ":id/preferenceItem");
    public BySelector avoidLView = By.res(TnUIACommon.PACKAGE_NAME + ":id/leftCheckPreference");
    public BySelector avoidRView = By.res(TnUIACommon.PACKAGE_NAME + ":id/rightCheckPreference");
    public BySelector chBox = By.res(TnUIACommon.PACKAGE_NAME + ":id/preferencesCheckItemBox");
    public BySelector settingSwitch = By.res("android:id/checkbox");
    public BySelector back= By.res(TnUIACommon.PACKAGE_NAME + ":id/topBarBackButton");
    public BySelector close = By.res(TnUIACommon.PACKAGE_NAME + ":id/topBarCloseButton");
    public BySelector done = By.res(TnUIACommon.PACKAGE_NAME + ":id/topBarCloseButton");
    public BySelector crashPanel = By.res("android:id/parentPanel");
    public BySelector crashPanelOk = By.res("android:id/button1");
    public BySelector nextPage = By.res(TnUIACommon.PACKAGE_NAME + ":id/side_scroll_next_button");
    public BySelector previousPage = By.res(TnUIACommon.PACKAGE_NAME + ":id/side_scroll_previous_button");
    public BySelector zoomLevel = By.res(TnUIACommon.PACKAGE_NAME + ":id/commonMapSurfaceView");
    public BySelector zoomIn = By.res(TnUIACommon.PACKAGE_NAME + ":id/zoomInButton");
    public BySelector zoomOut = By.res(TnUIACommon.PACKAGE_NAME + ":id/zoomOutButton");
    public BySelector locateMeButton = By.res(TnUIACommon.PACKAGE_NAME + ":id/mapResetButton");
    public BySelector automationFlag = By.res(TnUIACommon.PACKAGE_NAME + ":id/automationTestButton");
    public BySelector categoryViewer = By.res(TnUIACommon.PACKAGE_NAME + ":id/hotCategoryViewPager");
    public BySelector nonPageViewer = By.res(TnUIACommon.PACKAGE_NAME + ":id/hotCategoryNonPagedView");
    public BySelector pageViewer = By.res(TnUIACommon.PACKAGE_NAME + ":id/hotCategoryViewPager");
    public BySelector categoryText= By.res(TnUIACommon.PACKAGE_NAME + ":id/hotCategoryItemText");
    public BySelector hotCateBoard = By.res(TnUIACommon.PACKAGE_NAME + ":id/hotCategoryBoard");
    public BySelector subCategoryView = By.res(TnUIACommon.PACKAGE_NAME + ":id/hotSubCategoryRightList");
    public BySelector parking = By.desc("poiParking");
    public BySelector TAC = By.res(TnUIACommon.PACKAGE_NAME + ":id/tacOptionTacCheckBox");
    public BySelector Privacy = By.res(TnUIACommon.PACKAGE_NAME + ":id/tacOptionPrivacyCheckBox");
    public BySelector option = By.res(TnUIACommon.PACKAGE_NAME + ":id/tacOptionOptInCheckBox");
    public BySelector accept = By.res(TnUIACommon.PACKAGE_NAME + ":id/tacAccept");
    public BySelector decline = By.res(TnUIACommon.PACKAGE_NAME + ":id/tacDecline");
    public BySelector FTUEArrow = By.res(TnUIACommon.PACKAGE_NAME + ":id/ftueArrow");
    public BySelector predictNavOff = By.res(TnUIACommon.PACKAGE_NAME + ":id/ftuePredictNavButton2");
    public BySelector autoUpdate = By.res(TnUIACommon.PACKAGE_NAME + ":id/alertDialogCheckBox");
    public BySelector sdCardPopup = By.res(TnUIACommon.PACKAGE_NAME + ":id/alertDialogTopPanel");
    public BySelector confirm = By.res(TnUIACommon.PACKAGE_NAME + ":id/button3");
    public BySelector alertPopup = By.res(TnUIACommon.PACKAGE_NAME + ":id/alertDialogTopPanel");
    public BySelector No = By.res(TnUIACommon.PACKAGE_NAME + ":id/button2");
    public BySelector popup = By.res("android:id/parentPanel");
    public BySelector OK = By.res("android:id/button1");
    public BySelector mapOption = By.res(TnUIACommon.PACKAGE_NAME + ":id/mapOptionButton");
    public BySelector places = By.text("Places");
    public BySelector subCategoryNm = By.res(TnUIACommon.PACKAGE_NAME + ":id/subCategoryName");
    public BySelector progressBar = By.res(TnUIACommon.PACKAGE_NAME + ":id/calculatingProgressBar");

    public CommonScreen(TnUIADevice tud)
    {
        super(tud);
    }
    @Override
    public boolean checkScreen() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("Common CheckScreen run!");
        return true;
    }
}
