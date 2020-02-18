package template_method;

import java.util.ArrayList;

public class IntelligentCannibal extends Cannibal {
    IntelligentCannibal(String name, ArrayList<Human> preys) {
        this.name = name;
        this.preys = preys;
    }

    public void cook(Human human) {
        System.out.println("Fried human: " + human.toString());
    }

    public void talk(Human human) {
        System.out.println("Talked to human: " + human.toString());
    }

    public void act(Human human) {
        this.hunt(human);
        this.talk(human);
        this.cook(human);
        this.eat(human);
        this.sleep();
    }
}