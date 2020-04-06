package abstract_factory;

public class OrcSoldier implements Soldier {

    private int index;

    public OrcSoldier(int index) {
        this.index = index;
	}

	@Override
    public void attack() {
        System.out.println("Orc soldier [" + this.index + "] attacked");
    }

    @Override
    public void defend() {
        System.out.println("Orc soldier [" + this.index + "] defended");
    }

    @Override
    public void throwUp() {
        System.out.println("Orc soldier [" + this.index + "] throwed up");
    }
    
}