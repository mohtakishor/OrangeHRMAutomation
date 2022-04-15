package com.module.orangeHrm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.modeule.orangeHrm.homePage.HomePage;
import com.module.orangeHrm.browsers.ChromeBrowser;
import com.module.orangeHrm.candiateDetails.CanditureForm;
import com.module.orangeHrm.candiateDetails.DownloadCandidateResume;
import com.module.orangeHrm.loginPage.LoginPage;
import com.module.orangeHrm.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BasicTestCase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage canditateDetails;
	CanditureForm canditureForm;
	DownloadCandidateResume downloadCandidateResume;

	@BeforeMethod
	@Description("Open Chrome as an broswer and to go the OrangeHrm URL")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserStack\\chromedriver.exe");
		driver = new ChromeBrowser().getDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
	}

	@BeforeMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Login with the valid credentials")
	public void toLoginAsAdmin() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserName().enterPassword().loginButton().click();
	}

	@Description("Clicking on candidate and then to add the candidate profile")
	public void selectingCandidateToUpdateProfile() {
		canditateDetails = new HomePage(driver).selectRecruitment().selectCandidate().clickOnAdd();
	}

	@Test(priority = 1, description = "Creating canditate details")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Giving the details of the candiate and submitting the resume")
	public void createANewCandidateProfile() {
		selectingCandidateToUpdateProfile();
		canditureForm = new CanditureForm(driver);
		canditureForm.firstName().lastName().emailId().contactNum().roleSelection().uploadResume().clickSaveButton()
				.getApplicationStatus().assertApplicationStatus();
	}

	@Test(description = "Downloading the resume")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Search for the candidate which got created and download the resume")
	public void enter_userDetails() {
		canditateDetails = new HomePage(driver).selectRecruitment().selectCandidate();
		downloadCandidateResume = new DownloadCandidateResume(driver).enterCandidateName().clickOnSearchButton()
				.downloadResume();
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}