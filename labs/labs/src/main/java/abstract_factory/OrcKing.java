package abstract_factory;

public class OrcKing implements King {

    String name;

    public OrcKing(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("ORC KING (" + this.name + "): Attack!");
    }

    @Override
    public void defend() {
        System.out.println("ORC KING (" + this.name + "): Defend!");
    }

    @Override
    public void throwUp() {
        System.out.println("ORC KING (" + this.name + "): Throw up!");
    }
    
}