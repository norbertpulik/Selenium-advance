package sk.pulik;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlurTest {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/waitforit.php");
	}

	@Test

	public void testBlur() {

		driver.findElement(By.id("waitForBlur")).sendKeys("Brano ma nohy");
		((JavascriptExecutor) driver).executeScript("arguments[0].blur()", driver.findElement(By.id("waitForBlur")));

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForBluer")), "value", "blured"));
	}

	@Test

	public void testClick() {
		driver.findElement(By.id("startWaitForTesxt"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.id("startWaitForTesxt")));

	}

}





