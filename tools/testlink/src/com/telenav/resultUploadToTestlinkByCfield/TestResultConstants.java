package com.telenav.resultUploadToTestlinkByCfield;

public class TestResultConstants {
	public static final String HTML_FILE_PATTERN = "*.html";
	// HTML result constants
	public static final String HTML_RESULT_LINE_BEGIN = "<td><a href=";
	public static final String HTML_RESULT_TAG = "a";
	public static final String HTML_CFIELD_TAG_NAME = "name";
	public static final int CFIELD_ATTRIBUTE_POSITION = 1;
	public static final String HTML_SUCCESS_RESULT_STATUS = "<td>Success</td>";
	public static final String HTML_WARNING_RESULT_STATUS = "<td>Warning</td>";
	public static final String HTML_FAILURE_RESULT_STATUS = "<td>Failure</td>";
	public static final String HTML_ERROR_RESULT_STATUS = "<td>Error</td>";
	// Testlink API constants
	public static final String DEV_KEY = "devKey";
	public static final String TEST_PLAN_ID = "testplanid";
	public static final String TEST_PLAN_NAME = "testplanname";
	public static final String BUILD_ID = "buildid";
	public static final String BUILD_NAME = "buildname";
	public static final String BUILD_NOTES = "buildnotes";
	public static final String TEST_CASE_NAME = "testcasename";
	public static final String TEST_CASE_ID = "testcaseid";
	public static final String TEST_SUITE_NAME = "testsuitename";
	public static final String TEST_PROJECT_NAME = "testprojectname";
	public static final String TEST_CASE_PATH_NAME = "testcasepathname";
	public static final String TEST_CASE_EXTERNAL_ID = "testcaseexternalid";
	public static final String CUSTOM_FIELDS = "customfields";
	public static final String PLATFORM_ID = "platformid";
	public static final String PLATFOR_NAME = "platformname";
	public static final String STATUS = "status";
	public static final String NOTES = "notes";
	public static final String GUESS = "guess";
	public static final String BUG_ID = "bugid";
	public static final String OVERWRITE = "overwrite";
}
