package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

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

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", statistics=" + statistics +
                ", limit=" + limit +
                ", description='" + description + '\'' +
                ", tag=" + tag +
                '}';
    }

    public int compareToRating(final Anime animeToCompare) {
        return (int) (statistics.getRating() - animeToCompare.statistics.getRating());
    }

    public int compareToViews(final Anime animeToCompare) {
        return (int) (statistics.getViews() - animeToCompare.statistics.getViews());
    }


}
