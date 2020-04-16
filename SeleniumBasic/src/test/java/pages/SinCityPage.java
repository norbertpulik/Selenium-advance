package pages;

import static base.TestBase.BASE_URL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.WebDriverSingelton;
import enumeratios.SinType;
import junit.framework.Assert;
import models.Sin;

public class SinCityPage {

	private WebDriver driver;
	private static final String PAGE_URL = "sincity.php";

	@FindBy(name = "title")

	private WebElement titleInput;

	@FindBy(name = "author")
	private WebElement authorInput;

	@FindBy(name = "message")
	private WebElement messageInput;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement confessButton;

	@FindBy(css = "div.sinsListArea")
	private WebElement sinListSection;

	public SinCityPage() {

		driver = WebDriverSingelton.getWebDriverInstance();
		PageFactory.initElements(driver, this);

	}

	public void openPage() {
		driver.get(BASE_URL + PAGE_URL);
	}

	public void fillSinnInformation(Sin sin) {
		titleInput.sendKeys(sin.getTitle());
		authorInput.sendKeys(sin.getTitle());
		messageInput.sendKeys(sin.getMessage());
	}

	public void markTag(List<SinType> tags) {
		for (SinType tag : tags) {
			driver.findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();
		}

	}

	public void confessSinn() {
		confessButton.click();
	}

	public void openSinDetail(Sin spiderSin) {
		WebElement listOfSins = sinListSection.findElement(By.cssSelector("ul.list-of-sins"));
		listOfSins.findElement(By.xpath("./li[contains(text(),'" + spiderSin.getTitle() + "')]")).click();
	}

	public void checkSinStatus(Sin spiderSin) {
		// najst element hriech
		WebElement actualSin = getSinFromListElement(spiderSin);

		// vytiahnut text
		String actualText = actualSin.findElement(By.cssSelector("p")).getText().trim();

		// porovnat so skutocnym
		if (spiderSin.isForgiven()) {
			Assert.assertEquals("forgiven", actualText);
		} else {
			Assert.assertEquals("pending", actualText);
		}

	}

	private WebElement getSinFromListElement(Sin spiderSin) {
		WebElement listOfSins = driver.findElement(By.cssSelector("ul.list-of-sins"));
		WebElement actualSin = listOfSins
				.findElement(By.xpath("./li[contains(text(),'" + spiderSin.getTitle() + "')]"));
		return actualSin;
	}

	public void openDetail(Sin spiderSin) {
		getSinFromListElement(spiderSin).click();

	}

	public void checkDetail(Sin spiderSin) {
		// 1.element detialu

		WebElement sinDetail = driver.findElement(By.cssSelector("div.detail"));

		// pockat na hriech

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.textToBePresentInElement(sinDetail.findElement(By.cssSelector("p")), spiderSin.getMessage()));

		// overit meassage, author, title

		String actualTitle = sinDetail.findElement(By.cssSelector("h4")).getText();
		Assert.assertTrue(actualTitle.contains(spiderSin.getTitle()));
		Assert.assertTrue(actualTitle.contains(spiderSin.getAuthor()));

	}

}
