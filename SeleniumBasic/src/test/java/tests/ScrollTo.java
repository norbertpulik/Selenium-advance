package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.TestBase;

public class ScrollTo extends TestBase {

	private WebDriver driver;

	@Test

	public void testToScroll() {
		driver.get(BASE_URL + "tabulka.php");
		WebElement lastRow = driver.findElement(By.xpath("//table//tbody//tr[5]"));

		System.out.println(lastRow.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", lastRow);

	}
}
