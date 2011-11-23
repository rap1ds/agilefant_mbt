package com.groupzero;

import com.groupzero.subgraphs.CreateNewIteration;
import com.groupzero.subgraphs.OpenProjectBacklog;

/**
 * Remember to start the selenium server, before running the test: java -jar
 * lib/selenium-server.jar -singleWindow
 */
public class AgilefantTest {

	// SubGraphs
	private OpenProjectBacklog openProjectBacklog = new OpenProjectBacklog();
	private CreateNewIteration createNewIteration = new CreateNewIteration();
	
	/* .................... Open Project Backlog .......................... */
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
	
	public void e_Logout() {
		openProjectBacklog.e_Logout();
	}
	
	/* .................. Create New Iteration ............................... */

	public void v_SubGraphCreateNewIteration() {
		createNewIteration.v_SubGraphCreateNewIteration();
	}
	
	public void e_ClickCreateNewIteration() {
		createNewIteration.e_ClickCreateNewIteration();
	}
	
	public void v_CreateNewIteration() {
		createNewIteration.v_CreateNewIteration();
	}
	
	public void e_ClickCancelNewIteration() {
		createNewIteration.e_ClickCancelNewIteration();
	}
	
	public void e_InputIterationDetailsAndSave() {
		createNewIteration.e_InputIterationDetailsAndSave();
	}
	
	public void v_VerifyIterationCreation() {
		createNewIteration.v_VerifyIterationCreation();
	}
}