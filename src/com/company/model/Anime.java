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


    public int compareTo1(Anime o1){
        if(this.statistics.getRating()== o1.statistics.getRating()){

        }
        else if(this.statistics.getRating() > o1.statistics.getRating()){

        }else{

        }
    }
}
