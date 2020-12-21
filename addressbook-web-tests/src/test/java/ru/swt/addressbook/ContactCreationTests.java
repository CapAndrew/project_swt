package ru.swt.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests {
	private WebDriver wd;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.get("http://localhost/addressbook/index.php");
		login("admin", "secret");
	}

	@Test
	public void testContactsCreation() throws Exception {

		initNewContactCreation();
		fillContactForm(new ContactData(
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
		submitContactCreation();
		goToHomePage();

	}

	private void goToHomePage() {
		wd.findElement(By.linkText("home page")).click();
	}

	private void submitContactCreation() {
		wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
	}

	private void fillContactForm(ContactData contactData) {
		wd.findElement(By.name("firstname")).click();
		wd.findElement(By.name("firstname")).clear();
		wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
		wd.findElement(By.name("middlename")).clear();
		wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
		wd.findElement(By.name("lastname")).clear();
		wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
		wd.findElement(By.name("nickname")).clear();
		wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
		wd.findElement(By.name("title")).clear();
		wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
		wd.findElement(By.name("company")).clear();
		wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
		wd.findElement(By.name("address")).clear();
		wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
		wd.findElement(By.name("home")).clear();
		wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
		wd.findElement(By.name("mobile")).clear();
		wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
		wd.findElement(By.name("work")).clear();
		wd.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
		wd.findElement(By.name("fax")).clear();
		wd.findElement(By.name("fax")).sendKeys(contactData.getFaxPhone());
		wd.findElement(By.name("email")).clear();
		wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
		wd.findElement(By.name("email2")).clear();
		wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
		wd.findElement(By.name("email3")).clear();
		wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
		wd.findElement(By.name("homepage")).clear();
		wd.findElement(By.name("homepage")).sendKeys(contactData.getHomePage());
		wd.findElement(By.name("bday")).click();
		new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDayOfBDay());
		wd.findElement(By.xpath("//option[@value='" + contactData.getDayOfBDay() + "']")).click();
		wd.findElement(By.name("bmonth")).click();
		new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonthOfBDay());
		wd.findElement(By.xpath("//option[@value='" + contactData.getMonthOfBDay() + "']")).click();
		wd.findElement(By.name("byear")).clear();
		wd.findElement(By.name("byear")).sendKeys(contactData.getYearOfBDay());
		wd.findElement(By.name("aday")).click();
		new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getDayOfAnniversary());
		wd.findElement(By.xpath("(//option[@value='" + contactData.getDayOfAnniversary() + "'])[2]")).click();
		wd.findElement(By.name("amonth")).click();
		new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getMonthOfAnniversary());
		wd.findElement(By.xpath("(//option[@value='" + contactData.getMonthOfAnniversary() + "'])[2]")).click();
		wd.findElement(By.name("ayear")).clear();
		wd.findElement(By.name("ayear")).sendKeys(contactData.getYearOfAnniversary());
		wd.findElement(By.name("address2")).clear();
		wd.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
		wd.findElement(By.name("phone2")).clear();
		wd.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
		wd.findElement(By.name("notes")).clear();
		wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
	}

	private void initNewContactCreation() {
		wd.findElement(By.linkText("add new")).click();
	}

	private void login(String username, String password) {
		wd.findElement(By.name("user")).clear();
		wd.findElement(By.name("user")).sendKeys(username);
		wd.findElement(By.name("pass")).click();
		wd.findElement(By.name("pass")).clear();
		wd.findElement(By.name("pass")).sendKeys(password);
		wd.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		wd.findElement(By.linkText("Logout")).click();
		wd.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			wd.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
