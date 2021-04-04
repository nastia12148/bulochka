package com.company.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Statistics {

    private int views;
    private double rating;

    public Statistics() {
    }

    public Statistics(int views, double rating) {
        this.views = views;
        this.rating = rating;
    }

    public ArrayList<Anime> sort(ArrayList<Anime> list, boolean ratingOrViews) {
        final Comparator<Anime> comparator = ratingOrViews
                ? Anime::compareToRating
                : Anime::compareToViews;

        list.sort(comparator);

        return list;
    }

    public double qualityIndexOfAnime(){
        return rating*(double)views;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "views=" + views +
                ", rating=" + rating +
                '}';
    }

    public int getViews() { return views; }

    public void setViews(int views) { this.views = views; }

    public double getRating() { return rating; }

    public void setRating(double rating) { this.rating = rating; }

}
