package herokuapp;

import java.awt.event.WindowStateListener;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Modal {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com";

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(testUrl);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void dataTableTest1() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/dynamic_controls']")).click();

		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println(checkbox.getLocation());

		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']")).click();
		System.out.println(checkbox.getLocation());

		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']")).click();

		System.out.println(driver.findElement(By.cssSelector("form#checkbox-example > div:nth-of-type(1)")).getText());

	}


}