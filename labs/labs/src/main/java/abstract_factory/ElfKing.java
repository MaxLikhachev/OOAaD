package abstract_factory;

public class ElfKing implements King {

    String name;

    public ElfKing(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("ELF KING (" + this.name + "): Attack!");
    }

    @Override
    public void defend() {
        System.out.println("ELF KING (" + this.name + "): Defend!");
    }

    @Override
    public void throwUp() {
        System.out.println("ELF KING (" + this.name + "): Throw up!");
    }
    
}