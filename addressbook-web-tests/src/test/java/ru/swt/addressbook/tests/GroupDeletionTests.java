package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTO().groupPage();
		if (app.group().all().size() == 0) {
			app.group().createGroup(new GroupData().withName("test3").withHeader("test2").withFooter("test3"));
		}
	}

	@Test
	public void testGroupDelete() throws Exception {
		Set<GroupData> before = app.group().all();
		GroupData deletedGroup = before.iterator().next();

		app.group().delete(deletedGroup);

		Set<GroupData> after = app.group().all();
		Assert.assertEquals(after.size(), before.size() - 1);

		before.remove(deletedGroup);
		Assert.assertEquals(before, after);
	}
}
