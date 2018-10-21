package implementations;

import contracts.IAdapter;

import java.sql.*;
import java.util.HashMap;

public class AdapterSQL implements IAdapter {
    private static String URL = "jdbc:mysql://localhost:3306/mediator";
    private static String PARAMETER ="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String LOGIN = "root";
    private static String PASSWORD = "root";

    public Connection connexion() throws SQLException {
        return DriverManager.getConnection(URL+PARAMETER, LOGIN, PASSWORD);
    }

    @Override
    public HashMap<String, Integer> query1() {
        return null; //Pas de champs ou colonne dans la BDD permettant d'insérer le nombre de cours
}

    @Override
    public Integer query2() throws SQLException {
       String req = "select count(*) from etudiant where provenance = 'fr'";
        Statement stmt = connexion().createStatement();
        ResultSet RS = stmt.executeQuery(req);
        RS.next();
        return RS.getInt(1);
    }

    @Override
    public HashMap<String, Integer> query3() throws SQLException {
        HashMap <String, Integer> query3 = new HashMap<>();
        String req = "SELECT type, count(*) FROM `cours` group by type";
        Statement stmt = connexion().createStatement();
        ResultSet RS = stmt.executeQuery(req);

        while(RS.next()) {
            query3.put(RS.getString(1),RS.getInt(2));
        }
        return query3;
    }
}
