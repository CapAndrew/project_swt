package ru.swt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
	protected WebDriver wd;

	public HelperBase(WebDriver wd) {
		this.wd = wd;
	}

	protected void type(By locator, String text) {
		click(locator);
		wd.findElement(locator).clear();
		wd.findElement(locator).sendKeys(text);
	}

	protected void click(By locator) {
		wd.findElement(locator).click();
	}

	protected void selectFromList(By locator, String locatorName, String text) {
		wd.findElement(locator).click();
		new Select(wd.findElement(locator)).selectByVisibleText(text);
		wd.findElement(By.cssSelector("select[name=\"" + locatorName + "\"] > option[value=\"" + text + "\"]")).click();
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
