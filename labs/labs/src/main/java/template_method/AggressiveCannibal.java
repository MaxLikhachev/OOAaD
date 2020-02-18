package template_method;

import java.util.ArrayList;

public class AggressiveCannibal extends Cannibal {
    AggressiveCannibal(String name, ArrayList<Human> preys){
        this.name = name;
        this.preys = preys;
    }

    public void cook(Human human) {
        System.out.println("Boiled human: " + human.toString());
    }

    public void act(Human human) {
        this.hunt(human);
        this.cook(human);
        this.eat(human);
        this.sleep();
    }
}