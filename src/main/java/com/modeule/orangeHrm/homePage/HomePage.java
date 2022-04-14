package com.modeule.orangeHrm.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By clickOnRecruitment = By.id("menu_recruitment_viewRecruitmentModule");
	By clickOnCandidate = By.id("menu_recruitment_viewCandidates");
	By clickOnAdd = By.cssSelector("input#btnAdd");

	public HomePage selectRecruitment() {
		driver.findElement(clickOnRecruitment).click();
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
