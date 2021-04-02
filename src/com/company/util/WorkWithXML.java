package com.company.util;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.AdventureAnime;
import com.company.model.Anime;

import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.company.model.Statistics;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class WorkWithXML implements IWorkWithFile {

    public WorkWithXML() {
    }

    @Override
    public List<Anime> read(final String filePath) throws FileNotFoundException {
        try {
            File file = new File(filePath);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            List<Anime> animeList = new ArrayList<>();

            NodeList nodeList = doc.getElementsByTagName("anime");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    final String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    NodeList nodeListS = doc.getElementsByTagName("statistics");
                    double rating = 0;
                    int views = 0;
                    for (int j = 0; j < nodeListS.getLength(); j++) {
                        Node nodeS = nodeListS.item(i);
                        if (nodeS.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElementS = (Element) node;
                            rating = Double.parseDouble(eElementS.getElementsByTagName("rating").item(0).getTextContent());
                            views = Integer.parseInt(eElementS.getElementsByTagName("views").item(0).getTextContent());
                        }

                    }
                    final AgeLimits ageLimits = AgeLimits.valueOf(eElement.getElementsByTagName("age-limit").item(0).getTextContent());
                    final String description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    final Tag tag = Tag.valueOf(eElement.getElementsByTagName("tag").item(0).getTextContent());
                    final String animeType = eElement.getElementsByTagName("anime-type").item(0).getTextContent();
                    if (animeType.equals("adventure")) {
                        final int amountOfLocations = Integer.parseInt(eElement.getElementsByTagName("amount-of-locations").item(0).getTextContent());
                        animeList.add(new AdventureAnime(name, new Statistics(views, rating), ageLimits, description, tag, amountOfLocations));
                    } else if (animeType.equals("comedy")) {
                        final int amountOfJokes = Integer.parseInt(eElement.getElementsByTagName("amount-of-jokes").item(0).getTextContent());
                        animeList.add(new AdventureAnime(name, new Statistics(views, rating), ageLimits, description, tag, amountOfJokes));
                    } else if (animeType.equals("romantic")) {
                        final int amountOfGirlfriends = Integer.parseInt(eElement.getElementsByTagName("amount-of-girlfriends").item(0).getTextContent());
                        animeList.add(new AdventureAnime(name, new Statistics(views, rating), ageLimits, description, tag, amountOfGirlfriends));
                    }
                }
            }
            return animeList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
