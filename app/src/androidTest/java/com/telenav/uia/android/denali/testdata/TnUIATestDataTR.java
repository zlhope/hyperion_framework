package com.telenav.uia.android.denali.testdata;

public class TnUIATestDataTR extends TnUIATestData {

    ////Test Cases Data///////////////////////

//SampleTest AUDIO
    //Denali-473:Start Route Guidance - between info range and 1st guidance
    public static String tc473origin = "38.129161, 27.386177";
    public static String tc473dest = "38.113310, 27.410416";
    public static String tc473expect[] = {"guidance will start now","proceed (.*)"};
    //Denali-552:Dest arrival-on the left
    public static String tc552origin = "39.967391, 32.759457";
    public static String tc552dest = "39.964140, 32.758980";
    public static String tc552expect[] = {"Guidance will start now","In (.*) your destination is on your left","in (.*) your destination is on your left","[Y|y]ou have reached your destination on your left" };
    //Denali-1487:Turn right after landmark
    public static String tc1487origin = "40.204069, 29.177718";
    public static String tc1487dest = "40.203496, 29.180160";
    public static String tc1487expect[] = {"guidance will start now","in (.*) turn right.","in (.*) turn right after the (.*) to (.*)","turn right to (.*)" };



//SampleTest GUIDANCE
    //Denali-695:Demo route
    public static String tc695origin ="39.964904, 32.787794";
    public static String tc695dest = "KFC";
    //Denali-418:ETE to Destination
    public static int tc418minete = 35;
    public static int tc418maxete = 42;
    public static String  tc418origin = "39.964904, 32.787794";
    public static String  tc418dest = "ESB";
    public static String  tc418expect = "Esenboga Airport";
    //Denali-1054:Seach exit POI
    public static String tc1054origin = "40.718085, 30.422309";
    public static String tc1054dest = "40.718746, 30.440145";
    public static String tc1054expectExit = "Rest Area";
    public static String[] tc1054ExpectedExitPOIType = {"Restaurant"};
    //Denali-136:Junction view display
    public static String tc136origin = "40.004014, 32.634572";
    public static String tc136dest = "40.019320, 32.637721";
    //Denali-942:Correct number of lanes
    public static String tc942origin = "39.905773, 32.857893";
    public static String tc942dest = "39.902146, 32.859124";
    public static int tc942ln = 4;
    //Denali-362:Start Route
    public static String tc362origin ="39.964904, 32.787794";
    public static String tc362dest = Fuel;
    //Denali-635:Show timing-get route successfully
    public static String tc635origin = "39.964904, 32.787794";
    public static String tc635dest = "ESB";
    //Denali-370:Dest arrival-on route
    public static String tc370origin = "39.890964, 32.795205";
    public static String tc370dest = "39.896879, 32.791126";
    //Denali-388:Waypoint arrival-on route
    public static String tc388origin ="39.964904, 32.787794";
    public static String tc388dest = "39.905395, 32.810489";
    public static String tc388category = Coffee;
    public static String tc388wp = "Starbucks";
    //Denali-1060:Waypoint edit view
    public static String  tc1060origin = "39.964904, 32.787794";
    public static String tc1060dest = "KFC";
    public static String tc1060wp = "Starbucks";
    //Denali-404:Sub panel - tight turn
    public static String tc404origin = "36.904322, 30.707650";
    public static String tc404dest = "36.905876, 30.706206";
    public static String tc404expTurnType1 = "TurnRight";
    public static String tc404expStreet1 = "Emrah Cadessi";
    public static String tc404expTurnType2 = "TurnRight";
    public static String tc404expStreet2 = "788 Sokak";
    //Denali-1018:Waypoint Skip To Next Sign
    public static String tc1018origin = "39.968597, 32.804238";
    public static String tc1018dest = "39.946364, 32.857918";
    public static String tc1018wp = "Tchibo";
    public static String tc1018category = Coffee;
    public static String tc1018DriveTo = "Drive to 6 Uzunyol Sokak";
    //Denali-921:Auto zoom timing - local road
    public static String tc921origin = "39.880321, 32.860700";
    public static String tc921dest = "39.886547, 32.855104";
    public static int tc921metric = 800;




//SampleTest MAP
    //Denali-211:Generic 2.5D landmarks
    public static String tc211origin = "39.910092, 32.860876";
    //Denali-21:City name: Dortdmund
    public static String tc21origin = "39.910092, 32.860876";
    //Denali-2:Highway shields display condition
    public static String tc2origin = "39.910092, 32.860876";
    //Denali-19 : State name display
    public static String tc19origin = "39.910092, 32.860876";
    //Denali-22 : Street Name : Paris
    public static String tc22origin = "39.910092, 32.860876";
    //Denali-66:Scroll map around 3D Landmark
    public static String tc66origin = "";
    //Denali-105:Zoom in/out map_navigation
    public static String tc105searchTxt = "Esenboga Airport";
    //Denali-1161:Show POI icons on map
    public static String  tc1161origin = "39.910092, 32.860876";
    //Denali-1235:Change default zoom level NavigationMap
    public static String tc1235origin = "39.910092, 32.860876";
    public static String tc1235dest = "39.913392, 32.856456";
    // Denali-997:Vehicle icon menu - Home/Work are set up
    public static String tc997origin = "39.910092, 32.860876";
    public static String tc997home = "Kuzgun Sokak 14 Ankara";
    public static String tc997work = "Beykoz Sokak 5 Ankara";



//SampleTest NAVSETTING
    //Denali-614:Avoid Freeway/Motorway = ON
    public static String tc614origin = "39.870114, 32.941863";
    //public static String tc614input = "39.898797, 32.983481";
    public static String tc614dest = "39.898797, 32.983481";
    public static String tc614expected = "O-20";
    //Denali-1483:Alert of Railroad Crossing = ON - Approach
    public static String tc1483origin = "37.947212, 27.376824";
    public static String tc1483dest = "37.947284, 27.372114";



//SampleTest OFFBOARD
    //Denali-43:Traffic flow
    public static String tc43origin="39.964904, 32.787794";



//SampleTest ROUTE
    //Denali-375:Cancel route
    public static String tc375origin = "39.964904, 32.787794";
    public static String tc375dest = Fuel;
    // Denali-297:Across country
    public static String tc297origin =	"39.964904, 32.787794";
    public static String tc297dest = "41.977248, 21.578839";
    //Denali-300:In one city
    public static String tc300origin =	"39.964904, 32.787794";
    public static String tc300dest = "Ankara";
    //Denali-304:Roundabouts - Pass
    public static String tc304origin ="38.405349, 27.120288";
    public static String tc304dest ="38.407588, 27.124923";
    public static String[][] tc304NextStInfo={{"Kazim Karabekir Meydani","EnterAhead"},{"Inonu Sokak","ExitRight"}};
    //Denali-318:Closed Rd - To
    public static String tc318origin = "39.970332, 32.902531";
    public static String tc318dest = "39.972607, 32.900840";
    //Denali-296:Route overview
    public static String tc296origin =	"39.964904, 32.787794";
    public static String tc296dest = "39.986256, 32.758402";
    //Denali-286:Fastest route
    public static String tc286origin ="39.997735, 32.886366";
    public static String tc286input = "Esenboga Airport";
    public static String tc286expect = "Esenboga Airport";




//SampleTest SEARCH
    //Denali-841:Enter space
    public static String tc841origin = "39.964904, 32.787794";
    //Denali-721:Alias name-Airport code
    public static String tc721origin ="39.964904, 32.787794";
    public static String tc721input = "ESB";
    public static String tc721expect ="Esenboga Airport"; // use exact
    //Denali-1072:Search along route - Category search
    public static String  tc1072origin = "39.964904, 32.787794";
    public static String  tc1072dest = "ESB";
    public static String tc1072input = Fuel;
    public static String tc1072expect = "Shell";
    //Denali-751:City
    public static String tc751origin = "39.964904, 32.787794";
    public static String tc751input = "Antalya";
    public static String tc751expect= "Antalya, ANTALYA";
    //Denali-748:State+Postcode
    public static String tc748origin = "39.964904, 32.787794";
    public static String tc748input = "Izmir 35000";
    public static String tc748expect= "Izmir, IZMIR";
    //Denali-824:Str1+at+Str2+State+Postcode
    public static String tc824origin = "39.964904, 32.787794";
    public static String tc824input = "Yalim at Beykoz, Antalya 7000";
    public static String tc824expect = "Yalim Sokak at Beykoz Street";
    //Denali-607:POI category
    public static String tc607input = "KFC";
    //Denali-852:Search category
    public static String tc852origin = "39.964904, 32.787794";
    public static String tc852input = Fuel;
    public static String tc852expect = "BP & OPET & LUKOIL & PETROL OFISI";
    public static int tc852resultNumber = 4;
    //Denali-704:POI Name+in+city+state
    public static String tc704origin = "39.964904, 32.787794";
    public static String tc704input = "KFC in Ankara Turkey";
    public static String tc704expect = "KFC";
    //Denali-717:Chain POI name+In+postcode
    public static String tc717origin = "39.964904, 32.787794";
    public static String tc717input = "KFC in 6000";
    public static String tc717expect = "KFC"; //add logic < 6 miles
    public static int tc717resultNumber = 10;
    //Denali-734:Sub category+NEAR+city+country
    public static String tc734origin ="39.964904, 32.787794";
    public static String tc734input = "Chinese food Ankara Turkey";
    public static String tc734expect = "Noodle Box & Wangcho Çin Lokantası & Wok & Walk & Guangzhou Wuyang Chınese Rest";
    public static int tc734resultNumber = 4;
    //Denali-854:Search result detailed info
    public static String tc854origin = "39.964904, 32.787794";
    public static String tc854input = Fuel;
    //Denali-809:Lat/lon search - Common
    public static String tc809input = "39.910092, 32.860876";
    public static String tc809expect = "6 Yalim Sokak";
    //Denali-777:Street+IN+City
    public static String tc777origin = "39.910092, 32.860876";
    public static String tc777input = "Sembol Sokak in Ankara";
    public static String tc777expect = "Sembol Sokak";
    //Denali-787:Door Number+Street
    public static String tc787origin = "39.910092, 32.860876";
    public static String tc787input = "4 Kemah Sokak";
    public static String tc787expect = "4 Kemah Sokak";
    //Denali-719:Landmarks
    public static String tc719origin = "39.910092, 32.860876";
    public static String tc719input = "Ankara Castle";
    public static String tc719expect = "Ankara Castle";
    //Denali-1191:Add from one box search
    public static String tc1191origin = "39.910092, 32.860876";
    public static String  tc1191dest = "Ankara Yalim Sokak 6";
    public static String  tc1191recent = "6 Yalim Sokak";
    public static String  tc1191wp = "Tchibo";
    //Denali-1108:Set POI category to favorite
    public static String  tc1108origin = "39.910092, 32.860876";
    public static String tc1108expect = "Starbucks";
}
