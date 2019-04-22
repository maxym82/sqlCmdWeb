package view;

import java.util.Scanner;

public class InputOutput implements View {
    Scanner userInput = new Scanner(System.in);
    @Override
    public String input() {
        return userInput.nextLine();
    }

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
