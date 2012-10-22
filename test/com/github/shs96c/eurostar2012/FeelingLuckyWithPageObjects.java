package com.github.shs96c.eurostar2012;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FeelingLuckyWithPageObjects {

  @Test
  public void navigateToGoogle() {
    WebDriver driver = new FirefoxDriver();

    // Create the page object
    GoogleFeelingLucky google = new GoogleFeelingLucky(driver);
    // Now do the navigation
    google.get();

    driver.quit();
  }

  @Test
  public void performAnIFeelLuckySearch() {
    WebDriver driver = new FirefoxDriver();

    GoogleFeelingLucky google = new GoogleFeelingLucky(driver).get();
    google.doFeelingLuckySearch();

    driver.quit();
  }

  @Test
  public void performAnIFeelLuckySearchAndCountForResults() {
    WebDriver driver = new FirefoxDriver();

    GoogleFeelingLucky google = new GoogleFeelingLucky(driver).get();
    DoodlePage doodles = google.doFeelingLuckySearch();

    int count = doodles.getDoodleCount();
    assertTrue(count > 0);

    System.out.println("allImages.size() = " + count);

    driver.quit();
  }
}
