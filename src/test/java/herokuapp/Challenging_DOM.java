package herokuapp;

import java.awt.event.WindowStateListener;
import java.net.http.HttpClient;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Challenging_DOM {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/challenging_dom";

	private int invalidImageCount;

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

	@Test(enabled=false)
	public void staleElement1() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/challenging_dom']")).click();

		for (int i = 0; i < 3; i++) {
			getStaleElem(By.xpath("//div[@id='content']/div[@class='example']/div/div/div[1]/a[1]"), driver).click();
		
		}
	}


	@Test
	public void shadowJavaScriptExecutor() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String btnCSS = ".button:nth-of-type(1)";
		for (int i = 0; i < 3; i++) {
			js.executeScript("document.querySelector('.button:nth-of-type(1)').click();");
			System.out.println(driver.findElement(By.cssSelector(btnCSS)).getText());
		}
		
	}

	
	WebElement getStaleElem(By by, WebDriver driver) {
		try {
			return driver.findElement(by);
		} catch (StaleElementReferenceException e) {
			System.out.println("Attempting to recover from StaleElementReferenceException ...");
			return getStaleElem(by, driver);
		} catch (NoSuchElementException ele) {
			System.out.println("Attempting to recover from NoSuchElementException ...");
			return getStaleElem(by, driver);
		}
	}
}