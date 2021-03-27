package com.company;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.Anime;
import com.company.model.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final List<Anime> animeList = new ArrayList<>();

        readFromConsole(animeList);

        animeList.stream()
                .map(Anime::toString)
                .forEach(System.out::println);

        System.out.println("Sorted by rating: \n");
        animeList.stream()
                .sorted(Anime::compareToRating)
                .map(Anime::toString)
                .forEach(System.out::println);

        System.out.println("Sorted by views: \n");
        animeList.stream()
                .sorted(Anime::compareToViews)
                .map(Anime::toString)
                .forEach(System.out::println);
    }

    public static void readFromConsole(List<Anime> animeList) throws Exception{
        Scanner animeScanner = new Scanner(System.in);
        System.out.println("Enter the amount of anime");
        int amountOfAnime = animeScanner.nextInt();
        String name;
        Statistics statistics = new Statistics();
        AgeLimits limit = AgeLimits.CODOMO;
        String description;
        Tag tag;
        for (int i = 0; i < amountOfAnime; i++){
            System.out.println("Enter the name of anime");
            name = animeScanner.next();
            System.out.println("Enter the rating of anime");
            statistics.setRating(Double.parseDouble(animeScanner.next()));
            System.out.println("Enter the views of anime");
            statistics.setViews(Integer.parseInt(animeScanner.next()));
            System.out.println("Enter the age limit of anime (CODOMO, SUNEEN, SHOZE, SEINEN, JOSAI)");
            limit = AgeLimits.valueOf(animeScanner.next());
            System.out.println("Enter the description of anime");
            description = animeScanner.next();
            System.out.println("Enter the tag of anime (HETERO, YAOI, YURI, FANTASY, GAME, HISTORY)");
            tag = Tag.valueOf(animeScanner.next());

            animeList.add(new Anime(name, statistics, limit, description, tag));
        }
    }
}


