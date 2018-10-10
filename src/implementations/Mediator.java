package implementations;

import java.util.ArrayList;

import contracts.IAdapter;
import contracts.IMediator;

public class Mediator implements IMediator{
    
    ArrayList <IAdapter> adapters;

    public Mediator () {

    }

    public ArrayList <String> query (String sqlRequest){
        return null;
    }

    public void attachAdapter (IAdapter adapter){
        this.adapters.add(adapter);
    }

}