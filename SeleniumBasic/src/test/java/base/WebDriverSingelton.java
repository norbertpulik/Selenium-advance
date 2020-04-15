package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingelton {

	private static WebDriver driver;

	private static void initialize() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();

	}

	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			initialize();
		}

		return driver;

	}

}
