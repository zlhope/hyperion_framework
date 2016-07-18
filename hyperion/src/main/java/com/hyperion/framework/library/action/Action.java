package com.hyperion.framework.library.action;
/**
 * Created by Johnny Huang on 2016/1/21.
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.hyperion.framework.library.utils.HFDevice;
import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Action {
    public HFDevice hfd;

    public Action() {
        hfd = new HFDevice(HFVariables.PACKAGE_NAME);
    }

    protected void pressBackTwice() {
        hfd.getDevice().pressBack();
        hfd.getDevice().pressBack();
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
    }

    protected void pressEnter() {
        hfd.getDevice().pressEnter();
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
    }

    protected void pressBack() {
        hfd.getDevice().pressBack();
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
    }

    protected void pressHome() {
        hfd.getDevice().pressHome();
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
    }

    protected boolean clickIfExist(BySelector selector) throws HFObjectNotFoundException {
        try {
            if (objExist(selector)) {
                hfd.getDevice().findObject(selector).click();
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("ClickIfExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("CLICK_IF_EXIST_ERROR");
        }
    }

    protected boolean clickIfExist(BySelector selector, int timeout) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, timeout)) {
                hfd.getDevice().findObject(selector).click();
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("ClickIfExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("CLICK_IF_EXIST_ERROR");
        }
    }

    protected boolean click(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).click();
        } else {
            throw new HFObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
        return true;
    }

    protected boolean click(String text) throws HFObjectNotFoundException {
        BySelector selector = By.text(text);
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).click();
        } else {
            throw new HFObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
        return true;
    }

    protected boolean click(BySelector selector, int timeout) throws HFObjectNotFoundException {
        if (objExist(selector, timeout)) {
            hfd.getDevice().findObject(selector).click();
        } else {
            throw new HFObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
        return true;
    }

    protected boolean longClickIfExist(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).longClick();
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            return true;
        } else {
            return false;
        }
    }

    protected boolean longClick(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).longClick();
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            return true;
        } else {
            throw new HFObjectNotFoundException("CLICK_SELECTOR_NOT_EXIST");
        }
    }

    protected boolean waitForElement(String text, int timeout) throws HFObjectNotFoundException {
        return objExist(text, timeout);
    }

    protected boolean waitForElement(BySelector selector, int timeout) throws HFObjectNotFoundException {
        return objExist(selector, timeout);
    }

    protected boolean waitUtilObjEnabled(BySelector selector) throws HFObjectNotFoundException {
        try {
            for (int i = 0; i < 30; i++) {
                if (objExist(selector)) {
                    if (objIsEnabled(selector)) {
                        return true;
                    } else {
                        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND / 2);
                    }
                } else {
                    SystemClock.sleep(HFVariables.WAIT_ONE_SECOND / 2);
                }
            }
            return true;
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean objExist(BySelector selector) throws HFObjectNotFoundException {
        try {
            return hfd.getDevice().wait(Until.hasObject(selector), HFVariables.WAIT_SHORT);
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean objIsSelected(BySelector selector) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_SHORT)) {
                return hfd.getDevice().findObject(selector).isSelected();
            } else {
                throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjIsSelected check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_SELECTED_ERROR");
        }
    }

    protected boolean objIsSelected(BySelector selector, int timeout) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, timeout)) {
                return hfd.getDevice().findObject(selector).isSelected();
            } else {
                throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjIsSelected check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_SELECTED_ERROR");
        }
    }

    protected boolean objExist(BySelector selector, int timeout) throws HFObjectNotFoundException {
        try {
            return hfd.getDevice().wait(Until.hasObject(selector), timeout);
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean objExist(BySelector... selectors) {
        for (BySelector selector : selectors) {
            if (!hfd.getDevice().hasObject(selector)) {
                return false;
            }
        }
        return true;
    }

    protected boolean clickCheckBox(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            UiObject2 obj = hfd.getDevice().findObject(selector);
            if (!obj.isChecked()) {
                obj.click();
            }
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            return true;
        }
        throw new HFObjectNotFoundException("CHECKBOX_SELECTOR_NOT_EXIST");
    }

    protected boolean clickCheckBox(BySelector selector, Boolean on) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            UiObject2 obj = hfd.getDevice().findObject(selector);
            if (on) {
                if (!obj.isChecked()) {
                    obj.click();
                }
            } else {
                if (obj.isChecked()) {
                    obj.click();
                }
            }
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            return true;
        }
        throw new HFObjectNotFoundException("CHECKBOX_SELECTOR_NOT_EXIST");
    }

    protected boolean clickCheckBox(UiObject2 selector, Boolean on) throws HFObjectNotFoundException {
        if (on) {
            if (!selector.isChecked()) {
                selector.click();
            }
        } else {
            if (selector.isChecked()) {
                selector.click();
            }
        }
        SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        return true;
    }

    protected boolean clickSelector(BySelector selector, Boolean on) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            UiObject2 obj = hfd.getDevice().findObject(selector);
            if (on) {
                if (!obj.isSelected()) {
                    obj.click();
                }
            } else {
                if (obj.isSelected()) {
                    obj.click();
                }
            }
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            return true;
        } else {
            throw new HFObjectNotFoundException("CLICK_SELECTOR_ERROR");
        }
    }

    protected boolean objIsEnabled(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).isEnabled();
        } else {
            throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objIsFocusable(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).isFocusable();
        } else {
            throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objIsClickable(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).isClickable();
        } else {
            throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objIsChecked(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).isChecked();
        } else {
            throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected boolean objTextShouldBe(BySelector selector, String str) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).getText().equals(str);
        } else {
            throw new HFObjectNotFoundException("OBJ_NOT_EXIST");
        }
    }

    protected String getTextIfExist(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).getText();
        } else {
            return null;
        }
    }

    protected String getTextIfExist(BySelector selector, int timeout) throws HFObjectNotFoundException {
        if (objExist(selector, timeout)) {
            return hfd.getDevice().findObject(selector).getText();
        } else {
            return null;
        }
    }

    protected boolean clearText(BySelector selector) throws HFObjectNotFoundException {
        try {
            if (objExist(selector)) {
                hfd.getDevice().findObject(selector).clear();
                if ((hfd.getDevice().findObject(selector).getText() == null) ||
                        (hfd.getDevice().findObject(selector).getText().isEmpty())) {
                    return true;
                }
                for (int i = 0; i < 30; i++) {
                    if (hfd.getDevice().findObject(selector).getText().length() > 3) {
                        hfd.getDevice().findObject(selector).longClick();
                        hfd.getDevice().pressDelete();
                    } else {
                        break;
                    }
                }
                int length = hfd.getDevice().findObject(selector).getText().length();
                for (int i = 0; i < length - 1; i++) {
                    hfd.getDevice().pressDPadRight();
                    hfd.getDevice().pressDelete();
                }
                hfd.getDevice().pressDPadRight();
                return true;
            } else {
                throw new HFObjectNotFoundException("EDIT_TEXT_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("ClearTextIfExist failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("CLEAR_TEXT_FAILED");
        }
    }

    protected boolean clearTextIfExist(BySelector selector) throws HFObjectNotFoundException {
        try {
            if (objExist(selector)) {
                hfd.getDevice().findObject(selector).clear();
                if ((hfd.getDevice().findObject(selector).getText() == null) ||
                        (hfd.getDevice().findObject(selector).getText().isEmpty())) {
                    return true;
                }
                for (int i = 0; i < 30; i++) {
                    if (hfd.getDevice().findObject(selector).getText().length() > 3) {
                        hfd.getDevice().findObject(selector).longClick();
                        hfd.getDevice().pressDelete();
                    } else {
                        break;
                    }
                }
                int length = hfd.getDevice().findObject(selector).getText().length();
                for (int i = 0; i < length - 1; i++) {
                    hfd.getDevice().pressDPadRight();
                    hfd.getDevice().pressDelete();
                }
                hfd.getDevice().pressDPadRight();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("ClearTextIfExist failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("CLEAR_TEXT_FAILED");
        }
    }

    protected boolean setTextIfExist(BySelector selector, String str) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).setText(str);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            return true;
        } else {
            return false;
        }
    }

    protected boolean setText(BySelector selector, String str) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).setText(str);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            if (hfd.getDevice().findObject(selector).getText().equals(str)) {
                return true;
            } else {
                throw new HFObjectNotFoundException("SET_TEXT_FAILED");
            }
        } else {
            throw new HFObjectNotFoundException("SET_TEXT_SELECTOR_NOT_EXIST");
        }
    }

    protected boolean listObjsClick(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                if ((objLists.size() - 1) >= index) {
                    objLists.get(index).click();
                    SystemClock.sleep(HFVariables.WAIT_SHORT);
                    return true;
                } else {
                    throw new HFObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Click List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("LIST_OBJ_CLICK_ERROR");
        }
    }

    protected String listObjsGetText(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                if ((objLists.size() - 1) >= index) {
                    if (objLists.get(index).getText().length() > 0) {
                        return objLists.get(index).getText();
                    } else {
                        throw new HFObjectNotFoundException("LIST_OBJ_TEXT_IS_NULL");
                    }
                } else {
                    throw new HFObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("LIST_OBJ_GET_TEXT_ERROR");
        }
    }

    protected String listObjsGetText2(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                if ((objLists.size() - 1) >= index) {
                    if (objLists.get(index).getText().length() > 0) {
                        return objLists.get(index).getText();
                    } else {
                        return "";
                    }
                } else {
                    return "";
                }
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("LIST_OBJ_GET_TEXT_ERROR");
        }
    }

    protected boolean listIndexObjsIsSelected(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                if ((objLists.size() - 1) >= index) {
                    return objLists.get(index).isSelected();
                } else {
                    throw new HFObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("LIST_OBJ_GET_SELECTED_STATUS_ERROR");
        }
    }

    protected void listIndexObjsSwipeLeft(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                if ((objLists.size() - 1) >= index) {
                    objLists.get(index).swipe(Direction.LEFT, 1.0f);
                } else {
                    throw new HFObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("LIST_OBJ_SWIPE_ERROR");
        }
    }

    protected void listIndexObjsSwipeRight(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                if ((objLists.size() - 1) >= index) {
                    if (objLists.get(index).getText().length() > 0) {
                        objLists.get(index).swipe(Direction.RIGHT, 1.0f);
                    } else {
                        throw new HFObjectNotFoundException("LIST_OBJ_TEXT_IS_NULL");
                    }
                } else {
                    throw new HFObjectNotFoundException("LIST_OBJ_INDEX_NOT_EXIST");
                }
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("LIST_OBJ_GET_TEXT_ERROR");
        }
    }

    protected Boolean listObjsExists(BySelector selector, int index) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                return (objLists.size() - 1) >= index;
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("Get List Item Error!");
        }
    }

    protected int listObjsGetCount(BySelector selector) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                List<UiObject2> objLists = hfd.getDevice().findObjects(selector);
                return objLists.size();
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Count Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("Get List Count Error!");
        }
    }

    protected int listObjsGetChildCount(BySelector selector) throws HFObjectNotFoundException {
        try {
            if (objExist(selector, HFVariables.WAIT_LONG)) {
                int childCount = hfd.getDevice().findObject(selector).getChildCount();
                return childCount;
            } else {
                throw new HFObjectNotFoundException("LIST_OBJ_NOT_EXIST");
            }
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Child Count Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("Get List Child Count Error!");
        }
    }

    protected UiObject2 listObjsGetChildObj(BySelector selector, int index, BySelector child_selector) throws HFObjectNotFoundException {
        objExist(selector, HFVariables.WAIT_LONG);
        try {
            UiObject2 root = hfd.getDevice().findObjects(selector).get(index);
            UiObject2 obj = root.findObject(child_selector);
            for (int i = 0; i < 3; i++) {
                if (obj == null) {
                    root = root.getParent();
                    obj = root.findObject(child_selector);
                } else {
                    break;
                }
            }
            return obj;
        } catch (Exception e) {
            HFLog.addRecordToLog("Get List Item Error!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("Get List Item Error!");
        }
    }

    protected boolean objectTextExist(String textValue) throws HFObjectNotFoundException {
        return objExist(By.text(textValue));
    }

    protected boolean pkgExist(String textValue) throws HFObjectNotFoundException {
        return objExist(By.pkg(textValue).depth(0));
    }

    protected boolean clickIfExist(String textValue) throws HFObjectNotFoundException {
        return clickIfExist(By.text(textValue));
    }

    protected boolean objExist(String textValue) throws HFObjectNotFoundException {
        return objExist(By.text(textValue));
    }

    protected boolean objExist(String textValue, int timeout) throws HFObjectNotFoundException {
        return objExist(By.text(textValue), timeout);
    }

    protected boolean objExistByTextContains(String textValue) throws HFObjectNotFoundException {
        return objExist(By.textContains(textValue));
    }

    protected String getText(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector, HFVariables.WAIT_SHORT)) {
            String str = getTextIfExist(selector);
            if (str != null) {
                return str;
            } else {
                throw new HFObjectNotFoundException("Get obj text Failed!");
            }
        } else {
            throw new HFObjectNotFoundException("OBJ_DOES_NOT_EXIST!");
        }
    }

    protected String getDesc(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            return hfd.getDevice().findObject(selector).getContentDescription();
        } else {
            throw new HFObjectNotFoundException("GET_OBJ_DESC_FAILED!");
        }
    }

    protected void waitForProgress() throws HFObjectNotFoundException {
        for (int i = 0; i < 60; i++) {
            if (objExist(By.res("android:id/progress"))) {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            } else {
                break;
            }
        }
    }

    protected int getDeviceWidth() {
        return hfd.getDevice().getDisplayWidth();
    }

    protected int getDeviceHeight() {
        return hfd.getDevice().getDisplayHeight();
    }

    protected boolean scrollDown(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.DOWN, 1.0f, 2000);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollUp(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.UP, 1.0f, 2000);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollLeft(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.LEFT, 1.0f, 2000);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollRight(BySelector selector) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.RIGHT, 1.0f, 2000);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollDown(BySelector selector, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.DOWN, 1.0f, step);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollUp(BySelector selector, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.UP, 1.0f, step);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollLeft(BySelector selector, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.LEFT, 1.0f, step);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean scrollRight(BySelector selector, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).swipe(Direction.RIGHT, 1.0f, step);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollUp(BySelector selector, int times, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            for (int i = 0; i < times; i++) {
                hfd.getDevice().findObject(selector).swipe(Direction.UP, 1.0f, step);
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollLeft(BySelector selector, int times, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            for (int i = 0; i < times; i++) {
                hfd.getDevice().findObject(selector).swipe(Direction.LEFT, 1.0f, step);
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollRight(BySelector selector, int times, int step) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            for (int i = 0; i < times; i++) {
                hfd.getDevice().findObject(selector).swipe(Direction.RIGHT, 1.0f, step);
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    public boolean scrollDown(BySelector selector, int times, int step, float percent) throws HFObjectNotFoundException {
        if (objExist(selector)) {
            for (int i = 0; i < times; i++) {
                hfd.getDevice().findObject(selector).swipe(Direction.DOWN, percent, step);
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean pinchClose(BySelector selector) throws HFObjectNotFoundException {
        float pinchPercentage = 50;
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).pinchClose(pinchPercentage);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean pinchOpen(BySelector selector) throws HFObjectNotFoundException {
        float pinchPercentage = 50;
        if (objExist(selector)) {
            hfd.getDevice().findObject(selector).pinchOpen(pinchPercentage);
            SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
        } else {
            throw new HFObjectNotFoundException("SCROLL_OBJ_NOT_EXIST");
        }
        return true;
    }

    protected boolean waitUtilObjDisappear(BySelector selector, int timeout) throws HFObjectNotFoundException {
        try {
            return hfd.getDevice().wait(Until.gone(selector), timeout);
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    protected boolean waitUtilObjDisappear(BySelector selector) throws HFObjectNotFoundException {
        try {
            return hfd.getDevice().wait(Until.gone(selector), HFVariables.WAIT_SHORT);
        } catch (Exception e) {
            HFLog.addRecordToLog("ObjExist check failed!");
            HFLog.addRecordToLog(e.getStackTrace());
            throw new HFObjectNotFoundException("OBJ_EXIST_ERROR");
        }
    }

    //Assert Method
    protected void uiaAssertTrue(String msg, boolean condition) {
        if (!condition)
            msg = msg + ":" + HFVariables.REPORT_KEY_SCREEN_SHOT + HFDevice.screenShot(msg);
        assertTrue(msg, condition);
    }

    protected void uiaAssertEqual(String msg, String str1, String str2) {
        if (!str1.equals(str2))
            msg = "[" + str1 + "]" + "IS_NOT_EQUAL_TO" + "[" + str2 + "]" + ":" +
                    HFVariables.REPORT_KEY_SCREEN_SHOT + HFDevice.screenShot(msg);
        assertTrue(msg, str1.equals(str2));
    }

    protected void uiaAssertEqualIgnoreCase(String msg, String str1, String str2) {
        if (!str1.equals(str2))
            msg = "[" + str1 + "]" + "IS_NOT_EQUAL_TO" + "[" + str2 + "]" + ":" +
                    HFVariables.REPORT_KEY_SCREEN_SHOT + HFDevice.screenShot(msg);
        assertTrue(msg, str1.equalsIgnoreCase(str2));
    }

    protected void uiaAssertMatches(String msg, String str1, String str2) {
        if (!str1.matches(str2))
            msg = "[" + str1 + "]" + "DO_NOT_MATCH_TO" + "[" + str2 + "]" + ":" +
                    HFVariables.REPORT_KEY_SCREEN_SHOT + HFDevice.screenShot(msg);
        assertTrue(msg, str1.matches(str2));
    }

    protected void uiaAssertFalse(String msg, boolean condition) {
        if (condition)
            msg = msg + ":" + HFVariables.REPORT_KEY_SCREEN_SHOT + HFDevice.screenShot(msg);
        assertFalse(msg, condition);
    }
}