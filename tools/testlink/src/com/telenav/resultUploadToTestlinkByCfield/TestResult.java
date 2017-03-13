package com.telenav.resultUploadToTestlinkByCfield;

public class TestResult {
    private String testResultDir;
	private String customFieldName;
	private String customFieldValue;
	private String projectName;
	private String testPlanName;
	private String buildName;
	private String resultStatus;
	private String testCaseName;
	private boolean onlyUploadPassCases;

	/**
	 * returns test result directory
	 * @return custom field name
	 */
	public String getTestResultDir() {
		return this.testResultDir;
	}

	/**
	 * returns custom field name
	 * @return custom field name
	 */
	public String getCustomFieldName() {
		return this.customFieldName;
	}

	/**
	 * returns custom field value
	 * @return custom field value
	 */
	public String getCustomFieldValue() {
		return this.customFieldValue;
	}

	/**
	 * returns project name
	 * @return project name
	 */
	public String getProjectName() {
		return this.projectName;
	}

	/**
	 * returns test plan name
	 * @return test plan name
	 */
	public String getTestPlanName() {
		return this.testPlanName;
	}

	/**
	 * returns test build name
	 * @return test build name
	 */
	public String getBuildName() {
		return this.buildName;
	}

	/**
	 * returns test result status
	 * @return test result status
	 */
	public String getResultStatus() {
		return this.resultStatus;
	}

	/**
	 * returns only Upload Pass Cases flag
	 * @return only Upload Pass Cases flag value
	 */
	public boolean getOnlyUploadPassCases() {
		return this.onlyUploadPassCases;
	}

	/**
	 * Set test result directory
	 * @return void
	 */
	public void setTestResultDir(String testResultDir) {
		this.testResultDir = testResultDir;
	}

	/**
	 * Set custom Field name
	 * @return void
	 */
	public void setCustomFieldName(String customFieldName) {
		this.customFieldName = customFieldName;
	}

	/**
	 * Set custom Field value
	 * @return void
	 */
	public void setCustomFieldValue(String customFieldValue) {
		this.customFieldValue = customFieldValue;
	}

	/**
	 * Set project name
	 * @return void
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Set test plan name
	 * @return void
	 */
	public void setTestPlanName(String testPlanName) {
		this.testPlanName = testPlanName;
	}

	/**
	 * Set test build name
	 * @return void
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * Set result status
	 * @return void
	 */
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	public String getTestCaseName() {
		return this.testCaseName;
	}

	/**
	 * Set only Upload Pass Cases flag
	 * @return void
	 */
	public void setOnlyUploadPassCases(boolean onlyUploadPassCases) {
		this.onlyUploadPassCases = onlyUploadPassCases;
	}
}
