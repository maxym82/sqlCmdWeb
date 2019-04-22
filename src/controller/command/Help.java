package controller.command;

import controller.Command;

public class Help implements Command {
    @Override
    public boolean ifExecutable() {
        return false;
    }

    @Override
    public void execute() {

    }
}
