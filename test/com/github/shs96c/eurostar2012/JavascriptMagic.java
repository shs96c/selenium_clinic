package com.github.shs96c.eurostar2012;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class JavascriptMagic {

    @Test
    public void getDataBackFromJavascript() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().setScriptTimeout(30, SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("http://www.google.com/");

        Number duration = (Number) js.executeScript(
                "var t = window.performance.timing;" +
                "var duration = t.domComplete - t.requestStart;" +
                "return duration;");
        System.out.println("duration.intValue() = " + duration.intValue());

        WebElement body = (WebElement) js.executeScript("return document.body");
        System.out.println(body.getTagName());

        String tagName = (String) js.executeScript("return arguments[0].tagName;", body);
        System.out.println("tagName = " + tagName);

        String value = (String) js.executeAsyncScript("var cb = arguments[arguments.length - 1]; " +
                "window.setTimeout(function() { cb('hello') }, 1000);");
        System.out.println("value = " + value);

        driver.quit();
    }
}
