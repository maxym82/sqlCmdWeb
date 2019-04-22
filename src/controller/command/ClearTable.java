package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

public class ClearTable implements Command {
    private DataBaseInterface dataBase;
    private String tableName;
    private View console;
    public ClearTable(DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }
    @Override
    public void execute() {
        this.dataBase.clearTable(this.tableName);
    }
}
