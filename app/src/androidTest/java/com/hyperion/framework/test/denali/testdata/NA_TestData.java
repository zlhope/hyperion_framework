package com.hyperion.framework.test.denali.testdata;

public class NA_TestData extends TestData {
    /*****************
     * COMMON
     ***********************/
    public static String OfficeLatLon = "37.37890,-122.01074";
    public static String originFromLocation = "37.789060, -122.402077";
    public static String originAtGM = "42.329645, -83.039008";
    public static String sfoLatLon = "37.616924, -122.384481";
    public static int DistanceToDestination = 300; // ft as unit
    public static float distanceInAArea = 6;

    public static String separator = ",";


    /********************
     * Audio
     ***********************/
    public static String waypointApproach = "your waypoint is";

    //// Test Cases Data///////////////////////

    //Denali-1:Landmark
    public static String tc1input = "Golden Gate Bridge";
    public static String[] tc1expect = {"Golden Gate Bridge"};
    public static String tc1origin = "37.37890,-122.01074";

    // Denali-2:Highway shields display condition
    public static String tc2origin = "37.323972, -121.892367";
    // Denali-11 : walkway
    public static String tc11origin = "37.391808, -121.981580";
    // Denali-16:One way street direction
    public static String tc16origin = "37.789060, -122.402077";
    public static String tc16dest = "37.789925, -122.397816";
    // Denali-19 : State name display
    public static String tc19origin = "37.097612, -102.113829";
    // Denali-21:City name
    public static String tc21origin = "37.37890,-122.01074";
    // Denali-22 : Street Name
    public static String tc22origin = "37.789060, -122.402077";
    // Denali-23:State & country boundary
    public static String tc23origin = "32.718764, -114.719634";
    // Denali-28:Seas, lakes & rivers
    public static String tc28origin = "44.955618, -82.504296";
    // Denali-30:Facility name
    public static String tc30originAirport = "37.621614, -122.378580";
    public static String tc30originPark = "37.552909, -121.964007";
    public static String tc30originGolf = "37.423643, -122.041572";
    // Denali-43:Traffic flow
    public static String tc43origin = "37.789060, -122.402077";
    // Denali-47:Next Turn info
    public static String tc47origin = "37.365370, -122.049972";
    public static String tc47dest = "807 Piper Ave, Sunnyvale";
    public static String[][] tc47ExpectedTurn = {{"Hanover Ave", "TurnRight"}, {"Elmira Dr", "TurnLeft"}, {"Piper Ave", "TurnRight"}, {"807 Piper Ave", "LocationLeft"}};
    // Denali-48:Active route color
    public static String tc48origin = "37.382515, -121.995675";
    public static String tc48dest = "950 De guigne Dr";
    public static String tc48category = Food;
    public static String tc48wp = "McDonald's";

    // Denali-50:Traffic indicator update
    public static String tc50origin = "37.37890,-122.01074";
    public static String tc50dest = "950 De guigne Dr";

    //Denali-52:Exit Amenities list show timing - Highway
    public static String tc52origin = "37.410699, -121.991901";
    public static String tc52dest = "37.418709, -121.969046";

    // Denali-66:Scroll map around 3D Landmark
    public static String tc66origin = "37.789060, -122.402077,1";
    // Denali-86:Scroll map on junction view
    public static String tc86origin = "37.389497,-121.989645";

    //Denali-94:Drive time to home/work - change address
    public static String tc94origin = "37.37890,-122.01074";
    public static String tc94home = "685 Market St San Francisco, CA";
    public static String tc94work = "43519 Boscell Rd, Fremont, CA 94538";

    // Denali-102:Zoom in/out in ocean
    public static String tc102origin = "37.398064, -122.696472";
    // Denali-105:Zoom in/out map_navigation
    public static String tc105searchTxt = "airport";

    //Denali-107:Zoom in/out on current route overview screen
    public static String tc107origin = "37.398064, -122.696472";
    public static String tc107dest = "SFO";

    // Denali-136:Junction view display
    public static String tc136origin = "37.389497,-121.989645";
    public static String tc136dest = "37.388168,-121.996043";
    // Denali-138:Junction view color
    public static String tc138origin = "37.434628, -121.918859";
    public static String tc138dest = "37.449913, -121.915186";
    //Denali-140:Waypoint button
    public static String tc140origin = "37.37890,-122.01074";
    public static String tc140input = "KFC";
    // Denali-147:Exit POI info update
    public static String tc147origin = "37.418719, -121.969588";
    public static String tc147Dest = "37.421964, -121.931928";
    public static String tc147exit = "Exit North First Street";
    // Denali-150:GRC - highway
    public static String tc150origin = "37.425967, -121.916715";
    // Denali-154:RGC - Unnamed road
    public static String tc154origin = "37.384033, -122.014599";
    // Denali-211:Generic 2.5D landmarks
    public static String tc211origin = "37.789060, -122.402077";
    // Denali-217:Current street name display-unnamed road
    public static String tc217origin = "41.346277, -82.756512";
    public static String tc217dest = "41.342765, -82.762491";
    public static String tc217expect = "Ramp";

    //Denali-227:Drive time to home/work - change preferred route
    public static String tc227origin = "37.37890,-122.01074";
    public static String tc227home = "685 Market St San Francisco, CA";
    // Denali-230:Add by Map
    public static String tc230origin = "37.37890,-122.01074";
    // Denali-231:Day color
    public static String tc231origin = originFromLocation;
    // Denali-232:Night color
    public static String tc232origin = originFromLocation;

    // Denali-235:Set Home Address
    public static String tc235origin = "37.37890,-122.01074";
    public static String tc235input = "1951 Tradan Dr, San Jose, CA";
    public static String tc235expected = "Tradan Dr, San Jose, CA";
    // Denali-236:Set Home Address
    public static String tc236input = "950 De Guigne Dr, Sunnyvale, CA";
    public static String tc236expected = "950 Deguigne Dr";


    // Denali-260:JV show timing-Hwy -> Ramp -> Ramp -> Hwy
    public static String tc260origin = "37.548067, -122.291060";
    public static String tc260dest = "37.555979, -122.285875";
    // Denali-261:JV show timing-Hwy -> Ramp -> Ramp -> Local
    public static String tc261origin = "37.493561, -122.224269";
    public static String tc261dest = "37.487085,-122.216540";
    // Denali-262:JV show timing-Local -> Ramp -> Ramp -> Hwy
    public static String tc262origin = "37.415222,-122.078076";
    public static String tc262dest = "37.417201,-122.087073";
    // Denali-263:JV show timing-Local -> Ramp -> Ramp -> Local
    public static String tc263origin = "37.400990,-121.909490";
    public static String tc263dest = "37.400759,-121.909976";
    // Denali-264:JV show timing- Ramp -> Ramp -> Hwy
    public static String tc264origin = "37.316591, -121.943882";
    public static String tc264dest = "37.307171, -121.940725";
    // Denali-265:JV show timing- Hwy -> Hwy
    public static String tc265origin = "37.438896, -121.920033";
    public static String tc265dest = "37.423305, -121.924372";
    // Denali-266:JV show timing- Hwy -> Local
    public static String tc266origin = "35.293742, -85.151355";
    public static String tc266dest = "35.304101, -85.147675";
    //// Denali-267: Static ETE - Destination
    public static String tc267origin = "37.37890,-122.01074";
    public static String tc267dest = "SFO";
    public static String tc267exp = "Airport";
    public static int tc267Lower = 28;
    public static int tc267expUpper = 60;

    // Denali-286:Fastest route
    public static String tc286origin = "37.37890,-122.01074";
    public static String tc286input = "SFO";
    public static String tc286expect = "San Francisco Int'l Airport";

    // Denali-293:Route type inherit - Route option
    public static String tc293origin = "37.37890,-122.01074";
    public static String tc293dest = "SFO";
    public static String tc293exp = "Airport";

    // Denali-294:Route type inherit - Add waypoint
    public static String tc294origin = "37.37890,-122.01074";
    public static String tc294dest = "SFO";
    public static String tc294exp = "San Francisco Int'l Airport";
    public static String tc294Wp = Fuel;

    // Denali-295:Route type inherit - Remove waypoint
    public static String tc295origin = "37.388269, -122.009873, 270";
    public static String tc295dest = "37.384162, -122.026280";
    public static String tc295exp = "Shell";

    // Denali-296:Route overview
    public static String tc296origin = "37.37890,-122.01074";
    public static String tc296dest = "37.617073, -122.384829";
    // Denali-297:Across country
    public static String tc297origin = "37.37890,-122.01074";
    public static String tc297dest = "32.550854, -116.938873";
    // Denali-298:Across state
    public static String tc298origin = "43.003750,-87.883737";
    public static String tc298SearchText = "San Francisco, CA";
    // Denali-299:Across state
    public static String tc299origin = "37.37890,-122.01074";
    public static String tc299SearchText = "San Jose, CA";
    // Denali-300:In one city
    public static String tc300origin = "37.37890,-122.01074";
    public static String tc300dest = "Sunnyvale, CA";
    // Denali-301:One way street - Pass
    public static String tc301origin = "37.789692, -122.402165";
    public static String tc301SearchText = "105 Montgomery St";
    public static String tc301ExpectedSearchResult = "105 Montgomery St";
    public static String[] tc301ExpectedRoute = {"Market St", "Geary St", "Kearny St", "Bush St", "Montgomery St",
            "105 Montgomery St"};
    // Denali-302:Roundabouts - From
    public static String tc302Origin = "37.718114, -122.478028";// Juan Bistista
    // Circle

