package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.InputOutput;

import java.util.ArrayList;

public class FindTable implements Command {
    private DataBaseInterface dataBase;
    private InputOutput console;
    private String tableName;

    public FindTable (DataBaseInterface dataBase, InputOutput console) {
        this.console = console;
        this.dataBase = dataBase;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (!command.get(0).equals("find")) {
            return false;
        }
        else {return true;}
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (!command.get(0).equals("find") || command.size() != 2) {
            console.outputln("Incorrect command format, please type \"help\" for help");
        } else {
            try {

                ArrayList<ArrayList<String>> tableToPrint = dataBase.findTable(command.get(1), "");
                console.outputln("");
                console.outputln(tableToPrint);
            } catch (Exception e) {
                console.outputln(e.getMessage());
            }

        }
    }
}
