package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PanelCarSearch {
	WebDriver driver;
	String testUrl = "https://www.carsguide.com.au/";

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(testUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

	@Test
	public void findYourNextCar() {
		WebElement makeSelect = driver.findElement(By.xpath("/html//select[@id='makes']"));
		Select make = new Select(makeSelect);
		make.selectByValue("Ford");

		WebElement modelSelect = driver.findElement(By.xpath("/html//select[@id='models']"));
		Select model = new Select(modelSelect);
		model.selectByValue("Thunderbird");

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement showResultsButton = driver.findElement(By.xpath("/html//button[@id='search-submit']"));

		wait.until(ExpectedConditions.elementToBeClickable(showResultsButton));
		showResultsButton.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void findYourNextCarMore() {
		WebElement makeSelect = driver.findElement(By.xpath("/html//select[@id='makes']"));
		Select make = new Select(makeSelect);
		make.selectByValue("Ford");

		WebElement modelSelect = driver.findElement(By.xpath("/html//select[@id='models']"));
		Select model = new Select(modelSelect);
		model.selectByValue("Thunderbird");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement showResultsButton = driver.findElement(By.xpath("/html//button[@id='search-submit']"));

		WebElement moreFilter = driver
				.findElement(By.xpath("//form[@id='cgAppCarsForSaleForm']//a[@class='more-filters-link']"));
		wait.until(ExpectedConditions.elementToBeClickable(moreFilter));
		moreFilter.click();

		WebElement kmsSelect = driver.findElement(By.xpath("/html//select[@id='kms']"));
//		kmsSelect.click();
		Select kms = new Select(kmsSelect);
		kms.selectByIndex(2);

		WebElement priceSelect = driver.findElement(By.xpath("/html//select[@id='price-max']"));
		Select price = new Select(priceSelect);
		price.selectByIndex(2);

		wait.until(ExpectedConditions.elementToBeClickable(showResultsButton));
		showResultsButton.click();
		System.out.println(driver.getTitle());
	}

	@Test(dependsOnMethods = { "findYourNextCar" })
	public void recentSearch() throws InterruptedException {
		driver.navigate().back();
		String recentSearchXpath = "//form[@id='cgAppCarsForSaleForm']//a[@href='/buy-a-car/all-new-and-used/all-states/all-locations/all-bodytypes/ford_thunderbird']";

		Thread.sleep(5000);
		{
			List<WebElement> elements = driver.findElements(By.linkText("Ford Thunderbird"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void advanceSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement moreFilter = driver
				.findElement(By.xpath("//form[@id='cgAppCarsForSaleForm']//a[@class='more-filters-link']"));
		wait.until(ExpectedConditions.elementToBeClickable(moreFilter));
		moreFilter.click();

		driver.findElement(By.xpath("/html//a[@id='advanced-search-submit']")).click();
		
		WebElement sellerTypes 		= driver.findElement(By.xpath("/html//select[@id='sellerTypes']"));
		WebElement makes 			= driver.findElement(By.xpath("/html//select[@id='makes']"));
		WebElement models 			= driver.findElement(By.xpath("/html//select[@id='models']"));
		WebElement badges 			= driver.findElement(By.xpath("/html//select[@id='badges']"));
		WebElement series 			= driver.findElement(By.xpath("/html//select[@id='series']"));
		WebElement priceFrom 		= driver.findElement(By.xpath("/html//select[@id='priceFrom']"));
		WebElement priceTo 			= driver.findElement(By.xpath("/html//select[@id='priceTo']"));
		WebElement yearFrom 		= driver.findElement(By.xpath("/html//select[@id='yearFrom']"));
		WebElement yearTo 			= driver.findElement(By.xpath("/html//select[@id='yearTo']"));
		WebElement locations 		= driver.findElement(By.xpath("/html//select[@id='locations']"));
		WebElement postCode 		= driver.findElement(By.xpath("/html//input[@id='postCode']"));
		WebElement bodyTypes 		= driver.findElement(By.xpath("/html//select[@id='bodyTypes']"));
		WebElement kilometres 		= driver.findElement(By.xpath("/html//select[@id='kilometres']"));
		WebElement fuels 			= driver.findElement(By.xpath("/html//select[@id='fuels']"));
		WebElement transmissions 	= driver.findElement(By.xpath("/html//select[@id='transmissions']"));
		WebElement cylinders 		= driver.findElement(By.xpath("/html//select[@id='cylinders']"));
		WebElement engineSize 		= driver.findElement(By.xpath("/html//select[@id='engineSize']"));
		WebElement power 			= driver.findElement(By.xpath("/html//select[@id='power']"));
		WebElement wheelDrive 		= driver.findElement(By.xpath("/html//select[@id='wheelDrive']"));
		WebElement doors 			= driver.findElement(By.xpath("/html//select[@id='doors']"));
		WebElement seats 			= driver.findElement(By.xpath("/html//select[@id='seats']"));
		WebElement whenAdvertised 	= driver.findElement(By.xpath("/html//select[@id='whenAdvertised']"));
		WebElement baseColour 		= driver.findElement(By.xpath("/html//select[@id='baseColour']"));

		WebElement submitbtn = driver.findElement(By.xpath("/html//input[@id='submit-btn']"));
		
		sellerTypes.sendKeys("New In Stock");
		makes.sendKeys("Alfa Romeo");
		
		models.sendKeys("GT");
		badges.sendKeys("JTS");
		series.sendKeys("Any series");
		priceFrom.sendKeys("$20,000");
		priceTo.sendKeys("$150,000");
		yearFrom.sendKeys("2009");
		yearTo.sendKeys("2020");
		locations.sendKeys("NSW - Central Coast");
//		postCode.selectByValue(value);
//		bodyTypes.selectByValue(value);
//		kilometres.selectByValue(value);
//		fuels.selectByValue(value);
//		transmissions.selectByValue(value);
//		cylinders.selectByValue(value);
//		engineSize.selectByValue(value);
//		power.selectByValue(value);
//		wheelDrive.selectByValue(value);
//		doors.selectByValue(value);
//		seats.selectByValue(value);
//		whenAdvertised.selectByValue(value);
//		baseColour.selectByValue(value);

		submitbtn.submit();
		
	}

}
