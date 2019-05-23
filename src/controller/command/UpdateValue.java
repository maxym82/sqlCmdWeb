package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.InputOutput;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateValue implements Command {
    private DataBaseInterface dataBase;
    private InputOutput console;

    public UpdateValue (DataBaseInterface dataBase, InputOutput console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("update")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size() != 4) {
            console.outputln("Command format is wrong... Pleae type \'help\' for help");
        } else {
            try {
                // update table1 column1|'roadHouse' column2|123
                String lookupCondition;
                String newValues;
                console.outputln("Following row will be modified:");
                lookupCondition = command.get(2).split("\\|")[0] + " = " + command.get(2).split("\\|")[1];
                newValues = command.get(3).split("\\|")[0] + " = " + command.get(3).split("\\|")[1];
                console.outputln(dataBase.findTable(command.get(1), lookupCondition));
                ArrayList<ArrayList<String>> newTable = dataBase.updateValue(command.get(1), lookupCondition, newValues);
                console.outputln("New row:");
                console.outputln(newTable);

            } catch (SQLException e) {
                console.outputln(e.getMessage());
            }
        }

    }
}
