package com.jungroup;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JunGroupSiteTest {
	WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
	}

	@Before
	public void startFromScratch() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jungroup.com/");
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	// 1 Open the website
	public void testBrands() throws Exception {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		// 2 Click on "Brands'
		WebElement menuBrands = driver.findElement(By.className("brands"));
		menuBrands.click();
		// 2.1 Click on "Learn more"
		WebElement LearnMoreBrands = webDriverWait
				.until(ExpectedConditions.elementToBeClickable(By.className("brands-learn-more")));
		LearnMoreBrands.click();
		// Count blocks cs-toggle-block
		List<WebElement> megaBlock = driver.findElements(By.className("case-study-megablock"));
		assertEquals(1, megaBlock.size());
		// Click on the Case study
		WebElement lg = driver.findElement(By.className("lg"));
		lg.click();

		// 2.2 Click on "Go back"
		WebElement GoBackBrands = driver.findElement(By.className("go-back"));
		GoBackBrands.click();
	}

	@Test
	public void testContacts() throws Exception {
		WebElement menuContact = driver.findElement(By.className("contact"));
		menuContact.click();
		// Find elements Contact blocks
		List<WebElement> contacts = driver.findElements(By.className("contact-block"));
		assertEquals(3, contacts.size());
	}

	@Test
	public void testPublishers() throws Exception {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		// Click on "Publishers"
		WebElement menuPublishers = driver.findElement(By.className("publishers"));
		menuPublishers.click();
		// Click on "Learn more"
		WebElement LearnMorePublishers = webDriverWait
				.until(ExpectedConditions.elementToBeClickable(By.className("publishers-learn-more")));
		LearnMorePublishers.click();
		// Find elements Contact blocks

		WebElement block = driver.findElement(By.className("cs3"));
		block.click();

		// Click on "Go back"
		WebElement GoBackPublishers = driver.findElement(By.className("go-back"));
		GoBackPublishers.click();

	}

	@Test
	public void testTeam() throws Exception {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		// Click on "Team"
		WebElement menuTeam = driver.findElement(By.className("team"));
		menuTeam.click();
		// Click on "Meet the founders"
		WebElement MeetTheFounders = webDriverWait
				.until(ExpectedConditions.elementToBeClickable(By.className("meet-the-team")));
		MeetTheFounders.click();
		List<WebElement> founders = driver.findElements(By.className("founder-name"));
		assertEquals(2, founders.size());
		founders.get(0).click();
		founders.get(1).click();

	}

	@Test
	// // 5 Click on Careers"
	public void testCareers() throws Exception {
		WebElement menuCareers = driver.findElement(By.className("careers"));
		menuCareers.click();
		// Find all career categories
		// List<WebElement> careerCategory =
		// driver.findElements(By.className("career-category-link"));
		// assertEquals(6, careerCategory.size());
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		WebElement adOperation = webDriverWait
				.until(ExpectedConditions.elementToBeClickable(By.className("ad-operations")));
		;
		adOperation.click();
	}
	//
	// public void testMedia() throws Exception {
	// // 6 Click on "Media"
	// WebElement menuMedia = driver.findElement(By.className("media"));
	// menuMedia.click();
	// }
}
