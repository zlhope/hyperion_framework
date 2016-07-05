package com.telenav.uia.android.denali.testdata;

public class TnUIATestDataAF extends  TnUIATestData{


	/******************** Audio ***********************/
	public static String waypointApproach = "your waypoint is";
	
	//// Test Cases Data///////////////////////
	// Denali-2:Highway shields display condition
	public static String tc2origin = "37.323972, -121.892367";
	// Denali-11 : walkway
	public static String tc11origin = "37.391808, -121.981580";
	// Denali-16:One way street direction
	public static String tc16origin = "37.777092, -122.415935";
	// Denali-19 : State name display
	public static String tc19origin = "37.097612, -102.113829";
	// Denali-21:City name
	public static String tc21origin = "-34.002541, 18.558915";
	// Denali-22 : Street Name
	public static String tc22origin = "-33.922682, 18.418767";
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
	public static String tc47dest = "807 Piper Ave";
	public static String[][] tc47ExpectedTurn = {{"Hanover Ave","TurnRight"},{"Elmira Dr","TurnLeft"},{"Piper Ave","TurnRight"},{"807 Piper Ave, Sunnyvale, CA 94087, USA","LocationLeft"}};
	// Denali-48:Active route color
	public static String tc48origin = "37.382515, -121.995675";
	public static String tc48dest = "950 De guigne Dr";
	public static String tc48category = FastFood;
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
	// Denali-102:Zoom in/out in ocean
	public static String tc102origin = "37.398064, -122.696472";
	// Denali-105:Zoom in/out map_navigation
	public static String tc105searchTxt = "airport";
	// Denali-136:Junction view display
	public static String tc136origin = "37.389497,-121.989645";
	public static String tc136dest = "37.388168,-121.996043";
	// Denali-138:Junction view color
	public static String tc138origin = "37.434628, -121.918859";
	public static String tc138dest = "37.449913, -121.915186";
	// Denali-147:Exit POI info update
	public static String tc147origin = "37.418719, -121.969588";
	public static String tc147Dest = "37.421964, -121.931928";
	public static String tc147exit = "Exit North First Street";
	// Denali-150:GRC - highway
	public static String tc150origin = "37.425967, -121.916715";
	// Denali-154:RGC - Unnamed road
	public static String tc154origin = "37.384033, -122.014599";
	// Denali-232:Night color
	public static String tc232origin  = originFromLocation;
	// Denali-231:Day color
	public static String tc231origin = originFromLocation;
	// Denali-235:Set Home Address
	public static String tc235input = "1951 Tradan Dr, San Jose, CA";
	public static String tc235expected = "Tradan Dr, San Jose, CA";
	// Denali-236:Set Home Address
	public static String tc236input = "950 De Guigne Dr, Sunnyvale, CA";
	public static String tc236expected = "950 Deguigne Dr";
	// Denali-211:Generic 2.5D landmarks
	public static String tc211origin = "37.789060, -122.402077";
	// Denali-230:Add by Map
	public static String tc230origin = "37.37890,-122.01074";
	// Denali-260:JV show timing-Hwy -> Ramp -> Ramp -> Hwy
	public static String tc260origin = "48.143000, 11.743987";
	public static String tc260dest = "48.137374, 11.758618";
	// Denali-261:JV show timing-Hwy -> Ramp -> Ramp -> Local
	public static String tc261origin = "37.491508,-122.219516";
	public static String tc261dest = "37.487085,-122.216540";
	// Denali-262:JV show timing-Local -> Ramp -> Ramp -> Hwy
	public static String tc262origin = "37.415222,-122.078076";
	public static String tc262dest = "37.417201,-122.087073";
	// Denali-263:JV show timing-Local -> Ramp -> Ramp -> Local
	public static String tc263origin = "37.400990,-121.909490";
	public static String tc263dest = "37.400759,-121.909976";
	// Denali-264:JV show timing- Ramp -> Ramp -> Hwy
	public static String tc264origin = "37.316591, -121.943882";
	public static String tc264dest = "37.312588, -121.940683";
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
	public static String tc295origin = OfficeLatLon;
	public static String tc295dest = "927 Kifer Rd, Sunnyvale, CA 94086";
	public static String tc295exp = "Shell";

	// Denali-296:Route overview
	public static String tc296origin = "-33.925337, 18.413531";
	public static String tc296dest = "-33.928837, 18.424552";
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
	public static String tc300origin = "-33.922682, 18.418767";
	public static String tc300dest = "Stellenbosch, WESTERN CAPE";
	// Denali-301:One way street - Pass
	public static String tc301origin = "37.789692, -122.402165";
	public static String tc301SearchText = "105 Montgomery St";
	public static String tc301ExpectedSearchResult = "105 Montgomery St";
	public static String[] tc301ExpectedRoute = { "Market St", "Geary St", "Kearny St", "Bush St", "Montgomery St",
			"105 Montgomery St" };
	// Denali-302:Roundabouts - From
	public static String tc302Origin = "37.718114, -122.478028";// Juan Bistista
																// Circle

