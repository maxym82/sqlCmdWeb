package controller;


import controller.command.*;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import view.InputOutput;
import view.View;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandInvoker {
    private View inputOutput;
    private DataBaseInterface dataBase;
    private List<Command> commands;
    private Connection connection;
    private ArrayList<String> userInput;
    private final String prompt = "sqlCmd_> ";
    private final String[] commandsAvailable = {"connect", "clear", "close", "create", "createTable", "drop", "delete", "find", "pdn", "help", "insert", "print", "update", "exit"};

    public CommandInvoker () {
    this.inputOutput = new InputOutput();
    this.dataBase = new DataBaseOperations();
    commands = new ArrayList<>();
    this.setCommandList();

    }

    private void setCommandList () {
        commands.add(new ClearTable(this.dataBase, this.inputOutput));
        commands.add(new CloseConnection(this.dataBase, this.inputOutput));
        commands.add(new ConnectToDataBase(this.dataBase, this.inputOutput));
        commands.add(new CreateDB(this.dataBase, this.inputOutput));
        commands.add(new CreateTable(this.dataBase, this.inputOutput));
        commands.add(new DeleteValue(this.dataBase, this.inputOutput));
        commands.add(new DropTable(this.dataBase, this.inputOutput));
        commands.add(new FindTable(this.dataBase, this.inputOutput));
        commands.add(new GetDataBaseName(this.dataBase, this.inputOutput));
        commands.add(new Help());
        commands.add(new InsertRow(this.dataBase, this.inputOutput));
        commands.add(new PrintTable(this.dataBase, this.inputOutput));
        commands.add(new UpdateValue(this.dataBase, this.inputOutput));
    }

    public void start () {
        inputOutput.output("Welcome to sqlCmd.");
        inputOutput.output("For list of commands available type help.");
        inputOutput.output("For help on a particular comment type command following by \"?\"");
        inputOutput.output("Type your commend here");
        while (true) {
            userInput = new ArrayList<>(Arrays.asList(inputOutput.input(prompt).split(" +")));
            if (Arrays.stream(commandsAvailable).anyMatch(userInput.get(0)::equals)) {
                if (((userInput.get(0).toLowerCase()).equals("exit"))) {
//                    todo: close connection if opened and exit from program
                    break;}


                inputOutput.output("we are working");

            } else {
                inputOutput.output("This commend is not supported, please type \"help\" for help");
            }
        }

    }

}
