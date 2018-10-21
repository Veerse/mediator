package contracts;

import java.sql.SQLException;
import java.util.HashMap;

public interface IAdapter {
    HashMap<String, Integer> query1();
    Integer query2() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
    HashMap<String, Integer> query3() throws SQLException;
}
