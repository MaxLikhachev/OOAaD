package command;

public class CeilingFanOffCommand implements Command {
    
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan){        
        this.ceilingFan = ceilingFan;    
    }    
    
    public void execute(){        
        prevSpeed = ceilingFan.getSpeed();        
        ceilingFan.off();    
    }

    public void undo(){        
        switch(prevSpeed) {
            case CeilingFan.HIGH: ceilingFan.high();
            case CeilingFan.MEDIUM: ceilingFan.medium();
            case CeilingFan.LOW: ceilingFan.low();
            case CeilingFan.OFF: ceilingFan.off();
        }
    }
}