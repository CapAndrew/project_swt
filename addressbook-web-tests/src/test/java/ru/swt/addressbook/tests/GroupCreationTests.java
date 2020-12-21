package ru.swt.addressbook.tests;

import model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() throws InterruptedException {
		app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();

	}
}
