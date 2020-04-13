package sk.pulik;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InceptionTest {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/inception.php");
		driver.manage().window().maximize();
	}

	@Test

	public void testDeeper() {
		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.id("letsGoDeeper")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);

		}
		driver.findElement(By.xpath("//input[1]")).sendKeys("Sanfala");
		driver.close();

		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("letsGoDeeper")).click();

	}

	@After

	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