	public static String tc302Destination = "37.715510, -122.480045";
	public static String tc302Destination2 = "37.720527, -122.480763";
	public static String[] tc302SearchText = { "101 Crespi Dr", "426 Font Blvd" };
	public static String[] tc302ExpectedSearchResult = { "101 Crespi Dr", "426 Font Blvd" };
	// Denali-303:Roundabouts - To
	public static String tc303Origin = "37.716569, -122.475378";
	public static String tc303SearchText = "37.718114, -122.478028";// Juan
																	// Bistista
																	// Circle
	public static String tc303Destination = "Juan Bautista Cir";
	// Denali-304:Roundabouts - Pass
	public static String tc304origin = "-33.921146, 18.424043";
	public static String tc304dest = "-33.918604, 18.423830";
	public static String[][] tc304NextStInfo = { { "Roundabout", "EnterAhead" }, { "Hans Strijdom Ave", "ExitLeft" } };
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
	public static String tc318origin = "-33.930688, 18.440510";
	public static String tc318dest = "-33.951921, 18.443344";
	// Denali-325:Long route > 2000 mi
	public static String tc325Origin = "37.37890,-122.01074";
	public static String tc325SearchText = "NYC";
	public static String tc325ExpectedSearchResult = "New York, NY";
	public static int tc325Distance = 2000;
	// Denali-336:To vehicle position - On road
	public static String tc336SearchText = "230 Santa Ana Ct";
	public static String tc336ExpectedSearchResult = "230 Santa Ana Ct";
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
	public static String tc358dest ="255 W Maude Ave, Sunnyvale, CA 94085";
	// Denali-359:Add by POI
	public static String tc359Origin = "37.37890,-122.01074";
	public static String tc359Destination = "Shell";
	public static String tc359Waypoint = "Chevron";
	// Denali-361:Add by recent places
	public static String tc361Origin = "37.37890,-122.01074";
	public static String tc361SearchText = "KFC";
	// Denali-362:Start Route
	public static String tc362origin = "-33.911680, 18.418030";
	public static String tc362dest = Fuel;
	// Denali-367:Current street name in Guidance
	public static String tc367origin = OfficeLatLon;
	public static String tc367dest = "896 E Arques Ave, Sunnyvale CA";
	public static String[] tc367ExpectedSt ={"Santa Ana Ct","E Arques Ave"};
	// Denali-368:Next maneuver card - next street name
	public static String tc368origin = "37.366274, -122.052440";
	public static String tc368dest = "807 Piper Ave";
	public static String[] tc368ExpectedNextSt = {"Hanover Ave","Elmira Dr","Piper Ave","807 Piper Ave, Sunnyvale, CA 94087, USA"};
	// Denali-370:Dest arrival-on route
	public static String tc370origin = "-33.922594, 18.417851";
	public static String tc370dest = "Food Inn India";
	// Denali-374:The flag display when dest arrival
	public static String tc374dest = "289 Santa Ana Ct";
	// Denali-375:Cancel route
	public static String tc375origin = "-33.922682, 18.418767";
	public static String tc375dest = Fuel;

	//Denali-372:Add waypoint when arrive dest
	public static String tc372origin = "37.37890,-122.01074";
	public static String tc372dest = "289 Santa Ana Ct Sunnyvale CA";
	public static String tc372wpType = "Fuel";

	//Denali-379:MAX waypoints
	public static String tc379origin = "37.37890,-122.01074";
	public static String tc379dest = "KFC";
	public static String tc379wp = "NYC";
	public static String tc379wp1Type = "Fast Food";
	public static String tc379wp1 = "Florida City, FL";
	public static String tc379wp2 = "Chevron";

	//Denali-380:Add waypoint before arrive waypoint/dest
	public static String tc380origin = "37.37890,-122.01074";
	public static String tc380dest = "KFC";
	public static String tc380wp = "Chevron";
	public static String tc380wp1 = "76";

	//Denali-381:Delete Waypoint
	public static String tc381origin = "37.37890,-122.01074";
	public static String tc381dest = "KFC";
	public static String tc381wp = "Chevron";
	public static String tc381nwp1 = "76";

	//Denali-382:Delete all waypoints continuously
	public static String tc382origin = "37.37890,-122.01074";
	public static String tc382dest = "KFC";
	public static String tc382wp = "Shell";
	public static String tc382wp1Type = "Fast Food";
	public static String tc382nwp1 = "Taco Bell";
	public static String tc382wp2 = "76";

	//Denali-383:Reorder Waypoints
	public static String tc383origin = "37.37890,-122.01074";
	public static String tc383dest = "KFC";
	public static String tc383nwp = "Shell";
	public static String tc383wp1Type = "Fast Food";
	public static String tc382wp1 = "Taco Bell";
	public static String tc382wp3 = "76";

	//Denali-390:Add waypoint after arrive waypoint
	public static String tc390origin = "37.383120, -122.018021";
	public static String tc390dest = "KFC";
	public static String tc390wp = "Chevron";
	public static String tc390wp1 = "76";

