package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

import java.util.ArrayList;

public class GetDataBaseName implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public GetDataBaseName (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("pwd")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        console.outputln(this.dataBase.getDataBaseName());

    }
}
