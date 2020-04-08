package com.mycompany.app;

import java.util.ArrayList;

public class RouteConcreteIterator implements RouteIterator{
    RouteConcreteCollection routeConcreteCollection;
    ArrayList<BusStop> busStops = new ArrayList<>();
    int iterationState = 0;
    int distance = 1;

    public RouteConcreteIterator(RouteConcreteCollection routeConcreteCollection) {
        this.routeConcreteCollection = routeConcreteCollection;
    }

    @Override
    public BusStop getNext() {
        
        this.distance = this.iterationState == 0 ? 1 : this.distance;
        this.distance = this.iterationState == this.busStops.size() - 1 ? -1 : this.distance;

        this.iterationState += this.distance;

        return this.busStops.get(this.iterationState);
    }
    
}