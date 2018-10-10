package client;

import contracts.IMediator;
import implementations.Mediator;


public class client {
    public static void main(String[] args){
        IMediator mediator = new Mediator();
        mediator.query("SELECT * FROM Cours");
    }
}