package com.groupzero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
/*import org.openqa.selenium.server.browserlaunchers.locators.BrowserLocator;*/
import org.tigris.mbt.ModelBasedTesting;
import org.tigris.mbt.Util;
/*import org.tigris.mbt.exceptions.InvalidDataException;*/

import com.groupzero.subgraphs.CreateNewStory;
import com.groupzero.subgraphs.OpenProjectBacklog;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

/**
 * Remember to start the selenium server, before running the test: java -jar
 * lib/selenium-server.jar -singleWindow
 */
public class AgilefantTest {

	// SubGraphs
	private CreateNewStory createNewStory = new CreateNewStory();
	private OpenProjectBacklog openProjectBacklog = new OpenProjectBacklog();
	
	/**
	 * VERTEXES
	 */

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
		this.openProjectBacklog.v_BrowserStopped();
	}
	
	public void v_BrowserStarted() {
		this.openProjectBacklog.v_BrowserStarted();
	}
	
	public void v_Login() {
		this.openProjectBacklog.v_Login();
	}
	
	public void v_AgilefantLandingPage() {
		this.openProjectBacklog.v_AgilefantLandingPage();
	}
	
	public void v_EmptyBacklogPage() {
		this.openProjectBacklog.v_EmptyBacklogPage();
	}
	
	public void v_AgilefantProjectBacklog() {
		this.openProjectBacklog.v_AgilefantProjectBacklog();
	}
	
