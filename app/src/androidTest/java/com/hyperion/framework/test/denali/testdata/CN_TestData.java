package com.hyperion.framework.test.denali.testdata;

public class CN_TestData extends TestData {

    public static String OfficeLatLon = "31.205889, 121.398181";


    /********************
     * Audio
     ***********************/
    public static String waypointApproach = "前方 到达途经点附近";
    //// Test Cases Data///////////////////////

    //Denali-1:Landmark
    public static String tc1input = "上海新国际博览中心";
    public static String[] tc1expect = {"上海新国际博览中心"};
    public static String tc1origin = "31.205889, 121.398181";

    // Denali-2:Highway shields display condition
    public static String tc2origin = "31.223346, 121.346534";
    // //Denali-11 : walkway
    // public static String tc11origin = "37.391808,-121.981580";
    // Denali-16:One way street direction
    public static String tc16origin = "31.237670,121.507974";
    public static String tc16dest = "31.237902,121.513316";
    // //Denali-19 : State name display
    // public static String tc19origin = "37.097612,-102.113829";
    // //Denali-21:City name
    public static String tc21origin = "34.309023, 108.948669";
    // //Denali-22 : Street Name
    public static String tc22origin = "30.605170, 114.284596";
    // // Denali-23:State & country boundary
    // public static String tc23origin = "32.718764,-114.719634";
    // //Denali-28:Seas,lakes & rivers
    // public static String tc28origin="44.955618,-82.504296";
    // //Denali-30:Facility name
    // public static String tc30originAirport = "37.621614,-122.378580";
    // public static String tc30originPark = "37.552909,-121.964007";
    // public static String tc30originGolf = "37.423643,-122.041572";
    // //Denali-43:Traffic flow
    // public static String tc43origin="37.789060,-122.402077";
    // Denali-47:Next Turn info
    public static String tc47origin = "31.208683,121.400616,0";
    public static String tc47dest = "31.211617,121.394708";
    public static String[][] tc47ExpectedTurn = {{"茅台路", "TurnLeft"}, {"芙蓉江路", "TurnRight"}};
    // Denali-48:Active route color
    public static String tc48origin = "31.233737,121.499948";
    public static String tc48dest = "张杨路世纪大道";
    public static String tc48category = Food;
    public static String tc48wp = "麦当劳";
    //Denali-50:Traffic indicator update
    public static String tc50origin = "31.158536,121.691791";
    public static String tc50dest = "31.169594,121.702110";
    // //Denali-66:Scroll map around 3D Landmark
    public static String tc66origin = "31.239712, 121.499777";
    // // Denali-86:Scroll map on junction view
    public static String tc86origin = "38.391442,106.292505";

    //Denali-94:Drive time to home/work - change address
    public static String tc94origin = "31.223819,121.461733";
    public static String tc94home = "上海市浦东区川北公路3087弄18号";
    public static String tc94work = "上海市徐汇区, 宜山路280号";

    // // Denali-102:Zoom in/out in ocean
    // public static String tc102origin = "37.398064,-122.696472";
    // Denali-105:Zoom in/out map_navigation
    public static String tc105searchTxt = "机场";

    //Denali-107:Zoom in/out on current route overview screen
    public static String tc107origin = "31.207739,121.377222,90";
    public static String tc1070dest = "上海虹桥国际机场";

    // // Denali-136:Junction view display
    public static String tc136origin = "35.403886, 118.259575";
    public static String tc136dest = "35.410762, 118.258996";

    // Denali-138:Junction view color
    public static String tc138origin = "31.223819,121.461733";
    public static String tc138dest = "法国公园旧址";
    //Denali-140:Waypoint button
    public static String tc140origin = "31.237871, 121.485815";
    public static String tc140input = "肯德基";

    // //Denali-147:Exit POI info update
    // public static String tc147origin = "37.418719,-121.969588";
    // public static String tc147Dest = "37.421964,-121.931928";
    // //Denali-150:GRC - highway
    // public static String tc150origin = "37.425967,-121.916715";
    // //Denali-154:RGC - Unnamed road
    // public static String tc154origin = "37.384033,-122.014599";
    // public static String tc235expected="950 Deguigne Dr";
    // //Denali-211:Generic 2.5D landmarks
    public static String tc211origin = "31.239712, 121.499777";
    //  Denali-217:Current street name display-unnamed road
    public static String tc217origin = "31.220985,121.318999,65";
    public static String tc217dest = "华苑迎宾馆";
    public static String tc217expect = "北翟高架路出口";

    //Denali-227:Drive time to home/work - change preferred route
    public static String tc227origin = "31.223819,121.461733";
    public static String tc227home = "上海市浦东区川北公路3087弄18号";

    // Denali-230:Add by Map
    public static String tc230origin = "31.239712, 121.499777";
    // Denali-231:Day color
    public static String tc231origin = "31.239712, 121.499777";
    // Denali-232:Night color
    public static String tc232origin = "31.239712, 121.499777";
    // Denali-235:Set Home Address
    public static String tc235origin = "31.239712, 121.499777";
    public static String tc235input = "上海市浦东区川北公路3087弄18号";
    public static String tc235expected = "上海市浦东区川北公路3087弄18号";

    //Denali-236:Set Home Address
    public static String tc236input = "中国山东青岛中山路146号";
    //Denali-260:JV show timing-Hwy -> Ramp -> Ramp -> Hwy
    public static String tc260origin = "31.249957,121.222866";
    public static String tc260dest = "31.237118,121.240567";
    // //Denali-261:JV show timing-Hwy -> Ramp -> Ramp -> Local
    // public static String tc261origin ="37.491508,-122.219516";
    // public static String tc261dest = "37.487085,-122.216540";
    // //Denali-262:JV show timing-Local -> Ramp -> Ramp -> Hwy
    // public static String tc262origin ="37.415222,-122.078076";
    // public static String tc262dest = "37.417201,-122.087073";
    // //Denali-263:JV show timing-Local -> Ramp -> Ramp -> Local
    // public static String tc263origin ="37.400990,-121.909490";
    // public static String tc263dest = "37.400759,-121.909976";
    //Denali-264:JV show timing- Ramp -> Ramp -> Hwy
    public static String tc264origin = "31.399719,121.419921";
    public static String tc264dest = "31.394483,121.424360";
    //Test case name:Denali-265:JV show timing- Hwy -> Hwy
    public static String tc265origin = "40.002076,116.451366";
    public static String tc265dest = "40.015078,116.465170";

    // //Denali-266:JV show timing- Hwy -> Local
    // public static String tc266origin ="35.296288,-85.151009";
    // public static String tc266dest = "35.304060,-85.147569";

    //// Denali-267: Static ETE - Destination
    public static String tc267origin = "39.908868,116.400205";
    public static String tc267dest = "北京首都国际机场";
    public static String tc267exp = "首都国际机场";
    public static int tc267Lower = 20;
    public static int tc267expUpper = 40;

    // //Denali-286:Fastest route
    public static String tc286origin = "31.193485,121.325241";
    public static String tc286input = "北京首都国际机场";
    public static String tc286expect = "北京首都国际机场";

    // Denali-293:Route type inherit - Route option
    public static String tc293origin = "39.985746,116.327802";
    public static String tc293dest = "朝阳区798路";
    public static String tc293exp = "798路";

    // Denali-294:Route type inherit - Add waypoint
    public static String tc294origin = "32.059111,118.780882";
    public static String tc294dest = "长江大桥";
    public static String tc294exp = "南京长江大桥";
    public static String tc294Wp = Fuel;

    // Denali-295:Route type inherit - Remove waypoint
    public static String tc295origin = "31.218251, 121.400824";
    public static String tc295dest = "古北路  玉屏南路";
    public static String tc295exp = "仙城加油站";

