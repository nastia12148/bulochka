package com.company.model;

import com.company.Statistics;

public class Anime {

    private String name;
    private Statistics statistics;
    private AgeLimits limit;
    private String description;
    private Tag tag;

    public Anime(String name, Statistics statistics, AgeLimits limit, String description, Tag tag) {
        this.name = name;
        this.statistics = statistics;
        this.limit = limit;
        this.description = description;
        this.tag = tag;
    }


    public int compareToRating (Anime o1) {
        return (int) (statistics.getRating() - o1.statistics.getRating());
    }

    public int compareToViews (Anime o1) {
        return (int) (statistics.getViews() - o1.statistics.getViews());
    }
}
