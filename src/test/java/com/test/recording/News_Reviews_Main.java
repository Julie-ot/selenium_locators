package com.test.recording;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class News_Reviews_Main {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.carsguide.com.au/");
		driver.manage().window().setSize(new Dimension(1296, 696));

//		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyNewsMain() {
//		vars.put("latest_news_reviews", driver.findElement(By.cssSelector(".home-news-reviews-1 > h2")).getText());
		{
			List<WebElement> elements = driver
					.findElements(By.cssSelector(".main-row--first > .news-card:nth-child(1) .article-image"));
			assert (elements.size() > 0);
		}
		{
			List<WebElement> elements = driver
					.findElements(By.cssSelector(".main-row--first > .news-card:nth-child(1) h3"));
			assert (elements.size() > 0);
		}

		Assert.assertEquals(
				driver.findElement(By.cssSelector(".main-row--first > .news-card:nth-child(1) .news-card--teaser"))
						.getText(),
				"The new BT-50 ute might be styled much closer to its contemporary stablemates, but can a model built by another brand truly slot into Mazda's own Skyactiv philosophy?Well, Mazda's...");
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".group-main-1"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void verifyNewsLinks() {
		List<WebElement> subNews = driver.findElements(By.xpath("//*[@id='block-system-main']//div[@class='sub-row--top']/child::*"));
		Assert.assertEquals(subNews.size(),6);
	}
}
