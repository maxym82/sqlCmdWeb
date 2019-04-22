package view;

import java.util.Scanner;

public class InputOutput implements View {
    private Scanner userInput = new Scanner(System.in);
    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return userInput.nextLine();
    }

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
