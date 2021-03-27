package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

public class AdventureAnime extends Anime {
    int amountOfLocations;

    public AdventureAnime(final String name, final Statistics statistics, final AgeLimits limit,
                          final String description, final Tag tag,final int amountOfLocations) {
        super(name, statistics, limit, description, tag);
        this.amountOfLocations = amountOfLocations;
    }

    @Override
    public String toString() {
        return "AdventureAnime{" + "name: " + getName()
                + "statistics: " + getStatistics().toString()
                + "age limit: " + getLimit().toString()
                + "description: " + getDescription()
                + "tag: " + getTag().toString()
                + "amount of locations:" + getAmountOfLocations()
                + "}\n";
    }

    public int getAmountOfLocations() {
        return amountOfLocations;
    }

    public void setAmountOfLocations(int amountOfLocations) {
        this.amountOfLocations = amountOfLocations;
    }
}
