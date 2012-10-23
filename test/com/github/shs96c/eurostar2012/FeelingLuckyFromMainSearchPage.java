package com.github.shs96c.eurostar2012;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class FeelingLuckyFromMainSearchPage {

    @Test
    public void canRevealPredictiveSearchFeelingLuckyAndClickOnIt(){
      WebDriver driver = new FirefoxDriver();
      Wait<WebDriver> wait = new WebDriverWait(driver, 10);

      driver.get("https://www.google.co.uk/search?q=.");

      WebElement searchInput = driver.findElement(By.cssSelector("input[name='q']"));

      searchInput.clear();
      searchInput.sendKeys("selenium");

      // "I feel lucky" only appears when you hover over the first item in
      // the selection list or select it
      //<table class="gssb_m">

      // Note: we'd normally use a static import to make this code read nicely
      // but this way, you can see where the "visibility..." method comes from.
      wait.until(
          ExpectedConditions.visibilityOfElementLocated(
              By.cssSelector("table[class='gssb_m']")));

      List<WebElement> predictiveSearchResults = driver.findElements(
          By.cssSelector("table[class='gssb_m'] > tbody > tr"));

      // the one we want should be the first one
      WebElement seleniumPredictedSearch = predictiveSearchResults.get(0);
      assertThat(seleniumPredictedSearch.getText(), is("selenium"));

      // hover over it or select it
      searchInput.sendKeys(Keys.ARROW_DOWN);

      // wait until the #ifl I feel lucky link is ready for use
      WebElement iFeelLuckyLink = wait.until(
          ExpectedConditions.elementToBeClickable(
              By.cssSelector("a[href='#ifl']")));

      // can't guarantee that it will always be selenium home page, but I
      // assume title will always contain selenium
      String oldTitle = driver.getTitle();

      iFeelLuckyLink.click();

      assertThat(driver.getTitle(), is(not(oldTitle)));
      assertThat(driver.getTitle().toLowerCase(), containsString("selenium"));

      driver.quit();
    }
}
