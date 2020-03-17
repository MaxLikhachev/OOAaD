package command;

public class Stereo {
    private String location, state;
    
    public Stereo(String location) {
        this.location = location;
    }
    
    public void on() {
        this.state = "Stereo is on";   
    }
    
    public void off() {
        this.state = "Stereo is off";   
    }
    
    public void setSD() {
        this.state = "Stereo is set for CD input";   
    }

    public void setDVD() {
        this.state = "Stereo is set for DVD input";   
    }
    
    public void setRadio() {
        this.state = "Stereo is set";   
    }
    
    public void setVolume(int volume){
        this.state = "Stereo volume set to " + volume;   
    }

    public String toString() {
        return this.location + " " + this.state;
    }
}