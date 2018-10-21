package client;

import contracts.IAdapter;
import contracts.IMediator;
import implementations.AdapterXML;
import implementations.Mediator;


public class client {
    public static void main(String[] args) throws Exception {

        String XMLfilePath = "assets/Univ_BD_3.xml";

        IMediator mediator = new Mediator();

        IAdapter adapterXML = new AdapterXML(XMLfilePath);
        IAdapter adapterSQL;
        IAdapter adapterExcel;

        mediator.attachAdapter(adapterXML);

        System.out.println(mediator.query1());
        System.out.println(mediator.query2());
        System.out.println(mediator.query3());

    }
}