    // //Denali-295:Route type inherit - Remove waypoint
    // public static String tc295searchText ="927 Kifer Rd,Sunnyvale,CA 94086";
    // public static String tc295MatchText ="927 Kifer Rd";
    // //Denali-296:Route overview
    public static String tc296origin = "34.746406, 113.628661";
    public static String tc296dest = "32.058121, 118.790677";
    // // Denali-297:Across country
    public static String tc297origin = "51.507350,-0.127759";
    public static String tc297dest = "50.951411,1.856697";
    // // Denali-298:Across state
    // public static String tc298origin = "43.003750,-87.883737";
    // public static String tc298SearchText = "San Francisco,CA";

    // Denali-299:Across city
    public static String tc299origin = "30.274141,120.155411";
    public static String tc299SearchText = "北京市";

    // //Denali-300:In one city
    public static String tc300origin = "23.396074,113.306144";
    public static String tc300dest = "广州";

    // Denali-301:One way street - Pass
    public static String tc301origin = "31.230721,121.480643";
    public static String tc301SearchText = "程裕新茶号";
    public static String tc301ExpectedSearchResult = "上海麦卡森医药有限公司";
    public static String[] tc301ExpectedRoute = {"广西北路", "广东路", "浙江中路"};

    //Denali-302:Roundabouts - From
    public static String tc302Origin = "38.922310,121.644206";//大连
    // Circle
    public static String tc302Destination = "向日葵日式拉面";
    public static String tc302Destination2 = "韩裕烧烤";
    // public static String[] tc302ExpectedSearchResult = {"101 Crespi Dr","426
    // Font Blvd"};
    //Denali-303:Roundabouts - To
    public static String tc303Origin = "38.924374,121.640855";
    public static String tc303SearchText = "向日葵日式拉面";//Juan
    // Bistista Circle
    // public static String tc303Destination = "Juan Bautista Cir";
    // //Denali-304:Roundabouts - Pass
    public static String tc304origin = "34.340979,108.941536";
    public static String tc304dest = "34.340973,108.952028";
    public static String[][] tc304NextStInfo = {{"Castle Street Roundabout", "EnterAhead"},
            {"Castle Street", "ExitLeft"}};
    // //Denali-305:Tunel - From
    public static String tc305Origin = "36.015627,120.291055";
    public static String tc305SearchText = "中国山东青岛中山路146号";
    // public static String tc305ExpectedSearchResult = "21 Old Tunnel Rd";
    //Denali-306:Tunel - To
    public static String tc306Origin = "35.980673,120.272054";
    public static String tc306SearchText = "青岛胶州湾隧道";
    public static String tc306ExpectedSearchResult = "青岛胶州湾隧道";
    public static String tc306Destination = "青岛胶州湾隧道";
    //Denali-308:Ferry - From
    public static String tc308Origin = "36.051046,120.253712";
    public static String tc308SearchText = "中国山东青岛中山路146号";
    //public static String tc308ExpectedSearchResult = "刘公岛路";
    // //Denali-309:Ferry - To
    public static String tc309Origin = "36.066232,120.304256";
    public static String tc309SearchText = "青岛黄岛渡轮";
    public static String tc309ExpectedText = "黄岛轮渡站";
    // public static String tc309Destination = "Cape May-Lewes Fry";
    //Denali-311:Airport - From
    public static String tc311Origin = "31.144764,121.809611";
    public static String tc311SearchText = "清真伊兰特牛肉面";
    //public static String tc311ExpectedSearchResult = "754 7th Ave";
    //Denali-312:Airport - To
    public static String tc312Origin = "31.185605,121.747260";
    public static String tc312SearchText = "上海浦东国际机场";
    public static String tc312ExpectedSearchResult = "上海浦东国际机场";

    // public static String tc312Destination = "San Francisco Int'l Airport";
    //Denali-316:Park - To
    public static String tc316Origin = "31.176237,121.753501";
    public static String tc316SearchText = "上海地质科普公园";
    public static String tc316ExpectedSearchResult = "上海地质科普公园";
    // //public static String tc316Destination = "540 N Fair Oaks Ave";
    // public static String tc316Destination ="Fair Oaks Park";
    // //Denali-318:Closed Rd - To
    public static String tc318origin = "31.205898,121.398409";
    public static String tc318dest = "31.234962,121.475948";

    //Denali-325:Long route > 2000 mi
    public static String tc325Origin = "31.176237,121.753501";
    public static String tc325SearchText = "甘肃省兰州市";
    public static String tc325ExpectedSearchResult = "兰州市";
    public static int tc325Distance = 2000;
    //Denali-336:To vehicle position - On road
    public static String tc336Origin = "31.177640,121.777906";
    public static String tc336dest = "上海地质科普公园";
    // // Denali-341:Avoid fail - Preferences setting
    // public static String tc341origin = "37.390049,-122.030354";
    // public static String tc341SearchText ="37.397810,-122.022943";
    // //Denali-345:Time Restricted Turn - On restricted time
    // public static String tc345Origin ="42.378251,-83.014251";
    // public static String tc345SearchText ="42.378056,-83.015165";

    //Denali-357:Legal routing - Left turn restricted
    public static String tc357Origin = "41.76965,123.39925";
    public static String tc357SearchText = "沈阳市玉器厂";
    public static String tc357ExpectedSearchResult = "和平南大街100号";

    // //Denali-358:Add by Address
    public static String tc358origin = "31.206376,121.398765";
    public static String tc358dest = "清真伊兰特牛肉面";

    // Denali-359:Add by POI
    public static String tc359Origin = "31.206376,121.398765";
    public static String tc359Destination = "仙城加油站";
    public static String tc359Waypoint = "华辉加油站";
    //Denali-361:Add by recent places
    public static String tc361Origin = "31.206376,121.398765";
    public static String tc361SearchText = "古北路与天山路交叉口";
    // //Denali-362:Start Route
    public static String tc362origin = "39.918820,116.440982";
    public static String tc362dest = Fuel;
    // //Denali-367:Current street name in Guidance
    public static String tc367origin = "31.205883,121.398369,90";
    public static String tc367dest = "天山路古北路";
    public static String[] tc367ExpectedSt = {"仙霞路", "古北路"};
    // Denali-368:Next maneuver card - next street name
    public static String tc368origin = "31.208683,121.400616,0";
    public static String tc368dest = "31.211617,121.394708";
    public static String[] tc368ExpectedNextSt = {"茅台路", "芙蓉江路"};
    // // Denali-370:Dest arrival-on route
    public static String tc370origin = "31.205862, 121.398304";
    public static String tc370dest = "31.205937, 121.403170";

    //Denali-372:Add waypoint when arrive dest
    public static String tc372origin = "31.240260, 121.450476";
    public static String tc372dest = "上海市闸北区天目西路307-1";
    public static String tc372wpType = Fuel;
    // //Denali-374:The flag display when dest arrival
    // public static String tc374dest = "289 Santa Ana Ct";
    // //Denali-375:Cancel route
    public static String tc375origin = "29.555321,106.549453";
    public static String tc375dest = Fuel;

    //Denali-379:MAX waypoints
    public static String tc379origin = "31.237871, 121.485815";
    public static String tc379dest = "肯德基";
    public static String tc379wp1Type = Food;
    public static String tc379wp2 = "浙江省杭州市";
    public static String tc379wp2expect = "杭州市";
    public static String tc379wp3 = "中国石油";
    public static String tc379wp5 = "北京市";
    public static String tc379wp5expect = "北京市公安局 | 北京";

    //Denali-380:Add waypoint before arrive waypoint/dest
    public static String tc380origin = "31.240260, 121.450476";
    public static String tc380dest = "肯德基";
    public static String tc380wp = "上海第三加油站";
    public static String tc380wp1 = "常德路加油站";
    //Denali-381:Delete Waypoint
    public static String tc381origin = "31.240260,121.450476";
    public static String tc381dest = "肯德基";
    public static String tc381wp = "上海第三加油站";
    public static String tc381wp1 = "常德路加油站";

