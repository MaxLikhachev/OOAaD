package command;

public class Light {
    private String location, state;

    public Light(String location) {
        this.location = location;
        this.state = "off";   
    }
    
    public void on() {
        this.state = "on";      
    }   
    
    public void off() {
        this.state = "off";  
    }

    public String toString() {
        return this.location + " Light is " + this.state;
    }
}