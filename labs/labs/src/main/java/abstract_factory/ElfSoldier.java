package abstract_factory;

public class ElfSoldier implements Soldier {

    private int index;

    public ElfSoldier(int index) {
        this.index = index;
	}

	@Override
    public void attack() {
        System.out.println("Elf soldier [" + this.index + "] attacked");
    }

    @Override
    public void defend() {
        System.out.println("Elf soldier [" + this.index + "] defended");
    }

    @Override
    public void throwUp() {
        System.out.println("Elf soldier [" + this.index + "] throwed up");
    }
    
}