    //Denali-382:Delete all waypoints continuously
    public static String tc382origin = "31.240260, 121.450476";
    public static String tc382dest = "肯德基";
    public static String tc382wp = "晋元加油站";
    public static String tc382wp1Type = Food;
    public static String tc382wp1 = "红运小吃";
    public static String tc382wp2 = "常德路加油站";

    //Denali-383:Reorder Waypoints
    public static String tc383origin = "31.240260, 121.450476";
    public static String tc383dest = "肯德基";
    public static String tc383nwp = "晋元加油站";
    public static String tc383wp1Type = Food;
    public static String tc383wp1 = "红运小吃";
    public static String tc383wp2 = "常德路加油站";

    // Denali-384:Cancel route when arrive waypoint
    public static String tc384Origin = "31.198768,121.448187";
    public static String tc384Destination = "威宁饭店";
    public static String tc384Waypoint = "中国石化宛平路第2加油站";

    // //Denali-388:Waypoint arrival-on route
    public static String tc388origin = "31.214972, 121.385330,180";
    public static String tc388dest = "星巴克咖啡(万都店)";
    public static String tc388wp = "威宁饭店";
    public static String tc388category = Food;

    //Denali-390:Add waypoint after arrive waypoint
    public static String tc390origin = "31.240260, 121.450476";
    public static String tc390dest = "肯德基";
    public static String tc390wp = "上海第三加油站";
    public static String tc390wp1 = "常德路加油站";

    //Denali-396:Legal routing - Right turn restricted
    public static String tc396Origin = "31.216368,121.375095";
    public static String tc396Dest = "人寿堂国药";

    // Denali-399:Maneuver arrow
    public static String tc399origin = "31.242133,121.541039";
    public static String tc399dest = "31.244833,121.542392";
    public static String[][] tc399expect = {{"浦东大道", "右转"}};

    // //Denali-404:Sub panel - tight turn
    public static String tc404origin = "31.208403,121.409078,270";
    public static String tc404dest = "31.210722, 121.406296";
    public static String tc404expTurnType1 = "TurnRight";
    public static String tc404expStreet1 = "天山路";
    public static String tc404expTurnType2 = "TurnRight";
    public static String tc404expStreet2 = "天山路";

    // Denali-405:ETA-Wpt and Dest in same Timezone
    public static String tc405origin = "31.210942,121.405526";
    public static String tc405dest = "翰林碳烤";
    public static String tc405category = Food;
    public static String tc405wp = "麦当劳";

    //Denali-410:ETA to Destination
    public static String tc410origin = "31.210942,121.405526";
    public static String tc410dest = "翰林碳烤";
    //Denali-411:ETA with one Waypoint
    public static String tc411origin = "31.210942,121.405526";
    public static String tc411dest = "上海浦东国际机场";
    public static String tc411category = Food;
    public static String tc411wp = "红翻天湖北菜";
    //Denali-412:ETA with Dest Change
    public static String tc412origin = "31.210942,121.405526";
    public static String tc412dest = "上海浦东国际机场";
    public static String tc412category = Food;
    public static String tc412newDest = "红翻天湖北菜";

    // //Denali-418:ETE to Destination
    public static String tc418origin = "39.908700,116.397448";
    public static String tc418dest = "北京首都国际机场";
    public static String tc418expect = "北京首都国际机场";
    public static int tc418minete = 28;
    public static int tc418maxete = 50;
    // Denali-419:ETE with one Waypoint
    public static String tc419origin = "31.210942,121.405526";
    public static String tc419unit = "分钟";
    public static String tc419dest = "肯德基";
    public static String tc419category = Food;
    public static String tc419wp = "红翻天湖北菜";
    //Denali-420:ETE with Dest Change
    public static String tc420origin = "31.210942,121.405526";
    public static String tc420dest = "上海浦东国际机场";
    public static String tc420category = Food;
    public static String tc420wp = "红翻天湖北菜";
    public static String tc420unit = "分钟";
    //Denali-421:ETE with Waypoint Change
    public static String tc421origin = "31.210942,121.405526";
    public static String tc421dest = "上海浦东国际机场";
    public static String tc421category1 = Food;
    public static String tc421wp1 = "红翻天湖北菜";
    public static String tc421category2 = Fuel;
    public static String tc421wp2 = "76";

    //Denali-459:Sub panel - lane guidance
    public static String tc459origin = "31.169565,121.511378";
    public static String tc459dest = "31.173699,121.517452";

    //Denali-470:Delete favorite from favorite list
    public static String tc470origin = "31.205889,121.398181";
    public static String tc470input = "上海市浦东区川北公路3087弄18号";

    // //Denali-491:Left turn on Local Street
    // public static String tc491origin = "37.381016,-122.014760,90";//set
    // vehicle direction to east
    // public static String tc491Dest = "37.382209,-122.007219";
    // //Denali-473:Start Route Guidance - between info range and 1st guidance
    // public static String tc473origin = "37.459414,-121.924161";
    // public static String tc473dest = "37.486500,-121.932776";
    // // Denali-477:Start Route Guidance - between 2nd and 3rd guidance
    // public static String tc477origin = "37.380015,-122.010533";
    // public static String tc477Dest = "37.380906,-122.007712";
    //Denali-505:Highway Entrance - slight right
    //public static String tc505origin = "31.158536,121.691791";
    //public static String tc505Dest = "31.169594,121.702110";
    // //Denali-515:Highway-to-road Exit - take exit on the right
    // public static String tc515origin = "37.403973,-122.051116";
    // public static String tc515Dest = "37.394500,-122.029047";
    // //Denali-522:Highway transition - take exit on the right
    // public static String tc522origin = "37.393217,-122.048672";
    // public static String tc522Dest = "37.398194,-122.024874";
    // // Denali-552:Dest arrival-on the left
    // public static String tc552origin = "37.380902,-122.008855";
    // public static String tc552dest = "1145 E Arques Ave Sunnyvale,CA 94085";

    // Denali-558:Search History list-one box search
    public static String tc558input = "上海兴业路123弄";
    // Denali-561:Select from Search History List
    public static String tc561input = "加油站";

    // //Denali-583:RGC - CAN
    // public static String tc583origin = "43.676396,-79.401367";
    // //Denali-584:RGC - MEX
    // public static String tc584origin = "25.688738,-100.317290";

    // Denali-586:Maneuver arrow _ U-turn
    public static String tc586origin = "31.226377,121.553273";
    public static String tc586dest = "31.226423,121.553015";
    // //Denali-587:Turn icon - Roundabout
    public static String tc587origin = "31.234484,121.501372,0";
    public static String[] tc587dest = {"31.237518,121.502219", "31.240295,121.502327", "31.239807,121.497915", "31.237330,121.498584", "31.236429,121.500339"};
    // Denali-588:Turn icon - U-turn
    public static String tc588origin = "31.210942,121.405526,270";
    //public static String tc588dest = "31.211214,121.402978";
    public static String tc588dest = "翰林碳烤";
    public static String tc588expect = "LeftUTurn";
    // Denali-589:Turn icon - Vehicle is off road
    public static String tc589origin = "31.181328,121.781826";
    public static String tc589dest = "上海地质科普公园";
    public static String tc589expect = "TurnLeft";
    // //Denali-590:Valid Postcode+unrelated country
    // public static String tc590input = "12345 USA";
    // Denali-591:next maneuver card - distance update
    public static String tc591origin = "31.205845,121.396196,90";
    public static String tc591dest = "茅台路芙蓉江路";
    // Denali-592:Destination icon direction
    public static String tc592origin = "31.206203,121.400184,0";
    public static String tc592destLeft = "31.211018,121.400295";
    public static String tc592destRight = "31.210452,121.401089";
    public static String tc592destAhead = "31.209849,121.400596";
    public static String tc592expectAhead = "LocationAhead";
    public static String tc592expectLeft = "LocationLeft";
    public static String tc592expectRight = "LocationRight";

