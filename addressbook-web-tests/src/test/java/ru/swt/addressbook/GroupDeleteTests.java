package ru.swt.addressbook;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase {

	@Test
	public void testGroupDeleteTests() throws Exception {
		goToGroupPage();
		selectGroup();
		deleteSelectedGroups();
		goToGroupPage();
	}
}
