package sk.pulik;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThereAndBackTest {

	WebDriver driver;
	JavascriptExecutor js;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/tabulka.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	}

	@Test

	public void testScroll() {

		for (int i = 0; i < 4; i++) {
			js.executeScript("window.scrollBy(0,200)");

		}

	}

	@Test

	public void testSrollToEnd() {

		long bodyHight = (long) js.executeScript("return document.body.scrollHeight");
		js.executeScript("window.scrollBy(0," + bodyHight + ")");
	}

}
