package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.util.ArrayList;

public class DropTable implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public DropTable (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("drop")) {
            return true;
        } return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size() != 2) {
            console.outputln("Incorrect format, please type \"help\" for help");
            return;
        }
        try {
            if (dataBase.dropTable(command.get(1))) {
                console.outputln("Table \"" + command.get(1) + "\" has been deleted");
            } else {
                //console.outputln("Something went wrong, check your spelling");
            }
        } catch (Exception e) {
            console.outputln(e.getMessage());
        }

    }
}
