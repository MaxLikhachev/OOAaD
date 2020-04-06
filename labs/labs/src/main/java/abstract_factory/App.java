package abstract_factory;

public class App {
    public static void main(String[] args) {

        ElfArmy elfArmy = new ElfArmy("Legolas", 5, 200);
        OrcArmy orcArmy = new OrcArmy("Shrek", 6, 240);

        battle(elfArmy, orcArmy);
    }

    private static void battle(Army frstArmy, Army scndArmy) {
        frstArmy.attack();
        scndArmy.defend();

        if (frstArmy.getPower() > scndArmy.getPower()) {
            scndArmy.throwUp();
        } else if (scndArmy.getPower() > frstArmy.getPower()) {
            frstArmy.throwUp();
        } else {
            frstArmy.throwUp();
            scndArmy.throwUp();
        }
    }
}