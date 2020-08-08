package herokuapp;

import java.awt.event.WindowStateListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DigestAuth  {
	WebDriver driver;
	String username = "admin";
	String password = "admin";
	
	String testUrl = "https://" +username+ ":" +password+ "@the-internet.herokuapp.com";

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
	public void dataTableTest1() {
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/digest_auth']")).click();
		
		String headText = driver.findElement(By.xpath("//div[@id='content']//h3[.='Digest Auth']")).getText();
		System.out.println(headText);		
	}
}