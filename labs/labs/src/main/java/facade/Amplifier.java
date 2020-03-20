package facade;

public class Amplifier {

	public void setSurroundSound() {
        System.out.println("Amplifier surround sound");
	}

	public void setDvd(DvdPlayer dvd) {
        System.out.println("Amplifier setting DVD");
	}

	public void on() {
        System.out.println("Amplifier is on");
	}

	public void setVolume(int i) {
        System.out.println("Amplifier is setting volume to " + i + "%");
	}

	public void off() {
        System.out.println("Amplifier is off");
	}

}
