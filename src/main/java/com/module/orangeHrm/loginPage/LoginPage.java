package com.module.orangeHrm.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.module.orangeHrm.utils.PageHandle;

import io.qameta.allure.Step;

public class LoginPage {
	
	private String loginId=System.getProperty("id");
	private String loginPassowrd=System.getProperty("password");

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
		PageHandle.clickAndSend(enterId,  loginId);
		return new LoginPage(driver);
	}

	@Step("Enter user crendtial : Password")
	public LoginPage enterPassword() {
		WebElement enterPassword = driver.findElement(userPassword);
		PageHandle.clickAndSend(enterPassword, loginPassowrd);
		return new LoginPage(driver);
	}

	@Step("Click on loginButton")
	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}

}
