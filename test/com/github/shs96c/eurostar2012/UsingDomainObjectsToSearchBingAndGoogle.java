package com.github.shs96c.eurostar2012;

import com.github.shs96c.eurostar2012.domain.Bing;import com.github.shs96c.eurostar2012.domain.Google;
import com.github.shs96c.eurostar2012.domain.SearchEngine;
import com.github.shs96c.eurostar2012.domain.SearchResult;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UsingDomainObjectsToSearchBingAndGoogle {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

    @Test
    public void searchUsingGoogle() {
        SearchEngine google = new Google(driver);

        List<SearchResult> results = google.searchFor("selenium");

        assertThat(results.size(), is(greaterThan(0)));
    }

    @Test
    public void searchUsingBing() {
        SearchEngine bing = new Bing(driver);

        List<SearchResult> results = bing.searchFor("selenium");

        assertThat(results.size(), is(greaterThan(0)));
    }

}
