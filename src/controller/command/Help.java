package controller.command;

import controller.Command;

import java.util.ArrayList;

public class Help implements Command {
    @Override
    public boolean isExecutable(ArrayList<String> command) {
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {

    }
}
