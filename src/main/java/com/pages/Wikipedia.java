package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Wikipedia extends BasePage {

	@FindBy(xpath = "//th[contains(text(),'Country')]//following-sibling::td")
	private WebElement countryName;

	@FindBy(xpath = "//div[contains(text(),'Release date')]//following::td[1]")
	private WebElement movieReleaseDate;

	/**
	 * Instantiates a new Wikipedia page
	 *
	 * @param driver the driver
	 */
	public Wikipedia(WebDriver driver) {
		super(driver);
	}

	/**
	 * Gets the country Name
	 *
	 */
	public String getCountryName() {
		return countryName.getText();
	}

	/**
	 * Gets the movie releaseDate
	 *
	 */
	public String getMovieReleaseDate() {
		return movieReleaseDate.getText();
	}

}
