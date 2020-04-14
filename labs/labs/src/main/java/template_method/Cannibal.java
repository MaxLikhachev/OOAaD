package template_method;

import java.util.ArrayList;

public abstract class Cannibal {

    String name;
    ArrayList<Human> preys;

    public void hunt(Human human) {
        this.preys.add(human);
        System.out.println("Hunted new human: " + human.toString());
    }

    abstract public void cook(Human human);

    public void eat(Human human) {
        this.preys.remove(human);
        System.out.println("Eated human: " + human.toString());
    }

    public void sleep() {
        System.out.println("Cannibal " + this.name + " go to sleep");
    }

    public void act(Human human) {
        this.hunt(human);
        this.cook(human);
        this.talk(human);
        this.eat(human);
        this.sleep();
    }

    public void talk(Human human) {};
}