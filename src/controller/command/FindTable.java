package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.InputOutput;
import view.View;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindTable implements Command {
    private DataBaseInterface dataBase;
    private InputOutput console;
    private String tableName;

    public FindTable (DataBaseInterface dataBase, InputOutput console) {
        this.console = console;
        this.dataBase = dataBase;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        if (!command.get(0).equals("find")) {
            return false;
        }
        else {return true;}
    }

    @Override
    public void execute(ArrayList<String> command) {
        if (!command.get(0).equals("find") || command.size() != 2) {
            console.outputln("Incorrect command format, please type \"help\" for help");
        } else {
            ResultSet result = dataBase.findTable(command.get(1));
            ResultSetMetaData rsmd = null;
            ArrayList<ArrayList<String>> tableToPrint = new ArrayList<ArrayList<String>>();
            ArrayList<String> row;
            ArrayList<String> header = new ArrayList();
            try {
                rsmd = result.getMetaData();
                int columnNumber = rsmd.getColumnCount();
                for (int i = 1; i <= columnNumber; i++) {
                    header.add(rsmd.getColumnName(i));
                }
                tableToPrint.add(header);
                while (result.next()) {
                    row = new ArrayList<>();
                    for (int i = 1; i <= columnNumber; i++) {
                        if (result.getString(i) != null) {
                            row.add(result.getString(i));
                        }
                    }
                    tableToPrint.add(row);
                }
                console.outputln(tableToPrint);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
