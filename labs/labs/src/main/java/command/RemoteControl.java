package command;

import java.util.ArrayList;

public class RemoteControl {
    ArrayList<Command> commands = new ArrayList<>();
    ArrayList<Integer> buffer = new ArrayList<>();

    int index = 0, prevIndex = 0;
    
    public void execute(Command command) {
        System.out.println("\nEXECUTE");
        
        this.addCommand(command);
        this.getCurrentCommand().execute();

        this.showCurrentState();
    }

    public void undo() {
        if (isPossibleUndo()) {
            System.out.println("\nUNDO");

            this.getCurrentCommand().undo();
            this.goToPrevState();

            this.showCurrentState();
        } else {
            System.out.println("\nTRYING UNDO");
        }
    }

    public void redo() {
        if (isPossibleRedo()) {
            System.out.println("\nREDO");

            this.goToNextState();
            this.getCurrentCommand().execute();

            this.showCurrentState();
        } else {
            System.out.println("\nTRYING REDO");
        }
    }

    private void addCommand(Command command) {
        this.prevIndex = this.index;
        this.index = this.commands.size();

        this.commands.add(command);
        this.buffer.add(this.prevIndex);
    }

    private Command getCurrentCommand() {
        return this.commands.get(this.index);
    }

    private void goToPrevState() {
        this.prevIndex = this.index;
        this.index = this.buffer.get(this.index);
    }

    private void goToNextState() {
        this.prevIndex = this.index;
        this.index = this.buffer.lastIndexOf(this.index) == -1 ? this.index : this.buffer.lastIndexOf(this.index);
    }

    private void showCurrentState() {
        System.out.println(this.index + " <- " + this.prevIndex + " : " + this.commands.get(this.buffer.get(this.index)));
    }

    public boolean isPossibleUndo() {
        return this.index == 0 && this.prevIndex == 0 ? false : true;
    }

    public boolean isPossibleRedo() {
        return this.index == this.buffer.size() - 1 ? false : true;
    }
}