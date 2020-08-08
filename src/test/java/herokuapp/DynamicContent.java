package herokuapp;

import java.awt.event.WindowStateListener;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicContent {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/dynamic_content";

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
	public void dataTableTest1() throws InterruptedException {
//		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/dynamic_content']")).click();

		for (int i = 0; i < 3; i++) {
			getContent();
			driver.navigate().refresh();
		}
	}

	private void getContent() {
		List<WebElement> images = driver
				.findElements(By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']//img"));
		for (WebElement e : images) {
			System.out.println(e.getAttribute("src"));
		}

		List<WebElement> paragraphs = driver
				.findElements(By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']//div[2]"));
		for (WebElement par : paragraphs) {
			System.out.println(par.getText());
		}
	}
}