package template_method;

public class Human {
    String name;
    String sex;

    public Human(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    
	public String toString(){
        return this.name + " (" + this.sex +")";
    }
}