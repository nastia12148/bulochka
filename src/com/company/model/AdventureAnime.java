package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

public class AdventureAnime extends Anime {

    public AdventureAnime(final String name, final Statistics statistics, final AgeLimits limit,
                          final String description, final Tag tag) {
        super(name, statistics, limit, description, tag);
    }

    @Override
    public String toString() {
        return "AdventureAnime{" + "name: " + getName()
                + "statistics: " + getStatistics().toString()
                + "age limit: " + getLimit().toString()
                + "description: " + getDescription()
                + "tag: " + getTag().toString()
                + "}\n";
    }
}
