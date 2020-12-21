package ru.swt.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {

	@Test
	public void testGroupDeleteTests() throws Exception {
		app.goToGroupPage();
		app.selectGroup();
		app.deleteSelectedGroups();
		app.goToGroupPage();
	}
}