    public static String tc302Destination = "37.715510, -122.480045";
    public static String tc302Destination2 = "37.720527, -122.480763";
    public static String[] tc302SearchText = {"101 Crespi Dr", "426 Font Blvd"};
    public static String[] tc302ExpectedSearchResult = {"101 Crespi Dr", "426 Font Blvd"};
    // Denali-303:Roundabouts - To
    public static String tc303Origin = "37.716569, -122.475378";
    public static String tc303SearchText = "37.718114, -122.478028";// Juan
    // Bistista
    // Circle
    public static String tc303Destination = "Juan Bautista Cir";
    // Denali-304:Roundabouts - Pass
    public static String tc304origin = "37.716172, -122.474691,315";
    public static String tc304dest = "37.719494, -122.479524";
    public static String[][] tc304NextStInfo = {{"Juan Bautista Cir", "EnterAhead"}, {"Font Blvd", "ExitRight"}};
    // Denali-305:Tunel - From
    public static String tc305Origin = "37.857118, -122.213445";
    public static String tc305SearchText = "21 Old Tunnel Rd, Orinda, CA 94563";
    public static String tc305ExpectedSearchResult = "21 Old Tunnel Rd";
    // Denali-306:Tunel - To
    public static String tc306Origin = "37.851053, -122.222790";
    public static String tc306SearchText = "Caldecott Tunl";
    public static String tc306ExpectedSearchResult = "Caldecott Tunl";
    public static String tc306Destination = "Caldecott Tunl";
    // Denali-308:Ferry - From
    public static String tc308Origin = "38.78158, -75.11987";
    public static String tc308SearchText = "15 Texas Ave, Lewes,DE";
    public static String tc308ExpectedSearchResult = "15 Texas Ave";
    // Denali-309:Ferry - To
    public static String tc309Origin = "38.781390, -75.127707";
    public static String tc309SearchText = "Cape May-Lewes Fry";
    public static String tc309ExpectedText = "Cape May-Lewes Fry";
    public static String tc309Destination = "Cape May-Lewes Fry";
    // Denali-311:Airport - From
    public static String tc311Origin = "37.616982, -122.384060";
    public static String tc311SearchText = "754 7th Ave, San Bruno, CA";
    public static String tc311ExpectedSearchResult = "754 7th Ave";
    // Denali-312:Airport - To
    public static String tc312Origin = "37.6015816,-122.3838958";
    public static String tc312SearchText = "SFO";
    public static String tc312ExpectedSearchResult = "San Francisco Int'l Airport";
    public static String tc312Destination = "San Francisco Int'l Airport";
    // Denali-316:Park - To
    // public static String tc316Origin = <OriginationFromOffice>;
    public static String tc316Origin = "37.37890,-122.01074";
    public static String tc316SearchText = "Fair Oaks Park";
    public static String tc316ExpectedSearchResult = "Fair Oaks Park";
    // public static String tc316Destination = "540 N Fair Oaks Ave";
    public static String tc316Destination = "Fair Oaks Park";
    // Denali-318:Closed Rd - To
    public static String tc318origin = "37.395944, -121.979211";
    public static String tc318dest = "37.392555, -121.982755";
    // Denali-325:Long route > 2000 mi
    public static String tc325Origin = "37.37890,-122.01074";
    public static String tc325SearchText = "NYC";
    public static String tc325ExpectedSearchResult = "New York, NY";
    public static int tc325Distance = 2000;
    // Denali-336:To vehicle position - On road
    public static String tc336Origin = "37.37890,-122.01074";
    public static String tc336dest = "37.37890,-122.01074";
    // Denali-341:Avoid fail - Preferences setting
    public static String tc341origin = "37.390049, -122.030354";
    public static String tc341SearchText = "37.397810, -122.022943";
    // Denali-345:Time Restricted Turn - On restricted time
    public static String tc345Origin = "42.378251,-83.014251";
    public static String tc345SearchText = "42.378056,-83.015165";
    // Denali-357:Legal routing - Left turn restricted
    public static String tc357Origin = "37.293231,-121.929598,0";
    public static String tc357SearchText = "1056 E Hamilton Ave";
    public static String tc357ExpectedSearchResult = "1056 E Hamilton Ave";
    // Denali-358:Add by Address
    public static String tc358origin = "37.37890,-122.01074";
    public static String tc358dest = "255 W Maude Ave, Sunnyvale, CA 94085";
    // Denali-359:Add by POI
    public static String tc359Origin = "37.37890,-122.01074";
    public static String tc359Destination = "Shell";
    public static String tc359Waypoint = "Chevron";
    // Denali-361:Add by recent places
    public static String tc361Origin = "37.37890,-122.01074";
    public static String tc361SearchText = "KFC";
    // Denali-362:Start Route
    public static String tc362origin = "37.37890,-122.01074";
    public static String tc362dest = Fuel;
    // Denali-367:Current street name in Guidance
    public static String tc367origin = OfficeLatLon;
    public static String tc367dest = "896 E Arques Ave, Sunnyvale CA";
    public static String[] tc367ExpectedSt = {"Santa Ana Ct", "E Arques Ave"};
    // Denali-368:Next maneuver card - next street name
    public static String tc368origin = "37.366274, -122.052440";
    public static String tc368dest = "807 Piper Ave, Sunnyvale";
    public static String[] tc368ExpectedNextSt = {"Hanover Ave", "Elmira Dr", "Piper Ave", "807 Piper Ave"};
    // Denali-370:Dest arrival-on route
    public static String tc370origin = "37.37890,-122.01074";
    public static String tc370dest = "890 E Arques Ave";
    // Denali-374:The flag display when dest arrival
    public static String tc374dest = "289 Santa Ana Ct";
    // Denali-375:Cancel route
    public static String tc375origin = "37.37890,-122.01074";
    public static String tc375dest = Fuel;

    //Denali-372:Add waypoint when arrive dest
    public static String tc372origin = "37.37890,-122.01074";
    public static String tc372dest = "289 Santa Ana Ct Sunnyvale CA";
    public static String tc372wpType = Fuel;

    //Denali-379:MAX waypoints
    public static String tc379origin = "37.37890,-122.01074";
    public static String tc379dest = "San Jose, CA";
    public static String tc379wp1Type = Food;
    public static String tc379wp2 = "San Jose, CA";
    public static String tc379wp2expect = "San Jose, CA";
    public static String tc379wp3 = "Chevron";
    public static String tc379wp5 = "NYC";
    public static String tc379wp5expect = "NYC | Nyc, NY";

    //Denali-380:Add waypoint before arrive waypoint/dest
    public static String tc380origin = "37.37890,-122.01074";
    public static String tc380dest = "KFC";
    public static String tc380wp = "Chevron";
    public static String tc380wp1 = "76";

    //Denali-381:Delete Waypoint
    public static String tc381origin = "37.37890,-122.01074";
    public static String tc381dest = "KFC";
    public static String tc381wp = "Chevron";
    public static String tc381wp1 = "76";

    //Denali-382:Delete all waypoints continuously
    public static String tc382origin = "37.37890,-122.01074";
    public static String tc382dest = "KFC";
    public static String tc382wp = "Shell";
    public static String tc382wp1Type = Food;
    public static String tc382wp1 = "McDonald's";
    public static String tc382wp2 = "76";

    //Denali-383:Reorder Waypoints
    public static String tc383origin = "37.37890,-122.01074";
    public static String tc383dest = "KFC";
    public static String tc383nwp = "Shell";
    public static String tc383wp1Type = Food;
    public static String tc383wp1 = "McDonald's";
    public static String tc383wp2 = "76";


    // Denali-384:Cancel route when arrive waypoint
    public static String tc384Origin = "37.383120, -122.018021";
    public static String tc384Destination = "KFC";
    public static String tc384Waypoint = "Chevron";
    // Denali-388:Waypoint arrival-on route
    public static String tc388origin = "37.373898, -122.056759";
    public static String tc388dest = "198 E El Camino Real, Sunnyvale, CA 94087";
    public static String tc388category = Food;
    public static String tc388wp = "SUBWAY";

    //Denali-390:Add waypoint after arrive waypoint
    public static String tc390origin = "37.383120, -122.018021";
    public static String tc390dest = "KFC";
    public static String tc390wp = "Chevron";
    public static String tc390wp1 = "76";

    // Denali-390:Add waypoint after arrive waypoint
    public static String tc390Origin = "37.383120, -122.018021";

    // Denali-396:Legal routing - Right turn restricted //backup data:
    // 37.771503, -122.423829 to 37.770916, -122.422782
    public static String tc396Origin = "37.319996, -121.992034";
    public static String tc396Dest = "42.383843, -83.296678";
    public static String tc396NextStreet = "Centralia";

    // Denali-399:Maneuver arrow
    public static String tc399origin = "37.365165, -122.048853";
    public static String tc399dest = "809 Piper Ave";
    public static String[][] tc399expect = {{"Hanover Ave", "TurnSlightRight"}, {"Elmira Dr", "TurnLeft"}, {"Piper Ave", "TurnRight"}, {"809 Piper Ave", "LocationLeft"}};

    // Denali-404:Sub panel - tight turn
    public static String tc404origin = "37.380957, -122.012438,270";
    public static String tc404dest = "37.382072, -122.016816";
    public static String tc404expTurnType1 = "TurnLeft";
    public static String tc404expStreet1 = "Montara Ter";
    public static String tc404expTurnType2 = "TurnRight";
    public static String tc404expStreet2 = "Montara Ter";

    // Denali-405:ETA-Wpt and Dest in same Timezone
    public static String tc405origin = "37.37890,-122.01074";
    public static String tc405dest = "950 De guigne Dr";
    public static String tc405category = Food;
    public static String tc405wp = "McDonald's";

    //Denali-406:WTA-Wpt and Dest in different Timezone
    public static String tc406origin = "36.108013, -115.154734";
    public static String tc406dest = "Salt Lake City";
    public static int tc406destzonediff = 1;
    public static String tc406wp = "Albuquerque";
    public static String tc406wpexpect = "Albuquerque, NM";
    public static int tc406wpzonediff = 1;

