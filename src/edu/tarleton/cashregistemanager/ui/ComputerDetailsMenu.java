package edu.tarleton.cashregistemanager.ui;

import java.util.Scanner;

import edu.tarleton.cashregistermanager.logic.Cart;
import edu.tarleton.cashregistermanager.logic.Computer;
import edu.tarleton.cashregistermanager.logic.InvalidMenuOptionException;
import java.util.InputMismatchException;

public class ComputerDetailsMenu {

    public void show(Cart cart, Computer c, Scanner input) throws InvalidMenuOptionException {
        System.out.println();
        System.out.println(c.featuresFormat());

        Menu computerDetailsMenu = new Menu("Choose an option below: ", input);
        computerDetailsMenu.addOption("Add computer to cart.");
        computerDetailsMenu.addOption("Return to previous menu.");
        computerDetailsMenu.setOptionsLogic((e) -> {
            int choice = (int) e;
            if (choice == 1) {
                int num = Menu.requestNumbericalData(
                        "Please enter how many you would like to add to the cart", 
                        input);
                Integer currQuantity = cart.items.get(c);
                if (currQuantity != null) {
                    cart.items.put(c, cart.items.get(c) + num);
                } else {
                    cart.items.put(c, num);
                }
            }
            if (choice == 2) {
                System.out.println("No items were added to the cart. Returning to previous menu.");
            }
        });
        computerDetailsMenu.display();
    }
}
