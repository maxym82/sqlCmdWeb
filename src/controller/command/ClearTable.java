package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
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
        if (command.get(0).equals("clear")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size()!= 2) {
            console.outputln("Incorrect format, please type \"help\" for help");
            return;
        }
        try {
            this.dataBase.clearTable(command.get(1));
        } catch (Exception e) {
            console.outputln(e.getMessage());
        }
    }
}
