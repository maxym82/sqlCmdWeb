import controller.CommandInvoker;
import dataBase.DataBaseOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandInvoker commandInterface = new CommandInvoker();

        commandInterface.start();

    }

}
