package ru.swt.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {
	protected ApplicationManager app;
	protected WebDriver wd;


	public HelperBase(ApplicationManager app) {
		this.app = app;
		this.wd = app.getDriver();
	}

	public void type(By locator, String text) {
		click(locator);
		if (text != null) {
			String existingText = wd.findElement(locator).getAttribute("value");
			if (!text.equals(existingText)) {
				wd.findElement(locator).clear();
				wd.findElement(locator).sendKeys(text);
			}
		}
	}

	public void attach(By locator, File file) {
		if (file != null) {
			wd.findElement(locator).sendKeys(file.getAbsolutePath());
		}
	}

	public void click(By locator) {
		wd.findElement(locator).click();
	}

	public void selectFromListByName(By locator, String text) {
		click(locator);
		new Select(wd.findElement(locator)).selectByVisibleText(text);
	}

	public void selectFromListByValue(By locator, String value) {
		click(locator);
		new Select(wd.findElement(locator)).selectByValue(value);
	}

	public void acceptAlert() {
		wd.switchTo().alert().accept();
	}

	public boolean isElementPresent(By locator) {
		try {
			wd.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
