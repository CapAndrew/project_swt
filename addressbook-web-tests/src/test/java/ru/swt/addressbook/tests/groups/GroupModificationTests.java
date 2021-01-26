package ru.swt.addressbook.tests.groups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;
import ru.swt.addressbook.model.Groups;
import ru.swt.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTO().groupPage();
		if (app.group().all().size() == 0) {
			app.group().createGroup(new GroupData()
							.withName("test3")
							.withHeader("test2")
							.withFooter("test3")
			);
		}
	}

	@Test
	public void testGroupModification() {
		Groups before = app.group().all();
		GroupData modifiedGroup = before.iterator().next();
		GroupData newGroupData = new GroupData()
						.withId(modifiedGroup.getId())
						.withName("test4")
						.withHeader("test5")
						.withFooter("test6");

		app.group().modify(newGroupData);

		assertThat(app.group().count(), equalTo(before.size()));
		Groups after = app.group().all();
		assertThat(after, equalTo(before.withModified(modifiedGroup, newGroupData)));
	}
}
