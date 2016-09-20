package com.hyperion.framework.library.action;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.screen.CommonScreen;
import com.hyperion.framework.library.screen.FavoriteScreen;
import com.hyperion.framework.library.screen.FreeMapScreen;
import com.hyperion.framework.library.screen.HwyExitScreen;
import com.hyperion.framework.library.screen.MyPlaceScreen;
import com.hyperion.framework.library.screen.NavigationScreen;
import com.hyperion.framework.library.screen.OneBoxSearchScreen;
import com.hyperion.framework.library.screen.RecentsScreen;
import com.hyperion.framework.library.screen.ResultDetailScreen;
import com.hyperion.framework.library.screen.ResultListScreen;
import com.hyperion.framework.library.screen.RouteEditScreen;
import com.hyperion.framework.library.screen.RouteListScreen;
import com.hyperion.framework.library.screen.RoutePlanScreen;
import com.hyperion.framework.library.screen.RouteSettingScreen;
import com.hyperion.framework.library.screen.SecretScreen;
import com.hyperion.framework.library.screen.SettingScreen;
import com.hyperion.framework.library.screen.WpEditScreen;
import com.hyperion.framework.library.screen.WpPopUpScreen;


public class ScreenSets extends Action {
    protected FreeMapScreen freeMap;
    protected CommonScreen common;
    protected FavoriteScreen favorite;
    protected HwyExitScreen hwyExit;
    protected MyPlaceScreen myPlace;
    protected NavigationScreen navigation;
    protected OneBoxSearchScreen oneBoxSearch;
    protected RecentsScreen recents;
    protected ResultDetailScreen resultDetail;
    protected ResultListScreen resultList;
    protected RouteListScreen routeList;
    protected RouteEditScreen routeEdit;
    protected RouteSettingScreen routeSetting;
    protected RoutePlanScreen routePlan;
    protected SecretScreen secret;
    protected SettingScreen setting;
    protected WpEditScreen wpEdit;
    protected WpPopUpScreen wpPopUp;

    public ScreenSets() {
        freeMap = new FreeMapScreen();
        common = new CommonScreen();
        favorite = new FavoriteScreen();
        hwyExit = new HwyExitScreen();
        myPlace = new MyPlaceScreen();
        navigation = new NavigationScreen();
        oneBoxSearch = new OneBoxSearchScreen();
        recents = new RecentsScreen();
        resultDetail = new ResultDetailScreen();
        resultList = new ResultListScreen();
        routeList = new RouteListScreen();
        routeEdit = new RouteEditScreen();
        routeSetting = new RouteSettingScreen();
        routePlan = new RoutePlanScreen();
        secret = new SecretScreen();
        setting = new SettingScreen();
        wpEdit = new WpEditScreen();
        wpPopUp = new WpPopUpScreen();
    }
}