package command;

import dataBase.DataBaseInterface;

public class CloseConnection implements Command {
    private DataBaseInterface dataBase;

    public CloseConnection (DataBaseInterface dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        this.dataBase.closeConnection();

    }
}
