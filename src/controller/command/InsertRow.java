package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.util.ArrayList;

public class InsertRow implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public InsertRow (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }


    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("insert")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size() < 2) {
            console.outputln("Incorrect command format, please type \"help\" for help");
        } else {
            try {
                if (dataBase.insertROW(command.get(1), new ArrayList<>(command.subList(2, command.size())))) {
                    console.outputln("Row was successfully inserted");
                }
            } catch (Exception e) {
                console.outputln("Something went wrong \n" + e.toString());
            }
        }

    }
}
