package ru.swt.addressbook.tests;

import org.junit.Assert;
import ru.swt.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() throws InterruptedException {
		app.getNavigationHelper().goToGroupPage();

		int before = app.getGroupHelper().getGroupCount();

		app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));

		int after = app.getGroupHelper().getGroupCount();
		Assert.assertEquals(after, before + 1);
	}
}