	// Denali-384:Cancel route when arrive waypoint
	public static String tc384Origin = "37.383120, -122.018021";
	public static String tc384Destination = "KFC";
	public static String tc384Waypoint = "Chevron";
	// Denali-388:Waypoint arrival-on route
	public static String tc388origin = "-33.923165, 18.418346";
	public static String tc388dest = "CPT";
	public static String tc388category = Coffee;
	public static String tc388wp = "Shwarma Cafe";
	// Denali-390:Add waypoint after arrive waypoint
	public static String tc390Origin = "37.383120, -122.018021";
	// Denali-396:Legal routing - Right turn restricted //backup data:
	// 37.771503, -122.423829 to 37.770916, -122.422782
	public static String tc396Origin = "37.319996, -121.992034";
	public static String tc396Dest = "42.383843, -83.296678";
	public static String tc396NextStreet = "Centralia";
			// Denali-404:Sub panel - tight turn
	public static String tc404origin = "-33.924368, 18.415851";
	public static String tc404dest = "-33.923165, 18.418346";
	public static String tc404expTurnType1 = "TurnRight";
	public static String tc404expStreet1 = "Longmarket";
	public static String tc404expTurnType2 = "TurnRight";
	public static String tc404expStreet2 = "Long St";

	// Denali-405:ETA-Wpt and Dest in same Timezone
	public static String tc405origin = "37.37890,-122.01074";
	public static String tc405dest = "950 De guigne Dr";
	public static String tc405category = "Fast Food";
	public static String tc405wp = "McDonald's";

	//Denali-406:WTA-Wpt and Dest in different Timezone
	public static String tc406origin = "37.37890,-122.01074";
	public static String tc406dest = " Chicago IL";

	// Denali-410:ETA to Destination
	public static String tc410origin = OfficeLatLon;
	public static String tc410dest = "286 Santa Ana Ct, Sunnyvale CA";

	// Denali-411:ETA with one Waypoint
	public static String tc411origin = "37.382515, -121.995675";
	public static String tc411dest = "SFO";
	public static String tc411category = "Fast Food";
	public static String tc411wp = "McDonald's";

	// Denali-411:ETA with one Waypoint
	public static String tc419origin = "37.382515, -121.995675";
	public static String tc419dest = "SFO";
	public static String tc419category = "Fast Food";
	public static String tc419wp = "McDonald's";

	// Denali-412:ETA with Dest Change
	public static String tc412origin = "37.382515, -121.995675";
	public static String tc412dest = "SFO";
	public static String tc412category = "Fast Food";
	public static String tc412newDest = "McDonald's";

	// Denali-418:ETE to Destination
	public static int tc418ete = 16;
	public static String tc418origin = "-33.922594, 18.417851";
	public static String tc418dest = "CPT";
	public static String tc418expect = "Cape Town International Airport";

	// Denali-420:ETE with Dest Change
	public static String tc420origin = "37.382515, -121.995675";
	public static String tc420dest = "SFO";
	public static String tc420category = "Fast Food";
	public static String tc420wp = "McDonald's";

	// Denali-421:ETE with Waypoint Change
	public static String tc421origin = "37.382515, -121.995675";
	public static String tc421dest = "San Francisico";
	public static String tc421category1 = "Fast Food";
	public static String tc421wp1 = "McDonald's";
	public static String tc421category2 = "Gas";
	public static String tc421wp2 = "76";

