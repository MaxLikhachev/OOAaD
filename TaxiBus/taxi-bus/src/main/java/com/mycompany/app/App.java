package com.mycompany.app;

public class App  {
    public static void main( final String[] args) {
        RouteConcreteCollection routeConcreteCollection;
        Bus bus = new Bus("1", 50);
        BusStop busStop = new BusStop("A");
        Passenger passenger = new Passenger(busStop);
    }
}
