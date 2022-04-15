package com.modeule.orangeHrm.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.module.orangeHrm.utils.Constants;

import io.qameta.allure.Step;

public class HomePage {
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
		Assert.assertEquals(loginValidation, Constants.EXPECTEDLOGINPAGEVALIDATION);
		clickOnRecuirtment.click();
		return new HomePage(driver);
	}

	@Step("Clicked on candidate tab")
	public HomePage selectCandidate() {
		driver.findElement(clickOnCandidate).click();
		return new HomePage(driver);
	}

	@Step("Clicked on Add button to update the candidate profile")
	public HomePage clickOnAdd() {
		driver.findElement(clickOnAdd).click();
		return new HomePage(driver);
	}

}
