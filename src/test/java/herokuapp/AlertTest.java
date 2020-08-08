package herokuapp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/javascript_alerts";

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

		WebElement element1 = driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']"));
		WebElement element2 = driver
				.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']"));
		WebElement element3 = driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']"));

		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

		List<WebElement> list = new ArrayList();
		list.add(element1);
		list.add(element2);
		list.add(element3);

		for (WebElement element : list) {
			element.click();

			driver.switchTo().alert().accept();

			System.out.println(result.getText());
			Thread.sleep(5000);
		}

		for (WebElement element : list) {
			element.click();

			driver.switchTo().alert().dismiss();

			System.out.println(result.getText());
			Thread.sleep(5000);
		}
		{
			element3.click();

			driver.switchTo().alert().sendKeys("Hello World!");
			driver.switchTo().alert().accept();
			System.out.println(result.getText());
			Thread.sleep(5000);
		}

	}

}
