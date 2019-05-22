package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.util.ArrayList;

public class CreateDB implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public CreateDB (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {

    }
}
