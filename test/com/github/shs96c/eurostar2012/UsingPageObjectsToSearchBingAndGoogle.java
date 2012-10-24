package com.github.shs96c.eurostar2012;

import com.github.shs96c.eurostar2012.domain.SearchResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UsingPageObjectsToSearchBingAndGoogle {

    private WebDriver driver;

    @Before
    public void createDriver() {
        driver = new FirefoxDriver();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void searchUsingGoogle() {
        SearchPage page = new GoogleSearch(driver);
        ResultsPage results = page.searchFor("selenium");

        assertThat(results.getCount(), is(greaterThan(0)));
    }

    @Test
    public void searchUsingBing() {
        SearchPage page = new BingSearch(driver);
        ResultsPage results = page.searchFor("selenium");

        System.out.println("results.getCount() = " + results.getCount());
        assertThat(results.getCount(), is(greaterThan(0)));

    }

    // added the following just to show injection athough it doesn't add much
    @Test
    public void searchUsingGoogleInject() {
        SearchPage page = new GoogleSearch(driver);
        searchAndCheckDomainResults(page);
    }

    @Test
    public void searchUsingBingInject() {
        SearchPage page = new BingSearch(driver);
        searchAndCheckDomainResults(page);
    }

    private void searchAndCheckDomainResults(SearchPage page) {

        ResultsPage resultsPage = page.searchFor("selenium");

        assertThat(resultsPage.getCount(), is(greaterThan(0)));
    }

}
