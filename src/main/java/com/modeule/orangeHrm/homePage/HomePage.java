package com.modeule.orangeHrm.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.module.orangeHrm.utils.Constants;

import io.qameta.allure.Step;

public class HomePage {

	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	WebDriver driver;
	static String loginValidation = "";

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By clickOnRecruitment = By.id("menu_recruitment_viewRecruitmentModule");
	By clickOnCandidate = By.id("menu_recruitment_viewCandidates");
	By clickOnAdd = By.cssSelector("input#btnAdd");

	@Step("validation on logged in successfully")
	public HomePage selectRecruitment() {
		WebElement clickOnRecuirtment = driver.findElement(clickOnRecruitment);
		loginValidation = clickOnRecuirtment.getText();
		logger.info("Click on " + loginValidation);
		Assert.assertEquals(loginValidation, Constants.EXPECTEDLOGINPAGEVALIDATION);
		clickOnRecuirtment.click();
		return new HomePage(driver);
	}

	@Step("Clicked on candidate tab")
	public HomePage selectCandidate() {
		driver.findElement(clickOnCandidate).click();
		logger.info("Click on candidate tab");
		return new HomePage(driver);
	}

	@Step("Clicked on Add button to update the candidate profile")
	public HomePage clickOnAdd() {
		driver.findElement(clickOnAdd).click();
		logger.info("Click on Add button");
		return new HomePage(driver);
	}

}
