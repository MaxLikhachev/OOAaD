package com.mycompany.app;

import java.util.ArrayList;

public class BusStop implements Component, PassengerController, BusController {

    String name;
    Bus bus;
    ArrayList<Passenger> passengers = new ArrayList<>();

    public BusStop(String name) {
        this.name = name;

        this.render();
    }

    @Override
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);

    }

    @Override
    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);

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
        this.bus = null;
        this.renderMessage("leaved on bus: " + bus);
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

}
