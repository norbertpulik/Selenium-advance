package tests;

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

import base.TestBase;
import junit.framework.Assert;

public class WaitForMinons extends TestBase {

	@Test

	public void waitForMinions() {

		getDriver().get(BASE_URL + "minions.php");

		int numberOfMinions = 8;

		getDriver().findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(numberOfMinions));
		getDriver().findElement(By.xpath("//button[contains(@class,'btn-warning')]")).click();

		new WebDriverWait(getDriver(), 5).withMessage("Timeout waiting for number of minons" + numberOfMinions).until(
				ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"), numberOfMinions));

		Assert.assertEquals(numberOfMinions, getDriver().findElements(By.xpath("//div[@class='minions']//img")).size());

	}

	@After

	public void tearDown() {
		getDriver().quit();

	}
}