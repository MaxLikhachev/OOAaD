package strategy;

public class Context {

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

