package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class represents ImdbPage.
 *
 */
public class Imdb extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Country of origin')]//following::a[1]")
	private WebElement countryName;


	@FindBy(xpath = "//a[contains(text(),'Release date')]//following::a[1]")
	private WebElement movieReleaseDate;

	/**
	 * Instantiates a new imdb page.
	 *
	 * @param driver the driver
	 */
	public Imdb(WebDriver driver) {
		super(driver);
	}



	/**
	 * Gets the country Name.
	 *
	 */
	public String getCountryName() {
		return countryName.getText();
	}

	/**
	 * Gets the movie releaseDate.
	 *
	 */
	public String getMovieReleaseDate() {
		return movieReleaseDate.getText();
	}

}
