package com.groupzero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.tigris.mbt.ModelBasedTesting;
import org.tigris.mbt.Util;

import com.thoughtworks.selenium.Selenium;

public class TestBaseClass {
	
	/**
	 * Agilefant location
	 */
	public static String url = "http://localhost:8080/agilefant";
	
	// PREREQUIREMENTS:
	//
	// In order to properly execute the tests, you should have:
	// - an existing product named "Group Zero"
	// - an existing project named "Zero Sugar Project"
	// - a user "admin" with password "secret"
	public static final String PRODUCT_NAME = "Group Zero";
	public static final String PROJECT_NAME = "Zero Sugar Project";
	public static final String USERNAME = "admin";
	public static final String PASSWORD = "secret";
	
	/**
	 * Setup logger. The logs are written in file logs/mbt.log
	 */
	public static Logger log = Util.setupLogger(AgilefantTest.class);
	
	/**
	 * Selenium client
	 */
	public static Selenium s = null;
	
	// Excel test data
	public static TestData productNames = new TestData("testdata/testdata.xls");
	public static String sheetName;
	public static int rowIndex;
	public static int cellnum;
	
	/* ................ Assertion helpers ................................ */
	
	public void assertTextPresent(String pattern) {
		if(s.isTextPresent(pattern) == false) {
			fail("Text is not present: " + pattern);
		}
	}
	
	public void assertBodyText(String regex) {
		String body = s.getBodyText();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(body);
		
		if (matcher.find() == false) {
			fail("Body text did not contain: " + regex);
		}
	}
	
	public void assertLocation(String regex) {
		String body = s.getLocation();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(body);
		
		if (matcher.find() == false) {
			fail("Location did not contain: " + regex);
		}
	}
	
	public void assertElementPresent(String locator) {
		if(!s.isElementPresent(locator)) {
			fail("Element is not present: " + locator);
		}
	}
	
	/* .................. Selenium shorthands ........................ */
	
	/**
	 * Marks the test as failed.
	 * 
	 * When a assertion fails, call this function in order to mark the test as 
	 * failed, stop execution and close the browser.
	 */
	public void fail(String message) {
		log.error(message);
		failRequirement();
		Util.AbortIf(true, "Verification failed");
		s.close();
	}
	
	/**
	 * Selenium.waitForPageToLoad shorthand
	 */
	public void waitPageLoad() {
		s.waitForPageToLoad("20000");
	}
	
	/**
	 * Shorthand for marking requirement as passed
	 */
	public void passRequirement() {
		ModelBasedTesting.getInstance().passRequirement(true);
	}
	
	/**
	 * Shorthand for marking requirement as failed
	 */
	public void failRequirement() {
		ModelBasedTesting.getInstance().passRequirement(false);
	}
	
	/**
	 * Change the test step execution speed to normal
	 */
	public void normalSpeed() {
		s.setSpeed("400");
	}
	
	/**
	 * Change the test step execution speed to slow
	 */
	public void slowSpeed() {
		s.setSpeed("1000");
	}
	
	/**
	 * Change the test step execution speed to fast
	 */
	public void fastSpeed() {
		s.setSpeed("100");
	}
	
	/* ..................... Test helpers ........................... */
	
	// Put here all the common action needed to be performed in the tests.
	
	/**
	 * Clicks left side tree to open Product and Project
	 */
	public void openProject() {
		slowSpeed();
		s.click("link=Products");
		s.click("link=" + PRODUCT_NAME);
		normalSpeed();
		waitPageLoad();
		s.click("link=" + PROJECT_NAME);
		waitPageLoad();
	}
}