	// Denali-459:Sub panel - lane guidance
	public static String tc459origin = "37.788187, -122.409572";
	public static String tc459dest = "37.786296, -122.399101";
	// Denali-488:Slight Right Turn on Local Street
	public static String tc488origin = "37.293980, -122.040128,270";
	public static String tc488Dest = "37.29249, -122.04629";
	//	Test case name: Denali-489:Keep right on Local Street
	public static String tc489origin = "19.489697, -99.142227";
	public static String tc489dest = "19.48727, -99.13237";
	// Denali-491:Left turn on Local Street
	public static String tc491origin = "37.418714, -122.124722";//set vehicle direction to east
	public static String tc491Dest = "37.416866,-122.087016";
	//	Denali-496: Turn sharp left on Local Street
	public static String tc493origin = "37.684317, -122.463654,1";
	public static String tc493Dest = "37.687696, -122.468374";
	public static String tc493expected[] = {"guidance will start now", "^in (.*) turn sharp left after (.*) to (.*)", "^turn sharp left to (.*)"};
	//  Denali-496:Make a U-turn
	public static String tc496origin = "37.378484, -121.995819,0";
	public static String tc496dest = "19.416468, -99.087186";
	//	Denali-497:Enter large roundabout
	public static String tc497origin = "19.420962, -99.088337";
	public static String tc497dest = "19.416468, -99.087186";
	//	Denali-472 Start Route Guidance - on road/ between 15mi and info range
	public static String tc472origin = "37.403973, -122.051116";
	public static String tc472dest = "431 E Dunne Ave, Morgan Hill, CA 95037";
	public static String[] tc472expected = {"guidance will start now","proceed on (.*)" };
	// Denali-473:Start Route Guidance - between info range and 1st guidance
	public static String tc473origin = "-34.086703, 18.836771";
	public static String tc473dest = "-34.132123, 18.913267";
	// Denali-477:Start Route Guidance - between 2nd and 3rd guidance
	public static String tc477origin = "37.380015, -122.010533";
	public static String tc477Dest = "37.380906, -122.007712";
	//	Denali-500:Enter Ferry
	public static String tc500origin = "48.684840, -123.410535";
	public static String tc500dest = "48.806771, -123.308460";
	//  Denali-501:Exit ferry
	public static String tc501origin = "48.690611, -123.402992,225";
	public static String tc501dest = "48.68785, -123.41060";
	// Denali-505:Highway Entrance - slight right
	public static String tc505origin = "49.306744,-123.038331";
	public static String tc505Dest = "49.297791,-123.026447";
	//	Denali-506:Highway Entrance - turn left
	public static String tc506origin = "37.349951, -121.873995";
	public static String tc506Dest = "37.358204, -121.870742";
	public static String tc506expected[] = {"guidance will start now", "^in (.*) use (.*) lane to turn left to (.*) towards (.*)", "^in (.*) use (.*) lane to turn left to (.*) towards (.*)", "^turn left to (.*)"};
	// Denali-515:Highway-to-road Exit - take exit on the right
	public static String tc515origin = "37.403973, -122.051116";
	public static String tc515Dest = "37.394500,-122.029047";
	// Denali-540:Continuous Guidance - dest arrival
	public static String tc540rigin = "37.374258,-121.958367";
	public static String tc540dest = "37.366896,-121.959510,1";
 	// Denali-522:Highway transition - take exit on the right
	public static String tc522origin = "37.250590, -121.894878";
	public static String tc522Dest = "37.275703,-121.863164";
	//	Denali-528:Highway to same highway-keep left
	public static String tc528origin = "19.602329, -99.188903";
	public static String tc528Dest = "19.586047, -99.204262";
	// Denali-552:Dest arrival-on the left
	public static String tc552origin = "37.380952, -122.011622";
	public static String tc552dest = "1145 E Arques Ave Sunnyvale, CA 94085";
	//  Denali-555:Continuous Guidance - waypoint arrival
	public static String tc555origin = "37.375631, -122.061071";
	public static String tc555Dest = "37.352133, -122.003358";
	public static String tc555wp = "SUBWAY";
	public static String tc555category = "Fast Food";
	// Denali-583:RGC - CAN
	public static String tc583origin = "43.676396, -79.401367";
	// Denali-584:RGC - MEX
	public static String tc584origin = "25.688738, -100.317290";
	// Denali-587:Turn icon - Roundabout
	public static String tc587origin = "37.717027, -122.476122,315";
	public static String[] tc587dest = {"14 Diaz Ave","117 Crespi Dr","16 Fuente Ave","422 Font Blvd",
			"30 Bucareli Dr","4 Grijalva Dr","24 Josepha Ave"};
	// Denali-588:Turn icon - U-turn
	public static String tc588origin = "37.383161, -121.995734";
	public static String tc588dest = "1177 Kern Ave";
	public static String tc588expect = "LeftUTurn";
	// Denali-590:Valid Postcode+unrelated country
	public static String tc590input = "12345 USA";
	// Denali-591:next maneuver card - distance update
	public static String tc591origin = "37.366168, -122.051775";
	public static String tc591dest = "831 Piper Ave";
	
	// Denali-592:Destination icon direction
	public static String tc592origin = "37.380950, -122.011539";
	public static String tc592destLeft = "1135 E Arques Ave";
	public static String tc592destRgiht = "1090 E Arques Ave";
	public static String tc592destAhead = "E Arques Ave at Santa Trinita Ave";
	public static String tc592expectAhead = "LocationAhead";
	public static String tc592expectLeft = "LocationLeft";
	public static String tc592expectRight= "LocationRight";
	
	// Denali-607:POI category
	public static String tc607input = "KFC";
	// Denali-613:Avoid Freeway = OFF
	public static String tc613origin = "37.390522, -122.030263";
	public static String tc613input = "822 N Fair Oaks Ave";
	public static String tc613expected = "822 N Fair Oaks Ave";
	public static String tc613road = "US-101";

	//Denali-614:Avoid Freeway/Motorway = ON
	public static String tc614origin = "37.390049, -122.030354";
	public static String tc614input = "37.390049, -122.030354";
	public static String tc614expected = "US-101";

	//:Denali-615:Avoid Toll Road = OFF
	public static String tc615origin = "37.390049, -122.030354";
	public static String tc615input = "37.390049, -122.030354";
	public static String tc615expected = "US-101";

	// Denali-635:Show timing-get route successfully
	public static String tc635origin = "-33.911680, 18.418030";
	public static String tc635dest = "CPT";

