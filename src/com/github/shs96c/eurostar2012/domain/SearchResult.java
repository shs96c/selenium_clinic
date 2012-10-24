package com.github.shs96c.eurostar2012.domain;

/**
 * A domain object to represent an item in a search result
 */
public class SearchResult {

    private String description;
    private String url;
    private String title;

    public SearchResult(String aDescription, String aURL, String aTitle){
        this.description = aDescription;
        this.url = aURL;
        this.title = aTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

}
