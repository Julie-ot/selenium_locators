package herokuapp;

import java.awt.event.WindowStateListener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu  {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com";

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
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/context_menu']")).click();

		WebElement element = driver.findElement(By.xpath("/html//div[@id='hot-spot']"));
		
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		
	}
}