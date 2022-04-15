package com.module.orangeHrm.candiateDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.module.orangeHrm.utils.Constants;
import com.module.orangeHrm.utils.PageHandle;
import com.module.orangeHrm.utils.RandomData;

public class CanditureForm {
	WebDriver driver;
	static String candidateFirstName = "";
	static String candidateLastName = "";
	String actuallStatus="";

	public CanditureForm(WebDriver driver) {
		this.driver = driver;
	}

	By enterFirstName = By.cssSelector("input#addCandidate_firstName");
	By enterLastName = By.cssSelector("input#addCandidate_lastName");
	By enterEmailId = By.xpath("//input[@id='addCandidate_email']");
	By enterContactNumebr = By.xpath("//input[@id='addCandidate_contactNo']");
	By selectRole = By.xpath("//select[@name='addCandidate[vacancy]']");
	By uploadResume = By.xpath("//input[@id='addCandidate_resume']");
	By saveCanditureDetail = By.id("btnSave");
	By getStatusText = By.xpath("//span[text()='Status: Application Initiated']");

	public CanditureForm firstName() {
		WebElement firstName = driver.findElement(enterFirstName);
		candidateFirstName = RandomData.getRandomName();
		PageHandle.clickAndSend(firstName, candidateFirstName);
		return new CanditureForm(driver);
	}

	public CanditureForm lastName() {
		WebElement lastName = driver.findElement(enterLastName);
		candidateLastName = RandomData.getRandomName();
		PageHandle.clickAndSend(lastName, candidateLastName);
		return new CanditureForm(driver);
	}

	public CanditureForm emailId() {
		WebElement emailId = driver.findElement(enterEmailId);
		PageHandle.clickAndSend(emailId, RandomData.getRandomName() + "@gmail.com");
		return new CanditureForm(driver);
	}

	public CanditureForm contactNum() {
		WebElement contactNum = driver.findElement(enterContactNumebr);
		PageHandle.clickAndSend(contactNum, RandomData.getRandomNumber());
		return new CanditureForm(driver);
	}

	public CanditureForm roleSelection() {
		WebElement dropDownRoleSelection = driver.findElement(selectRole);
		PageHandle.selectRandomOption(dropDownRoleSelection);
		return new CanditureForm(driver);
	}

	public CanditureForm uploadResume() {
		WebElement uploadDocs = driver.findElement(uploadResume);
		uploadDocs.sendKeys(Constants.RESUMEPATH);
		return new CanditureForm(driver);
	}

	public CanditureForm clickSaveButton() {
		WebElement saveButton = driver.findElement(saveCanditureDetail);
		saveButton.click();
		return new CanditureForm(driver);
	}

	public CanditureForm getApplicationStatus() {
		WebElement getStatus = driver.findElement(getStatusText);
		actuallStatus = getStatus.getText();
		return new CanditureForm(driver);
	}
	
	public void assertApplicationStatus() {
		Assert.assertEquals(actuallStatus, Constants.EXPECTEDRESULT);
	}

}
