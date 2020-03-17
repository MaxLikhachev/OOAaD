package command;

public final class RemoteControlApp {
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        RemoteControlGUI app = new RemoteControlGUI();
		app.pack();
		app.setVisible(true);
    }
}
