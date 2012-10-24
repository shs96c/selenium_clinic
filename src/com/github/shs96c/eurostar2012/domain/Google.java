package com.github.shs96c.eurostar2012.domain;

import com.github.shs96c.eurostar2012.GoogleSearch;
import com.github.shs96c.eurostar2012.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Google implements SearchEngine {

    private WebDriver driver;

    public Google(WebDriver driver){
        this.driver = driver;
    }


    @Override
    public List<SearchResult> searchFor(String term) {
        GoogleSearch google = new GoogleSearch(driver);
        google.searchFor(term);
        return getResults();
    }

    private List<SearchResult> getResults() {

        List<SearchResult> results = new ArrayList<SearchResult>();

        // a div class="vsc" per result
        List<WebElement> resultDetails = driver.findElements(By.cssSelector("div[class='vsc']"));
        for (WebElement weResult : resultDetails) {

            String aDescription = weResult.findElement(By.cssSelector("div[class='s'] > span[class='st']")).getText();
            String aTitle = weResult.findElement(By.cssSelector("h3 > a")).getText();
            String aURL = "http://" + weResult.findElement(By.cssSelector("div[class='s'] > div > cite")).getText();

            SearchResult result = new SearchResult(aDescription, aURL, aTitle);
            results.add(result);
        }

        return results;
    }
}
