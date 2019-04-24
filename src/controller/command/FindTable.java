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
        if (!command.get(0).equals("find") || command.size() != 2) {
            console.outputln("Incorrect command format, please type \"help\" for help");
            return false;
        }
        else {return true;}
    }

    @Override
    public void execute(ArrayList<String> command) {
        dataBase.findTable(command.get(1));

    }
}
