package com.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimeList<T extends Anime> extends ArrayList<T> implements List<T> {

    public AnimeList<Anime> sort(AnimeList<Anime> list, boolean ratingOrViews) {
        final Comparator<Anime> comparator = ratingOrViews
                ? Anime::compareToRating
                : Anime::compareToViews;

        list.sort(comparator);

        return list;
    }

}
