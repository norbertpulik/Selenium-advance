package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import base.TestBase;
import enumeratios.SinType;
import models.Sin;

public class SinCityTest extends TestBase {

	@Test

	public void testNewSin() {
		getDriver().get(BASE_URL + "sincity.php");
		Sin spiderSin = new Sin("zabil", "noro", "kobercom");
		
		List<SinType> spiderSinTags = new ArrayList<SinType>();
		spiderSinTags.add(SinType.MURDER);
		spiderSinTags.add(SinType.ROBBERY);
		
		

		spiderSin.setTags(spiderSinTags);
		
		fillSinnInformation(spiderSin);
		markTag(spiderSin.getTags());
	}

	private void fillSinnInformation(Sin sin) {
		getDriver().findElement(By.name("title")).sendKeys(sin.getTitle());
		getDriver().findElement(By.name("author")).sendKeys(sin.getTitle());
		getDriver().findElement(By.name("message")).sendKeys(sin.getMessage());

	}

	private void markTag(List<SinType> tags) {
		for (SinType tag : tags) {
			getDriver().findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();

		}
	}

}
