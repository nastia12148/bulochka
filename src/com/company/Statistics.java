package com.company;

import java.util.Objects;

public class Statistics{

    int views;
    double rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistics)) return false;
        Statistics that = (Statistics) o;
        return views == that.views && Double.compare(that.rating, rating) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(views, rating);
    }

    public int getViews() { return views; }

    public void setViews(int views) { this.views = views; }

    public double getRating() { return rating; }

    public void setRating(double rating) { this.rating = rating; }

}
