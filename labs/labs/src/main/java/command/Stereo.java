package command;

public class Stereo {

    public static final int ON = 1;
    public static final int OFF = 0;

    private String location, status;
    int state;

    public Stereo(String location) {
        this.location = location;
        this.off();
    }
    
    public void on() {
        this.status = "Stereo is on";
        this.state = ON;   
        System.out.println(this.toString());  
    }
    
    public void off() {
        this.status = "Stereo is off";  
        this.state = OFF; 
        System.out.println(this.toString());    
    }
    
    public void setSD() {
        this.status = "Stereo is set for CD input"; 
        System.out.println(this.toString());    
    }

    public void setDVD() {
        this.status = "Stereo is set for DVD input"; 
        System.out.println(this.toString());    
    }
    
    public void setRadio() {
        this.status = "Stereo is set";   
        System.out.println(this.toString());  
    }
    
    public void setVolume(int volume){
        this.status = "Stereo volume set to " + volume; 
        System.out.println(this.toString());    
    }

    public String toString() {
        return this.location + " " + this.status;
    }
}