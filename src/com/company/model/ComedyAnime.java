package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

public class ComedyAnime extends Anime {
    private int amountOfJokes;

    public ComedyAnime(final String name, final Statistics statistics, final AgeLimits limit,
                       final String description, final Tag tag, final  int amountOfJokes) {
        super(name, statistics, limit, description, tag);
        this.amountOfJokes = amountOfJokes;
    }

    @Override
    public String toString() {
        return "ComedyAnime{" + "name: " + getName()
                + "statistics: " + getStatistics().toString()
                + "age limit: " + getLimit().toString()
                + "description: " + getDescription()
                + "tag: " + getTag().toString()
                + "amount of jokes: " + getAmountOfJokes()
                + "}\n";
    }

    public int getAmountOfJokes() {
        return amountOfJokes;
    }

    public void setAmountOfJokes(int amountOfJokes) {
        this.amountOfJokes = amountOfJokes;
    }
}
