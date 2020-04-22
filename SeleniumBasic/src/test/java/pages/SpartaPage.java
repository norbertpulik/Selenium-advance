package pages;

import static base.TestBase.BASE_URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.WebDriverSingelton;
import models.Sin;

public class SpartaPage {

	private WebDriver driver;

	private static final String PAGE_URL = "sparta.php";

	public SpartaPage() {

		driver = WebDriverSingelton.getWebDriverInstance();
		PageFactory.initElements(driver, this);

	}

	public void openPage() {
		driver.get(BASE_URL + PAGE_URL);
	}

	public WebElement getMainSinElement(Sin sin) {
		return driver.findElement(By.xpath("//article[p[text()='" + sin.getMessage() + "']]"));

	}

	public void forgiveSin(Sin evaSpieva) {
        //1.najst article a button
        WebElement article = getMainSinElement(evaSpieva);
        //2.chcem kliknut na button
        article.findElement(By.cssSelector("button")).click();
        //3.potvrdit modal
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("confirm")));
        driver.findElement(By.id("confirm")).click();
        //nastavit hriechu forgiven -> true
        evaSpieva.setForgiven(true);
    }

}
