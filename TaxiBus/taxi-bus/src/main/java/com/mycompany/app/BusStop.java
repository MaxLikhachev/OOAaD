package com.mycompany.app;

import java.util.ArrayList;

public class BusStop implements Component, PassengerController, BusController {

    String name;
    Bus bus;
    ArrayList<Passenger> passengers = new ArrayList<>();

    public BusStop(String name) {
        this.name = name;

        //this.render();
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
        this.renderMessage("appeared new passenger: " + passenger );
        return true;
    }

    @Override
    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
        this.renderMessage("leaved passenger: " + passenger );
    }

    @Override
    public void render() {
        System.out.println(this.toString());
    }

    @Override
    public boolean hasPassengers() {
        return !this.passengers.isEmpty();
    }

    @Override
    public void setBus(Bus bus) {
        this.bus = bus;
        this.renderMessage("reached bus: " + bus);
    }

    @Override
    public void removeBus() {
        this.renderMessage("leaved on bus: " + this.bus);
        this.bus = null;
    }

    @Override
    public boolean isAnyPassengerReached(BusStop busStop) {
        return this.bus.isAnyPassengerReached(this);
    }

    @Override
    public int getIndex(Passenger passenger) {
        return this.passengers.indexOf(passenger);
    }

    @Override
    public void renderMessage(String message) {
        System.out.println(this.toString() + message);
    }

    public String toString() {
        return "Bus stop \"" + this.name + "\" [" + this.passengers.size() + "]: ";
    }

    public int getSizeOfPassengers() {
        return this.passengers.size();
    }

	public Bus getBus() {
		return this.bus;
	}

	public ArrayList<Passenger> getPassengers() {
		return this.passengers;
	}

	public void addPassengers(ArrayList<Passenger> passengers) {
        for (Passenger passenger : passengers) {
            this.passengers.add(passenger);
        }
	}
}
