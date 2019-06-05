package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;

public class DropDB implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public DropDB (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("erase")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size() < 2) {
            console.outputln("Command format is wrong... Pleae type \'help\' for help");
        } else {
            try {
                if (dataBase.dropDB(command.get(1))) {
                    console.outputln("Data Base '" + command.get(1) + "' has been deleted");
                }
            } catch (SQLException e) {
                console.outputln(e.toString());
            }
        }

    }
}