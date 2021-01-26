package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		if (app.contact().all().size() == 0) {
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
	public void testContactModification() {
		Set<ContactData> before = app.contact().all();
		ContactData modifiedContact = before.iterator().next();
		ContactData newContactData = new ContactData()
						.withId(modifiedContact.getId())
						.withFirstName("First Name2")
						.withLastName("Last Name2")
						.withAddress("Address2")
						.withEmail("Test@email.com2")
						.withMobilePhone("Test Phone22")
						.withGroup("test12");

		app.contact().modify(modifiedContact, newContactData);
		app.contact().waitForLoadingHomePage();

		Set<ContactData> after = app.contact().all();
		Assert.assertEquals(after.size(), before.size());

		app.contact().setShortImplicityWait();

		before.remove(modifiedContact);
		before.add(newContactData);
		Assert.assertEquals(before, after);
	}
}