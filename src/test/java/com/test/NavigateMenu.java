package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigateMenu {

	WebDriver driver;
	String testUrl = "https://www.carsguide.com.au/";


	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.get(testUrl);
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

	@Test
	public void navigateToBuyAndSell() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		// buy + sell
		String xpath = "/html//div[@id='u_H']//ul[@class='uhf-menu']//a[@href='/buy-a-car/all-new-and-used']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToCarReviews() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "/html//div[@id='u_H']//ul[@class='uhf-menu']/li[2]/a[@href='/car-reviews']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToCarNews() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "/html//div[@id='u_H']//ul[@class='uhf-menu']//a[@href='/car-news']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToAdvice() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "/html//div[@id='u_H']//ul[@class='uhf-menu']/li[4]/a[@href='/car-advice']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToPricingAndSpecs() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "/html//div[@id='u_H']//ul[@class='uhf-menu']//a[@href='/price']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToGuides() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "/html//div[@id='u_H']//ul[@class='uhf-menu']//a[@href='#']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToSellMyCar() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "/html//div[@id='u_H-white']//ul[@class='uhf-right-user']//a[@href='/sell-my-car']/button[@class='uhf-button-purple-border']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void navigateToShortlist() {
		//this menu is only clickable if driver.get followed by the steps immediately
	    driver.get("https://www.carsguide.com.au/"); 
	    
	  //this menu is only clickable at this specific size, not work for default nor maximize
	    driver.manage().window().setSize(new Dimension(1066, 662)); 
	    driver.findElement(By.cssSelector(".uhf-shortlist span")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void navigateToSignInSignUp() {
		//this menu is only clickable if driver.get followed by the steps immediately
	    driver.get("https://www.carsguide.com.au/"); 
	    
	  //this menu is only clickable at this specific size, not work for default nor maximize
	    driver.manage().window().setSize(new Dimension(1066, 662));

		String xpath = "/html//div[@id='u_H-white']//ul[@class='uhf-right-user']//a[@href='#']/span[@class='uhf-logged-out-show uhf-user-label']";
		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void selectAMake() {
		
		String xpathMake = "/html//input[@id='uhf-make']";
		WebElement makeDropdown = driver.findElement(By.xpath(xpathMake));
		makeDropdown.click();
		
		WebElement makeSelectedValue = driver.findElement(By.xpath("//div[@id='uhf-make-search']/ul//a[@href='/ford']"));
		makeSelectedValue.click();

		String xpathModel = "/html//input[@id='uhf-model']";
		WebElement elementModel = driver.findElement(By.xpath(xpathModel));
		elementModel.click();

		WebElement modelSelectedValue = driver.findElement(By.xpath("//div[@id='uhf-model-results']/ul//a[@href='/ford/futura']"));
		modelSelectedValue.click();

		System.out.println(driver.getTitle());
	}
	
	@Test
	public void navigateToSearch() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		String xpath = "div#u_H .uhf-input-group-addon";
		WebElement element = driver.findElement(By.cssSelector(xpath));

		element.click();
		System.out.println(driver.getTitle());
	}
}
