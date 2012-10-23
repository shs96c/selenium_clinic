package com.github.shs96c.eurostar2012;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    SearchEngine engine = new GoogleSearch(driver);
    ResultsPage results = engine.searchFor("selenium");

    assertThat(results.getCount(), is(greaterThan(0)));
  }

  @Test
  public void searchUsingBing() {
    SearchEngine engine = new BingSearch(driver);
    ResultsPage results = engine.searchFor("selenium");

    System.out.println("results.getCount() = " + results.getCount());
    assertThat(results.getCount(), is(greaterThan(0)));
  }
}
