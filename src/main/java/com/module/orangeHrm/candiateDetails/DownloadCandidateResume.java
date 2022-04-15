package com.module.orangeHrm.candiateDetails;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.module.orangeHrm.utils.Constants;
import com.module.orangeHrm.utils.PageHandle;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class DownloadCandidateResume {

	By enterCandidateName = By.xpath("//input[@name='candidateSearch[candidateName]']");
	By searchButton = By.xpath("//input[@name='btnSrch']");
	By downloadResume = By.xpath("//a[text()='Download']");

	WebDriver driver;
	File file;

	public DownloadCandidateResume(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Enter the candidate name to search the candidate profile")
	public DownloadCandidateResume enterCandidateName() {
		WebElement candidateName = driver.findElement(enterCandidateName);
		PageHandle.clickAndSend(candidateName,
				CanditureForm.candidateFirstName + " " + CanditureForm.candidateLastName);
		return new DownloadCandidateResume(driver);
	}

	@Step("Click on the search button to execute the search list")
	public DownloadCandidateResume clickOnSearchButton() {
		WebElement clickSearchButton = driver.findElement(searchButton);
		clickSearchButton.click();
		return new DownloadCandidateResume(driver);
	}

	@Attachment(value = "", type = ".pdf")
	@Step("Click on the download tab to download the resume and the candidate profile")
	public DownloadCandidateResume downloadResume() {
		deleteDownloadedResume();
		WebElement clickOnDownload = driver.findElement(downloadResume);
		clickOnDownload.click();
		PageHandle.waitUntilDownloadsComplete(driver, file);
		return new DownloadCandidateResume(driver);
	}

	@Step("Check whether the file already exist if yes then delete the previous downloaded resume")
	public void deleteDownloadedResume() {
		file = new File(System.getProperty("user.dir") + "/" + Constants.RESUME);
		if (file.exists()) {
			file.delete();
		}
	}
}
