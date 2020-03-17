package command;

public interface Device {
    String status = "";
    int state = 0;

    public int getState();
    public String toString();
}