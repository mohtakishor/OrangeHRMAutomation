package com.module.orangeHrm.tests;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.modeule.orangeHrm.homePage.HomePage;
import com.module.orangeHrm.Browsers.ChromeBrowser;
import com.module.orangeHrm.LoginPage.LoginPage;
import com.module.orangeHrm.Utils.Constants;
import com.module.orangeHrm.candiateDetails.CanditureForm;
import com.module.orangeHrm.candiateDetails.DownloadCandidateResume;

public class TestCase1 {
	WebDriver driver;
	LoginPage loginPage;
	HomePage canditateDetails;
	CanditureForm canditureForm;
	DownloadCandidateResume downloadCandidateResume;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserStack\\chromedriver.exe");
		driver = new ChromeBrowser().getDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
	}

	@BeforeMethod
	public void navigate_to_homepage_click_on_getstarted() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserName().enterPassword().loginButton().click();
	}

	@Test(priority = 1, description = "Creating canditate details")
	public void createANewCandidateProfile() {
		canditateDetails = new HomePage(driver);
		canditateDetails.selectRecruitment().selectCandidate().clickOnAdd();

		canditureForm = new CanditureForm(driver);
		canditureForm.firstName().lastName().emailId().contactNum().roleSelection().uploadResume().clickSaveButton();
		
		canditateDetails.selectCandidate();

		enter_userDetails();
	}

	public void enter_userDetails() {
		downloadCandidateResume = new DownloadCandidateResume(driver);
		downloadCandidateResume.enterCandidateName().clickOnSearchButton().downloadResume();
	}
}