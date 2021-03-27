package com.company.util;

import com.company.model.Anime;

import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class WorkWithXML implements IWorkWithFile {

    public WorkWithXML() {
    }

    @Override
    public void  /*List<Anime>*/ read(final String filePath) {
        try {
            File file = new File(filePath);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("anime");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println("Anime type: " + eElement.getElementsByTagName("anime-type").item(0).getTextContent());
                    System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    NodeList nodeListS = doc.getElementsByTagName("statistics");
                    for (int j = 0; j < nodeListS.getLength(); j++) {
                        Node nodeS = nodeListS.item(i);
                        System.out.println("\nNode Name :" + nodeS.getNodeName());
                        if (nodeS.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElementS = (Element) node;
                            System.out.println("Rating: " + eElementS.getElementsByTagName("rating").item(0).getTextContent());
                            System.out.println("Views: " + eElementS.getElementsByTagName("views").item(0).getTextContent());
                        }
                        System.out.println("Age limit: " + eElement.getElementsByTagName("age-limit").item(0).getTextContent());
                        System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
                        System.out.println("Tag: " + eElement.getElementsByTagName("tag").item(0).getTextContent());
                    }
                }
                //return  ;
            }
        }catch (Exception e){
            e.printStackTrace();
            //return  null;
        }
    }
}
