package command;

import java.util.ArrayList;

public class RemoteControl {
    ArrayList<Command> commands = new ArrayList<>();
    ArrayList<Integer> prevIndexes = new ArrayList<>();

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

        this.goToNextState();
        this.getCurrentCommand().execute();

        this.showCurrentState();
    }

    private void addCommand(Command command) {
        this.prevIndex = this.index;
        this.index = this.commands.size();

        this.commands.add(command);
        this.prevIndexes.add(this.prevIndex);
    }

    private Command getCurrentCommand() {
        return this.commands.get(this.index);
    }

    private void goToPrevState() {
        this.prevIndex = this.index;
        this.index = this.prevIndexes.get(this.index);
    }

    private void goToNextState() {
        this.prevIndex = this.prevIndex ^ this.index ^ ( this.index = this.prevIndex );
    }

    private void showCurrentState() {
        System.out.println(this.index + " <- " + this.prevIndex + " : " + this.commands.get(this.prevIndexes.get(this.index)));
    }
}