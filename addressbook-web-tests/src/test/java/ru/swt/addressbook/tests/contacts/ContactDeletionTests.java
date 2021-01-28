package ru.swt.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.model.Contacts;
import ru.swt.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		if (app.db().contacts().size() == 0) {
			app.contact().create(new ContactData()
											.withFirstName("First Name")
											.withLastName("Last Name")
											.withAddress("Address")
											.withEmail("Test@email.com")
											.withMobilePhone("Test Phone2")
											.withGroup("test1"),
							true);
			app.goTO().homePage();
		}
	}

	@Test
	public void testContactDelete() {

		Contacts before = app.db().contacts();
		ContactData deletedContact = before.iterator().next();

		app.contact().delete(deletedContact);
		app.contact().waitForLoadingHomePage();

		Contacts after = app.db().contacts();
		app.contact().setShortImplicityWait();
		assertThat(after, equalTo(before.without(deletedContact)));
		assertThat(app.contact().count(), equalTo(before.size() - 1));
		verifyContactListInUI();
	}
}
