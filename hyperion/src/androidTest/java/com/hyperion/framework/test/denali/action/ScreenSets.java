package com.hyperion.framework.test.denali.action;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import com.hyperion.framework.test.denali.screen.DestEditScreen;
import com.hyperion.framework.test.denali.screen.FavoriteScreen;
import com.hyperion.framework.test.denali.screen.FreeMapScreen;
import com.hyperion.framework.test.denali.screen.HwyExitScreen;
import com.hyperion.framework.test.denali.screen.MapOptionScreen;
import com.hyperion.framework.test.denali.screen.MyPlaceScreen;
import com.hyperion.framework.test.denali.screen.NavigationScreen;
import com.hyperion.framework.test.denali.screen.OneBoxSearchScreen;
import com.hyperion.framework.test.denali.screen.RecentsScreen;
import com.hyperion.framework.test.denali.screen.ResultDetailScreen;
import com.hyperion.framework.test.denali.screen.ResultListScreen;
import com.hyperion.framework.test.denali.screen.RouteEditScreen;
import com.hyperion.framework.test.denali.screen.RouteListScreen;
import com.hyperion.framework.test.denali.screen.RoutePlanScreen;
import com.hyperion.framework.test.denali.screen.RouteSettingScreen;
import com.hyperion.framework.test.denali.screen.SecretScreen;
import com.hyperion.framework.test.denali.screen.SettingScreen;


public class ScreenSets extends Action {
    protected FreeMapScreen freeMap;
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
    protected DestEditScreen destEdit;
    protected MapOptionScreen mapOption;

    public ScreenSets() {
        freeMap = new FreeMapScreen();
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
        destEdit = new DestEditScreen();
        mapOption = new MapOptionScreen();
    }
}