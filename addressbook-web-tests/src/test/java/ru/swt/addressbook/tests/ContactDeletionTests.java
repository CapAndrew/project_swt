package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		if (!app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData(
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
											"test1"),
							true);
			app.getNavigationHelper().goToHomePage();
		}
	}

	@Test
	public void testContactDelete() throws InterruptedException {

		List<ContactData> before = app.getContactHelper().getContactList();
		int index = before.size() - 1;

		app.getContactHelper().selectContact(index);
		app.getContactHelper().deleteSelectedContacts();
		app.getContactHelper().submitContactDelete();
		app.getContactHelper().waitForLoadingHomePage();

		List<ContactData> after = app.getContactHelper().getContactList();
		app.getContactHelper().setShortImplicityWait();
		Assert.assertEquals(after.size(), before.size() - 1);

		before.remove(index);
		Assert.assertEquals(before, after);
	}
}
