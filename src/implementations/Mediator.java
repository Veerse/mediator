package implementations;

import java.util.ArrayList;
import java.util.HashMap;

import contracts.IAdapter;
import contracts.IMediator;

public class Mediator implements IMediator{
    
    ArrayList <IAdapter> adapters;

    public Mediator () {
        this.adapters = new ArrayList<>();
    }

    @Override
    public void attachAdapter(IAdapter adapter) {
        this.adapters.add(adapter);
        System.out.println("Adapter " + adapter.toString () + " attached");
    }

    @Override
    public HashMap<String, Integer> query1() throws Exception {
        HashMap<String, Integer> response = new HashMap<>();

        for (IAdapter tmp : this.adapters){
            response = tmp.query1();
        }

        return response;
    }

    @Override
    public Integer query2() {
        return null;
    }

    @Override
    public HashMap<String, Integer> query3() {
        return null;
    }
}