	// Denali-640:Route list info
	public static String tc640origin = "37.366168, -122.051775";
	public static String tc640dest = "831 Piper Ave";
	public static String tc640st1 = "Hanover Ave";
	public static String tc640st2 = "Elmira Dr";
	public static String tc640st3 = "Piper Ave";
	public static String[] tc640st1Dist = {"1046","1066"};
	public static String[] tc640st2Dist = {"369","389"};
	public static String[] tc640st3Dist = {"237","257"};

	// Denali-677:Route display
	public static String tc653origin = "37.380909, -122.009474";
	public static String tc653dest = "KFC";
	public static String tc653wp = "Starbucks";

	// Denali-677:Route display
	public static String tc677origin = "37.392024, -121.998297";
	public static String tc677dest = "SFO";

	//Denali-684:Preferred Route = Fastest
	public static String tc684origin = "50.075099, 14.390438";
	public static String tc684dest = "50.075619, 14.389667";
	
	// Denali-695:Demo route
	public static String tc695origin = "-33.924290, 18.415914";
	public static String tc695dest = "KFC";

	//Denali-697:Cancel demo
	public static String tc697input = "37.37890,-122.01074";
	public static String tc697expected = "SFO";

	// Denali-698:POI Name
	public static String tc698input = "KFC";
	public static String tc698expected = "KFC";

