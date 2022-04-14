package com.module.orangeHrm.candiateDetails;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.module.orangeHrm.Utils.Constants;
import com.module.orangeHrm.Utils.PageHandle;

public class DownloadCandidateResume {

	By enterCandidateName = By.xpath("//input[@name='candidateSearch[candidateName]']");
	By searchButton = By.xpath("//input[@name='btnSrch']");
	By downloadResume = By.xpath("//a[text()='Download']");

	WebDriver driver;
	File file;

	public DownloadCandidateResume(WebDriver driver) {
		this.driver = driver;
	}

	public DownloadCandidateResume enterCandidateName() {
		WebElement candidateName = driver.findElement(enterCandidateName);
		PageHandle.clickAndSend(candidateName,
				CanditureForm.candidateFirstName + " " + CanditureForm.candidateLastName);
		return new DownloadCandidateResume(driver);
	}

	public DownloadCandidateResume clickOnSearchButton() {
		WebElement clickSearchButton = driver.findElement(searchButton);
		clickSearchButton.click();
		return new DownloadCandidateResume(driver);
	}

	public DownloadCandidateResume downloadResume() {
		deleteDownloadedResume();
		WebElement clickOnDownload = driver.findElement(downloadResume);
		clickOnDownload.click();
		PageHandle.waitUntilDownloadsComplete(driver, file);
		return new DownloadCandidateResume(driver);
	}

	public void deleteDownloadedResume() {
		file = new File(System.getProperty("user.dir") + "/" + Constants.RESUME);
		if (file.exists()) {
			file.delete();
		}
	}
}
