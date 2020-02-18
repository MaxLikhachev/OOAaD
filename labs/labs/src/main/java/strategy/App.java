package strategy;

import java.util.Scanner;

interface Strategy {
    void execute(String text);
}

class ConcreteStrategyRed implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void execute(final String text) {
        System.out.println(ANSI_RED + text + ANSI_RESET);
    }
}

class ConcreteStrategyBlue implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public void execute(final String text) {
        System.out.println(ANSI_BLUE + text + ANSI_RESET);
    }
}

class ConcreteStrategyGreen implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void execute(final String text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }
}

class Context {

    private Strategy strategy;

    public Context() {
    }

    public void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String text) {
        strategy.execute(text);
    }
}

public final class App {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final Context context = new Context();

        System.out.println("Select color:\n\tred\n\tblue\n\tgreen");
        String color = in.nextLine();
        System.out.println("Choosed color: " + color);

        switch (color.toLowerCase()) {
        case "red":
            context.setStrategy(new ConcreteStrategyRed());
            break;
        case "blue":
            context.setStrategy(new ConcreteStrategyBlue());
            break;
        case "green":
            context.setStrategy(new ConcreteStrategyGreen());
            break;
        default:
            System.out.println("ERROR: Current color not exists");
            break;
        }

        System.out.println("Enter text:");
        String text = in.nextLine();
        context.executeStrategy(text);

        in.close();
    }
}