    //Denali-606:Brand POI name
    public static String tc606input = "肯德基";
    public static String[] tc606expect = {"肯德基"};
    public static String tc606origin = "31.205889,121.398181";

    // //Denali-607:POI category
    public static String tc607input = "肯德基";

    //Denali-608:POI name
    public static String tc608input = "ATM";
    public static String[] tc608expect = {"ATM"};
    public static String tc608origin = "31.205889,121.398181";

    //Denali-609:Airport code
    public static String tc609input = "PVG";
    public static String[] tc609expect = {"PVG", "上海浦东国际机场"};
    public static String tc609origin = "31.205889,121.398181";

    //Denali-613:Avoid Freeway = OFF
    public static String tc613origin = "31.205889,121.398181";
    public static String tc613input = "上海浦东国际机场";
    public static String tc613expected = "上海浦东国际机场";
    public static String tc613road = "内环高架路";

    //Denali-614:Avoid Freeway/Motorway = ON
    public static String tc614origin = "30.429536,120.270442";
    public static String tc614dest = "上海地质科普公园";
    public static String tc614expected = "S11";

    //:Denali-615:Avoid Toll Road = OFF
    public static String tc615origin = "30.733921,120.869274";
    public static String tc615input = "上海地质科普公园";
    public static String tc615expected = "G60";

    //Denali-616:Avoid Toll Road = ON
    public static String tc616origin = "30.733921,120.869274";
    public static String tc616input = "上海地质科普公园";
    public static String tc616expected = "G60";

    // Denali-630:Dest icon - dest is off road
    public static String tc630dest = "虹桥公园(东二门)";

    //Denali-633:Traffic display = OFF
    public static String tc633origin = "31.205972, 121.396975";

    //Denali-634:Traffic display = ON
    public static String tc634origin = "31.205972, 121.396975";

    //Denali-635:Show timing-get route successfully
    public static String tc635origin = "31.206103,121.399277";
    public static String tc635dest = "浦东国际机场";

    // Denali-640:Route list info
    public static String tc640origin = "37.366168, -122.051775";
    public static String tc640dest = "831 Piper Ave";
    public static String tc640st1 = "Hanover Ave";
    public static String tc640st2 = "Elmira Dr";
    public static String tc640st3 = "Piper Ave";
    public static String[] tc640st1Dist = {"1046", "1066"};
    public static String[] tc640st2Dist = {"369", "389"};
    public static String[] tc640st3Dist = {"237", "257"};

    // Denali-653:Route display
    public static String tc653origin = "31.237871, 121.485815";
    public static String tc653dest = "肯德基(福建中路)";
    public static String tc653wp = "慧公馆(外滩店)";
    public static String tc653category = Food;
    // Denali-677:Route display
    public static String tc677origin = "30.274198,120.154545";
    public static String tc677dest = "上海市";

    //Denali-678:Traffic indicator - waypoint/dest
    public static String tc678origin = "31.237871, 121.485815";
    public static String tc678input = "肯德基";


    //Denali-681:3D Heading up display
    public static String tc681origin = "31.206103,121.399277";

    //Denali-682:2D Heading up display
    public static String tc682origin = "31.206103,121.399277";

    //Denali-683:2D North up display
    public static String tc683origin = "31.206103,121.399277";

    //Denali-684:Preferred Route = Fastest
    public static String tc684origin = "31.230107,121.474725";
    public static String tc684dest = "上海地质科普公园";

    // //Denali-695:Demo route
    public static String tc695origin = "31.230107,121.474725";
    public static String tc695dest = "肯德基";

    //Denali-697:Cancel demo
    public static String tc697input = "31.230107,121.474725";
    public static String tc697expected = "上海地质科普公园";

    // //Denali-698:POI Name
    // public static String tc698input = "KFC";
    // public static String tc698expected = "KFC";


    // //Denali-704:POI Name+in+city+state
    public static String tc704origin = "31.205824,121.395309";
    public static String tc704input = "星巴克  上海";
    public static String tc704expect = "星巴克咖啡(上海影城店)";
    public static String tc704expectAddr = "长宁区 新华路160号";
    // //Denali-705:POI Name+of+state+country
    // public static String tc705input = "Shell of CA USA";
    // public static String tc705expected = "Shell";
    // // Denali-706:POI Name+near+city+postcode
    // public static String tc706input = "Costco near Sunnyvale 94085";
    // public static String tc706expected = "Costco"; //add logic < 6 miles
    // // Denali-715:Chain POI name+near by+city
    // public static String tc715input = "starbucks near by Sunnyvale";
    // public static String tc715expected = "Starbucks"; //add logic < 6 miles
    // //Denali-717:Chain POI name+In+postcode
    public static String tc717origin = "51.507350,-0.127759";
    public static String tc717input = "starbucks in W1K 6JL";
    public static String tc717expect = "Starbucks"; // add logic < 6 miles
    // //Denali-719:Landmarks
    public static String tc719origin = "51.507350,-0.127759";
    public static String tc719input = "Tower Bridge";
    public static String tc719expect = "Tower Bridge";
    // // Denali-720:Airport Name
    // public static String tc720input = "San Francisco International Airport";
    // public static String[] tc720expected = {"San Francisco Int'l
    // Airport","San Francisco International Airport","San Francisco Int'l
    // Airport (SFO)"}; //use exact
    // //Denali-721:Alias name-Airport code
    public static String tc721origin = "31.144330,121.808109";
    public static String tc721input = "PVG";
    public static String tc721expect = "上海浦东国际机场"; // use exact
    // //Denali-728:Search super category
    // public static String tc728input = "ATM";
    // public static String[] tc728expected = {"Chase","Wells Fargo","Bank of
    // America"};
    // //Denali-731:Super Category+near+city
    // public static String tc731input = "hotel near Milpitas";
    // public static String[] tc731expected = {"Hilton Garden Inn","Staybridge
    // Suites","Days Inn"};
    // //Denali-733:Super Category+of+postcode
    // public static String tc733input = "park of 94085";
    // public static String[] tc733expected = {"Fair Oaks Park","Columbia
    // Park","Lakewood Park"};
    // //Denali-734:Sub category+NEAR+city+country
    public static String tc734origin = "51.507350,-0.127759";
    public static String tc734input = "Italian food near London UK";
    public static String tc734expect = "Bocca di Lupo & Polpo Soho & Trullo Dei Sapori";
    // // Denali-735:Sub category+in+state+country
    // public static String tc735input = "Burgers in CA USA";
    // public static String[] tc735expected = {"McDonald's","In-N-Out Burger"};
    // // Denali-737:GM dealership
    // public static String tc737input = "GM dealership";
    // public static String tc737expected = "GM";//need revisit with returned
    // format

    // Denali-740:Sort by relevance
    public static String tc740origin = "34.343841,108.943270";
    public static String tc740input = "城市公园";
    public static String tc740expect = "西安城市运动公园|西安城市运动公园(南门)|天朗城市公园";

    // Denali-740:Sort by distance
    public static String tc741origin = "34.343841,108.943270";
    public static String tc741input = "城市公园";

