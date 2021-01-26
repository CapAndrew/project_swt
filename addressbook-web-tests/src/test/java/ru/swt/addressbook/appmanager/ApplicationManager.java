package ru.swt.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	private WebDriver wd;

	public final long IMPL_TIME = 1;

	private ContactHelper contactHelper;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private SessionHelper sessionHelper;
	private String browser;

	public ApplicationManager(String browser) {
		this.browser = browser;
	}

	public void init() {
		if (browser.equals(BrowserType.FIREFOX)) {
			wd = new FirefoxDriver();
		} else if (browser.equals(BrowserType.CHROME)) {
			wd = new ChromeDriver();
		} else if (browser.equals(BrowserType.IE)) {
			wd = new InternetExplorerDriver();
		}
		wd.manage().timeouts().implicitlyWait(IMPL_TIME, TimeUnit.SECONDS);
		wd.get("https://localhost/addressbook/index.php");
		groupHelper = new GroupHelper(wd);
		navigationHelper = new NavigationHelper(wd);
		sessionHelper = new SessionHelper(wd);
		contactHelper = new ContactHelper(wd);
		sessionHelper.login("admin", "secret");
	}


	public void stop() {
		sessionHelper.logout();
		wd.quit();
	}

	public GroupHelper group() {
		return groupHelper;
	}

	public NavigationHelper goTO() {
		return navigationHelper;
	}

	public ContactHelper contact() {
		return contactHelper;
	}
}
