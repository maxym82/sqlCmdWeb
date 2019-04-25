package controller;


import controller.command.*;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import view.InputOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandInvoker {
    private InputOutput inputOutput;
    private DataBaseInterface dataBase;
    private List<Command> commands;
    private Connection connection;
    private ArrayList<String> userInput;
    private String prompt;
    private final String[] commandsAvailableWhenConnected = {"clear", "close", "create", "createTable", "drop", "delete", "find", "pdn", "help", "insert", "print", "update", "exit"};
    private final String[] commandsWhenNotConnected = {"connect", "help", "exit"};

    public CommandInvoker () {
    this.inputOutput = new InputOutput();
    this.dataBase = new DataBaseOperations();
    commands = new ArrayList<>();
    userInput = new ArrayList<String>();
    this.setCommandList();
    this.setPrompt();
    }

    private void setPrompt (String line) {
        this.prompt = line;
    }

    private void setPrompt() {
        this.prompt = "sqlCmd_> ";
    }

    private void setCommandList () {
        commands.add(new ClearTable(this.dataBase, this.inputOutput));
        commands.add(new CloseConnection(this.dataBase, this.inputOutput));
        commands.add(new CreateDB(this.dataBase, this.inputOutput));
        commands.add(new CreateTable(this.dataBase, this.inputOutput));
        commands.add(new DeleteValue(this.dataBase, this.inputOutput));
        commands.add(new DropTable(this.dataBase, this.inputOutput));
        commands.add(new FindTable(this.dataBase, this.inputOutput));
        commands.add(new GetDataBaseName(this.dataBase, this.inputOutput));
        commands.add(new Help());
        commands.add(new InsertRow(this.dataBase, this.inputOutput));
        commands.add(new listTables(this.dataBase, this.inputOutput));
        commands.add(new UpdateValue(this.dataBase, this.inputOutput));
    }

    public void start () {
        inputOutput.outputln("Welcome to sqlCmd.");
        inputOutput.outputln("For list of commands available type help.");
        inputOutput.outputln("For help on a particular comment type command following by \"?\"");

        loop: while (true) {
            if (!this.dataBase.isConnected()) {
                inputOutput.outputln("You are on an unconnected mode.");
                inputOutput.outputln("Type your commend here");
                userInput = new ArrayList<String>(Arrays.asList(inputOutput.input(prompt).split(" +")));
                if (Arrays.stream(commandsWhenNotConnected).anyMatch(userInput.get(0)::equals)) {
                    if (userInput.get(0).equals("help")) {}
                    if (userInput.get(0).equals("exit")) {
                        String userSelect = inputOutput.input("You are about to close the progran, please confirm (Y/N): ").toUpperCase();
                        while (true) {
//                        todo: check if i need to close any connection. should not be a problem, we did chec it on a condition above
                            if (userSelect.equals("Y")){
                                inputOutput.outputln("Programm saccessfully closed");
                                break loop;
                            }else if (userSelect.equals("N")) {break;}
                            else {userSelect = inputOutput.input("Please select \"Y\" or \"N\" (Y/N): ").toUpperCase();}
                        }
                    }
                    if (userInput.get(0).equals("connect")) {
                        ConnectToDataBase doConnect = new ConnectToDataBase(this.dataBase, this.inputOutput);
                        if (doConnect.isExecutable(userInput)) {
                            doConnect.execute(userInput);
                            setPrompt("sqlCmd/" + this.dataBase.getDataBaseName() + "/_> ");
                        }
                    }

                }else {
                    inputOutput.outputln("This command is not supported on this mode, please type help for \"help\"");
                }

            }
            else {
                inputOutput.outputln("You are on connected mode");
                inputOutput.outputln("Type your command here");
                userInput = new ArrayList<String>(Arrays.asList(inputOutput.input(prompt).split(" +")));
                for (Command command: commands) {
                    if (command.isExecutable(userInput)) {
                        command.execute(userInput);
                        if (userInput.get(0).equals("close")) {
                            setPrompt();
                            break;
                        }
                    }
                }

            }

        }

    }

}
