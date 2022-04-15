package com.modeule.orangeHrm.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.module.orangeHrm.utils.Constants;

import io.netty.util.Constant;

public class HomePage {
	WebDriver driver;
	static String loginValidation = "";

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By clickOnRecruitment = By.id("menu_recruitment_viewRecruitmentModule");
	By clickOnCandidate = By.id("menu_recruitment_viewCandidates");
	By clickOnAdd = By.cssSelector("input#btnAdd");

	public HomePage selectRecruitment() {
		WebElement clickOnRecuirtment = driver.findElement(clickOnRecruitment);
		clickOnRecuirtment.click();
		loginValidation = clickOnRecuirtment.getText();
		Assert.assertEquals(loginValidation, Constants.EXPECTEDLOGINPAGEVALIDATION);
		return new HomePage(driver);
	}

	public HomePage selectCandidate() {
		driver.findElement(clickOnCandidate).click();
		return new HomePage(driver);
	}

	public HomePage clickOnAdd() {
		driver.findElement(clickOnAdd).click();
		return new HomePage(driver);
	}

}
