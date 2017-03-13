package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class NavigationScreen extends Screen {

    public BySelector ETA = By.desc("ETA");
    public BySelector ETE = By.desc("ETE");

    public BySelector viewRoute = By.res(HFVariables.PACKAGE_NAME + ":id/glViewMapTrafficIndicator");
    public BySelector routeListBtn = By.res(HFVariables.PACKAGE_NAME + ":id/mapRouteListButton");
    public BySelector mapControlPanel = By.res(HFVariables.PACKAGE_NAME + ":id/glViewMapControlPane");
    public BySelector arrivalScreenPage = By.res(HFVariables.PACKAGE_NAME + ":id/arrivalView");
    public BySelector turnIconNextStView = By.res(HFVariables.PACKAGE_NAME + ":id/movingMap0LaneGuidanceAndTurnContainer");
    public BySelector navScreenID = By.res(HFVariables.PACKAGE_NAME + ":id/fragment_in_nav_container");
    public BySelector navBillboard = By.res(HFVariables.PACKAGE_NAME + ":id/glViewManeuver");
    public BySelector mute = By.res(HFVariables.PACKAGE_NAME + ":id/navigationMuteButton");
    public BySelector turnIcon = By.res(HFVariables.PACKAGE_NAME + ":id/movingMap0TitleTurnIconView");
    public BySelector newRouteView = By.res(HFVariables.PACKAGE_NAME + ":id/dynamicDetailContainer");
    public BySelector trafficInfoIcon = By.res(HFVariables.PACKAGE_NAME + ":id/dynamicInfoButton");
    public BySelector dynamicRouteView = By.res(HFVariables.PACKAGE_NAME + ":id/dynamicAlertLayout");
    public BySelector destWpIcon = By.res(HFVariables.PACKAGE_NAME + ":id/destinationIcon");
    public BySelector endTrip = By.res(HFVariables.PACKAGE_NAME + ":id/endTripButton");
    public BySelector endTripIcon = By.res(HFVariables.PACKAGE_NAME + ":id/endTripIcon");
    public BySelector trafficMockIcon = By.res(HFVariables.PACKAGE_NAME + ":id/automationTestButtonTrafficIcon");
    public BySelector routeDistance = By.res(HFVariables.PACKAGE_NAME + ":id/glViewMapTrafficIndicatorDistance");
    public BySelector mapTrafficPanel = By.res(HFVariables.PACKAGE_NAME + ":id/glViewMapRightPane");
    public BySelector laneGuidance = By.res(HFVariables.PACKAGE_NAME + ":id/movingMap0LaneGuidanceView");
    public BySelector tightTurnSt = By.res(HFVariables.PACKAGE_NAME + ":id/tightTurnNextStreetName");
    public BySelector tightTurn = By.res(HFVariables.PACKAGE_NAME + ":id/tightTurnIconView");
    public BySelector tightTurnDis = By.res(HFVariables.PACKAGE_NAME + ":id/tightTurnDistance");
    public BySelector subPanel = By.res(HFVariables.PACKAGE_NAME + ":id/sub_maneuver_container");
    public BySelector arrivalText = By.res(HFVariables.PACKAGE_NAME + ":id/arrivalText");
    public BySelector junctionView = By.res(HFVariables.PACKAGE_NAME + ":id/junctionView");
    public BySelector alertText = By.res(HFVariables.PACKAGE_NAME + ":id/zoneAlertText");
    public BySelector waypointEntryBtn = By.res(HFVariables.PACKAGE_NAME + ":id/mapWayPointButton");
    public BySelector hwyExit = By.res(HFVariables.PACKAGE_NAME + ":id/mapHighwayExitListButton");
    public BySelector driveTo = By.res(HFVariables.PACKAGE_NAME + ":id/driveToNextWayPointInfo");
    public BySelector wpText = By.res(HFVariables.PACKAGE_NAME + ":id/nextWayPointInfo");
    public BySelector skip = By.res(HFVariables.PACKAGE_NAME + ":id/skipWayPointButton");
    public BySelector wpApproachingView = By.res(HFVariables.PACKAGE_NAME + ":id/wayPointApproachingView");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("MovingMapState") ||
                    getDesc(mapPage).equals("JunctionView")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
