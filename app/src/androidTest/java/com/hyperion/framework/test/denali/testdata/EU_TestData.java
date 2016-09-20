package com.hyperion.framework.test.denali.testdata;


public class EU_TestData extends TestData {

    public static String originFromLocation = "46.773293, 23.592481";


    ////Test Cases Data///////////////////////
    // Denali-2:Highway shields display condition
    public static String tc2origin = "52.328339, 4.913284";
    //	//Denali-11 : walkway
//	public static String tc11origin = "37.391808, -121.981580";
//	//	Denali-16:One way street direction
//	public static String tc16origin = "37.777092, -122.415935";
    //Denali-19 : State name display
    public static String tc19origin = "37.097612, -102.113829";
    //	//Denali-21:City name: Dortdmund
    public static String tc21origin = "51.513461, 7.465334";
    //	//Denali-22 : Street Name : Paris
    public static String tc22origin = "48.869608, 2.308245";
    //	//	Denali-23:State & country boundary
//	public static String tc23origin = "32.718764, -114.719634";
//	//Denali-28:Seas, lakes & rivers
//	public static String tc28origin="44.955618, -82.504296";
//	//Denali-30:Facility name
//	public static String tc30originAirport = "37.621614, -122.378580";
//	public static String tc30originPark = "37.552909, -121.964007";
//	public static String tc30originGolf = "37.423643, -122.041572";	
//	//Denali-43:Traffic flow
    public static String tc43origin = "48.859524, 2.345109";

    //	//	Denali-47:Next Turn info
    //public static String tc47origin = "51.526901, -0.082812";
    //public static String tc47dest = "71 Buttesland St";
    //public static String[][] tc47ExpectedTurn = {{"Coronet Street","TurnRight"},{"Chart Street","TurnLeft"},{"71 Buttesland Street, London, N1 6, United Kingdom","LocationAhead"}};

    public static String tc47origin = "46.7571572,23.5928598";
    public static String tc47dest = "20 Strada Bisericii Ortodoxe";
    public static String[][] tc47ExpectedTurn = {{"Strada Republicii", "TurnLeft"}, {"Strada Ion Mincu", "TurnRight"}, {"20 Strada Bisericii Ortodoxe", "LocationLeft"}};

//	public static String[][] tc47ExpectedTurn ={{"Hanover Ave","TurnSlightRight"},{"Elmira Dr","TurnLeft"},{"Piper Ave","TurnRight"},{"831 Piper Ave","LocationLeft"}};
//	//Denali-48:Active route color
//	public static String  tc48origin = "37.382515, -121.995675";
//	public static String  tc48dest = "950 De guigne Dr";
//	public static String  tc48category = "Fast Food";
//	public static String  tc48wp = "McDonald's";
//	//Denali-66:Scroll map around 3D Landmark: Paris, Tour Eiffel

    // Denali-50:Traffic indicator update
    public static String tc50origin = "46.771729, 23.597004";
    public static String tc50dest = "46.774849, 23.591642";

    //Denali-52:Exit Amenities list show timing - Highway
    public static String tc52origin = "48.777963, 2.214133";
    public static String tc52dest = "48.775886, 2.237064";
    // Denali-66:Scroll map around 3D Landmark
    public static String tc66origin = "";
    //	//	Denali-86:Scroll map on junction view
//	public static String tc86origin = "37.389497,-121.989645";
//	//	Denali-102:Zoom in/out in ocean
//	public static String tc102origin = "37.398064, -122.696472";
    public static String tc105searchTxt = "airport";
    //	Denali-136:Junction view display
    public static String tc136origin = "51.401817, 0.207933";
    public static String tc136dest = "51.384373, 0.214008";
    //	// Denali-138:Junction view color
// Denali-138:Junction view color
    public static String tc138origin = "48.146034, 0.678202";
    public static String tc138dest = "48.145852, 0.687767";
    //	//Denali-147:Exit POI info update
    public static String tc147origin = "48.777963, 2.214133";
    public static String tc147Dest = "48.775886, 2.237064";
    public static String tc147exit = "Exit A86";
    //	//Denali-150:GRC - highway
//	public static String tc150origin = "37.425967, -121.916715";
//	//Denali-154:RGC - Unnamed road
//	public static String tc154origin = "37.384033, -122.014599";
    // Denali-230:Add by Map
    public static String tc230origin = "51.537022, -0.139458";
    //  Denali-232:Night color
    public static String tc232origin = "51.537022, -0.139458";
    //  Denali-231:Day color
    public static String tc231origin = "51.537022, -0.139458";
    //  Denali-235:Set Home Address
    public static String tc235input = "291 Grimesthorpe Road";
    public static String tc235origin = "53.402525, -1.458288";
    //  Denali-236:Set Home Address
    public static String tc236input = "Calea Turzii Cluj-Napoca";
    public static String tc236expected = "Calea Turzii";

    //	//Denali-211:Generic 2.5D landmarks
//	public static String tc211origin = "37.789060, -122.402077";
    public static String tc211origin = "46.770785, 23.597094";
    //	//Denali-260:JV show timing-Hwy -> Ramp -> Ramp -> Hwy
    public static String tc260origin = "48.142994, 11.743928";
    public static String tc260dest = "48.135598, 11.758824";
    //	//Denali-261:JV show timing-Hwy -> Ramp -> Ramp -> Local
    public static String tc261origin = "48.142994, 11.743928";
    public static String tc261dest = "48.135598, 11.758824";
    //	//Denali-262:JV show timing-Local -> Ramp -> Ramp -> Hwy
    public static String tc262origin = "48.142505, 11.755015";
    public static String tc262dest = "48.135598, 11.758824";
    //	//Denali-263:JV show timing-Local -> Ramp -> Ramp -> Local
    public static String tc263origin = "48.142505, 11.755015";
    public static String tc263dest = "48.135598, 11.758824";
    //	//Denali-264:JV show timing- Ramp -> Ramp -> Hwy
    public static String tc264origin = "48.142505, 11.755015";
    public static String tc264dest = "48.135598, 11.758824";
    // Denali-265:JV show timing- Hwy -> Hwy
    public static String tc265origin = "48.142994, 11.743928";
    public static String tc265dest = "48.135598, 11.758824";
    //	//Denali-266:JV show timing- Hwy -> Local
    public static String tc266origin = "48.142994, 11.743928";
    public static String tc266dest = "48.135598, 11.758824";
    //	// Denali-267: Static ETE - Destination
    public static String tc267origin = "46.745763, 23.582905";
    public static String tc267dest = "Cluj airport";
    public static String tc267exp = "Airport";
    public static int tc267Lower = 18;
    public static int tc267expUpper = 34;
    //	//Denali-286:Fastest route
    public static String tc286origin = "51.507350, -0.127759";
    public static String tc286input = "LGW";
    public static String tc286expect = "London Gatwick Airport";
    // Denali-293:Route type inherit - Route option
    public static String tc293origin = "46.770980, 23.559544";
    public static String tc293dest = "Cluj airport";
    public static String tc293exp = "Cluj International Airport";
    // Denali-294:Route type inherit - Add waypoint
    public static String tc294origin = "46.777263, 23.599901";
    public static String tc294dest = "Cluj airport";
    public static String tc294exp = "Cluj International Airport";
    public static String tc294Wp = Fuel;
    // Denali-295:Route type inherit - Remove waypoint
    public static String tc295origin = "46.777263, 23.599901";
    public static String tc295dest = "46.783177, 23.600239";
    public static String tc295exp = "LUKOIL";
    //	//Denali-296:Route overview
    public static String tc296origin = "51.507350, -0.127759";
    public static String tc296dest = "51.507794, -0.148050";
    //	// Denali-297:Across country
    public static String tc297origin = "40.762144, 30.391777";
    public static String tc297dest = "41.440009, 22.644683";
    // Denali-298:Across state
    public static String tc298origin = "47.3009804,5.0430528";
    public static String tc298SearchText = "Cluj-napoca";
    // Denali-299:Across state
    public static String tc299origin = "44.4378258,26.0946376";
    public static String tc299SearchText = "Cluj-napoca";
    //	//Denali-300:In one city
    public static String tc300origin = "51.507350, -0.127759";
    public static String tc300dest = "London";
    // Denali-301:One way street - Pass
    public static String tc301origin = "51.537022, -0.139458";
    public static String tc301SearchText = "51.537173, -0.139646";
    public static String[] tc301ExpectedRoute = {"Plender Street", "Mandela Street", "Pratt Street", "Bayham Street"};
    // Denali-302:Roundabouts - From
    public static String tc302Origin = "52.518407, 13.452668";
    public static String tc302Destination = "52.514441, 13.453209";
    public static String tc302Destination2 = "52.524625, 13.449180";
    // Denali-303:Roundabouts - To
    public static String tc303Origin = "46.776691, 23.614029";
    public static String tc303SearchText = "46.778343, 23.614656";
    //	//Denali-304:Roundabouts - Pass
    public static String tc304origin = "50.849428, -1.123999";
    public static String tc304dest = "50.844301, -1.122425";
    public static String[][] tc304NextStInfo = {{"Castle Street Roundabout", "EnterAhead"}, {"Castle Street", "ExitLeft"}};
    // Denali-305:Tunel - From
    public static String tc305Origin = "47.459821, 8.298197";
    public static String tc305SearchText = "5413 Birmenstorf, Switzerland";
    // Denali-306:Tunel - To
    public static String tc306Origin = "47.465063, 8.250430";
    public static String tc306SearchText = "Baregg Tunnel";
    public static String tc306ExpectedSearchResult = "Bareggtunnel";
    // Denali-308:Ferry - From
    public static String tc308Origin = "45.288464, 27.994950";
    public static String tc308SearchText = "Strada Nicopole 21, Braila, RO";
    // Denali-309:Ferry - To
    public static String tc309Origin = "45.290034, 27.978421";
    public static String tc309SearchText = "45.285455, 27.997674";
    public static String tc309ExpectedText = "DN22";
    // Denali-311:Airport - From
    public static String tc311Origin = "46.782057, 23.687039";
    public static String tc311SearchText = "Rodnei 9, Cluj-napoca, RO";
    // Denali-312:Airport - To
    public static String tc312Origin = "46.786154, 23.657165";
    public static String tc312SearchText = "Cluj airport";
    public static String tc312ExpectedSearchResult = "Cluj international airport";
    // Denali-316:Park - To
    public static String tc316Origin = "51.519970, -0.144873";
    public static String tc316SearchText = "Hyde Park";
    public static String tc316ExpectedSearchResult = "Hyde Park";
    //	//Denali-318:Closed Rd - To
    public static String tc318origin = "51.507350, -0.127759";
    public static String tc318dest = "51.503525, -0.143866";
    // Denali-325:Long route > 2000 mi
    public static String tc325Origin = "38.747011, -9.154400";//lisbon
    public static String tc325SearchText = "50.4333, 30.5167";//kiev
    public static int tc325Distance = 2580;
    // Denali-336:To vehicle position - On road
    public static String tc336Origin = "46.786154, 23.657165";
    public static String tc336dest = "46.786154, 23.657165";
    //	//	Denali-341:Avoid fail - Preferences setting
//	public static String tc341origin = "37.390049, -122.030354";
//	public static String tc341SearchText ="37.397810, -122.022943";
//	//Denali-345:Time Restricted Turn - On restricted time
//	public static String tc345Origin ="42.378251,-83.014251";
//	public static String tc345SearchText ="42.378056,-83.015165";
    // Denali-357:Legal routing - Left turn restricted
    public static String tc357Origin = "46.770980, 23.559544";
    public static String tc357SearchText = "46.771706, 23.560327";
    //  Denali-358:Add by Address
    public static String tc358origin = "46.7708581,23.5522411";
    public static String tc358dest = "Strada Donath 29, Cluj-Napoca 400000";
    // Denali-359:Add by POI
    public static String tc359Origin = "46.777263, 23.599901";
    public static String tc359Destination = "Rompetrol";
    public static String tc359Waypoint = "Napoca Oil";
    // Denali-361:Add by recents places
    public static String tc361Origin = "46.783177, 23.600239";
    public static String tc361SearchText = "KFC";
    //Denali-362:Start Route
    public static String tc362origin = "51.507350, -0.127759";
    public static String tc362dest = Fuel;
    //	//Denali-367:Current street name in Guidance
    //public static String tc367origin = "51.526901, -0.082812";
    //public static String tc367dest = "71 Buttesland St";
    //public static String[] tc367ExpectedSt = {"Coronet Street","Boot Street","Pitfield Street","Chart Street","71 Buttesland Street, London, N1 6, United Kingdom"};

    public static String tc367origin = "46.7571572,23.5928598";
    public static String tc367dest = "20 Strada Bisericii Ortodoxe";
    public static String[] tc367ExpectedSt = {"Strada Republicii", "Strada Ion Mincu", "20 Strada Bisericii Ortodoxe"};

