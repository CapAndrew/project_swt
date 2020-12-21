package ru.swt.addressbook.tests;

import model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() throws InterruptedException {

		app.goToGroupPage();
		app.initGroupCreation();
		app.fillGroupForm(new GroupData("test1", "test2", "test3"));
		app.submitGroupCreation();
		app.returnToGroupPage();

	}

}
