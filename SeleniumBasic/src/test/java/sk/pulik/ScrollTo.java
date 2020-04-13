package sk.pulik;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollTo {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/tabulka.php");
	}

	@Test

	public void testToScroll() {
		WebElement lastRow = driver.findElement(By.xpath("//table//tbody//tr[5]"));

		System.out.println(lastRow.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", lastRow);

	}
}