    // //Denali-748:State+Postcode
    public static String tc748origin = "34.259489,108.948769";
    public static String tc748input = "710003,陕西省";
    public static String tc748expect = "西安市";
    // //Denali-750: Postcode
    // public static String tc750input = "94102";
    // public static String[] tc750expected ={ "San Francisco","San
    // Francisco,CA","San Francisco,CALIFORNIA"};//Onboard/Offboard
    // //Denali-751:City
    public static String tc751origin = "31.206363,121.398743";
    public static String tc751input = "上海";
    public static String tc751expect = "上海市";
    // //Denali-754:City+State+Country
    // public static String tc754input = "San Francisco CA USA";
    // public static String[] tc754expected = {"San Francisco,CA","San
    // Francisco"}; //Onboard/Offboard
    // //Denali-756:City+State+Postcode
    // public static String tc756input = "San Francisco CA 94102";
    // public static String[] tc756expected = {"San Francisco,CA","San
    // Francisco,CALIFORNIA"};//Onboard/Offboard
    // //Denali-762:Subcity
    // public static String tc762input = "Etobicoke,Toronto,ON CAN M8Y";
    // public static String tc762expected = "Etobicoke"; //Need revisit for the
    // expectation
    // //Denali-770:Fuzzy search - Complete road type
    // public static String tc770input = "De guigne Drive";
    // public static String tc770expected = "De Guigne Dr";
    // //Denali-771:Fuzzy search - Street with directional prefix
    // public static String tc771input = "NW 9th St Oswego,NY USA";
    // public static String tc771expected = "NW 9th St";
    // //Denali-775:Interval char - Comma
    // public static String tc775input = "950,De guigne Dr,Sunnyvale,CA,94085";
    // public static String tc775expected = "950 De Guigne Dr";
    // // Denali-776:Street
    // public static String tc776input = "De guigne Dr";
    // public static String tc776expected = "De Guigne Dr";
    // // Denali-777:Street+IN+City
    public static String tc777origin = "51.507350,-0.127759";
    public static String tc777input = "A4207 in London";
    public static String tc777expect = "A4207";
    // //Denali-780:Street+City+State+Country
    // public static String tc780input = "Panchita Way Los Altos CA USA";
    // public static String tc780expected = "Panchita Way";
    // //Denali-784:Street+City+Postcode
    // public static String tc784input = "1st St San Francisco 94107";
    // public static String tc784expected = "1st St";
    // //Denali-787:Door Number+Street
    public static String tc787origin = "51.507350,-0.127759";
    public static String tc787input = "10 Beak St";
    public static String tc787expect = "10 Beak St | 10 Beak Street";
    // //Denali-788:Door Number+Street+City
    // public static String tc788input = "950 De guigne Dr Sunnyvale";
    // public static String[] tc788expected = {"950 Deguigne Dr","950 De Guigne
    // Dr"}; //Onboard/Offboard
    // //Denali-790:Door Number+Street+State+Postcode
    // public static String tc790input = "1 1st St CA 94107";
    // public static String tc790expected = "1 1st St";
    // //Denali-807:Out of range door number
    // public static String tc807input = "10000 Kifer Rd Sunnyvale CA";
    // public static String tc807expected = "Kifer Rd"; //Need review the
    // expectation
    // //Denali-809:Lat/lon search - Common
    // public static String tc809origin = "37.37890,-122.01074";
    public static String tc809input = "51.516223,-0.206360";
    public static String tc809expect = "65 Kensington Park Road";
    // //Denali-815:Str1+Str2+Of+Postcode
    // public static String tc815input = "1st St Howard St 94107";
    // public static String tc815expected = "1st St";
    // //Denali-821:Str1+at+Str2
    // public static String tc821input = "1st St at Howard St"; //Near SF.
    // public static String tc821expected = "1st St";
    // //Denali-824:Str1+at+Str2+State+Postcode
    public static String tc824origin = "31.205879,121.398700";
    public static String tc824input = "仙霞路 古北路";
    public static String tc824expect = "仙霞路古北路";
    // // Denali-828:Str1+and+Str2+In+City+State
    // public static String tc828input = "1st St at Howard St near San Francisco
    // CA";
    // public static String tc828expected = "1st St";
    // // Denali-835:Str1+@+Str2+of+State+Country
    // public static String tc835input = "1st St @ Howard St of CA USA";
    // public static String tc835expected = "1st St";
    // //Denali-836:Multiple Intersections
    // public static String tc836input = "camden sierra at otay rnch fieldbrook
    // st,ca";
    // public static String tc836expected = "Camden Sierra at Otay Rnch";
    // //Denali-838:Intersection_Roundabout With/Without Name
    // public static String[] tc838input = {"Juan Bautista Cir and Font Blvd in
    // San Francisco","Serrano Dr and Font Blvd in San Francisco"};
    // public static String[] tc838expected = {"Juan Bautista Cir","Serrano
    // Dr"};
    // Denali-841:Enter space
    public static String tc841origin = "31.205906,121.400109";
    // //Denali-852:Search category
    public static String tc852origin = "31.205824,121.395309";
    public static String tc852input = Fuel;
    public static String tc852expect = "仙城加油站&武夷路加油站";
    // //Denali-854:Search result detailed info
    public static String tc854origin = "51.507350,-0.127759";
    public static String tc854input = Fuel;

    //Denali-860:View result list - scroll
    public static String tc860origin = "31.154036,121.630976";
    public static String tc860dest = "肯德基";
    public static String tc860itemName = "^肯德基.*";
    public static String tc860itemCategory = "^快餐*";
    public static String tc860itemStreet = ".+";

    // Denali-861:Preferred Route = ECO
    public static String tc861origin = "31.230107,121.474725";
    public static String tc861dest = "上海地质科普公园";

    // Denali-862:Search result - Drive time without guidnace
    public static String tc862origin = "31.154036,121.630976";
    public static String tc862searchtext = "PVG";
    public static String tc862searchresult = "上海浦东国际机场";

    // Denali-867:Scroll map on search result list
    public static String tc867origin = "31.205972,121.396975";

    // //Denali-920:Current vehicle position-unnamed
    // public static String tc920origin = "37.385546,-122.014443";
    // Denali-921:Auto zoom timing - local road
    public static String tc921origin = "31.211552,121.400798,90";
    public static String tc921dest = "31.207386,121.406868";
    public static int tc921metric = 240;
    // //Denali-922:Auto zoom for highway
    // public static String tc922origin = "37.316638,-121.946544";
    // public static String tc922dest = "37.309835,-121.940705";
    //Denali-924:Restore Zoom scale - highway
    public static String tc924origin = "31.182695,121.738980";
    public static String tc924dest = "上海地质科普公园";
    //Denali-925:Dest Drive To Current Dest Sign
    public static String tc925origin = "31.182697,121.775560";
    public static String tc925dest = "上海地质科普公园";
    public static String tc925expect = "行驶至上海地质科普公园";
    // //Denali-926:Arrival message-Destination
    // public static String tc926dest = "289 Santa Ana Ct";

    // Denali-935:EJV(Enhanced Junction View
    public static String tc935origin = "31.219436,121.471844";
    public static String tc935dest = "31.227053,121.475772";

    //Denali-936:GJV(Generic Junction View)
    public static String tc936origin = "31.120958,121.130985";
    public static String tc936dest = "31.135352,121.157611";
    //Denali-937:SAR(Sign As Real)
    public static String tc937origin = "40.007040,116.452985";
    public static String tc937dest = "40.015078,116.465170";
    // //Denali-938:GMS(Generic Motorway Signs)
    // public static String tc938origin = "38.88038,-77.12461";

    // Denali-939:Lane Guidance show timing - Highway
    public static String tc939origin = "40.002076,116.451366";
    public static String tc939dest = "40.015078,116.465170";
    //Denali-942:Correct number of lanes
    public static String tc942origin = "31.224235,121.535089,300";
    public static String tc942dest = "31.224207, 121.530884";
    public static int tc942ln = 5;// (left turn)|(straight)|(straight)|(straight
    // and right turn)

