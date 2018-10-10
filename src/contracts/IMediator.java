package contracts;

import java.util.ArrayList;

public interface IMediator {
    public ArrayList <String> query (String sqlRequest);
    public void attachAdapter (IAdapter adapter);
}