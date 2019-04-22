package command;

import dataBase.DataBaseInterface;

public class FindTable implements Command {
    private DataBaseInterface dataBase;
    private String tableName;

    public FindTable (DataBaseInterface dataBase, String tableName) {
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        dataBase.findTable(this.tableName);
    }
}
