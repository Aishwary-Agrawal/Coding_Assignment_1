package Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.lang.*;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import CommonProperties.UI_Auto.CustomWebElement;
import CommonProperties.UI_Auto.DateFormatter;

public class Imdb extends CustomWebElement {

	public Imdb(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(xpath = "//input[@id='suggestion-search']")
	private WebElement searchSuggestionTextField;

	@FindBy(xpath = "//button[@id='suggestion-search-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='main']/div/div[2]/table/tbody/tr[1]/td[2]/a")
	private WebElement movieTableRow;

	@FindBy(xpath = "//*[@id='__next']/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[2]/div/ul/li/a")
	private WebElement originCountry;

	@FindBy(xpath = "//*[@id='__next']/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[1]/div/ul/li/a")
	private WebElement releasedDate;

	public static String country;
	public static LocalDate releaseDate;

	public void verifyFields() {
		Assert.assertTrue(searchSuggestionTextField.isDisplayed(),
				"Search text field Field is displayed on imdb home page");
		Assert.assertTrue(searchButton.isDisplayed(), "Search button is displayed on imdb home page");

	}

	public void enterDetails(String searchText) {
		if (!searchSuggestionTextField.isDisplayed() || !searchSuggestionTextField.isEnabled()) {
			Assert.fail("Search textfield is not displayed or enabled");
		}
		searchSuggestionTextField.sendKeys(searchText);
	}

	public void clickSearchButton() {
		if (!searchButton.isDisplayed() || !searchButton.isEnabled()) {
			Assert.fail("Search button is not displayed or enabled");
		}
		searchButton.click();
	}

	public void validateFieldsToPerformSearch(String searchText) {
		verifyFields();
		enterDetails(searchText);
		clickSearchButton();
	}

	public void clickMovieTable() {
		try {
			Thread.sleep(1000);
			movieTableRow.click();
			Thread.sleep(2000);
			country = originCountry.getText().trim();
			String relDate = releasedDate.getText().trim();
			String newDate = (String) relDate.replace(",", "");
			String splittedDate[] = newDate.split(" ");
			String month = splittedDate[0];
			String day = splittedDate[1];
			String year = splittedDate[2];
			String finalDate = day + " " + month + " " + year;
			releaseDate = DateFormatter.parseCustomDates(finalDate);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