    // Denali-410:ETA to Destination
    public static String tc410origin = OfficeLatLon;
    public static String tc410dest = "286 Santa Ana Ct, Sunnyvale CA";

    // Denali-411:ETA with one Waypoint
    public static String tc411origin = "37.382515, -121.995675";
    public static String tc411dest = "SFO";
    public static String tc411category = Food;
    public static String tc411wp = "McDonald's";

    // Denali-412:ETA with Dest Change
    public static String tc412origin = "37.382515, -121.995675";
    public static String tc412dest = "SFO";
    public static String tc412category = Food;
    public static String tc412newDest = "McDonald's";

    // Denali-418:ETE to Destination
    public static int tc418minete = 28;
    public static int tc418maxete = 50;
    public static String tc418origin = "37.37890,-122.01074";
    public static String tc418dest = "SFO";
    public static String tc418expect = "San Francisco Int'l Airport";

    // Denali-419:ETE with one Waypoint
    public static String tc419origin = "37.382515, -121.995675";
    public static String tc419unit = "m";
    public static String tc419dest = "SFO";
    public static String tc419category = Food;
    public static String tc419wp = "McDonald's";

    // Denali-420:ETE with Dest Change
    public static String tc420origin = "37.382515, -121.995675";
    public static String tc420dest = "SFO";
    public static String tc420category = Food;
    public static String tc420wp = "McDonald's";
    public static String tc420unit = "m";
    // Denali-421:ETE with Waypoint Change
    public static String tc421origin = "37.382515, -121.995675";
    public static String tc421dest = "San Francisico";
    public static String tc421category1 = Food;
    public static String tc421wp1 = "McDonald's";
    public static String tc421category2 = Fuel;
    public static String tc421wp2 = "76";
    // Denali-456:Change route type - fastest
    public static String tc456origin = "37.37890,-122.01074";
    public static String tc456destination = "SFO";
    public static String tc456search = "Airport";
    // Denali-459:Sub panel - lane guidance
    public static String tc459origin = "37.788617, -122.406163";
    public static String tc459dest = "37.786296, -122.399101";
    // Denali-488:Slight Right Turn on Local Street
    public static String tc488origin = "37.293980, -122.040128,270";
    public static String tc488Dest = "37.29249, -122.04629";
    public static String tc488expect[] = {"guidance will start now", "^(I|i)n (.*) turn slight right(.)?", "(I|i)n (.*) turn slight right to (.*)", "turn slight right to (.*)"};
    //	Test case name: Denali-489:Keep right on Local Street
    public static String tc489origin = "37.389339, -122.014895";
    public static String tc489dest = "37.384551, -122.017509";
    public static String tc489expect[] = {"guidance will start now", "^in (.*) keep right", "^in (.*) keep right to (.*)", "^keep right to (.*)"};
    // Denali-491:Left turn on Local Street
    public static String tc491origin = "37.418714, -122.124722";//set vehicle direction to east
    public static String tc491Dest = "37.416866,-122.087016";
    public static String tc491expect[] = {"guidance will start now", "^in (.*) turn left.", "^in (.*) turn left to (.*)", "^turn left to (.*)"};
    //	Denali-493: Turn sharp left on Local Street
    public static String tc493origin = "37.684317, -122.463654,1";
    public static String tc493Dest = "37.687696, -122.468374";
    public static String tc493expected[] = {"guidance will start now", "^in (.*) turn sharp left after (.*) to (.*)", "^turn sharp left to (.*)"};
    //  Denali-496:Make a U-turn
    public static String tc496origin = "37.378484, -121.995819,0";
    public static String tc496dest = "37.384218, -121.996029";
    public static String tc496expect[] = {"guidance will start now", "^in (.*) make a u-turn if possible", "^in (.*) make a u-turn if possible at (.*)", "^make a u-turn if possible at (.*)"};//5/22 R11.1 RC5
    //	Denali-497:Enter large roundabout
    public static String tc497origin = "19.423230, -99.088939";
    public static String tc497dest = "19.418591, -99.087726";
    public static String tc497expect[] = {"guidance will start now", "^in (.*) enter the roundabout and take the eighth exit", "^in (.*) take the eighth exit to (.*)", "^Take the eighth exit"};
    //Denali-470:Delete favorite from favorite list
    public static String tc470origin = "37.37890,-122.01074";
    public static String tc470input = "1140 Kifer Rd";
    //	Denali-472 Start Route Guidance - on road/ between 15mi and info range
    public static String tc472origin = "37.403973, -122.051116";
    public static String tc472dest = "431 E Dunne Ave, Morgan Hill, CA 95037";
    public static String[] tc472expected = {"guidance will start now", "proceed on (.*)"};
    // Denali-473:Start Route Guidance - between info range and 1st guidance
    public static String tc473origin = "37.460334, -121.924591";
    public static String tc473dest = "37.508696, -121.963871";
    public static String tc473expect[] = {"guidance will start now", "proceed (.*)"};
    // Denali-477:Start Route Guidance - between 2nd and 3rd guidance
    public static String tc477origin = "37.380015, -122.010533";
    public static String tc477Dest = "37.380872, -122.008551";
    public static String tc477expect[] = {"guidance will start now", "turn right to (.*) and then your destination will be on your right"};
    //	Denali-500:Enter Ferry
    public static String tc500origin = "48.684840, -123.410535";
    public static String tc500dest = "48.806771, -123.308460";
    public static String tc500expect[] = {"guidance will start now", "^in (.*) prepare to enter the ferry terminal", "^you have reached the ferry terminal"};
    //  Denali-501:Exit ferry
    public static String tc501origin = "48.690611, -123.402992,225";
    public static String tc501dest = "48.688393, -123.410830";
    public static String tc501expect[] = {"guidance will start now", "continue on the current road and then your destination will be on your right"};
    // Denali-505:Highway Entrance - slight right
    public static String tc505origin = "49.306744,-123.038331";
    public static String tc505Dest = "49.297791,-123.026447";
    public static String tc505expect[] = {"guidance will start now", "^in (.*) turn slight right to (.*)", "^in (.*) turn slight right to (.*) towards (.*)", "^turn slight right to (.*)"};
    //	Denali-506:Highway Entrance - turn left
    public static String tc506origin = "37.349951, -121.873995";
    public static String tc506Dest = "37.362628, -121.886873";
    public static String tc506expected[] = {"guidance will start now", "^in (.*) turn left to (.*) towards (.*)", "^in (.*) turn left to (.*) towards (.*)", "^turn left to (.*)"};
    // Denali-515:Highway-to-road Exit - take exit on the right
    public static String tc515origin = "37.403973, -122.051116";
    public static String tc515Dest = "37.394500,-122.029047";
    public static String tc515expect[] = {"guidance will start now", "^in (.*) take exit on the right to (.*) towards (.*)", "^in (.*) exit on the right to (.*) towards (.*)", "^exit right to (.*)"};//5/22/2015 R11.1 RC5
    // Denali-540:Continuous Guidance - dest arrival
    public static String tc540rigin = "37.389169, -122.016828";
    public static String tc540dest = "37.388954, -122.002852";
    public static String tc540expect[] = {"guidance will start now", "^in (.*) turn left.", "^in (.*) turn left to (.*) and then you will arrive at your destination"};//6/25/2015 R11.3 RC2
    // Denali-522:Highway transition - take exit on the right
    public static String tc522origin = "37.250590, -121.894878";
    public static String tc522Dest = "37.275703,-121.863164";
    public static String tc522expect[] = {"guidance will start now", "^in (.*) take exit (.*) on the right to (.*) towards (.*)", "^in (.*) take exit (.*) on the right to (.*) towards (.*)", "^exit right to (.*)"};
    //	Denali-528:Highway to same highway-keep left
    public static String tc528origin = "19.602329, -99.188903";
    public static String tc528Dest = "19.586047, -99.204262";
    public static String tc528expect[] = {"guidance will start now", "^in (.*) keep left to (.*) towards (.*)", "^in (.*) keep left to (.*) towards (.*)", "^keep left to (.*)"};
    // Denali-552:Dest arrival-on the left
    public static String tc552origin = "37.380952, -122.011622";
    public static String tc552dest = "1145 E Arques Ave Sunnyvale, CA 94085";
    public static String tc552expect[] = {"Guidance will start now", "In (.*) your destination is on your left", "in (.*) your destination is on your left", "[Y|y]ou have reached your destination on your left"};
    //  Denali-555:Continuous Guidance - waypoint arrival
    public static String tc555origin = "37.375631, -122.061071";
    public static String tc555Dest = "37.352133, -122.003358";
    public static String tc555wp = "SUBWAY";
    public static String tc555category = Food;
    public static String tc555expect[] = {"^in (.*) your waypoint is on your right", "^in (.*) your waypoint is on your right", "you have reached your waypoint on your right"};
    // Denali-558:Search History list-one box search
    public static String tc558input = "950 Deguigne Dr Sunnyvale 94085";
    // Denali-561:Select from Search History List
    public static String tc561input = "coffee near by sunnyvale 94085";
    // Denali-583:RGC - CAN
    public static String tc583origin = "43.676396, -79.401367";
    // Denali-584:RGC - MEX
    public static String tc584origin = "25.688738, -100.317290";

    // Denali-586:Maneuver arrow _ U-turn
    public static String tc586origin = "37.382367, -121.995759";
    public static String tc586dest = "1177 Kern Ave, Sunnyvale";

    // Denali-587:Turn icon - Roundabout
    public static String tc587origin = "37.717027, -122.476122,315";
    public static String[] tc587dest = {"14 Diaz Ave", "117 Crespi Dr", "16 Fuente Ave", "422 Font Blvd",
            "30 Bucareli Dr", "4 Grijalva Dr", "24 Josepha Ave"};
    // Denali-588:Turn icon - U-turn
    public static String tc588origin = "37.383161, -121.995734";
    public static String tc588dest = "1177 Kern Ave, Sunnyvale";
    public static String tc588expect = "LeftUTurn";