    // Denali-943:Lane guidance display timing - Major road
    public static String tc943origin = "39.992758,116.334223,90";
    public static String tc943dest = "佛教文化期刊社";
    public static String tc943expaudio = "前方 五百米 在下一个路口 右转 进入 学院路";

    // //Denali-948:Lane guidance type Continue and Left //(left
    // turn)|(straight)|(straight)|(straight )
    // public static String tc948origin ="37.378581,-122.013014,180";
    // public static String tc948dest = "37.377190,-122.010213";
    // //Denali-949:Lane guidance type Continue and Right //(straight)|(right )
    // public static String tc949origin = "37.788730,-122.402132,180";
    // public static String tc949dest = "37.787996,-122.403419";
    //Denali-951:Lane guidance type Right //right | right
    public static String tc951origin = "31.217836,121.472443";
    public static String tc951dest = "31.218431,121.475986";
    // //Denali-954:Lane guidance type Left Uturn
    // public static String tc954origin = "37.352298,-122.005128,270";
    // public static String tc954dest = "37.352104,-122.007821";
    // //Denali-956:Lane guidance type Left and Right
    // public static String tc956origin = "37.771447,-122.510272,270";//set
    // vehicle direction to west
    // public static String tc956dest = "37.770506,-122.511003";
    // //Denali-957:Lane guidance type Continue and Left and Right//(left
    // turn)|(straight)|(straight)|(right )
    // public static String tc957origin = "41.852622,-87.628448,90";//set
    // vehicle direction to east
    // public static String tc957dest = "41.852052,-87.627097";

    //Denali-962:Route Type Preferences
    public static String tc962origin = "31.232717,121.529601";
    // Denali-964:Route Overview
    public static String tc964origin = "31.168273,121.698112";
    public static String tc964dest = "上海浦东国际机场";

    //  Denali-965:Recenter around destination
    public static String tc965input = "北京机场";
    //Denali-969:End navigation
    public static String tc969origin = "31.232717,121.529601";
    public static String tc969input = "肯德基";
    // Denali-987:Zoom out before auto zoom
    public static String tc987origin = "31.178599,121.768927";
    public static String tc987dest = "上海地质科普公园";
    public static int tc987metric = 800;
    //Denali-988:Zoom out after auto zoom
    public static String tc988origin = "31.177901,121.765575";
    public static String tc988dest = "上海地质科普公园";
    public static String tc988manuever = "晨阳路";
    // //Denali-997:Vehicle icon menu - Home/Work are set up
    public static String tc997origin = "31.232717,121.529601";
    // public static String tc997home = "上海市 浦东新区，松林路88弄";
    public static String tc997home = "31.211272, 121.395411";
    public static String tc997work = OfficeLatLon;
    //Denali-1008:Back
    public static String tc1008origin = "31.237871, 121.485815";
    public static String tc1008input = "肯德基";
    //Denali-1012:Zoom in/out button - Disappear
    public static String tc1012origin = "31.237871, 121.485815";
    //Denali-1013:Route View - Display in guidance
    public static String tc1013origin = "31.237871, 121.485815";
    public static String tc1013input = "肯德基";
    // Denali-1016:Avoid pop up info
    public static String tc1016origin = "31.185436,121.766051";
    public static String tc1016dest = "上海地质科普公园";
    public static String tc1016avoid = "圩华路";
    //Denali-1017:Tight turn auto zoom
    public static String tc1017origin = "31.197556,121.589548";
    public static String tc1017dest = "31.209528,121.592024";
    public static String tc1017maneuver1 = "祖冲之路";
    public static String tc1017maneuver2 = "牛顿路";

    //Denali-1018:Waypoint Skip To Next Sign
    public static String tc1018origin = "31.214972, 121.385330,180";
    public static String tc1018dest = "星巴克咖啡(万都店)";
    public static String tc1018wp = "威宁饭店";
    public static String tc1018category = Food;
    public static String tc1018DriveTo = "行驶至星巴克咖啡(万都店)";
    //Test case name:Denali-1019:Show junction view on turn list
    public static String tc1019origin = "39.999426,116.450378";
    public static String tc1019dest = "40.015078,116.465170";
    // // Denali-1020:Show turn list on junction view
    // public static String tc1020origin = "37.434628,-121.918859";
    //Denali-1022:Resume trip bubble display - End trip
    public static String tc1022origin = "31.237871, 121.485815";
    public static String tc1022input = "肯德基";
    //Denali-1024:Waypoint pop up
    public static String tc1024origin = "31.237871, 121.485815";
    public static String tc1024dest = "肯德基";

    //Denali-1025:Add waypoint options-cancel
    public static String tc1025origin = "31.237871, 121.485815";
    public static String tc1025dest = "肯德基";
    public static String tc1025search = "晋元加油站";

    //Denali-1026:Add waypoint options-Add as Waypoint
    public static String tc1026origin = "31.237871, 121.485815";
    public static String tc1026dest = "肯德基";
    public static String tc1026wp = "中国石化黄埔第1加油站";

    //Denali-1027:Add waypoint options-Make new destination
    public static String tc1027origin = "31.237871, 121.485815";
    public static String tc1027dest = "肯德基";
    public static String tc1027wp = "晋元加油站";

    //Denali-1028:Add waypoint method
    public static String tc1028origin = "31.237871, 121.485815";
    public static String tc1028dest = "肯德基";
    public static String tc1028expect = "肯德基(福州店)";
    public static String tc1028wp = "晋元加油站";
    //Denali-1141:Back from home
    public static String tc1141input = Health;
    // // Denali-1050:Exit Amenities Icon - local road
    // public static String tc1050origin = "37.406358,-121.995664";
    // public static String tc1050Dest = "37.416818,-121.977421";
    // // Denali-1051:Exit Amenities Icon - highway
    // public static String tc1051origin = "37.410699,-121.991901";
    // public static String tc1051Dest = "37.418709,-121.969046"; //Exit 6 of
    // CA237
    // //Denali-1052:Exit Amenity List generic info
    // public static String tc1052origin = "37.404035,-122.021466";
    // public static String tc1052Dest = "37.411197,-121.989281";
    // // Denali-1053:Exit Amenity List - available POI info
    // public static String tc1053origin = "37.410699,-121.991901";
    // public static String tc1053Dest ="37.418822,-121.966675";
    // //Denali-1054:Seach exit POI
    public static String tc1054origin = "31.170044, 121.338961";
    public static String tc1054dest = "31.192361, 121.327093";
    public static String tc1054expectExit = "出口Railway Station";
    public static String[] tc1054ExpectedExitPOIType = {"Gas", "Restuarant"};


    // //Denali-1060:Waypoint edit view
    public static String tc1060origin = "23.125829,113.247523";
    public static String tc1060dest = "广州白云机场";
    public static String tc1060wp = "80 Cafe";

    // Denali-1072:Search along route - Category search
    public static String tc1072origin = "31.205879,121.396762";
    public static String tc1072dest = "仙霞路";
    public static String tc1072input = Fuel;
    public static String tc1072expect = "仙城加油站";

    // Denali-1090:Recent destination - Drive
    public static String tc1090origin = "31.205889,121.398181";
    public static String tc1090destination1 = "田林加油站";
    public static String tc1090destination2 = "凯燕加油站";
    //Denali-1092:Next/Previous page
    public static String tc1092input = "肯德基";

    //Denali-1094:Only one result
    public static String tc1094input = "31.248314, 121.400281";
    // Denali-1095:Sub panel display priority
    public static String tc1095origin = "39.182611,117.156869";
    public static String tc1095dest = "39.182970,117.160766";
    public static String tc1095originTight = "31.188618,121.412962";
    public static String tc1095destTight = "31.189581,121.409734";

    //Denali-1101:Rich data POI - Introduction
    public static String tc1101origin = "31.205979,121.396959";
    //public static String tc1101dest = "Yoga Tree, Valencia St, San Francisco, CA";

