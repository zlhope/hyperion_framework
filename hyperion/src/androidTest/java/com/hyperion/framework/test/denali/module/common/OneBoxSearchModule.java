package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.hyperion.framework.test.denali.module.Module;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.testdata.TestData;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OneBoxSearchModule extends Module {
    public OneBoxSearchModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    /**
     * ******************************************************
     * Flow: One Box -> Result list/Result detail
     ********************************************************
     **/
    public void getResultListByOnebox(String keyword) throws HFObjectNotFoundException {
        clickIfExist(oneBoxSearch.clearBtn, HFVariables.WAIT_ONE_SECOND);
        setTextIfExist(oneBoxSearch.oneBox, keyword);
        pressEnter();
        waitForProgressBar(1);
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * return = 1: return detail page
     * return = 0: return list page
     * Flow: FreeMap -> Search list page
     ********************************************************
     **/
    public int getResultListBySearch(String keyword, int type) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getOnebox();
        if(type == 1){
            getResultListByOnebox(keyword);
        }
        if(type == 2){
            getResultListByCategory(keyword);
        }
        if(resultList.checkScreen())
        {
            if(objExist(resultList.emptyView, HFVariables.WAIT_ONE_SECOND)){
                throw new HFObjectNotFoundException("SEARCH_RESULT_IS_EMPTY");
            }
            return 0;
        }
        else if(objExist(resultDetail.resultDetailView)){
            return 1;
        }
        throw new HFObjectNotFoundException("GET_RESULTS_LIST_FAILED");
    }

    /**
     * ******************************************************
     * Flow: One Box -> Result list
     ********************************************************
     **/
    public void getResultListByCategory(String category) throws HFObjectNotFoundException {
        if(category.equals(TestData.Recent)
                ||category.equals(TestData.Favorite)){
            tapCategory(category);
        }
        else{
            tapCategory(category);
            waitForElement(oneBoxSearch.hotCategoryText, HFVariables.WAIT_SHORT);
            click(oneBoxSearch.subCategory);
        }
        waitForProgressBar(1);
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailByFaves(int index) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getFavorites();
        listObjsClick(favorite.rowItem, index);
        if(resultDetail.checkScreen()) {
            return moduleDataMap;
        }else{
            throw new HFObjectNotFoundException("GET_DETAIL_BY_FAVORITE_FAILED");
        }
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailByRecents(int index) throws HFObjectNotFoundException {
        moduleHandler.freeMapModule.getRecents();
        listObjsClick(recents.userItem, index);
        if(resultDetail.checkScreen()) {
            return moduleDataMap;
        }else{
            throw new HFObjectNotFoundException("GET_DETAIL_BY_RECENTS_FAILED");
        }
    }

    /**
     * ******************************************************
     * type = 1: Search by normal keyword
     * type = 2: Search by category
     * Flow: FreeMap -> Search list page -> Search result page
     ********************************************************
     **/
    public HashMap<String, String> getDetailBySearch(String keyword, int type, int index) throws HFObjectNotFoundException {
        int ret = getResultListBySearch(keyword,  type);
        if(ret == 0){
            return getDetail(index);
        }else
        {
            return getInfoInDetailPage();
        }
    }

    /**
     * ******************************************************
     * Flow: FreeMap -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetailByRGC() throws HFObjectNotFoundException {
        return moduleDataMap;
    }

    /**
     * ******************************************************
     * Flow: Search list page -> Search detail page
     ********************************************************
     **/
    public HashMap<String, String> getDetail( int index) throws HFObjectNotFoundException {
        for(int i=0; i <= 3; i++){
            listObjsClick(oneBoxSearch.resultItem, index);
            waitForProgressBar(2);
            if(resultDetail.checkScreen()) {
                return getInfoInDetailPage();
            }else{
                HFLog.logMessage("Get POI detail page failed, try: " + (i+1));
            }
        }
        throw new HFObjectNotFoundException("GET_DETAIL_BY_SEARCH_FAILED");
    }

    /**
     * ******************************************************
     * Flow: One Box -> Auto suggestion -> Search list
     ********************************************************
     **/
    public boolean getResultListByAutoSuggestion(String keyword) throws HFObjectNotFoundException {
        getAutoSuggestion(keyword);
        return clickIfExist(oneBoxSearch.autoSuggestItem);
    }

    /**
     * ******************************************************
     * Flow: One Box -> Auto suggestion
     ********************************************************
     **/
    public void getAutoSuggestion(String keyword) throws HFObjectNotFoundException {
        for(int i = 0; i<10; i++){
            clickIfExist(oneBoxSearch.clearBtn);
            setTextIfExist(oneBoxSearch.oneBox, keyword);
            if(waitForElement(oneBoxSearch.autoSuggestItem, HFVariables.WAIT_MIDDLE)){
                return;
            }
            HFLog.logMessage("Get auto suggestion failed, try:" + (i+1));
        }
        throw new HFObjectNotFoundException("GET_AUTO_SUGGESTION_FAILED");
    }

    /**
     * ******************************************************
     * Flow: Auto suggestion
     ********************************************************
     **/
    public ArrayList<String> getAutoSuggestionItem() throws HFObjectNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        if(objExist(oneBoxSearch.autoSuggestionListView) &&
                objExist(oneBoxSearch.autoSuggestItem)){
            int count = listObjsGetChildCount(oneBoxSearch.autoSuggestionListView);
            if(count == 4 && (!listObjsExists(oneBoxSearch.autoSuggestItem, 3))){
                HFLog.logMessage("Keyboard shows, dismiss it!");
                pressBack();
                SystemClock.sleep(HFVariables.WAIT_SHORT);
                count = listObjsGetChildCount(oneBoxSearch.autoSuggestionListView);
            }
            for( int i = 0; i<count -1; i++){
                result.add(listObjsGetText(oneBoxSearch.autoSuggestItem, i));
            }
        }else{
            throw new HFObjectNotFoundException("GET_SUGGESTION_ITEM_FAILED");
        }
        return result;
    }

    /**
     * ******************************************************
     * Flow: One Box -> Tab category -> Search List
     ********************************************************
     **/
    public boolean tapCategory(String category) throws HFObjectNotFoundException {
        UiSelector childPattern = new UiSelector().className("android.widget.TextView");
        UiScrollable parentView = new UiScrollable(new UiSelector().scrollable(true));
        parentView.setAsHorizontalList();
        try {
            UiObject obj = parentView.getChildByDescription(childPattern, category, true);
            obj.click();
        }catch (Exception e)
        {
            throw new HFObjectNotFoundException("HOT_CATEGORY_NOT_EXIT");
        }
        return true;
    }

    /**
     * ******************************************************
     * Flow: Search List
     ********************************************************
     **/
    public boolean checkResultHasPrice() throws HFObjectNotFoundException {
        return true;
    }

    /**
     * ******************************************************
     * Flow: Search List -> set sort type -> Search list
     * On = true : sort by distance
     * On = false : sort by relevance
     ********************************************************
     **/
    public void setResultSortType(Boolean on) throws HFObjectNotFoundException {
        if((HFVariables.SORT_BY_DISTANCE != null)){
            if( (HFVariables.SORT_BY_DISTANCE && on)||
                    ((!HFVariables.SORT_BY_DISTANCE) && (!on))){
                return;
            }
        }
        if (clickIfExist(resultList.sort, HFVariables.WAIT_LONG * 3)){
            if(on){
                click(resultList.sortByDistance);
                HFVariables.SORT_BY_DISTANCE = true;
                HFLog.logMessage("Set search by distance!");
            }else{
                click(resultList.sortByRelevance);
                HFVariables.SORT_BY_DISTANCE = false;
                HFLog.logMessage("Set search by relevance!");
            }
            if(resultList.checkScreen()){
                waitForElement(resultList.resultName, HFVariables.WAIT_SHORT);
                SystemClock.sleep(HFVariables.WAIT_SHORT);
                return;
            }
        }
        throw new HFObjectNotFoundException("Set sort type failed");
    }

    /**
     * ******************************************************
     * Flow: Search List/Search Detail
     * type = 0 : Result list
     * type = 1 : Result detail
     ********************************************************
     **/
    public boolean checkSearchResult(int type, String text) throws HFObjectNotFoundException {
        String poiName, street, city, category, totalStr, index;
        List<UiObject2> objLists;
        UiObject2 parentObj, obj;
        HFLog.logMessage("Expected search result: " + text);
        if(type == 0){
            setResultSortType(false);
            while(true) {
                int count = Math.min(listObjsGetChildCount(resultList.oneBoxSearchList), 3);
                objLists = HFDevice.getDevice().findObjects(resultList.resultName);
                for (int i = 0; i < count; i++) {
                    poiName = listObjsGetText2(resultList.resultName, i);
                    index = poiName.split("\\.")[0];
                    poiName = poiName.split("\\.")[1];
                    parentObj = objLists.get(i).getParent().getParent();
                    obj = parentObj.findObject(resultList.street);
                    street = obj != null ? obj.getText(): "";
                    obj = parentObj.findObject(resultList.city);
                    city = obj != null ? obj.getText(): "";
                    obj = parentObj.findObject(resultList.itemCategory);
                    category = obj != null ? obj.getText(): "";
                    category = category == null ? "" : category;
                    totalStr = poiName + "#" + street + "#" + city + "#" + category;
                    HFLog.logMessage("Found result list: "+ index +"."+totalStr.replace(" ",""));
                    if (comparePOIInfo(totalStr, text)) {
                        return true;
                    }
                }
                if((!objExist(resultList.nextPage)) ||
                        (isListToEnd())){
                    break;
                }
                click(resultList.nextPage);
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        if(type == 1){
            poiName = getTextIfExist2(resultDetail.entityName);
            street = getTextIfExist2(resultDetail.address);
            city = getTextIfExist2(resultDetail.city);
            category = getTextIfExist2(resultDetail.itemCategory);
            totalStr = poiName + "#" + street + "#" + city + "#" + category;
            HFLog.logMessage("Found result detail: "+ totalStr.replace(" ",""));
            if (comparePOIInfo(totalStr, text)) {
                return true;
            }
        }
        return false;
    }

    private boolean comparePOIInfo(String actual, String expected) throws HFObjectNotFoundException{
        String[] expectedList = expected.replace("#"," # ").split("#");
        String[] actualList = actual.replace("#"," # ").split("#");
        String actualTmp, expectedTmp;
        if(expectedList.length != 4 ||
                expectedList.length != actualList.length){
            throw new HFObjectNotFoundException("INPUT_TEXT_FORMAT_ERROR");
        }
        for(int i = 0; i < actualList.length; i++){
            actualTmp = actualList[i].replace(" ", "");
            expectedTmp = expectedList[i].replace(" ", "");
            if(!expectedTmp.equals("")) {
                if (!actualTmp.matches(expectedTmp)) {
                    return false;
                }
            }
        }
        HFLog.logMessage("Compare successfully!");
        return true;
    }

    public boolean isListToEnd() throws HFObjectNotFoundException {
        return getDesc(resultList.nextPage).equalsIgnoreCase("lastPage");
    }
}
