package com.example.news_app;

import java.io.Serializable;
import java.util.List;

public class NewsItem implements Serializable {
    private String title;
    private String description;
    private String imageUrl;
    private List<NewsItem> relatedNews;

    public NewsItem(String title, String description, String imageUrl, List<NewsItem> relatedNews) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.relatedNews = relatedNews;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<NewsItem> getRelatedNews() {
        return relatedNews;
    }
}
