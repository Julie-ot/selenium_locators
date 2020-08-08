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

public class JQueryUIMenu {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/jqueryui/menu";

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

		WebElement menu = driver.findElement(By.xpath("//ul[@id='menu']"));
		WebElement element1 = menu.findElement(By.xpath("//li[2]/a[@href='#']"));
		WebElement element2 = menu.findElement(By.xpath("//li[2]/ul/li[1]/a[@href='#']"));
		WebElement element3 = menu.findElement(By.xpath("//li[2]//a[@href='/jqueryui']"));

		WebElement element4 = menu
				.findElement(By.xpath("//li[2]/ul/li[1]//a[@href='/download/jqueryui/menu/menu.pdf']"));
		WebElement element5 = menu
				.findElement(By.xpath("//li[2]/ul/li[1]//a[@href='/download/jqueryui/menu/menu.csv']"));
		WebElement element6 = menu
				.findElement(By.xpath("//ul[@id='menu']/li[2]/ul/li[1]//a[@href='/download/jqueryui/menu/menu.xls']"));
		
		List<WebElement> list = new ArrayList();
		list.add(element1);
		list.add(element2);
		list.add(element3);
		list.add(element4);
		list.add(element5);
		list.add(element6);

		for (WebElement element : list) {
			Actions action = new Actions(driver);
			
			action.moveToElement(element).click().perform();
			System.out.println(element.getText());
			Thread.sleep(5000);
		}

	}

}
