package edu.tarleton.cashregistemanager.ui;

import edu.tarleton.cashregistermanager.login.Account;
import edu.tarleton.cashregistermanager.login.AdminAccount;
import java.util.Scanner;

public class SignInMenu {

    public static Account show(Scanner input) {
        System.out.println("+----------------------+");
        System.out.println("|    Sign in Screen    |");
        System.out.println("+----------------------+");
        boolean validCredentials = false;
        while (!validCredentials) {
            System.out.print("Username: ");
            String user = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            // String password = input.nextLine();
            if (user.equals("admin") && password.equals("12345678")) {
                return new AdminAccount();
            }
            Account found = Account.loadAccount(user, password);
            if (found == null) {
                System.out.println("Account not valid. Please ensure you entered valid account credentials.");
            } else {
                System.out.println("|~~~~~~~~~~~Succesfully signed in.~~~~~~~~~~~|");
                found.getCustomer().greet();
                return found;
            }
        }
        return null;
    }
}
