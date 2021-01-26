package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

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
	public void testContactDelete() throws InterruptedException {

		List<ContactData> before = app.contact().list();
		int index = before.size() - 1;

		app.contact().select(index);
		app.contact().delete();
		app.contact().submitDeletion();
		app.contact().waitForLoadingHomePage();

		List<ContactData> after = app.contact().list();
		app.contact().setShortImplicityWait();
		Assert.assertEquals(after.size(), before.size() - 1);

		before.remove(index);
		Assert.assertEquals(before, after);
	}
}
