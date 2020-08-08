package herokuapp;

import java.awt.event.WindowStateListener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
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
//		driver.quit();
	}

	@Test
	public void dataTableTest1() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/drag_and_drop']")).click();

		WebElement source = driver.findElement(By.xpath("/html//div[@id='column-a']"));
		WebElement target = driver.findElement(By.xpath("/html//div[@id='column-b']"));

		Point bLocation = target.getLocation();
		System.out.println(bLocation);

		Actions act = new Actions(driver);


		act.dragAndDropBy(source, bLocation.x, bLocation.x).build().perform();

	}
}