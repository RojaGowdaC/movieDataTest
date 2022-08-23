package com.data.tests;

import com.factory.PageinstancesFactory;
import com.pages.Imdb;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(testName = "Imdb movies data test", description = "Verify the country name and release date information of pushpa movie from imdb website")
public class ImdbDataTest extends BaseTest {
    private static final String IMDB_URL = "https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0";
    @Test
    public void imdbDataTest() {
        driver.get(IMDB_URL);
        driver.manage().window().maximize();
        Imdb imdbPage = PageinstancesFactory.getInstance(Imdb.class);
        Assert.assertEquals(imdbPage.getCountryName(), "India");
        Assert.assertEquals(imdbPage.getMovieReleaseDate(), "January 7, 2022 (United States)");
    }
}
