package facade;

public class TheaterLights {

	public void dim(int i) {
        System.out.println("Light is dimming to " + i + " %");
	}

	public void on() {
        System.out.println("Light is on");
	}
}
