package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.InputOutput;

import java.util.ArrayList;

public class DeleteValue implements Command {
    private DataBaseInterface dataBase;
    private InputOutput console;

    public DeleteValue (DataBaseInterface dataBase, InputOutput console) {
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
        ArrayList<ArrayList<String>> tableToPrint = new ArrayList<ArrayList<String>>();
        if (command.size() != 3) {
            console.outputln("Incorrect command format, please type \"help\" for help");
        }else {
            try {
                //delete table1 column1|'any_text'
                String lookupValues = command.get(2).split("\\|")[0] + " = " + command.get(2).split("\\|")[1];
                console.outputln("You are about to delete row that contains Value " + lookupValues);
                String userInput = console.input("Plese confirm (Y/N): ").toUpperCase();
                if (userInput.equals("Y")) {
                    tableToPrint = dataBase.deleteValue(command.get(1), lookupValues);
                    console.outputln("Following row was deleted fron the table \"" +
                            command.get(1) + ":");
                    console.outputln("");
                    console.outputln(tableToPrint);
                }

            } catch (Exception e) {
                console.outputln("Something went wrong \n" + e.toString());
            }

        }

    }
}
