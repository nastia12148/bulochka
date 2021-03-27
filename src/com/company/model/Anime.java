package com.company.model;

import com.company.Statistics;

public class Anime {

    private String name;
    private Statistics statistics;
    private AgeLimits limit;
    private String description;
    private Tag tag;

    public Anime(final String name, final Statistics statistics, final AgeLimits limit,
                 final String description, final Tag tag) {
        this.name = name;
        this.statistics = statistics;
        this.limit = limit;
        this.description = description;
        this.tag = tag;
    }

    public int compareToRating(final Anime animeToCompareByRating) {
        return (int) (statistics.getRating() - animeToCompareByRating.statistics.getRating());
    }

    public int compareToViews(final Anime animeToCompareByViews) {
        return (int) (statistics.getViews() - animeToCompareByViews.statistics.getViews());
    }
}
