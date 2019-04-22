package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

public class DropTable implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public DropTable (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public void execute() {

    }
}
