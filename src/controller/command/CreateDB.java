package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;

public class CreateDB implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public CreateDB (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("make")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size() < 2) {
            console.outputln("Command format is wrong... Pleae type \'help\' for help");
        } else {
            try {
                if (dataBase.createDB(command.get(1))) {
                    console.outputln("Data Base '" + command.get(1) + "' has been created");
                }
            } catch (SQLException e) {
                console.outputln(e.toString());
            }
        }

    }
}
