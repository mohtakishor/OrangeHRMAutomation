package com.module.orangeHrm.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.module.orangeHrm.utils.PageHandle;

import io.qameta.allure.Step;

public class LoginPage {

	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	private String loginId = System.getProperty("id");
	private String loginPassword = System.getProperty("password");

	WebDriver driver;
	By userName = By.id("txtUsername");
	By userPassword = By.name("txtPassword");
	By loginButton = By.xpath("//input[@id='btnLogin']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Enter user crendtial : UserID")
	public LoginPage enterUserName() {
		WebElement enterId = driver.findElement(userName);
		if (loginId == null) {
			loginId = "Admin";
		}
		PageHandle.clickAndSend(enterId, loginId);
		logger.debug("Login as " + loginId);
		return new LoginPage(driver);
	}

	@Step("Enter user crendtial : Password")
	public LoginPage enterPassword() {
		WebElement enterPassword = driver.findElement(userPassword);
		if (loginPassword == null) {
			loginPassword = "admin123";
		}
		PageHandle.clickAndSend(enterPassword, loginPassword);
		logger.debug("Enter password as :-" + loginPassword);
		return new LoginPage(driver);
	}

	@Step("Click on loginButton")
	public WebElement loginButton() {
		logger.info("clicked on loggin button");
		return driver.findElement(loginButton);
	}
}
