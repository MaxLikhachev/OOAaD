package command;

public class StereoOnWithCDCommand implements Command {
    
    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    
    public void execute() {
        stereo.on();
        stereo.setSD();
        stereo.setVolume(10);
    }

    public void undo() {
        stereo.off();
    }
}