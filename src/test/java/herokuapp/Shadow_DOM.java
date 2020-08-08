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

public class Shadow_DOM {
	WebDriver driver;
	String testUrl = "chrome://downloads/";

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

	@Test
	public void getTextFromShadowDOM() {
		WebElement root1 = driver.findElement(By.cssSelector("downloads-manager"));
		
		//Get shadowRoot elements
		WebElement shadowRoot1 = expandRootElement(root1);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
		WebElement shadowRoot2 = expandRootElement(root2);

		WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
		WebElement shadowRoot3 = expandRootElement(root3);

		//Verify
		String h1Text = shadowRoot3.findElement(By.id("leftSpacer")).getText();
		System.out.println(h1Text);
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot;",
				element);
		return ele;
	}

}