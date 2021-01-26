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

		ContactData contact = new ContactData(
						"Test Name",
						"Test Surname",
						"Test Lastname",
						"Test Nick",
						"Test Title",
						"Test Company",
						"Test Address",
						"Test Home",
						"Test Mobile",
						"Test Work",
						"Test Fax",
						"Test@email.com",
						"Test2@email.com",
						"Test3@email.com",
						"asd",
						"Test Address2",
						"Test Phone2",
						"Test Notes",
						"1",
						"May",
						"1982",
						"1",
						"March",
						"1980",
						"test1");

		app.contact().create(contact,true);
		app.contact().returnToHomePage();

		List<ContactData> after = app.contact().list();
		Assert.assertEquals(after.size(), before.size() + 1);

		contact.setId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}