    // //Denali-1108:Set POI category to favorite
    public static String tc1108origin = "31.205979,121.396959";
    public static String tc1108expect = "阳光咖啡厅";
    //Denali-1117:Next maneuver card - waypoint/dest address info
    public static String tc1117origin = "31.182284,121.775747";
    public static String tc1117dest = "上海地质科普公园";

    //Denali-1118:Action - avoid waypoint
    public static String tc1118origin = "31.240260,121.450476";
    public static String tc1118dest = "肯德基";
    public static String tc1118wp = "上海第三加油站";

    //Denali-1119:Delete dest
    public static String tc1119origin = "31.240260,121.450476";
    public static String tc1119dest = "肯德基";
    public static String tc1119expect = "肯德基(恒丰路店)";
    public static String tc1119wp = "上海第三加油站";

    //Denali-1132:Result list - Close
    public static String tc1132input = "肯德基";

    //Denali-1133:Result list - Back
    public static String tc1133input = "肯德基";
    //Denali-1134:Detail info
    public static String tc1134input = "上海浦东国际机场";
    //Denali-1135:Detail info - Drive
    public static String tc1135input = "上海浦东国际机场";

    //Denali-1147:Route list - Back
    public static String tc1147origin = "31.237871, 121.485815";
    public static String tc1147input = "肯德基";
    //Denali-1148:Route list - Close
    public static String tc1148origin = "31.237871, 121.485815";
    public static String tc1148input = "肯德基";
    //Denali-1149:Route Edit - Back
    public static String tc1149origin = "31.237871, 121.485815";
    public static String tc1149input = "肯德基";
    //Denali-1150:Route Edit - Close
    public static String tc1150origin = "31.237871,121.485815";
    public static String tc1150input = "肯德基";
    //Denali-1153:Waypoint Edit - Back
    public static String tc1153origin = "31.237871,121.485815";
    public static String tc1153input = "肯德基";
    //Denali-1154:Waypoint Edit - Close
    public static String tc1154origin = "31.237871,121.485815";
    public static String tc1154input = "肯德基";
    public static String tc1154waypoint = "上海石油分公司第一加油站";
    //Denali-1158:Search - Close
    public static String tc1158origin = "31.237871,121.485815";
    public static String tc1158input = "肯德基";
    //Denali-1159:Back from home
    public static String tc1159origin = "31.139017,121.539659";
    public static String tc1159input = "上海浦东国际机场";
    public static String tc1159input1 = Fuel;
    //Denali-1161:Show POI icons on map
    public static String tc1161origin = "31.237871, 121.485815";
    // //Denali-1162:Hide all POI icons on map
    // public static String tc1162origin =originFromLocation;

    //Denali-1163:Brand icon
    public static String tc1163origin = "31.237871, 121.485815";
    //Denali-1167:Simple Arrival View-Destination
    public static String tc1167origin = "31.182697,121.775560";
    public static String tc1167dest = "上海地质科普公园";
    public static String tc1167expect = "上海地质科普公园";

    //Denali-1168:Simple Arrival View-Waypoint
    public static String tc1168origin = "31.239002,121.458551";
    public static String tc1168dest = "31.251579,121.451510";
    public static String tc1168category = Food;
    public static String tc1168wp = "麦当劳(恒丰路)";

    // Denali-1169:Waypoint/dest info-POI
    public static String tc1169origin = "31.240260,121.450476";
    public static String tc1169dest = "肯德基(恒丰路店)";
    public static String tc1169waypoint = "上海第三加油站";

    // Denali-1170:Next maneuver card - waypoint/dest POI info
    public static String tc1170origin = "31.209556,121.351105";
    public static String tc1170dest = "31.201904,121.369705";
    public static String tc1170category = Food;
    public static String tc1170wp = "强强菜饭馆";
    public static String tc1170expectWp = "上海市 长宁区 ";
    public static String tc1170expectTurn = "LocationRight";

    //Denali-1172:3D landmark Setting = OFF
    public static String tc1172origin = "31.232523,121.503092"; //陆家嘴

    // //Denali-1191:Add from one box search
    //public static String tc1191origin = "51.507350,-0.127759";
    //public static String tc1191dest = "25 Short St. London SE1 8LJ";
    //public static String tc1191recent = "Short Street";
    //public static String tc1191wp = "Starbucks";

    // Denali-1192:Add Waypoint to Recent
    public static String tc1192destination1 = "哈密路加油站";
    public static String tc1192destination2 = "中国石化强生虹井加油站";

    // //Denali-1193:Entries sort by Date and Time
    // public static String tc1193dest1 = "New York,NY";
    // public static String tc1193dest2 = "San Francisco Int'l Airport";
    // public static String tc1193dest3 = "Shell";

    // //Denali-1197:Hide selected POI icons on map
    public static String tc1197origin = "31.205889,121.398181";

    // Denali-1208:No results - No suggestion
    public static String tc1208input = "啊喔额";

    // Denali-1209:Dest arrival in turn list screen
    public static String tc1209origin = "31.205889,121.398181";
    public static String tc1209dest = "仙城加油站";

    // Denali-1210:Detailed recent info
    public static String tc1210origin = "31.205889,121.398181";
    public static String tc1210destination = "哈密路加油站";

    // Denali-1222:Set one box search to favorite
    public static String tc1222input = "上海市浦东区川北公路3087弄18号";

    //Denali-1226:Show Junction View over Exit POI
    public static String tc1226origin = "39.999426,116.450378";
    public static String tc1226Dest = "40.015078,116.465170";
    //Denali-1227:Keep Search page over Junction View
    public static String tc1227origin = "39.999426,116.450378";
    public static String tc1227dest = "40.015078,116.465170";
    // //Denali-1235:Change default zoom level NavigationMap
    // public static String tc1235origin = "37.437647,-121.919426";
    // public static String tc1235dest = "37.745787,-122.200759";

    // Denali-1242:Save Favorite from city search
    public static String tc1242input = "杭州市";
    public static String tc1242expected = "杭州市";
    // Denali-1243:Search Recent from One Box
    public static String tc1243origin = "31.205889,121.398181";
    public static String tc1243destination = "华江石油";
    public static String tc1243expected = "华江石油";

    // Denali-1245:Search history list - belong to Recent/Favorites/Contact
    public static String tc1245input = "上海市徐汇区, 宜山路280号";
    public static String tc1245expected = "上海市";

    // Denali-1246:Search History list - No result return
    public static String tc1246input = "!啊23喔!@#$";

    //Denali-1247:City name
    public static String tc1247input = "上海市";
    public static String[] tc1247expect = {"上海市"};
    public static String tc1247origin = "31.154036,121.630976";

    // Denali-1248:Street name
    public static String tc1248origin = "31.205889, 121.398181";
    public static String[] tc1248input = {"仙霞", "仙霞路"};

    //Denali-1249:Detali info - get route failed
    public static String tc1249origin = "31.205889, 121.398181";
    public static String tc1249dest = "23.498412,120.462408";

    //Denali-1250:Search result - Drive time with guidance
    public static String tc1250origin = "31.154036,121.630976";
    public static String tc1250searchtext = "PVG";
    public static String tc1250searchresult = "上海浦东国际机场";
    public static String tc1250coffee = "维迪莎咖啡";

    // Denali-1251:Search result - Distance
    public static String tc1251origin = "31.106008, 121.345343";
    public static String tc1251dest = "PVG";
    public static String tc1251destexpect = "上海浦东国际机场";

    //Denali-1253:Half screen buttons - Search
    public static String tc1253origin = "31.186904,121.754802";

    // Denali-1254:Half screen buttons - Guidance
    public static String tc1254origin = "31.186904,121.754802";
    public static String tc1254dest = "上海地质科普公园";

