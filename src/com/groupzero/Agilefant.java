package com.groupzero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
/*import org.openqa.selenium.server.browserlaunchers.locators.BrowserLocator;*/
import org.tigris.mbt.ModelBasedTesting;
import org.tigris.mbt.Util;
/*import org.tigris.mbt.exceptions.InvalidDataException;*/

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

/**
 * Remember to start the selenium server, before running the test: java -jar
 * lib/selenium-server.jar -singleWindow
 */
public class Agilefant {
	private Selenium browser = null;
	private Logger log = Util.setupLogger(Agilefant.class);
	private static String url = "http://localhost:8080/agilefant";
	private String username = "admin";
	private String password = "secret";
	private TestData productNames = new TestData("testdata/testdata.xls");
	private String sheetName;
	private int rowIndex;
	private int cellnum;

	
	/**
	 * VERTEXES
	 */
	
	/**
	 * This method implements the Vertex 'v_BaseURL'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_BaseURL() {
		log.info("Vertex: v_BaseURL");
		// Just for sure, lets wait until 1000 ms page to load due to eg. network delays
		browser.waitForPageToLoad("1000");
		if (browser.getTitle().equals("Agilefant - The simplest solution that might work - Home") == false) {
			log.error("Verification failed: " + browser.getTitle());
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		ModelBasedTesting.getInstance().passRequirement(true);
	}

	/**
	 * This method implements the Vertex 'v_BrowserStarted'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_BrowserStarted() {
		log.info("Vertex: v_BrowserStarted");
		String title = null;
		try {
			title = browser.getTitle();
		} catch (Exception e) {
			log.error("Found no open browser");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		ModelBasedTesting.getInstance().passRequirement(true);
		log.info("Found browser with title: " + title);
	}

	/**
	 * This method implements the Vertex 'v_BrowserStopped'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_BrowserStopped() {
		log.info("Vertex: v_BrowserStopped");
		if (browser == null) {
			log.error("browser object should not be null. It should have been assigned at e_Init");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		String title = null;
		try {
			title = browser.getTitle();
		} catch (Exception e) {
			ModelBasedTesting.getInstance().passRequirement(true);
			return;
		}
		log.error("We should not have reach this code. Found an open browser: " + title);
		ModelBasedTesting.getInstance().passRequirement(false);
		Util.AbortIf(true, "Verification failed");
	}
	
	/**
	 * This method implements the Vertex 'v_Login'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_Login() {
		log.info("Vertex: v_Login");
		browser.waitForPageToLoad("5000");
		String body = browser.getBodyText();
		// Lets check that "Agilefant login" can be found from bodytext using pattern and matcher functionality
		Pattern pattern = Pattern.compile("Agilefant login");
		Matcher matcher = pattern.matcher(body);
		if (matcher.find() == false) {
			log.error("Could not match: Agilefant login");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		ModelBasedTesting.getInstance().passRequirement(true);
	}
	
	/**
	 * This method implements the Vertex 'v_AgilefantMainPage'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_AgilefantMainPage() {
		log.info("Vertex: v_AgilefantMainPage");
		// Lets check that login was successful
		String body = browser.getBodyText();
		Pattern pattern = Pattern.compile("Create new");
		Matcher matcher = pattern.matcher(body);
		if (matcher.find() == false) {
			log.error("Could not found: Create new -link");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		pattern = Pattern.compile("Help");
		matcher = pattern.matcher(body);
		if (matcher.find() == false) {
			log.error("Could not match: Help -link");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		pattern = Pattern.compile("Logout");
		matcher = pattern.matcher(body);
		if (matcher.find() == false) {
			log.error("Could not match: Logout -link");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		ModelBasedTesting.getInstance().passRequirement(true);
	}
	
	/**
	 * This method implements the Vertex 'v_CreateNewProduct'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_CreateNewProduct() {
		log.info("Vertex: v_CreateNewProduct");
		String body = browser.getBodyText();
		Pattern pattern = Pattern.compile("Create a new product");
		Matcher matcher = pattern.matcher(body);
		if (matcher.find() == false) {
			log.error("Could not match: Create a new product");
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		ModelBasedTesting.getInstance().passRequirement(true);
	}
	
	/**
	 * This method implements the Vertex 'v_VerifyProductCreation'
	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
	 * the outcome of the verification of that requirement.
	 * If no requirement exists, the call does nothing.
	 * The user writing the test code, does not have to know whether a requirement exist in the model for
	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
	 * will take care of it, and present the result at the end of the test in the mbt.log file.
	 */
	public void v_VerifyProductCreation() {
		log.info("Vertex: v_VerifyProductCreation");
		browser.click("menuAccordion-products");
		// Set the interval between  test steps to 5000 ms, because AJAX components take time to load to UI
		browser.setSpeed("5000");
		// We need to verify creation of created product
		int previousRow = rowIndex-1;
		try {
			browser.click("link="+productNames.getValue(sheetName, previousRow, cellnum));
		} catch (Exception e) {
			log.error("Could not match: "+productNames.getValue(sheetName, previousRow, cellnum));
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		String body = browser.getBodyText();
		Pattern pattern = Pattern.compile("Product: "+productNames.getValue(sheetName, previousRow, cellnum));
		Matcher matcher = pattern.matcher(body);
		if (matcher.find() == false) {
			log.error("Could not match: Product: "+productNames.getValue(sheetName, previousRow, cellnum));
			ModelBasedTesting.getInstance().passRequirement(false);
			Util.AbortIf(true, "Verification failed");
		}
		ModelBasedTesting.getInstance().passRequirement(true);
		// Set the interval between test steps back to 1500 ms
		browser.setSpeed("1500");
	}
	
	/**
	 * EDGES
	 */
	
	/**
	 * This method implements the Edge 'e_init'
	 */
	public void e_init() throws Exception {
		log.info("Edge: e_init");

		// For a linux machine with firefox installed in '/usr/lib/mozilla-firefox/'
		// where the firefox executable is not in the path.
		// See also:
		// http://release.seleniumhq.org/selenium-remote-control/1.0-beta-2/doc/java/com/thoughtworks/selenium/DefaultSelenium.html#DefaultSelenium(java.lang.String,%20int,%20java.lang.String,%20java.lang.String)
		//browser = new DefaultSelenium("localhost", 4444, "*firefox /usr/lib/firefox-3.5.8/firefox", url);

		// Should work for any machine where the firefox executable is in the path.
		//browser = new DefaultSelenium("localhost", 4444, "*iexplore", url);
		browser = new DefaultSelenium("localhost", 4444, "*firefox", url);
		// Set the interval between  test steps to 1500 ms
		browser.setSpeed("400");
		sheetName = "Product";
		rowIndex = 1;
		cellnum = 0;
	}
	
	/**
	 * This method implements the Edge 'e_EnterBaseURL'
	 */
	public void e_EnterBaseURL() {
		log.info("Edge: e_EnterBaseURL");
		browser.open(url);
	}

	/**
	 * This method implements the Edge 'e_StartBrowser'
	 */
	public void e_StartBrowser() {
		log.info("Edge: e_StartBrowser");
		if (browser == null) {
			log.error("browser object should not be null. It should have been assigned at e_Init");
			Util.AbortIf(true, "browser object should not be null. It should have been assigned at e_Init");
		}
		browser.start();
	}
	
	/**
	 * This method implements the Edge 'e_InputUserCredentials'
	 */
	public void e_InputUserCredentials() {
		log.info("Edge: e_InputUserCredentials");
		// Input username admin
		browser.type("j_username", username);
		log.info("Username: "+username);
		// Input password password
		browser.type("j_password", password);
		log.info("Password: "+password);
		// Click Log in
		browser.click("//input[@type='submit']");
	}
	
	/**
	 * This method implements the Edge 'e_ClickCreateNewProduct'
	 */
	public void e_ClickCreateNewProduct() {
		log.info("Edge: e_ClickCreateNewProduct");
		// Lets click first Backlogs. Otherwise system will increment the id "editor-2" in e_InputDetailsAndSave method
		browser.click("link=regexp:Backlogs");
		// Click Create new -- Product
		browser.click("createNewMenuLink");
		browser.click("createNewProduct");
	}
	
	/**
	 * This method implements the Edge 'e_InputProductData'
	 */
	public void e_InputDetailsAndSave() {
		log.info("Edge: e_InputDetailsAndSave");
		browser.setSpeed("5000");
		// Click on Name text field
		browser.click("editor-2");
		// Input Product name, which is fetched from testdata.xls
		browser.type("editor-2", productNames.getValue(sheetName, rowIndex, cellnum));
		// Save
		browser.click("//button[@type='button'][2]");
		// Increase rowIndex by one
		rowIndex++;
		browser.setSpeed("1500");
	}
	
	/**
	 * This method implements the Edge 'e_ClickLogout'
	 */
	public void e_ClickLogout() {
		log.info("Edge: e_ClickLogout");
		browser.click("link=regexp:Logout"); 
	}
	
	/**
	 * This method implements the Edge 'e_ClickCancel'
	 */
	public void e_ClickCancel() {
		log.info("Edge: e_ClickCancel");
		browser.click("//button[@type='button'][1]");
	}
}