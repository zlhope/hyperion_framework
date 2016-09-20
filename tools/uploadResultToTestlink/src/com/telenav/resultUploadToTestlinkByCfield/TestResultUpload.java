package com.telenav.resultUploadToTestlinkByCfield;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.telenav.resultUploadToTestlinkByCfield.DBUtil;

public class TestResultUpload {
	// Stage APIKey
//	private final String devKey = "92f8b6e291c7df5c902656948c218bc3";
	// Production APIKey
	private final String devKey = "fa9e4c74ed29cf008ea9e15d7dfdedef";
	private XmlRpcClient rpcClient;
	private XmlRpcClientConfigImpl config;
	
	public TestResultUpload() throws MalformedURLException {
		config = new XmlRpcClientConfigImpl();
		// Stage APIKey
//		config.setServerURL(new URL("http://tlstage.telenav.com/lib/api/xmlrpc.php"));
		// Production APIKey
		config.setServerURL(new URL("http://testlink.telenav.com/lib/api/xmlrpc/v1/xmlrpc.php"));
		rpcClient = new XmlRpcClient();
		rpcClient.setConfig(config);
	}
	
	public Object[] getBuildsForTestPlan(Integer testPlanId) {
		Object[] latestBuild = null;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_PLAN_ID, testPlanId);
		params.add(executionData);
		
		try {
			if (rpcClient.execute("tl.getBuildsForTestPlan", params) != null &&
					!"".equals(rpcClient.execute("tl.getBuildsForTestPlan", params))) {
				latestBuild = (Object[]) rpcClient.execute("tl.getBuildsForTestPlan", params);				
			}
		} catch (Exception e) {
			System.out.println("Exception of getting builds for test plan id - " +
					String.valueOf(testPlanId) + " in testlink!");
			e.printStackTrace();
		}
		
