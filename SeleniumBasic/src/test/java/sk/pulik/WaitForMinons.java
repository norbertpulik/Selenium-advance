package sk.pulik;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WaitForMinons {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/minions.php");
	}

	@Test

	public void waitForMinions() {

		int numberOfMinions = 8;

		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(numberOfMinions));
		driver.findElement(By.xpath("//button[contains(@class,'btn-warning')]")).click();

		new WebDriverWait(driver, 5).withMessage("Timeout waiting for number of minons" + numberOfMinions).until(
				ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"), numberOfMinions));

		Assert.assertEquals(numberOfMinions, driver.findElements(By.xpath("//div[@class='minions']//img")).size());

	}
	
	

	@After

	public void tearDown() {
		driver.quit();

	}
}