package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.action.Action;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public abstract class Screen extends Action {
    public BySelector mapPage = By.res(HFVariables.PACKAGE_NAME + ":id/mainMapStaticMap");
    public BySelector parentV = By.res(HFVariables.PACKAGE_NAME + ":id/preferenceItem");
    public BySelector avoidLView = By.res(HFVariables.PACKAGE_NAME + ":id/leftCheckPreference");
    public BySelector avoidRView = By.res(HFVariables.PACKAGE_NAME + ":id/rightCheckPreference");
    public BySelector checkItemBox = By.res(HFVariables.PACKAGE_NAME + ":id/preferencesCheckItemBox");
    public BySelector currentStreet = By.res(HFVariables.PACKAGE_NAME + ":id/glViewCurrentVehicleStreetName");
    public BySelector recenter = By.res(HFVariables.PACKAGE_NAME + ":id/reCenterButton");

    //one box
    public BySelector oneBox = By.res(HFVariables.PACKAGE_NAME + ":id/commonFilterBoxTextView");
    public BySelector clearBtn = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxClearButton");
    public BySelector oneBoxClose = By.res(HFVariables.PACKAGE_NAME + ":id/OneBoxClose");
    public BySelector oneBoxBack = By.res(HFVariables.PACKAGE_NAME + ":id/oneBoxTopBackButton");
    public BySelector oneBoxResult = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxSearchResultItem");
    public BySelector oneBoxSearchList = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxSearchResultListView");

    //recent faves
    public BySelector recent = By.desc("recent");
    public BySelector favorite = By.desc("favorite");

    //side bar
    public BySelector setting = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarSettings");
    public BySelector OneboxEntry = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarSearch");
    public BySelector layer = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarLayer");
    public BySelector sideBarView = By.res(HFVariables.PACKAGE_NAME + ":id/glViewSidebar");
    public BySelector sideBarButton = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarSwitchButton");
    public BySelector sideBarIcon = By.res(HFVariables.PACKAGE_NAME + ":id/sideBarIcon");

    //top bar
    public BySelector topBarTitle = By.res(HFVariables.PACKAGE_NAME + ":id/topBarTitleTextView");
    public BySelector back = By.res(HFVariables.PACKAGE_NAME + ":id/topBarBackButton");
    public BySelector close = By.res(HFVariables.PACKAGE_NAME + ":id/topBarCloseButton");
    public BySelector done = By.res(HFVariables.PACKAGE_NAME + ":id/topBarCloseButton");
    public BySelector edit = By.res(HFVariables.PACKAGE_NAME + ":id/topBarAdditionalButton1");
    public BySelector done2 = By.res(HFVariables.PACKAGE_NAME + ":id/topBarAdditionalButton1");

    //side scroll
    public BySelector nextPage = By.res(HFVariables.PACKAGE_NAME + ":id/side_scroll_next_button");
    public BySelector previousPage = By.res(HFVariables.PACKAGE_NAME + ":id/side_scroll_previous_button");

    //zoom
    public BySelector zoomLevel = By.res(HFVariables.PACKAGE_NAME + ":id/commonMapSurfaceView");
    public BySelector zoomIn = By.res(HFVariables.PACKAGE_NAME + ":id/zoomInButton");
    public BySelector zoomOut = By.res(HFVariables.PACKAGE_NAME + ":id/zoomOutButton");

    public BySelector navBillboard = By.res(HFVariables.PACKAGE_NAME + ":id/movingMap0TitleContainer");
    public BySelector distanceToTurn = By.res(HFVariables.PACKAGE_NAME + ":id/movingMap0TurnDistanceView");

    public BySelector locateMeButton = By.res(HFVariables.PACKAGE_NAME + ":id/mapResetButton");
    public BySelector automationFlag = By.res(HFVariables.PACKAGE_NAME + ":id/automationTestButton");
    public BySelector categoryViewer = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryViewPager");
    public BySelector nonPageViewer = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryNonPagedView");
    public BySelector pageViewer = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryViewPager");
    public BySelector categoryText = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryItemText");
    public BySelector hotCateBoard = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryBoard");
    public BySelector subCategoryView = By.res(HFVariables.PACKAGE_NAME + ":id/hotSubCategoryRightList");
    public BySelector TAC = By.res(HFVariables.PACKAGE_NAME + ":id/tacOptionTacCheckBox");
    public BySelector Privacy = By.res(HFVariables.PACKAGE_NAME + ":id/tacOptionPrivacyCheckBox");
    public BySelector option = By.res(HFVariables.PACKAGE_NAME + ":id/tacOptionOptInCheckBox");
    public BySelector accept = By.res(HFVariables.PACKAGE_NAME + ":id/tacAccept");
    public BySelector decline = By.res(HFVariables.PACKAGE_NAME + ":id/tacDecline");
    public BySelector FTUEArrow = By.res(HFVariables.PACKAGE_NAME + ":id/ftueArrow");
    public BySelector predictNavOff = By.res(HFVariables.PACKAGE_NAME + ":id/ftuePredictNavButton2");
    public BySelector autoUpdate = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogCheckBox");
    public BySelector sdCardPopup = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogTopPanel");
    public BySelector alertPopup = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogTopPanel");
    public BySelector mapOption = By.res(HFVariables.PACKAGE_NAME + ":id/mapOptionButton");
    public BySelector subCategoryNm = By.res(HFVariables.PACKAGE_NAME + ":id/subCategoryName");
    public BySelector progressBar = By.res(HFVariables.PACKAGE_NAME + ":id/calculatingProgressBar");
    public BySelector toastMessage = By.res(HFVariables.PACKAGE_NAME + ":id/toastMessageWithoutTapButton");
    public BySelector alertPanel = By.res(HFVariables.PACKAGE_NAME + ":id/alertDialogButtonPanel");

    public BySelector parking = By.desc("poiParking");
    public BySelector places = By.text("Places");

    public BySelector list = By.res("android:id/list");
    public BySelector summary = By.res("android:id/summary");
    public BySelector title = By.res("android:id/title");
    public BySelector button1 = By.res("android:id/button1");
    public BySelector button2 = By.res("android:id/button2");
    public BySelector button3 = By.res("android:id/button3");
    public BySelector dpButton1 = By.res(HFVariables.PACKAGE_NAME+":id/button1");
    public BySelector dpButton2 = By.res(HFVariables.PACKAGE_NAME+":id/button2");
    public BySelector dpButton3 = By.res(HFVariables.PACKAGE_NAME+":id/button3");

    public BySelector popup = By.res("android:id/parentPanel");
    public BySelector checkBox = By.res("android:id/checkbox");

    public static final String TRAFFIC = "keyTrafficInfoSetting";
    public static final String TRAFFIC_FLOW ="keyTrafficFlowOption";
    public static final String TRAFFIC_ON = "keyTrafficOn";
    public static final String AUTO_ZOOM = "keyEnableAutoZoom";
    public static final String M3D_LANDMARKS = "Show3DLandmarks";
    public static final String M3D_BUILDINGS = "Show3DBuildings";
    public static final String M3D_HEADING = "keySet3DHeadingUp";
    public static final String M2D_HEADING = "keySet2DHeadingUp";
    public static final String M2D_NORTH = "keySet2DNorthUp";
    public static final String EDIT_DEST = "keyEditDestinations";
    public static final String POI_ON_MAP = "keyPOIOnMap";

    public abstract boolean checkScreen() throws HFObjectNotFoundException;
}
