package ru.swt.addressbook.tests;

import ru.swt.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void testContactModification() throws InterruptedException {
		//Указывать в формате [*], где * в квадратных скобках - позиция контакта в списке.
		//Если контакт первый - указывать пустое значение
		app.getContactHelper().initContactModification("");
		app.getContactHelper().fillContactForm(new ContactData(
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
										null),
						false
		);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();
	}
}