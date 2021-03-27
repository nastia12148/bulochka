package com.company;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.Anime;
import com.company.model.Statistics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Anime> animeList = new ArrayList<Anime>();
        readFromConsole(animeList);
        for (int i = 0 ; i < animeList.size() ; i++){
            System.out.println(animeList.get(i).toString());
        }
        animeList.sort(Anime::compareToRating);
        System.out.println("Sorted by rating: \n");
        for (int i = 0 ; i < animeList.size() ; i++){
            System.out.println(animeList.get(i).toString());
        }
        animeList.sort(Anime::compareToViews);
        for (int i = 0 ; i < animeList.size() ; i++){
            System.out.println(animeList.get(i).toString());
        }

    }

    public static void readFromConsole(ArrayList<Anime> animeList) throws Exception{
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


