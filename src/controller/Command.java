package controller;

public interface Command {

    boolean ifExecutable();

    void execute();
    //void undo();
}
