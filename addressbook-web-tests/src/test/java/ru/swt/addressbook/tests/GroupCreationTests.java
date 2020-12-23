package ru.swt.addressbook.tests;

import ru.swt.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() throws InterruptedException {
		app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
	}
}
