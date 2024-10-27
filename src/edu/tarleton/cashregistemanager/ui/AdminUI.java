package edu.tarleton.cashregistemanager.ui;

import edu.tarleton.cashregistermanager.logic.InvalidMenuOptionException;
import java.util.Scanner;

public class AdminUI {

    public void show(Scanner input) throws InvalidMenuOptionException {
        System.out.println("<---------------Admin Mode----------------->");
        Menu adminOptions = new Menu("Admin options", input);
        adminOptions.addOption("Adcomputers");
        adminOptions.setOptionsLogic((e) -> {
            int choice = (int) e;
            if (choice == 1) {
                Menu computerAddRemoveMenu = new Menu("Add/Remove Computers", input);
                computerAddRemoveMenu.addOption("Add computer(s)");
                computerAddRemoveMenu.setOptionsLogic((e2) -> {
                    if (e2 == 1) {
                        try {
                            AddComputersMenu.show(input);
                        } catch (InvalidMenuOptionException ex) {
                            System.out.println("Something happened, and there is a problem.");
                        }
                    }
                });
                try {
                    computerAddRemoveMenu.display();
                } catch (InvalidMenuOptionException ex) {
                    System.out.println("Something happened, and there is a problem.");
                }
            }
        });
        adminOptions.display();
    }

    public boolean parseBool(String val) {
        if (val.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

}