    //	//Denali-368:Next maneuver card - next street name
    public static String tc368origin = "51.526901, -0.082812";
    public static String tc368dest = "71 Buttesland St";
    public static String[] tc368ExpectedNextSt = {"Coronet Street", "Boot Street", "Pitfield Street", "Chart Street", "71 Buttesland Street"};
    //	//	Denali-370:Dest arrival-on route
    public static String tc370origin = "51.516240, -0.149530";
    public static String tc370dest = "51.517548, -0.142106";
    //	//	Denali-372:Add waypoint when arrive dest
//	public static String tc372origin =OfficeLatLon;
//	public static String tc372dest = "289 Santa Ana Ct";	
//	//Denali-374:The flag display when dest arrival
//	public static String tc374dest = "289 Santa Ana Ct";	
//	//Denali-375:Cancel route
    public static String tc375origin = "51.507350, -0.127759";
    public static String tc375dest = Fuel;

    //Denali-372:Add waypoint when arrive dest
    public static String tc372origin = "48.140026, 11.518507";
    public static String tc372dest = "Hackerbrucke 4";
    public static String tc372wpType = Fuel;

    //Denali-379:MAX waypoints
    public static String tc379origin = "48.140026, 11.518507";
    public static String tc379dest = "KFC";
    public static String tc379wp = "Am Knie 19";
    public static String tc379wp1Type = Fuel;
    public static String tc379wp1 = "Esso";
    public static String tc379wp2 = "Shell";

    //Denali-380:Add waypoint before arrive waypoint/dest
    public static String tc380origin = "48.140026, 11.518507";
    public static String tc380dest = "KFC";
    public static String tc380wp = "Shell";
    public static String tc380wp1 = "Esso";

    //Denali-381:Delete Waypoint
    public static String tc381origin = "48.140026, 11.518507";
    public static String tc381dest = "KFC";
    public static String tc381wp = "Shell";
    public static String tc381wp1 = "Esso";

    //Denali-382:Delete all waypoints continuouslyt
    public static String tc382origin = "48.140026, 11.518507";
    public static String tc382dest = "KFC";
    public static String tc382wp = "Shell";
    public static String tc382wp1Type = Coffee;
    public static String tc382wp1 = "Segafredo";
    public static String tc382wp2 = "Esso";

    //Denali-383:Reorder Waypoints
    public static String tc383origin = "48.140026, 11.518507";
    public static String tc383dest = "KFC";
    public static String tc383nwp = "Shell";
    public static String tc383wp1Type = Coffee;
    public static String tc383wp1 = "Segafredo";
    public static String tc383wp2 = "Esso";

    //Denali-390:Add waypoint after arrive waypoint
    public static String tc390origin = "48.140026, 11.518507";
    public static String tc390dest = "KFC";
    public static String tc390wp = "Shell";
    public static String tc390wp1 = "Esso";

    // Denali-384:Cancel route when arrive waypoint
    public static String tc384Origin = "46.777263, 23.599901";
    public static String tc384Destination = "KFC";
    public static String tc384Waypoint = "LUKOIL";
    //Denali-388:Waypoint arrival-on route
    public static String tc388origin = "51.509994, -0.122403";
    public static String tc388dest = "6 Clipstone St Fitzrovia, London W1W 6BB";
    public static String tc388category = Coffee;
    public static String tc388wp = "Starbucks";
    //	//Denali-390:Add waypoint after arrive waypoint
//	public static String tc390Origin ="37.383120, -122.018021";

    // Denali-399:Maneuver arrow
    public static String tc399origin = "46.774935, 23.621395";
    public static String tc399dest = "46.775589, 23.623542";
    public static String[][] tc399expect = {{"Strada Sarmisegetuza", "TurnRight"}};

    // Denali-396:Legal routing - Right turn restricted
    public static String tc396Origin = "46.766244, 23.606809";
    public static String tc396Dest = "46.767798, 23.608766";
    public static String tc396NextStreet = "Strada Mihai Veliciu";

    //	//Denali-404:Sub panel - tight turn
    public static String tc404origin = "48.866551, 2.317752";
    public static String tc404dest = "48.864969, 2.318291";
    public static String tc404expTurnType1 = "TurnRight";
    public static String tc404expStreet1 = "Cours La Reine";
    public static String tc404expTurnType2 = "TurnRight";
    public static String tc404expStreet2 = "Cours La Reine";

    // Denali-405:ETA-Wpt and Dest in same Timezone
    public static String tc405origin = "48.140026, 11.518507";
    public static String tc405dest = "Dietleibstrasse 3";
    public static String tc405category = Fuel;
    public static String tc405wp = "Shell";


    //Denali-406:WTA-Wpt and Dest in different Timezone
    public static String tc406origin = "44.428991, 26.104171";
    public static String tc406dest = "45.996585, 26.151800";
    public static int tc406destzonediff = 1;
    public static String tc406wp = "Albuquerque";
    public static String tc406wpexpect = "Albuquerque, NM";
    public static int tc406wpzonediff = 1;

    //	//Denali-410:ETA to Destination
    public static String tc410origin = "48.140026, 11.518507";
    public static String tc410dest = "Hackerbrucke 4";

    //Denali-411:ETA with one Waypoint
    public static String tc411origin = "48.140026, 11.518507";
    public static String tc411dest = "KFC";
    public static String tc411category = Fuel;
    public static String tc411wp = "Esso";

    // Denali-412:ETA with Dest Change
    public static String tc412origin = "48.140026, 11.518507";
    public static String tc412dest = "KFC";
    public static String tc412category = Fuel;
    public static String tc412newDest = "Esso";

    //Denali-418:ETE to Destination
    public static int tc418ete = 66;
    public static String tc418origin = "51.516240, -0.149530";
    public static String tc418dest = "LGW";
    public static String tc418expect = "London Gatwick Airport";

    //	Denali-419:ETE with one Waypoint
    public static String tc419origin = "48.132612, 11.52033";
    public static String tc419dest = "48.275687, 11.748527";
    public static String tc419category = Fuel;
    public static String tc419wp = "Esso";
    public static String tc419unit = "m";

    // Denali-420:ETE with Dest Change
    public static String tc420origin = "48.132612, 11.52033";
    public static String tc420dest = "48.275687, 11.748527";
    public static String tc420category = Fuel;
    public static String tc420wp = "Esso";
    public static String tc420unit = "m";

    // Denali-421:ETE with Waypoint Change
    public static String tc421origin = "48.132612, 11.52033";
    public static String tc421dest = "48.275687, 11.748527";
    public static String tc421category1 = Fuel;
    public static String tc421wp1 = "Shell";
    public static String tc421category2 = Fuel;
    public static String tc421wp2 = "JET";

    //	//Denali-412:ETA with Dest Change
//	public static String  tc412origin = "37.382515, -121.995675";
//	public static String  tc412dest = "SFO";
//	public static String  tc412category = "Fast Food";
//	public static String  tc412newDest = "McDonald's";
//	//Denali-418:ETE to Destination
//	public static String  tc418origin = "37.37890,-122.01074";
//	public static String  tc418dest = "SFO";
//	//Denali-420:ETE with Dest Change
//	public static String  tc420origin = "37.382515, -121.995675";
//	public static String  tc420dest = "SFO";
//	public static String  tc420category = "Fast Food";
//	public static String  tc420newDest = "McDonald's";
//	//Denali-421:ETE with Waypoint Change
//	public static String  tc421origin = "37.382515, -121.995675";
//	public static String  tc421dest = "San Francisico";
//	public static String  tc421category1 = "Fast Food";
//	public static String  tc421wp1 = "McDonald's";
//	public static String  tc421category2 = "Gas";
//	public static String  tc421wp2 = "76";
    // Denali-456:Change route type - fastest
    public static String tc456origin = "46.745763, 23.582905";
    public static String tc456destination = "Cluj Airport";
    public static String tc456search = "Airport";
    //	//Denali-459:Sub panel - lane guidance
    public static String tc459origin = "46.766366, 23.590265";
    public static String tc459dest = "46.769676, 23.590606";
    //	//Denali-491:Left turn on Local Street
    public static String tc491origin = "48.8495956,2.6786669";//set vehicle direction to east
    public static String tc491Dest = "48.8565434,2.6859374";
    public static String tc491expect[] = {"guidance will start now", "^in (.*) turn left.", "^in (.*) turn left to (.*)", "^turn left to (.*)"};
    //	Denali-493: Turn sharp left on Local Street
    public static String tc493origin = "46.775353, 23.621889";
    public static String tc493Dest = "46.776935, 23.623592";
    public static String tc493expected[] = {"guidance will start now", "^in (.*) turn sharp left to (.*)", "^turn sharp left to (.*)"};
    //  Denali-496:Make a U-turn
    public static String tc496origin = "48.165199, 11.553065";
    public static String tc496dest = "48.163706, 11.552900";
    public static String tc496expect[] = {"guidance will start now", "^in (.*) make a u-turn if possible", "^in (.*) make a u-turn if possible at (.*)", "^make a u-turn if possible at (.*)"};//5/22 R11.1 RC5
    //	Denali-497:Enter large roundabout
    public static String tc497origin = "48.875307, 2.290010";
    public static String tc497dest = "48.874149, 2.298850";
    public static String tc497expect[] = {"guidance will start now", "^in (.*) enter the roundabout and take the eighth exit", "^in (.*) take the eighth exit to (.*)", "^Take the eighth exit"};
    //Denali-470:Delete favorite from favorite list
    public static String tc470origin = "";
    public static String tc470input = "";

    //	Denali-472 Start Route Guidance - on road/ between 15mi and info range
    public static String tc472origin = "53.496807458, -2.212488335";
    public static String tc472dest = "53.515794, -2.148539";
    public static String[] tc472expected = {"guidance will start now", "proceed (.*)"};
    //	//Denali-473:Start Route Guidance - between info range and 1st guidance
    public static String tc473origin = "48.231600, 11.634679";
    public static String tc473dest = "48.302081, 11.634710";
    public static String tc473expect[] = {"guidance will start now", "proceed (.*)"};
    //	//	Denali-477:Start Route Guidance - between 2nd and 3rd guidance
    public static String tc477origin = "48.204487, 16.374206";
    public static String tc477Dest = "48.204473, 16.375705";
    public static String tc477expect[] = {"guidance will start now", "turn right to (.*) and then your destination will be on your right"};
    //	 Denali-488:Slight Right Turn on Local Street
    public static String tc488origin = "47.436828, 9.768245";
    public static String tc488Dest = "47.436597, 9.775946";
    public static String tc488expect[] = {"guidance will start now", "^(I|i)n (.*) turn slight right(.)?", "(I|i)n (.*) turn slight right to (.*)", "turn slight right to (.*)"};
    //	Test case name: Denali-489:Keep right on Local Street
    public static String tc489origin = "47.508904, 19.017727";
    public static String tc489dest = "47.502987, 19.023987";
    public static String tc489expect[] = {"guidance will start now", "^in (.*) keep right", "^in (.*) keep right to (.*)", "^keep right to (.*)"};
    //	Denali-500:Enter Ferry
    public static String tc500origin = "45.289910, 27.990934";
    public static String tc500dest = "45.286526, 27.999236";
    public static String tc500expect[] = {"guidance will start now", "^in (.*) prepare to enter the ferry terminal", "^you have reached the ferry terminal"};
    //  Denali-501:Exit ferry
    public static String tc501origin = "57.702739, 11.927172";
    public static String tc501dest = "57.703137, 11.927498";
    public static String tc501expect[] = {"guidance will start now", "continue on the current road and then your destination will be on your right"};
    //Denali-505:Highway Entrance - slight right
    public static String tc505origin = "46.403687,3.049165";
    public static String tc505Dest = "46.391866,3.033945";
    public static String tc505expect[] = {"guidance will start now", "^in (.*) turn slight right to (.*)", "^in (.*) turn slight right to (.*) towards (.*)", "^turn slight right to (.*)"};
    //	Denali-506:Highway Entrance - turn left
    public static String tc506origin = "54.332576,-2.626132";
    public static String tc506Dest = "54.334775,-2.619383";
    public static String tc506expected[] = {"guidance will start now", "^in (.*) turn left to (.*) towards (.*)", "^in (.*) turn left to (.*) towards (.*)", "^turn left to (.*)"};
    //  Denali-515:Highway-to-road Exit - take exit on the right
//	public static String tc515origin = "52.499396, 4.700735";
    public static String tc515origin = "48.873319, 2.480015";
    public static String tc515Dest = "48.877372, 2.475942";
    public static String tc515expect[] = {"guidance will start now", "^in (.*) take exit on the right to (.*) towards (.*)", "^in (.*) exit on the right to (.*) towards (.*)", "^exit right to (.*)"};//5/22/2015 R11.1 RC5
    //	Denali-522:Highway transition - take exit on the right
    public static String tc522origin = "52.403800, 4.949869";
    public static String tc522Dest = "52.403681, 4.934120";
    public static String tc522expect[] = {"guidance will start now", "^in (.*) take exit (.*) on the right to (.*) towards (.*)", "^in (.*) take exit (.*) on the right to (.*) towards (.*)", "^exit right to (.*)"};
    //	Denali-528:Highway to same highway-keep left
    public static String tc528origin = "47.768692, 12.957212";
    public static String tc528Dest = "47.787197, 12.981733";
    public static String tc528expect[] = {"guidance will start now", "^in (.*) keep left to (.*) towards (.*)", "^in (.*) keep left to (.*) towards (.*)", "^keep left to (.*)"};
    // Denali-540:Continuous Guidance - dest arrival
    public static String tc540rigin = "52.528794, 13.335867";
    public static String tc540dest = "52.530311, 13.336950";
    public static String tc540expect[] = {"guidance will start now", "^in (.*) turn left.", "^in (.*) turn left to (.*) and then you will arrive at your destination"};//6/25/2015 R11.3 RC2
    //	Denali-552:Dest arrival-on the left
    public static String tc552origin = "53.510345, -2.158975";
    public static String tc552dest = "53.512800, -2.154330";
    public static String tc552expect[] = {"Guidance will start now", "In (.*) your destination is on your left", "in (.*) your destination is on your left", "[Y|y]ou have reached your destination on your left"};
    //  Denali-555:Continuous Guidance - waypoint arrival
//	public static String tc555origin = "48.206405, 16.336698";
    public static String tc555origin = "48.205995, 16.340647";
    public static String tc555Dest = "48.207939, 16.325147";
    public static String tc555wp = "Roki";
    public static String tc555category = Coffee;
    public static String tc555expect[] = {"^in (.*) your waypoint is on your right", "^in (.*) your waypoint is on your right", "you have reached your waypoint on your right"};
    // Denali-558:Search History list-one box search
    public static String tc558input = "Handelskai 32 Vienna";
    // Denali-561:Select from Search History List
    public static String tc561input = "coffee near by Cluj-Napoca 400000";
//	//Denali-583:RGC - CAN
//	public static String tc583origin = "43.676396, -79.401367";
//	//Denali-584:RGC - MEX
//	public static String tc584origin = "25.688738, -100.317290";
    // Denali-587:Turn icon - Roundabout

