package herokuapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

public class MultipleWindow {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/windows";

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

		WebElement element1 = driver.findElement(By.xpath("//div[@id='content']//a[@href='/windows/new']"));
		element1.click();
		Thread.sleep(5000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle: windowHandles) {
			System.out.println(windowHandle);
		}
		driver.switchTo().window("18");
		element1.click();
		Thread.sleep(5000);
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		for (String windowHandle: windowHandles2) {
			System.out.println(windowHandle);
		}
		
	}

}
