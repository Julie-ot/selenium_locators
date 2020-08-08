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

public class KeyPress {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/key_presses";

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

		WebElement textbox = driver.findElement(By.xpath("//input[@id='target']"));
		WebElement element1 = driver.findElement(By.xpath("//p[@id='result']"));

		textbox.sendKeys(Keys.ALT);

		System.out.println(element1.getText());

	}

}
