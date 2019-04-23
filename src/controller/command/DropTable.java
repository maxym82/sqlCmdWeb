package controller.command;

import controller.Command;
import dataBase.DataBaseInterface;
import view.View;

import java.util.ArrayList;

public class DropTable implements Command {
    private DataBaseInterface dataBase;
    private View console;

    public DropTable (DataBaseInterface dataBase, View console) {
        this.dataBase = dataBase;
        this.console = console;
    }

    @Override
    public boolean isExecutable(ArrayList<String> command) {
        return false;
    }

    @Override
    public void execute(ArrayList<String> command) {

    }
}
