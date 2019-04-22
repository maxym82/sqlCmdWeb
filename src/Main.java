import controller.CommandInvoker;
import dataBase.DataBaseOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandInvoker commandInterface = new CommandInvoker();

        commandInterface.start();

    }

    private static void oldMain() {
        DataBaseOperations newBD = new DataBaseOperations();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the data Base manager.");
        while (true) {
            System.out.println("Please select one of the option below:");
            System.out.println("1:  Connect to Data Base;");
            System.out.println("2.  Print out list of tables available;");
            System.out.println("3.  Clear table content");
            System.out.println("4.  Drop the table;");
            System.out.println("5.  Create the Table;");
            System.out.println("6.  Print table content;");
            System.out.println("7.  Insert row in to the table;");
            System.out.println("8.  Update column value;");
            System.out.println("9.  Delete value;");
            System.out.println("10. Help;");
            System.out.println("11. Exit");
            System.out.print("Please enter your desired option: ");

            int userChoice = userInput.nextInt();
            userInput.nextLine();

            if (userChoice == 1) {
                System.out.println("Please provide DB name and user credentials.");
                System.out.print("Data Base name: ");
                String dataBaseName = userInput.nextLine();
                System.out.print("User name: ");
                String userName = userInput.nextLine();
                System.out.print("Password: ");
                String userPassword = userInput.nextLine();
                newBD.connectToDataBase(dataBaseName, userName, userPassword);
                if (newBD.isConnected()) {
                    System.out.println("You hafe connected to DB:" + dataBaseName);
                }
                else {
                    System.out.println("Semething went wrong, please check DB name, and user credentials");
                }
            }
            else if (userChoice == 2) {
                if (newBD.isConnected()) {
                    System.out.println("At DB with name " + newBD.getDataBaseName() + "following ables available:");
                    newBD.printTables();
                }else {
                    System.out.println("You are not connected to any DB.");
                }
            }
            else if (userChoice == 3) {}
            else if (userChoice == 4) {}
            else if (userChoice == 5) {}
            else if (userChoice == 6) {
                if (newBD.isConnected()) {
                    System.out.print("Please enter table name: ");
                    String tableName = userInput.nextLine();
                    newBD.findTable(tableName);
                }else {
                    System.out.println("You are not connected to any DB.");
                }
            }
            else if (userChoice == 7) {}
            else if (userChoice == 8) {}
            else if (userChoice == 9) {}
            else if (userChoice == 10) {}
            else if (userChoice == 11) {
                System.out.print("You are about to close connection" +
                        "Please confirm Y/N ");
                String userSelect = userInput.nextLine();
                if (userSelect.equals("Y") || userSelect.equals("y")) {
                    if (newBD.closeConnection()) {
                        System.out.println("You have successfully close connection and exit the program");
                        break;
                    }else {
                        System.out.println("Something went wrong");
                    }
                }else {
                    System.out.println("You selected not ot close connection.");
                };
            }
            else {
                System.out.println("Wrong selection. Please select one of the valid options");
            }


        }
    }
}
