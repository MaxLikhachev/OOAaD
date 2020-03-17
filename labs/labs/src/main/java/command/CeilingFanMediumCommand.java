package command;

public class CeilingFanMediumCommand implements Command {
    
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan){        
        this.ceilingFan = ceilingFan;    
    }    
    
    public void execute(){        
        prevSpeed = ceilingFan.getSpeed();        
        ceilingFan.medium();    
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