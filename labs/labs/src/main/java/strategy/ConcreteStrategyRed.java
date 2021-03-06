package strategy;

public class ConcreteStrategyRed implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void execute(final String text) {
        System.out.println(ANSI_RED + text + ANSI_RESET);
    }
}
