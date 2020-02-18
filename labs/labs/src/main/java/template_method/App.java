package template_method;

import java.util.ArrayList;
import java.util.Scanner;

public final class App {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        AggressiveCannibal ogre = new AggressiveCannibal("Shrek", new ArrayList<>());
        Human fiona = new Human("Fiona", "female");
        ogre.hunt(fiona);

        Cannibal cannibal = null;

        System.out.println("Select type of cannibal:\n1\tAggressive\n2\tIntelligent");
        int type = in.nextInt();

        switch (type) {
        case 1: {
            System.out.println("Select name of aggressive cannibal:");
            cannibal = new AggressiveCannibal(in.nextLine(), new ArrayList<>());
        }
            break;
        case 2: {
            System.out.println("Select name of intelligent cannibal:");
            cannibal = new IntelligentCannibal(in.nextLine(), new ArrayList<>());
        }
            break;
        default:
            System.out.println("ERROR! Incorrect type!");
            break;
        }

        System.out.println("Enter name & sex of new human:");
        Human human = new Human(in.nextLine(),in.nextLine());
        cannibal.act(human);
        in.close();
    }
}