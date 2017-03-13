package com.hyperion.framework.test.denali.screen;
/**
 * Created by Johnny Huang on 2016/1/21
 */

import android.os.SystemClock;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;

public class OneBoxSearchScreen extends Screen {

    public BySelector label4 = By.res(HFVariables.PACKAGE_NAME + ":id/label4");
    public BySelector autoSuggestItem = By.res(HFVariables.PACKAGE_NAME + ":id/onebox0ItemDisplayTextView");
    public BySelector autoSuggestionListView = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxAutoSuggestionListView");
    public BySelector btnDSR = By.res(HFVariables.PACKAGE_NAME + ":id/commonDsrButton");
    public BySelector nextPage = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryNextButton");
    public BySelector subCategory = By.res(HFVariables.PACKAGE_NAME + ":id/subCategoryName");
    public BySelector hotCategoryText = By.res(HFVariables.PACKAGE_NAME + ":id/hotCategoryItemText");
    public BySelector resultItem = By.res(HFVariables.PACKAGE_NAME + ":id/oneboxResultItemNameTextView");

    @Override
    public boolean checkScreen() throws HFObjectNotFoundException {
        for (int i = 0; i < 3; i++) {
            if (getDesc(mapPage).equals("Suggestion")) {
                return true;
            } else {
                SystemClock.sleep(HFVariables.WAIT_ONE_SECOND);
            }
        }
        return false;
    }
}
