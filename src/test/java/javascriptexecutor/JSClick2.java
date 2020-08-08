package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JSClick2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");

		WebElement element = driver
				.findElement(By.xpath("//div[@id='content']/div[@class='example']/div/div/div[1]/a[1]"));
		WebElement element2 = driver
				.findElement(By.xpath("//div[@id='content']/div[@class='example']/div/div/div[1]/a[3]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(2000);
		js.executeScript("arguments[1].click()", element, element2);
	}
}
