package com.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimeList<T extends Anime> extends ArrayList<T> implements List<T> {

    public AnimeList<Anime> sort(AnimeList<Anime> list, boolean ratingOrViews ){

        if(ratingOrViews == true){
        Comparator<Anime> sortByRating = new Comparator<Anime>() {
            @Override
            public int compare(Anime o1, Anime o2) {
                //return o1.compareTo(o2);
                return  0;
            }

        };
        Collections.sort(list,sortByRating);
        }else{
            Comparator<Anime> sortByViews = new Comparator<Anime>() {
                @Override
                public int compare(Anime o1, Anime o2) {
                    //return o1.compareTo(o2);
                    return  0;
                }

            };
            Collections.sort(list,sortByViews);
        }
        return list;
    }

}
