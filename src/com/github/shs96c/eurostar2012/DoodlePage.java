package com.github.shs96c.eurostar2012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DoodlePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public DoodlePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
  }

  public int getDoodleCount() {
    List<WebElement> allImages = wait.until(
        presenceOfManyElementsLocated(By.className("doodle-image")));
    return allImages.size();
  }

  private ExpectedCondition<List<WebElement>> presenceOfManyElementsLocated(final By locator) {
    return new ExpectedCondition<List<WebElement>>() {
      public List<WebElement> apply(WebDriver driver) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() > 0) {
          return elements;
        }

        return null;
      }
    };
  }
}
