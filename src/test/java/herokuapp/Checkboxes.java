package herokuapp;

import java.awt.event.WindowStateListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkboxes  {
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
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/checkboxes']")).click();

		WebElement checkBox1 = driver.findElement(By.xpath("/html//form[@id='checkboxes']/input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("/html//form[@id='checkboxes']/input[2]"));
		
		if (checkBox1.getAttribute("checked") == null) {
			checkBox1.click();
		}
		if (checkBox2.getAttribute("checked") != null) {
			checkBox2.click();
		}
		System.out.println(checkBox1.getAttribute("checked"));
		System.out.println(checkBox2.getAttribute("checked"));

	}
}