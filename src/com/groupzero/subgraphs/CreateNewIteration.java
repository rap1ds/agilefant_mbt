package com.groupzero.subgraphs;

import com.groupzero.TestBaseClass;

public class CreateNewIteration extends TestBaseClass {
	
	/**
	 * Nothing here,
	 * this is just a placeholder to support merging graphs
	 */
	public void v_SubGraphCreateNewIteration() {
		// Nothing here, this is just a placeholder to support merging graphs
		passRequirement();
	}
	
	public void e_ClickCreateNewIteration() {
		s.click("id=createNewMenuLink");
		s.click("id=createNewIteration");
	}
	
	public void v_CreateNewIteration() {
		assertTextPresent("Create a new iteration");
		passRequirement();
	}
	
	public void e_ClickCancelNewIteration() {
		// This works with pure luck... There's no identification that the button
		// is really the Cancel button.
		s.click("//button[@type='button']");
	}
	
	/**
	 * Inputs iteration details to the dialog and saves the created iteration.
	 * 
	 * Notice: The elements inside the modal dialog do not have proper ids. That's
	 * why very complex XPath/jQuery queries have to be made to get hands in the right 
	 * DOM elements. Shit.
	 */
	public void e_InputIterationDetailsAndSave() {
		slowSpeed();
		
		String name = "xpath=((//div[contains(@role,'dialog')])[last()]//input)[1]";
		String parent = "xpath=((//div[contains(@role,'dialog')])[last()]//input)[2]";
		String startDate = "xpath=((//div[contains(@role,'dialog')])[last()]//input)[3]";
		String endDate = "xpath=((//div[contains(@role,'dialog')])[last()]//input)[4]";
		String okButton = "xpath=(//div[contains(@role,'dialog')])[last()]//button[2]";
		
		s.type(name, "New Zero Sugar Iteration");
		
		// Click the "Parent" input field and type "Group Ze" to open the auto-complete menu
		s.click(parent);
		s.typeKeys(parent, "Group Ze");
		
		// Simulate mouse over the auto-complete menu item
		s.getEval("window.jQuery('ul.ui-menu').last().find('li a').trigger('mouseenter')");
		// Simulate click the auto-complete menu item
		s.getEval("window.jQuery('ul.ui-menu').last().find('li a').trigger('click')");
		
		// BUG NEEDS TO TYPE!

		s.click(startDate);
		s.type(startDate, "2011-12-01 12:00");
		s.click(endDate);
		s.type(endDate, "2011-12-31 12:00");
		s.click(okButton);
		
		normalSpeed();
	}
	
	public void v_VerifyIterationCreation() {
		openProject();
		s.getEval("window.jQuery('a[href=#iterations]').click()");
		assertElementPresent("xpath=//span[text()='New Zero Sugar Iteration']");
		
		passRequirement();
	}
	
}
