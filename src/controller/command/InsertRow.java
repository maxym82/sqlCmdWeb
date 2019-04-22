package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

public class InsertRow implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public InsertRow (DataBaseInterface dataBase, View console) {
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
