package ru.swt.mantis.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

	public SessionHelper(ApplicationManager app) {
		super(app);
	}

	public void login(String username, String password) {
		type(By.name("username"), username);
		type(By.name("password"), password);
		click(By.cssSelector("input[value='Login']"));
	}

	public void logout() {
		click(By.cssSelector("a[href='/mantisbt-1.2.19/logout_page.php']"));
	}

}
