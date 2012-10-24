package com.github.shs96c.eurostar2012.domain;

import com.github.shs96c.eurostar2012.BingSearch;
import com.github.shs96c.eurostar2012.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Bing implements SearchEngine {

    private WebDriver driver;

    public Bing(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @return a list of SearchResults as domain objects rather than page objects
     */
    private List<SearchResult> getResults(){

        List<SearchResult> results = new ArrayList<SearchResult>();

        // a div class="sa_mc" per result
        List<WebElement> resultDetails = driver.findElements(By.cssSelector("div[class='sa_mc']"));
        for(WebElement weResult : resultDetails){

            String aDescription = weResult.findElement(By.tagName("p")).getText();
            WebElement weTitle = weResult.findElement(By.cssSelector("div[class='sb_tlst'] > h3 > a"));
            String aTitle = weTitle.getText();
            String aURL = weTitle.getAttribute("href");

            SearchResult result = new SearchResult(aDescription, aURL, aTitle);
            results.add(result);
        }

        return results;
    }

    @Override
    public List<SearchResult> searchFor(String term) {
        BingSearch bing = new BingSearch(driver);
        bing.searchFor(term);
        return getResults();
    }
}
