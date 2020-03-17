package command;

public class CeilingFan {
   
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    
    private String location, status = "";
    int speed;

    public CeilingFan(String location){        
        this.location = location;    
        this.off();    
    }

    public void high(){        
        speed = HIGH;        
        this.status = location + " Ceiling fan is on high"; 
        System.out.println(this.toString());     
    }

    public void medium(){        
        speed = MEDIUM;        
        this.status = location + " Ceiling fan is on medium"; 
        System.out.println(this.toString());     
    }

    public void low(){        
        speed = LOW;        
        this.status = location + " Ceiling fan is on low"; 
        System.out.println(this.toString());     
    }

    public void off(){        
        speed = OFF;        
        this.status = location + " Ceiling fan is off";   
        System.out.println(this.toString());   
    }

    public int getSpeed(){        
        return speed;    
    }

    public String toString() {
        return this.location + " " + this.status;
    }
}