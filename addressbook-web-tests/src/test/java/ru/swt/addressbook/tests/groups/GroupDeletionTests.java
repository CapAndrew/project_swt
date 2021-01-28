package ru.swt.addressbook.tests.groups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;
import ru.swt.addressbook.model.Groups;
import ru.swt.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

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
	public void testGroupDelete() {
		Groups before = app.db().groups();
		GroupData deletedGroup = before.iterator().next();

		app.group().delete(deletedGroup);

		Groups after = app.db().groups();
		assertThat(app.group().count(), equalTo(before.size() - 1));
		assertThat(after, equalTo(before.without(deletedGroup)));
	}
}
