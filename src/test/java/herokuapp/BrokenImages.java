package herokuapp;

import java.awt.event.WindowStateListener;
import java.net.http.HttpClient;
import java.util.List;

import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenImages {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com";
	
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
		driver.quit();
	}

	@Test
	public void dataTableTest1() {
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/broken_images']")).click();

		invalidImageCount = 0;
		List<WebElement> images = driver.findElements(By.xpath("//div[@id='content']//img"));
		for (WebElement image : images) {
			if (image != null) {
				verifyImageActive(image);
			}
		}
		System.out.println("Number of invalid images: " +invalidImageCount);
	}

	public void verifyImageActive(WebElement image) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(image.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200) {
				invalidImageCount++; 
				System.out.println(response.getStatusLine().getStatusCode());
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}