    public static String tc587origin = "51.525010, -0.075264";
    public static String[] tc587dest = {"51.525686, -0.075830", "51.526150, -0.075801", "51.526824, -0.075021", "51.526269, -0.074136",
            "51.525972, -0.074252"};
    //	//Denali-588:Turn icon - U-turn
    public static String tc588origin = "48.165199, 11.553065";
    public static String tc588dest = "48.163706, 11.552900";
    public static String tc588expect = "LeftUTurn";
    //	//Denali-590:Valid Postcode+unrelated country
//	public static String tc590input = "12345 USA";
//	//Denali-591:next maneuver card - distance update
//	public static String tc591dest = "831 Piper Ave";
//	//Denali-592:Destination icon direction
    public static String tc592origin = "46.771375, 23.553324";
    public static String tc592destLeft = "Gollierplatz 1";
    public static String tc592destRight = "Gollierstrasse 56";
    public static String tc592destAhead = "46.772078, 23.556626";
    public static String tc592expectAhead = "LocationAhead";
    public static String tc592expectLeft = "LocationLeft";
    public static String tc592expectRight = "LocationRight";
    //	//Denali-607:POI category
    public static String tc607input = "KFC";

    //	//Denali-613:Avoid Freeway = OFF
    public static String tc613origin = "50.026485, 8.220302";
    public static String tc613input = "Mombacher Str. 91, 55122 Mainz, Germania";
    public static String tc613expected = "Mombacher Straße 91";
    public static String tc613road = "K17";

    //Denali-614:Avoid Freeway/Motorway = ON
    public static String tc614origin = "51.291595, 0.476446";
    public static String tc614dest = "51.305286, 0.514138";
    public static String tc614expected = "M20";

    //Denali-615:Avoid Toll Road = OFF
    public static String tc615origin = "zzz";
    public static String tc615input = "zzz";
    public static String tc615expected = "zzz";

    //Denali-616:Avoid Toll Road = ON
    public static String tc616origin = "45.017405, 11.701693";
    public static String tc616input = "45.117269, 11.772348";
    public static String tc616expected = "Rovigo";

    //Denali-618 :: Avoid Ferry = OFF
    public static String tc618origin = "57.590303, 9.974248";
    public static String tc618dest = "59.047486, 10.058220";
    public static String tc618ferry = "Hirtshals-Larvik";

    //	public static String tc614expected="822 N Fair Oaks Ave";
    //Denali-635:Show timing-get route successfully
    public static String tc635origin = "51.507350, -0.127759";
    public static String tc635dest = "LGW";

    // Denali-640:Route list info
    public static String tc640origin = "51.566968, -0.080390";
    public static String tc640dest = "Durley Road";
    public static String tc640st1 = "Fairholt Road";
    public static String tc640st2 = "Cranwich Road";
    public static String tc640st3 = "Durley Road";
    public static String[] tc640st1Dist = {"197", "217"};
    public static String[] tc640st2Dist = {"400", "410"};
    public static String[] tc640st3Dist = {"610", "620"};


    //Denali-684:Preferred Route = Fastest
    public static String tc684origin = "50.075099, 14.390438";
    public static String tc684dest = "50.084798, 14.362443";

    //Denali-697:Cancel demo
    public static String tc697input = "51.507350, -0.127759";
    public static String tc697expected = "KFC";

    // Denali-677:Route display
    public static String tc677origin = "47.554734, 19.075738";
    public static String tc677dest = "47.549518, 19.073582";

    //Denali-653:Waypoint/dest info-address
    public static String tc653origin = "51.579164, -0.147363";
    public static String tc653dest = "KFC";
    public static String tc653wp = "Titanic Cafe";
    public static String tc653category = Coffee;
    // Denali-956:Lane guidance type Left and Right
    public static String tc956origin = "50.075099, 14.390438";
    public static String tc956dest = "50.075619, 14.389667";

    // Denali-957:Lane guidance type Continue and Left and Right//(left
    // turn)|(straight)|(straight)|(right )
    public static String tc957origin = "50.087798, 14.443204";
    public static String tc957dest = "50.087465, 14.437902";
    //Denali-695:Demo route
    public static String tc695origin = "51.507350, -0.127759";
    public static String tc695dest = "KFC";
    //	//Denali-698:POI Name
//	public static String tc698input = "KFC";
//	public static String tc698expected = "KFC";
//	//Denali-704:POI Name+in+city+state
    public static String tc704origin = "51.507350, -0.127759";
    public static String tc704input = "Starbucks in London";
    public static String tc704expect = "Starbucks";
    //	//Denali-705:POI Name+of+state+country
//	public static String tc705input = "Shell of CA USA";
//	public static String tc705expected = "Shell";
//	//	Denali-706:POI Name+near+city+postcode
//	public static String tc706input = "Costco near Sunnyvale 94085";
//	public static String tc706expected = "Costco"; //add logic < 6 miles
//	// Denali-715:Chain POI name+near by+city
//	public static String tc715input = "starbucks near by Sunnyvale";
//	public static String tc715expected = "Starbucks"; //add logic < 6 miles
//	//Denali-717:Chain POI name+In+postcode
    public static String tc717origin = "51.507350, -0.127759";
    public static String tc717input = "starbucks in EC1A";
    public static String tc717expect = "Starbucks"; //add logic < 6 miles
    public static int tc717resultNumber = 25;
    //	//Denali-719:Landmarks
    public static String tc719origin = "51.507350, -0.127759";
    public static String tc719input = "Tower Bridge";
    public static String tc719expect = "Tower Bridge";
    //	// Denali-720:Airport Name
//	public static String tc720input = "San Francisco International Airport";
//	public static String[] tc720expected = {"San Francisco Int'l Airport","San Francisco International Airport","San Francisco Int'l Airport (SFO)"}; //use exact
//	//Denali-721:Alias name-Airport code
    public static String tc721origin = "51.507350, -0.127759";
    public static String tc721input = "LGW";
    public static String tc721expect = "London Gatwick Airport"; // use exact
    //	//Denali-728:Search super category
//	public static String tc728input = "ATM";
//	public static String[] tc728expected = {"Chase","Wells Fargo","Bank of America"};	
//	//Denali-731:Super Category+near+city
//	public static String tc731input = "hotel near Milpitas";
//	public static String[] tc731expected = {"Hilton Garden Inn","Staybridge Suites","Days Inn"};
//	//Denali-733:Super Category+of+postcode
//	public static String tc733input = "park of 94085";
//	public static String[] tc733expected = {"Fair Oaks Park","Columbia Park","Lakewood Park"};
//	//Denali-734:Sub category+NEAR+city+country
    public static String tc734origin = "51.507350, -0.127759";
    public static String tc734input = "Italian food near London UK";
    public static String tc734expect = "Prezzo & Crivelli Garden & Trattoria Italiana & Lulvio";
    public static int tc734resultNumber = 5;
    //	// Denali-735:Sub category+in+state+country
//	public static String tc735input = "Burgers in CA USA";
//	public static String[] tc735expected = {"McDonald's","In-N-Out Burger"};
//	//   Denali-737:GM dealership
//	public static String tc737input = "GM dealership";
//	public static String tc737expected = "GM";//need revisit with returned format
    // Denali-738:Search along route - one box search
    public static String tc738origin = "Strada Donath 29, Cluj-Napoca, Romania";
    public static String tc738input = "KFC";
    public static String tc738expected = "KFC";
    //	//Denali-748:State+Postcode
    public static String tc748origin = "51.507350, -0.127759";
    public static String tc748input = "Angus DD10";
    public static String tc748expect = "Montrose, SCOTLAND";
    //	//Denali-750: Postcode
//	public static String tc750input = "94102";
//	public static String[] tc750expected ={ "San Francisco","San Francisco, CA","San Francisco, CALIFORNIA"};//Onboard/Offboard
//	//Denali-751:City
    public static String tc751origin = "51.507350, -0.127759";
    public static String tc751input = "Birmingham";
    public static String tc751expect = "Birmingham, ENGLAND";
    //	//Denali-754:City+State+Country
//	public static String tc754input = "San Francisco CA USA";
//	public static String[] tc754expected = {"San Francisco, CA","San Francisco"}; //Onboard/Offboard
//	//Denali-756:City+State+Postcode
//	public static String tc756input = "San Francisco CA 94102";
//	public static String[] tc756expected = {"San Francisco, CA","San Francisco, CALIFORNIA"};//Onboard/Offboard
//	//Denali-762:Subcity
//	public static String tc762input = "Etobicoke, Toronto, ON CAN M8Y"; 
//	public static String tc762expected = "Etobicoke"; //Need revisit for the expectation
//	//Denali-770:Fuzzy search - Complete road type
//	public static String tc770input = "De guigne Drive";
//	public static String tc770expected = "De Guigne Dr";
//	//Denali-771:Fuzzy search - Street with directional prefix
//	public static String tc771input = "NW 9th St  Oswego, NY USA";
//	public static String tc771expected = "NW 9th St";
//	//Denali-775:Interval char - Comma 
//	public static String tc775input = "950,De guigne Dr,Sunnyvale,CA,94085";
//	public static String tc775expected = "950 De Guigne Dr";
//	//	Denali-776:Street
//	public static String tc776input = "De guigne Dr";
//	public static String tc776expected = "De Guigne Dr";
//	// Denali-777:Street+IN+City
    public static String tc777origin = "51.507350, -0.127759";
    public static String tc777input = "A4207 in London";
    public static String tc777expect = "A4207";
    //	//Denali-780:Street+City+State+Country
//	public static String tc780input = "Panchita Way Los Altos CA USA";
//	public static String tc780expected = "Panchita Way";
//	//Denali-784:Street+City+Postcode
//	public static String tc784input = "1st St San Francisco 94107";
//	public static String tc784expected = "1st St";
//	//Denali-787:Door Number+Street
    public static String tc787origin = "51.507350, -0.127759";
    public static String tc787input = "10 Beak St";
    public static String tc787expect = "10 Beak St | 10 Beak Street";
    //	//Denali-788:Door Number+Street+City
//	public static String tc788input = "950 De guigne Dr Sunnyvale";
//	public static String[] tc788expected =  {"950 Deguigne Dr","950 De Guigne Dr"}; //Onboard/Offboard
//	//Denali-790:Door Number+Street+State+Postcode
//	public static String tc790input = "1 1st St CA 94107";
//	public static String tc790expected = "1 1st St";
//	//Denali-807:Out of range door number
//	public static String tc807input = "10000 Kifer Rd Sunnyvale CA";
//	public static String tc807expected = "Kifer Rd"; //Need review the expectation
//	//Denali-809:Lat/lon search - Common
//	public static String tc809origin = "37.37890,-122.01074";
    public static String tc809input = "51.516223, -0.206360";
    public static String tc809expect = "65 Kensington Park Road";
    //	//Denali-815:Str1+Str2+Of+Postcode
//	public static String tc815input = "1st St Howard St 94107";
//	public static String tc815expected = "1st St";
//	//Denali-821:Str1+at+Str2
//	public static String tc821input = "1st St at Howard St"; //Near SF.
//	public static String tc821expected = "1st St";
//	//Denali-824:Str1+at+Str2+State+Postcode
    public static String tc824origin = "51.507350, -0.127759";
    public static String tc824input = "Oxford St at Duke St London W1K 6JL";
    public static String tc824expect = "Oxford Street at Duke Street";
//	//	Denali-828:Str1+and+Str2+In+City+State
//	public static String tc828input = "1st St at Howard St near San Francisco CA"; 
//	public static String tc828expected = "1st St";
//	//	Denali-835:Str1+@+Str2+of+State+Country
//	public static String tc835input = "1st St @ Howard St of CA USA"; 
//	public static String tc835expected = "1st St";
//	//Denali-836:Multiple Intersections
//	public static String tc836input = "camden sierra at otay rnch fieldbrook st, ca"; 
//	public static String tc836expected = "Camden Sierra at Otay Rnch";	
//	//Denali-838:Intersection_Roundabout With/Without Name

