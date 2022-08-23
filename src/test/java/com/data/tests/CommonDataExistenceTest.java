package com.data.tests;

import com.factory.PageinstancesFactory;
import com.pages.Imdb;
import com.pages.Wikipedia;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(testName = "Pushpa movies data test", description = "Verify the country name and release date information of pushpa movie from two different website")
public class CommonDataExistenceTest extends BaseTest {

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/Pushpa:_The_Rise";
    private static final String IMDB_URL = "https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0";

    @Test
    public void verifyMovieCountryName() {
        driver.get(IMDB_URL);
        Imdb imdbPage = PageinstancesFactory.getInstance(Imdb.class);
        String imdbCountryName = imdbPage.getCountryName();
        driver.get(WIKIPEDIA_URL);
        Wikipedia wikipedia = PageinstancesFactory.getInstance(Wikipedia.class);
        String wikipediaCountryName = wikipedia.getCountryName();
        Assert.assertEquals(imdbCountryName, wikipediaCountryName);
    }

    @Test
    public void verifyMovieReleaseDate() {
        driver.get(IMDB_URL);
        driver.manage().window().maximize();
        Imdb imdbPage = PageinstancesFactory.getInstance(Imdb.class);
        String imdbReleaseDate = imdbPage.getMovieReleaseDate();
        driver.get(WIKIPEDIA_URL);
        Wikipedia wikipedia = PageinstancesFactory.getInstance(Wikipedia.class);
        String wikipediaReleaseDate = wikipedia.getMovieReleaseDate();
        Assert.assertEquals(imdbReleaseDate, wikipediaReleaseDate);
    }

}
