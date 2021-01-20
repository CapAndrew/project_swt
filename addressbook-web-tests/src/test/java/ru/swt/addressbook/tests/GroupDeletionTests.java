package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

	@Test
	public void testGroupDelete() throws Exception {
		app.getNavigationHelper().goToGroupPage();
		if(!app.getGroupHelper().isThereAGroup()){
			app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
		}

		int before = app.getGroupHelper().getGroupCount();

		app.getGroupHelper().selectGroup(before - 1);
		app.getGroupHelper().deleteSelectedGroups();
		app.getNavigationHelper().goToGroupPage();

		int after = app.getGroupHelper().getGroupCount();
		Assert.assertEquals(after, before - 1);
	}
}
