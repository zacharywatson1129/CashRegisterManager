package edu.tarleton.cashregistermanager.main;

import edu.tarleton.cashregistemanager.ui.AdminUI;
import java.util.Scanner;

import edu.tarleton.cashregistermanager.logic.Cart;
import edu.tarleton.cashregistemanager.ui.CustomerUI;
import edu.tarleton.cashregistermanager.login.Customer;

public class Main {

    public static Cart cart = new Cart();
    
    public static void main(String[] args) {

        try {
            Customer.nextID = 5;       
            System.out.println("Welcome to Rocket Speed Computers!");
            System.out.println();
            Scanner userInput = new Scanner(System.in);
            System.out.println("Press any key and [enter] (or just [enter] ) to continue.....");
            String notUsed = userInput.nextLine();
            System.out.println();
            CustomerUI ui = new CustomerUI();
            if (ui.display(userInput) == -1) {
                AdminUI adminUI = new AdminUI();
                adminUI.show(userInput);
            }
        }
        catch (Exception ex) {
            System.out.println("The program has went into an error state.");
            System.out.println("Sorry for any inconviences.");
        }

    }

}
