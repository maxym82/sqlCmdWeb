package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.util.ArrayList;

public class CreateTable implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public CreateTable (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (command.get(0).equals("create")) {return true;}
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (command.size() < 2) {
            console.outputln("Command format is wrong... Pleae type \'help\' for help");
        } else {
            try {
                if (dataBase.createTable(command.get(1), new ArrayList<>(command.subList(2, command.size())))) {
                    console.outputln("DB \"" + command.get(1) + "\" has been created");
                }
            } catch (Exception e) {
                console.outputln(e.toString());
            }
        }

    }
}
