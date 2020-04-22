package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class BlurTest extends TestBase {

	@Test

	public void testBlur() {
		getDriver().get(BASE_URL + "waitforit.php");

		getDriver().findElement(By.id("waitForBlur")).sendKeys("Brano ma nohy");
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].blur()", getDriver().findElement(By.id("waitForBlur")));

		new WebDriverWait(getDriver(), 10)
				.until(ExpectedConditions.attributeToBe(getDriver().findElement(By.id("waitForBlur")), "value", "blured"));
	}

	@Test

	public void testClick() {
		getDriver().findElement(By.id("startWaitForTesxt"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()",
				getDriver().findElement(By.id("startWaitForTesxt")));

	}

}
