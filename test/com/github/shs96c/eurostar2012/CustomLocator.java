package com.github.shs96c.eurostar2012;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomLocator {

    @Test
    public void demoCustomLocator() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.co.uk/");
        WebElement button = driver.findElement(byJquery("$(body)"));

        assertEquals("Google Search", button.getText());

        driver.quit();
    }

    private By byJquery(final String label) {
        return new By() {

            @Override
            public List<WebElement> findElements(SearchContext context) {
                JavascriptExecutor js = null;
                if (context instanceof JavascriptExecutor) {
                    js = (JavascriptExecutor) context;
                } else if (context instanceof WrapsDriver) {
                    js = (JavascriptExecutor) ((WrapsDriver) context).getWrappedDriver();
                } else {
                    throw new WebDriverException("context does not allow js execution");
                }

                WebElement body = (WebElement) js.executeScript("return document.body;");
                return Collections.singletonList(body);
            }
        };
    }
}
