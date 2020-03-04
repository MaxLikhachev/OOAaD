package template_method;

import java.util.ArrayList;
import java.util.Scanner;

public final class App {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final AggressiveCannibal ogre = new AggressiveCannibal("Shrek", new ArrayList<>());
        final Human fiona = new Human("Fiona", "female");
        ogre.hunt(fiona);

        Cannibal cannibal = null;

        System.out.println("Select type of cannibal:\n1\tAggressive\n2\tIntelligent");
        
        switch (in.nextInt()) {
            case 1: {
                in.nextLine();
                System.out.println("Select name of aggressive cannibal:");
                cannibal = new AggressiveCannibal(in.nextLine());
            }
                break;
            case 2: {
                in.nextLine();
                System.out.println("Select name of intelligent cannibal:");
                cannibal = new IntelligentCannibal(in.nextLine());
            }
                break;
            default:
                System.out.println("ERROR! Incorrect type!");
                break;
        }

        System.out.println("Enter name & sex of new human:");
        final Human human = new Human(in.nextLine(), in.nextLine());
        cannibal.act(human);
        in.close();
    }
}