    //	Denali-841:Enter space
    public static String tc841origin = "51.507350, -0.127759";
    //	//Denali-852:Search category
    public static String tc852origin = "52.495901, 13.400916";
    public static String tc852input = Fuel;
    public static String tc852expect = "Esso & JET & ARAL";
    //	//Denali-854:Search result detailed info
    public static String tc854origin = "51.507350, -0.127759";
    public static String tc854input = Fuel;
    // Denali-861:Preferred Route = ECO
    public static String tc861origin = "50.075099, 14.390438";
    public static String tc861dest = "49.842218, 15.469908";
    //	//Denali-920:Current vehicle position-unnamed
//	public static String tc920origin = "37.385546, -122.014443";
    //Denali-921:Auto zoom timing - local road
    public static String tc921origin = "51.516240, -0.149530";
    public static String tc921dest = "51.511130, -0.133642";
    public static int tc921metric = 800;
    // Denali-922:Auto zoom for highway
    public static String tc922origin = "48.231934, 11.542148";
    public static String tc922dest = "48.225974, 11.540372";
    //Test case name: Denali-924:Restore Zoom scale - highway
    public static String tc924origin = "48.178417, 11.905457";
    public static String tc924dest = "48.174003, 11.926048";

    //Denali-925:Dest Drive To Current Dest Sign
    public static String tc925origin = "48.140026, 11.518507";
    public static String tc925dest = "Birketweg 1";
    public static String tc925expect = "Birketweg 1";

    //	//Denali-926:Arrival message-Destination
//	public static String tc926dest = "289 Santa Ana Ct";


    // Denali-935:EJV(Enhanced Junction View
    public static String tc935origin = "50.611723, 8.816707";
    public static String tc935dest = "50.604233, 8.819797";

    //	//Denali-936:GJV(Generic Junction View)
    public static String tc936origin = "48.146034, 0.678202";
    public static String tc936dest = "48.145852, 0.687767";
    // Denali-937:SAR(Sign As Real)
    public static String tc937origin = "48.142994, 11.743928";
    public static String tc937dest = "48.135598, 11.758824";
    //	//Denali-938:GMS(Generic Motorway Signs)
    public static String tc938origin = "48.146034, 0.678202";
    public static String tc938dest = "48.145852, 0.687767";


    // Denali-939:Lane Guidance show timing - Highway
    public static String tc939origin = "48.099956, 11.613819";
    public static String tc939dest = "48.105802, 11.611050";

    //Denali-942:Correct number of lanes
    public static String tc942origin = "48.862808, 2.319245";
    public static String tc942dest = "48.860404, 2.331962";
    public static int tc942ln = 3;

    // Denali-943:Lane guidance display timing - Major road
    public static String tc943origin = "46.775016, 23.602166";
    public static String tc943dest = "46.773759, 23.592539";
    public static String tc943expaudio = "in one quarter of a mile turn right";


    //	//Denali-948:Lane guidance type Continue and Left //(left turn)|(straight)|(straight)|(straight )
    public static String tc948origin = "53.761701, -2.410261";
    public static String tc948dest = "53.768589, -2.395138";

    //	//Denali-949:Lane guidance type Continue and Right //(straight)|(right )
    /*public static String tc949origin = "46.767269, 23.595848";
	public static String tc949dest = "46.767294, 23.598680";*/
    public static String tc949origin = "zzz";
    public static String tc949dest = "zzz";

    //	//Denali-951:Lane guidance type Right //right | right
    public static String tc951origin = "46.777283, 23.619523";
    public static String tc951dest = "46.777968, 23.615020";
    //Denali-954:Lane guidance type Left Uturn
    public static String tc954origin = "37.352298, -122.005128,270";
    public static String tc954dest = "37.352104,-122.007821";
    //	//Denali-956:Lane guidance type Left and Right
//	public static String tc956origin = "37.771447, -122.510272,270";//set vehicle direction to west
//	public static String tc956dest = "37.770506, -122.511003";
//	//Denali-957:Lane guidance type Continue and Left and Right//(left turn)|(straight)|(straight)|(right )
//	public static String tc957origin = "41.852622, -87.628448,90";//set vehicle direction to east
//	public static String tc957dest = "41.852052, -87.627097";
//	Denali-970:Demo long route
    //Denali-960:No results - has suggestions
    public static String tc960searchText = "KFC near Bucuresti";
    //Denali-962:Route Type Preferences
    public static String tc962origin = "51.608346, -0.270648";
    // Denali-964:Route Overview
    public static String tc964origin = "51.503844, -0.087379";
    public static String tc964dest = "LGW";
    public static String tc970origin = "48.1419167,11.5592144";
    public static String tc970dest = "Madrid, Spain";
    //Denali-973:Repeated search and map action while long route
    public static String tc973origin = "52.3745291,4.7585319";
    public static String tc973dest = "Podgorica, Montenegro";
    //	Denali-974:Map action in 3D map
    public static String tc974origin = "51.504931, -0.086514"; //london The Shard

    // Denali-987:Zoom out before auto zoom
    public static String tc987origin = "51.485634, -0.334871";
    public static String tc987dest = "51.573242, -0.025267";
    public static int tc987metric = 800;

    //Denali-988:Zoom out after auto zoom
    public static String tc988origin = "51.608346, -0.270648";
    public static String tc988dest = "51.604618, -0.272415";
    public static String tc988manuever = "A5109";
    // Denali-997:Vehicle icon menu - Home/Work are set up
    public static String tc997origin = "51.593235, -0.161257";
    public static String tc997home = "13 Middleway";
    public static String tc997work = "33 Buckhurst Street";

    // Denali-1016:Avoid pop up info
    public static String tc1016origin = "51.579164, -0.147363";
    public static String tc1016dest = "51.583806, -0.140266";
    public static String tc1016avoid = "Onslow Gardens";

    //	Denali-1017:Tight turn auto zoom
    public static String tc1017origin = "51.600726, -0.272000";
    public static String tc1017dest = "51.603402, -0.277105";
    public static String tc1017maneuver1 = "Axholme Ave";
    public static String tc1017maneuver2 = "Greencourt Ave";

    //Denali-1018:Waypoint Skip To Next Sign
    public static String tc1018origin = "51.509994, -0.122403";
    public static String tc1018dest = "6 Clipstone St Fitzrovia, London W1W 6BB";
    public static String tc1018wp = "Starbucks";
    public static String tc1018category = Coffee;
    public static String tc1018DriveTo = "Drive to 6 Clipstone Street";

    //	//Test case name:Denali-1019:Show junction view on turn list
    public static String tc1019origin = "48.224180, 11.528049";
    public static String tc1019dest = "48.224926, 11.587094";
//	// Denali-1020:Show turn list on junction view
//	public static String tc1020origin = "37.434628, -121.918859";

    //Denali-1024:Waypoint pop up
    public static String tc1024origin = "48.140026, 11.518507";
    public static String tc1024dest = "KFC";

    //Denali-1025:Add waypoint options-cancel
    public static String tc1025origin = "48.140026, 11.518507";
    public static String tc1025dest = "KFC";
    public static String tc1025search = "Shell";

    //Denali-1026:Add waypoint options-Add as Waypoint
    public static String tc1026origin = "48.140026, 11.518507";
    public static String tc1026dest = "KFC";
    public static String tc1026wp = "Esso";

    //Denali-1027:Add waypoint options-Make new destination
    public static String tc1027origin = "48.140026, 11.518507";
    public static String tc1027dest = "KFC";
    public static String tc1027wp = "Shell";

    //Denali-1028:Add waypoint method
    public static String tc1028origin = "48.140026, 11.518507";
    public static String tc1028dest = "KFC";
    public static String tc1028wp = "Shell";
    public static String tc1028expect = "KFC";

    //Denali-1119:Delete dest
    public static String tc1119origin = "48.140026, 11.518507";
    public static String tc1119dest = "KFC";
    public static String tc1119expect = "KFC";
    public static String tc1119wp = "Shell";

    // Denali-1050:Exit Amenities Icon - local road
    public static String tc1050origin = "46.840107, 23.105406";
    public static String tc1050Dest = "46.829317, 23.151761";
    //	// Denali-1051:Exit Amenities Icon - highway
//	public static String  tc1051origin = "37.410699, -121.991901";
//	public static String tc1051Dest = "37.418709, -121.969046"; //Exit 6 of CA237 
//	//Denali-1052:Exit Amenity List generic info
    public static String tc1052origin = "48.777963, 2.214133";
    public static String tc1052Dest = "48.775886, 2.237064";
    public static String tc1052Exit = "Exit A86";
    //	//	Denali-1053:Exit Amenity List - available POI info
    public static String tc1053origin = "48.777963, 2.214133";
    public static String tc1053Dest = "48.774931, 2.218498";
    public static String tc1053Exit = "Exit A86";
    //	//Denali-1054:Seach exit POI
    public static String tc1054origin = "52.993858, -2.297000";
    public static String tc1054dest = "52.994969, -2.289978";
    public static String tc1054expectExit = "Exit 15";
    public static String[] tc1054ExpectedExitPOIType = {"gas"};





	/*public static String tc1054origin = "53.407450, -1.394750";
	public static String tc1054dest = "53.411261, -1.403065";
	public static String tc1054expectExit = "Exit 34";
	public static String[] tc1054ExpectedExitPOIType = {"coffee"};
	public static String targetExitPOI = "Tinsley Transcafe";*/

    //Denali-1060:Waypoint edit view
    public static String tc1060origin = "51.507350, -0.127759";
    public static String tc1060dest = "KFC";
    public static String tc1060wp = "Starbucks";
    //	//Denali-1108:Set POI category to favorite
    public static String tc1108origin = "51.507350, -0.127759";
    public static String tc1108expect = "Starbucks";

    //Denali-1072:Search along route - Category search
    public static String tc1072origin = "51.507350, -0.127759";
    public static String tc1072dest = "LGW";
    public static String tc1072input = Fuel;
    public static String tc1072expect = "Shell";
    //	Denali-1087:FreeMap
    public static String tc1087origin = "48.860892, 2.337790";
    // Denali-1090:Recent destination - Drive
    public static String tc1090origin = "52.5167, 13.3833";
    public static String tc1090destination1 = "Shell";
    public static String tc1090destination2 = "HEM";
    // Denali-1095:Sub panel display priority
    public static String tc1095origin = "46.769599, 23.566807";
    public static String tc1095dest = "46.769287, 23.568238";
    public static String tc1095originTight = "46.762241, 23.600003";
    public static String tc1095destTight = "46.759533, 23.598275";

    //	//Denali-1101:Rich data POI - Introduction
    public static String tc1101origin = "51.498996, -0.116968";
    public static String tc1101dest = "London Eye";

    //	//Denali-1117:Next maneuver card - waypoint/dest address info
    public static String tc1117origin = "51.542891, 0.009588";
    public static String tc1117dest = "209 Romford Road";

    //Denali-1118:Action - avoid waypoint
    public static String tc1118origin = "51.579164, -0.147363";
    public static String tc1118dest = "KFC";
    public static String tc1118wp = "Esso";

    // Denali-1151:Did you mean page - Back
    public static String tc1151searchText = "KFC Piata Unirii";

    //	//Denali-1161:Show POI icons on map
//	public static String  tc1161origin = "50.114902, 8.680363";
    public static String tc1161origin = "50.112510, 8.687908";
//	//Denali-1162:Hide all POI icons on map
//	public static String tc1162origin = originFromLocation;

    //Denali-1166:Home/Work address stored
    public static String tc1166home = "15 Donath, Cluj Napoca, RO";
    public static String tc1166work = "19 Marasesti, Cluj Napoca, RO";

    //Denali-1167:Simple Arrival View-Destination
    public static String tc1167origin = "48.843639, 2.306076";
    public static String tc1167dest = "117 Rue Lecourbe";
    public static String tc1167expect = "117 Rue Lecourbe";

