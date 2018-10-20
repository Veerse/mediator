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

    String filePath;

    public AdapterXML (String pathFile) {
        this.filePath = pathFile;
    }

    public void lire_XML () throws FileNotFoundException, SAXException,
            IOException, ParserConfigurationException{

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        org.w3c.dom.Document doc = builderFactory.newDocumentBuilder().parse(new FileInputStream(this.filePath));

        NodeList nodeList = doc.getElementsByTagName("*");
        NodeList tmp;
        System.out.println(nodeList.getLength());

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // do something with the current element
                if(node.getNodeName() == "Enseignant") {
                    System.out.println(node.getChildNodes().item(2).getTextContent());
                    if(node.getChildNodes().item(5).hasChildNodes()){
                        System.out.println(node.getChildNodes().item(5).getChildNodes().item(0).getChildNodes().item(0).getTextContent());
                    }
                }
            }
        }
    }

    @Override
    public HashMap<String, Integer> query1() throws FileNotFoundException, SAXException,
            IOException, ParserConfigurationException{
        this.lire_XML();
        return null;
    }

    @Override
    public Integer query2() {
        return null;
    }

    @Override
    public HashMap<String, Integer> query3() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
