package ua.com.maksym82.controller.command;

import ua.com.maksym82.controller.Command;
import ua.com.maksym82.dataBase.DataBaseInterface;
import ua.com.maksym82.dataBase.DataSet;
import ua.com.maksym82.dataBase.DataSetInterface;
import ua.com.maksym82.view.View;

import java.util.List;

public class CreateTable implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public CreateTable (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(List<String> command) {
        if (command.get(0).equals("create")) {return true;}
        return false;
    }

    @Override
    public void execute(List<String> command) {
        if (command.size() < 2) {
            console.outputln("Command format is wrong... Pleae type \'help\' for help");
        } else {
            DataSetInterface newTable = new DataSet();
            //  create table1 column1|text column2|int
            for (String column: command.subList(2, command.size())) {
                newTable.put(column.split("\\|")[0], column.split("\\|")[1]);
            }
            try {
                if (dataBase.createTable(command.get(1), newTable)) {
                    console.outputln("DB \"" + command.get(1) + "\" has been created");
                }
            } catch (Exception e) {
                console.outputln(e.toString());
            }
        }

    }
}
