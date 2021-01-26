package ru.swt.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.swt.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {

	public ContactHelper(WebDriver wd) {
		super(wd);
	}

	public void submitContactCreation() {
		click(By.xpath("(//input[@name='submit'])[2]"));
	}

	public void fillContactForm(ContactData contactData, boolean creation) {
		type(By.name("firstname"), contactData.getFirstName());
		type(By.name("middlename"), contactData.getMiddleName());
		type(By.name("lastname"), contactData.getLastName());
		type(By.name("nickname"), contactData.getNickName());
		type(By.name("title"), contactData.getTitle());
		type(By.name("company"), contactData.getCompany());
		type(By.name("address"), contactData.getAddress());
		type(By.name("home"), contactData.getHomePhone());
		type(By.name("mobile"), contactData.getMobilePhone());
		type(By.name("work"), contactData.getWorkPhone());
		type(By.name("fax"), contactData.getFaxPhone());
		type(By.name("email"), contactData.getEmail());
		type(By.name("email2"), contactData.getEmail2());
		type(By.name("email3"), contactData.getEmail3());
		type(By.name("homepage"), contactData.getHomePage());
		selectFromList(By.name("bday"), contactData.getDayOfBDay());
		selectFromList(By.name("bmonth"), contactData.getMonthOfBDay());
		type(By.name("byear"), contactData.getYearOfBDay());
		selectFromList(By.name("aday"), contactData.getDayOfAnniversary());
		selectFromList(By.name("amonth"), contactData.getMonthOfAnniversary());
		type(By.name("ayear"), contactData.getYearOfAnniversary());
		type(By.name("address2"), contactData.getAddress2());
		type(By.name("phone2"), contactData.getPhone2());
		type(By.name("notes"), contactData.getNotes());

		if (creation) {
			new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
		} else {
			Assert.assertFalse(isElementPresent(By.name("new_group")));
		}
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void select(int index) {
		wd.findElements(By.name("selected[]")).get(index).click();
	}

	public void delete() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void submitDeletion() {
		acceptAlert();
	}

	public void initContactModification(int position) {
		if (position == 0) {
			click(By.xpath("(//img[@alt='Edit'])"));
		} else {
			click(By.xpath("(//img[@alt='Edit'])" + position));
		}
	}

	public void submitContactModification() {
		click(By.name("update"));
	}

	public void create(ContactData contact, boolean creation) {
		initNewContactCreation();
		fillContactForm(contact, creation);
		submitContactCreation();
	}


	public void modify(int positionOfContact, ContactData newContactData) {
		initContactModification(positionOfContact);
		fillContactForm(newContactData, false);
		submitContactModification();
		returnToHomePage();
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void setShortImplicityWait() {
		wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	public void setLongImlicityWait() {
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void waitForLoadingHomePage() {
		setLongImlicityWait();
		wd.findElement(By.id("maintable")).click();
	}

	public boolean isThereAContact() {
		return isElementPresent(By.name("selected[]"));
	}

	public List<ContactData> list() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));

		for (WebElement element : elements) {
			String lastName = element.findElement(By.xpath(".//td[2]")).getText();
			String firstName = element.findElement(By.xpath(".//td[3]")).getText();
			int id = Integer.parseInt(element.findElement(By.xpath(".//td/input")).getAttribute("id"));

			ContactData contact = new ContactData(
							id,
							firstName,
							lastName
			);

			contacts.add(contact);
		}

		return contacts;
	}
}
