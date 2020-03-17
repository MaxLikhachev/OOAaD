package command;

public class GarageDoor {

    public static final int UP = 1;
    public static final int DOWN = 0;

    private String status;
    int state;

    public GarageDoor() {
        this.down();
    }

    public void up() {
        this.status = "The door is up";
        this.state = UP;
        System.out.println(this.toString());  
    }

    public void down() {
        this.status = "The door is down";
        this.state = DOWN;
        System.out.println(this.toString());  
    }

    public void stop() {
        this.status = "The door is stopped";
        System.out.println(this.toString());  
    }

    public void lightOn() {
        this.status = "The light in garage is on";
        System.out.println(this.toString());  
    }
    
    public void lightOff() {
        this.status = "The light in garage is off";
        System.out.println(this.toString());  
    }

    public String toString() {
        return this.status;
    }
}