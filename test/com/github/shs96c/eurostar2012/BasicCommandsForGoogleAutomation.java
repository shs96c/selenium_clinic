package com.github.shs96c.eurostar2012;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class BasicCommandsForGoogleAutomation {

    @Test
    public void navigateToGoogleAndAssertTitle() {
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.google.com?complete=0");

        assertTrue("title should contain Google",
                    driver.getTitle().contains("Google"));

        driver.quit();
    }
}
