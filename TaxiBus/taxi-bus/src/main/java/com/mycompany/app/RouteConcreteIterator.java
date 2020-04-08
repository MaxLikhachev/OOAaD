package com.mycompany.app;

import java.util.ArrayList;

public class RouteConcreteIterator implements RouteIterator{
    RouteConcreteCollection routeConcreteCollection;
    int iterationState = 0;
    int distance = 1;

    public RouteConcreteIterator(RouteConcreteCollection routeConcreteCollection) {
        this.routeConcreteCollection = routeConcreteCollection;
    }

    @Override
    public BusStop getNext() {
        
        this.distance = this.iterationState == 0 ? 1 : this.distance;
        this.distance = this.iterationState == this.routeConcreteCollection.getBusStops().size() - 1 ? -1 : this.distance;

        this.iterationState += this.distance;

        return this.routeConcreteCollection.getBusStops().get(this.iterationState);
    }
    
}