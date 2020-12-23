package ru.swt.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import ru.swt.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	public void selectContact() {
		click(By.name("selected[]"));
	}

	public void deleteSelectedContacts() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void submitContactDelete() {
		acceptAlert();
	}

	public void initContactModification(String position) {
		click(By.xpath("(//img[@alt='Edit'])" + position));
	}

	public void submitContactModification() {
		click(By.name("update"));
	}
}
