package controller;

import java.util.ArrayList;

public interface Command {

    boolean isExecutable(ArrayList<String> command);

    void execute(ArrayList<String> command);
    //void undo();
}
