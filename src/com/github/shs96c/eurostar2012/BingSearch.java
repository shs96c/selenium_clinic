package com.github.shs96c.eurostar2012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BingSearch implements SearchPage {

  private final WebDriver driver;
  private final Wait<WebDriver> wait;

  public BingSearch(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
  }

  public ResultsPage searchFor(String term) {
    driver.get("http://www.bing.com/");
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys(term);
    WebElement magnifyingGlass = driver.findElement(By.name("go"));
    magnifyingGlass.click();

    wait.until(visibilityOfElementLocated(By.id("results_area")));

    return new BingResults(driver);
  }
}
