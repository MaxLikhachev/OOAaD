package com.mycompany.app;

public class Passenger implements Component{

    String name;
    BusStop busStop;

    public Passenger(String name, BusStop busStop) {
        this.busStop = busStop;
        this.name = name;

        //this.render();
    }
 
    public BusStop getBusStop() {
        return this.busStop;
    }

    @Override
    public void render() {
        System.out.println(this.toString()); 
    }

	public void leaveBus(Bus bus) {
        this.renderMessage("leaved bus " + bus);
        bus.removePassenger(this);
	}

	public boolean goToBus(Bus bus) {
        this.renderMessage("went to bus " + bus);
        return bus.addPassenger(this);
	}

    @Override
    public void renderMessage(String message) {
        System.out.println(this.toString() + message);
    }

    public String toString() {
        return "Passenger \"" + this.name + "\" -> " + this.busStop + ": ";
    }

}
