package ru.swt.addressbook.tests;

import org.junit.Assert;
import ru.swt.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void testGroupModification() {
		app.getNavigationHelper().goToGroupPage();
		if(!app.getGroupHelper().isThereAGroup()){
			app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
		}

		int before = app.getGroupHelper().getGroupCount();

		app.getGroupHelper().selectGroup(before - 1);
		app.getGroupHelper().initGroupModification();
		app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();

		int after = app.getGroupHelper().getGroupCount();
		Assert.assertEquals(after, before);
	}
}
