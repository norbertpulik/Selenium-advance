package sk.pulik;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PestigeTest {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/prestige.php");
	}

	@Test

	public void prestige() {
		driver.findElement(By.cssSelector("div.hat img")).click();

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.hat img")));

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.hat img")));

	}
	
	@After
	
	public void tearDown() {
		driver.quit();
	}

}
