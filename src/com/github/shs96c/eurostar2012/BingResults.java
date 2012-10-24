package com.github.shs96c.eurostar2012;

import com.github.shs96c.eurostar2012.domain.SearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BingResults implements ResultsPage {

  private final WebDriver driver;

  public BingResults(WebDriver driver) {
    this.driver = driver;
  }

  public int getCount() {
    WebElement resultsArea = driver.findElement(By.id("results"));
    // The class name used here looks like one that can change
    List<WebElement> allResults = resultsArea.findElements(By.className("sa_wr"));
    return allResults.size();
  }




}
