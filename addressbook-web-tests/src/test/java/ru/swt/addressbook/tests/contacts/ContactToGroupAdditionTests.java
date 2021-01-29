package ru.swt.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.model.GroupData;
import ru.swt.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupAdditionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		if (app.db().contacts().size() == 0) {
			app.contact().create(new ContactData()
											.withFirstName("First Name")
											.withLastName("Last Name")
											.withAddress("Address")
											.withEmail("Test@email.com")
											.withMobilePhone("Test Phone2"),
							true);
		}
		if (app.db().groups().size() == 0 || app.db().availableContactsToAddToGroup().size() == 0) {
			app.goTO().groupPage();
			app.group().createGroup(new GroupData()
							.withName("test3")
							.withHeader("test2")
							.withFooter("test3")
			);
		}
		app.goTO().homePage();
	}

	@Test
	public void contactToGroupAddition() {
		app.goTO().homePage();

		ContactData before = app.db().availableContactsToAddToGroup().iterator().next();
		GroupData group = app.db().availableGroupsForAddAContact(before).iterator().next();

		app.contact().addContactToGroup(before,group);

		ContactData after = app.db().getContactWithId(before.getId());

		assertThat(after.getGroups().size(), equalTo(before.getGroups().size() + 1));
		assertThat(after.getGroups(), hasItem(group));
	}
}