    // Denali-1168:Simple Arrival View-Waypoint
    public static String tc1168origin = "48.154260, 11.511629";
    public static String tc1168dest = "KFC";
    public static String tc1168category = Fuel;
    public static String tc1168wp = "Esso";

    // Denali-1169:Waypoint/dest info-POI
    public static String tc1169origin = "46.780099, 23.604902";
    public static String tc1169dest = "KFC";
    public static String tc1169waypoint = "OMV";

    //	//Denali-1170:Next maneuver card - waypoint/dest POI info
    public static String tc1170origin = "48.853264, 2.377438";
    public static String tc1170dest = "135 Rue de Charonne";
    public static String tc1170expectDest = "135 Rue de Charonne";
    public static String tc1170category = Coffee;
    public static String tc1170wp = "Les Andalouses";
    public static String tc1170expectWp = "Les Andalouses";
    public static String tc1170expectTurn = "LocationLeft";
    //	//Denali-1191:Add from one box search
    public static String tc1191origin = "51.507350, -0.127759";
    public static String tc1191dest = "25 Short St. London SE1 8LJ";
    public static String tc1191recent = "Short Street";
    public static String tc1191wp = "Starbucks";
    // Denali-1192:Add Waypoint to Recent
    public static String tc1192origin = "52.5167, 13.3833";
    public static String tc1192destination1 = "Shell";
    public static String tc1192destination2 = "HEM";
    // Denali-1193:Entries sort by Date and Time
    public static String tc1193destination1 = "Starbucks";
    public static String tc1193destination2 = "KFC";
    public static String tc1193destination3 = "TEXACO";
//	//Denali-1193:Entries sort by Date and Time
//	public static String tc1193dest1 = "New York, NY";
//	public static String tc1193dest2 = "San Francisco Int'l Airport";
//	public static String tc1193dest3 = "Shell";
//	//Denali-1197:Hide selected POI icons on map
//	public static String tc1197origin =originFromLocation;

    // Denali-1209:Dest arrival in turn list screen
    public static String tc1209rigin = "48.140026, 11.518507";
    public static String tc1209dest = "Esso";
    // Denali-1210:Detailed recents info
    public static String tc1210origin = "52.398930, 5.346604";
    public static String tc1210destination = "Shell";
    //Denali-1222:Set one box search to favorite
    public static String tc1222input = "Munich, Bavaria, Germany";

    //	//Denali-1226:Show Junction View over Exit POI
    public static String tc1226origin = "48.227313, 11.609563";
    public static String tc1226Dest = "48.199416, 11.613375";

    //	//Denali-1227:Keep Search page over Junction View
    public static String tc1227origin = "48.142994, 11.743928";
    public static String tc1227dest = "48.135598, 11.758824";
    //	//Denali-1235:Change default zoom level NavigationMap
    public static String tc1235origin = "52.398930, 5.346604";
    public static String tc1235dest = "52.670327, 5.711338";
    // Denali-1242:Save Favorite from city search
    public static String tc1242input = "London, UK";
    public static String tc1242expected = "London, London, United Kingdom";
    // Denali-1243:Search Recent from One Box
    public static String tc1243origin = "52.5167, 13.3833";
    public static String tc1243destination = "RWE";
    public static String tc1243expected = "RWE";
    // Denali-1244:Did you mean page - Close
    public static String tc1244searchText = "KFC Piata Unirii";
    // Denali-1245:Search history list - belong to Recent/Favorites/Contact
    public static String tc1245input = "Daverlostraat 10 8310 Belgium";
    public static String tc1245expected = "10 daverlostraat";
    // Denali-1246:Search History list - No result return
    public static String tc1246input = "!ab23cdefg!@#$";
    // Denali-1446:Delete favorite from navigation appadb device
    public static String tc1446origin = "46.7739925,23.5786711";
    public static String tc1446input = "Bundesweg, 20146 Hamburg, Germany";
    //	Denali-1448:Play of Railroad Crossing = OFF
    public static String tc1448origin = "46.787571, 23.627286";
    public static String tc1448dest = "46.783453, 23.623793";
    //	//Denali-1483:Alert of Railroad Crossing = ON - Approach
    public static String tc1483origin = "51.440009, 7.091486";
    public static String tc1483dest = "51.437775, 7.098696";
    //	//Denali-1487:Turn right after landmark
    public static String tc1487origin = "52.529010, 13.457135";
    public static String tc1487dest = "52.529609, 13.450203";
    public static String tc1487expect[] = {"guidance will start now", "in (.*) turn right.", "in (.*) turn right after the (.*) to (.*)", "turn right to (.*)"};
    //	Denali-1496:repeat oneBoxEditText search
    public static String tc1496origin = "48.1419167,11.5592144";
    //	Denali-1497:map action while route in a big city
    public static String tc1497origin = "51.504931, -0.086514";
    public static String tc1497dest = "124 Hanworth Rd, Hampton TW12 3EG, UK";
    //	Denali-1501:Alert of Railroad Crossing = ON
    public static String tc1501origin = "49.062743, 6.286590";
    public static String tc1501dest = "49.061119, 6.291674";
    // Denali-1502:Save Favorite from POI brand name search
    public static String tc1502input = "KFC";
    // Denali-1505:Select one from favorite list
    public static String tc1505input = "KFC";
    // Denali-1506:Favorite list
    public static String tc1506origin = "KFC";
    public static String tc1506origin2 = "Starbucks";
    // Denali-1269:Next maneuver card - turn icon
    //public static String tc1269origin = "51.526901, -0.082812";
    //public static String tc1269dest = "71 Buttesland St";
    //public static String[][] tc1269expect = {{"Boot Street","TurnRight"},{"Pitfield Street","TurnRight"},{"Chart Street","TurnLeft"},{"71 Buttesland Street, London, N1 6, United Kingdom","LocationLeft"}};

    public static String tc1269origin = "46.7571572,23.5928598";
    public static String tc1269dest = "20 Strada Bisericii Ortodoxe";
    public static String[][] tc1269expect = {{"Strada Republicii", "TurnLeft"}, {"Strada Ion Mincu", "TurnRight"}, {"20 Strada Bisericii Ortodoxe", "LocationLeft"}};

    //Denali-1719:long route at background
    public static String tc1719origin = "48.1419167,11.5592144";
    public static String tc1719dest = "Barcelona Spain";
    public static String[] smokeSearches = {"madrid", "barcelona"};
    public static String[] multipleSearches = {"alicante", "alicante Aeroport", "alicante Aeroporto", "alicante Aeropuerto", "alicante Airport", "Alicante airport", "alicante Avenida de las naciones alicante", "alicante El altet", "alicante Flughafen", "alicante Flygplats", "alicante Gran Via", "alicante aeropuerto", "alicante, avenida de Oscar Espla", "alicante, avenida de Salamanca", "alicante,calle Isaac Albeniz", "alicante calle Italia", "alicante calle San Vicente", "alicante calle doctor Buades", "alicante calle padre Recadero de los Raos", "barcelona", "barcelona Airport", "barcelona Avinguda Diagonal", "barcelona Camp nou", "Carrer d'Arago barcelona", "barcelona Carrer de Balmes", "barcelona Carrer de Mallorca", "barcelona Carrer de Muntaner", "barcelona Carrer de Valencia", "barcelona Diagonal", "barcelona Flughafen", "barcelona Gran Via de les Corts Catalanes", "barcelona La rambla", "barcelona Passeig de gracia", "barcelona Placa d'Espanya", "barcelona Rambla", "barcelona Ramblas", "barcelona aeropuerto", "barcelona instituto guttman", "bilbao", "bilbao Adiskidetasun kalea", "bilbao Aeropuerto", "bilbao Airport", "bilbao Alameda de Urquijo", "bilbao Artasamina kalea", "bilbao Avenida abandoibarra", "bilbao Avenida miraflores", "bilbao Calle Blas de Otero", "bilbao Calle Ercilla", "bilbao Flughafen", "bilbao Gran via", "bilbao Lehendakari Leizaola Kalea", "bilbao Plaza Circular", "bilbao, plaza de la encarnacion", "bilbao Sabino Arana etorbidea", "bilbao aeropuerto", "bilbao araneko", "bilbao autonomia", "granada", "granada Acera del darro", "granada Alhambra", "granada Avenida de Madrid", "granada Avenida de la Constitucion", "granada Calle Acera del Darro", "granada Calle Arabial", "Gran Via de Colon Granada", "granada Calle Navas", "granada", "Calle Real de la Alhambra", "granada Calle Recogidas", "granada Calle acera del darro", "granada Calle real de la alhambra", "granadaCamino de Ronda", "granada Paseo de la Sabica", "granada Paseo de la sabica", "granada Plaza Nueva", "granada Plaza nueva", "granada Recogidas", "madrid", "madrid Airport", "madrid alcala", "madrid Arturo Soria", "madrid Atocha", " madrid Avenida de America", "madrid Calle Serrano", "madrid Calle de Alcala", "madrid Calle de Atocha", "madrid Calle de Ayala", "madrid Calle de Bravo Murillo", "madrid calle mendez alvaro", "madrid calle de ramon gomez de la serna", "madrid Called de Segovia", "madrid Flughafen", "madrid Gran Via", "madrid Paseo de la Castellana", "madrid Plaza mayor", "malaga", "malaga Aeroport", "malaga Aeroporto", "malaga Aeropuerto", "malaga Airport", "malaga Avda garcia morato", "malaga Avenida de velazquez", "malaga Avenida garcia morato", "malaga Bandaneira", "malaga Calle larios", "malaga Centro", "malaga Flughafen", "malaga Garcia morato", "malaga Herman hesse", "malaga Malaga airport", "malaga Marmoles", "malaga Plaza de la marina", "malaga Plaza de la merced", "malaga Zentrum", "mallorca", "mallorca Aeropuerto", "mallorca Airport", "mallorca Alcudia", "mallorca Avenidas ses savines", "mallorca Cala millor", "mallorca Cala pi", "mallorca Canyamel", "mallorca Cap de formentor", "mallorca Cap formentor", "mallorca Es trenc", "mallorca Flughafen", "mallorca Formentor", "mallorca Murro", "mallorca Palma", "mallorca Palma de Mallorca", "mallorca Pilar juncosa", "mallorca Sa coma", "mallorca Schinkenstrasse", "mallorca Sineu", "marbella", "marbella Avenida de Ramon y cajal", "marbella calle camilo jose cela", "marbella Calle bronce", "marbella Calle camilo jose cela", "marbella Calle oxford", "marbella Carretera de ojen", "marbella Centro", "marbella Jardines de principe", "marbella La canada", "marbella Montenebros", "marbella Parque Comercial La Canada", "marbella Paseo maritimo", "marbella Plaza de los Naranjos", "marbella Plaza de los naranjos", "marbella Puerto banus", "marbella puerto banus", "malaga", "malaga Acceso Sur Aeropuerto", "malaga Avenida Carlos Haya", "malaga Avenida del Comandante Garcia Morato", "malaga Calle Mercedes Llopart", "malaga Calle Mairmoles", "malaga Calle Ramal Atabalero", "malaga Calle de Manuel Altolaguirre", "malaga Calle de la Victoria", "malaga Calle del Marques de Larios", "malaga Flughafen", "malaga MERCEDES LLOMPART", "malaga Plaza Era Alta", "malaga Plaza de la Constitucionn", "malaga Plaza de la Marina", "malaga Plaza de la Merced", "malaga Aeropuerto de Malaga", "malaga aeropuerto", " malaga airport", "palma", "palma Aeroport", "palma Aeroporto", "palma Aeropuerto", "palma Airport", "palma Avenida del Aeropuerto", "palma Avinguda de Gabriel Roca", "palma Carrer son fangos", "palma Flughafen", "palma Parc de la mar", "palma Paseo Maritimo", "palma Paseo maritimo", "palma Placa major", "palma Plaza major", "palma Poligono son oms", "palma Porto pi", "palma Schinkenstrasse", "palma airport", "palma flughafen", "palma de mallorca", "palma de mallorca Aeroporto", "palma de mallorca Aeropuerto", "palma de mallorca Airport", "palma de mallorca Avenida gabriel roca", "palma de mallorca Calle san juan", "palma de mallorca Calle unio", "palma de mallorca Camino de ca'n pastilla", "palma de mallorca Carrer de Sant Miguel", "palma de mallorca Carrer de la concepcio", "palma de mallorca Flughafen", "palma de mallorca Manuela de los herreros", "palma de mallorca Manuela de los herreros i sora", "palma de mallorca Parc de la mar", "palma de mallorca Paseo maritimo", "palma de mallorca Passeo maritimo", "palma de mallorca Placa major", "palma de mallorca Plaza espana", "palma de mallorca Plaza major", "palma de mallorca Union", "sevilla", "sevilla Aeropuerto", "sevilla Airport", "sevilla Avenida Blas Infante", "sevilla Avenida Kansas City", "sevilla Avenida San Francisco Javier", "sevilla Avenida de Eduardo Dato", "sevilla Avenida de Jerez", "sevilla Avenida de Roma", "sevilla Avenida de la Soleai", "sevilla Calle leon xiii", "sevilla Calle sierpes", "sevilla Flughafen", "sevilla Plaza de Espana", "sevilla Plaza de armas", "sevilla Plaza de espana", "sevilla Plaza nueva", "sevilla aeropuerto", "sevilla plaza de armas", "valencia", "valencia Aeropuerto", "valencia Airport", "valencia Avenida Cortes Valencianas", "valencia Avenida Primado Reig", "valencia Avenida de Ausias March", "valencia Avenida de las Cortes Valencianas", "valencia Avenida del Cid", "valencia Avenida del Puerto", "valencia Calle Rosales", "valencia Calle San Vicente Mairtir", "valencia Calle del General Urrutia", "valencia Calle del litografo pascual y abad", "valencia Carrer de Colon", "valencia Carrer del Comte de Melito", "valencia Flughafen", "valencia Paseo de la Alameda", "valencia Plaza del Ayuntamiento", "valencia Salamanca", "zaragoza", "zaragoza Avenida Cataluna", "zaragoza Avenida de Caesar Augusto", "zaragoza Avenida de Gomez de Avellaneda", "zaragoza Avenida de Mara Zambrano", "zaragoza Avenida de Tenor Fleta", "zaragoza Calle Adolfo Aznar", "zaragoza Calle Batalla de Lepanto", "zaragoza Calle Conde de Aranda", "zaragoza Calle La Milagrosa", "zaragoza Calle de Santa Gema", "zaragoza Calle de las Delicias", "zaragoza Calle del Coso", "zaragoza Calle del Pintor Zuloaga", "zaragoza Paseo Sagasta", "zaragoza Plaza del Pilar", "zaragoza Puerto Venecia", "zaragoza ctra. de madrid km. 314.900", "zaragoza puerto venecia"};


