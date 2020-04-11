package com.mycompany.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class App {

    static int maxPassengersonBusStop = 5;

    private static void init(ArrayList<BusStop> busStops, Bus bus) {
        initBusStops(busStops);
        initBus(bus);

        setBuses(busStops, bus);
    }

    private static void setBuses(ArrayList<BusStop> busStops, Bus bus) {
        busStops.get(0).setBus(bus);
    }   

    private static void initBus(Bus bus) {
        bus = new Bus("1", 50);
    }

    private static void initBusStops(ArrayList<BusStop> busStops) {
        for (char c = 'A'; c <= 'Z'; c++)
            busStops.add(new BusStop("" + c));
    }

    private static BusStop getRandomBusStop(ArrayList<BusStop> busStops) {
        return busStops.get(new Random().nextInt(busStops.size()));
    }

    private static void step(BusStop busStop, ArrayList<BusStop> busStops, RouteIterator routeIterator) {
        System.out.println("\n\n\n---------------------------------------------------NEW STEP---------------------------------------------------");
        System.out.println("\n---------------------------------------------------GENERATION NEW PASSENGERS---------------------------------------------------");
        generateRandomPassengers(busStop, busStops);
        System.out.println("\n---------------------------------------------------DROPPING OFF PASSENGERS---------------------------------------------------");
        dropOffPassengers(busStop);
        System.out.println("\n---------------------------------------------------PICKING UP PASSENGERS---------------------------------------------------");
        pickUpPassengers(busStop, busStops, routeIterator);
    }

    private static void dropOffPassengers(BusStop busStop) {
        if (busStop.getBus().isAnyPassengerReached(busStop)) {
            busStop.addPassengers(busStop.getBus().dropOffPassengers(busStop));
        }
    }

    private static void pickUpPassengers(BusStop busStop, ArrayList<BusStop> busStops, RouteIterator routeIterator) {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for (Passenger passenger : busStop.getPassengers()) {
            if (routeIterator.searchElement(passenger.getBusStop()) && passenger.goToBus(busStop.getBus())) {
                passengers.add(passenger);
            }
        }

        for (Passenger passenger : passengers) {
            busStop.removePassenger(passenger);
        }
    }

    private static void generateRandomPassengers(BusStop busStop, ArrayList<BusStop> busStops) {
        Random random = new Random();

        for (int i = busStop.getSizeOfPassengers(); i < random.nextInt(maxPassengersonBusStop); i++) {
            busStop.addPassenger(new Passenger("" + new Timestamp(System.currentTimeMillis()), getRandomBusStop(busStops)));
        }
    }

    public static void main(final String[] args) {

        ArrayList<BusStop> busStops = new ArrayList<>();

        Bus bus = new Bus();

        init(busStops, bus);
        RouteConcreteCollection routeConcreteCollection = new RouteConcreteCollection(busStops);
        RouteIterator routeIterator = routeConcreteCollection.createIterator();

        step(busStops.get(0), busStops, routeIterator);

        while (true) {
            step(routeIterator.getNext(), busStops, routeIterator);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
