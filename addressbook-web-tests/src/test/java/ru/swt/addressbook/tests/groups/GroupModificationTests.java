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
		if(app.db().groups().size() == 0){
			app.group().createGroup(new GroupData()
							.withName("test3")
							.withHeader("test2")
							.withFooter("test3")
			);
		}
		app.goTO().groupPage();
	}

	@Test
	public void testGroupModification() {
		Groups before = app.db().groups();
		GroupData modifiedGroup = before.iterator().next();
		GroupData newGroupData = new GroupData()
						.withId(modifiedGroup.getId())
						.withName("test4")
						.withHeader("test5")
						.withFooter("test6");

		app.group().modify(newGroupData);

		Groups after = app.db().groups();
		assertThat(app.group().count(), equalTo(before.size()));
		assertThat(after, equalTo(before.withModified(modifiedGroup, newGroupData)));
	}
}
