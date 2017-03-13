package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;


public class RoutePlannerModule extends Module {
    public RoutePlannerModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    /**
     * ******************************************************
     * Flow: Search detail page -> Route planner
     ********************************************************
     **/
    public void goToRoutePlanner() throws HFObjectNotFoundException {
        if(clickIfExist(resultDetail.routeOptions, HFVariables.WAIT_LONG * 3)){
            if(!routePlan.checkScreen()){
                throw new HFObjectNotFoundException("GO_TO_ROUTE_PLANNER_FAILED");
            }
        }else{
            throw new HFObjectNotFoundException("CAN_NOT_FIND_ROUTE_OPTION_BUTTON");
        }
        waitUtilObjDisappear(routePlan.routePlanningProgress, HFVariables.WAIT_LONG*2);
    }

    /**
     * ******************************************************
     * Flow: Route planner -> Navigation
     * Index: select which option and drive
     ********************************************************
     **/
    public void goFromRoutePlanner(int index) throws HFObjectNotFoundException {
        switch(index){
            case 1:
                waitForElement(routePlan.option1,HFVariables.WAIT_SHORT);
                click(routePlan.option1);
                break;
            case 2:
                waitForElement(routePlan.option2, HFVariables.WAIT_SHORT);
                click(routePlan.option2);
                break;
            case 3:
                waitForElement(routePlan.option3, HFVariables.WAIT_SHORT);
                click(routePlan.option3);
                break;
            default:
                waitForElement(routePlan.option1,HFVariables.WAIT_SHORT);
                click(routePlan.option1);
                break;
        }
        clickIfExist(routePlan.go);
        if (!navigation.checkScreen()) {
            throw new HFObjectNotFoundException("GET_NAVIGATION_FROM_ROUTE_PLANNER_FAILED");
        }
    }
}
