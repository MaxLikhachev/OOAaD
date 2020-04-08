package com.mycompany.app;

import java.util.ArrayList;

public class RouteConcreteCollection implements RouteIterableCollection {

    ArrayList<BusStop> busStops = new ArrayList<>();

    public RouteConcreteCollection(ArrayList<BusStop> busStops) {
        this.busStops = busStops;
    }

    public ArrayList<BusStop> getBusStops() {
        return this.busStops;
    }

    @Override
    public RouteIterator createIterator() {
        return new RouteConcreteIterator(this);
    }

}
