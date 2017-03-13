package com.hyperion.framework.test.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21
 */

import com.hyperion.framework.test.denali.module.common.OneBoxSearchModule;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.utils.HFVariables;


public class CN_OneBoxSearchModule extends OneBoxSearchModule {

    public CN_OneBoxSearchModule(CaseBase caseBase)
    {
        super(caseBase);
    }

    @Override
    public boolean checkResultHasPrice() throws HFObjectNotFoundException {
        try {
            int count;
            String price;
            while (true) {
                count = Math.max(3 , listObjsGetChildCount(oneBoxSearch.oneBoxSearchList));
                for (int i = 0; i < count; i++) {
                    try {
                        price = listObjsGetText2(resultList.itemCategory, i);
                    } catch (Exception e) {
                        price = "";
                    }
                    if (price.contains("￥")) {
                        HFLog.logMessage("Check gas POI item: "+ (i+1));
                        listObjsClick(resultList.itemCategory, i);
                        waitForElement(resultDetail.driveText, HFVariables.WAIT_LONG * 3);
                        click(resultDetail.nextPage);
                        return objExist(resultDetail.gasPrice);
                    }
                }
                if (objExist(resultDetail.gasPrice) &&
                        objIsEnabled(resultDetail.gasPrice)) {
                    click(resultDetail.nextPage);
                }else
                {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new HFObjectNotFoundException("CHECK_GAS_PRICE_FAILED");
        }
    }
}