    // Denali-838:Intersection_Roundabout With/Without Name
    //public static String tc838origin = "37.717265, -122.476515";


    // Denali-589:Turn icon - Vehicle is off road
    public static String tc589origin = "47.205593, 8.288073";
    public static String tc589dest = "47.208347, 8.293425";
    public static String tc589expect = "TurnSlightRight";
    // Denali-217:Current street name display-unnamed road
    public static String tc217origin = "zzz";
    public static String tc217dest = "zzz";
    public static String tc217expect = "zzz";
    // Denali-1718:Current street name display-No vehicle access road
    public static String tc1718origin = "46.768524, 23.576415";
    public static String tc1718dest = "zzz";
    // Denali-586:Maneuver arrow _ U-turn
    //public static String tc586origin = "47.554734, 19.075738";
    //public static String tc586dest = "47.551152, 19.074098";
    public static String tc586origin = "48.165199, 11.553065";
    public static String tc586dest = "48.163706, 11.552900";


    //search-intersection
    // Denali-838:Intersection_Roundabout With/Without Name
    public static String[] tc838input = {"Juans Bautista Cir and Font Blvd in San Francisco", "Serrano Dr and Font Blvd in San Francisco"};
    public static String[] tc838expected = {"Juan Bautista Cir", "Serrano Dr"};
    public static String tc838origin = "";
    // Denali-836:Multiple Intersections
    public static String tc836origin = "51.522673, -0.137456";
    public static String tc836input = "Park Square at A501";
    public static String tc836expected = "Park Square at A501";
    //Denali-828:Str1+and+Str2+In+City+State
    public static String tc828input = "Baker St at Geroge St London UK";
    public static String tc828expected = "Baker St at Geroge St";
    // Denali-821:Str1+at+Str2
    public static String tc821origin = "51.522673, -0.137456";
    public static String tc821input = "Baker St at Geroge St";
    public static String tc821expected = "Baker St at Geroge St";
    // Denali-811:Str1+Str2
    public static String tc811origin = "51.522673, -0.137456";
    public static String tc811input = "Baker St Geroge St";
    public static String tc811expected = "Baker St at Geroge St";
    // Denali-815:Str1+Str2+Of+Postcode
    public static String tc815input = "Baker St Geroge St of SE1 7PB";
    public static String tc815expected = "Baker St at Geroge St";
    // Denali-826:Str1+and+Str2
    public static String tc826input = "Baker St Geroge St";
    public static String tc826expected = "Baker St at Geroge St";
    // Denali-816:Str1+&+Str2
    public static String tc816input = "Baker St & Geroge St";
    public static String tc816expected = "Baker St at Geroge St";
    // Denali-600:Str1+@+Str2+City+State+Country
    public static String tc600input = "Baker St @ Geroge St London UK";
    public static String tc600expected = "Baker St at Geroge St";
    // Denali-814:Str1+Str2+City+Postcode
    public static String tc814input = "Baker St Geroge St SE1 7PB";
    public static String tc814expected = "Baker St Geroge St";

    //Denali-48:Active route color
    public static String tc48origin = "52.550152, 13.448939";
    public static String tc48dest = "52.558509, 13.415756";
    public static String tc48category = Fuel;
    public static String tc48wp = "Shell";


    //ADDRESS SEARCH MULTIBOX
    // Denali-2293:Street + City
    public static String tc2293origin = "51.2333, 6.7833";
    public static String tc2293field1 = "Daleside Road";
    public static String tc2293field3 = "London";
    public static String tc2293expected = "Daleside Road, London, SW16 6, United Kingdom";

    // Denali-2294:Street + Postcode
    public static String tc2294origin = "51.2333, 6.7833";
    public static String tc2294field1 = "Calle de Ibiza";
    public static String tc2294field3 = "28009";
    public static String tc2294expected = "Calle de Ibiza, 28009 Madrid (Madrid), Spain";

    // Denali-2297:Street + Postcode + City
    public static String tc2297origin = "51.2333, 6.7833";
    public static String tc2297field1 = "Stadionweg";
    public static String tc2297field3 = "1077 Amsterdam";
    public static String tc2297expected = "Stadionweg, 1077 Amsterdam, Amsterdam, Netherlands";

    // Denali-2305:Street + Postcode + Country
    public static String tc2305origin = "51.2333, 6.7833";
    public static String tc2305field1 = "Daverlostraat";
    public static String tc2305field3 = "8310 Belgium";
    public static String tc2305expected = "Daverlostraat, 8310 Bruges, Belgium";

    // Denali-2306:Street + Postcode + Region
    public static String tc2306origin = "51.2333, 6.7833";
    public static String tc2306field1 = "Viale Adua";
    public static String tc2306field3 = "51100 Tuscany";
    public static String tc2306expected = "Viale Adua, 51100 Pistoia Pistoia, Italy|Viale Adua, 51100 Pistoia PT, Italy";

    // Denali-2299:Street + City + Region
    public static String tc2299origin = "51.2333, 6.7833";
    public static String tc2299field1 = "Viale Renato Serra";
    public static String tc2299field3 = "Milano Lombardia";
    public static String tc2299expected = "Viale Renato Serra, 20149 Milan Milan, Italy|Viale Renato Serra, 20149 Milan MI, Italy";

    // Denali-2300:Street + City + Country
    public static String tc2300origin = "51.2333, 6.7833";
    public static String tc2300field1 = "Bundesweg";
    public static String tc2300field3 = "Hamburg Germany";
    public static String tc2300expected = "Bundesweg, 20146 Hamburg, Germany";

    // Denali-2295:Street + number + City
    public static String tc2295origin = "51.2333, 6.7833";
    public static String tc2295field1 = "Handelskai";
    public static String tc2295field2 = "32";
    public static String tc2295field3 = "Vienna";
    public static String tc2295expected = "Handelskai 32, 1200 Vienna, Austria|32 Handelskai, 1200 Vienna, Austria";

    // Denali-2296:Street + number + Postcode
    public static String tc2296origin = "51.2333, 6.7833";
    public static String tc2296field1 = "Carsten Reimers Ring";
    public static String tc2296field2 = "14";
    public static String tc2296field3 = "22175";
    public static String tc2296expected = "Carsten-Reimers-Ring 14, 22175 Hamburg, Germany";

    // Denali-2298:Street + number + Postcode + City
    public static String tc2298origin = "51.2333, 6.7833";
    public static String tc2298field1 = "calle de las adelfas";
    public static String tc2298field2 = "38";
    public static String tc2298field3 = "28007 Madrid";
    public static String tc2298expected = "Calle de las Adelfas, 38, 28007 Madrid (Madrid), Spain|38 Calle de las Adelfas, 38, 28007 Madrid (Madrid), Spain";

    // Denali-2303:Street + number + Postcode + Country
    public static String tc2303origin = "51.2333, 6.7833";
    public static String tc2303field1 = "Filips van Cleeflaan";
    public static String tc2303field2 = "23";
    public static String tc2303field3 = "9000 Belgium";
    public static String tc2303expected = "Filips van Cleeflaan 23, 9000 Ghent, Belgium|23 Filips van Cleeflaan, 9000 Ghent, Belgium";

    // Denali-2304:Street + number + Postcode + Region
    public static String tc2304origin = "51.5072, 0.1275";
    public static String tc2304field1 = "Oedenberger Straße";
    public static String tc2304field2 = "99";
    public static String tc2304field3 = "90491 Bavaria";
    public static String tc2304expected = "Oedenberger Straße 99, 90491 Nuremberg, Germany";

    // Denali-2301:Street + number + City + Region
    public static String tc2301origin = "51.2333, 6.7833";
    public static String tc2301field1 = "Spalto Gamondio";
    public static String tc2301field2 = "10";
    public static String tc2301field3 = "Alessandria Piemonte";
    public static String tc2301expected = "Spalto Gamondio 10, 10, 15121 Alessandria Alessandria, Italy|10 Spalto Gamondio, 10, 15121 Alessandria AL, Italy";

    // Denali-2302:Street + number + City + Country
    public static String tc2302origin = "51.2333, 6.7833";
    public static String tc2302field1 = "Courtman Road";
    public static String tc2302field2 = "80";
    public static String tc2302field3 = "London UK";
    public static String tc2302expected = "80 Courtman Road, London, N17 7, United Kingdom";

    // Denali-2307:Postcode + City
    public static String tc2307origin = "51.2333, 6.7833";
    public static String tc2307field3 = "59000 Lille";
    public static String tc2307expected = "59000 Lille, Nord-Pas-de-Calais, France|Lille, NORD-PAS-DE-CALAIS, Nord-Pas-de-Calais, France";

    // Denali-2308:City + Country
    public static String tc2308origin = "51.2333, 6.7833";
    public static String tc2308field3 = "Braga Portugal";
    public static String tc2308expected = "Braga, Portugal";

    // Denali-2309:City + Region
    public static String tc2309origin = "51.2333, 6.7833";
    public static String tc2309field3 = "Metz Lorraine";
    //public static String tc2309expected = "Metz, Lorraine, France";
    public static String tc2309expected = "Metz, Lorraine, France|Metz, LORRAINE, France";

    // Denali-2310:Postcode + City + Region + Country
    public static String tc2310origin = "51.5072, 0.1275";
    public static String tc2310field3 = "80331 Munich Bavaria Germany";
    public static String tc2310expected = "80331 Munich, Bavaria, Germany|80331 Munich, Bavaria, Germany, Bavaria, Germany";


    //NA CITY
    // Denali-754:City+State+Country
    public static String tc754input = "Munchen Bayern Germany";
    public static String tc754expected = "Munich, Bavaria, Germany";

    // Denali-756:City+State+Postcode
    public static String tc756input = "Metz Lorraine 57000";
    public static String tc756expected = "Metz, LORRAINE";

    // Denali-753:City+State+Country
    public static String tc753input = "Metz Lorraine France";
    public static String tc753expected = "Metz, LORRAINE";

    // Denali-762:Subcity
    public static String tc762input = "Offenbach am Main, Frankfurt";
    public static String tc762expected = "Offenbach am Main";

    // Denali-750: Postcode
    public static String tc750input = "57000";
    public static String tc750expected = "Metz, LORRAINE";

    // Denali-759:City+Postcode
    public static String tc759input = "Metz 57000";
    public static String tc759expected = "Metz, LORRAINE";

    // Denali-749:Postcode+Country
    public static String tc749input = "57000 France";
    public static String tc749expected = "Metz, LORRAINE";

    // Denali-758:City+Postcode+Country
    public static String tc758input = "Metz 57000 France";
    public static String tc758expected = "Metz, LORRAINE";

    // Denali-747:State+Postcode+Country
    public static String tc747input = "Lorraine 57000 France";
    public static String tc747expected = "Metz, LORRAINE";


    //NA STREET
    // Denali-775:Interval char - Comma
    public static String tc775input = "10,Landshuter Allee,Munchen,Germany,80637";
    public static String tc775expected = "Landshuter Allee 10";

