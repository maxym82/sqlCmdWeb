package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.InputOutput;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;

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
                ArrayList<ArrayList<String>> rowToDelete = dataBase.findTable(command.get(1), command.get(2));
                console.outputln("Following row will be modified:");
                console.outputln(rowToDelete);
                ArrayList<ArrayList<String>> newValues = dataBase.updateValue(command.get(1), command.get(2), command.get(3));
                console.outputln("New row:");
                console.outputln(newValues);

            } catch (SQLException e) {
                console.outputln(e.getMessage());
            }
        }

    }
}
