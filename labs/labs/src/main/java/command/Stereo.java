package command;

public class Stereo {
    private String location, state;
    
    public Stereo(String location) {
        this.location = location;
    }
    
    public void on() {
        this.state = "on";   
    }
    
    public void off() {
        this.state = "off";   
    }
    
    public void setSD() {
        this.state = "set for CD input";   
    }

    public void setDVD() {
        this.state = "set for DVD input";   
    }
    
    public void setRadio() {
        this.state = "set";   
    }
    
    public void setVolume(int volume){
        System.out.println(location + " stereo volume set to " + volume);

        this.state = "set to " + volume;   
    }

    public String toString() {
        return this.location + "Radio is " + this.state;
    }
}