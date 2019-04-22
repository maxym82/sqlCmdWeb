package command;

import dataBase.DataBaseInterface;

public class ClearTable implements Command {
    private DataBaseInterface dataBase;
    private String tableName;
    public ClearTable(DataBaseInterface dataBase, String tableName) {
        this.dataBase = dataBase;
        this.tableName = tableName;
    }
    @Override
    public void execute() {
        this.dataBase.clearTable(this.tableName);
    }
}
