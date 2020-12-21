package ru.swt.addressbook.tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() throws Exception {

		app.initNewContactCreation();
		app.fillContactForm(new ContactData(
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
						"January",
						"1980",
						"1",
						"January",
						"1980"));
		app.submitContactCreation();
		app.goToHomePage();

	}
}