		return latestBuild;
	}
	
	public HashMap getLatestBuildForTestPlan(Integer testPlanId, Integer testBuildId) {
		HashMap latestBuild = null;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_PLAN_ID, testPlanId);
		if(testBuildId != 0){
			executionData.put(TestResultConstants.BUILD_ID, testBuildId);
		}
		params.add(executionData);
		
		try {
			latestBuild = (HashMap) rpcClient.execute("tl.getLatestBuildForTestPlan", params);
			if (latestBuild == null) {
				System.out.println("There is no build for test plan - " + testPlanId);
			}
		} catch (Exception e) {
			System.out.println("Cannot get latest build in testlink!");
			e.printStackTrace();
		}
		
		return latestBuild;
	}
	
	public int createBuild(Integer testPlanId,
			String buildName, String buildNotes) {
		int buildID = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_PLAN_ID, testPlanId);
		executionData.put(TestResultConstants.BUILD_NAME, buildName);
		executionData.put(TestResultConstants.BUILD_NOTES, buildNotes);
		params.add(executionData);
	    
		Object[] result;
		try {
			result = (Object[]) rpcClient.execute("tl.createBuild", params);
			for (int i = 0; i < result.length; i++) {
				Map item = (Map) result[i];
				if (item.get("id") != null) {
					buildID = Integer.parseInt((String) item.get("id"));
				}
			}
		} catch (Exception e) {
			System.out.println("Cannot create new build in testlink!");
			e.printStackTrace();
		}
		
		return buildID;
	}
	
	public void copy_assignments(int source_build_id, int target_build_id, Connection connection) {
		String Script = "INSERT INTO user_assignments" +
						"       (type, feature_id, user_id, deadline_ts," +
						"        assigner_id, creation_ts, status, build_id)" +
						"SELECT type, feature_id, user_id, deadline_ts," +
						"       assigner_id, SYSDATE(), status," + String.valueOf(target_build_id) +
						"  FROM user_assignments" +
						" WHERE build_id = " + String.valueOf(source_build_id);
		
		try {
			int insertRows = DBUtil.insertDataByPstmt(Script, connection);
			if (insertRows > 0) {
				System.out.println("Test assignment copy is successfully!");
			}
		} catch (Exception e) {
			System.out.println("SQL Insert Exception of copy_assignments!");
			e.printStackTrace();
		}
	}
	
	public int[] getFeatureIDForTestPlan(int testPlanId, Connection connection) {
		int[] featureID = null;
		ResultSet rs = null;
		String query = "SELECT id AS feature_id " +
		               "  FROM testplan_tcversions " +
		               " WHERE testplan_id = " + String.valueOf(testPlanId);
		
		try {
			int i = 0;
			rs = DBUtil.getResultByPstmt(query, connection);
			if (rs != null) {
				rs.last();
				int count = rs.getRow();
				if (count > 0){
					featureID = new int[count];
					rs.beforeFirst();
					while (rs.next()) {
						featureID[i] = rs.getInt(1);
						i++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("SQL ResultSet Extraction Exception of " +
					"getFeatureIDForTestPlan!");
			e.printStackTrace();
		}
		
		return featureID;
	}
	
	public void createAssignments(int[] featureId, int buildId, int testerId,
			Connection connection) {
		String sql = "INSERT INTO user_assignments VALUES " +
				     "(NULL, 1, ?, ?, NULL, 765, SYSDATE(), 1, ?)";
		
		try {
			for (int i = 0; i < featureId.length; i++) {
				int result = DBUtil.createAssginments(sql, featureId[i],
						buildId, testerId, connection);
				if (result > 0) {
					System.out.println("create assignment successfully - " +
							String.valueOf(featureId[i]) + "!");
				} else if (result == 0) {
					System.out.println("create assignment failed - " +
							String.valueOf(featureId[i]) + "!");
				}
			}
		} catch (Exception e) {
			System.out.println("SQL Insert Exception of createAssignments!");
			e.printStackTrace();
		}
	}
	
	public String getLatestBuildNameForTestPlan(String testProjectName,
			String testPlanName, String testBuildName) throws Exception {
		String buildName = null;
		int testPlanId = getTestPlanID(testPlanName, testProjectName);
		int testBuildId = getBuildID(testPlanId, testBuildName);
		HashMap latestBuild = null;
		if (getBuildsForTestPlan(testPlanId) != null) {
			latestBuild = getLatestBuildForTestPlan(testPlanId, testBuildId);
		} else {
			throw new Exception("There is no latest build of test plan - " +
					testPlanName);
		}
		if (latestBuild != null) {
			buildName = getlatestBuildName(latestBuild);
		}
		
		return buildName;
	}
	
	public void createBuildAndAssginment(String testProjectName,
			String testPlanName, String buildName, Connection connection)
			throws Exception {
		int testPlanId = getTestPlanID(testPlanName, testProjectName);
		int testBuildId = getBuildID(testPlanId, buildName);
		HashMap latestBuild = null;
		int targetBuildID;
		int[] featureID;
		// get and check the latest test build if there is build in test plan
		// create assginments for the new build if new build is created
		if (getBuildsForTestPlan(testPlanId) != null) {
			latestBuild = getLatestBuildForTestPlan(testPlanId, testBuildId);
			// check if the new build name is duplicate
			if (latestBuild != null) {
				int latestBuildID = getlatestBuildID(latestBuild, buildName);
				if (latestBuildID != 0) {
					targetBuildID = createBuild(testPlanId, buildName, "");
					featureID = getFeatureIDForTestPlan(testPlanId, connection);
					createAssignments(featureID, targetBuildID, 765, connection);
				}
			}
		// directly create build if there is no build in test plan
		} else {
			targetBuildID = createBuild(testPlanId, buildName, "");
			featureID = getFeatureIDForTestPlan(testPlanId, connection);
			createAssignments(featureID, targetBuildID, 765, connection);
		}
	}
	
	public boolean checkBuildNotExist(String testProjectName,
			String testPlanName, String buildName, Connection connection)
			throws Exception {
		int testPlanId = getTestPlanID(testPlanName, testProjectName);
		int testBuildId = getBuildID(testPlanId, buildName);
		HashMap latestBuild = null;

		// build doesn't exists
		boolean flag = false;
		// get and check the latest test build if there is build in test plan
		// create assginments for the new build if new build is created

		if(testBuildId == 0){
		    flag = true;
		}
		
		return flag;
	}
	
	public int getTestCaseID(String testCaseName, String testSuiteName,
			String testProjectName, String testCasePathName) {
		int testCaseID = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_CASE_NAME, testCaseName);
		executionData.put(TestResultConstants.TEST_SUITE_NAME, testSuiteName);
		executionData.put(TestResultConstants.TEST_PROJECT_NAME, testProjectName);
		executionData.put(TestResultConstants.TEST_CASE_PATH_NAME, testCasePathName);
		params.add(executionData);
	    
		Object[] result;
		try {
			result = (Object[]) rpcClient.execute(
					"tl.getTestCaseIDByName", params);
			for (int i = 0; i < result.length; i++) {
				Map item = (Map) result[i];
				if (item.get("id") != null) {
					testCaseID = Integer.parseInt((String) item.get("id"));					
				}
			}
		} catch (Exception e) {
			System.out.println("Cannot find relevant test case in testlink!");
			e.printStackTrace();
		}
		
		return testCaseID;
	}
	
	public int[] getTestCaseVersionIdByCfield(String customFieldName,
			String customFiledValue, Connection connection) {
		int[] tcversionID = null;
		ResultSet rs = null;
		String query = "SELECT cdv.node_id AS tcversion_id " +
		               "  FROM custom_fields cf, " +
		               "       cfield_design_values cdv " +
		               " WHERE cf.id = cdv.field_id " +
		               "   AND cf.name = '" + customFieldName + "'" +
		               "   AND cdv.value = '" + customFiledValue + "'";
		
		try {
			int i = 0;
			rs = DBUtil.getResultByPstmt(query, connection);
			if (rs != null) {
				rs.last();
				int count = rs.getRow();
				if (count > 0){
					tcversionID = new int[count];
					rs.beforeFirst();
					while (rs.next()) {
						tcversionID[i] = rs.getInt(1);
						i++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("SQL ResultSet Extraction Exception of " +
					"getTestCaseVersionIdByCfield!");
			e.printStackTrace();
		}
		
		return tcversionID;
	}
	
	public int getProjectID(String projectName) {
		int projectID = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_PROJECT_NAME, projectName);
		params.add(executionData);
		
		Map result;
		try {
			result = (HashMap) rpcClient.execute(
					"tl.getTestProjectByName", params);
			Iterator iter = result.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (key.equals("id")) {
					projectID = Integer.valueOf(val.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("Cannot get relevant test project id in testlink!");
			e.printStackTrace();
		}
		
		return projectID;
	}
	
	public int getTestPlanID(String testPlanName, String projectName) {
		int testPlanID = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_PLAN_NAME, testPlanName);
		executionData.put(TestResultConstants.TEST_PROJECT_NAME, projectName);
		params.add(executionData);
	    
		Object[] result;
		try {
			result = (Object[]) rpcClient.execute(
					"tl.getTestPlanByName", params);
			for (int i = 0; i < result.length; i++) {
				Map item = (Map) result[i];
				if (item.get("id") != null) {
					testPlanID = Integer.parseInt((String) item.get("id"));					
				}
			}
			
			if(testPlanID == 0){
			    System.out.println("======================Warning! Can't find plan id!=======================");
			}
			
		} catch (Exception e) {
			System.out.println("Cannot get relevant test plan id in testlink!");
			e.printStackTrace();
		}
		
		return testPlanID;
	}
	
	public int getBuildID(Integer testPlanId, String buildName) {
		int buildID = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_PLAN_ID, testPlanId);
		params.add(executionData);
	    
		Object[] result;
		try {
			result = (Object[]) rpcClient.execute(
					"tl.getBuildsForTestPlan", params);
			for (int i = 0; i < result.length; i++) {
				Map item = (Map) result[i];
				if (item.get("id") != null && buildName.equals(item.get("name"))) {
					buildID = Integer.parseInt((String) item.get("id"));		
				}
			}
		} catch (Exception e) {
			System.out.println("Cannot get relevant build id in testlink!");
			e.printStackTrace();
		}
		
		return buildID;
	}
		
	public int setTestCaseExecutionResult(Integer testCaseId,
			Integer testCaseExternalId, Integer testPlanId, String status,
			Integer buildId, String buildName, String notes, Boolean guess,
			String bugId, Integer platformId, String platformName,
			Map customFields, Boolean overwrite) {
		int uploadResult = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		Hashtable<String, Object> executionData = new Hashtable<String, Object>();
		executionData.put(TestResultConstants.DEV_KEY, devKey);
		executionData.put(TestResultConstants.TEST_CASE_ID, testCaseId);
		executionData.put(TestResultConstants.TEST_CASE_EXTERNAL_ID, testCaseExternalId);
		executionData.put(TestResultConstants.TEST_PLAN_ID, testPlanId);
		executionData.put(TestResultConstants.STATUS, status);
		executionData.put(TestResultConstants.BUILD_ID, buildId);
		executionData.put(TestResultConstants.BUILD_NAME, buildName);
		executionData.put(TestResultConstants.NOTES, notes);
		executionData.put(TestResultConstants.GUESS, guess);
		executionData.put(TestResultConstants.BUG_ID, bugId);
		executionData.put(TestResultConstants.PLATFORM_ID, platformId);
		executionData.put(TestResultConstants.PLATFOR_NAME, platformName);
		if (customFields == null) {
			executionData.put(TestResultConstants.CUSTOM_FIELDS, "");
		} else {
			executionData.put(TestResultConstants.CUSTOM_FIELDS, customFields);	    	  
		}
		executionData.put(TestResultConstants.OVERWRITE, overwrite);
		params.add(executionData);
	    
		Object[] result;
		try {
			result = (Object[]) rpcClient.execute("tl.setTestCaseExecutionResult", params);
			for (int i=0; i< result.length; i++)
			{
				Map item = (Map)result[i];
				if (item.get("message") != null && "Success!".equals(item.get("message"))) {
					uploadResult = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Result Upload Exception in calling API!");
	    	e.printStackTrace();
		}
		
		return uploadResult;
	}
	
	public boolean uploadTestResult(String projectName, String testPlanName,
			String buildName, String customFieldName, String customFieldValue,
			String resultStatus, Connection connection)
			throws Exception {
		boolean successfulUpload = true;
		int[] testCaseVersionID  = getTestCaseVersionIdByCfield(customFieldName, customFieldValue, connection);
		int testCaseID = 0;
		if (testCaseVersionID != null) {
			int testPlanID = getTestPlanID(testPlanName, projectName);
			if (testPlanID != 0) {
				testCaseID = checkTestCase(testCaseVersionID, testPlanID, connection);
				if (testCaseID != 0) {
					int buildID = getBuildID(testPlanID, buildName);
					if (buildID != 0) {
						int uploadResult = setTestCaseExecutionResult(testCaseID, 0,
								testPlanID, resultStatus, buildID, "", "", false, "", 0, "", null, false);
						if (uploadResult == 1) {
							System.out.println("The test execution result upload of test case: "
									+ customFieldValue + " - " + testCaseID + " is successful!\n");
						} else {
							successfulUpload = false;
							System.out.println("The test execution result upload of test case: "
									+ customFieldValue + " - " + testCaseID + " is fail!\n");
						}
					} else {
						successfulUpload = false;
						throw new Exception("The build - " + buildName
								+ " does not exist!\n");
					}
				} else {
					successfulUpload = false;
					System.out.println("No custom field matches project - "
							+ projectName + " - " + customFieldValue + "!\n");
				}
			} else {
				successfulUpload = false;
				throw new Exception("The test plan - " + testPlanName
						+ " does not exist!\n");
			}
		} else {
			successfulUpload = false;
			System.out.println("The relevant test case for custom field value - " + customFieldValue +
					" does not exist!\n");
		}

		return successfulUpload;
	}
	
	private int getlatestBuildID(HashMap latestBuild, String buildName)
			throws Exception {
		int latestBuildID = 0;
		String latestBuildName = latestBuild.get("name").toString();
		if (buildName.equalsIgnoreCase(latestBuildName)) {
			System.out.println("Same build!");
			//throw new Exception("Cannot create new build because of duplicate build name!");
		} else {
			latestBuildID = Integer.valueOf((String) latestBuild.get("id"));
		}

		return latestBuildID;
	}
	
	private String getlatestBuildName(HashMap latestBuild) throws Exception {
		String latestBuildName = null;
		latestBuildName = latestBuild.get("name").toString();

		return latestBuildName;
	}

	private int checkTestCase(int[] testCaseVersionID, int testPlanID,
			Connection connection) {
		int uniqueTestCaseID = 0;
		ResultSet rs = null;
		
		StringBuffer tcversionStringBuffer = new StringBuffer();
		for(int i = 0; i < testCaseVersionID.length; i++){
			tcversionStringBuffer.append(String.valueOf(testCaseVersionID[i]) + ", ");
		}
		String tcversionConditionString = removeTailComa(tcversionStringBuffer.toString());
		
		String query = "SELECT NH.parent_id " +
		               "  FROM nodes_hierarchy NH, testplan_tcversions TPTC " +
		               " WHERE NH.id = TPTC.tcversion_id " +
		               "   AND TPTC.testplan_id = " + String.valueOf(testPlanID) +
		               "   AND TPTC.tcversion_id IN (" + tcversionConditionString + ")";
		
		try {
			rs = DBUtil.getResultByPstmt(query, connection);
			if (rs != null) {
				while (rs.next()) {
					uniqueTestCaseID = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			System.out.println("SQL ResultSet Extraction Exception of checkTestCase!");
			e.printStackTrace();
		}
		
		return uniqueTestCaseID;
	}
	
	private String removeTailComa(String str){
		if(!str.substring(str.length() - 2).equals(", ")){
			return str;
		}else{
			return removeTailComa(str.substring(0, str.length() - 2));
		}
	}
}
