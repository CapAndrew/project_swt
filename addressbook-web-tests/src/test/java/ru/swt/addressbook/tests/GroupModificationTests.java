package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {

	@Test
	public void testGroupModification() {
		app.getNavigationHelper().goToGroupPage();
		if (!app.getGroupHelper().isThereAGroup()) {
			app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
		}

		List<GroupData> before = app.getGroupHelper().getGroupList();

		app.getGroupHelper().selectGroup(before.size() - 1);
		app.getGroupHelper().initGroupModification();
		app.getGroupHelper().fillGroupForm(new GroupData("test4", "test5", "test6"));
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();

		List<GroupData> after = app.getGroupHelper().getGroupList();
		Assert.assertEquals(after.size(), before.size());
	}
}
