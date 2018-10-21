package implementations;

import contracts.IAdapter;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class AdapterExcel implements IAdapter {

    private String filePath;
    private org.w3c.dom.Document doc;

    public AdapterExcel(String pathFile) throws FileNotFoundException, SAXException,
            IOException, ParserConfigurationException {

        this.filePath = pathFile;

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        doc = builderFactory.newDocumentBuilder().parse(new FileInputStream(this.filePath));
    }
    @Override
    public HashMap<String, Integer> query1() {
        return null;
    }

    @Override
    public Integer query2() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        return null;
    }

    @Override
    public HashMap<String, Integer> query3() throws SQLException {
        return null;
    }
}
