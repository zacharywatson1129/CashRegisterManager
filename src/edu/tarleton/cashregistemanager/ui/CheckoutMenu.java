package edu.tarleton.cashregistemanager.ui;

import edu.tarleton.cashregistermanager.logic.Cart;
import edu.tarleton.cashregistermanager.logic.Receipt;

public class CheckoutMenu {

    public void show(Cart c) {
        // if the cart's customer is not null (aka they actually signed in), we can save the receipt as a text file in the correct folder, otherwise just save in a reciepts folder.
        if (c.items.isEmpty()) {
            System.out.println("Your cart is empty. Hopefully our products interest you. Thank you for browsing, and have a great day!");
        } else {           
            Receipt r = new Receipt(c);
            r.print();
            System.out.println(r.toString());
            System.out.println();
            System.out.println("Thank you for shopping. We appreciate your business, and hope to see you again!");
        }
    }
}
