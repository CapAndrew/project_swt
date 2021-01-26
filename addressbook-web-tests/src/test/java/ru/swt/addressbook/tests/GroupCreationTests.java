package ru.swt.addressbook.tests;

import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;
import ru.swt.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation() {
		app.goTO().groupPage();

		Groups before = app.group().all();
		GroupData group = new GroupData().withName("test3").withHeader("test2").withFooter("test3");

		app.group().createGroup(group);

		Groups after = app.group().all();
		assertThat(after.size(), equalTo(before.size() + 1));
		assertThat(after, equalTo(
						before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
	}

	@Test
	public void testBadGroupCreation() {
		app.goTO().groupPage();

		Groups before = app.group().all();
		GroupData group = new GroupData().withName("test3'").withHeader("test2").withFooter("test3");

		app.group().createGroup(group);

		assertThat(app.group().count(), equalTo(before.size()));
		Groups after = app.group().all();
		assertThat(after, equalTo(before));
	}
}
