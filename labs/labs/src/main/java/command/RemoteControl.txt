package command;

public class RemoteControl {
    Command [] onCommands;
    Command [] offcommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offcommands = new Command[7];
        Command noCommand = new NoCommand();
        
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offcommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }
        
    public void setCommand(int slot, Command onCommand, Command offCommmand) {
        onCommands[slot] = onCommand;
        offcommands[slot] = offCommmand;  
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];  
    }

    public void offButtonWasPushed(int slot) {
        offcommands[slot].execute();
        undoCommand = offcommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "   " + offcommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
    
}