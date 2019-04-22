package controller;


import controller.command.*;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import view.InputOutput;
import view.View;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private View inputOutput;
    private DataBaseInterface dataBase;
    private List<Command> commands;
    private Connection connection;

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

}
