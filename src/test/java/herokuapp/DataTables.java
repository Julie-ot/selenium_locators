package herokuapp;

import java.awt.event.WindowStateListener;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataTables {
	WebDriver driver;
	String testUrl = "https://the-internet.herokuapp.com/tables";

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(testUrl);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void dataTableTest1() throws InterruptedException {
		
		String customer1FirstName = getCellData(1,1).getText();
				
		System.out.println(customer1FirstName);
		
		getCellAction(2, "delete").click();

		System.out.println(driver.getCurrentUrl());
		
		System.out.printf("Table2, column 2 firstname is %s\n",getCellDataByClassName(2, "first-name").getText());
	}
	
	private WebElement getCellData(int rowNo, int colNo) {
		String table1Locator = "table#table1 > tbody > tr:nth-of-type("
							+Integer.toString(rowNo)
							+ ") > td:nth-of-type("
							+Integer.toString(colNo)
							+")";
		System.out.println(table1Locator);
		WebElement cell = driver.findElement(By.cssSelector(table1Locator));
		return cell;
	}
	
	private WebElement getCellDataByClassName(int rowNo, String className) {
		String table1Locator = "table#table2 > tbody > tr:nth-of-type("
							+Integer.toString(rowNo)
							+ ") > ."
							+ className;
							
		System.out.println(table1Locator);
		WebElement cell = driver.findElement(By.cssSelector(table1Locator));
		return cell;
	}

	private WebElement getCellAction(int rowNo, String action) {
		String actionNo = Integer.toString((action == "edit") ? 1:2);
		String table1Locator = "table#table1 > tbody > tr:nth-of-type("
							+Integer.toString(rowNo)
							+ ") > td:nth-of-type(6) >a:nth-of-type("
							+ actionNo
							+")";
		WebElement cell = driver.findElement(By.cssSelector(table1Locator));
		return cell;
	}

}