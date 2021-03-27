package com.company.model;

import com.company.Statistics;
import com.company.model.Anime;

public class ComedyAnime extends Anime {

    public ComedyAnime (final String name, final Statistics statistics, final AgeLimits limit,
                        final String description, final Tag tag) {
        super(name, statistics, limit, description, tag);
    }
}
