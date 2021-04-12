package com.company.util;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithCSV<T> implements IWorkWithFile<T> {

    public WorkWithCSV() { }

    @Override
    public List<? super Anime> read(final String filePath) throws FileNotFoundException {
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

    @Override
    public void write(final String filepath, final List<? super Anime> animeList) throws IOException {
        FileWriter csvWriter = new FileWriter(filepath);
        csvWriter.append("name;rating;views;age-limit;description;tag;anime-type;amount");
        csvWriter.append("\n");

        for (int i = 0; i<animeList.size(); i++) {
            String rowData = ((Anime)animeList.get(i)).getName()+";"
                    +String.valueOf(((Anime)animeList.get(i)).getStatistics().getRating()+ ";"
                    +String.valueOf((((Anime) animeList.get(i)).getStatistics().getViews()))) + ";"
                    +String.valueOf(((Anime)animeList.get(i)).getLimit())+ ";"
                    +((Anime)animeList.get(i)).getDescription() + ";"
                    +((Anime)animeList.get(i)).getTag() + ";";
            if ((animeList.get(i)).getClass().toString().equals("class com.company.model.AdventureAnime")) {
                rowData += "adventure;";
                rowData += ((AdventureAnime)animeList.get(i)).getAmountOfLocations();
            } else if (animeList.get(i).getClass().toString().equals("class com.company.model.ComedyAnime")) {
                rowData+="comedy;";
                rowData += ((ComedyAnime)animeList.get(i)).getAmountOfJokes();
            } else if (animeList.get(i).getClass().toString().equals("class com.company.model.RomanticAnime")) {
                rowData+= "romantic;";
                rowData+= ((RomanticAnime)animeList.get(i)).getAmountOfGirlfriends();
            }

            csvWriter.append(rowData);
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
