package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

public class CloseConnection implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public CloseConnection (DataBaseInterface dataBase, View console) {
        this.console = console;
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        this.dataBase.closeConnection();

    }
}
