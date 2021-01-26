package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		Set<ContactData> before = app.contact().all();

		app.contact().initNewContactCreation();

		ContactData contact = new ContactData()
						.withFirstName("First Name")
						.withLastName("Last Name")
						.withAddress("Address")
						.withEmail("Test@email.com")
						.withMobilePhone("Test Phone2")
						.withGroup("test1");

		app.contact().create(contact, true);
		app.contact().returnToHomePage();

		Set<ContactData> after = app.contact().all();
		Assert.assertEquals(after.size(), before.size() + 1);

		contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
		before.add(contact);
		Assert.assertEquals(before, after);
	}
}
