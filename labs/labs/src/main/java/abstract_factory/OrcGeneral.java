package abstract_factory;

public class OrcGeneral implements General {

    int index;

    public OrcGeneral(int index) {
        this.index = index;
	}

	@Override
    public void attack() {
        System.out.println("ORC GENERAL [" + this.index + "]: Attack!");
    }

    @Override
    public void defend() {
        System.out.println("ORC GENERAL [" + this.index + "]: Defend!");
    }

    @Override
    public void throwUp() {
        System.out.println("ORC GENERAL [" + this.index + "]: Throw up!");
    }

}