package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

import java.util.ArrayList;

public class DeleteValue implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public DeleteValue (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }


    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("delete")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        ArrayList rowToDelete = new ArrayList();
        if (command.size() != 4) {
            console.outputln("Incorrect command format, please type \"help\" for help");
        }else {
            try {
                if (dataBase.deleteValue(command)) {

                }

            } catch (Exception e) {
                console.outputln("Something went wrong \n" + e.toString());
            }

        }

    }
}
