package implementations;

import contracts.IAdapter;
import jdk.internal.org.xml.sax.SAXException;
import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AdapterExcel implements IAdapter {
    public static final int COL_ID = 0;
    public static final int COL_NOM = 1;
    public static final int COL_PRENOM = 2;
    public static final int COL_STATUT = 3;
    public static final int COL_PROVENANCE = 4;
    public static final int COL_FRMPRE = 5;
    public static final int COL_NIVINSERT = 6;
    public static final int COL_ID_COURS = 7;
    public static final int COL_LIBLCOURS = 8;
    public static final int COL_TYPECOURS = 9;
    public static final int COL_NIVCOURS = 10;
    public static final int COL_NOTE = 11;
    private Workbook workbook;


    public AdapterExcel(String pathFile) throws FileNotFoundException, SAXException,
            IOException, ParserConfigurationException, BiffException {

        this.workbook = Workbook.getWorkbook(new File("assets/Source1.xls"));

    }
    public HashMap<String, Integer> query1() {
        Cell[] Provenance;
        Cell[] id;
        Cell[] statut;
        HashMap <String, Integer> query1 = new HashMap<>();
        for (int i = 1; i < this.workbook.getNumberOfSheets(); i++) {
            Provenance = workbook.getSheet(i - 1).getColumn(COL_PROVENANCE);
            id = workbook.getSheet(i - 1).getColumn(COL_ID);
            statut = workbook.getSheet(i - 1).getColumn(COL_STATUT);

            for (int j = 0; j < Provenance.length; j++) {
                if (statut[j].getContents().equalsIgnoreCase("etudiant")
                        && !Provenance[j].getContents().equalsIgnoreCase("france")
                        && !query1.containsKey(id[j].getContents()))
                    query1.put(Provenance[j].getContents(), Integer.parseInt(id[j].getContents()));
            }
        }

        return query1;
    }

    @Override
    public HashMap<String, ArrayList<Integer>> query2() {
        Cell[] id;
        Cell[] statut;
        Cell[] provenance;
        HashMap<String, ArrayList<Integer>> temp = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < this.workbook.getNumberOfSheets(); i++) {
            id = workbook.getSheet(i).getColumn(COL_ID);
            statut = workbook.getSheet(i).getColumn(COL_STATUT);
            provenance = workbook.getSheet(i).getColumn(COL_PROVENANCE);

            for (int j = 1; j < provenance.length; j++) {
                ArrayList<Integer> temp2 = new ArrayList<Integer>();
                if (statut[j].getContents().equalsIgnoreCase("etudiant")) {
                    if (!temp.containsKey(provenance[j].getContents())) {
                        temp2.add(Integer.parseInt(id[j].getContents()));
                        temp.put(provenance[j].getContents(), temp2);
                    } else {
                        if (!temp.get(provenance[j].getContents()).contains(Integer.parseInt(id[j].getContents())))
                            temp.get(provenance[j].getContents()).add(Integer.parseInt(id[j].getContents()));
                    }
                }
            }
        }

        int taille = 0;
        String prov = "";

        for (int i = 0, j = 1; j < temp.size(); j++) {
            String key = (String) temp.keySet().toArray()[i];
            String key2 = (String) temp.keySet().toArray()[j];
            if (temp.get(key).size() > temp.get(key2).size()) {
                taille = temp.get(key).size();
                prov = key;
            } else {
                taille = temp.get(key2).size();
                prov = key2;
            }
        }



        return temp;

    }




    public HashMap<String, Integer> query3() {
        return null;
    }
}
