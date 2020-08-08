package herokuapp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotificationMessage {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/notification_message_rendered";

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(testUrl);
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

	@Test
	public void hoverTest() throws InterruptedException {

		WebElement element1 = driver.findElement(By.xpath("//div[@id='flash']"));
		WebElement element2 = driver.findElement(By.xpath("//div[@id='content']//a[@href='/notification_message']"));

		System.out.println(element1.getText());
		element2.click();
		
		System.out.println(element2.getText());

	}

}
