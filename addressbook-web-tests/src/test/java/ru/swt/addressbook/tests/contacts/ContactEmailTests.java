package ru.swt.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		if (app.contact().all().size() == 0) {
			app.contact().create(new ContactData()
											.withFirstName("First Name")
											.withLastName("Last Name")
											.withAddress("Address")
											.withEmail("Test@email.com")
											.withMobilePhone("Test Phone2")
											.withEmail("Test@email.com")
											.withEmail2("test-232@gmail.com")
											.withEmail3("qweqwe.asdas@asdas-asd.com"),
							true);
			app.contact().returnToHomePage();
		}
	}

	@Test
	public void testContactEmails() {
		app.goTO().homePage();
		ContactData contact = app.contact().all().iterator().next();
		ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

		assertThat(contact.getAllEmails(), equalTo(app.contact().mergeEmails(contactInfoFromEditForm)));
	}

}