	// Denali-704:POI Name+in+city+state
	public static String tc704origin = "-33.907275, 18.412184";
	public static String tc704input = "BP in Cape Town Western Cape";
	public static String tc704expect = "BP"; // add
																					// lo// 6// miles
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
	public static String tc717origin = "-33.907275, 18.412184";
	public static String tc717input = "KFC in 7600";
	public static String tc717expect = "KFC"; // add logic < 6 miles
	public static int tc717resultNumber = 100;
	// Denali-719:Landmarks
	public static String tc719origin = "-33.907275, 18.412184";
	public static String tc719input = "Cape Town Stadium";
	public static String tc719expect = "Cape Town Stadium"; // add logic < 6
																// miles
	// Denali-720:Airport Name
	public static String tc720input = "San Francisco International Airport";
	public static String[] tc720expected = { "San Francisco Int'l Airport", "San Francisco International Airport",
			"San Francisco Int'l Airport (SFO)" }; // use exact
	// Denali-721:Alias name-Airport code
	public static String tc721origin = "-33.924758, 18.415690";
	public static String tc721input = "CPT";
	public static String tc721expect = "Cape Town International Airport"; // use
																																				// exact
	// Denali-728:Search super category
	public static String tc728input = "ATM";
	public static String[] tc728expected = { "Chase", "Wells Fargo", "Bank of America" };
	// Denali-731:Super Category+near+city
	public static String tc731input = "hotel near Milpitas";
	public static String[] tc731expected = { "Hilton Garden Inn", "Staybridge Suites", "Days Inn" };
	// Denali-733:Super Category+of+postcode
	public static String tc733input = "park of 94085";
	public static String[] tc733expected = { "Fair Oaks Park", "Columbia Park", "Lakewood Park" };
	// Denali-734:Sub category+NEAR+city+country
	public static String tc734origin = "-33.914359, 18.421129";
	public static String tc734input = "Chinese Food near Cape Town South Africa";
	public static String tc734expect = "Sea Palace";
	public static int tc734resultNumber = 100;
	// Denali-735:Sub category+in+state+country
	public static String tc735input = "Burgers in CA USA";
	public static String[] tc735expected = { "McDonald's", "In-N-Out Burger" };
	// Denali-737:GM dealership
	public static String tc737input = "GM dealership";
	public static String tc737expected = "GM";// need revisit with returned
												// format
	// Denali-748:State+Postcode
	public static String tc748origin = "-33.927552, 18.482407";
	public static String tc748input = "Western Cape 7600";
	public static String tc748expect = "Stellenbosch, WESTERN CAPE";
	// Denali-750: Postcode
	public static String tc750input = "94102";
	public static String[] tc750expected = { "San Francisco", "San Francisco, CA", "San Francisco, CALIFORNIA" };// Onboard/Offboard
	// Denali-751:City
	public static String tc751origin = "-33.920358, 18.420273";
	public static String tc751input = "Cape Town";
	public static String tc751expect = "Cape Town, WESTERN CAPE";
	// Denali-754:City+State+Country
	public static String tc754input = "San Francisco CA USA";
	public static String[] tc754expected = { "San Francisco, CA", "San Francisco" }; // Onboard/Offboard
	// Denali-756:City+State+Postcode
	public static String tc756input = "San Francisco CA 94102";
	public static String[] tc756expected = { "San Francisco, CA", "San Francisco, CALIFORNIA" };// Onboard/Offboard
	// Denali-762:Subcity
	public static String tc762input = "Etobicoke, Toronto, ON CAN M8Y";
	public static String tc762expected = "Etobicoke"; // Need revisit for the
														// expectation
	// Denali-770:Fuzzy search - Complete road type
	public static String tc770input = "De guigne Drive";
	public static String tc770expected = "De Guigne Dr";
	// Denali-771:Fuzzy search - Street with directional prefix
	public static String tc771input = "NW 9th St  Oswego, NY USA";
	public static String tc771expected = "NW 9th St";
	// Denali-775:Interval char - Comma
	public static String tc775input = "950,De guigne Dr,Sunnyvale,CA,94085";
	public static String tc775expected = "950 De Guigne Dr";
	// Denali-776:Street
	public static String tc776input = "De guigne Dr";
	public static String tc776expected = "De Guigne Dr";
	// Denali-777:Street+IN+City
	public static String tc777origin = "-33.914359, 18.421129";
	public static String tc777input = "Bree St in Cape Town";
	public static String tc777expect = "Bree St";
	// Denali-780:Street+City+State+Country
	public static String tc780input = "Panchita Way Los Altos CA USA";
	public static String tc780expected = "Panchita Way";
	// Denali-784:Street+City+Postcode
	public static String tc784input = "1st St San Francisco 94107";
	public static String tc784expected = "1st St";
	// Denali-787:Door Number+Street
	public static String tc787origin = "37.37890,-122.01074";
	public static String tc787input = "950 De guigne Dr";
	public static String tc787expect = "950 Deguigne Dr | 950 De Guigne Dr";
	// Denali-788:Door Number+Street+City
	public static String tc788input = "950 De guigne Dr Sunnyvale";
	public static String[] tc788expected = { "950 Deguigne Dr", "950 De Guigne Dr" }; // Onboard/Offboard
	// Denali-790:Door Number+Street+State+Postcode
	public static String tc790input = "1 1st St CA 94107";
	public static String tc790expected = "1 1st St";
	// Denali-807:Out of range door number
	public static String tc807input = "10000 Kifer Rd Sunnyvale CA";
	public static String tc807expected = "Kifer Rd"; // Need review the
														// expectation
	// Denali-809:Lat/lon search - Common
	public static String tc809origin = "-33.921272, 18.629636";
	public static String tc809input = "-34.047051, 18.671011";
	public static String tc809expect = "Khwezi Cres";
	// Denali-815:Str1+Str2+Of+Postcode
	public static String tc815input = "1st St and Howard St 94107";
	public static String tc815expected = "1st St at Howard St";
	// Denali-821:Str1+at+Str2
	public static String tc821input = "1st St at Howard St"; // Near SF.
	public static String tc821expected = "1st St at Howard St";
	// Denali-824:Str1+at+Str2+State+Postcode
	public static String tc824origin = "-33.918303, 18.418278";
	public static String tc824input = "Loop St at Riebeek St Western Cape 8000";
	public static String tc824expect = "Loop St at Riebeek St";
	// Denali-828:Str1+and+Str2+In+City+State
	public static String tc828input = "1st St at Howard St San Francisco CA";
	public static String tc828expected = "1st St at Howard St";
	// Denali-835:Str1+@+Str2+of+State+Country
	public static String tc835input = "1st St @ Howard St CA USA";
	public static String tc835expected = "1st St at Howard St";
	// Denali-836:Multiple Intersections
	public static String tc836input = "Mission Blvd at I-680 N CA";
	public static String tc836expected = "Mission Blvd at I-680 N";
	// Denali-838:Intersection_Roundabout With/Without Name
	public static String[] tc838input = { "Juan Bautista Cir and Font Blvd San Francisco",
			"Serrano Dr and Font Blvd San Francisco" };
	public static String[] tc838expected = { "Juan Bautista Cir at Font Blvd", "Serrano Dr at Font Blvd" };
	// Denali-841:Enter space
	public static String tc841origin = "-33.907275, 18.412184";
	// Denali-852:Search category
	public static String tc852origin = "-33.927552, 18.482407";
	public static String tc852input = Fuel;
	public static String tc852expect = "Shell&Caltex & BP";
	public static int tc852resultNumber = 50;
	// Denali-854:Search result detailed info
	public static String tc854origin = "-33.907275, 18.412184";
	public static String tc854input = Fuel;
	// Denali-920:Current vehicle position-unnamed
	public static String tc920origin = "37.385546, -122.014443";
	// Denali-921:Auto zoom timing - local road
	public static String tc921origin = "-33.923829, 18.416489";
	public static String tc921dest = "-33.920208, 18.425078";
	public static int tc921metric = 800;
	// Denali-922:Auto zoom for highway
	public static String tc922origin = "37.306172, -121.940497";
	public static String tc922dest = "37.317290, -121.934417";
	//Test case name: Denali-924:Restore Zoom scale - highway
	public static String tc924origin = "37.459633, -121.924222";
	public static String tc924dest = "46455 Warm Springs Blvd Fremont, CA 94539";

	//Denali-925:Dest Drive To Current Dest Sign
	public static String tc925origin = "37.373898, -122.056759";
	public static String tc925dest = "198 E El Camino Real, Sunnyvale CA 94087";

	// Denali-926:Arrival message-Destination
	public static String tc926dest = "289 Santa Ana Ct";
	// Denali-936:GJV(Generic Junction View)
	public static String tc936origin = "33.823170,-118.081366";
	public static String tc936dest = "33.831360,-118.075089";

