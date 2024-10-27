package edu.tarleton.cashregistemanager.ui;

import edu.tarleton.cashregistermanager.logic.InvalidMenuOptionException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

/*
This class represents a numbered list.
 */
public class Menu {

    private String prompt;
    private final ArrayList<String> options = new ArrayList<String>();
    private Consumer<Integer> executor;
    private Scanner scanner;

    public void setOptionsLogic(Consumer<Integer> executor) {
        this.executor = executor;
    }

    public Menu(String prompt, Scanner scanner) {
        this.prompt = prompt;
        this.scanner = scanner;
    }

    public void changePrompt(String newPrompt) {
        this.prompt = newPrompt;
    }

    public void addOption(String option) {
        if (!option.isEmpty()) {
            options.add(option);
        }
    }

    public void display() throws InvalidMenuOptionException {

        System.out.println(prompt);
        while (true) {
            try {
                for (int i = 0; i < options.size(); i++) {
                    System.out.printf("\t");
                    System.out.printf("%d. %s%n", i + 1, options.get(i));
                }
                System.out.print("> ");

                int num = scanner.nextInt();
                parseInput(num);
                break;
            } catch (InputMismatchException ex) {
                System.out.printf("Please enter an integer value between 1 and %d", options.size());
            }
        }
    }

    private void parseInput(int input) throws InvalidMenuOptionException {

            executor.accept(input);
        
    }

    private boolean isInputValid(int userNum) throws InvalidMenuOptionException {

        int length = options.size();

        if (userNum > 0 && userNum <= length) {
            return true;
        } else {
            throw new InvalidMenuOptionException();
        }
    }

    public static int requestNumbericalData(String message, Scanner input) {
        System.out.println(message);
        while (true) {
            System.out.print("> ");
            try {
                int userVal = input.nextInt();
                return userVal;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value.");
            }
        }
    }

    public static int requestNumbericalData(String message, Scanner input, int smallestVal, int largestVal) {
        System.out.println(message);
        while (true) {
            System.out.print("> ");
            try {
                int userVal = input.nextInt();
                if (userVal >= smallestVal && userVal <= largestVal) {
                    return userVal;
                } else {
                    System.out.printf("Please enter a value in the range %d to %d.%n", smallestVal, largestVal);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value.");
            }
        }
    }
}
