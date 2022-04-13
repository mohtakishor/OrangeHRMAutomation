package com.module.orangeHrm.LoginPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.module.orangeHrm.Utils.RandomData;
import org.openqa.selenium.support.ui.*;

public class main {

	WebDriver driver;
	final static String URL = "https://opensource-demo.orangehrmlive.com/";

	public WebDriver openBrowser(String browserName, String Url) {
		switch (browserName) {
		case "chrome":
			driver = new ChromeBrowser().getDriver();
			break;
		default:
			throw new IllegalStateException("Unexpected value: " + browserName);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // for page load
		driver.get("https://opensource-demo.orangehrmlive.com/"); // Testing webpage
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // for Implicit wait

		WebElement uname = driver.findElement(By.id("txtUsername")); // Username.........ID
		uname.sendKeys("Admin");

		WebElement pwd = driver.findElement(By.name("txtPassword")); // Password.........NAME
		pwd.sendKeys("admin123");

		WebElement loginb = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginb.click(); // Loginbutton......XPATH

		WebElement pim = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
		pim.click(); // Admin tab-PIM

		WebElement config = driver.findElement(By.id("menu_recruitment_viewCandidates"));
		config.click(); // Configuration tab

		WebElement data_imp = driver.findElement(By.cssSelector("input#btnAdd"));
		data_imp.click(); // Data Import tab.....PARTIALLINKT

		WebElement clickfirstName = driver.findElement(By.cssSelector("input#addCandidate_firstName"));
		clickfirstName.click();
		String firstName = RandomData.getRandomName();
		clickfirstName.sendKeys(firstName);
		WebElement lastName = driver.findElement(By.cssSelector("input#addCandidate_lastName"));
		lastName.click();
		String last = RandomData.getRandomName();
		lastName.sendKeys(last);
		WebElement email = driver.findElement(By.xpath("//input[@id='addCandidate_email']"));
		email.click();
		email.sendKeys(RandomData.getRandomName() + "@gmail.com");
		WebElement contactNumber = driver.findElement(By.xpath("//input[@id='addCandidate_contactNo']"));
		contactNumber.click();
		contactNumber.sendKeys(RandomData.getRandomNumber());
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='addCandidate[vacancy]']"));
		Select sl = new Select(dropDown);
		// select option with text visible
		sl.selectByVisibleText("Senior QA Lead");

		WebElement upload = driver.findElement(By.xpath("//input[@id='addCandidate_resume']")); // Upload button
		upload.sendKeys(System.getProperty("user.dir") + "/Driver/[Turn] Test Automation Exercise (1).pdf");
		System.out.println("3");

		WebElement saveButton = driver.findElement(By.id("btnSave")); // Upload button
		saveButton.click();
		System.out.println("3");

		System.out.println("File Uploaded Successfully"); // Confirmation message

		WebElement config2 = driver.findElement(By.id("menu_recruitment_viewCandidates"));
		config2.click();

		WebElement searchCanditate = driver.findElement(By.xpath("//input[@name='candidateSearch[candidateName]']"));
		searchCanditate.click();
		searchCanditate.sendKeys(firstName + " " + last);

		WebElement searchButton = driver.findElement(By.xpath("//input[@name='btnSrch']"));
		searchButton.click();

		WebElement clickOnDownload = driver.findElement(By.xpath("//a[text()='Download']"));
		clickOnDownload.click();
		
		System.out.println(System.getProperty("user.dir"));

		File file = new File(System.getProperty("user.dir") + "/downloaded/");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofMillis(100));
		wait.until(x -> file.exists());
		driver.manage().timeouts().getPageLoadTimeout();

		return driver;
	}

	public static void main(String args[]) {
		main main = new main();
		main.openBrowser("chrome", URL);
	}
}