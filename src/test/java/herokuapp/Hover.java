package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hover {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/hovers";

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
	public void hoverTest() {
		WebElement avatar1 = driver.findElement(By.xpath("//div[@id='content']/div/div[1]/img[@alt='User Avatar']"));
		WebElement avatar2 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/img[@alt='User Avatar']"));
		WebElement avatar3 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[3]/img[@alt='User Avatar']"));
	
		Actions action = new Actions(driver);
		action.moveToElement(avatar1).perform();
	}
}