    // Denali-807:Out of range door number
    public static String tc807input = "10000 Avenue de Nancy Metz France";
    public static String tc807expected = "Avenue de Nancy";

    // Denali-784:Street+City+Postcode
    public static String tc784input = "Oberanger, Munich, 80331";
    public static String tc784expected = "Oberanger";

    // Denali-776:Street
    public static String tc776origin = "49.103116, 6.226669";
    public static String tc776input = "Avenue de Nancy";
    public static String tc776expected = "Avenue de Nancy";

    // Denali-788:Door Number+Street+City
    public static String tc788input = "21 Avenue de Nancy Metz";
    public static String[] tc788expected = {"21 Avenue de Nancy", "21 Avenue de Nancy"}; // Onboard/Offboard

    // Denali-790:Door Number+Street+State+Postcode
    public static String tc790input = "21 Avenue de Nancy Lorraine 57000";
    public static String tc790expected = "21 Avenue de Nancy";

    // Denali-780:Street+City+State+Country
    public static String tc780input = "Avenue de Nancy Metz Lorraine France";
    public static String tc780expected = "Avenue de Nancy";

    // Denali-779:Street+City+State
    public static String tc779input = "Avenue de Nancy Metz Lorraine";
    public static String tc779expected = "Avenue de Nancy";

    // Denali-783:Street+City+Country
    public static String tc783input = "Avenue de Nancy Metz France";
    public static String tc783expected = "Avenue de Nancy";

    // Denali-785:Street+Postcode
    public static String tc785input = "Avenue de Nancy Metz 57000";
    public static String tc785expected = "Avenue de Nancy";

    // Denali-786:Street+Postcode+Country
    public static String tc786input = "Avenue de Nancy 57000 France";
    public static String tc786expected = "Avenue de Nancy";

    // Denali-782:Street+State+Postcode
    public static String tc782input = "Avenue de Nancy Lorraine 57000";
    public static String tc782expected = "Avenue de Nancy";

    // Denali-596:Street+City+State+Postcode
    public static String tc596input = "Avenue de Nancy Metz Lorraine 57000";
    public static String tc596expected = "Avenue de Nancy";

    // Denali-789:Door Number+Street+City+State
    public static String tc789input = "21 Avenue de Nancy Metz Lorraine";
    public static String tc789expected = "21 Avenue de Nancy";

    // Denali-793:Door Number+Street+Postcode
    public static String tc793input = "45 Luisenstrasse 10117";
    public static String tc793expected = "45 Luisenstrasse";

    // Denali-792:Door Number+Street+City+Postcode
    public static String tc792input = "21 Avenue de Nancy Metz 57000";
    public static String tc792expected = "21 Avenue de Nancy";

    // Denali-795:Door Number+Street+City+Postcode+State
    public static String tc795input = "21 Avenue de Nancy Metz 57000 Lorraine";
    public static String tc795expected = "21 Avenue de Nancy";

    // Denali-796:Door Number+Street+City+State+Postcode
    public static String tc796input = "21 Avenue de Nancy Metz Lorraine 57000";
    public static String tc796expected = "21 Avenue de Nancy";

    // Denali-804:Street with number
    public static String tc804input = "Via 1 Maggio Milan Italy";
    public static String tc804expected = "Via Prima Maggio Milan";

    // Denali-810:Lat/lon search - Special
    public static String tc810input = "49.825996, 4.547451";
    public static String tc810expected = "Murtin-et-Bogny, CHAMPAGNE-ARDENNE";

    // Denali-773:Alternate Name
    public static String[] tc773input = {"469 Fashion Ave, Manhattan, NY", "469 7th Ave, Manhattan, NY"};
    public static String[] tc773expected = {"469 Fashion Ave", "469 7th Ave"};

    // Denali-805:Street with order number
    public static String[] tc805input = {"1st St San Francisco, CA 94105", "First St San Francisco, CA 94105"};
    public static String tc805expected = "1st st | first st";


    //POI SEARCH MULTIBOX
    // Denali-2350:POI Category around me
    public static String tc2350origin = "51.5197502,-0.2772995";
    public static String tc2350fieldPOI = "Fuel";
    public static String tc2350fieldNear = "";
    public static String tc2350expected = "BP";

    // Denali-2351:POI name around me
    public static String tc2351origin = "51.5197502,-0.2772995";
    public static String tc2351fieldPOI = "Starbucks";
    public static String tc2351fieldNear = "";
    public static String tc2351expected = "Starbucks";

    // Denali-2353:POI name + City
    public static String tc2353origin = "51.5197502,-0.2772995";
    public static String tc2353fieldPOI = "Starbucks";
    public static String tc2353fieldNear = "Manchester";
    public static String tc2353expected = "Starbucks";

    // Denali-2352:POI Category + City
    public static String tc2352origin = "51.5197502,-0.2772995";
    public static String tc2352fieldPOI = "Coffee";
    public static String tc2352fieldNear = "Cluj-Napoca";
    public static String tc2352expected = "Q Caffe";

    // Denali-2355:POI name + street + City
    public static String tc2355origin = "51.5197502,-0.2772995";
    public static String tc2355fieldPOI = "zzz";
    public static String tc2355fieldNear = "zzz";

    // Denali-2354:POI Category + street + City
    public static String tc2354origin = "51.5197502,-0.2772995";
    public static String tc2354fieldPOI = "zzz";
    public static String tc2354fieldNear = "zzz";

    // Denali-2357:POI name + Street +Postcode
    public static String tc2357origin = "51.5197502,-0.2772995";
    public static String tc2357fieldPOI = "zzz";
    public static String tc2357fieldNear = "zzz";

    // Denali-2356:POI Category + Street +Postcode
    public static String tc2356origin = "51.5197502,-0.2772995";
    public static String tc2356fieldPOI = "zzz";
    public static String tc2356fieldNear = "zzz";

    // Denali-2359:POI name + Postcode + City
    public static String tc2359origin = "51.5197502,-0.2772995";
    public static String tc2359fieldPOI = "Starbucks";
    public static String tc2359fieldNear = "80333 Munich";
    public static String tc2359expected = "Starbucks";

    // Denali-2358:POI Category + Postcode + City
    public static String tc2358origin = "51.5197502,-0.2772995";
    public static String tc2358fieldPOI = "Fuel";
    public static String tc2358fieldNear = "80333 Munich";
    public static String tc2358expected = "Agip";

    // Denali-2361:POI name + Postcode + Country
    public static String tc2361origin = "51.5197502,-0.2772995";
    public static String tc2361fieldPOI = "Starbucks";
    public static String tc2361fieldNear = "80335 Germany";
    public static String tc2361expected = "Starbucks-München Hauptbahnhof-Plattform GF";

    // Denali-2360:POI Category + Postcode + Country
    public static String tc2360origin = "51.5197502,-0.2772995";
    public static String tc2360fieldPOI = "Fuel";
    public static String tc2360fieldNear = "80335 Germany";
    public static String tc2360expected = "Shell";


    //AUDIO GUIDANCE
    // Denali-2243:Start Route guidance-on route
    public static String tc2243origin = "51.2333, 6.7833";
    public static String tc2243destination = "51.235294, 6.784383";
    public static String tc2243expected[] = {"Guidance will start now"};

    // Denali-2244:Route Calculation failed
    public static String tc2244origin = "51.2333, 6.7833";
    public static String tc2244destination = "57.287540, 3.808549";
    public static String tc2244expected[] = {"Route calculation failed"};

    // Denali-2245:Continue on Local Street
    public static String tc2245origin = "41.874934, 12.466012";
    public static String tc2245destination = "41.890034, 12.474285";
    public static String tc2245expected[] = {"zzz", "", ""};

    // Denali-2247:Slight Right Turn on Local Street
    public static String tc2247origin = "48.115116, 11.746324";
    public static String tc2247destination = "48.115375, 11.749422";
    public static String tc2247expected[] = {"guidance will start now", "in (.*) turn slight right to Ringstraße", "turn slight right to Ringstraße"};

    // Denali-2246:Slight Left Turn on Local Street
    public static String tc2246origin = "48.101791, 11.723050";
    public static String tc2246destination = "48.104494, 11.721838";
    public static String tc2246expected[] = {"guidance will start now", "in (.*) turn slight left to Jagdfeldring", "turn slight left to Jagdfeldring"};

    // Denali-2248:Left Turn on Local Street
    public static String tc2248origin = "51.496732, 7.055231";
    public static String tc2248destination = "51.498964, 7.053658";
    public static String tc2248expected[] = {"guidance will start now", "in (.*) turn left to Alte Kirchstraße", "turn left to Alte Kirchstraße"};

    // Denali-2249:Right Turn on Local Street
    public static String tc2249origin = "51.491933, 7.053341";
    public static String tc2249destination = "51.493684, 7.055907";
    public static String tc2249expected[] = {"guidance will start now", "in (.*) turn right to Middeldorper Weg", "turn right to Middeldorper Weg"};

    // Denali-2250:Sharp Left Turn on Local Street
    public static String tc2250origin = "51.352166, 4.745729";
    public static String tc2250destination = "51.348290, 4.741192";
    public static String tc2250expected[] = {"guidance will start now", "in (.*) turn sharp left to Heerbaan", "turn sharp left to Heerbaan"};

    // Denali-2251:Sharp Right Turn on Local Street
    public static String tc2251origin = "51.351276, 4.742840";
    public static String tc2251destination = "51.352166, 4.745729";
    public static String tc2251expected[] = {"guidance will start now", "in (.*) turn sharp right to Merret", "turn sharp right to Merret"};

    // Denali-2252:U-turn
    public static String tc2252origin = "48.895940, 2.216085";
    public static String tc2252destination = "48.896294, 2.215146";
    public static String tc2252expected[] = {"guidance will start now", "in (.*) make a u-turn if possible", "make a u-turn if possible at Avenue Frédéric et Irène Joliot-Curie"};

    // Denali-2253:Ferry
    public static String tc2253origin = "50.794095,-1.101497";
    public static String tc2253destination = "50.728946,-1.068793";
    public static String tc2253expected[] = {"", "", "", ""};

    // Denali-2558:Roundabout 1st exit
    public static String tc2558origin = "49.795133, 9.942790";
    public static String tc2558destination = "49.797910, 9.945401";
    public static String tc2558expected[] = {"guidance will start now", "in (.*) enter the roundabout and ake the first exit to Martin-Luther-Straße", "take the first exit"};

    // Denali-2809:Roundabout 2nd exit
    public static String tc2809origin = "49.795133, 9.942790";
    public static String tc2809destination = "49.798922, 9.946818";
    public static String tc2809expected[] = {"guidance will start now", "in (.*) enter the roundabout and take the second exit", "in (.*) take the second exit to Schweinfurter Straße", "take the second exit"};

    // Denali-2810:Roundabout 3rd exit
    public static String tc2810origin = "49.795133, 9.942790";
    public static String tc2810destination = "49.800223, 9.943362";
    public static String tc2810expected[] = {"guidance will start now", "in (.*) enter the roundabout and take the third exit", "in (.*) take the third exit to Berliner Platz", "take the third exit"};

    // Denali-2811:Roundabout 4th exit
    public static String tc2811origin = "49.795133, 9.942790";
    public static String tc2811destination = "49.799716,9.939665";
    public static String tc2811expected[] = {"guidance will start now", "in (.*) enter the roundabout and take the fourth exit", "in (.*) take the fourth exit to Haugerring", "take the fourth exit"};

    // Denali-2812:Roundabout 5h exit
    public static String tc2812origin = "49.795133, 9.942790";
    public static String tc2812destination = "49.798082, 9.940074";
    public static String tc2812expected[] = {"guidance will start now", "in (.*) enter the roundabout and take the fifth exit", "in (.*) take the fifth exit (.*)", "take the fifth exit"};

    // Denali-2813:Roundabout 6th exit
    public static String tc2813origin = "49.800616, 9.943469";
    public static String tc2813destination = "49.798765, 9.945339";
    public static String tc2813expected[] = {"guidance will start now", "in (.*) take the sixth exit to Schweinfurter Straße", "take the sixth exit"};

    // Denali-2254:Roundabout
    public static String tc2254origin = "48.896957, 2.205394";
    public static String tc2254destination = "48.898117, 2.204890";
    public static String tc2254expected[] = {"guidance will start now", "turn right to Rue Gounod", "in (.*) enter the roundabout and take the first exit to Rue Pascal", "take the first exit"};

    // Denali-2255:Continuous Guidance - Motorway
    public static String tc2255origin = "48.755075, 2.345461";
    public static String tc2255destination = "48.754303,2.332064";
    public static String tc2255expected[] = {"zzz", "", "", "", "", "", ""};

    // Denali-2256:Continuous Guidance - Residential Roads
    public static String tc2256origin = "51.478684,6.999847";
    public static String tc2256destination = "51.479366,7.000920";
    public static String tc2256expected[] = {"guidance will start now", "turn left to Großenbruchstraße and then turn right"};

