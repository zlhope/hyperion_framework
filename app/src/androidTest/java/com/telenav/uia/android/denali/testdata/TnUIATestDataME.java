package com.telenav.uia.android.denali.testdata;

public class TnUIATestDataME extends TnUIATestData {

    ////Test Cases Data///////////////////////


//SampleTest MAP
    //Denali-211:Generic 2.5D landmarks
    public static String tc211origin = "24.796424, 46.664682";
    //Denali-21:City name:
    public static String tc21origin = "24.796424, 46.664682";
    //Denali-2:Highway shields display condition
    public static String tc2origin = "24.796424, 46.664682";
    //Denali-19 : State name display
    public static String tc19origin = "24.796424, 46.664682";
    //Denali-22 : Street Name : Paris
    public static String tc22origin = "24.796424, 46.664682";
    //Denali-66:Scroll map around 3D Landmark
    public static String tc66origin = "24.787640, 46.837980";
    //Denali-105:Zoom in/out map_navigation
    public static String tc105searchTxt = "Airport";
    //Denali-1161:Show POI icons on map
    public static String  tc1161origin = "24.796424, 46.664682";
    //Denali-1235:Change default zoom level NavigationMap
    public static String tc1235origin = "24.796424, 46.664682";
    public static String tc1235dest = "24.803245, 46.614069";
    //public static String tc1235origin = "24.795294, 46.660101";
    //public static String tc1235dest = "24.793327, 46.668716";
    // Denali-997:Vehicle icon menu - Home/Work are set up
    public static String tc997origin = "24.803245, 46.614069";
    public static String tc997home = "10 Prince Faisal Bin Saad Street, Al Ulayah Al Janoubiyah, Riyadh 12244";
    public static String tc997work = "320 Al Orubah Road, Al Ulayah Al Gharbiyah, Riyadh 12333";



//SampleTest NAVSETTING
    //Denali-614:Avoid Freeway/Motorway = ON
    public static String tc614origin = "24.736247, 46.661578";
    public static String tc614dest = "24.791970, 46.633153";
    public static String tc614expected = "65";
    //Denali-1483:Alert of Railroad Crossing = ON - Approach
    public static String tc1483origin = "26.193220, 50.007002";
    public static String tc1483dest = "26.202536, 50.006339";



//SampleTest OFFBOARD
    //Denali-43:Traffic flow
    public static String tc43origin="24.768466, 46.681923";



//SampleTest ROUTE
    //Denali-375:Cancel route
    public static String tc375origin = "24.768466, 46.681923";
    public static String tc375dest = Fuel;
    //Denali-297:Across country
    //public static String tc297origin =	"31.512829, 37.114799";
    //public static String tc297dest = "31.951632, 35.908878";
    public static String tc297origin =	"24.768466, 46.681923";
    public static String tc297dest = "23.246642, 56.510652";
    //Denali-300:In one city
    public static String tc300origin =	"24.768466, 46.681923";
    public static String tc300dest = "Riyadh";
    //Denali-304:Roundabouts - Pass
    public static String tc304origin ="24.815547, 46.645449";
    public static String tc304dest ="24.822540, 46.641949";
    //public static String[][] tc304NextStInfo={{"",""},{"",""}};
    //Denali-318:Closed Rd - To
    public static String tc318origin = "24.671700, 46.727901";
    public static String tc318dest = "24.666909, 46.736571";
    //Denali-296:Route overview
    public static String tc296origin =	"24.768466, 46.681923";
    public static String tc296dest = "24.762094, 46.701660";
    //Denali-286:Fastest route
    public static String tc286origin ="24.768466, 46.681923";
    public static String tc286input = "King Khaled International Airport";
    public static String tc286expect = "King Khaled International Airport";




//SampleTest SEARCH
    //Denali-841:Enter space
    public static String tc841origin = "24.796424, 46.664682";
    //Denali-721:Alias name-Airport code
    public static String tc721origin ="24.796424, 46.664682";
    public static String tc721input = "RUH";
    public static String tc721expect ="King Khaled International Airport"; // use exact
    //Denali-1072:Search along route - Category search
    public static String  tc1072origin = "24.796424, 46.664682";
    public static String  tc1072dest = "RUH";
    public static String tc1072input = Fuel;
    //public static String tc1072expect = "ساسكو";
    public static String tc1072expect = "SASCO";
    //Denali-751:City
    public static String tc751origin = "21.227780, 40.370775";
    public static String tc751input = "Riyadh";
    public static String tc751expect= "Riyadh";
    //Denali-748:State+Postcode
    public static String tc748origin = "24.796424, 46.664682";
    public static String tc748input = "Riyadh 12241";
    public static String tc748expect= "Riyadh";
    //Denali-824:Str1+at+Str2+State+Postcode
    public static String tc824origin = "24.796424, 46.664682";
    public static String tc824input = "Tabuk Street at Al Kamar Street 12485";
    public static String tc824expect = "Tabuk Street at Al Kamar Street";
    //Denali-607:POI category
    public static String tc607input = "KFC";
    //Denali-852:Search category
    public static String tc852origin = "24.796424, 46.664682";
    public static String tc852input = Fuel;
    public static String tc852expect = "SASCO";
//  public static int tc852resultNumber = 4;
    //Denali-704:POI Name+in+city+state
    public static String tc704origin = "24.796424, 46.664682";
    public static String tc704input = "KFC in Buraydah";
    public static String tc704expect = "KFC";
    //Denali-717:Chain POI name+In+postcode
    public static String tc717origin = "24.796424, 46.664682";
    public static String tc717input = "KFC in 12241";
    public static String tc717expect = "KFC"; //add logic < 6 miles
    public static int tc717resultNumber = 10;
    //Denali-734:Sub category+NEAR+city+country
    public static String tc734origin ="24.796424, 46.664682";
    public static String tc734input = "Italian food Riyadh";
    public static String tc734expect = "Al Taj & Roma Restaurant & Pizza Restaurant & Amori";
    public static int tc734resultNumber = 4;
    //Denali-854:Search result detailed info
    public static String tc854origin = "24.796424, 46.664682";
    public static String tc854input = Fuel;
    //Denali-809:Lat/lon search - Common
    public static String tc809input = "24.726649, 46.687436";
    public static String tc809expect = "68 Shiekh Abdullah Al Anqari Street";
    //Denali-777:Street+IN+City
    public static String tc777origin = "24.796424, 46.664682";
    public static String tc777input = "Ar rabi street in Riyadh";
    public static String tc777expect = "Ar rabi street";
    //Denali-787:Door Number+Street
    public static String tc787origin = "24.796424, 46.664682";
    public static String tc787input = "3165 Qabis Street";
    public static String tc787expect = "3165 Qabis Street";
    //Denali-719:Landmarks
    public static String tc719origin = "24.796424, 46.664682";
    public static String tc719input = "Kingdom Centre Tower";
    public static String tc719expect = "Kingdom Centre Tower";
    //Denali-1191:Add from one box search
    public static String tc1191origin = "24.796424, 46.664682";
    public static String  tc1191dest = "320 Al Orubah Road, Al Ulayah Al Gharbiyah, Riyadh 12333";
    public static String  tc1191recent = "320 Al Orubah Road";
    //public static String  tc1191wp = "ستاربكس";//Starbucks
    public static String  tc1191wp = "Starbucks";//Starbucks
    //Denali-1108:Set POI category to favorite
    public static String  tc1108origin = "24.796424, 46.664682";
    public static String tc1108expect = "Java Cafe";





