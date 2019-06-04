package controller.command;

import dataBase.DataBaseInterface;
import controller.Command;
import view.InputOutput;

import java.util.ArrayList;

public class ConnectToDataBase implements Command {
    private DataBaseInterface dataBase;
    private InputOutput console;
    private String userPassword;
    private final boolean debug = true;

    public ConnectToDataBase (DataBaseInterface dataBase, InputOutput console) {
        this.console = console;
        this.dataBase = dataBase;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (!command.get(0).equals("connect") || command.size() != 3) {
            console.outputln("Incorrect command format, please type \"help\" for help");
            return false;
        }
        else {return true;}
    }

    @Override
    public void execute(ArrayList<String> command) {
        this.setPassword();
        try {
            dataBase.connectToDataBase(command.get(1), command.get(2), userPassword);
            if (dataBase.isConnected()) {
                console.outputln("You have connected to DB:" + command.get(1));
            } else {
                console.outputln("Semething went wrong, please check DB name, and user credentials");
            }
        } catch (Exception e) {
            console.outputln(e.getMessage());
        }

    }

    private void setPassword () {
        if (debug) {this.userPassword = console.input("password: ");}
        else {this.userPassword = String.valueOf(this.console.inputPassword());}
    }
}
