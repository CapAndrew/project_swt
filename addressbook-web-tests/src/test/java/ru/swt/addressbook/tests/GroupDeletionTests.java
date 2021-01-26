package ru.swt.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;
import ru.swt.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTO().groupPage();
		if (app.group().all().size() == 0) {
			app.group().createGroup(new GroupData().withName("test3").withHeader("test2").withFooter("test3"));
		}
	}

	@Test
	public void testGroupDelete() {
		Groups before = app.group().all();
		GroupData deletedGroup = before.iterator().next();

		app.group().delete(deletedGroup);

		Groups after = app.group().all();

		assertThat(after.size(), equalTo(before.size() - 1));
		assertThat(after, equalTo(before.without(deletedGroup)));
	}
}
