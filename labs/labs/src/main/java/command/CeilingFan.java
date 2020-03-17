package command;

public class CeilingFan {
   
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private String location, state = "";
    int speed;

    public CeilingFan(String location){        
        this.location = location;    
        speed = OFF;    
    }

    public void high(){        
        speed = HIGH;        
        this.state = location + " Ceiling fan is on high";    
    }

    public void medium(){        
        speed = MEDIUM;        
        this.state = location + " Ceiling fan is on medium";    
    }

    public void low(){        
        speed = LOW;        
        this.state = location + " Ceiling fan is on low";    
    }

    public void off(){        
        speed = OFF;        
        this.state = location + " Ceiling fan is off";    
    }

    public int getSpeed(){        
        return speed;    
    }

    public String toString() {
        return this.location + " " + this.state;
    }
}