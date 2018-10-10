package contracts;

import java.util.ArrayList;

public interface IAdapter {

    public void connexion();
    public void deconnexion();
    public ArrayList<String> query();
    
}
