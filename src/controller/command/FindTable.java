package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

import java.util.ArrayList;

public class FindTable implements Command {
    private DataBaseInterface dataBase;
    private View console;
    private String tableName;

    public FindTable (DataBaseInterface dataBase, View console) {
        this.console = console;
        this.dataBase = dataBase;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        dataBase.findTable(this.tableName);
    }
}
