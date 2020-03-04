package strategy;
 
public class ConcreteStrategyBlue implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public void execute(final String text) {
        System.out.println(ANSI_BLUE + text + ANSI_RESET);
    }
}

