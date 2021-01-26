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
			app.contact().create(new ContactData(
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
