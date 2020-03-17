package command;

public class CeilingFanLowCommand implements Command {
    
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan){        
        this.ceilingFan = ceilingFan;    
    }    
    
    public void execute(){        
        prevSpeed = ceilingFan.getSpeed();        
        ceilingFan.low();    
    }

    public void undo(){        
        switch(prevSpeed) {
            case CeilingFan.HIGH: ceilingFan.high(); break;
            case CeilingFan.MEDIUM: ceilingFan.medium(); break;
            case CeilingFan.LOW: ceilingFan.low(); break;
            case CeilingFan.OFF: ceilingFan.off(); break;
        } 
    }
}