    //SampleTest AUDIO
    //Denali-473:Start Route Guidance - between info range and 1st guidance
    public static String tc473origin = "24.758815, 46.833566";
    public static String tc473dest = "24.714699, 46.759502";
    public static String tc473expect[] = {"guidance will start now","proceed (.*)"};
    //Denali-552:Dest arrival-on the left
    public static String tc552origin = "24.713940, 46.678559,180";
    public static String tc552dest = "10 Prince Faisal Bin Saad Street, Al Ulayah Al Janoubiyah, Riyadh 12244, Saudi Arabia";
    public static String tc552expect[] = {"Guidance will start now","In (.*) your destination is on your left","in (.*) your destination is on your left","[Y|y]ou have reached your destination on your left" };
    //Denali-1487:Turn right after landmark
    public static String tc1487origin = "24.786598, 46.834604";
    public static String tc1487dest = "24.789416, 46.835656";
    public static String tc1487expect[] = {"guidance will start now","in (.*) turn right.","in (.*) turn right after the (.*) to (.*)","turn right to (.*)" };


    //SampleTest GUIDANCE
    //Denali-695:Demo route
    public static String tc695origin ="24.843049, 46.808995";
    public static String tc695dest = "24.843291, 46.825319";
    //Denali-418:ETE to Destination
    public static int tc418ete = 16;
    public static String  tc418origin = "24.799494, 46.657541";
    public static String  tc418dest = "King Khaled International Airport";
    public static String  tc418expect = "King Khaled International Airport";
    //Denali-1054:Seach exit POI
    public static String tc1054origin = "24.798491, 46.719463";
    public static String tc1054dest = "24.958202, 46.700918";
    public static String tc1054expectExit = "Exit 2B";
    public static String[] tc1054ExpectedExitPOIType = {"Gas","Coffee"};

