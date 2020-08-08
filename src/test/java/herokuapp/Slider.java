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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Slider {
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
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/horizontal_slider']")).click();

		WebElement slider = driver
				.findElement(By.xpath("/html//div[@id='content']//div[@class='sliderContainer']/input"));

		double min = getMin(slider);
		double max = getMax(slider);
		double step = getStep(slider);

		double count = (max - min / step);
		// By using Actions
//		Actions move = new Actions(driver);
//		move.dragAndDropBy(slider, slider.getLocation().x + 5, slider.getLocation().y).build().perform();
		
//		System.out.println(slider.getLocation());

		// By sendKeys
		for (int i = 0; i < 1; i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
			Thread.sleep(5000);
			System.out.printf("Value at %d move is %f\n", i+1, getValue());
		}
	}

	private double getStep(WebElement slider) {
		return Double.parseDouble(slider.getAttribute("step"));
	}

	private double getMax(WebElement slider) {
		return Double.parseDouble(slider.getAttribute("max"));
	}

	private double getMin(WebElement slider) {
		return Double.parseDouble(slider.getAttribute("min"));
	}
	private double getValue() {
		WebElement range = driver
				.findElement(By.xpath("/html//div[@id='content']//div[@class='sliderContainer']/span"));
		
		double currentRange = Double.parseDouble(range.getText());
		return currentRange;
	}

}