    // Denali-589:Turn icon - Vehicle is off road
    public static String tc589origin = "37.386533,-122.004404";
    public static String tc589dest = "37.383925, -122.003905";
    public static String tc589expect = "TurnLeft";

    // Denali-590:Valid Postcode+unrelated country
    public static String tc590input = "12345 USA";
    // Denali-591:next maneuver card - distance update
    public static String tc591origin = "37.366168, -122.051775";
    public static String tc591dest = "831 Piper Ave";

    // Denali-592:Destination icon direction
    public static String tc592origin = "37.380950, -122.011539";
    public static String tc592destLeft = "1135 E Arques Ave";
    public static String tc592destRight = "1090 E Arques Ave";
    public static String tc592destAhead = "E Arques Ave at Lawrence Expy";
    public static String tc592expectAhead = "LocationAhead";
    public static String tc592expectLeft = "LocationLeft";
    public static String tc592expectRight = "LocationRight";

    // Denali-596:Street+City+State+Postcode
    public static String tc596input = "Deguigne Dr. Sunnyvale CA 94085";
    public static String tc596expected = "Deguigne Dr | De Guigne Dr";

    // Denali-600:Str1+@+Str2+City+State+Country
    public static String tc600input = "E Arques Ave @ Santa Ana Ct Sunnyvale CA USA";
    public static String tc600expected = "Santa Ana Ct at E Arques Ave | E Arques Ave at Santa Ana Ct";

    //Denali-606:Brand POI name
    public static String tc606input = "KFC";
    public static String[] tc606expect = {"KFC"};
    public static String tc606origin = "37.37890,-122.01074";

    // Denali-607:POI category
    public static String tc607input = "Restaurant";

    //Denali-608:POI name
    public static String tc608input = "ATM";
    public static String[] tc608expect = {"ATM"};
    public static String tc608origin = "37.37890,-122.01074";

    //Denali-609:Airport code
    public static String tc609input = "SFO";
    public static String[] tc609expect = {"SFO", "San Francisco Int'l Airport"};
    public static String tc609origin = "37.37890,-122.01074";

    // Denali-613:Avoid Freeway = OFF
    public static String tc613origin = "37.390522, -122.030263";
    public static String tc613input = "822 N Fair Oaks Ave";
    public static String tc613expected = "822 N Fair Oaks Ave";
    public static String tc613road = "US-101";

    //Denali-614:Avoid Freeway/Motorway = ON
    public static String tc614origin = "37.390049, -122.030354";
    public static String tc614dest = "37.396160, -121.995840";
    public static String tc614expected = "US-101";

    //:Denali-615:Avoid Toll Road = OFF
    public static String tc615origin = "37.538442, -122.016395";
    public static String tc615input = "37.473025, -122.185997";
    public static String tc615expected = "CA-84 W";

    //Denali-616:Avoid Toll Road = ON
    public static String tc616origin = "37.538442, -122.016395";
    public static String tc616input = "37.473025, -122.185997";
    public static String tc616expected = "CA-84 W";

    //Denali-618 :: Avoid Ferry = OFF
    public static String tc618origin = "38.779137, -75.134037";
    public static String tc618dest = "38.972201, -74.928340";
    public static String tc618ferry = "Cape May-Lewes Fry";

    //Denali-633:Traffic display = OFF
    public static String tc633origin = "37.789060, -122.402077";

    //Denali-634:Traffic display = ON
    public static String tc634origin = "37.789060, -122.402077";

    // Denali-635:Show timing-get route successfully
    public static String tc635origin = "37.37890,-122.01074";
    public static String tc635dest = "SFO";

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
    public static String tc653origin = "37.380909, -122.009474";
    public static String tc653dest = "KFC";
    public static String tc653wp = "Starbucks";
    public static String tc653category = Coffee;
    // Denali-677:Route display
    public static String tc677origin = "37.392024, -121.998297";
    public static String tc677dest = "SFO";

    //Denali-678:Traffic indicator - waypoint/dest
    public static String tc678origin = "37.37890,-122.01074";
    public static String tc678input = "KFC";

    //Denali-681:3D Heading up display
    public static String tc681origin = "37.37890,-122.01074";

    //Denali-682:2D Heading up display
    public static String tc682origin = "37.37890,-122.01074";

    //Denali-683:2D North up display
    public static String tc683origin = "37.37890,-122.01074";

    //Denali-684:Preferred Route = Fastest
    public static String tc684origin = "37.399293, -121.867746";
    public static String tc684dest = "37.420026, -122.152592";

    // Denali-695:Demo route
    public static String tc695origin = "37.37890,-122.01074";
    public static String tc695dest = "KFC";

    //Denali-697:Cancel demo
    public static String tc697input = "37.37890,-122.01074";
    public static String tc697expected = "SFO";

    // Denali-698:POI Name
    public static String tc698input = "KFC";
    public static String tc698expected = "KFC";

