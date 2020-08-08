package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopularReviews {
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
	public void popularReviews() {
		List<WebElement> reviewsLink = driver.findElements(By.xpath("/html//div[@id='block-system-main']/div[@class='content']//ul[@class='links']//a"));
		Assert.assertEquals(reviewsLink.size(), 10);
		
		for (WebElement e: reviewsLink) {
			System.out.printf("Popular reviews: %s\n", e.getText());
		}
	}
}
