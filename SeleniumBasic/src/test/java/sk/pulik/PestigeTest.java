package sk.pulik;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PestigeTest {
	
	WebDriver driver = new FirefoxDriver();
	

	public void prestige() {
		driver.findElement(By.cssSelector("div.hat img")).click();

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.hat img")));

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.hat img")));

	}
	
	@After
	
	public void tearDown() {
		driver.quit();
	}

}
