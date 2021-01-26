package ru.swt.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.model.Contacts;

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
		if (contactData.getFirstName() != null)
			type(By.name("firstname"), contactData.getFirstName());
		if (contactData.getMiddleName() != null)
			type(By.name("middlename"), contactData.getMiddleName());
		if (contactData.getLastName() != null)
			type(By.name("lastname"), contactData.getLastName());
		if (contactData.getNickName() != null)
			type(By.name("nickname"), contactData.getNickName());
		if (contactData.getTitle() != null)
			type(By.name("title"), contactData.getTitle());
		if (contactData.getCompany() != null)
			type(By.name("company"), contactData.getCompany());
		if (contactData.getAddress() != null)
			type(By.name("address"), contactData.getAddress());
		if (contactData.getHomePhone() != null)
			type(By.name("home"), contactData.getHomePhone());
		if (contactData.getMobilePhone() != null)
			type(By.name("mobile"), contactData.getMobilePhone());
		if (contactData.getWorkPhone() != null)
			type(By.name("work"), contactData.getWorkPhone());
		if (contactData.getFaxPhone() != null)
			type(By.name("fax"), contactData.getFaxPhone());
		if (contactData.getEmail() != null)
			type(By.name("email"), contactData.getEmail());
		if (contactData.getEmail2() != null)
			type(By.name("email2"), contactData.getEmail2());
		if (contactData.getEmail3() != null)
			type(By.name("email3"), contactData.getEmail3());
		if (contactData.getHomePage() != null)
			type(By.name("homepage"), contactData.getHomePage());
		if (contactData.getDayOfBDay() != null)
			selectFromList(By.name("bday"), contactData.getDayOfBDay());
		if (contactData.getMonthOfBDay() != null)
			selectFromList(By.name("bmonth"), contactData.getMonthOfBDay());
		if (contactData.getYearOfBDay() != null)
			type(By.name("byear"), contactData.getYearOfBDay());
		if (contactData.getDayOfAnniversary() != null)
			selectFromList(By.name("aday"), contactData.getDayOfAnniversary());
		if (contactData.getMonthOfAnniversary() != null)
			selectFromList(By.name("amonth"), contactData.getMonthOfAnniversary());
		if (contactData.getYearOfAnniversary() != null)
			type(By.name("ayear"), contactData.getYearOfAnniversary());
		if (contactData.getAddress2() != null)
			type(By.name("address2"), contactData.getAddress2());
		if (contactData.getPhone2() != null)
			type(By.name("phone2"), contactData.getPhone2());
		if (contactData.getNotes() != null)
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

	public void selectById(int id) {
		wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
	}

	public void deleteSelectedContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void submitDeletion() {
		acceptAlert();
	}

	public void initContactModification(int id) {
		click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
	}

	public void submitContactModification() {
		click(By.name("update"));
	}

	public void create(ContactData contact, boolean creation) {
		initNewContactCreation();
		fillContactForm(contact, creation);
		submitContactCreation();
		contactCache = null;
		returnToHomePage();
	}


	public void modify(ContactData modifiedContact, ContactData newContact) {
		initContactModification(modifiedContact.getId());
		fillContactForm(newContact, false);
		submitContactModification();
		contactCache = null;
		returnToHomePage();
	}


	public void delete(ContactData deletedContact) {
		selectById(deletedContact.getId());
		deleteSelectedContact();
		submitDeletion();
		contactCache = null;
		waitForLoadingHomePage();
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
		wd.findElement(By.id("search_count")).click();
	}

	public boolean isThereAContact() {
		return isElementPresent(By.name("selected[]"));
	}

	public int count() {
		return wd.findElements(By.name("selected[]")).size();
	}

	private Contacts contactCache = null;

	public Contacts all() {
		if (contactCache != null) {
			return new Contacts(contactCache);
		}

		contactCache = new Contacts();
		List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));

		for (WebElement element : elements) {
			int id = Integer.parseInt(element.findElement(By.xpath(".//td/input")).getAttribute("id"));
			String lastName = element.findElement(By.xpath(".//td[2]")).getText();
			String firstName = element.findElement(By.xpath(".//td[3]")).getText();
			String address = element.findElement(By.xpath(".//td[4]")).getText();
			String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
			String allPhones = element.findElement(By.xpath(".//td[6]")).getText();

			ContactData contact = new ContactData()
							.withId(id)
							.withFirstName(firstName)
							.withLastName(lastName)
							.withAddress(address)
							.withAllEmails(allEmails)
							.withAllPhones(allPhones);

			contactCache.add(contact);
		}
		return new Contacts(contactCache);
	}

	public ContactData infoFromEditForm(ContactData contact) {
		initContactModification(contact.getId());
		String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
		String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
		String home = wd.findElement(By.name("home")).getAttribute("value");
		String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
		String work = wd.findElement(By.name("work")).getAttribute("value");
		String address = wd.findElement(By.name("address")).getAttribute("value");
		String email = wd.findElement(By.name("email")).getAttribute("value");
		String email2 = wd.findElement(By.name("email2")).getAttribute("value");
		String email3 = wd.findElement(By.name("email3")).getAttribute("value");
		wd.navigate().back();

		return new ContactData()
						.withId(contact.getId())
						.withFirstName(firstname)
						.withLastName(lastname)
						.withHomePhone(home)
						.withMobilePhone(mobile)
						.withWorkPhone(work)
						.withAddress(address)
						.withEmail(email)
						.withEmail2(email2)
						.withEmail3(email3);
	}
}