	// Denali-937:SAR(Sign As Real)
	public static String tc937origin = "37.547360,-122.290353";
	public static String tc937dest = "37.555340,-122.287306";
	// Denali-938:GMS(Generic Motorway Signs)
	public static String tc938origin = "38.88038, -77.12461";
	public static String tc938dest = "38.881966, -77.118415";

	// Denali-939:Lane Guidance show timing - Highway
	public static String tc939origin = "37.493736, -121.949651";
	public static String tc939dest = "5399 Auto Mall Pkwy";
	// Denali-942:Correct number of lanes
	public static String tc942origin = "-33.915889, 18.428608";
	public static String tc942dest = "-33.911680, 18.418030";
	public static int tc942ln = 6;// (left turn)|(left
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
	public static String tc954origin = "37.352298, -122.005128,270";
	public static String tc954dest = "37.352104,-122.007821";
	// Denali-956:Lane guidance type Left and Right
	public static String tc956origin = "37.771556, -122.506504";// set
																	// vehicle
																	// direction
																	// to west
	public static String tc956dest = "37.767785, -122.510498";
	// Denali-957:Lane guidance type Continue and Left and Right//(left
	// turn)|(straight)|(straight)|(right )
	public static String tc957origin = "41.852771, -87.632372";// set vehicle
																	// direction
																	// to east
	public static String tc957dest = "41.848707, -87.626984";
	// Denali-964:Route Overview
	public static String tc964origin = "37.37890,-122.01074";
	public static String tc964dest = "SFO";
	//  Denali-965:Recenter around destination
	public static String tc965input = "NYC";
	
	// Denali-970:Demo long route
	public static String tc970origin = "37.37890,-122.01074";
	public static String tc970dest = "New York, NY";
	// Denali-973:Repeated search and map action while long route
	public static String tc973origin = "37.421358, -121.934800";
	public static String tc973dest = "Seattle, WA";
	// Denali-974:Map action in 3D map
	public static String tc974origin = "37.789060, -122.402077";
	//Denali-988:Zoom out after auto zoom
	public static String tc988origin = "37.380955, -122.010282";
	public static String tc988dest = "37.382746, -122.007241";
	// Denali-997:Vehicle icon menu - Home/Work are set up
	public static String tc997origin = "-33.928687, 18.427034";
	public static String tc997home = "4 Chesterfield St, Oranjezicht, Cape Town, 8001, South Africa";
	public static String tc997work = "3 Muswell Hill Rd, Mowbray, Cape Town, 7700, South Africa";

	// Denali-1016:Avoid pop up info
	public static String tc1016origin = "51.566968, -0.080390";
	public static String tc1016dest = "Durley Road";
	public static String tc1016avoid = "Dunsmure Road";

	// Denali-1017:Tight turn auto zoom
	public static String tc1017origin = "37.384050, -122.028454,45";
	public static String tc1017dest = "37.393814, -122.023270";
	// Denali-1018:Waypoint Skip To Next Sign
	public static String tc1018origin = "-33.923165, 18.418346";
	public static String tc1018dest = "CPT";
	public static String tc1018category = Coffee;
	public static String tc1018wp = "News Bar";
	// Test case name:Denali-1019:Show junction view on turn list
	public static String tc1019origin = "37.455914, -121.923137";
	public static String tc1019dest = "37.495843, -121.948217";
	// Denali-1020:Show turn list on junction view
	public static String tc1020origin = "37.434628, -121.918859";

	//Denali-1025:Add waypoint options-cancel
	public static String tc1025origin = "37.37890,-122.01074";
	public static String tc1025dest = "KFC";

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
	public static String tc1028wp = "Shell";

	//Denali-1024:Waypoint pop up
	public static String tc1024origin = "37.37890,-122.01074";
	public static String tc1024dest = "KFC";

	//Denali-1119:Delete dest
	public static String tc1119origin = "37.37890,-122.01074";
	public static String tc1119dest = "KFC";
	public static String tc1119wp = "Chevron";

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
	public static String tc1053Exit = "Exit 5";
	public static String tc1054expectExit = "G10";
	public static String[] tc1054ExpectedExitPOIType = { "Gas", "ATM" };


	// Denali-1054:Seach exit POI
	public static String tc1054origin = "37.437124, -121.919300";
	public static String tc1054dest = "37.460070, -121.924482";
	// Denali-1060:Waypoint edit view
	public static String tc1060origin = "-33.923165, 18.418346";
	public static String tc1060dest = "CPT";
	public static String tc1060wp = "News Bar";
	// Denali-1108:Set POI category to favorite
	public static String tc1108origin = "-33.920358, 18.420273";
	public static String tc1108expect = "Gourmet Burger-Cape Town";

	// Denali-1072:Search along route - Category search
	public static String tc1072origin = "-33.920358, 18.420273";
	public static String tc1072dest = "CPT";
	public static String tc1072input = Fuel;
	public static String tc1072expect = "Shell";
	// Denali-1087:FreeMap
	public static String tc1087origin = "37.789060, -122.402077";

