package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() throws Exception {
		List<ContactData> before = app.contact().list();

		app.contact().initNewContactCreation();

		ContactData contact = new ContactData()
						.withFirstName("First Name")
						.withLastName("Last Name")
						.withAddress("Address")
						.withEmail("Test@email.com")
						.withMobilePhone("Test Phone2")
						.withGroup("test1");

		app.contact().create(contact,true);
		app.contact().returnToHomePage();

		List<ContactData> after = app.contact().list();
		Assert.assertEquals(after.size(), before.size() + 1);

		contact.withId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}
