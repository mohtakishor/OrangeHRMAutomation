package com.module.orangeHrm.candiateDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.module.orangeHrm.utils.Constants;
import com.module.orangeHrm.utils.PageHandle;
import com.module.orangeHrm.utils.RandomData;

import io.qameta.allure.Step;

public class CanditureForm {
	private static final Logger logger = LoggerFactory.getLogger(CanditureForm.class);

	WebDriver driver;
	static String candidateFirstName = "";
	static String candidateLastName = "";
	static String actuallStatus = "";

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
	By getStatusText = By.xpath("//span[@class=\"status\"]");

	@Step("Enter the first name of Candidate")
	public CanditureForm firstName() {
		WebElement firstName = driver.findElement(enterFirstName);
		candidateFirstName = RandomData.getRandomName();
		PageHandle.clickAndSend(firstName, candidateFirstName);
		logger.info("Enter the first name as :- " + candidateFirstName);
		return new CanditureForm(driver);
	}

	@Step("Enter the last name of Candidate")
	public CanditureForm lastName() {
		WebElement lastName = driver.findElement(enterLastName);
		candidateLastName = RandomData.getRandomName();
		PageHandle.clickAndSend(lastName, candidateLastName);
		logger.info("Enter the last name as :- " + candidateFirstName);
		return new CanditureForm(driver);
	}

	@Step("Enter the email id of Candidate")
	public CanditureForm emailId() {
		WebElement emailId = driver.findElement(enterEmailId);
		PageHandle.clickAndSend(emailId, RandomData.getRandomName() + "@gmail.com");
		logger.info("Enter the email id");
		return new CanditureForm(driver);
	}

	@Step("Enter the contact number of Candidate")
	public CanditureForm contactNum() {
		WebElement contactNum = driver.findElement(enterContactNumebr);
		PageHandle.clickAndSend(contactNum, RandomData.getRandomNumber());
		logger.info("Enter the contact number");
		return new CanditureForm(driver);
	}

	@Step("Select the role for which the candidate is applying")
	public CanditureForm roleSelection() {
		WebElement dropDownRoleSelection = driver.findElement(selectRole);
		PageHandle.selectRandomOption(dropDownRoleSelection);
		logger.info("Select the role");
		return new CanditureForm(driver);
	}

	@Step("Upload the resume for the Candidate")
	public CanditureForm uploadResume() {
		WebElement uploadDocs = driver.findElement(uploadResume);
		uploadDocs.sendKeys(Constants.RESUMEPATH);
		logger.info("Upload the resume from the given path :-" + Constants.RESUMEPATH);
		return new CanditureForm(driver);
	}

	@Step("Click on the save button to save the data for the candidate")
	public CanditureForm clickSaveButton() {
		WebElement saveButton = driver.findElement(saveCanditureDetail);
		saveButton.click();
		logger.info("Click on save button to save the canditure details");
		return new CanditureForm(driver);
	}

	@Step("Validate for the status on candidate profile")
	public CanditureForm getApplicationStatus() {
		WebElement getStatus = driver.findElement(getStatusText);
		actuallStatus = getStatus.getText();
		logger.info("Status of the candidate application :-" + actuallStatus);
		return new CanditureForm(driver);
	}

	@Step("Assertion on candidate profile status")
	public void assertApplicationStatus() {
		Assert.assertEquals(actuallStatus, Constants.EXPECTEDRESULT);
	}

}
