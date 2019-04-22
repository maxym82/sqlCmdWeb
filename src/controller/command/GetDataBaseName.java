package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

public class GetDataBaseName implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public GetDataBaseName (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean ifExecutable() {
        return false;
    }

    @Override
    public void execute() {

    }
}
