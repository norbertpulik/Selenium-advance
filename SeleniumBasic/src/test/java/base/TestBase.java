package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static final String BASE_URL = "http://localhost:8888/";
	
	
	@Before
	
	public void setUp () {
		
	}

	@After

	public void tearDown() {
		WebDriverSingelton.getWebDriverInstance().close();
		//WebDriverSingelton.getWebDriverInstance().quit();

	}

	protected WebDriver getDriver() {
		return WebDriverSingelton.getWebDriverInstance();

	}

}
