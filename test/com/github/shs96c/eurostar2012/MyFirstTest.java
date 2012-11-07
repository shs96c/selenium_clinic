package com.github.shs96c.eurostar2012;

import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MyFirstTest {


    private WebDriver driver;
    private Wait<WebDriver> wait;

    @Before
    public void createDriver() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void tidyUp() {
        driver.quit();
    }

    @Test
    public void myFirstGoogleTest(){
        driver.get("http://www.google.com");

        ((WebDriverWait)wait).withTimeout(60, TimeUnit.SECONDS);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Cheese");

        WebElement navend = wait.until(navEndIsVisibleAndTitleContains("heese"));
    }

    private ExpectedCondition<WebElement> navEndIsVisibleAndTitleContains(final String needle) {
        return new ExpectedCondition<WebElement>() {

            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement toReturn = webDriver.findElement(By.className("navend"));
                if (!toReturn.isDisplayed()) {
                    return null;
                }

                String haystack = webDriver.getTitle();
                if (haystack.contains(needle)) {
                    return toReturn;
                }

                return null;
            }
        };
    }
}
