package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListTables implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public ListTables(DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (!command.get(0).equals("list")) {
            return false;
        }
        else {return true;}
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (!command.get(0).equals("list") || command.size() != 1) {
            console.outputln("Incorrect command format, please type \"help\" for help");
        } else {
            int counter = 1;
            console.outputln(String.format("On Data Base \" %s \" you can find this tables available: ", this.dataBase.getDataBaseName()));
            try {
                List<String> tables = dataBase.listTables();
                if (tables.size() == 0) {
                    console.outputln("No tables available. DB is empty");
                } else {
                    for (String tableName : tables) {
                        console.outputln("+" + "-".repeat(tableName.length() + 11) + "+");
                        console.output("| " + counter++ + " |");
                        console.outputln("    " + tableName + "   |");
                        console.outputln("+" + "-".repeat(tableName.length() + 11) + "+");
                    }
                }

            } catch (SQLException e) {
                console.outputln(e.getMessage());
            }
        }
    }
}
