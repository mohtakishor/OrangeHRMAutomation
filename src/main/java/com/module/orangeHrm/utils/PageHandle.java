package com.module.orangeHrm.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;

public class PageHandle {
	public static void selectFromDropDown(WebElement element, String value) {
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(value);
	}

	public static void clickAndSend(WebElement element, String value) {
		element.click();
		element.sendKeys(value);
	}

	public static String selectRandomOption(WebElement options) {
		Select dropDown = new Select(options);
		List<WebElement> optionList = dropDown.getOptions();
		int index = RandomData.getRandomNumberBetween(1, optionList.size() - 1);
		String selectedText = optionList.get(index).getText();

		dropDown.selectByIndex(index);
		return selectedText;
	}

	public static void waitUntilDownloadsComplete(WebDriver driver, File file) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofMillis(100));
		wait.until(x -> file.exists());
	}
}