    // Denali-1255:Half screen buttons - Route
    public static String tc1255origin = "31.186904,121.754802";

    // Denali-1269:Next maneuver card - turn icon
    public static String tc1269origin = "31.211737,121.392653,90";
    public static String tc1269dest = "31.203760,121.395809";
    public static String[][] tc1269expect = {{"芙蓉江路", "TurnLeft"}, {"天山路", "TurnRight"}};

    // Denali-1446:Delete favorite from navigation app
    public static String tc1446origin = "31.203760,121.395809";
    public static String tc1446input = "清真伊兰特牛肉面";

    //Denali-1483:Alert of Railroad Crossing = ON - Approach
    public static String tc1483origin = "39.673680,118.409909";
    public static String tc1483dest = "39.67304,118.41260";
    // //Denali-1487:Turn right after landmark
    // public static String tc1487origin = "37.380701,-122.004244,270";
    // public static String tc1487dest = "37.383470,-122.013452";

    // Denali-1502:Save Favorite from POI brand name search
    public static String tc1502input = "肯德基";

    // Denali-1505:Select one from favorite list
    public static String tc1505input = "肯德基";

    // Denali-1506:Favorite list
    public static String tc1506origin = "肯德基(仙霞路店)";
    public static String tc1506origin2 = "星巴克咖啡（万都店）";

    //Denali-1596:3D Landmarks = ON
    public static String tc1596origin = "31.232523,121.503092"; //陆家嘴

    // Denali-1718:Current street name display-No vehicle access road
    public static String tc1718origin = "31.217957,121.320843";
    public static String tc1718dest = "上海市";

    // Denali-1935 : POI nearby
    public static String tc1935origin = "31.287194,121.175715";
    public static String tc1935input = "肯德基";
    public static String tc1935expect = "肯德基(安亭店)|肯德基(汽车城店)|肯德基(曹新路)";

    //Denali-1938:Nearby search by SZM
    public static String tc1938origin = "31.205792,121.398402";
    public static String tc1938input = "DFWJDS";
    public static String tc1938expect = "东方维京大厦";

    // Denali-1957:Landmark in whole country
    public static String tc1957origin = "31.205792,121.398402";
    public static String[] tc1957input = {"故宫", "黄果树瀑布"};//"故宫","华山"
    // , "天安门", "武夷山"
    public static String[] tc1957expect = {"故宫博物院", "黄果树瀑布"};//"故宫博物院","华山风景名胜区",
    public static String[] tc1957expCity = {"博物馆", "镇宁布依族苗族自治县"};//"北京市东城区","陕西省渭南市华阴市","贵州省安顺市镇宁布依族苗族自治县"

    //Denali-1958:POI category nearby
    public static String tc1958origin = "31.205792,121.398402";
    public static String tc1958cat = Parking;
    public static String[] tc1958expect = {"广兰路停车场", "上海欢乐谷停车场"};
    public static String[] tc1958expCity = {"公共停车场", "公共停车场"};

    //Denali-1967:City name
    public static String tc1967origin = "31.205792,121.398402";
    public static String tc1967input[] = {"杭州", "苏州"};
    public static String tc1967expect[] = {"浙江省杭州市", "江苏省苏州市"};
    public static String[] tc1967expCity = {"浙江省杭州市", "江苏省苏州市"};

    //  Denali-1976:Local Road name
    public static String tc1976origin = "31.205792,121.398402";
    public static String tc1976input = "大渡河路";
    public static String tc1976expect = "大渡河路(地铁站)";

    // Denali-1980:Street odd door number
    public static String tc1980origin = "31.205792,121.398402";
    public static String tc1980input = "龙东大道3999";
    public static String tc1980expect = "龙东大道3999号";

    // Denali-1983:City Street name
    public static String tc1983origin = "31.205792,121.398402";
    public static String tc1983input = "长沙银杉路";
    public static String tc1983expect = "银杉路";
    public static String tc1983expectCity = "望城区"; //"湖南省长沙市"

    //  Denali-1992:Street street
    public static String tc1992origin = "31.205792,121.398402";
    public static String tc1992input = "虹梅路吴中路";
    public static String tc1992expect = "吴中路虹梅路口";

    // Denali-1993:Intersection search with SZM
    public static String tc1993origin = "31.205792,121.398402";
    public static String tc1993input = "hml@wzl";
    public static String tc1993expect = "虹梅路吴中路(公交站)";

    // Denali-2019:Along route
    public static String tc2019origin = "31.207739,121.377222,90";
    public static String tc2019dest = "仙霞路娄山关路";
    public static String tc2019input = Food;
    public static String tc2019expect = "俊记餐厅";


    // Denali-2019:Along route
    public static String tc2020origin = "31.207739,121.377222,90";
    public static String tc2020dest = "上海虹桥国际机场";
    public static String tc2020input = Food;
    public static String tc2020expect = "上海动物园餐厅";

    //Denali-2072:Large roundabout with road name at the exit
    public static String tc2072origin = "38.924680, 121.653888,270";
    public static String tc2072dest = "38.920637, 121.640753";
    //Denali-2083:Highway transition - change highway - keep right[ANDY] waiting for test data from CN team
    public static String tc2083origin = "31.015653,120.676018";// S20
    public static String tc2083dest = "31.043918,120.711555";//延安高架
    //Denali-2086:Highway to road exit - with exit name
    public static String tc2086origin = "31.142501, 121.374944";
    public static String tc2086dest = "31.158113, 121.371121";
    //Denali-2101:Intersection
    public static String tc2101origin = "31.255077,121.310447";
    public static String tc2101dest = "31.256890,121.316334";

    //Denali-2234:Generic highway exit info
    public static String tc2234origin = "30.389301,120.318250";
    public static String tc2234dest = "中国上海松江区人民北路405-3号";// "31.01737, 121.225929"
    public static String tc2234expect = "上海农商银行";
    // Denali-2234:Generic highway exit info
    //public static String tc2234origin = "31.140728, 121.375946";
    //public static String tc2234dest = "31.187618, 121.357718";
    //Test case name:  Denali-1142:Route plan - Back
    public static String tc1142origin = "30.389301,120.318250";

    //Denali-1936:POI in current city
    public static String tc1936origin = "30.274061, 120.155078";
    public static String tc1936input = "杭州招商银行";
    public static String tc1936expect = "招商银行(杭州文晖支行) & 招商银行24小时自助银行(杭州中山支行)";

    // Denali-973:Repeated search and map action while long route
    public static String tc973origin = "31.205889, 121.398181";
    public static String tc973dest = "广东省深圳市";//"22.538178, 114.058911";
    //Denali-2049:Start guidance on route
    public static String tc2049origin = OfficeLatLon;
    public static String tc2049dest = "31.205770, 121.406904";
    //Denali-2050:Next maneuver is 8.5km away
    public static String tc2050origin = "31.201094, 121.403208,270";
    public static String tc2050dest = "31.091291, 121.029159";
    //Denali-2052:Destination in between 2km and 8.5km
    public static String tc2052origin = "31.201094, 121.403208,270";
    public static String tc2052dest = "31.167189, 121.334183";
    //Denali-2053:Waypoint in between 2km and 8.5km
    public static String tc2053origin = "31.201094, 121.403208,270";
    public static String tc2053dest = "31.167189, 121.334183";
    //Denali-2054:Motorway branch in between 3km and 8.5km
    public static String tc2054origin = "31.285183,121.189147";
    public static String tc2054dest = "31.269487,121.239839";
    //Denali-2057:Z2F in between 2km and 8.5km
    public static String tc2057origin = "31.285183,121.189147";
    public static String tc2057dest = "31.269487,121.239839";
    public static String DEFAULT_ADDRESS = "上海火车站(地铁站)";
    public static String WAY_POINT_ADDRESS = "上海虹桥国际机场1号航站楼";
}
