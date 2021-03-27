package com.company.model;

import com.company.Statistics;

public class Anime {

    final String name;
    final Statistics statistics;
    final AgeLimits limit;
    final String description;
    final Tag tag;

    public Anime(String name, Statistics statistics, AgeLimits limit, String description, Tag tag) {
        this.name = name;
        this.statistics = statistics;
        this.limit = limit;
        this.description = description;
        this.tag = tag;
    }


    public int compareToRating(Anime o1){
        if(this.statistics.getRating()== o1.statistics.getRating()){
            return  0;
        }
        else if(this.statistics.getRating() > o1.statistics.getRating()){
            return 1;
        }else{
            return  -1;
        }
    }

    public int compareToViews(Anime o1){
        if(this.statistics.getViews()== o1.statistics.getViews()){
            return  0;
        }
        else if(this.statistics.getViews() > o1.statistics.getViews()){
            return 1;
        }else{
            return  -1;
        }
    }
}