    // Denali-2257:Continuous Guidance - "turn right and then left
    public static String tc2257origin = "43.123948, 12.365654";
    public static String tc2257destination = "43.125769, 12.368690";
    public static String tc2257expected[] = {"guidance will start now", "in (.*) turn right to Strada Perugia-San Marco and then turn slight left"};

    // Denali-2560:Continuous guidance roundabout-and then turn right
    public static String tc2560origin = "49.79751875,9.9438909";
    public static String tc2560destination = "49.798618, 9.940261";
    public static String tc2560expected[] = {"guidance will start now", "take the fourth exit", "take the fourth exit and then turn right"};

    // Denali-2814:Continuous guidance roundabout-and then turn left
    public static String tc2814origin = "49.79751875,9.9438909";
    public static String tc2814destination = "49.797009, 9.941324";
    public static String tc2814expected[] = {"guidance will start now", "take the fifth exit", "take the fifth exit and then turn left"};

    // Denali-2565:Continuous guidance roundabout - highway entrance
    public static String tc2565origin = "49.753384, 9.847936";
    public static String tc2565destination = "49.748916, 9.819639";
    public static String tc2565expected[] = {"guidance will start now", "in (.*) enter the roundabout and take the (.*) to Anschlussstelle Würzburg/Kist"};

    // Denali-2566:Continuous guidance - residential road - with slight turn
    public static String tc2566origin = "49.846819, 10.048000";
    public static String tc2566destination = "49.845907, 10.050202";
    public static String tc2566expected[] = {"guidance will start now", "turn left to Mühlweg and then turn slight right"};

    // Denali-2576:Continous guidance on highway and then exit right
    public static String tc2576origin = "50.634675,3.395814";
    public static String tc2576destination = "50.628658,3.415697";
    public static String tc2576expected[] = {"guidance will start now", "in (.*) merge right to E forty two heading towards Tournai and then exit right"};

    // Denali-2577:Continous guidance on highway and then keep right
    public static String tc2577origin = "50.612493,3.318062";
    public static String tc2577destination = "50.615838,3.323368";
    public static String tc2577expected[] = {"guidance will start now", "keep left and then keep right"};

    // Denali-2578:Continous guidance on highway and then keep left
    public static String tc2578origin = "51.2980697,0.52279889";
    public static String tc2578destination = "51.2967565,0.5134161";
    public static String tc2578expected[] = {"guidance will start now", "exit left to Running Horse Roundabout and then keep left"};

    // Denali-2258:Motorway Entrance - slight right
    public static String tc2258origin = "46.403687,3.049165";
    public static String tc2258destination = "46.391866,3.033945";
    public static String tc2258expected[] = {"guidance will start now", "in (.*) turn slight right to N seventy nine", "turn slight right to N seventy nine"};

    // Denali-2259:Motorway Entrance - slight left
    public static String tc2259origin = "53.765355, -2.627164";
    public static String tc2259destination = "53.756673,-2.637696";
    public static String tc2259expected[] = {"guidance will start now", "in (.*) turn slight left to M6 (.*)", "turn slight left to M6 (.*)"};

    // Denali-2260:Motorway Entrance - turn right
    public static String tc2260origin = "50.898148,10.922158";
    public static String tc2260destination = "50.893974,10.912590";
    public static String tc2260expected[] = {"guidance will start now", "in (.*) turn right to A four towards Frankfurt a.M.", "in (.*) turn right to A four towards Frankfurt a.M.", "turn right to A four"};

    // Denali-2261:Motorway Entrance - turn left
    public static String tc2261origin = "54.332576,-2.626132";
    public static String tc2261destination = "54.334775,-2.619383";
    public static String tc2261expected[] = {"guidance will start now", "in (.*) turn left to M six (.*)", "turn left to M six (.*)"};

    // Denali-2584:Motorway entrance Sharp left turn
    public static String tc2584origin = "48.700102,2.306921";
    public static String tc2584destination = "48.704880,2.306262";
    public static String tc2584expected[] = {"guidance will start now", "in (.*) turn left to A six towards Paris", "in (.*) turn left to A six towards Paris and then you will arrive at your destination", "turn left to A six and then you will arrive at your destination"};

    // Denali-2267:Motorway-to-road Exit - Without Exit Number
    public static String tc2267origin = "50.920562,10.535604";
    public static String tc2267destination = "50.915104,10.550691";
    public static String tc2267expected[] = {"zzzz", "", "", ""};

    // Denali-2269:Motorway-to-road Exit - turn right
    public static String tc2269origin = "51.560412, 5.134142";
    public static String tc2269destination = "51.549531, 5.139989";
    public static String tc2269expected[] = {"zzz", "", "", ""};

    // Denali-2270:Motorway-to-road Exit - turn left
    public static String tc2270origin = "51.488207, -2.550624";
    public static String tc2270destination = "51.474086, -2.557145";
    public static String tc2270expected[] = {"zzz", "", "", ""};

    // Denali-2271:Motorway transition - without Exit number
    public static String tc2271origin = "49.560074, 10.982927";
    public static String tc2271destination = "49.566838, 10.991245";
    public static String tc2271expected[] = {"zzz", "", "", ""};

    // Denali-2272:Motorway transition - turn right with Exit number
    public static String tc2272origin = "41.821226, 12.415362";
    public static String tc2272destination = "41.822762, 12.391773";
    public static String tc2272expected[] = {"zzz", "", "", ""};

    // Denali-2273:Motorway transition - turn left with Exit number
    public static String tc2273origin = "53.783046, -1.556940";
    public static String tc2273destination = "53.784222, -1.531244";
    public static String tc2273expected[] = {"zzz", "", "", ""};

    // Denali-2559:Destination arrival message on the right
    public static String tc2559origin = "48.1495107,11.548144";
    public static String tc2559destination = "48.148929574,11.551056";
    public static String tc2559expected[] = {"guidance will start now", "in (.*) your destination is on your right", "you have reached your destination on your right"};

    // Denali-2815:Destination arrival message on the left
    public static String tc2815origin = "48.148210, 11.554814";
    public static String tc2815destination = "48.147995, 11.557169";
    public static String tc2815expected[] = {"guidance will start now", "in (.*) your destination is on your left", "you have reached your destination on your left"};

    // Denali-2569:Motorway to local road In distance exit right to street towards city
    public static String tc2569origin = "50.716866,4.587589";
    public static String tc2569destination = "50.706920,4.598103";
    public static String tc2569expected[] = {"guidance will start now", "in (.*) take exit on the right to Boulevard de l'Europe towards Ottigines-LLN", "in (.*) take exit on the right to Boulevard de l'Europe towards Ottigines-LLN and then keep right", "exit right to Boulevard de l'Europe and then keep right"};

    // Denali-2571:Motorway to local road In distance take exit number on the right to street towards city
    public static String tc2571origin = "49.525829,6.008364";
    public static String tc2571destination = "49.538036,6.028549";
    public static String tc2571expected[] = {"guidance will start now", "in (.*) take exit three on the right to Rue d'Europe towards Pontpierre", "in (.*) take exit three on the right to Rue d'Europe towards Pontpierre", "exit right to Rue d'Europe"};

    // Denali-2572:Motorway to local road In distance exit right to street
    public static String tc2572origin = "48.226842,11.565014";
    public static String tc2572destination = "48.227888,11.584625";
    public static String tc2572expected[] = {"guidance will start now", "in (.*) take exit on the right to Anschlussstelle München-Neuherberg"};

    // Denali-2573:Motorway to local road Exit right to street
    public static String tc2573origin = "44.574818,20.980574";
    public static String tc2573destination = "44.582451,20.987071";
    public static String tc2573expected[] = {"guidance will start now", "exit right to M twenty four"};

    // Denali-2579:Motorway to local exit left to street
    public static String tc2579origin = "51.493277398,-0.4230088";
    public static String tc2579destination = "51.4937809,-0.4101515";
    public static String tc2579expected[] = {"guidance will start now", "exit left to A three twelve"};

    // Denali-2580:Highway to Highway Merge right to street name heading towards city name
    public static String tc2580origin = "50.634611210,3.39941497";
    public static String tc2580destination = "50.630656647,3.41496448";
    public static String tc2580expected[] = {"guidance will start now", "merge right to E forty two towards Liège"};

    // Denali-2581:Highway to Highway Merge left to street name towards city name
    public static String tc2581origin = "50.634611210,3.39941497";
    public static String tc2581destination = "50.6336414777,3.416615514";
    public static String tc2581expected[] = {"guidance will start now", "merge left to E four twenty nine towards Bruxelles"};

    // Denali-2582:Ramp to ramp keep left at the exit
    public static String tc2582origin = "50.424766116,2.9834708";
    public static String tc2582destination = "50.41470887469,2.9848744";
    public static String tc2582expected[] = {"guidance will start now", "in (.*) keep left at exit"};

    // Denali-2583:Ramp to ramp keep right at the exit
    public static String tc2583origin = "50.41652114509,2.9854966";
    public static String tc2583destination = "50.42404539,2.9854376";
    public static String tc2583expected[] = {"guidance will start now", "in (.*) keep right at exit to Échangeur d'Hénin-Beaumont-Lens and then keep right",};


    //ADDRESS FORMAT
    // Denali-2825:French address format
    public static String tc2825origin = "48.1333, 11.5667";
    public static String tc2825search = "190 Rue de Rivoli Paris";
    public static String tc2825expected = "190 Rue de Rivoli 75001 Paris, France";

    // Denali-2826:UK address format
    public static String tc2826origin = "48.1333, 11.5667";
    public static String tc2826search = "27 Lothair road Liverpool";
    public static String tc2826expected = "27 Lothair Road, Liverpool, L4 0, United Kingdom";

    // Denali-2827:German address format
    public static String tc2827origin = "48.1333, 11.5667";
    public static String tc2827search = "Linienstrasse 65 Berlin";
    public static String tc2827expected = "Linienstrasse 65, 10119 Berlin, Germany";

    // Denali-2828:Finnish address format
    public static String tc2828origin = "48.1333, 11.5667";
    public static String tc2828search = "Kaivokatu 2 Helsinki";
    public static String tc2828expected = "Kaivokatu 2, 00100, Helsinki, Finland";

    // Denali-2829:Swedish address format
    public static String tc2829origin = "48.1333, 11.5667";
    public static String tc2829search = "Holmgatan 9, 211 45, malmo";
    public static String tc2829expected = "Holmgatan 9, 211 45 Malmo, Sweden";

    // Denali-2830:Norwegian address format
    public static String tc2830origin = "48.1333, 11.5667";
    public static String tc2830search = "Engene 43,3015 Drammen";
    public static String tc2830expected = "Engene 43, Drammen, Drammen, Norway";

    // Denali-2831:Danish address format
    public static String tc2831origin = "48.1333, 11.5667";
    public static String tc2831search = "Ostergade 38 kobenhavn";
    public static String tc2831expected = "Ostergade 38, 1100, Kobenhavn K, Copenhagen, Denmark";

    // Denali-2832:Belgian address format
    public static String tc2832origin = "48.1333, 11.5667";
    public static String tc2832search = "Hertogstraat 4 Brussels";
    public static String tc2832expected = "Hertogstraat 4, 1000, Brussels, Belgium";

    // Denali-2833:Dutch address format
    public static String tc283origin = "48.1333, 11.5667";
    public static String tc2833search = "Oudeschans 114 1011 LE";
    public static String tc2833expected = "Oudeschans 114, 1011 LE, Amsterdam, Netherlands";

    // Denali-2834:Louxembourg address format
    public static String tc2834origin = "48.1333, 11.5667";
    public static String tc2834search = "Rue Lemire 4 Luxembourg";
    public static String tc2834expected = "4 Rue Lemire, 1927, Luxembourg, Luxembourg";

    // Denali-2835:italian address format
    public static String tc2835origin = "48.1333, 11.5667";
    public static String tc2835search = "Via del Carmine 2 Milan";
    public static String tc2835expected = "Cia del Carmine 2, 20121 Milan MI, Italy";

    // Denali-2836:Spanish address format
    public static String tc2836origin = "48.1333, 11.5667";
    public static String tc2836search = "Paseo de la Castellana 142 Madrid";
    public static String tc2836expected = "Paseo de la Castellana 142, 28046, Madrid (Madrid), Spain";

    // Denali-2837:Portugal address format
    public static String tc2837origin = "48.1333, 11.5667";
    public static String tc2837search = "Rua do Telhal 50, Lisboa";
    public static String tc2837expected = "Rua do Telhal 50, 1150-346 Lisbon, Portugal";

    // Denali-2838:Slovenian address format
    public static String tc2838origin = "48.1333, 11.5667";
    public static String tc2838search = "Samova ulica 25 Ljubljana";
    public static String tc2838expected = "Samova ulica 25, 1000 Ljubljana, Slovenia";

    // Denali-2839:Slovak address format
    public static String tc2839origin = "48.1333, 11.5667";
    public static String tc2839search = "";
    public static String tc2839expected = "";
}
