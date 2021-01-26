package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions(){
		app.goTO().groupPage();
		if (app.group().list().size() == 0) {
			app.group().createGroup(new GroupData("test1", "test2", "test3"));
		}
	}

	@Test
	public void testGroupDelete() throws Exception {
		List<GroupData> before = app.group().list();
		int index = before.size() - 1;

		app.group().delete(index);

		List<GroupData> after = app.group().list();
		Assert.assertEquals(after.size(), index);

		before.remove(index);
		Assert.assertEquals(before, after);
	}
}
