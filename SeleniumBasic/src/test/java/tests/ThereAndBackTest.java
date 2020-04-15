package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.TestBase;

public class ThereAndBackTest extends TestBase {

	JavascriptExecutor js;

	@Before

	public void setUp() {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	}

	@Test

	public void testScroll() {
		getDriver().get(BASE_URL + "tabulka.php");

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
