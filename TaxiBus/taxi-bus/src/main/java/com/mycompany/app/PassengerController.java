package com.mycompany.app;

public interface PassengerController {
    void addPassenger(Passenger passenger);
    void removePassenger(Passenger passenger);
    int getIndex(Passenger passenger);
    boolean hasPassengers();
    boolean isAnyPassengerReached(BusStop busStop);
}