package ru.swt.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {

	@Test
	public void testContactDelete() {
		app.getContactHelper().selectContact();
		app.getContactHelper().deleteSelectedContacts();
		app.getContactHelper().submitContactDelete();
	}
}
