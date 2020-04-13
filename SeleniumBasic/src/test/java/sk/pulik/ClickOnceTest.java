package sk.pulik;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnceTest {
	private WebDriver driver;
	private Map<String, Object> vars;

	JavascriptExecutor js;

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver" );
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void clickOne() {
		driver.get("http://localhost:8888/");
		driver.findElement(By.linkText("Click me baby")).click();
		driver.findElement(By.id("clickMe")).click();
		driver.findElement(By.id("clicks")).getText().equals("click");
		driver.findElement(By.cssSelector(".description")).getText().equals("klik");
		
	}

}
