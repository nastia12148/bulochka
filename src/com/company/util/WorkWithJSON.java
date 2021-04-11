package com.company.util;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Element;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkWithJSON<T> implements IWorkWithFile<T> {

    public WorkWithJSON() {
    }

    @Override
    public List<? super Anime> read(String filePath) throws FileNotFoundException {
        final List<Anime> animeList = new ArrayList<>();

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp, animeList ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  animeList;
    }

    private static void parseEmployeeObject(JSONObject anime, List animeList_)
    {

        JSONObject animeObject = (JSONObject) anime.get("anime");

        final String name = (String) animeObject.get("name");
        final double rating = Double.parseDouble((String) animeObject.get("rating"));
        final int views = Integer.parseInt((String) animeObject.get("views"));
        final AgeLimits ageLimit = AgeLimits.valueOf((String) animeObject.get("age-limit"));
        final String description = (String) animeObject.get("description");
        final Tag tag = Tag.valueOf((String) animeObject.get("tag"));
        final String animeType = (String) animeObject.get("anime-type");

        if (animeType.equals("adventure")) {
            final int amountOfLocations = Integer.parseInt((String) animeObject.get("amount"));
            animeList_.add(new AdventureAnime(name, new Statistics(views, rating), ageLimit, description, tag, amountOfLocations));
        } else if (animeType.equals("comedy")) {
            final int amountOfJokes = Integer.parseInt((String) animeObject.get("amount"));
            animeList_.add(new AdventureAnime(name, new Statistics(views, rating), ageLimit, description, tag, amountOfJokes));
        } else if (animeType.equals("romantic")) {
            final int amountOfGirlfriends = Integer.parseInt((String) animeObject.get("amount"));
            animeList_.add(new AdventureAnime(name, new Statistics(views, rating), ageLimit, description, tag, amountOfGirlfriends));
        }
    }

    @Override
    public void write(final String filepath, final List<? super Anime> animeList) throws FileNotFoundException {
        JSONArray animeList_ = new JSONArray();
        for(int i = 0; i<animeList.size();i++) {
            JSONObject animeDetails = new JSONObject();
            animeDetails.put("name", ((Anime)animeList.get(i)).getName());
            animeDetails.put("rating", (String.valueOf(((Anime) animeList.get(i)).getStatistics().getRating())));
            animeDetails.put("views", (String.valueOf(((Anime) animeList.get(i)).getStatistics().getViews())));
            animeDetails.put("age-limit", (String.valueOf(((Anime) animeList.get(i)).getTag())));
            animeDetails.put("description", ((Anime)animeList.get(i)).getDescription());
            animeDetails.put("tag", (String.valueOf(((Anime) animeList.get(i)).getTag())));
            animeDetails.put("anime-type", (animeList.get(i).getClass().toString()));

            if ((animeList.get(i)).getClass().toString().equals("class com.company.model.AdventureAnime")) {
                animeDetails.put("amount-of-locations",((AdventureAnime)animeList.get(i)).getAmountOfLocations());
            } else if (animeList.get(i).getClass().toString().equals("class com.company.model.ComedyAnime")) {
                animeDetails.put("amount-of-jokes",((ComedyAnime)animeList.get(i)).getAmountOfJokes());
            } else if (animeList.get(i).getClass().toString().equals("class com.company.model.RomanticAnime")) {
                animeDetails.put("amount-of-girlfriends",((RomanticAnime)animeList.get(i)).getAmountOfGirlfriends());
            }

            JSONObject anime = new JSONObject();
            anime.put("anime",animeDetails);

            animeList_.add(anime);
        }


        //Write JSON file
        try (FileWriter file = new FileWriter(filepath)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(animeList_.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


