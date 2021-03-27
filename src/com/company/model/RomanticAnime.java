package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

public class RomanticAnime extends Anime {

    public RomanticAnime(final String name, final Statistics statistics, final AgeLimits limit,
                         final String description, final Tag tag) {
        super(name, statistics, limit, description, tag);
    }

    @Override
    public String toString() {
        return "RomanticAnime{ " + super.toString();
    }
}
