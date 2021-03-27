package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

public class ComedyAnime extends Anime {

    public ComedyAnime(final String name, final Statistics statistics, final AgeLimits limit,
                       final String description, final Tag tag) {
        super(name, statistics, limit, description, tag);
    }

    @Override
    public String toString() {
        return "ComedyAnime{" + "name: " + getName()
                + "statistics: " + getStatistics().toString()
                + "age limit: " + getLimit().toString()
                + "description: " + getDescription()
                + "tag: " + getTag().toString()
                + "}\n";
    }
}
