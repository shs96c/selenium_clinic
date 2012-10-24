package com.github.shs96c.eurostar2012.domain;

import java.util.List;

public interface SearchEngine {

    List<SearchResult> searchFor(String term);
}
