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

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FeelingLucky {

  @Test
  public void navigateToGoogle() {
    WebDriver driver = new FirefoxDriver();

    driver.get("http://www.google.com?complete=0");

    driver.quit();
  }

  @Test
  public void performAnIFeelLuckySearch() {
    WebDriver driver = new FirefoxDriver();

    driver.get("http://www.google.com?complete=0");
    WebElement feelingLucky = driver.findElement(By.name("btnI"));
    feelingLucky.click();

    driver.quit();
  }

  @Test
  public void performAnIFeelLuckySearchAndWaitForResults() {
    WebDriver driver = new FirefoxDriver();

    driver.get("http://www.google.com?complete=0");
    WebElement feelingLucky = driver.findElement(By.name("btnI"));
    feelingLucky.click();

    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
    wait.until(visibilityOfElementLocated(By.id("doodle-list")));

    driver.quit();
  }

  @Test
  public void performAnIFeelLuckySearchAndCountForResults() {
    WebDriver driver = new FirefoxDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 30);

    driver.get("http://www.google.com?complete=0");
    WebElement feelingLucky = driver.findElement(By.name("btnI"));
    feelingLucky.click();

    List<WebElement> allImages = wait.until(
        presenceOfManyElementsLocated(By.className("doodle-image")));
    System.out.println("allImages.size() = " + allImages.size());

    driver.quit();
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
