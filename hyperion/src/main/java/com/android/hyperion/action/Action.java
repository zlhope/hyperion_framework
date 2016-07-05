package com.android.hyperion.action;
/**
 * Created by Johnny Huang on 2016/1/21.
 */
import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import com.android.hyperion.utility.TnUIACommon;
import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIALog;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Action{
    public TnUIADevice tud;

    public Action() {
    }

    protected void pressBackTwice() {
        tud.mDevice.pressBack();
        tud.mDevice.pressBack();
        SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
    }

    protected void pressEnter() {
        tud.mDevice.pressEnter();
        SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
    }

    protected void pressBack() {
        tud.mDevice.pressBack();
        SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
    }

    protected void pressHome() {
        tud.mDevice.pressHome();
        SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
    }

    protected boolean clickIfExist(BySelector selector) throws TnUIAObjectNotFoundException {
        try {
            if (objExist(selector)) {
                tud.mDevice.findObject(selector).click();
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
                return true;
            } else {
                return false;
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ClickIfExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("CLICK_IF_EXIST_ERROR");
        }
    }

    protected boolean clickIfExist(BySelector selector,int timeout) throws TnUIAObjectNotFoundException{
        try {
            if (objExist(selector, timeout)) {
                tud.mDevice.findObject(selector).click();
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
                return true;
            } else {
                return false;
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ClickIfExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("CLICK_IF_EXIST_ERROR");
        }
    }

    protected boolean click(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector)) {
            tud.mDevice.findObject(selector).click();
        } else {
            throw new TnUIAObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
        return true;
    }

    protected boolean click(String text) throws TnUIAObjectNotFoundException {
        BySelector selector = By.text(text);
        if (objExist(selector)) {
            tud.mDevice.findObject(selector).click();
        } else {
            throw new TnUIAObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
        return true;
    }

    protected boolean click(BySelector selector, int timeout) throws TnUIAObjectNotFoundException {
        if (objExist(selector, timeout)) {
            tud.mDevice.findObject(selector).click();
        } else {
            throw new TnUIAObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
        return true;
    }

    protected boolean longClickIfExist(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            tud.mDevice.findObject(selector).longClick();
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            return true;
        } else {
            return false;
        }
    }

    protected boolean longClick(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            tud.mDevice.findObject(selector).longClick();
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            return true;
        } else {
            throw new TnUIAObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
    }

    protected boolean waitForElement(String text, int timeout) throws TnUIAObjectNotFoundException{
        return objExist(text, timeout);
    }

    protected boolean waitForElement(BySelector selector, int timeout) throws TnUIAObjectNotFoundException{
        return objExist(selector, timeout);
    }

    protected boolean waitUtilObjEnabled(BySelector selector) throws TnUIAObjectNotFoundException{
        try{
            for (int i = 0; i < 30; i++){
                if(objExist(selector)){
                    if(objIsEnabled(selector)){
                        return true;
                    } else {
                        SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND/2);
                    }
                } else {
                    SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND/2);
                }
            }
            return true;
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean objExist(BySelector selector) throws TnUIAObjectNotFoundException{
        try{
            return tud.mDevice.wait(Until.hasObject(selector), TnUIACommon.WAIT_SHORT);
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean objIsSelected(BySelector selector) throws TnUIAObjectNotFoundException{
        try{
            if (objExist(selector, TnUIACommon.WAIT_SHORT)) {
                return tud.mDevice.findObject(selector).isSelected();
            }
            else
            {
                throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjIsSelected check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_SELECTED_ERROR");
        }
    }

    protected boolean objIsSelected(BySelector selector, int timeout) throws TnUIAObjectNotFoundException{
        try{
            if (objExist(selector, timeout)) {
                return tud.mDevice.findObject(selector).isSelected();
            }
            else
            {
                throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjIsSelected check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_SELECTED_ERROR");
        }
    }

    protected boolean objExist(BySelector selector, int timeout) throws TnUIAObjectNotFoundException{
        try{
            return tud.mDevice.wait(Until.hasObject(selector), timeout);
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean objExist(BySelector... selectors) {
        for (BySelector selector : selectors) {
            if (!tud.mDevice.hasObject(selector)) {
                return false;
            }
        }
        return true;
    }

    protected boolean clickCheckBox(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            UiObject2 obj = tud.mDevice.findObject(selector);
            if (!obj.isChecked()) {
                obj.click();
            }
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            return true;
        }
        throw new TnUIAObjectNotFoundException("CHECKBOX_SELECTOR_NOT_EXIST");
    }

    protected boolean clickCheckBox(BySelector selector, Boolean on) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            UiObject2 obj = tud.mDevice.findObject(selector);
            if(on)
            {
                if (!obj.isChecked()) {
                    obj.click();
                }
            }
            else
            {
                if (obj.isChecked()) {
                    obj.click();
                }
            }
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            return true;
        }
        throw new TnUIAObjectNotFoundException("CHECKBOX_SELECTOR_NOT_EXIST");
    }

    protected boolean clickCheckBox(UiObject2 selector, Boolean on) throws TnUIAObjectNotFoundException{
        if(on)
        {
            if (!selector.isChecked()) {
                selector.click();
            }
        }
        else
        {
            if (selector.isChecked()) {
                selector.click();
            }
        }
        SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        return true;
    }

    protected boolean clickSelector(BySelector selector,Boolean on) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            UiObject2 obj = tud.mDevice.findObject(selector);
            if(on)
            {
                if (!obj.isSelected()) {
                    obj.click();
                }
            }
            else
            {
                if (obj.isSelected()) {
                    obj.click();
                }
            }
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            return true;
        }
        else
        {
            throw new TnUIAObjectNotFoundException("CLICK_SELECTOR_ERROR");
        }
    }

    protected boolean objIsEnabled(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).isEnabled();
        }
        else
        {
            throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objIsFocusable(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).isFocusable();
        }
        else
        {
            throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objIsClickable(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).isClickable();
        }
        else
        {
            throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objIsChecked(BySelector selector) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).isChecked();
        }
        else
        {
            throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objTextShouldBe(BySelector selector, String str) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).getText().equals(str);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected String getTextIfExist(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).getText();
        } else {
            return null;
        }
    }

    protected String getTextIfExist(BySelector selector,int timeout) throws TnUIAObjectNotFoundException {
        if (objExist(selector,timeout)) {
            return tud.mDevice.findObject(selector).getText();
        } else {
            return null;
        }
    }

    protected boolean clearText(BySelector selector) throws TnUIAObjectNotFoundException{
        try {
            if (objExist(selector)) {
                tud.mDevice.findObject(selector).clear();
                if ((tud.mDevice.findObject(selector).getText() == null) ||
                        (tud.mDevice.findObject(selector).getText().isEmpty())) {
                    return true;
                }
                for (int i = 0; i < 30; i++) {
                    if (tud.mDevice.findObject(selector).getText().length() > 3) {
                        tud.mDevice.findObject(selector).longClick();
                        tud.mDevice.pressDelete();
                    } else {
                        break;
                    }
                }
                int length = tud.mDevice.findObject(selector).getText().length();
                for (int i = 0; i < length - 1; i++) {
                    tud.mDevice.pressDPadRight();
                    tud.mDevice.pressDelete();
                }
                tud.mDevice.pressDPadRight();
                return true;
            } else {
                throw new TnUIAObjectNotFoundException("EDIT_TEXT_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ClearTextIfExist failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("CLEAR_TEXT_FAILED");
        }
    }

    protected boolean clearTextIfExist(BySelector selector) throws TnUIAObjectNotFoundException{
        try {
            if (objExist(selector)) {
                tud.mDevice.findObject(selector).clear();
                if ((tud.mDevice.findObject(selector).getText() == null) ||
                        (tud.mDevice.findObject(selector).getText().isEmpty())) {
                    return true;
                }
                for (int i = 0; i < 30; i++) {
                    if (tud.mDevice.findObject(selector).getText().length() > 3) {
                        tud.mDevice.findObject(selector).longClick();
                        tud.mDevice.pressDelete();
                    } else {
                        break;
                    }
                }
                int length = tud.mDevice.findObject(selector).getText().length();
                for (int i = 0; i < length - 1; i++) {
                    tud.mDevice.pressDPadRight();
                    tud.mDevice.pressDelete();
                }
                tud.mDevice.pressDPadRight();
                return true;
            } else {
                return false;
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ClearTextIfExist failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("CLEAR_TEXT_FAILED");
        }
    }

    protected boolean setTextIfExist(BySelector selector, String str) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            tud.mDevice.findObject(selector).setText(str);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            return true;
        } else {
            return false;
        }
    }

    protected boolean setText(BySelector selector, String str) throws TnUIAObjectNotFoundException{
        if (objExist(selector)) {
            tud.mDevice.findObject(selector).setText(str);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            if(tud.mDevice.findObject(selector).getText().equals(str))
            {
                return true;
            }
            else
            {
                throw new TnUIAObjectNotFoundException("SET_TEXT_FAILED");
            }
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SET_TEXT_SELECTOR_NOT_EXIST");
        }
    }

    protected boolean listObjsClick(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                if ((objLists.size()-1)>=index) {
                    objLists.get(index).click();
                    SystemClock.sleep(TnUIACommon.WAIT_SHORT);
                    return true;
                } else {
                    throw new TnUIAObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Click List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("LIST_OBJ_CLICK_ERROR");
        }
    }

    protected String listObjsGetText(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                if ((objLists.size()-1)>=index) {
                    if (objLists.get(index).getText().length() > 0) {
                        return objLists.get(index).getText();
                    } else {
                        throw new TnUIAObjectNotFoundException("LIST_OBJ_TEXT_IS_NULL");
                    }
                } else {
                    throw new TnUIAObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("LIST_OBJ_GET_TEXT_ERROR");
        }
    }

    protected String listObjsGetText2(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                if ((objLists.size()-1)>=index) {
                    if (objLists.get(index).getText().length() > 0) {
                        return objLists.get(index).getText();
                    } else {
                        return "";
                    }
                } else {
                    return "";
                }
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("LIST_OBJ_GET_TEXT_ERROR");
        }
    }

    protected boolean listIndexObjsIsSelected(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                if ((objLists.size()-1)>=index) {
                    return objLists.get(index).isSelected();
                } else {
                    throw new TnUIAObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("LIST_OBJ_GET_SELECTED_STATUS_ERROR");
        }
    }

    protected void listIndexObjsSwipeLeft(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                if ((objLists.size()-1)>=index) {
                    objLists.get(index).swipe(Direction.LEFT, 1.0f);
                } else {
                    throw new TnUIAObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("LIST_OBJ_SWIPE_ERROR");
        }
    }

    protected void listIndexObjsSwipeRight(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                if ((objLists.size()-1)>=index) {
                    if (objLists.get(index).getText().length() > 0) {
                        objLists.get(index).swipe(Direction.RIGHT, 1.0f);
                    } else {
                        throw new TnUIAObjectNotFoundException("LIST_OBJ_TEXT_IS_NULL");
                    }
                } else {
                    throw new TnUIAObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("LIST_OBJ_GET_TEXT_ERROR");
        }
    }

    protected Boolean listObjsExists(BySelector selector, int index) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                return (objLists.size() - 1) >= index;
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("Get List Item Error!");
        }
    }

    protected int listObjsGetCount(BySelector selector) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                List<UiObject2> objLists = tud.mDevice.findObjects(selector);
                return objLists.size();
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Count Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("Get List Count Error!");
        }
    }

    protected int listObjsGetChildCount(BySelector selector) throws TnUIAObjectNotFoundException {
        try {
            if(objExist(selector, TnUIACommon.WAIT_LONG)){
                int childCount = tud.mDevice.findObject(selector).getChildCount();
                return childCount;
            }
            else{
                throw new TnUIAObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Child Count Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("Get List Child Count Error!");
        }
    }

    protected UiObject2 listObjsGetChildObj(BySelector selector, int index, BySelector child_selector) throws TnUIAObjectNotFoundException {
        objExist(selector,TnUIACommon.WAIT_LONG);
        try {
            UiObject2 root= tud.mDevice.findObjects(selector).get(index);
            UiObject2 obj= root.findObject(child_selector);
            for(int i=0;i<3;i++) {
                if (obj == null) {
                    root= root.getParent();
                    obj= root.findObject(child_selector);
                }
                else
                {
                    break;
                }
            }
            return obj;
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("Get List Item Error!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("Get List Item Error!");
        }
    }

    protected boolean objectTextExist(String textValue) throws TnUIAObjectNotFoundException {
        return objExist(By.text(textValue));
    }

    protected boolean pkgExist(String textValue) throws TnUIAObjectNotFoundException {
        return objExist(By.pkg(textValue).depth(0));
    }

    protected boolean clickIfExist(String textValue) throws TnUIAObjectNotFoundException {
        return clickIfExist(By.text(textValue));
    }

    protected boolean objExist(String textValue) throws TnUIAObjectNotFoundException {
        return objExist(By.text(textValue));
    }

    protected boolean objExist(String textValue,int timeout) throws TnUIAObjectNotFoundException {
        return objExist(By.text(textValue), timeout);
    }

    protected boolean objExistByTextContains(String textValue) throws TnUIAObjectNotFoundException {
        return objExist(By.textContains(textValue));
    }

    protected String getText(BySelector selector) throws TnUIAObjectNotFoundException {
        if(objExist(selector, TnUIACommon.WAIT_SHORT)){
            String str= getTextIfExist(selector);
            if(str!=null)
            {
                return str;
            }
            else
            {
                throw new TnUIAObjectNotFoundException("Get obj text Failed!");
            }
        }
        else{
            throw new TnUIAObjectNotFoundException("OBJ_DOES_NOT_EXIST!");
        }
    }

    protected String getDesc(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector)) {
            return tud.mDevice.findObject(selector).getContentDescription();
        } else {
            throw new TnUIAObjectNotFoundException("GET_OBJ_DESC_FAILED!");
        }
    }

    protected void waitForProgress() throws TnUIAObjectNotFoundException
    {
        for(int i=0;i<60;i++)
        {
            if(objExist(By.res("android:id/progress")))
            {
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            }
            else
            {
                break;
            }
        }
    }

    protected int getDeviceWidth() {
        return tud.mDevice.getDisplayWidth();
    }

    protected int getDeviceHeight() {
        return tud.mDevice.getDisplayHeight();
    }

    protected boolean scrollDown(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.DOWN, 1.0f, 2000);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollUp(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.UP, 1.0f, 2000);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollLeft(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.LEFT, 1.0f, 2000);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollRight(BySelector selector) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.RIGHT, 1.0f, 2000);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollDown(BySelector selector, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.DOWN, 1.0f, step);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollUp(BySelector selector, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.UP, 1.0f, step);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollLeft(BySelector selector, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.LEFT, 1.0f, step);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollRight(BySelector selector, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).swipe(Direction.RIGHT, 1.0f, step);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollUp(BySelector selector, int times, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            for(int i=0;i<times;i++) {
                tud.mDevice.findObject(selector).swipe(Direction.UP, 1.0f, step);
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            }
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollLeft(BySelector selector, int times, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            for(int i=0;i<times;i++) {
                tud.mDevice.findObject(selector).swipe(Direction.LEFT, 1.0f, step);
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            }
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollRight(BySelector selector, int times, int step) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            for(int i=0;i<times;i++) {
                tud.mDevice.findObject(selector).swipe(Direction.RIGHT, 1.0f, step);
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            }
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollDown(BySelector selector, int times, int step, float percent) throws TnUIAObjectNotFoundException {
        if (objExist(selector))
        {
            for(int i=0;i<times;i++) {
                tud.mDevice.findObject(selector).swipe(Direction.DOWN, percent, step);
                SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
            }
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean pinchClose(BySelector selector) throws TnUIAObjectNotFoundException {
        float pinchPercentage = 50;
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).pinchClose(pinchPercentage);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean pinchOpen(BySelector selector) throws TnUIAObjectNotFoundException {
        float pinchPercentage = 50;
        if (objExist(selector))
        {
            tud.mDevice.findObject(selector).pinchOpen(pinchPercentage);
            SystemClock.sleep(TnUIACommon.WAIT_ONE_SECOND);
        }
        else
        {
            throw new TnUIAObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean waitUtilObjDisappear(BySelector selector, int timeout) throws TnUIAObjectNotFoundException{
        try{
            return tud.mDevice.wait(Until.gone(selector), timeout);
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean waitUtilObjDisappear(BySelector selector) throws TnUIAObjectNotFoundException{
        try{
            return tud.mDevice.wait(Until.gone(selector), TnUIACommon.WAIT_SHORT);
        }catch (Exception e)
        {
            TnUIALog.addRecordToLog("ObjExist check failed!");
            TnUIALog.addRecordToLog(e.getStackTrace());
            throw new TnUIAObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    //Assert Method
    protected void uiaAssertTrue(String msg, boolean condition) {
        if (!condition)
            msg = msg + ":" + TnUIACommon.REPORT_KEY_SCREEN_SHOT + TnUIADevice.screenShot(msg);
        assertTrue(msg, condition);
    }

    protected void uiaAssertEqual(String msg, String str1,String str2) {
        if (!str1.equals(str2))
            msg = "["+str1+"]"+"IS_NOT_EQUAL_TO"+"["+str2+"]" + ":" +
                    TnUIACommon.REPORT_KEY_SCREEN_SHOT + TnUIADevice.screenShot(msg);
        assertTrue(msg, str1.equals(str2));
    }

    protected void uiaAssertEqualIgnoreCase(String msg, String str1,String str2) {
        if (!str1.equals(str2))
            msg = "["+str1+"]"+"IS_NOT_EQUAL_TO"+"["+str2+"]" + ":" +
                    TnUIACommon.REPORT_KEY_SCREEN_SHOT + TnUIADevice.screenShot(msg);
        assertTrue(msg, str1.equalsIgnoreCase(str2));
    }

    protected void uiaAssertMatches(String msg, String str1,String str2) {
        if (!str1.matches(str2))
            msg = "["+str1+"]"+"DO_NOT_MATCH_TO"+"["+str2+"]" + ":" +
                    TnUIACommon.REPORT_KEY_SCREEN_SHOT + TnUIADevice.screenShot(msg);
        assertTrue(msg, str1.matches(str2));
    }

    protected void uiaAssertFalse(String msg, boolean condition) {
        if (condition)
            msg = msg + ":" + TnUIACommon.REPORT_KEY_SCREEN_SHOT + TnUIADevice.screenShot(msg);
        assertFalse(msg, condition);
    }
}