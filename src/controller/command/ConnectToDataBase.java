package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.InputOutput;

import java.util.ArrayList;

public class ConnectToDataBase implements Command {
    private DataBaseInterface dataBase;
    private InputOutput console;
    private final String userPassword;
    private final boolean debug = true;

    public ConnectToDataBase (DataBaseInterface dataBase, InputOutput console) {
        this.console = console;
        this.dataBase = dataBase;
        if (debug) {userPassword = console.input("password: ");}
        else {userPassword = String.valueOf(this.console.inputPassword());}
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (!command.get(0).equals("connect") || command.size() != 3) {return false;}
        else {return true;}
    }

    @Override
    public void execute(ArrayList<String> command) {

        dataBase.connectToDataBase(command.get(1), command.get(2), userPassword);
        if (dataBase.isConnected()) {
            console.output("You hafe connected to DB:" + command.get(1));
        }
        else {
            console.output("Semething went wrong, please check DB name, and user credentials");
        }

    }
}
