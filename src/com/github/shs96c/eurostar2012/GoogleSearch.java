package com.github.shs96c.eurostar2012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GoogleSearch implements SearchPage {

  private final WebDriver driver;
  private final Wait<WebDriver> wait;

  public GoogleSearch(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
  }

  public ResultsPage searchFor(String term) {
    // We use "complete=1" to force Google Instant to be on
    driver.get("http://www.google.com?complete=1");
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys(term);

    wait.until(visibilityOfElementLocated(By.id("res")));

    return new GoogleResults(driver);
  }
}
