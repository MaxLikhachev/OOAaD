package template_method;

import java.util.ArrayList;

public class AggressiveCannibal extends Cannibal {
    AggressiveCannibal(String name, ArrayList<Human> preys){
        this.name = name;
        this.preys = preys;
    }

    AggressiveCannibal(String name) {
        this.name = name;
        this.preys = new ArrayList<Human>();
    }

    public void cook(Human human) {
        System.out.println("Boiled human: " + human.toString());
    }

    @Override
    public void talk(Human human) {
        System.out.println("Not talking with human: " + human.toString());
    }
}