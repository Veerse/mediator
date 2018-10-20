package contracts;

import java.util.ArrayList;
import java.util.HashMap;

public interface IMediator {
    void attachAdapter(IAdapter adapter);
    HashMap <String, Integer> query1 () throws Exception;
    Integer query2 ();
    HashMap <String, Integer> query3 ();
}