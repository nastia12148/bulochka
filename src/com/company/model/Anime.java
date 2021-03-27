package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

abstract public class Anime {

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

    @Override
    abstract public String toString();

    public int compareToRating(final Anime animeToCompare) {
        return (int) (statistics.getRating() - animeToCompare.statistics.getRating());
    }

    public int compareToViews(final Anime animeToCompare) {
        return (int) (statistics.getViews() - animeToCompare.statistics.getViews());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public AgeLimits getLimit() {
        return limit;
    }

    public void setLimit(AgeLimits limit) {
        this.limit = limit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