    // Denali-700:POI name+street without door number
    public static String tc700input = "Fry's Electronics E Arques Ave";
    public static String tc700expected = "Fry's Electronics";
    public static String tc700street = "1077 E Arques Ave";
    public static String tc700city = "Sunnyvale, CA 94085";
    // Denali-704:POI Name+in+city+state
    public static String tc704origin = "37.37890,-122.01074";
    public static String tc704input = "Fry's Electronics in Sunnyvale CA";
    public static String tc704expect = "Fry's Electronics";
    public static String tc704expectAddr = "1077 E Arques Ave";
    // Denali-705:POI Name+of+state+country
    public static String tc705input = "Shell of CA USA";
    public static String tc705expected = "Shell";
    // Denali-706:POI Name+near+city+postcode
    public static String tc706input = "Costco near Sunnyvale 94085";
    public static String tc706expected = "Costco"; // add logic < 6 miles
    // Denali-715:Chain POI name+near by+city
    public static String tc715input = "starbucks near by Sunnyvale";
    public static String tc715expected = "Starbucks"; // add logic < 6 miles
    // Denali-717:Chain POI name+In+postcode
    public static String tc717origin = "37.37890,-122.01074";
    public static String tc717input = "starbucks in 94085";
    public static String tc717expect = "Starbucks"; // add logic < 6 miles
    public static int tc717resultNumber = 100;
    // Denali-719:Landmarks
    public static String tc719origin = "37.37890,-122.01074";
    public static String tc719input = "Golden Gate Bridge";
    public static String tc719expect = "Golden Gate Bridge"; // add logic < 6
    // miles
    // Denali-720:Airport Name
    public static String tc720input = "San Francisco International Airport";
    public static String[] tc720expected = {"San Francisco Int'l Airport", "San Francisco International Airport",
            "San Francisco Int'l Airport (SFO)"}; // use exact
    // Denali-721:Alias name-Airport code
    public static String tc721origin = "37.37890,-122.01074";
    public static String tc721input = "SFO";
    public static String tc721expect = "San Francisco Int'l Airport | San Francisco International Airport | San Francisco Int'l Airport (SFO)"; // use
    // exact
    // Denali-728:Search super category
    public static String tc728input = "ATM";
    public static String tc728expect = "Chase & Wells Fargo & Bank of America";
    // Denali-731:Super Category+near+city
    public static String tc731input = "hotel near Milpitas";
    public static String[] tc731expected = {"Hilton Garden Inn", "Staybridge Suites", "Days Inn"};
    // Denali-733:Super Category+of+postcode
    public static String tc733input = "park of 94085";
    public static String[] tc733expected = {"Fair Oaks Park", "Columbia Park", "Lakewood Park"};
    // Denali-734:Sub category+NEAR+city+country
    public static String tc734origin = "37.359317, -122.026614";
    public static String tc734input = "Chinese Food near Sunnyvale USA";
    public static String tc734expect = "Dim Sum King & New Port Restaurant";
    public static int tc734resultNumber = 50;
    // Denali-735:Sub category+in+state+country
    public static String tc735input = "Burgers in CA USA";
    public static String[] tc735expected = {"McDonald's", "In-N-Out Burger"};
    // Denali-737:GM dealership
    public static String tc737input = "GM dealership";
    public static String tc737expected = "GM";// need revisit with returned
    // format
    // Denali-738:Search along route - one box search
    public static String tc738origin = "SFO";
    public static String tc738input = "KFC";
    public static String tc738expected = "KFC";
    // Denali-747:State+Postcode+Country
    public static String tc747input = "California 94538 USA";
    public static String tc747expected = "Fremont, CA";
    // Denali-748:State+Postcode
    public static String tc748origin = "37.37890,-122.01074";
    public static String tc748input = "CA 94538";
    public static String tc748expect = "Fremont, CA";
    // Denali-749:Postcode+Country
    public static String tc749input = "94538 USA";
    public static String tc749expected = "Fremont, CA";
    // Denali-750: Postcode
    public static String tc750input = "94102";
    public static String tc750expected = "San Francisco|San Francisco, CA|San Francisco, CALIFORNIA"; // Onboard/Offboard
    // Denali-751:City
    public static String tc751origin = "37.37890,-122.01074";
    public static String tc751input = "Sunnyvale";
    public static String tc751expect = "Sunnyvale, CA|Sunnyvale, California";
    // Denali-753:City+State
    public static String tc753input = "San Francisco CA";
    public static String tc753expected = "San Francisco, CA";
    // Denali-754:City+State+Country
    public static String tc754input = "San Francisco CA USA";
    public static String tc754expected = "San Francisco, CA|San Francisco"; // Onboard/Offboard
    // Denali-756:City+State+Postcode
    public static String tc756input = "San Francisco CA 94102";
    public static String tc756expected = "San Francisco, CA|San Francisco, CALIFORNIA"; // Onboard/Offboard
    // Denali-758:City+Postcode+Country
    public static String tc758input = "Fremont 94538 USA";
    public static String tc758expected = "Fremont, CA";
    // Denali-759:City+Postcode
    public static String tc759input = "Fremont 94538";
    public static String tc759expected = "Fremont, CA";
    // Denali-762:Subcity
    public static String tc762input = "Etobicoke, Toronto, ON CAN M8Y";
    public static String tc762expected = "Toronto, ON | Etobicoke";
    // Denali-770:Fuzzy search - Complete road type
    public static String tc770input = "De guigne Drive";
    public static String tc770expected = "De Guigne Dr";
    // Denali-771:Fuzzy search - Street with directional prefix
    public static String tc771input = "NW 9th St  Oswego, NY USA";
    public static String tc771expected = "NW 9th St";
    // Denali-773:Alternate Name
    public static String[] tc773input = {"469 Fashion Ave, Manhattan, NY", "469 7th Ave, Manhattan, NY"};
    public static String[] tc773expected = {"469 Fashion Ave", "469 7th Ave"};
    // Denali-775:Interval char - Comma
    public static String tc775input = "950,De guigne Dr,Sunnyvale,CA,94085";
    public static String tc775expected = "950 De Guigne Dr";
    // Denali-776:Street
    public static String tc776origin = "37.37890,-122.01074";
    public static String tc776input = "De guigne Dr";
    public static String tc776expected = "De Guigne Dr";
    // Denali-777:Street+IN+City
    public static String tc777origin = "37.37890,-122.01074";
    public static String tc777input = "De Guigne Dr in Sunnyvale";
    public static String tc777expect = "De Guigne Dr";
    // Denali-779:Street+City+State
    public static String tc779input = "Deguigne Dr. Sunnyvale CA";
    public static String tc779expected = "Deguigne Dr | De Guigne Dr";
    // Denali-780:Street+City+State+Country
    public static String tc780input = "Panchita Way Los Altos CA USA";
    public static String tc780expected = "Panchita Way";
    // Denali-782:Street+State+Postcode
    public static String tc782input = "Deguigne Dr. CA 94085";
    public static String tc782expected = "Deguigne Dr | De Guigne Dr";
    // Denali-783:Street+City+Country
    public static String tc783input = "Deguigne Dr. Sunnyvale USA";
    public static String tc783expected = "Deguigne Dr|deguigne dr|De Guigne Dr";
    // Denali-784:Street+City+Postcode
    public static String tc784input = "1st St San Francisco 94107";
    public static String tc784expected = "1st St";
    // Denali-785:Street+Postcode
    public static String tc785input = "Deguigne Dr. 94085";
    public static String tc785expected = "Deguigne Dr | De Guigne Dr";
    // Denali-786:Street+Postcode+Country
    public static String tc786input = "Deguigne Dr. 94085 USA";
    public static String tc786expected = "Deguigne Dr | De Guigne Dr";
    // Denali-787:Door Number+Street
    public static String tc787origin = "37.37890,-122.01074";
    public static String tc787input = "950 De guigne Dr";
    public static String tc787expect = "950 Deguigne Dr | 950 De Guigne Dr";
    // Denali-788:Door Number+Street+City
    public static String tc788input = "950 De guigne Dr Sunnyvale";
    public static String[] tc788expected = {"950 Deguigne Dr", "950 De Guigne Dr"}; // Onboard/Offboard
    // Denali-789:Door Number+Street+City+State
    public static String tc789input = "950 Deguigne Dr. Sunnyvale CA";
    public static String tc789expected = "950 Deguigne Dr | 950 De Guigne Dr";
    // Denali-790:Door Number+Street+State+Postcode
    public static String tc790input = "1 1st St, CA 94105";
    public static String tc790expected = "1 1st St";
    // Denali-792:Door Number+Street+City+Postcode
    public static String tc792input = "950 Deguigne Dr. Sunnyvale 94085";
    public static String tc792expected = "950 Deguigne Dr | 950 De Guigne Dr";
    // Denali-793:Door Number+Street+Postcode
    public static String tc793input = "950 Deguigne Dr. 94085";
    public static String tc793expected = "950 Deguigne Dr | 950 De Guigne Dr";
    // Denali-795:Door Number+Street+City+Postcode+State
    public static String tc795input = "950 Deguigne Dr. Sunnyvale 94085 CA";
    public static String tc795expected = "950 Deguigne Dr | 950 De Guigne Dr";
    // Denali-796:Door Number+Street+City+State+Postcode
    public static String tc796input = "950 Deguigne Dr. Sunnyvale CA 94085";
    public static String tc796expected = "950 Deguigne Dr | 950 De Guigne Dr";
    // Denali-804:Street with number
    public static String tc804input = "50 E Taylor St San Jose, CA 95112";
    public static String tc804expected = "50 E Taylor St | Fifty E Taylor St";
    // Denali-805:Street with order number
    public static String[] tc805input = {"1st St San Francisco, CA 94105", "First St San Francisco, CA 94105"};
    public static String tc805expected = "1st st";
    // Denali-807:Out of range door number
    public static String tc807input = "10000 Kifer Rd Sunnyvale CA";
    public static String tc807expected = "Kifer Rd"; // Need review the
    // expectation
    // Denali-809:Lat/lon search - Common
    public static String tc809origin = "37.37890,-122.01074";
    public static String tc809input = "37.790231, -122.408363";
    public static String tc809expect = "678 Bush St";
    // Denali-810:Lat/lon search - Special
    public static String tc810input = "44.774733, -114.950075";
    public static String tc810expected = "44.774733, -114.950075";
    // Denali-811:Str1+Str2
    public static String tc811origin = "37.37890,-122.01074";
    public static String tc811input = "Wolfe Rd Arques Ave";
    public static String tc811expected = "N Wolfe Rd at E Arques Ave";
    // Denali-814:Str1+Str2+City+Postcode
    public static String tc814input = "E Arques Ave @ Santa Ana Ct Sunnyvale 94085";
    public static String tc814expected = "Santa Ana Ct at E Arques Ave | E Arques Ave at Santa Ana Ct";
    // Denali-815:Str1+Str2+Of+Postcode
    public static String tc815input = "1st St and Howard St 94107";
    public static String tc815expected = "1st St at Howard St";
    // Denali-816:Str1+&+Str2
    public static String tc816input = "E Arques Ave & Santa Ana Ct";
    public static String tc816expected = "Santa Ana Ct at E Arques Ave | E Arques Ave at Santa Ana Ct";
    // Denali-821:Str1+at+Str2
    public static String tc821origin = "37.789060, -122.402077";
    public static String tc821input = "1st St at Howard St"; // Near SF.
    public static String tc821expected = "1st St at Howard St";
    // Denali-824:Str1+at+Str2+State+Postcode
    public static String tc824origin = "37.37890,-122.01074";
    public static String tc824input = "De Guigne Dr at Stewart Dr CA 94085";
    public static String tc824expect = "De Guigne Dr at Stewart Dr";
    // Denali-826:Str1+and+Str2
    public static String tc826input = "E Arques Ave and Santa Ana Ct";
    public static String tc826expected = "Santa Ana Ct at E Arques Ave | E Arques Ave at Santa Ana Ct";
    // Denali-828:Str1+and+Str2+In+City+State
    public static String tc828input = "1st St at Howard St San Francisco CA";
    public static String tc828expected = "1st St at Howard St";
    // Denali-835:Str1+@+Str2+of+State+Country
    public static String tc835input = "1st St @ Howard St CA USA";
    public static String tc835expected = "1st St at Howard St";
    // Denali-836:Multiple Intersections
    public static String tc836origin = "37.546651, -121.986742";
    public static String tc836input = "Grimmer Blvd at Fremont Blvd CA";
    public static String tc836expected = "Grimmer Blvd at Fremont Blvd";
    // Denali-838:Intersection_Roundabout With/Without Name
    public static String tc838origin = "37.717265, -122.476515";
    public static String[] tc838input = {"Juan Bautista Cir and Font Blvd San Francisco",};
    public static String[] tc838expected = {"Juan Bautista Cir at Font Blvd"};
    // Denali-841:Enter space
    public static String tc841origin = "37.37890,-122.01074";
    // Denali-852:Search category
    public static String tc852origin = "37.37890,-122.01074";
    public static String tc852input = Fuel;
    public static String tc852expect = "Valero & 76 & Chevron";
    //	public static int tc852resultNumber = 50;
    // Denali-854:Search result detailed info
    public static String tc854origin = "37.37890,-122.01074";
    public static String tc854input = Fuel;

    //Denali-860:View result list - scroll
    public static String tc860origin = "37.380909, -122.009474";
    public static String tc860dest = "KFC";

    // Denali-861:Preferred Route = ECO
    public static String tc861origin = "37.399293, -121.867746";
    public static String tc861dest = "37.420026, -122.152592";

    // Denali-862:Search result - Drive time without guidnace
    public static String tc862origin = "37.386367,-122.004646";
    public static String tc862searchtext = "SFO";
    public static String tc862searchresult = "San Francisco Int'l Airport";

    // Denali-867:Scroll map on search result list
    public static String tc867origin = OfficeLatLon;

    // Denali-920:Current vehicle position-unnamed
    public static String tc920origin = "37.385546, -122.014443";
    // Denali-921:Auto zoom timing - local road
    public static String tc921origin = "37.380902, -122.009629";
    public static String tc921dest = "37.386864, -121.992640";
    public static int tc921metric = 800;
    // Denali-922:Auto zoom for highway
    public static String tc922origin = "37.286654, -121.936909";
    public static String tc922dest = "37.317290, -121.934417";
    //Test case name: Denali-924:Restore Zoom scale - highway
    public static String tc924origin = "37.459633, -121.924222";
    public static String tc924dest = "46455 Warm Springs Blvd Fremont, CA 94539";

