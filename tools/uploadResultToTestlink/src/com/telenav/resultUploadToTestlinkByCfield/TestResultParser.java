package com.telenav.resultUploadToTestlinkByCfield;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestResultParser {
	TestResult testResult;
	boolean rerun = false;
	static Connection connection = null;
    
	public TestResultParser(String testResultDir, String projectName,
			String testPlanName, String buildName, String customFieldName,
			boolean onlyUploadPassCases) {
		testResult = new TestResult();
		testResult.setTestResultDir(testResultDir);
		testResult.setProjectName(projectName);
		testResult.setTestPlanName(testPlanName);
		testResult.setBuildName(buildName);
		testResult.setCustomFieldName(customFieldName);
		testResult.setOnlyUploadPassCases(onlyUploadPassCases);
	}
	
	public boolean parse() throws Exception {
		boolean successfulUpload;
		// create db connection for getting test case ID by Custom Field
		connection = DBUtil.getConnection();
		
		// reset the build name after creating new build or get latest build information
		testResult.setBuildName(getBuildName());
		// upload test results of normal run
		System.out.println("Start to upload the results of normal run!");
		successfulUpload = parseResultDir(testResult.getTestResultDir() + File.separator + "html", connection);
		
		// upload test results of rerun
		System.out.println("Start to upload the results of rerun!");
		if (new File(testResult.getTestResultDir() + File.separator + "rerun").exists()) {
			rerun = true;
			successfulUpload = parseResultDir(testResult.getTestResultDir()
					+ File.separator + "rerun" + File.separator + "html",
					connection);
		}
		
		// close db connection after parsing
		DBUtil.closeConnection(connection);
		
		return successfulUpload;
	}
	
	public boolean parseResultDir(String testResultDir, Connection connection) throws Exception {
		boolean successfulUpload = true;
		List<File> testResultFiles = getTestResultFiles(testResultDir);
		if (testResultFiles == null) {
			System.out.println("Cannot find report html files in directory - "
					+ testResultDir + "\n");
		}
		
		String testResultFilePath;
		
		for (File testResultFile : testResultFiles) {
			testResultFilePath = testResultFile.getAbsolutePath();
			if (testResultFilePath.indexOf("all-tests.html") == -1) {
				continue;
			}
			successfulUpload = parseResultFile(testResultFilePath, connection);
		}
		
		return successfulUpload;
	}
	
	public boolean parseResultFile(String filePath, Connection connection)
			throws Exception {
		File resultFile = null;
		boolean successfulUpload = true;
		try {
			// open file input stream
			resultFile = new File(filePath);
			// parse test result from xml input stream
			successfulUpload = parseBufferStream(resultFile, connection);
			return successfulUpload;
		} catch (FileNotFoundException fileNotFoundEx) {
			throw new Exception("Test result file not found: " + filePath,
					fileNotFoundEx);
		} catch (Exception ex) {
			throw new Exception("Parse test result file failed: " + filePath,
					ex);
		}
	}
    
	public boolean parseBufferStream(File resultFile,
			Connection connection) throws Exception {
		BufferedReader bufferedReader = null;
		TestResultUpload testResultUpload = new TestResultUpload();
        boolean successfulUpload = true;
        boolean caseSuccessfulUpload;
		Document doc;
		Element linkCustomField;
		String line = "";
		String customFieldValue = "";
		String resultStatus = "";
		try {
			bufferedReader = new BufferedReader(new FileReader(resultFile));
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.startsWith(TestResultConstants.HTML_RESULT_LINE_BEGIN)) {
					continue;
				}
				doc = Jsoup.parse(line);
				linkCustomField = doc.select(
						TestResultConstants.HTML_RESULT_TAG).get(
						TestResultConstants.CFIELD_ATTRIBUTE_POSITION);
				customFieldValue = linkCustomField.attr(TestResultConstants.HTML_CFIELD_TAG_NAME);
				if ((line.indexOf(TestResultConstants.HTML_SUCCESS_RESULT_STATUS) != -1)||
						(line.indexOf(TestResultConstants.HTML_WARNING_RESULT_STATUS) != -1)) {
					resultStatus = "p";
					caseSuccessfulUpload = testResultUpload.uploadTestResult(testResult.getProjectName(),
							testResult.getTestPlanName(), testResult.getBuildName(), testResult.getCustomFieldName(),
							customFieldValue, resultStatus, connection);
					if (caseSuccessfulUpload == false) {
						successfulUpload = false;
					}
				} else if (line.indexOf(TestResultConstants.HTML_FAILURE_RESULT_STATUS) != -1) {
					resultStatus = "f";
					if (testResult.getOnlyUploadPassCases() == false && rerun == false) {
						caseSuccessfulUpload = testResultUpload.uploadTestResult(testResult.getProjectName(),
								testResult.getTestPlanName(), testResult.getBuildName(), testResult.getCustomFieldName(),
								customFieldValue, resultStatus, connection);
						if (caseSuccessfulUpload == false) {
							successfulUpload = false;
						}
					}
				} else if (line.indexOf(TestResultConstants.HTML_ERROR_RESULT_STATUS) != -1) {
					resultStatus = "Error";
				} else {
					System.out.println("No Result status!!!");
				}
			}
			return successfulUpload;
		} catch (IOException ex) {
			throw new Exception("Parse test result file failed.", ex);
		} catch (Exception e) {
			throw new Exception("Parse test result file failed.", e);
		} finally {
			// release resource attached to xml stream reader.
			if (null != bufferedReader) {
				try {
					bufferedReader.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
    
	public String getBuildName() throws Exception {
		String buildName = null;
		TestResultUpload testResultUpload = new TestResultUpload();
		if ("".equals(testResult.getBuildName())) {
			buildName = testResultUpload.getLatestBuildNameForTestPlan(
					testResult.getProjectName(), testResult.getTestPlanName(), testResult.getBuildName());
		}else if(!testResultUpload.checkBuildNotExist(testResult.getProjectName(), testResult.getTestPlanName(), testResult.getBuildName(), connection)){
			System.out.println("--------------------- exists build--------------------------------");
			buildName = testResult.getBuildName();
		}else{
		    System.out.println("--------------------- not exists build--------------------------------");
			testResultUpload.createBuildAndAssginment(testResult.getProjectName(),
					testResult.getTestPlanName(), testResult.getBuildName(), connection);
			buildName = testResult.getBuildName();
		}
		
		return buildName;
	}
	
	/**
	 * Gets test result file list
	 * @return test result file list
	 */
	public List<File> getTestResultFiles(String testResultDir) {
		// build root directory of test suite files
		List<File> files = listCurrentFolder(testResultDir);

		// throw if we could not find files
		if (files.isEmpty()) {
			throw new NoSuchElementException("no test result files in ["
					+ testResultDir + "] or directory does not exist");
		}

		for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i));
		}

		return files;
	}
	
	/**
	 * @param basePath (in) folder to search
	 * @return files under current folder matching the file type filter.
	 *         Vector<File>
	 */
	public Vector<File> listCurrentFolder(String basePath) {
		Vector<File> subFiles = new Vector<File>();
		// get all files matching the filters
		File[] files = (new File(basePath)).listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				boolean canAccept = pathname.isFile();
				if (canAccept) {
					canAccept = TestResultParser.match(pathname.getName(),
							TestResultConstants.HTML_FILE_PATTERN);
				}
				return canAccept;
			} // accept
		});
		if (null != files) {
			for (int i = 0; i < files.length; ++i) {
				subFiles.add(files[i]);
			}
		}

		return subFiles;
	}
	
	/**
	 * tests whether a string matches another
	 * 
	 * @param sName (in) test result full path name
	 * @param sFilter (in) filter. can be null
	 * @return true if sFilter is null, or if (sName == sFilter). If sFilter
	 *         ends with '*', true if sFilter is prefix of sName
	 */
	public static boolean match(String sName, String sFilter) {
		if (null == sFilter) {
			return true;
		}

		if (wildMatch(sName, sFilter)) {
			return true;
		}

		return false;
	}
    
	/**
	 * wild match to support '?' and '*' characters. We do not support '\\'
	 * escape.
	 * 
	 * @param name (in) : input name
	 * @param pattern (in) : match pattern
	 * @return true if it is matched.
	 */
	public static boolean wildMatch(final String name, final String pattern) {
		if ((name == null) || (pattern == null))
			return false;
		boolean isStar = false;

		final int nlen = name.length();
		final int plen = pattern.length();
		int mi = 0; // current name index
		int mj = 0; // previous name index
		int pi = 0; // current pattern index
		int pj = 0; // previous pattern index
		while (mi < nlen) {
			if (pi >= plen)
				return false;
			if (pattern.charAt(pi) == '*') {
				isStar = true;
				for (pj = pi + 1; (pj < plen) && (pattern.charAt(pj) == '*'); ++pj) {
					// do nothing
				}
				if (pj >= plen)
					return true;
				pi = pj;
			} else if (pattern.charAt(pi) == '?') {
				++mi;
				++pi;
			} else if (pattern.charAt(pi) != name.charAt(mi)) {
				if (!isStar)
					return false;
				mi = ++mj;
				pi = pj;
			} else {
				++mi;
				++pi;
			}
		}

		return (pi >= plen);
	}
}
