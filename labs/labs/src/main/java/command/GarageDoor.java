package command;

public class GarageDoor {
    private String state;

    public void up() {
        this.state = "The door is up";
    }

    public void down() {
        this.state = "The door is down";
    }

    public void stop() {
        this.state = "The door is stopped";
    }

    public void lightOn() {
        this.state = "The light in garage is on";
    }
    
    public void lightOff() {
        this.state = "The light in garage is off";
    }

    public String toString() {
        return this.state;
    }
}