    //Denali-925:Dest Drive To Current Dest Sign
    public static String tc925origin = "37.373898, -122.056759";
    public static String tc925dest = "198 E El Camino Real, Sunnyvale CA 94087";
    public static String tc925expect = "198 E El Camino Real";

    // Denali-926:Arrival message-Destination
    public static String tc926dest = "289 Santa Ana Ct";

    // Denali-935:EJV(Enhanced Junction View
    public static String tc935origin = "37.619330,-122.425032";
    public static String tc935dest = "37.630130,-122.424978";

    // Denali-936:GJV(Generic Junction View)
    public static String tc936origin = "33.823170,-118.081366";
    public static String tc936dest = "33.831360,-118.075089";

    // Denali-937:SAR(Sign As Real)
    public static String tc937origin = "37.547360,-122.290353";
    public static String tc937dest = "37.555340,-122.287306";
    // Denali-938:GMS(Generic Motorway Signs)
    public static String tc938origin = "38.879307, -77.128779";
    public static String tc938dest = "38.881966, -77.118415";

    // Denali-939:Lane Guidance show timing - Highway
    public static String tc939origin = "37.493736, -121.949651";
    public static String tc939dest = "5399 Auto Mall Pkwy";
    // Denali-942:Correct number of lanes
    public static String tc942origin = "37.380914, -122.005978,315";
    public static String tc942dest = "37.374440, -122.013949";
    public static int tc942ln = 4;// (left turn)|(left
    // turn)|(straight)|(straight and right
    // turn)
    // Denali-943:Lane guidance display timing - Major road
    public static String tc943origin = "41.852782, -87.632944";
    public static String tc943dest = "41.848707, -87.626984";
    public static String tc943expaudio = "in one quarter of a mile turn right";

    // Denali-948:Lane guidance type Continue and Left //(left
    // turn)|(straight)|(straight)|(straight )
    public static String tc948origin = "37.380607, -122.012151";
    public static String tc948dest = "37.377193, -122.009855";
    // Denali-949:Lane guidance type Continue and Right //(straight)|(right )
    public static String tc949origin = "37.789882, -122.400672";
    public static String tc949dest = "37.787640, -122.406112";
    // Denali-951:Lane guidance type Right //right | right
    public static String tc951origin = "37.788588, -122.406422";
    public static String tc951dest = "37.787728, -122.400849";
    // Denali-954:Lane guidance type Left Uturn
    public static String tc954origin = "37.406925, -121.997361,180";
    public static String tc954dest = "37.405674, -121.996348";
    // Denali-956:Lane guidance type Left and Right
    public static String tc956origin = "37.771556, -122.506504, 270";// set
    // vehicle
    // direction
    // to west
    public static String tc956dest = "37.767785, -122.510498";
    // Denali-957:Lane guidance type Continue and Left and Right//(left
    // turn)|(straight)|(straight)|(right )
    public static String tc957origin = "41.852771, -87.632372";// set vehicle
    // direction
    // to east
    //

    public static String tc957dest = "41.848707, -87.626984";
    //Denali-960:No results - has suggestions
    public static String tc960searchText = "KFC near Main St";

    //Denali-962:Route Type Preferences
    public static String tc962origin = "37.37890,-122.01074";
    // Denali-964:Route Overview
    public static String tc964origin = "37.37890,-122.01074";
    public static String tc964dest = "SFO";
    //  Denali-965:Recenter around destination
    public static String tc965input = "NYC";

    //Denali-969:End navigation
    public static String tc969origin = "37.37890,-122.01074";
    public static String tc969input = "KFC";
    // Denali-970:Demo long route
    public static String tc970origin = "37.37890,-122.01074";
    public static String tc970dest = "New York, NY";
    // Denali-973:Repeated search and map action while long route
    public static String tc973origin = "37.421358, -121.934800";
    public static String tc973dest = "Seattle, WA";
    // Denali-974:Map action in 3D map
    public static String tc974origin = "37.789060, -122.402077";
    // Denali-987:Zoom out before auto zoom
    public static String tc987origin = "37.380902, -122.009629";
    public static String tc987dest = "37.386864, -121.992640";
    public static int tc987metric = 800;
    //Denali-988:Zoom out after auto zoom
    public static String tc988origin = "37.380955, -122.010282";
    public static String tc988dest = "37.386991, -122.004875";
    public static String tc988manuever = "E Arques Ave";

    // Denali-997:Vehicle icon menu - Home/Work are set up
    public static String tc997origin = "37.375615, -122.047391";
    public static String tc997home = "355 N Wolfe Rd Sunnyvale, CA 94085";
    public static String tc997work = "950 Deguigne Dr Sunnyvale CA 94085";

    //Denali-1008:Back
    public static String tc1008origin = "37.37890,-122.01074";
    public static String tc1008input = "KFC";

    //Denali-1012:Zoom in/out button - Disappear
    public static String tc1012origin = "37.37890,-122.01074";

    //Denali-1013:Route View - Display in guidance
    public static String tc1013origin = "37.37890,-122.01074";
    public static String tc1013input = "KFC";

    // Denali-1016:Avoid pop up info
    public static String tc1016origin = "37.366713, -122.009559";
    public static String tc1016dest = "37.369296, -122.000483";
    public static String tc1016avoid = "E Evelyn Ave";

    // Denali-1017:Tight turn auto zoom
    public static String tc1017origin = "37.384050, -122.028454";
    public static String tc1017dest = "37.393814, -122.023270";
    public static String tc1017maneuver1 = "W Maude Ave";
    public static String tc1017maneuver2 = "Borregas Ave";

    // Denali-1018:Waypoint Skip To Next Sign
    public static String tc1018origin = "37.373898, -122.056759";
    public static String tc1018dest = "198 E El Camino Real, Sunnyvale, CA 94087";
    public static String tc1018category = Food;
    public static String tc1018wp = "SUBWAY";
    public static String tc1018DriveTo = "Drive to 198 E El Camino Real";
    // Test case name:Denali-1019:Show junction view on turn list
    public static String tc1019origin = "37.455914, -121.923137";
    public static String tc1019dest = "37.495843, -121.948217";
    // Denali-1020:Show turn list on junction view
    public static String tc1020origin = "37.434628, -121.918859";

    //Denali-1022:Resume trip bubble display - End trip
    public static String tc1022origin = "37.37890,-122.01074";
    public static String tc1022input = "KFC";

    //Denali-1024:Waypoint pop up
    public static String tc1024origin = "37.37890,-122.01074";
    public static String tc1024dest = "KFC";
    //Denali-1025:Add waypoint options-cancel
    public static String tc1025origin = "37.37890,-122.01074";
    public static String tc1025dest = "KFC";
    public static String tc1025search = "Shell";

    //Denali-1026:Add waypoint options-Add as Waypoint
    public static String tc1026origin = "37.37890,-122.01074";
    public static String tc1026dest = "KFC";
    public static String tc1026wp = "Chevron";

    //Denali-1027:Add waypoint options-Make new destination
    public static String tc1027origin = "37.37890,-122.01074";
    public static String tc1027dest = "KFC";
    public static String tc1027wp = "Shell";

    //Denali-1028:Add waypoint method
    public static String tc1028origin = "37.37890,-122.01074";
    public static String tc1028dest = "KFC";
    public static String tc1028expect = "KFC";
    public static String tc1028wp = "Shell";

    // Denali-1050:Exit Amenities Icon - local road
    public static String tc1050origin = "37.406358, -121.995664";
    public static String tc1050Dest = "37.416818, -121.977421";
    // Denali-1051:Exit Amenities Icon - highway
    public static String tc1051origin = "37.410699, -121.991901";
    public static String tc1051Dest = "37.418709, -121.969046"; // Exit 6 of
    // CA237
    // Denali-1052:Exit Amenity List generic info
    public static String tc1052origin = "37.406818, -122.009313";
    public static String tc1052Dest = "37.411197, -121.989281";
    public static String tc1052Exit = "Exit 5";
    // Denali-1053:Exit Amenity List - available POI info
    public static String tc1053origin = "37.410699, -121.991901";
    public static String tc1053Dest = "37.418822, -121.966675";
    public static String tc1053Exit = "Exit 6";

    // Denali-1054:Seach exit POI
    public static String tc1054origin = "37.496527,-121.953360";
    public static String tc1054dest = "37.516405,-121.978514";
    public static String tc1054expectExit = "Exit 15";
    public static String[] tc1054ExpectedExitPOIType = {"Gas", "coffee", "food"};

    // Denali-1060:Waypoint edit view
    public static String tc1060origin = "37.37890,-122.01074";
    public static String tc1060dest = "SFO";
    public static String tc1060wp = "Starbucks";

    // Denali-1072:Search along route - Category search
    public static String tc1072origin = "37.37890,-122.01074";
    public static String tc1072dest = "SFO";
    public static String tc1072input = Fuel;
    public static String tc1072expect = "76";
    // Denali-1087:FreeMap
    public static String tc1087origin = "37.789060, -122.402077";
    // Denali-1090:Recent destination - Drive
    public static String tc1090origin = "37.37890,-122.01074";
    public static String tc1090destination1 = "Shell";
    public static String tc1090destination2 = "Chevron";

    //Denali-1092:Next/Previous page
    public static String tc1092input = "KFC";

    //Denali-1094:Only one result
    public static String tc1094input = "37.397399, -122.022781";
    // Denali-1095:Sub panel display priority
    public static String tc1095origin = "37.788390, -122.407762";
    public static String tc1095dest = "37.787322, -122.400292";
    public static String tc1095originTight = "37.380957, -122.012438, 270";
    public static String tc1095destTight = "37.382072, -122.016816 ";

    //Denali-1101:Rich data POI - Introduction
    public static String tc1101origin = "37.380909, -122.009474";
    public static String tc1101dest = "Yoga Tree, Valencia St, San Francisco, CA";
    // Denali-1108:Set POI category to favorite
    public static String tc1108origin = "37.37890,-122.01074";
    public static String tc1108expect = "Starbucks";
    //	//Denali-1117:Next maneuver card - waypoint/dest address info
    public static String tc1117origin = "37.380918, -122.009465";
    public static String tc1117dest = "1135 E Arques Ave";

