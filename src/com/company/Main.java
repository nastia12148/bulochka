package com.company;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.*;
import com.company.util.WorkWithCSV;
import com.company.util.WorkWithXML;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WorkWithXML xml = new WorkWithXML();
        List<Anime> animeList = new ArrayList<>();
        animeList = xml.read("resourses/Anime.xml");
        animeList.stream()
                .map(Anime::toString)
                .forEach(System.out::println);

        WorkWithCSV csv = new WorkWithCSV();
        List<Anime> animeList_ = new ArrayList<>();
        animeList_ = csv.read("resourses/Anime.csv");
        animeList_.stream()
                .map(Anime::toString)
                .forEach(System.out::println);

        /*final List<Anime> animeList = new ArrayList<>();
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
                .forEach(System.out::println);*/
    }

    public static void readFromConsole(final List<Anime> animeList) {
        final Scanner animeScanner = new Scanner(System.in);

        System.out.println("Enter the amount of anime");
        final int amountOfAnime = animeScanner.nextInt();

        for (int i = 0; i < amountOfAnime; ++i) {

            final String animeType;
            System.out.println("Enter the anime type (R, C, A)");
            animeType = animeScanner.next();

            final String name;
            System.out.println("Enter the name of anime");
            name = animeScanner.next();

            final Statistics statistics = new Statistics();
            System.out.println("Enter the rating of anime");
            statistics.setRating(Double.parseDouble(animeScanner.next()));

            System.out.println("Enter the views of anime");
            statistics.setViews(Integer.parseInt(animeScanner.next()));

            final AgeLimits limit;
            System.out.println("Enter the age limit of anime (CODOMO, SUNEEN, SHOZE, SEINEN, JOSAI)");
            limit = AgeLimits.valueOf(animeScanner.next());

            final String description;
            System.out.println("Enter the description of anime");
            description = animeScanner.next();

            final Tag tag;
            System.out.println("Enter the tag of anime (FANTASY, GAME, HISTORY, HETERO, YAOI, YURI)");
            tag = Tag.valueOf(animeScanner.next());

            if (animeType.equals("R")) {
                final int amountOfGirlfriends;
                System.out.println("Enter the amount of girlfriends in anime");
                amountOfGirlfriends = Integer.parseInt(animeScanner.next());

                animeList.add(new RomanticAnime(name, statistics, limit, description, tag, amountOfGirlfriends));
            } else if (animeType.equals("C")) {
                final int amountOfJokes;
                System.out.println("Enter the amount of jokes in anime");
                amountOfJokes = Integer.parseInt(animeScanner.next());

                animeList.add(new ComedyAnime(name, statistics, limit, description, tag, amountOfJokes));
            } else if (animeType.equals("A")) {
                final int amountOfLocations;
                System.out.println("Enter the amount of locations in anime");
                amountOfLocations = Integer.parseInt(animeScanner.next());

                animeList.add(new AdventureAnime(name, statistics, limit, description, tag, amountOfLocations));
            } else {
                System.out.println("Anime type error");
            }
        }
    }
}


