package com.groupzero.subgraphs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.tigris.mbt.ModelBasedTesting;
import org.tigris.mbt.Util;

import com.groupzero.AgilefantTest;
import com.groupzero.TestData;
import com.thoughtworks.selenium.Selenium;

public class TestBaseClass {
	
	public static final String PRODUCT_NAME = "Group Zero";
	public static final String PROJECT_NAME = "Zero Sugar Project";
	
	public static Selenium selenium = null;
	public static Logger log = Util.setupLogger(AgilefantTest.class);
	public static String url = "http://localhost:8080/agilefant";
	public static String username = "admin";
	public static String password = "secret";
	public static TestData productNames = new TestData("testdata/testdata.xls");
	public static String sheetName;
	public static int rowIndex;
	public static int cellnum;
	
	public void assertBodyText(String regex) {
		String body = selenium.getBodyText();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(body);
		
		if (matcher.find() == false) {
			fail("Body text did not contain: " + regex);
		}
	}
	
	public void assertLocation(String regex) {
		String body = selenium.getLocation();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(body);
		
		if (matcher.find() == false) {
			fail("Location did not contain: " + regex);
		}
	}
	
	public void fail(String message) {
		log.error(message);
		failRequirement();
		Util.AbortIf(true, "Verification failed");
		selenium.close();
	}
	
	public void waitPageLoad() {
		selenium.waitForPageToLoad("5000");
	}
	
	public void passRequirement() {
		ModelBasedTesting.getInstance().passRequirement(true);
	}
	
	public void failRequirement() {
		ModelBasedTesting.getInstance().passRequirement(false);
	}
	
	public void normalSpeed() {
		selenium.setSpeed("400");
	}
	
	public void slowSpeed() {
		selenium.setSpeed("1000");
	}
	
	public void fastSpeed() {
		selenium.setSpeed("100");
	}
}
