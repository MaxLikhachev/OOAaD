package com.mycompany.app;

public class RouteConcreteIterator implements RouteIterator{
    RouteConcreteCollection routeConcreteCollection;
    int iterationState = 0;
    int distance = 1;

    public RouteConcreteIterator(RouteConcreteCollection routeConcreteCollection) {
        this.routeConcreteCollection = routeConcreteCollection;
    }

    @Override
    public BusStop getNext() {
        Bus bus = this.routeConcreteCollection.getBus(this.iterationState);
        this.routeConcreteCollection.removeBus(this.iterationState);
        
        this.distance = this.iterationState == 0 ? 1 : this.distance;
        this.distance = this.iterationState == this.routeConcreteCollection.getBusStops().size() - 1 ? -1 : this.distance;

        this.iterationState += this.distance;

        this.routeConcreteCollection.getBusStops().get(this.iterationState).setBus(bus);

        return this.routeConcreteCollection.getBusStops().get(this.iterationState);
    }
    
    @Override
    public boolean searchElement(BusStop busStop){
        int iterationState = this.iterationState;

        for (int i = this.distance > 0 ? 0 : iterationState; i < (this.distance > 0 ? this.routeConcreteCollection.getSize() : 0); i += this.distance)
            if (busStop == this.routeConcreteCollection.getBusStop(i)) return true;

        this.iterationState = iterationState;

        return false;
    }
}