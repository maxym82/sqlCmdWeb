package view;

import java.io.Console;
import java.util.Scanner;

public class InputOutput implements View {
    private Scanner userInput = new Scanner(System.in);
    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return userInput.nextLine();
    }

    @Override
    public void outputln(String text) {
        System.out.println(text);
    }

    @Override
    public void output(String text) {
        System.out.print(text);
    }


    public char[] inputPassword () {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        return console.readPassword("password: ");
    }
}
