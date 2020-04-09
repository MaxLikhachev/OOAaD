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

	public Bus getBus(int iterationState) {
		return this.busStops.get(iterationState).getBus();
    }
    
    public void removeBus(int iterationState) {
		this.busStops.get(iterationState).removeBus();
	}

	public int getSize() {
		return this.busStops.size();
	}

	public BusStop getBusStop(int iterationState) {
		return this.busStops.get(iterationState);
	}

}
