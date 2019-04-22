package controller.command;

import controller.Command;

public class Exit implements Command {
    @Override
    public boolean ifExecutable() {
        return false;
    }

    @Override
    public void execute() {

    }
}
