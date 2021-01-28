package ru.swt.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.swt.addressbook.appmanager.ApplicationManager;
import ru.swt.addressbook.model.ContactData;
import ru.swt.addressbook.model.Contacts;
import ru.swt.addressbook.model.GroupData;
import ru.swt.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestBase {

	Logger logger = LoggerFactory.getLogger(TestBase.class);

	protected static final ApplicationManager app
					= new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

	@BeforeSuite
	public void setUp() throws IOException {
		app.init();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		app.stop();
	}

	@BeforeMethod
	public void logTestStart(Method m, Object[] p) {
		logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));
	}

	@AfterMethod(alwaysRun = true)
	public void logTestStop(Method m, Object[] p) {
		logger.info("Stop test " + m.getName() + "with parameters" + Arrays.asList(p));
	}

	/*
	 * -DverifyUI
	 * */
	public void verifyGorupListInUI() {
		if (Boolean.getBoolean("verifyUI")) {
			Groups dbGroups = app.db().groups();
			Groups uiGroups = app.group().all();

			MatcherAssert.assertThat(uiGroups, CoreMatchers.equalTo(dbGroups.stream()
							.map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
							.collect(Collectors.toSet())));
		}
	}

	/*
	 * -DverifyUI
	 * */
	public void verifyContactListInUI() {
		if (Boolean.getBoolean("verifyUI")) {
			Contacts dbContacts = app.db().contacts();
			Contacts uiContacts = app.contact().all();

			MatcherAssert.assertThat(uiContacts, CoreMatchers.equalTo(dbContacts.stream()
							.map((c) -> new ContactData()
											.withId(c.getId())
											.withLastName(c.getLastName())
											.withFirstName(c.getFirstName())
											.withAddress(c.getAddress())
							).collect(Collectors.toSet())));
		}
	}
}
