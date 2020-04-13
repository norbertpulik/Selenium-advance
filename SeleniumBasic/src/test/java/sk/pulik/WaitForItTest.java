package sk.pulik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForItTest {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/waitforit.php");
	}

	@Test

	public void waitForInputText() {

		driver.findElement(By.id("startWaitForText")).click();

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"), "value", "dary !!!"));

		System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));

	}

	@Test

	public void waitForClass() {

		driver.findElement(By.id("startWaitForProperty")).click();

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.attributeContains(By.id("waitForProperty"), "class", "error"));

		Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());

	}

}
