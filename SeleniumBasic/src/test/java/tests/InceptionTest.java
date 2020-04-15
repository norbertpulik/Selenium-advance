package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class InceptionTest extends TestBase {

	@Test

	public void testDeeper() {
		getDriver().get(BASE_URL + "inception.php");
		getDriver().manage().window().maximize();

		String parentWindow = getDriver().getWindowHandle();

		getDriver().findElement(By.id("letsGoDeeper")).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String handle : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(handle);

		}
		getDriver().findElement(By.xpath("//input[1]")).sendKeys("Sanfala");
		getDriver().close();

		getDriver().switchTo().window(parentWindow);
		getDriver().findElement(By.id("letsGoDeeper")).click();

	}

}
