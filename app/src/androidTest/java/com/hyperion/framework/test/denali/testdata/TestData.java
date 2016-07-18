package com.hyperion.framework.test.denali.testdata;

public class TestData {
    //category
    public static final String DISTANCE_REGEXP = "[0-9]{1,4}(\\.[0-9])? mi|[0-9]{1,3} ft|[0-9]{1,4}(\\.[0-9])? km|[0-9]{1,3} m";
    public static final String ADDRESS_REGEXP = ".+";
    public static final String NO_EMPTY_REGEXP = ".+";
    public static final int PAGE_NUMBER = 5;
    /*****************
     * COMMON
     ***********************/
    public static String OfficeLatLon = "37.37890,-122.01074";
    public static String originFromLocation = "37.789060, -122.402077";
    public static String originAtGM = "42.329645, -83.039008";
    public static String sfoLatLon = "37.616924, -122.384481";
    public static int DistanceToDestination = 300; // ft as unit
    public static float distanceInAArea = 6;
    public static int autozoomMatrix = 700;
    public static int count = 20;
    public static String separator = ",";
    public static String Or = "|";
    public static String And = "&";
    //////////////// setting page//////////////////
    public static String mapColor = "keyMapColorSetting";
    public static String auto = "auto";
    public static String bright = "day";
    public static String dark = "night";
    public static String homePref = "KeyHomeAndWorkSetting";
    public static String showMyPlace = "keyShowMyPlacesBubble";
    public static String homeAddr = "keySetHomeAddress";
    public static String workAddr = "KeySetWorkAddress";
    public static String dr2Home = "keySetHomeButton";
    public static String dr2KeyAddr = "keySetWorkButton";
    public static String edithome = "edit home address label";
    public static String editwork = "edit work address label";
    public static String editcustom = "edit key address label";
    public static String navPref = "keyNavigationPreferences";
    public static String navVoicePref = "keyNavigationVoiceControl";
    public static String predictiveNavPref = "keyAutoLearningPreference";
    public static String routeType = "keyRouteTypePreference";
    public static String fastest = "Fastest";
    public static String fastest_route_response = "(.*)Routing service request returned! route style: FASTEST(.*)";
    public static String eco_route_response = "(.*)Routing service request returned! route style: ECO(.*)";
    public static String eco_route_response_with_one_waypoint = "(.*)Routing service request returned! route style: ECO(.*)way points: 1";
    public static String eco_route_response_without_waypoint = "(.*)Routing service request returned! route style: ECO(.*)way points: 0";
    public static String automation_log_format = "INSTRUMENTATION_STATUS";
    public static String shortest = "Shortest";
    public static String eco = "ECO";
    public static String avoidOnRoute = "keyRouteAvoidance";
    public static String highway = "keyFreeways";
    public static String TollRoad = "keyTollRoads";
    public static String UnpavedRoad = "keyUnpavedRoads";
    public static String Tunnel = "keyTunnels";
    public static String HOVLane = "keyHOVLanes";
    public static String CountryBorder = "keyCountryBorders";
    public static String ferry = "keyFerries";
    public static String unit = "keyUnitSetting";
    public static String mile = "keyUnitImperial";
    public static String km = "keyUnitMetric";
    public static String Bld3d = "keyShowBuildingIn3DMode";
    public static String alertPref = "keyContentAndAlertPreference";
    public static String schoolzone = "keyPlayAlertApproachSchool";
    public static String railroad = "keyPlayAlertApproachRoadSafety";
    public static String speedCamera = "keyPlayAlertApproachCamera";
    public static String speedCamera_cn = "keyPlayAlertApproachTrafficCamera";
    public static String roadSafety = "keyPlayAlertApproachRoadSafety";
    public static String historyPref = "keyHistoryManagerPreference";
    public static String clearRecentDest = "keyClearRecentDestinations";
    public static String clearSearch = "keyClearRecentSearch";
    public static String mapUpdate = "keyMapUpdatesPreference";
    public static String termAndConditions = "keyTermAndConditions";
    public static String privacyStatement = "keyPrivacyStatement";
    public static String mapConfig = "keyMapConfiguration";
    public static String about = "keyAbout";
    /******************
     * Map Option
     *********************/
    public static String traffic = "keyTrafficInfoSetting";
    public static String trafficFlow = "keyTrafficFlowOption";
    public static String trafficOn = "keyTrafficOn";
    public static String autoZoom = "keyEnableAutoZoom";
    public static String m3Dlandmarks = "Show3DLandmarks";
    public static String m3Dbuildings = "Show3DBuildings";
    public static String m3DHeading = "keySet3DHeadingUp";
    public static String m2DHeading = "keySet2DHeadingUp";
    public static String m2DNorth = "keySet2DNorthUp";
    public static String editDestinations = "keyEditDestinations";
    /******************
     * POI on MAP & Hot Catogery
     *****************/
    //Text
//	public static String Favorite = "Favorites";
//	public static String Recent = "Recents";
//	public static String Food = "Food";
//	public static String Coffee = "Coffee";
//	public static String Lodging = "Lodging";
//	public static String Fuel = "Fuel";
//	public static String Shopping = "Shopping";
//	public static String Parking = "Parking";
//	public static String Dealerships = "Dealerships";
//	public static String Transit = "Transit";
//	public static String ATM = "Bank/ATMs";
//	public static String Attractions = "Attractions";
//	public static String Health = "Health";
//	public static String Entertainment = "Entertainment";
//	public static String Leisure = "Leisure";
//	public static String RestArea = "Rest Area";
//	public static String Emergency = "Emergency";
//
//	public static String Restaurant = "Restaurant";
//	public static String Movies = "Movies";
//	public static String Airports = "Airports";
//	public static String Bars = "Bars";
//	public static String fastFood = "Fast Food";
    //Content description
    public static String Favorite = "favorite";
    public static String Recent = "recent";
    public static String Food = "poiFood";
    public static String FastFood = "poiFastFood";
    public static String Coffee = "poiCoffee";
    public static String Lodging = "poiLodging";
    public static String Fuel = "poiGas";
    public static String Shopping = "poiShopping";
    public static String Parking = "poiParking";
    public static String Dealerships = "poiGmDealership";
    public static String Transit = "poiTransit";
    public static String ATM = "poiFinancial";
    public static String Attractions = "poiAttractions";
    public static String Health = "poiHealth";
    public static String Entertainment = "poiEntertainment";
    public static String Leisure = "poiLeisure";
    public static String RestArea = "Rest Area";
    public static String Emergency = "poiEmergency";
    public static String ATMOnMap = "poiATM";
    //Food subcategory
    public static String Restaurant = "poiRestaurant";
    public static String Bars = "poiBar";
    public static String Bakeries = "poiBakery";

