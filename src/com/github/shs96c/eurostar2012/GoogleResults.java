package com.github.shs96c.eurostar2012;

import com.github.shs96c.eurostar2012.domain.SearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleResults implements ResultsPage {

    private final WebDriver driver;

    public GoogleResults(WebDriver driver) {
        this.driver = driver;
    }

    public int getCount() {
        WebElement resultsList = driver.findElement(By.id("res"));
        List<WebElement> allResults = resultsList.findElements(By.tagName("li"));
        return allResults.size();
    }


}