	// Denali-1095:Sub panel display priority
	public static String tc1095origin = "37.788390, -122.407762";
	public static String tc1095dest = "37.787322, -122.400292";
	public static String tc1095originTight = "37.380957, -122.012438";
	public static String tc1095destTight = "37.382072, -122.016816 ";

	//	//Denali-1117:Next maneuver card - waypoint/dest address info
	public static String  tc1117origin = "37.380918, -122.009465";
	public static String tc1117dest = "1135 E Arques Ave";

	//Denali-1118:Action - avoid waypoint
	public static String tc1118origin = "37.37890,-122.01074";
	public static String tc1118dest = "KFC";
	public static String tc1118wp = "76";

	// Denali-1161:Show POI icons on map
	public static String tc1161origin = "-33.922682, 18.418767";
	// Denali-1162:Hide all POI icons on map
	public static String tc1162origin = originFromLocation;

	//Denali-1167:Simple Arrival View-Destination
	public static String tc1167origin = "37.378279, -121.995848";
	public static String tc1167dest = "550 Lawrence Expy Sunnyvale CA";

	// Denali-1168:Simple Arrival View-Waypoint
	public static String tc1168origin = "37.382515, -121.995675";
	public static String tc1168dest = "KFC";
	public static String tc1168category = "Fast Food";
	public static String tc1168wp = "McDonald's";

	// Denali-1170:Next maneuver card - waypoint/dest POI info
	public static String tc1170origin = "37.382515, -121.995675";
	public static String tc1170dest = "1252 Oakmead Pkwy";
	public static String tc1170expectDest = "1252 Oakmead Pkwy";
	public static String tc1170category = "Fast Food";
	public static String tc1170wp = "McDonald's";
	public static String tc1170expectWp = "McDonald's";
	public static String tc1170expectTurn = "LocationRight";
    
	// Denali-1191:Add from one box search
	public static String tc1191origin = "-33.918946, 18.421793";
	public static String tc1191dest = "Loop Street Mini Shop";
	public static String tc1191recent = "Loop Street Mini Shop";
	public static String tc1191wp = "house of coffees";

	// Denali-1193:Entries sort by Date and Time
	public static String tc1193dest1 = "New York, NY";
	public static String tc1193dest2 = "San Francisco Int'l Airport";
	public static String tc1193dest3 = "Shell";
	// Denali-1197:Hide selected POI icons on map
	public static String tc1197origin = originFromLocation;

	// Denali-1209:Dest arrival in turn list screen
	public static String tc1209rigin = "37.385272, -122.017254,225";
	public static String tc1209dest = "Chevron";

	// Denali-1226:Show Junction View over Exit POI
	public static String tc1226origin = "37.419288, -121.947573";
	public static String tc1226Dest = "37.546648, -121.984885";
	// Denali-1227:Keep Search page over Junction View
	public static String tc1227origin = "37.530984, -122.275138";
	public static String tc1227dest = "37.555340,-122.287306";
	// Denali-1235:Change default zoom level NavigationMap
	public static String tc1235origin = "-33.950073, 18.492048";
	public static String tc1235dest = "CPT";
	//	Denali-1448:Play of Railroad Crossing = OFF
	public static String tc1448origin = "37.376397, -122.029114";
	public static String tc1448dest = "37.379253, -122.027952";
	// Denali-1248:Street name
	public static String tc1248origin = "37.37890,-122.01074";
	public static String[] tc1248input = {"989 Reed Ave","Reed Ave"};
	// Denali-1269:Next maneuver card - turn icon
	public static String tc1269origin = "37.365370, -122.049972";
	public static String tc1269dest = "809 Piper Ave";
	public static String[][] tc1269expect = {{"Hanover Ave","TurnRight"},{"Elmira Dr","TurnLeft"},{"Piper Ave","TurnRight"},{"809 Piper Ave, Sunnyvale, CA 94087, USA","LocationLeft"}};
	
	// Denali-1483:Alert of Railroad Crossing = ON - Approach
	public static String tc1483origin = "37.382639, -122.026837,180";
	public static String tc1483dest = "37.376397, -122.029114";
	//	Denali-1501:Alert of Railroad Crossing= ON
	public static String tc1501origin = "37.379690, -122.027810,180";
	public static String tc1501dest = "37.371809, -122.030718";
	// Denali-1487:Turn right after landmark
	public static String tc1487origin = "37.380701, -122.004244,270";
	public static String tc1487dest = "37.383470,-122.013452";
	// Denali-1496:repeat oneBoxEditText search
	public static String tc1496origin = "37.37890,-122.01074";
	// Denali-1497:map action while route in a big city
	public static String tc1497origin = "42.329645, -83.039008";
	public static String tc1497dest = "5144 Chase Rd, Dearborn, MI 48126";

	// Denali-1719:long route at background
	public static String tc1719origin = "37.37890,-122.01074";
	public static String tc1719dest = "Seattle, WA";

}
