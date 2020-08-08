package herokuapp;

import java.awt.event.WindowStateListener;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class FloatingMenu {
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
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/floating_menu']")).click();

		WebElement homeMenu = driver.findElement(By.xpath("//div[@id='menu']/ul//a[@href='#home']"));
		WebElement newsMenu = driver.findElement(By.xpath("//div[@id='menu']/ul//a[@href='#news']"));
		System.out.println("Before" + newsMenu.getLocation());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		homeMenu.click();
		System.out.println(driver.getTitle());

		// div[@id='menu']/ul//a[@href='#contact']
		// div[@id='menu']/ul//a[@href='#about']

		System.out.println("After " + newsMenu.getLocation());

		// scroll to end of the page
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		System.out.println("At the bottom " + newsMenu.getLocation());

	}

}