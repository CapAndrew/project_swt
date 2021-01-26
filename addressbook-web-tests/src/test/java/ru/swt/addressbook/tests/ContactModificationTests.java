package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		if (app.contact().list().size() == 0) {
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
	public void testContactModification() throws InterruptedException {

		List<ContactData> before = app.contact().list();
		int positionOfContact = 0;
		ContactData newContactData = new ContactData()
						.withId(before.get(positionOfContact).getId())
						.withFirstName("First Name2")
						.withLastName("Last Name2")
						.withAddress("Address2")
						.withEmail("Test@email.com2")
						.withMobilePhone("Test Phone22")
						.withGroup("test12");

		app.contact().modify(positionOfContact, newContactData);
		app.contact().waitForLoadingHomePage();

		List<ContactData> after = app.contact().list();
		Assert.assertEquals(after.size(), before.size());

		app.contact().setShortImplicityWait();

		before.remove(positionOfContact);
		before.add(newContactData);

		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}