    //Denali-1118:Action - avoid waypoint
    public static String tc1118origin = "37.37890,-122.01074";
    public static String tc1118dest = "KFC";
    public static String tc1118wp = "76";
    //Denali-1119:Delete dest
    public static String tc1119origin = "37.37890,-122.01074";
    public static String tc1119dest = "KFC";
    public static String tc1119expect = "KFC";
    public static String tc1119wp = "Chevron";

    //Denali-1132:Result list - Close
    public static String tc1132input = "KFC";
    //Denali-1133:Result list - Back
    public static String tc1133input = "KFC";
    //Denali-1134:Detail info
    public static String tc1134input = "SFO";
    //Denali-1135:Detail info - Drive
    public static String tc1135input = "SFO";
    //Denali-1141:Back from home
    public static String tc1141input = TestData.Health;

    //Denali-1147:Route list - Back
    public static String tc1147origin = "37.37890,-122.01074";
    public static String tc1147input = "KFC";
    //Denali-1148:Route list - Close
    public static String tc1148origin = "37.37890,-122.01074";
    public static String tc1148input = "KFC";
    //Denali-1149:Route Edit - Back
    public static String tc1149origin = "37.37890,-122.01074";
    public static String tc1149input = "KFC";
    //Denali-1150:Route Edit - Close
    public static String tc1150origin = "37.37890,-122.01074";
    public static String tc1150input = "KFC";
    // Denali-1151:Did you mean page - Back
    public static String tc1151searchText = "KFC near Main St";
    //Denali-1153:Waypoint Edit - Back
    public static String tc1153origin = "37.37890,-122.01074";
    public static String tc1153input = "KFC";
    //Denali-1154:Waypoint Edit - Close
    public static String tc1154origin = "37.37890,-122.01074";
    public static String tc1154input = "KFC";
    public static String tc1154waypoint = "Chevron";
    //Denali-1158:Search - Close
    public static String tc1158origin = "37.37890,-122.01074";
    public static String tc1158input = "KFC";
    //Denali-1159:Back from home
    public static String tc1159origin = "37.37890,-122.01074";
    public static String tc1159input = "SFO";
    public static String tc1159input1 = Fuel;
    // Denali-1161:Show POI icons on map
    public static String tc1161origin = "37.789060, -122.402077";
    // Denali-1162:Hide all POI icons on map
    public static String tc1162origin = originFromLocation;

    //Denali-1163:Brand icon
    public static String tc1163origin = originFromLocation;

    //Denali-1166:Home/Work address stored
    public static String tc1166home = "1951 Tradan Dr, San Jose, CA";
    public static String tc1166work = "950 De Guigne Dr, Sunnyvale, CA";

    //Denali-1167:Simple Arrival View-Destination
    public static String tc1167origin = "37.378279, -121.995848";
    public static String tc1167dest = "550 Lawrence Expy Sunnyvale CA";
    public static String tc1167expect = "550 Lawrence Expy";

    // Denali-1168:Simple Arrival View-Waypoint
    public static String tc1168origin = "37.382515, -121.995675";
    public static String tc1168dest = "KFC";
    public static String tc1168category = Food;
    public static String tc1168wp = "McDonald's";

    // Denali-1169:Waypoint/dest info-POI
    public static String tc1169origin = "37.380921, -122.009718";
    public static String tc1169dest = "KFC";
    public static String tc1169waypoint = "76";

    // Denali-1170:Next maneuver card - waypoint/dest POI info
    public static String tc1170origin = "37.376997, -121.995866";
    public static String tc1170dest = "545 Oakmead Pkwy";
    public static String tc1170expectDest = "545 Oakmead Pkwy";
    public static String tc1170category = Food;
    public static String tc1170wp = "McDonald's";
    public static String tc1170expectWp = "McDonald's";
    public static String tc1170expectTurn = "LocationRight";

    //Denali-1172:3D landmark Setting = OFF
    public static String tc1172origin = "37.789060, -122.402077";

    // Denali-1191:Add from one box search
    public static String tc1191origin = "37.37890,-122.01074";
    public static String tc1191dest = "933 Kifer Rd, Sunnyvale, CA 94086";
    public static String tc1191recent = "Kifer Rd";
    public static String tc1191wp = "Starbucks";

    // Denali-1192:Add Waypoint to Recent
    public static String tc1192origin = "37.37890,-122.01074";
    public static String tc1192destination1 = "Shell";
    public static String tc1192destination2 = "Chevron";

    // Denali-1193:Entries sort by Date and Time
    public static String tc1193destination1 = "Starbucks";
    public static String tc1193destination2 = "KFC";
    public static String tc1193destination3 = "Shell";
/*	// Denali-1193:Entries sort by Date and Time
    public static String tc1193dest1 = "New York, NY";
	public static String tc1193dest2 = "San Francisco Int'l Airport";
	public static String tc1193dest3 = "Shell";*/

    // Denali-1197:Hide selected POI icons on map
    public static String tc1197origin = originFromLocation;

    // Denali-1208:No results - No suggestion
    public static String tc1208input = "asdfghjkl";

    // Denali-1209:Dest arrival in turn list screen
    public static String tc1209origin = "37.385272, -122.017254,225";
    public static String tc1209dest = "Chevron";

    // Denali-1210:Detailed recent info
    public static String tc1210origin = "37.37890,-122.01074";
    public static String tc1210destination = "Shell";

    // Denali-1222:Set one box search to favorite
    public static String tc1222input = "1130 Kifer Rd, Sunnyvale, CA";
    // Denali-1226:Show Junction View over Exit POI
    public static String tc1226origin = "37.419288, -121.947573";
    public static String tc1226Dest = "37.546648, -121.984885";
    // Denali-1227:Keep Search page over Junction View
    public static String tc1227origin = "37.530984, -122.275138";
    public static String tc1227dest = "37.555340,-122.287306";
    // Denali-1235:Change default zoom level NavigationMap
    public static String tc1235origin = "37.437647, -121.919426";
    public static String tc1235dest = "37.745787, -122.200759";

    // Denali-1243:Search Recent from One Box
    public static String tc1243origin = "37.37890,-122.01074";
    public static String tc1243destination = "Shell";
    public static String tc1243expected = "Shell";
    // Denali-1244:Did you mean page - Close
    public static String tc1244searchText = "KFC near Main St";
    // Denali-1245:Search history list - belong to Recent/Favorites/Contact
    public static String tc1245input = "960 Kifer Rd Sunnyvale CA";
    public static String tc1245expected = "960 kifer rd";

    // Denali-1242:Save Favorite from city search
    public static String tc1242input = "Sunnyvale, CA";
    public static String tc1242expected = "Sunnyvale, CA";

    // Denali-1246:Search History list - No result return
    public static String tc1246input = "!ab23cdefg!@#$";

    //Denali-1247:City name
    public static String tc1247input = "Sunnyvale CA";
    public static String[] tc1247expect = {"Sunnyvale, CA"};
    public static String tc1247origin = "37.37890,-122.01074";

    // Denali-1248:Street name
    public static String tc1248origin = "37.37890,-122.01074";
    public static String[] tc1248input = {"989 Reed Ave", "Reed Ave"};

    //Denali-1249:Detali info - get route failed
    public static String tc1249origin = "37.37890,-122.01074";
    public static String tc1249dest = "19.759807, -155.540270";

    //Denali-1250:Search result - Drive time with guidance
    public static String tc1250origin = "37.386367,-122.004646";
    public static String tc1250searchtext = "SFO";
    public static String tc1250searchresult = "San Francisco Int'l Airport";
    public static String tc1250coffee = "Starbucks";

    // Denali-1251:Search result - Distance
    public static String tc1251origin = "37.37890,-122.01074";
    public static String tc1251dest = "SFO";
    public static String tc1251destexpect = "San Francisco Int'l Airport";

    //Denali-1253:Half screen buttons - Search
    public static String tc1253origin = "37.37890,-122.01074";

    // Denali-1254:Half screen buttons - Guidance
    public static String tc1254origin = "37.434628, -121.918859";
    public static String tc1254dest = "37.449913, -121.915186";


    // Denali-1255:Half screen buttons - Route
    public static String tc1255origin = "37.37890,-122.01074";
    //public static String tc1255dest = "37.449913, -121.915186";

    // Denali-1269:Next maneuver card - turn icon
    public static String tc1269origin = "37.365370, -122.049972";
    public static String tc1269dest = "809 Piper Ave, Sunnyvale";
    public static String[][] tc1269expect = {{"Hanover Ave", "TurnRight"}, {"Elmira Dr", "TurnLeft"}, {"Piper Ave", "TurnRight"}, {"809 Piper Ave", "LocationLeft"}};
    // Denali-1446:Delete favorite from navigation app
    public static String tc1446origin = "37.37890,-122.01074";
    public static String tc1446input = "2457 Lawrence Expy, Sunnyvale, CA";
    //	Denali-1448:Play of Railroad Crossing = OFF
    public static String tc1448origin = "37.376397, -122.029114";
    public static String tc1448dest = "37.379253, -122.027952";
    // Denali-1483:Alert of Railroad Crossing = ON - Approach
    public static String tc1483origin = "37.382639, -122.026837,180";
    public static String tc1483dest = "37.376397, -122.029114";
    // Denali-1487:Turn right after landmark
    public static String tc1487origin = "37.380701, -122.004244,270";
    public static String tc1487dest = "37.383470,-122.013452";
    public static String tc1487expect[] = {"guidance will start now", "in (.*) turn right.", "in (.*) turn right after the (.*) to (.*)", "turn right to (.*)"};
    // Denali-1496:repeat oneBoxEditText search
    public static String tc1496origin = "37.37890,-122.01074";
    // Denali-1497:map action while route in a big city
    public static String tc1497origin = "42.329645, -83.039008";
    public static String tc1497dest = "5144 Chase Rd, Dearborn, MI 48126";
    //	Denali-1501:Alert of Railroad Crossing= ON
    public static String tc1501origin = "37.379690, -122.027810,180";
    public static String tc1501dest = "37.371809, -122.030718";
    // Denali-1502:Save Favorite from POI brand name search
    public static String tc1502input = "KFC";
    // Denali-1505:Select one from favorite list
    public static String tc1505input = "KFC";
    // Denali-1506:Favorite list
    public static String tc1506origin = "KFC";
    public static String tc1506origin2 = "Starbucks";

