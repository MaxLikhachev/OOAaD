package command;

public class Stereo {
    private String location;
    
    public Stereo(String location) {
        this.location = location;
    }
    
    public void on() {
        System.out.println(location + " Stereo is on");
    }
    
    public void off() {
        System.out.println(location + " Stereo is off");
    }
    
    public void setSD() {
        System.out.println(location + " stereo is set for CD input");
    }

    public void setDVD() {
        System.out.println(location + " stereo is set for DVD input");
    }
    
    public void setRadio() {
        System.out.println(location + " Radio is set");
    }
    
    public void setVolume(int volume){
        System.out.println(location + " stereo volume set to " + volume);
    }
}