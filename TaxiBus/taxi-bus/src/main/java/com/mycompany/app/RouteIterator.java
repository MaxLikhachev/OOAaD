package com.mycompany.app;

public interface RouteIterator {
    BusStop getNext();
    boolean searchElement(BusStop busStop);
}