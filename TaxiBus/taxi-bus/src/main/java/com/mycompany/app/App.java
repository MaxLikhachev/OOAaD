package com.mycompany.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class App {

    static int maxPassengersonBusStop = 5;

    private static void init(ArrayList<BusStop> busStops, ArrayList<Bus> buses) {
        initBusStops(busStops);
        initBuses(buses);

        setBuses(busStops, buses);
    }

    private static void setBuses(ArrayList<BusStop> busStops, ArrayList<Bus> buses) {
        if (buses.size() > 0)
            busStops.get(0).setBus(buses.get(0));
        if (buses.size() > 1)
            busStops.get(busStops.size() - 1).setBus(buses.get(1));
    }

    private static void initBuses(ArrayList<Bus> buses) {
        buses.add(new Bus("1", 50));
        buses.add(new Bus("2", 30));
    }

    private static void initBusStops(ArrayList<BusStop> busStops) {
        for (char c = 'A'; c <= 'Z'; c++)
            busStops.add(new BusStop("" + c));
    }

    private static BusStop getRandomBusStop(ArrayList<BusStop> busStops) {
        return busStops.get(new Random().nextInt(busStops.size()));
    }

    private static void step(BusStop busStop, ArrayList<BusStop> busStops) {
        generateRandomPassengers(busStop, busStops);

        // TODO:
        //1. Moving bus on next bus stop
        //2. Search bus stop (in concrete iterator)
    }

    private static void generateRandomPassengers(BusStop busStop, ArrayList<BusStop> busStops) {
        Random random = new Random();

        for (int i = busStop.getSizeOfPassengers(); i < random.nextInt(maxPassengersonBusStop); i++) {
            busStop.addPassenger(new Passenger("" + new Timestamp(System.currentTimeMillis()), getRandomBusStop(busStops)));
        }
    }

    public static void main(final String[] args) {

        ArrayList<BusStop> busStops = new ArrayList<>();

        ArrayList<Bus> buses = new ArrayList<>();

        init(busStops, buses);
        RouteConcreteCollection routeConcreteCollection = new RouteConcreteCollection(busStops);
        RouteIterator routeIterator = routeConcreteCollection.createIterator();

        step(busStops.get(0), busStops);

        while (0 == 0) {
            step(routeIterator.getNext(), busStops);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
