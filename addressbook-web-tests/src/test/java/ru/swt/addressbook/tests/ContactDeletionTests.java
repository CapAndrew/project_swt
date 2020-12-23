package ru.swt.addressbook.tests;

import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

	@Test
	public void testContactDelete() {
		if(!app.getContactHelper().isThereAContact()){
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
		app.getContactHelper().selectContact();
		app.getContactHelper().deleteSelectedContacts();
		app.getContactHelper().submitContactDelete();
	}
}
