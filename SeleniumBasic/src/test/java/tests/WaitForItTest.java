package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class WaitForItTest extends TestBase {

	@Test

	public void waitForInputText() {
		getDriver().get(BASE_URL + "waitforit.php");

		getDriver().findElement(By.id("startWaitForText")).click();

		new WebDriverWait(getDriver(), 10)
				.until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"), "value", "dary !!!"));

		System.out.println(getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));

	}

	@Test

	public void waitForClass() {

		getDriver().findElement(By.id("startWaitForProperty")).click();

		new WebDriverWait(getDriver(), 10)
				.until(ExpectedConditions.attributeContains(By.id("waitForProperty"), "class", "error"));

		Assert.assertFalse(getDriver().findElement(By.id("startWaitForProperty")).isEnabled());

	}

	@Test
	@Ignore

	public void checkLegendary() {
		getDriver().findElement(By.id("startWaitForText")).click();
		Assert.assertEquals("dary !!!", getDriver().findElement(By.id("waitFoTextInput")).getAttribute("value"));

	}
}
