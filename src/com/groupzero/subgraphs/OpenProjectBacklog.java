package com.groupzero.subgraphs;

import org.tigris.mbt.Util;

import com.thoughtworks.selenium.DefaultSelenium;

public class OpenProjectBacklog extends TestBaseClass {

	/**
	 * This method implements the Edge 'e_init'
	 */
	public void e_init() throws Exception {
		// For a linux machine with firefox installed in '/usr/lib/mozilla-firefox/'
		// where the firefox executable is not in the path.
		// See also:
		// http://release.seleniumhq.org/selenium-remote-control/1.0-beta-2/doc/java/com/thoughtworks/selenium/DefaultSelenium.html#DefaultSelenium(java.lang.String,%20int,%20java.lang.String,%20java.lang.String)
		//browser = new DefaultSelenium("localhost", 4444, "*firefox /usr/lib/firefox-3.5.8/firefox", url);

		// Should work for any machine where the firefox executable is in the path.
		//browser = new DefaultSelenium("localhost", 4444, "*iexplore", url);
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", url);
		normalSpeed();
		sheetName = "Product";
		rowIndex = 1;
		cellnum = 0;
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
		if (selenium == null) {
			fail("browser object should not be null. It should have been assigned at e_Init");
		}
		String title = null;
		try {
			title = selenium.getTitle();
		} catch (Exception e) {
			passRequirement();
			return;
		}
		log.error("We should not have reach this code. Found an open browser: " + title);
		failRequirement();
		Util.AbortIf(true, "Verification failed");
	}
	
	/**
	 * This method implements the Edge 'e_StartBrowser'
	 */
	public void e_StartBrowser() {
		if (selenium == null) {
			log.error("browser object should not be null. It should have been assigned at e_Init");
			Util.AbortIf(true, "browser object should not be null. It should have been assigned at e_Init");
		}
		selenium.start();
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
		String title = null;
		try {
			title = selenium.getTitle();
		} catch (Exception e) {
			log.error("Found no open browser");
			failRequirement();
			Util.AbortIf(true, "Verification failed");
		}
		passRequirement();
		log.info("Found browser with title: " + title);
	}
	
	/**
	 * This method implements the Edge 'e_EnterBaseURL'
	 */
	public void e_EnterBaseURL() {
		selenium.open(url);
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
		waitPageLoad();
		assertBodyText("Agilefant login");
		passRequirement();
	}
	
	/**
	 * This method implements the Edge 'e_InputUserCredentials'
	 */
	public void e_InputUserCredentials() {
		// Input username admin
		selenium.type("j_username", username);
		log.info("Username: "+username);
		// Input password password
		selenium.type("j_password", password);
		log.info("Password: "+password);
		// Click Log in
		selenium.click("//input[@type='submit']");
	}
	
	/**
	 * This method implements the Edge 'e_ClickLogout'
	 */
	public void e_ClickLogout() {
		selenium.click("link=regexp:Logout"); 
	}

	public void v_AgilefantLandingPage() {
		waitPageLoad();
		assertLocation("dailyWork.action");
		passRequirement();
	}

	public void v_EmptyBacklogPage() {
		waitPageLoad();
		assertBodyText("No backlog selected");
		passRequirement();
	}

	public void v_AgilefantProjectBacklog() {
		waitPageLoad();
		assertBodyText("Project: Zero Sugar Project");
		passRequirement();
	}

	/**
	 * Select project and open backlog tab
	 */
	public void e_ClickBacklogTab() {
		selenium.click("link=Backlogs");
	}

	public void e_ClickProjectName() {
		slowSpeed();
		selenium.click("link=Products");
		normalSpeed();
		
		selenium.click("link=" + PRODUCT_NAME);
		waitPageLoad();
		selenium.click("link=" + PROJECT_NAME);
	}
	
}
