package ru.swt.addressbook.tests;

import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		Contacts before = app.contact().all();

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

		Contacts after = app.contact().all();
		assertThat(after.size(), equalTo(before.size() + 1));
		assertThat(after, equalTo(
						before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
	}
}
