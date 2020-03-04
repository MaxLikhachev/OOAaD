package strategy;

public class ConcreteStrategyGreen implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void execute(final String text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }
}
