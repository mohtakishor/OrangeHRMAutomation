package com.module.orangeHrm.candiateDetails;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.module.orangeHrm.utils.Constants;
import com.module.orangeHrm.utils.PageHandle;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import java.nio.file.Files;

public class DownloadCandidateResume {
	private static final Logger logger = LoggerFactory.getLogger(DownloadCandidateResume.class);

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
		logger.info(
				"Search the candidate as " + CanditureForm.candidateFirstName + " " + CanditureForm.candidateLastName);
		return new DownloadCandidateResume(driver);
	}

	@Step("Click on the search button to execute the search list")
	public DownloadCandidateResume clickOnSearchButton() {
		WebElement clickSearchButton = driver.findElement(searchButton);
		clickSearchButton.click();
		logger.info("Click on search button to fetch the list");
		return new DownloadCandidateResume(driver);
	}

	@Step("Click on the download tab to download the resume and the candidate profile")
	public DownloadCandidateResume downloadResume() {
		deleteDownloadedResume();
		WebElement clickOnDownload = driver.findElement(downloadResume);
		clickOnDownload.click();
		PageHandle.waitUntilDownloadsComplete(driver, file);
		logger.info("Download the PDF and attach the PDF with report");
		attachPdf();
		return new DownloadCandidateResume(driver);
	}

	@Attachment(value = "Attaching the downladed resume", type = "application/pdf")
	public static byte[] attachPdf() {
		try {
			return Files.readAllBytes(Paths.get(Constants.DOWNLADEDRESUMEPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Step("Check whether the file already exist if yes then delete the previous downloaded resume")
	public void deleteDownloadedResume() {
		file = new File(Constants.DOWNLADEDRESUMEPATH);
		if (file.exists()) {
			file.delete();
		}
	}
}
