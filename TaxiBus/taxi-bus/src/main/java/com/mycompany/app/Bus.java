package com.mycompany.app;

import java.util.ArrayList;

public class Bus implements Component, PassengerController {

    String name;
    int size;
    ArrayList<Passenger> passengers = new ArrayList<>();

    public Bus(String name, int size) {
        this.name = name;
        this.size = size;

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
        return  !this.passengers.isEmpty();
    }

    @Override
    public boolean isAnyPassengerReached(BusStop busStop) {
        boolean isReached = false;
        for (Passenger passenger : this.passengers) {
            if (passenger.getBusStop() == busStop) {
                this.dropOffPassenger(passenger);
                isReached = !isReached;
            }
        }
        return isReached;
    }

    public void pickUpPassenger(Passenger passenger) {
        passenger.goToBus(this);
        this.addPassenger(passenger);
    }

    private void dropOffPassenger(Passenger passenger) { 
        passenger.leaveBus(this);
        passengers.remove(passenger);
    }

    public String toString() {
        return "Bus \"" + this.name + "\" [" + this.passengers.size() + "/" + this.size + "]: ";
    }

    @Override
    public void renderMessage(String message) {
        System.out.println(this.toString() + message);
    }

    @Override
    public int getIndex(Passenger passenger) {
        return this.passengers.indexOf(passenger);
    }
}