    //Denali-1596:3D Landmarks = ON
    public static String tc1596origin = "37.789060, -122.402077";

    // Denali-1718:Current street name display-No vehicle access road
    public static String tc1718origin = "37.769604, -122.505133";
    public static String tc1718dest = "San Francisco, CA";
    // Denali-1719:long route at background
    public static String tc1719origin = "37.37890,-122.01074";
    public static String tc1719dest = "Seattle, WA";

    // Denali-2315:15 Total Hot Categories
    public static String[] tc2315categorylist = {Food, Coffee, Fuel, Shopping, Parking, Dealerships, Transit, Lodging, ATM, Attractions, Health, Entertainment, Leisure, Emergency};
    // Denali-2316:Food Sub Category
    public static String[] tc2316subcategorylist = {Food, Restaurant, FastFood, Coffee, Bars, Bakeries, IceCream, Pizza, Hamburgers, Barbecue};
    // Denali-2319:Fuel Sub Category
    public static String[] tc2319subcategorylist = {Fuel};
    // Denali-2321:Shopping Sub Category
    public static String[] tc2321subcategorylist = {Grocery, ConvenienceStore, ShoppingCenter, Bakeries, DepartmentStore, ConsumerElectronics, HomeImprovement, BookStore};
    // Denali-2323:Parking Sub Category
    public static String[] tc2323subcategorylist = {Parking, ParkingLot, ParkingGarage, ParkAndRide};
    // Denali-2326:Transit Sub Category
    public static String[] tc2326subcategorylist = {Airport, Railway, LocalTransitStop, BusStation, FerryTerminal, CarRental};
    // Denali-2327:Lodging Sub Category
    public static String[] tc2327subcategorylist = {Lodging, Hotel, BedAndBreakfast};
    // Denali-2331:ATM Sub Category
    public static String[] tc2331subcategorylist = {ATM, Bank};
    // Denali-2333:Attractions Sub Category
    public static String[] tc2333subcategorylist = {Attractions, Park, TouristAttraction, Museum, HistoricalSite, AmusementPark};
    // Denali-2335:Health Sub Category
    public static String[] tc2335subcategorylist = {Pharmacy, Hospital, MedicalService};
    // Denali-2336:Entertainment Sub Category
    public static String[] tc2336subcategorylist = {Movies, Bars, NightClub, PerformingArts, Casino};
    // Denali-2337:Leisure Sub Category
    public static String[] tc2337subcategorylist = {FitnessCenter, SportsCenter, SwimmingPool, Campground, Beaches, RecreationCenter, Golf, Tennis, SkiResort};
    // Denali-2339:Emergency Sub Category
    public static String[] tc2339subcategorylist = {EmergencyCenter, PoliceStation, TowingService};

    // TrueDelta space list
    public static String[] space = {"USA_FL", "USA_GA", "USA_HI", "USA_ID", "USA_IL", "USA_IN", "USA_IA", "USA_KS", "USA_KY", "USA_LA", "USA_AL", "USA_ME", "USA_MD", "USA_MA", "USA_MI", "USA_MN", "USA_MS", "USA_MO", "USA_MT", "USA_NE", "USA_NV", "USA_AK", "USA_NH", "USA_NJ", "USA_NM", "USA_NY", "USA_NC", "USA_ND", "USA_OH", "USA_OK", "USA_OR", "USA_PA", "USA_AZ", "USA_RI", "USA_SC", "USA_SD", "USA_TN", "USA_TX", "USA_UT", "USA_VT", "USA_VA", "USA_WA", "USA_WV", "USA_AR", "USA_WI", "USA_WY", "CAN_NL", "CAN_PE", "CAN_NS", "CAN_NB", "CAN_QC", "CAN_ON", "CAN_MB", "CAN_SK", "USA_CA", "CAN_AB", "CAN_BC", "CAN_YT", "CAN_NT", "CAN_NU", "MEX_AG", "MEX_BN", "MEX_BS", "MEX_CM", "MEX_CP", "USA_CO", "MEX_CH", "MEX_CA", "MEX_CL", "MEX_DF", "MEX_DU", "MEX_GT", "MEX_GR", "MEX_HI", "MEX_JA", "MEX_MX", "USA_CT", "MEX_MC", "MEX_MR", "MEX_NA", "MEX_NL", "MEX_OA", "MEX_PU", "MEX_QE", "MEX_QR", "MEX_SL", "MEX_SI", "USA_DC", "MEX_SO", "MEX_TB", "MEX_TM", "MEX_TL", "MEX_VE", "MEX_YU", "MEX_ZA", "USA_PR", "USA_VI", "USA_DE"};
//	public static String[] space = {"USA_IL"};


    //data usage
    //testSearchDataUsage
    public static String Origin_Search = "37.789060, -122.402077";

    //Denali-1461:Download delta - Interrupted
    public static String tc1461origin = "37.37890,-122.01074";
    public static String tc1461space = "USA_CA";

    //Denali-1465:Detect delta - Without new version
    public static String tc1465origin = "37.37890,-122.01074";
    public static String tc1465space = "USA_CA";

    //Denali-1467:Prepare new data - Interrupted
    public static String tc1467origin = "37.37890,-122.01074";
    public static String tc1467space = "USA_CA";

    //Localization testing
    public static String Map001origin = "42.348343, -83.066515, 90";
    public static String Map002origin = "40.704480, -74.011968";
    public static String Map003origin = "42.348343, -83.066515, 90";
    public static String Map004origin = "42.348343, -83.066515, 90";
    public static String Map005origin = "42.348343, -83.066515, 90";
    public static String Map006origin = "42.348343, -83.066515, 90";
    public static String Map007origin = "42.348343, -83.066515, 90";
    public static String Map008origin = "42.348343, -83.066515, 90";
    public static String Map008home = "4210 Chene St Detroit, MI 48207";
    public static String Map008work = "4941 28th St, Detroit, MI 48210";
    public static String Map009origin = "42.348343, -83.066515, 90";
    public static String Map010origin = "42.348343, -83.066515, 90";
    public static String Map011origin = "42.348343, -83.066515, 90";
    public static String Map012origin = "42.348343, -83.066515, 90";

    public static String Search001origin = "42.348343, -83.066515, 90";
    public static String Search002origin = "42.348343, -83.066515, 90";
    public static String Search003origin = "42.348343, -83.066515, 90";
    public static String Search004origin = "42.348343, -83.066515, 90";
    public static String Search005origin = "42.348343, -83.066515, 90";
    public static String Search006origin = "42.348343, -83.066515, 90";
    public static String Search007origin = "42.348343, -83.066515, 90";
    public static String Search008origin = "42.348343, -83.066515, 90";
    public static String Search009origin = "42.348343, -83.066515, 90";
    public static String Search009input = "3526 Woodward Ave Detroit MI";
    public static String Search010origin = "42.348343, -83.066515, 90";
    public static String Search010input = "19.759807, -155.540270";

    public static String Nav001origin = "42.348343, -83.066515, 90";
    public static String Nav002origin = "42.348343, -83.066515, 90";
    public static String Nav003origin = "42.348343, -83.066515, 90";
    public static String Nav004origin = "37.602384, -122.379268";
    public static String Nav004dest = "37.6213129,-122.3811441";
    public static String Nav005origin = "37.788947, -122.403508";
    public static String Nav005dest = "37.788907, -122.402008";
    public static String Nav006origin = "37.380957, -122.012438,270";
    public static String Nav006dest = "37.382072, -122.016816";
    public static String Nav007origin = "37.626737, -121.382459";
    public static String Nav007dest = "35.388472, -119.383330";
    public static String Nav008origin = "37.394280,-122.007283";
    public static String Nav008dest = "37.322623, -121.835854";
    public static String Nav009origin = "42.348343, -83.066515, 90";
    public static String Nav010origin = "42.348343, -83.066515, 90";
    public static String Nav011origin = "42.348343, -83.066515, 90";
    public static String Nav012origin = "37.438896, -121.920033";
    public static String Nav012dest = "37.423305, -121.924372";
    public static String Nav013origin = "42.348343, -83.066515, 90";
    public static String Nav014origin = "42.348343, -83.066515, 90";
    public static String Nav015origin = "42.348343, -83.066515, 90";
    public static String Nav016origin = "42.348343, -83.066515, 90";
    public static String Nav017origin = "42.348343, -83.066515, 90";
    public static String Nav017dest = "616 Chase Ln Bloomfield Hills MI";
    public static String Nav018origin = "42.348343, -83.066515, 90";
    public static String Nav019origin = "42.348343, -83.066515, 90";
    public static String Nav020origin = "42.348343, -83.066515, 90";
    public static String Nav020dest = "42.269351, -83.367694";
    public static String Nav021origin = "37.37890,-122.01074";
    public static String Nav022origin = "42.348343, -83.066515, 90";
    public static String Nav023origin = "42.348343, -83.066515, 90";
    public static String Nav024origin = "42.348343, -83.066515, 90";
    public static String Nav025origin = "37.381052, -122.027376";
    public static String Nav025dest = "37.376397, -122.029114";


}
