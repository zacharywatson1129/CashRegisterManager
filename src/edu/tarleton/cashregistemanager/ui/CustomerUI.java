package edu.tarleton.cashregistemanager.ui;

import java.util.ArrayList;
import java.util.Scanner;

import edu.tarleton.cashregistermanager.io.ComputerReader;
import edu.tarleton.cashregistermanager.logic.Cart;
import edu.tarleton.cashregistermanager.logic.Computer;
import edu.tarleton.cashregistermanager.logic.InvalidMenuOptionException;
import edu.tarleton.cashregistermanager.logic.StringHelper;
import edu.tarleton.cashregistermanager.login.AdminAccount;
import java.text.NumberFormat;

public class CustomerUI {

    public CustomerUI() {
        loadComputers();
    }

    private Cart cart = new Cart();
    private ArrayList<Computer> computers;

    private void loadComputers() {
        ComputerReader reader = new ComputerReader();
        computers = reader.readComputers();
    }

    /*
    Returns a 1 if a customer signs or (or continues as an admin) or a -1 if an admin signs in.
     */
    public int display(Scanner input) throws InvalidMenuOptionException {
        String prompt = "Would you like to log into an existing account, register a new account, or continue as a guest?";
        Menu loginMenu = new Menu(prompt, input);
        loginMenu.addOption("Login to an existing account");
        loginMenu.addOption("Register for a new account");
        loginMenu.addOption("Continue as guest");

        // String optionPicked = input.nextLine();
        loginMenu.setOptionsLogic((e) -> {
            // When we call this menu, we ask for an integer, and only an integer.
            // The way scanner works, it ignores everything after the integer.
            // Thus, calling input.nextLine() consumes the \n, moving on.
            input.nextLine();

            if (e == 1) {
                cart.setAccount(SignInMenu.show(input));
                if (cart.getAccount() != null) {
                    System.out.println("Successfully signed in!");
                }
            }
            if (e == 2) {
                RegisterMenu.show(input);
            }
            if (e == 3) {
                System.out.println("Continuing as a guest user.");
            }

        });
        loginMenu.display();

        if (cart.getAccount() != null) {
            if (cart.getAccount().getClass().equals(AdminAccount.class)) {
                return -1;
            }
            String header = "Account options:";
            Menu accountOptions = new Menu(header, input);
            accountOptions.addOption("View previous receipts");
            accountOptions.addOption("Continue to store");

            String choice = input.nextLine();
            accountOptions.setOptionsLogic((e) -> {

                switch (e) {
                    case 1: {
                        System.out.printf("Loading receipts for %s %s: %n",
                                cart.getAccount().getCustomer().getFirstName(),
                                cart.getAccount().getCustomer().getLastName());
                        cart.getAccount().listAllReceipts();
                        break;
                    }
                    case 2:
                        System.out.println("Loading store...");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception ex) {
                            System.out.println("Sorry, the program broke.");
                        }
                        break;
                }
            });
            accountOptions.display();
//             accountOptions.parseInput(choice);

        }
        loadComputers();
        System.out.println();
        System.out.println("Press any key and [enter] (or just [enter] ) to view the catalog.");
        input.nextLine();
        System.out.println();

        //while (computerChoice != "checkout") {
        System.out.println(StringHelper.Multiply('-', 72));
        System.out.printf("%-10s %-50s %10s%n", "ITEM #", "DESCRIPTION", "PRICE");
        System.out.println(StringHelper.Multiply('-', 72));

        for (int i = 0; i < computers.size(); i++) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String price = formatter.format(computers.get(i).getPrice());
            System.out.printf("%-10d %-50s %10s%n", i + 1, computers.get(i).descriptionFormat(), price);
        }

        Menu atCatalogMenu = new Menu("Catalog options: ", input);
        atCatalogMenu.addOption("View an item.");
        atCatalogMenu.addOption("Checkout");
        if (cart.getAccount() != null) {
            atCatalogMenu.addOption("View previous orders");
        }
        atCatalogMenu.setOptionsLogic((g) -> {
            // if we want to view an item, request a specific number.
            if (g == 1) {
                int val = Menu.requestNumbericalData("Enter the item number of the computer you wish to view.",
                        input, 1, computers.size());
                try {
                    // int searchID = computerChoice;
//Integer.parseInt(computerChoice);

                    /*
                    Now, we take the ID entered and find the correct computer.
                    Choice 1. would be the first computer in the list, so
                    we find the ID associated with that computer to look it up.
                     */
                    String lookupID = computers.get(val - 1).getID();
                    Computer found = findByID(lookupID);
                    if (found != null) {
                        ComputerDetailsMenu subMenu = new ComputerDetailsMenu();
                        subMenu.show(cart, found, input);
                    } else {
                        System.out.println("Please enter a valid computer number: ");
                    }
                    atCatalogMenu.display();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Please enter a valid computer number: ");
                }
            }
        });
        atCatalogMenu.display();


        /*int computerChoice = Menu.requestNumbericalData(
                "To add a computer to the cart, type the item number and press enter. If you are ready to checkout, enter [checkout].",
                input);
        System.out.println();*/

 /*if (computerChoice.equals("checkout")) {
            break;
        }*/
        //if (!computerChoice.equals("checkout")) {
        //}
        // System.out.println("To add a computer to the cart, type the computer number and press enter. If you are ready to checkout, enter [checkout].");
        // }
        System.out.println("Checkout Time!");

        CheckoutMenu coMenu = new CheckoutMenu();
        coMenu.show(cart);

        System.out.println();
        return 1;
    }

    public Computer findByID(String id) {
        for (Computer c : computers) {
            if (c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
