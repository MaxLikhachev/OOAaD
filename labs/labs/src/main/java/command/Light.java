package command;

public class Light {
    private String location, state;

    public Light(String location) {
        this.location = location;
        this.state = "Light is off";   
    }
    
    public void on() {
        this.state = "Light is on";      
    }   
    
    public void off() {
        this.state = "Light is off";  
    }

    public String toString() {
        return this.location + " " + this.state;
    }
}