package strategy;

import java.util.Scanner;
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
