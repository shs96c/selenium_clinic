package com.github.shs96c.eurostar2012;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.fail;

public class GoogleFeelingLucky extends LoadableComponent<GoogleFeelingLucky> {

  private final WebDriver driver;

  public GoogleFeelingLucky(WebDriver driver) {
    this.driver = driver;

  }

  @Override
  protected void load() {
    driver.get("http://www.google.com?complete=0");
  }

  @Override
  protected void isLoaded() throws Error {
    try {
      driver.findElement(By.name("btnI"));
    } catch (NoSuchElementException ignored) {
      fail("Cannot locate feeling lucky button");
    }
  }

  public DoodlePage doFeelingLuckySearch() {
    WebElement feelingLucky = driver.findElement(By.name("btnI"));
    feelingLucky.click();

    return new DoodlePage(driver);
  }
}
