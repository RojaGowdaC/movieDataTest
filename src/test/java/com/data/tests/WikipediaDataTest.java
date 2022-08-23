package com.data.tests;

import com.factory.PageinstancesFactory;
import com.pages.Wikipedia;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(testName = "WikipediaDataTest", description = "Verify the country name and release date information of pushpa movie from wikipedia")
public class WikipediaDataTest extends BaseTest {
    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/Pushpa:_The_Rise";
    @Test
    public void wikipediaDataTest() {
        driver.get(WIKIPEDIA_URL);
        Wikipedia wikipedia = PageinstancesFactory.getInstance(Wikipedia.class);
        Assert.assertEquals(wikipedia.getCountryName(), "India");
        Assert.assertEquals(wikipedia.getMovieReleaseDate(), "17 December 2021");
    }
}

