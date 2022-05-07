package Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import CommonProperties.UI_Auto.CustomWebElement;
import CommonProperties.UI_Auto.DateFormatter;

public class Wikipedia extends CustomWebElement {

	public Wikipedia(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement filterInputText;

	@FindBy(xpath = "//input[@id='searchButton']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")
	private WebElement releaseDateText;

	@FindBy(xpath = "//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[14]/td")
	private WebElement releaseCountryText;

	public static String country;
	public static LocalDate releaseDate;

	public void verifyFields() {
		Assert.assertTrue(filterInputText.isDisplayed(), "Search text field Field is displayed on wikipedia home page");
		Assert.assertTrue(searchButton.isDisplayed(), "Search button is displayed on wikipedia home page");

	}

	public void enterDetails(String searchText) {
		if (!filterInputText.isDisplayed() || !filterInputText.isEnabled()) {
			Assert.fail("Search textfield is not displayed or enabled");
		}
		filterInputText.sendKeys(searchText);
	}

	public void clickSearchButton() {
		if (!searchButton.isDisplayed() || !searchButton.isEnabled()) {
			Assert.fail("Search button is not displayed or enabled");
		}
		searchButton.click();
	}

	public void getReleaseDate() {
		if (!releaseDateText.isDisplayed()) {
			Assert.fail("No release date displayed on the page");
		}
		if (!releaseCountryText.isDisplayed()) {
			Assert.fail("No release country displayed on the page");
		}
		country = releaseCountryText.getText().trim();
		String relDate = releaseDateText.getText().trim();
		releaseDate = DateFormatter.parseCustomDates(relDate);
	}
}
