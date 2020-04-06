package abstract_factory;

public class ElfGeneral implements General {

    int index;

    public ElfGeneral(int index) {
        this.index = index;
	}

	@Override
    public void attack() {
        System.out.println("ELF GENERAL [" + this.index + "]: Attack!");
    }

    @Override
    public void defend() {
        System.out.println("ELF GENERAL [" + this.index + "]: Defend!");
    }

    @Override
    public void throwUp() {
        System.out.println("ELF GENERAL [" + this.index + "]: Throw up!");
    }
    
}