    //Fuel subcategory
//	public static String CNG = "poiCNGStations";   EU only
//	public static String LPG = "poiLPGStations";   EU only
    public static String IceCream = "poiIceCream";
    public static String Pizza = "poiPizza";
    public static String Hamburgers = "poiHamburgers";
    public static String Barbecue = "poiBarbecue";
    //Shopping subcategory
    public static String Grocery = "poiGrocery";
    public static String ConvenienceStore = "poiConvenienceStore";
    public static String ShoppingCenter = "poiShoppingCenter";
    public static String DepartmentStore = "poiDepartmentStore";
    public static String ConsumerElectronics = "poiConsumerElectronics";
    public static String HomeImprovement = "poiHomeImprovement";
    public static String BookStore = "poiBookStore";
    //Parking subcategory
    public static String ParkingLot = "poiParkingLot";
    public static String ParkingGarage = "poiParkingGarage";
    public static String ParkAndRide = "poiParkAndRide";
    //Transit subcategory
    public static String Airport = "poiAirport";
    public static String Railway = "poiRailwayStation";
    public static String LocalTransitStop = "poiLocalTransitStop";
    public static String BusStation = "poiBusStation";
    public static String FerryTerminal = "poiFerryTerminal";
    public static String CarRental = "poiCarRental";
    //Lodging subcategory
    public static String Hotel = "poiHotels";
    public static String BedAndBreakfast = "poiBedAndBreakfast";
    //ATM subcategory
    public static String Bank = "poiBanks";
    //Attractions subcategory
    public static String Park = "poiParks";
    public static String TouristAttraction = "poiTouristAttraction";
    public static String Museum = "poiMuseum";
    public static String HistoricalSite = "poiHistoricalSite";
    public static String AmusementPark = "poiAmusementPark";
    //Health subcategory
    public static String Pharmacy = "poiPharmacy";
    public static String Hospital = "poiHospital";
    public static String MedicalService = "poiMedicalService";
    //Entertainment subcategory
    public static String MovieTheater = "poiMovie";
    public static String NightClub = "poiNightClub";
    public static String PerformingArts = "poiPerformingArts";
    public static String Casino = "poiCasino";
    //Leisure subcategory
    public static String FitnessCenter = "poiFitnessCenter";
    public static String SportsCenter = "poiSportCenter";
    public static String SwimmingPool = "poiSwimmingPool";
    public static String Campground = "poiCamping";
    public static String Beaches = "poiBeach";
    public static String RecreationCenter = "poiRecreationCenter";
    public static String Golf = "poiGolf";
    public static String Tennis = "poiTennis";
    public static String SkiResort = "poiSkiResort";
    //Emergency subcategory
    public static String EmergencyCenter = "poiEmergencyCenter";
    public static String PoliceStation = "poiPoliceStation";
    public static String TowingService = "poiTowingService";
    public static String Movies = "Movies";
    public static String Airports = "Airports";
    public static String Places = "places";
}
