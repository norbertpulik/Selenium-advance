package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import base.TestBase;
import enumeratios.SinType;
import models.Sin;
import pages.SinCityPage;
import pages.SpartaPage;

public class SinCityTest extends TestBase {

	@Test

	public void testNewSin() {

		// priprave testu
		SinCityPage sinCityPage = new SinCityPage();
		Sin spiderSin = new Sin("zabil", "noro", "kobercom");
		List<SinType> spiderSinTags = new ArrayList<SinType>();
		spiderSinTags.add(SinType.MURDER);
		spiderSinTags.add(SinType.ROBBERY);
		spiderSin.setTags(spiderSinTags);

		// vykonanie testu
		sinCityPage.openPage();
		sinCityPage.fillSinnInformation(spiderSin);
		sinCityPage.markTag(spiderSin.getTags());
		sinCityPage.confessSinn();
		sinCityPage.openSinDetail(spiderSin);
		sinCityPage.checkSinStatus(spiderSin);
		sinCityPage.openDetail(spiderSin);
		sinCityPage.checkDetail(spiderSin);

	}

	@Test
	public void testForgive() {
		
	Sin evaSpieva = new Sin("spievamcd", "evasdc m.", "spievam dscstale");
	SinCityPage sinCityPage = new SinCityPage();
	
	sinCityPage.openPage();
	sinCityPage.fillSinnInformation(evaSpieva);
	sinCityPage.confessSinn();
	
	SpartaPage spartaPage =  new SpartaPage ();
	spartaPage.openPage();
	spartaPage.forgiveSin(evaSpieva);
	
	sinCityPage.openPage();
	sinCityPage.checkSinStatus(evaSpieva);
	

	}
}
