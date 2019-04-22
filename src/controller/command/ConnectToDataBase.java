package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

import java.util.Scanner;

public class ConnectToDataBase implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public ConnectToDataBase (DataBaseInterface dataBase, View console) {
        this.console = console;
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please provide DB name and user credentials.");
        System.out.print("Data Base name: ");
        String dataBaseName = userInput.nextLine();
        System.out.print("User name: ");
        String userName = userInput.nextLine();
        System.out.print("Password: ");
        String userPassword = userInput.nextLine();
        dataBase.connectToDataBase(dataBaseName, userName, userPassword);
        if (dataBase.isConnected()) {
            System.out.println("You hafe connected to DB:" + dataBaseName);
        }
        else {
            System.out.println("Semething went wrong, please check DB name, and user credentials");
        }

    }
}
