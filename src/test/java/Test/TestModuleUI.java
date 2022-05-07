package Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonProperties.UI_Auto.DriverInitialization;
import CommonProperties.UI_Auto.UITestProperties;

public class TestModuleUI extends DriverInitialization {
	Wikipedia wiki;
	Imdb imd;
	private static String wikipediaUrl;
	private static String imdbUrl;
	private String searchValue = "Pushpa: The Rise";

	@BeforeClass
	public void init() {
		wikipediaUrl = UITestProperties.getWikipediaUrl();
		imdbUrl = UITestProperties.getImdbUrl();
		launchChromeDriver();
		wiki = new Wikipedia(DriverInitialization.driver);
		imd = new Imdb(DriverInitialization.driver);
	}

	@Test(description = "Verify fields in login screen")
	public void TC_001() {
		launchUrl(wikipediaUrl);
		wiki.verifyFields();
		wiki.enterDetails(searchValue);
		wiki.clickSearchButton();
		wiki.getReleaseDate();
		launchUrl(imdbUrl);
		imd.validateFieldsToPerformSearch(searchValue);
		imd.clickMovieTable();
		Assert.assertEquals(Wikipedia.country, Imdb.country, "Country don't match");
		Assert.assertEquals(Wikipedia.releaseDate.toString(), Imdb.releaseDate.toString(), "Release Date don't match");
	}
	
	/*
	 * @Test(description = "get date and country from imdb") public void TC_004() {
	 * launchUrl(imdbUrl); imd.validateFieldsToPerformSearch(searchValue);
	 * imd.clickMovieTable(); }
	 */
	
	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
