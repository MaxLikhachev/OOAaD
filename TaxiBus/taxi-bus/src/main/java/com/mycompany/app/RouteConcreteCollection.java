package com.mycompany.app;

public class RouteConcreteCollection implements RouteIterableCollection {

    @Override
    public RouteIterator createIterator() {
        return new RouteConcreteIterator(this);
    }

}
