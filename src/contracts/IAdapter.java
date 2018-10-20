package contracts;

import java.util.HashMap;

public interface IAdapter {
    HashMap<String, Integer> query1 () throws Exception;
    Integer query2 ();
    HashMap <String, Integer> query3 ();
}
