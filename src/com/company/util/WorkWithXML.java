package com.company.util;

import com.company.enums.AgeLimits;
import com.company.enums.Tag;
import com.company.model.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class WorkWithXML implements IWorkWithFile {

    public WorkWithXML() { }

    @Override
    public List<? super Anime> read(final String filePath) throws FileNotFoundException {
        try {
            final File file = new File(filePath);

            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            final DocumentBuilder db = dbf.newDocumentBuilder();
            final Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            final List<Anime> animeList = new ArrayList<>();

            final NodeList nodeList = doc.getElementsByTagName("anime");

            for (int i = 0; i < nodeList.getLength(); i++) {
                final Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    final Element eElement = (Element) node;
                    final String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    final NodeList nodeListS = doc.getElementsByTagName("statistics");
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

    @Override
    public void write(final String filepath, final List<? extends Anime> animeList) throws FileNotFoundException {
        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("anime-list");
            doc.appendChild(root);

            for(int i=0; i<animeList.size(); i ++ ) {
                Element anime = doc.createElement("anime");
                root.appendChild(anime);

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(animeList.get(i).getName()));
                anime.appendChild(name);

                Element statistics = doc.createElement("statistics");
                anime.appendChild(statistics);

                Element rating = doc.createElement("rating");
                rating.appendChild(doc.createTextNode(String.valueOf(animeList.get(i).getStatistics().getRating())));
                statistics.appendChild(rating);

                Element views = doc.createElement("views");
                views.appendChild(doc.createTextNode(String.valueOf(animeList.get(i).getStatistics().getViews())));
                statistics.appendChild(views);

                Element ageLimit = doc.createElement("age-limit");
                ageLimit.appendChild(doc.createTextNode(String.valueOf(animeList.get(i).getLimit())));
                anime.appendChild(ageLimit);

                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(String.valueOf(animeList.get(i).getDescription())));
                anime.appendChild(description);

                Element tag = doc.createElement("tag");
                tag.appendChild(doc.createTextNode(String.valueOf(animeList.get(i).getTag())));
                anime.appendChild(tag);

                Element animeType = doc.createElement("anime-type");
                animeType.appendChild(doc.createTextNode(String.valueOf(animeList.get(i).getClass())));
                anime.appendChild(animeType);

                if (animeType.getTextContent().equals("class com.company.model.AdventureAnime")) {
                    final Element amountOfLocations = doc.createElement("amount-of-locations");
                    AdventureAnime adventureAnime = (AdventureAnime)animeList.get(i);
                    amountOfLocations.appendChild(doc.createTextNode(String.valueOf(adventureAnime.getAmountOfLocations())));
                    anime.appendChild(amountOfLocations);
                } else if (animeType.getTextContent().equals("class com.company.model.ComedyAnime")) {
                    final Element amountOfJokes = doc.createElement("amount-of-jokes");
                    ComedyAnime comedyAnime = (ComedyAnime) animeList.get(i);
                    amountOfJokes.appendChild(doc.createTextNode(String.valueOf(comedyAnime.getAmountOfJokes())));
                    anime.appendChild(amountOfJokes);
                } else if (animeType.getTextContent().equals("class com.company.model.RomanticAnime")) {
                    final Element amountOfGirlfriends = doc.createElement("amount-of-girlfriends");
                    RomanticAnime romanticAnime = (RomanticAnime) animeList.get(i);
                    amountOfGirlfriends.appendChild(doc.createTextNode(String.valueOf(romanticAnime.getAmountOfGirlfriends())));
                    anime.appendChild(amountOfGirlfriends);
                }

            }


            // Save the document to the disk file
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();

            // format the XML nicely
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

            aTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");



            DOMSource source = new DOMSource(doc);
            try {
                FileWriter fos = new FileWriter(filepath);
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);

            } catch (IOException e) {

                e.printStackTrace();
            }



        } catch (TransformerException ex) {
            System.out.println("Error outputting document");

        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
    }
}