//	/**
//	 * This method implements the Vertex 'v_AgilefantMainPage'
//	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
//	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
//	 * the outcome of the verification of that requirement.
//	 * If no requirement exists, the call does nothing.
//	 * The user writing the test code, does not have to know whether a requirement exist in the model for
//	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
//	 * will take care of it, and present the result at the end of the test in the mbt.log file.
//	 */
//	public void v_AgilefantMainPage() {
//		log.info("Vertex: v_AgilefantMainPage");
//		// Lets check that login was successful
//		String body = browser.getBodyText();
//		Pattern pattern = Pattern.compile("Create new");
//		Matcher matcher = pattern.matcher(body);
//		if (matcher.find() == false) {
//			log.error("Could not found: Create new -link");
//			ModelBasedTesting.getInstance().passRequirement(false);
//			Util.AbortIf(true, "Verification failed");
//		}
//		pattern = Pattern.compile("Help");
//		matcher = pattern.matcher(body);
//		if (matcher.find() == false) {
//			log.error("Could not match: Help -link");
//			ModelBasedTesting.getInstance().passRequirement(false);
//			Util.AbortIf(true, "Verification failed");
//		}
//		pattern = Pattern.compile("Logout");
//		matcher = pattern.matcher(body);
//		if (matcher.find() == false) {
//			log.error("Could not match: Logout -link");
//			ModelBasedTesting.getInstance().passRequirement(false);
//			Util.AbortIf(true, "Verification failed");
//		}
//		ModelBasedTesting.getInstance().passRequirement(true);
//	}
//	
//	/**
//	 * This method implements the Vertex 'v_CreateNewProduct'
//	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
//	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
//	 * the outcome of the verification of that requirement.
//	 * If no requirement exists, the call does nothing.
//	 * The user writing the test code, does not have to know whether a requirement exist in the model for
//	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
//	 * will take care of it, and present the result at the end of the test in the mbt.log file.
//	 */
//	public void v_CreateNewProduct() {
//		log.info("Vertex: v_CreateNewProduct");
//		String body = browser.getBodyText();
//		Pattern pattern = Pattern.compile("Create a new product");
//		Matcher matcher = pattern.matcher(body);
//		if (matcher.find() == false) {
//			log.error("Could not match: Create a new product");
//			ModelBasedTesting.getInstance().passRequirement(false);
//			Util.AbortIf(true, "Verification failed");
//		}
//		ModelBasedTesting.getInstance().passRequirement(true);
//	}
//	
//	/**
//	 * This method implements the Vertex 'v_VerifyProductCreation'
//	 * Note the calls to org.tigris.mbt.ModelBasedTesting.passRequirement(boolean pass)
//	 * What the call does is, if there exists a requirement connected to this vertex, mbt will be notified of
//	 * the outcome of the verification of that requirement.
//	 * If no requirement exists, the call does nothing.
//	 * The user writing the test code, does not have to know whether a requirement exist in the model for
//	 * the vertex or not, and also, which requirement that would be. Only pass true or false, and mbt
//	 * will take care of it, and present the result at the end of the test in the mbt.log file.
//	 */
//	public void v_VerifyProductCreation() {
//		log.info("Vertex: v_VerifyProductCreation");
//		browser.click("menuAccordion-products");
//		// Set the interval between  test steps to 5000 ms, because AJAX components take time to load to UI
//		browser.setSpeed("5000");
//		// We need to verify creation of created product
//		int previousRow = rowIndex-1;
//		try {
//			browser.click("link="+productNames.getValue(sheetName, previousRow, cellnum));
//		} catch (Exception e) {
//			log.error("Could not match: "+productNames.getValue(sheetName, previousRow, cellnum));
//			ModelBasedTesting.getInstance().passRequirement(false);
//			Util.AbortIf(true, "Verification failed");
//		}
//		String body = browser.getBodyText();
//		Pattern pattern = Pattern.compile("Product: "+productNames.getValue(sheetName, previousRow, cellnum));
//		Matcher matcher = pattern.matcher(body);
//		if (matcher.find() == false) {
//			log.error("Could not match: Product: "+productNames.getValue(sheetName, previousRow, cellnum));
//			ModelBasedTesting.getInstance().passRequirement(false);
//			Util.AbortIf(true, "Verification failed");
//		}
//		ModelBasedTesting.getInstance().passRequirement(true);
//		// Set the interval between test steps back to 1500 ms
//		browser.setSpeed("1500");
//	}
	
	/**
	 * EDGES
	 */
	
	/**
	 * This method implements the Edge 'e_init'
	 */
	public void e_init() throws Exception {
		openProjectBacklog.e_init();
	}
	
	public void e_StartBrowser() {
		openProjectBacklog.e_StartBrowser();
	}
	
	public void e_EnterBaseURL() {
		openProjectBacklog.e_EnterBaseURL();
	}
	
	public void e_InputUserCredentials() {
		openProjectBacklog.e_InputUserCredentials();
	}
	
	public void e_ClickBacklogTab() {
		openProjectBacklog.e_ClickBacklogTab();
	}
	
	public void e_ClickProjectName() {
		openProjectBacklog.e_ClickProjectName();
	}
	
//	/**
//	 * This method implements the Edge 'e_ClickCreateNewProduct'
//	 */
//	public void e_ClickCreateNewProduct() {
//		log.info("Edge: e_ClickCreateNewProduct");
//		// Lets click first Backlogs. Otherwise system will increment the id "editor-2" in e_InputDetailsAndSave method
//		browser.click("link=regexp:Backlogs");
//		// Click Create new -- Product
//		browser.click("createNewMenuLink");
//		browser.click("createNewProduct");
//	}
//	
//	/**
//	 * This method implements the Edge 'e_InputProductData'
//	 */
//	public void e_InputDetailsAndSave() {
//		log.info("Edge: e_InputDetailsAndSave");
//		browser.setSpeed("5000");
//		// Click on Name text field
//		browser.click("editor-2");
//		// Input Product name, which is fetched from testdata.xls
//		browser.type("editor-2", productNames.getValue(sheetName, rowIndex, cellnum));
//		// Save
//		browser.click("//button[@type='button'][2]");
//		// Increase rowIndex by one
//		rowIndex++;
//		browser.setSpeed("1500");
//	}
//	
//	/**
//	 * This method implements the Edge 'e_ClickCancel'
//	 */
//	public void e_ClickCancel() {
//		log.info("Edge: e_ClickCancel");
//		browser.click("//button[@type='button'][1]");
//	}
}