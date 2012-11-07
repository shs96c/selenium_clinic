package com.github.shs96c.eurostar2012;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AutocompleteOnGoogle {

  @Test
  public void hackedTogetherVisitGoogleAndUseAutocomplete() throws Exception {
    WebDriver driver = new FirefoxDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 30);

    driver.get("http://www.google.co.uk?complete=1");

    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("cheese\n");
    wait.until(visibilityOfElementLocated(By.className("navend")));

    driver.findElement(By.name("btnG")).click();

    searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("c");
    wait.until(visibilityOfElementLocated(By.className("gssb_m")));
    searchBox.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);  // This is a really bad idea, but you can see what happens :)
    searchBox.sendKeys("\n");

    driver.quit();
  }
}
