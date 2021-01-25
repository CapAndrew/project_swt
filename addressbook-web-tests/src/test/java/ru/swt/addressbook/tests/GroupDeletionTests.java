package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions(){
		app.getNavigationHelper().goToGroupPage();
		if (!app.getGroupHelper().isThereAGroup()) {
			app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
		}
	}

	@Test
	public void testGroupDelete() throws Exception {
		List<GroupData> before = app.getGroupHelper().getGroupList();
		int index = before.size() - 1;

		app.getGroupHelper().selectGroup(index);
		app.getGroupHelper().deleteSelectedGroups();
		app.getNavigationHelper().goToGroupPage();

		List<GroupData> after = app.getGroupHelper().getGroupList();
		Assert.assertEquals(after.size(), index);

		before.remove(index);
		Assert.assertEquals(before, after);
	}
}
