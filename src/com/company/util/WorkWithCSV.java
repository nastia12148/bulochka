package com.company.util;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.AdventureAnime;
import com.company.model.Anime;
import com.company.model.Statistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithCSV implements IWorkWithFile {

    public WorkWithCSV() { }

    @Override
    public List<Anime> read(String filePath) throws FileNotFoundException {
        final List<Anime> animeList = new ArrayList<>();

        String line;
        try (final BufferedReader br = new BufferedReader(
                new FileReader(filePath))) {
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                String[] split = line.split(";");

                final String name = split[0];
                final double rating = Double.parseDouble(split[1]);
                final int views = Integer.parseInt(split[2]);
                final AgeLimits ageLimit = AgeLimits.valueOf(split[3]);
                final String description = split[4];
                final Tag tag = Tag.valueOf(split[5]);
                final String animeType = split[6];

                if (animeType.equals("adventure")) {
                    final int amountOfLocations = Integer.parseInt(split[7]);
                    animeList.add(new AdventureAnime(name, new Statistics(views, rating), ageLimit, description, tag, amountOfLocations));
                } else if (animeType.equals("comedy")) {
                    final int amountOfJokes = Integer.parseInt(split[7]);
                    animeList.add(new AdventureAnime(name, new Statistics(views, rating), ageLimit, description, tag, amountOfJokes));
                } else if (animeType.equals("romantic")) {
                    final int amountOfGirlfriends = Integer.parseInt(split[7]);
                    animeList.add(new AdventureAnime(name, new Statistics(views, rating), ageLimit, description, tag, amountOfGirlfriends));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return animeList;
    }
}
