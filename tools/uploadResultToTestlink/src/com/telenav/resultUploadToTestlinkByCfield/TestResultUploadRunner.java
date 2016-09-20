package com.telenav.resultUploadToTestlinkByCfield;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TestResultUploadRunner {
	private static final int STATUS_OK = 0;
	private static final int STATUS_EXCEPTION = -1;
	private String testResultDir;
	private String projectName;
	private String testPlanName;
	private String buildName;
	private String customFieldName;
	private boolean onlyUploadPassCases;
	
	public String getTestResultDir() {
		return this.testResultDir;
	}
	
	public void setTestResultDir(String testResultDir) {
		this.testResultDir = testResultDir;
	}
	
	public void runUpload(){
		try {
			TestResultParser testResultParser = new TestResultParser(
					testResultDir, projectName, testPlanName, buildName,
					customFieldName, onlyUploadPassCases);
			boolean successfulUpload = testResultParser.parse();
			if (successfulUpload) {
				System.out.println("*****************Result Upload for all test cases is successful!****************");
			} else {
				System.out.println("*************Result Upload for some cases is failed, please check!**************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	public int parseParameters (String[] args) {
		if (args.length != 5 && args.length != 6) {
			System.out.println("The parameter numbers are not correct, please check it!");
			return STATUS_EXCEPTION;
		} else {
			testResultDir = args[0];
			projectName = args[1];
			testPlanName = args[2];
			customFieldName = args[3];
			onlyUploadPassCases = Boolean.valueOf(args[4].toString().toLowerCase().trim());
			if (onlyUploadPassCases) {
				System.out.println("##################The upload mode is only upload passed cases!##################");
			}
			if (args.length == 5) {
				buildName = "";
			} else {
				//buildName = args[5] + "_" + getCurrentTimeString();
                buildName = args[5];
			}
		}
		
		return STATUS_OK;
	}
	
	private String getCurrentTimeString() {
		String datetimeString;
		
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		datetimeString = formatter.format(currentTime);
		
		return datetimeString;
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		TestResultUploadRunner runner = new TestResultUploadRunner();
		int nStatus = runner.parseParameters(args);
		if (STATUS_OK == nStatus) {
			runner.runUpload();
		}
	}
}
