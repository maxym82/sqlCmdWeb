package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import dataBase.DataSet;
import dataBase.DataSetInterface;
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
            DataSetInterface newRow = new DataSet();
            for (String column: command.subList(2, command.size())) {
                newRow.put(column.split("\\|")[0], column.split("\\|")[1]);
            }
            try {
                if (dataBase.insertROW(command.get(1), newRow)) {
                    console.outputln("Row was successfully inserted");
                }
            } catch (Exception e) {
                console.outputln("Something went wrong \n" + e.toString());
            }
        }

    }
}
