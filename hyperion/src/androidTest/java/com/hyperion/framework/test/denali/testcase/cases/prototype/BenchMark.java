package com.hyperion.framework.test.denali.testcase.cases.prototype;

/**
 * Created by Johnny Huang on 2016/4/21
 */

import android.os.SystemClock;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;

import com.hyperion.framework.test.denali.suite.CN_BAT_TAG;
import com.hyperion.framework.test.denali.testcase.cases.CaseBase;
import com.hyperion.framework.test.denali.utils.HFDevice;
import com.hyperion.framework.test.denali.utils.HFLog;
import com.hyperion.framework.test.denali.utils.HFVariables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.regex.Pattern;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class BenchMark extends CaseBase {
    @Before
    public void testSetup() throws Exception {
        HFVariables.TEST_CASE_NAME = testName.getMethodName();
    }

    @After
    public void testTeardown() {
    }

    BySelector searchBtn = By.res("com.autonavi.minimap:id/btn_search");
    BySelector searchText = By.res("com.autonavi.minimap:id/search_text");
    BySelector searchResultHandle = By.res("com.autonavi.minimap:id/search_result_handle");
    BySelector back = By.res("com.autonavi.minimap:id/back_imageview");
    BySelector searchBack = By.res("com.autonavi.minimap:id/btn_search_back");
    BySelector searchResultList = By.res("android:id/list");
    BySelector poiName = By.res("com.autonavi.minimap:id/poi_name");
    BySelector address = By.res("com.autonavi.minimap:id/address");
    BySelector poiName2 = By.res("com.autonavi.minimap:id/poiName");
    BySelector address2 = By.res("com.autonavi.minimap:id/poiAddr");
    BySelector poiName3 = By.res("com.autonavi.minimap:id/text");
    BySelector address3 = By.res("com.autonavi.minimap:id/addr");
    BySelector more = By.text(Pattern.compile("点击查看全部.*"));
    BySelector noResults = By.text("当前区域未找到相关结果!");
    BySelector cityMore = By.res("com.autonavi.minimap:id/img");
    BySelector bottomCard = By.res("com.autonavi.minimap:id/mapBottomInteractiveView");
    BySelector searchSug = By.res("com.autonavi.minimap:id/search_sug_container");
    BySelector sugItem = By.res("com.autonavi.minimap:id/main_content_rl");
    String output_poiName;
    String output_address;

    String[] keywords = {
            "黄山 安徽|Onebox_POINameInProvince_001",
            "泰山 山东|Onebox_POINameInProvince_002",
            "中山陵 江苏|Onebox_POINameInProvince_003",
            "千岛湖 浙江|Onebox_POINameInProvince_004",
            "浙江 普陀山|Onebox_POINameInProvince_005",
            "九寨沟 四川|Onebox_POINameInProvince_006",
            "少林寺 河南|Onebox_POINameInProvince_007",
            "天涯海角 海南|Onebox_POINameInProvince_008",
            "世界之窗 广东|Onebox_POINameInProvince_009",
            "避暑山庄 河北|Onebox_POINameInProvince_010",
            "布达拉宫 西藏|Onebox_POINameInProvince_011",
            "天山西路 百盛|Onebox_POINameNearStreet_001",
            "南京东路 永乐百货|Onebox_POINameNearStreet_002",
            "迪卡侬 仙霞西路|Onebox_POINameNearStreet_003",
            "南京西路 仙乐斯|Onebox_POINameNearStreet_004",
            "八佰伴 南泉路|Onebox_POINameNearStreet_005",
            "九六广场 东方路|Onebox_POINameNearStreet_006",
            "70后饭吧 汇金百货|Onebox_POINameNearPOI_001",
            "来福士 电影院|Onebox_POINameNearPOI_002",
            "龙之梦 来福小馆|Onebox_POINameNearPOI_003",
            "万达广场 交通银行|Onebox_POINameNearPOI_004",
            "哈根达斯 龙之梦|Onebox_POINameNearPOI_005",
            "必胜客 环球港|Onebox_POINameNearPOI_006",
            "金牌外婆家 国金中心|Onebox_POINameNearPOI_007",
            "日料 人民广场|Onebox_POIInShoppingDistrict_001",
            "中山公园 龙之梦|Onebox_POIInShoppingDistrict_002",
            "陆家嘴 餐厅 |Onebox_POIInShoppingDistrict_003",
            "停车场 徐家汇|Onebox_POIInShoppingDistrict_004",
            "五角场 电影院|Onebox_POIInShoppingDistrict_005",
            "正大广场 陆家嘴|Onebox_POIInShoppingDistrict_006",
            "江边城外 淮海路|Onebox_POIInShoppingDistrict_007",
            "初花 古北|Onebox_POIInShoppingDistrict_008",
            "金钱豹 虹桥|Onebox_POIInShoppingDistrict_009",
            "机场 江苏|Onebox_POICategoryInProvince_001",
            "北京 5星酒店|Onebox_POICategoryInProvince_002",
            "浙江 大学|Onebox_POICategoryInProvince_003",
            "5A级景区 江苏|Onebox_POICategoryInProvince_004",
            "长宁区 图书馆|Onebox_POICategoryIncity_001",
            "三林镇 社区医院|Onebox_POICategoryIncity_002",
            "5A级风景区 北京|Onebox_POICategoryIncity_003",
            "广州 机场|Onebox_POICategoryIncity_004",
            "5星酒店 重庆|Onebox_POICategoryIncity_005",
            "上海 博物馆|Onebox_POICategoryIncity_006",
            "仙霞路 银行|Onebox_POICategoryNearStreet_001",
            "邮局 上南路|Onebox_POICategoryNearStreet_002",
            "餐厅 天山路|Onebox_POICategoryNearStreet_003",
            "南京东路 商场|Onebox_POICategoryNearStreet_004",
            "南京西路 公园|Onebox_POICategoryNearStreet_005",
            "停车场 长宁路|Onebox_POICategoryNearStreet_006",
            "娄山关路地铁站 银行|Onebox_POICategoryNearPOI_001",
            "正大广场 停车场|Onebox_POICategoryNearPOI_002",
            "电影院 汇金百货|Onebox_POICategoryNearPOI_003",
            "万达广场 餐厅|Onebox_POICategoryNearPOI_004",
            "健身房 维京大厦|Onebox_POICategoryNearPOI_005",
            "重庆|Onebox_CityCenter_001",
            "三亚市|Onebox_CityCenter_002",
            "广西壮族自治区|Onebox_CityCenter_003",
            "哈密|Onebox_CityCenter_004",
            "浦江镇牌楼村|Onebox_CityCenter_005",
            "长宁区|Onebox_CityCenter_006",
            "南京市|Onebox_CityCenter_007",
            "上海市|Onebox_CityCenter_008",
            "浦东新区|Onebox_CityCenter_009",
            "临安市|Onebox_CityCenter_010",
            "温州市|Onebox_CityCenter_011",
            "上海市浦东新区 上南路|Onebox_CityStreetName_001",
            "上海市长宁区 淞虹路|Onebox_CityStreetName_002",
            "上海市普陀区 金沙江路|Onebox_CityStreetName_003",
            "广州市天河区 CBD隧道|Onebox_CityStreetName_004",
            "北京市 东城区 建国门内大街|Onebox_CityStreetName_005",
            "长宁区 天山路|Onebox_SubcityStreetName_001",
            "浦东新区 龙东大道|Onebox_SubcityStreetName_002",
            "闵行区 七莘路|Onebox_SubcityStreetName_003",
            "浦东新区 崂山路|Onebox_SubcityStreetName_004",
            "天河区 CBD隧道|Onebox_SubcityStreetName_005",
            "长宁区古北路88|Onebox_subcityStreetNameDoorNamber_001",
            "白云区 白云大道北113号|Onebox_subcityStreetNameDoorNamber_002",
            "浦东新区 杨南路797弄|Onebox_subcityStreetNameDoorNamber_003",
            "黄浦区西藏中路268号|Onebox_subcityStreetNameDoorNamber_004",
            "宝山区一二八纪念路878号|Onebox_subcityStreetNameDoorNamber_005",
            "长宁区仙霞路333号2401|Onebox_subcityStreetNameDoorNamber_006",
            "北京东路 河南中路 黄浦区|Onebox_IntersectionInCity_001",
            "中山南路/长江路 南京|Onebox_IntersectionInCity_002",
            "北京 西长安街 正义路|Onebox_IntersectionInCity_003",
            "浦东新区 东方路 张杨路|Onebox_IntersectionInCity_004",
            "苏州 干将东路/凤凰街|Onebox_IntersectionInCity_005",
            "无锡 太湖大道@塘南路|Onebox_IntersectionInCity_006"
    };

    @Test
    @Category(CN_BAT_TAG.class)
    public void benchMark() throws Exception {
        for (String tmpString : keywords) {
            String keyword = tmpString.split("\\|")[0];
            HFLog.logMessage("[Search]" + tmpString);
//            searchAction(keyword);
            inputAction(keyword);
        }
//        searchAction("浦东新区 杨南路797弄");
        inputAction("浦东新区 杨南路797弄");
    }

    private void inputAction(String keyword) throws Exception {
        clickIfExist(searchBtn, HFVariables.WAIT_SHORT);
        waitForElement(searchText, HFVariables.WAIT_SHORT);
        setText(searchText, keyword);
        //waitForElement(searchSug, HFVariables.WAIT_MIDDLE);
        waitForElement(sugItem, HFVariables.WAIT_MIDDLE);
        pressBack();
        getInfoFromSugList();
        click(searchBack);
    }

    private void getInfoFromSugList() throws Exception {
        List<UiObject2> objList =  HFDevice.getDevice().findObjects(sugItem);
        UiObject2 tmp;
        for (int i = 0; i < objList.size(); i++){
            tmp = objList.get(i).findObject(poiName3);
            if(tmp != null) {
                output_poiName = tmp.getText();
            }
            else
            {
                continue;
            }
            tmp = objList.get(i).findObject(address3);
            if(tmp != null) {
                output_address = tmp.getText();
            }
            else
            {
                output_address = "";
            }
            HFLog.logMessage("POIName   : " + output_poiName);
            HFLog.logMessage("POIAddress: " + output_address);
        }
    }

    private void searchAction(String keyword) throws Exception {
        clickIfExist(searchBtn, HFVariables.WAIT_SHORT);
        waitForElement(searchText, HFVariables.WAIT_SHORT);
        setText(searchText, keyword);
        pressEnter();
        pullList();
    }

    BySelector tmp = null;
    private void pullList() throws Exception{
        if (clickIfExist(searchResultHandle, HFVariables.WAIT_MIDDLE)) {
            getInfoFromList();
            if (clickIfExist(more)) {
                getInfoFromList();
            }
            clickIfExist(back);
            SystemClock.sleep(1000);
        } else {
            if (objExist(noResults)) {
                listObjsClick(cityMore,0);
                pullList();
            }
            else if (objExist(bottomCard) && objExist(poiName)){
                output_poiName = getText(poiName);
                try {
                    output_address = getText(address);
                }catch (Exception e){
                    output_address = "";
                }
                HFLog.logMessage("POIName   : " + output_poiName);
                HFLog.logMessage("POIAddress: " + output_address);
            }
            else if (objExist(searchBtn)) {
                HFLog.logMessage("There's no result!");
            }
        }
    }

    private void getInfoFromList() throws Exception {
        if (waitForElement(searchResultList, HFVariables.WAIT_MIDDLE)) {
            int count = listObjsGetChildCount(searchResultList);
            for (int i = 0; i < count; i++) {
                try {
                    if(objExist(poiName)) {
                        output_poiName = listObjsGetText2(poiName, i);
                    }else{
                        output_poiName = "";
                    }
                    if(objExist(address)) {
                        output_address = listObjsGetText2(address, i);
                    }
                    else{
                        output_address = "";
                    }
                    if(objExist(poiName2)){
                        output_poiName = listObjsGetText2(poiName2, i);
                        output_address = listObjsGetText2(address2, i);
                        if(output_address.equals("此地址上有")){
                            output_address = "";
                        }
                    }
                    if (!output_poiName.equals("")) {
                        HFLog.logMessage("POIName   : " + output_poiName);
                        HFLog.logMessage("POIAddress: " + output_address);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            HFLog.logMessage("Wait for result list timeout!");
        }
    }
}