package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.util.ArrayList;

public class CloseConnection implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public CloseConnection (DataBaseInterface dataBase, View console) {
        this.console = console;
        this.dataBase = dataBase;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("close")) {return true;}
        else return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
            String userInput = console.input("You are about to close connection to DB, please confirm (Y/N): ").toUpperCase();
        while (true) {
            if (userInput.equals("Y")) {
                try {
                    if (this.dataBase.closeConnection()) {
                        console.outputln("Connection to DB \" " + this.dataBase.getDataBaseName() + " \" closed");
                        return;
                    } else {
                        console.outputln("Was you really connected to any DB??? somwthing went wrong...");
                        return;
                    }
                } catch (Exception e) {
                    console.outputln(e.getMessage());
                }
            } else if (userInput.equals("N")) {
                return;
            } else {userInput = console.input("Please select only Y or N: ").toUpperCase();}

        }
    }
}
