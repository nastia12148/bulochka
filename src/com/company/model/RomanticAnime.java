package com.company.model;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;

public class RomanticAnime extends Anime {
    int amountOfGirlfriends;

    public RomanticAnime(final String name, final Statistics statistics, final AgeLimits limit,
                         final String description, final Tag tag, final  int amountOfGirlfriends) {
        super(name, statistics, limit, description, tag);
        this.amountOfGirlfriends = amountOfGirlfriends;
    }

    @Override
    public String toString() {
        return "RomanticAnime{" + "name: " + getName()
                + "statistics: " + getStatistics().toString()
                + "age limit: " + getLimit().toString()
                + "description: " + getDescription()
                + "tag: " + getTag().toString()
                + "amount of girlfriends" + getAmountOfGirlfriends()
                + "}\n";
    }

    public boolean isGarem(int amountOfGirlfriends){
        if(amountOfGirlfriends<=1){
            return false;
        } else{
          return true;
        }
    }

    public int getAmountOfGirlfriends() {
        return amountOfGirlfriends;
    }

    public void setAmountOfGirlfriends(int amountOfGirlfriends) {
        this.amountOfGirlfriends = amountOfGirlfriends;
    }
}
