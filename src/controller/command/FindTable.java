package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

public class FindTable implements Command {
    private DataBaseInterface dataBase;
    private View console;
    private String tableName;

    public FindTable (DataBaseInterface dataBase, View console) {
        this.console = console;
        this.dataBase = dataBase;
    }

    @Override
    public boolean ifExecutable() {
        return false;
    }

    @Override
    public void execute() {
        dataBase.findTable(this.tableName);
    }
}
