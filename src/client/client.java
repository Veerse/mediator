package client;

import contracts.IAdapter;
import contracts.IMediator;
import implementations.AdapterExcel;
import implementations.AdapterSQL;
import implementations.AdapterXML;
import implementations.Mediator;


public class client {
    public static void main(String[] args) throws Exception {

        String XMLfilePath = "assets/Univ_BD_3.xml";
        String ExcelfilePath = "assets/Source1.xls";

        IMediator mediator = new Mediator();

        IAdapter adapterXML = new AdapterXML(XMLfilePath);
        IAdapter adapterSQL = new AdapterSQL();
        IAdapter adapterExcel = new AdapterExcel(ExcelfilePath);

        mediator.attachAdapter(adapterXML);
        mediator.attachAdapter(adapterSQL);
        mediator.attachAdapter(adapterExcel);

        System.out.println(mediator.query1());
        System.out.println(mediator.query2());
        System.out.println(mediator.query3());


    }
}