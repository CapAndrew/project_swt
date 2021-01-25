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
	public void testContactModification() throws InterruptedException {

		List<ContactData> before = app.getContactHelper().getContactList();
		int positionOfContact = 0;
		ContactData newContactData = new ContactData(
						before.get(positionOfContact).getId(),
						"Test Name1",
						"Test Surname2",
						"Test Lastname3",
						"Test Nick4",
						"Test Title1",
						"Test Company2",
						"Test Address3",
						"Test Home4",
						"Test Mobile1",
						"Test Work2",
						"Test Fax3",
						"Test@email.com4",
						"Test2@email.com1",
						"Test3@email.com2",
						"asd3",
						"Test Address24",
						"Test Phone21",
						"Test Notes2",
						"12",
						"March",
						"1981",
						"11",
						"May",
						"1982",
						null);

		app.getContactHelper().modifyContact(positionOfContact, newContactData);
		app.getContactHelper().waitForLoadingHomePage();

		List<ContactData> after = app.getContactHelper().getContactList();
		Assert.assertEquals(after.size(), before.size());

		app.getContactHelper().setShortImplicityWait();

		before.remove(positionOfContact);
		before.add(newContactData);

		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}