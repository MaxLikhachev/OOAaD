package com.mycompany.app;

public class Passenger implements Component{

    String name;
    BusStop busStop;

    public Passenger(BusStop busStop) {
        this.busStop = busStop;
        //TODO Passenger name generator
        this.name = "";

        this.render();
    }
 
    public BusStop getBusStop() {
        return this.busStop;
    }

    @Override
    public void render() {
        System.out.println(this.toString()); 
    }

	public void leaveBus(Bus bus) {
	}

	public void goToBus(Bus bus) {
	}

    @Override
    public void renderMessage(String message) {
        System.out.println(this.toString() + message);
    }
    
    public String toString() {
        return "Passenger \"" + this.name + "\" -> " + this.busStop + ": ";
    }

}
