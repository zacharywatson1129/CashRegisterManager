package edu.tarleton.cashregistemanager.ui;

import edu.tarleton.cashregistermanager.login.Account;
import java.util.Scanner;

public class RegisterMenu {

    public static Account show(Scanner input) {
        
        String firstName;
        String lastName;
        String email;
        
        while (true) {
            System.out.println("Please enter your first name: ");
            firstName = input.nextLine();
            if (firstName.isEmpty() || firstName == null) {
                System.out.println("Please enter a first name: ");
            } else if (firstName.contains(";")) {
                System.out.println("Please don't use semi-colons. ");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Please enter your last name: ");
            lastName = input.nextLine();
            if (lastName.isEmpty()) {
                System.out.println("Please enter a last name: ");
            } else if (lastName.contains(";")) {
                System.out.println("Please don't use semi-colons. ");
            } else {
                break;
            }
        }
        
        while (true) {
            System.out.println("Please enter your email (this will be your username): ");
            email = input.nextLine();
            if (email.isEmpty()) {
                System.out.println("Please enter an email address: ");
            } else if (email.contains(";")) {
                System.out.println("Please don't use semi-colons. ");
            } else {
                break;
            }
        }
        String password = "b";
        String passwordConfirm = "c";
        while (!passwordConfirm.equals(password)) {
            System.out.println("Please enter a password: ");
            password = input.nextLine();
            while (password.isEmpty()) {
                System.out.println("Please enter a password");
                password = input.nextLine();
            }
            System.out.println("Please confirm your password: ");
            passwordConfirm = input.nextLine();
            while (passwordConfirm.isEmpty()) {
                System.out.println("Please confirm your password: ");
                passwordConfirm = input.nextLine();
            }
            if (!password.equals(passwordConfirm)) {
                System.out.println("Password and confirmation do not match.");
            }
        }
        System.out.println("Registering your account...");
        Account output = Account.register(firstName, lastName, email, password);
        System.out.println("Thank you for registering for an account.");
        return output;
    }

}
