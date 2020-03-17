package command;

public class Light {

    
    public static final int ON = 1;
    public static final int OFF = 0;

    private String location, status;
    int state;

    public Light(String location) {
        this.location = location;
        this.off();   
    }
    
    public void on() {
        this.state = ON;
        this.status = "Light is on";

        System.out.println(this.toString());        
    }   
    
    public void off() {
        this.state = OFF;
        this.status = "Light is off";

        System.out.println(this.toString());  
    }

    public String toString() {
        return this.location + " " + this.status;
    }
}