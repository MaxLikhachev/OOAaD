package com.mycompany.app;

import java.util.ArrayList;

public class Bus implements Component, PassengerController {

    String name;
    int size;
    ArrayList<Passenger> passengers = new ArrayList<>();

    public Bus(String name, int size) {
        this.name = name;
        this.size = size;

        //this.render();
    }

    public Bus() {
	}

	@Override
    public boolean addPassenger(Passenger passenger) {
        if (this.passengers.size() < this.size) {
            this.passengers.add(passenger);
            return true;
        } else return false;
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
                isReached = !isReached;
            }
        }
        return isReached;
    }

    public void pickUpPassenger(Passenger passenger) {
        passenger.goToBus(this);
        this.addPassenger(passenger);
    }

    public void dropOffPassenger(Passenger passenger) { 
        passenger.leaveBus(this);
        passengers.remove(passenger);
    }

    public ArrayList<Passenger> dropOffPassengers(BusStop busStop) {
        ArrayList<Passenger> passengers = new ArrayList<>();
 
        for (Passenger passenger : this.passengers) {
            if (passenger.getBusStop() == busStop) {
                passengers.add(passenger);
            }
        }

        for (Passenger passenger : passengers) {
            this.dropOffPassenger(passenger);
        }

        return passengers;
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
