package tests;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.TestBase;

public class JavascriotExecutor extends TestBase {

	
	@Test

	public void testHighLight() {
		getDriver().get(BASE_URL + "tabulka.php");

		List<WebElement> rows = getDriver().findElements(By.xpath("//table//tbody//tr"));

		for (WebElement row : rows) {
			if (row.getText().contains("Florian")) {
				highLight(row);
			}

		}

	}

	private void highLight(WebElement row) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", row);
	}

}
