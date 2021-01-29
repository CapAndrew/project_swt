package ru.swt.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.model.Contacts;
import ru.swt.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

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
			app.contact().returnToHomePage();
		}
	}

	@Test
	public void testContactModification() {
		Contacts before = app.db().contacts();
		ContactData modifiedContact = before.iterator().next();
		ContactData newContactData = new ContactData()
						.withId(modifiedContact.getId())
						.withFirstName("First Name2")
						.withLastName("Last Name2")
						.withAddress("Address2")
						.withEmail("Test@email.com2")
						.withMobilePhone("Test Phone22");

		app.contact().modify(modifiedContact, newContactData);
		app.contact().waitForLoadingHomePage();

		Contacts after = app.db().contacts();
		app.contact().setShortImplicityWait();
		assertThat(after, equalTo(before.withModified(modifiedContact, newContactData)));
		assertThat(app.contact().count(), equalTo(before.size()));
		verifyContactListInUI();
	}
}