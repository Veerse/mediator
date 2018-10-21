package implementations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import contracts.IAdapter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AdapterXML implements IAdapter {

    private String filePath;
    private org.w3c.dom.Document doc;

    public AdapterXML(String pathFile) throws FileNotFoundException, SAXException,
            IOException, ParserConfigurationException{

        this.filePath = pathFile;

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        doc = builderFactory.newDocumentBuilder().parse(new FileInputStream(this.filePath));
    }


    @Override
    public HashMap<String, Integer> query1()  {

        HashMap <String, Integer> query1 = new HashMap<>();
        NodeList nodeList = this.doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName().equals("Enseignant")) {

                    // item 5 is enseignements. If a teachent doesn't have enseignements, we cannot proceed...
                    if (node.getChildNodes().item(5).hasChildNodes()) {
                        for (int j = 0; j < node.getChildNodes().item(5).getChildNodes().getLength(); j++) {

                            // RETRIEVING TEACHER AND HOURS FOR EACH COURSE
                            String teacher = node.getChildNodes().item(2).getTextContent();
                            Integer hours = Integer.parseInt(node.getChildNodes().item(5).getChildNodes()
                                    .item(j).getChildNodes() // j here because we're at "enseigne" node (use method item(j).getNodeName();)
                                    .item(0).getChildNodes()
                                    .item(0).getTextContent());

                            // PUTTING IT TO THE HASH MAP
                            if(query1.containsKey(teacher))
                                query1.put(teacher, query1.get(teacher) + hours);
                            else
                                query1.put(teacher, hours);

                        }
                    }

                }
            }
        }
        return query1;
    }

    @Override
    public Integer query2() {
        Integer query2 = 0;
        NodeList nodeList = this.doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName().equals("Etudiant")) {
                    if(node.getChildNodes().item(3).getTextContent().toLowerCase().equals("france"))
                        query2++;
                }
            }
        }
        return query2;
    }

    @Override
    public HashMap<String, Integer> query3() {
        HashMap <String, Integer> query3 = new HashMap<>();
        NodeList nodeList = this.doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName().equals("Cours")) {

                    // RETRIEVING COURSE TYPE
                    String courseType = node.getChildNodes().item(3).getTextContent();

                    // PUTTING IT TO THE HASH MAP OR IF EXISTS INCREMENTS
                    if(query3.containsKey(courseType))
                        query3.put(courseType, query3.get(courseType) + 1);
                    else
                        query3.put(courseType, 1);
                }
            }
        }
        return query3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
