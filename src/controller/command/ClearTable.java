package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

import java.util.ArrayList;

public class ClearTable implements Command {
    private DataBaseInterface dataBase;
    private String tableName;
    private View console;
    public ClearTable(DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        this.dataBase.clearTable(this.tableName);
    }
}
