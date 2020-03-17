package command;

import java.util.ArrayList;

public class RemoteControl {
    ArrayList<BufferedCommand> commands = new ArrayList<>();
    int index = 0, prevIndex = 0;
    
    public void execute(Command command) {
        System.out.println("\nEXECUTE");
        
        this.addCommand(command);
        this.getCurrentCommand().execute();

        this.showCurrentState();
    }

    public void undo() {
        System.out.println("\nUNDO");

        this.getCurrentCommand().undo();
        this.goToPrevState();

        this.showCurrentState();
    }

    public void redo() {
        System.out.println("\nREDO");

        this.goToPrevState();
        this.getCurrentCommand().execute();

        this.showCurrentState();
    }

    private void addCommand(Command command) {
        this.prevIndex = this.index;
        this.index = this.commands.size();
        this.commands.add(new BufferedCommand(this.prevIndex, command));
    }

    private Command getCurrentCommand() {
        return this.commands.get(this.index);
    }

    private void goToPrevState() {
        this.prevIndex = this.index;
        this.index = this.commands.get(this.index).prevIndex;
    }

    private void goToNextState() {

        //this.prevIndex = this.index;
        //this.index = this.commands.get(this.prevIndex);
    }
/*
    private Command getPrevCommand() {
        return this.commands.get(this.commands.get(this.index).prevIndex);
    }

    private Command getNextCommand() {
        return this.commands.get(this.commands.get(this.index).prevIndex);
    }
*/
    private void showCurrentState() {
        System.out.println(this.index + " -> " + this.prevIndex + " : " + this.getCurrentCommand().toString());
    }
    class BufferedCommand implements Command{
        Command command;
        int prevIndex;

        public BufferedCommand(int prevIndex, Command command) {
            this.command = command;
            this.prevIndex = prevIndex;
        }

        public String toString() {
            return this.prevIndex + " . " + this.command;
        }

        public void execute() {
            this.command.execute();
        }

        public void undo() {
            this.command.undo();
        }
    }
}