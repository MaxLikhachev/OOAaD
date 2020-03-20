package facade;

public class DvdPlayer {

	public void on() {
        System.out.println("DVD player is on");
	}

	public void play(String movie) {
        System.out.println("DVD player is playing movie :" + movie);
	}

	public void stop() {
        System.out.println("DVD player is stopped");
	}

	public void eject() {
        System.out.println("DVD player is ejected");
	}

	public void off() {
        System.out.println("DVD player is off");
	}
}
