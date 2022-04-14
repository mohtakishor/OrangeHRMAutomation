package com.module.orangeHrm.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.module.orangeHrm.utils.PageHandle;

public class LoginPage {

	WebDriver driver;
	By userName = By.id("txtUsername");
	By userPassword = By.name("txtPassword");
	By loginButton = By.xpath("//input[@id='btnLogin']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage enterUserName() {
		WebElement enterId = driver.findElement(userName);
		PageHandle.clickAndSend(enterId, "Admin");
		return new LoginPage(driver);
	}

	public LoginPage enterPassword() {
		WebElement enterPassword=driver.findElement(userPassword);
		PageHandle.clickAndSend(enterPassword, "admin123");
		return new LoginPage(driver);
	}

	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}

}