    //Denali-136:Junction view display
    public static String tc136origin = "24.625216, 46.779750";
    public static String tc136dest = "24.638694, 46.799598";
    //Denali-942:Correct number of lanes
    public static String tc942origin = "25.280798, 51.513802";
    public static String tc942dest = "25.282984, 51.515506";
    public static int tc942ln = 2;
    //Denali-362:Start Route
    public static String tc362origin ="24.625216, 46.779750";
    public static String tc362dest = Fuel;
    //Denali-635:Show timing-get route successfully
    public static String tc635origin = "24.625216, 46.779750";
    public static String tc635dest = "RUH";
    //Denali-370:Dest arrival-on route
    public static String tc370origin = "24.625216, 46.779750";
    public static String tc370dest = "24.638694, 46.799598";
    //Denali-388:Waypoint arrival-on route
    public static String tc388origin ="24.720484, 46.684364";
    public static String tc388dest = "KFC";
    public static String tc388category = Coffee;
    //public static String tc388wp = "ستاربكس";//Starbucks
    public static String tc388wp = "Starbucks";//Starbucks
    //Denali-1060:Waypoint edit view
    public static String  tc1060origin = "24.720484, 46.684364";
    public static String tc1060dest = "KFC";
    //public static String tc1060wp = "ستاربكس";//Starbucks
    public static String tc1060wp = "Starbucks";//Starbucks
    //Denali-404:Sub panel - tight turn
    public static String tc404origin =    "24.720484, 46.684364";
    public static String tc404dest = "24.796388, 46.710046";
    public static String tc404expTurnType1 = "TurnRight";
    public static String tc404expStreet1 = "Al Shamasia Street";
    public static String tc404expTurnType2 = "";
    public static String tc404expStreet2 = "";
    //Denali-1018:Waypoint Skip To Next Sign
    public static String tc1018origin = "24.721447, 46.682680,0";
    public static String tc1018dest = "24.796388, 46.710046";
    //public static String tc1018wp = "ستاربكس";//Starbucks
    public static String tc1018wp = "Starbucks";//Starbucks
    public static String tc1018category = Coffee;
    //Denali-921:Auto zoom timing - local road
    // Denali-921:Auto zoom timing - local road
    public static String tc921origin = "24.738953, 46.668042,245";
    public static String tc921dest = "24.741362, 46.661222";
    public static int tc921metric = 800;


























}
