package edu.tarleton.cashregistermanager.logic;

import edu.tarleton.cashregistermanager.login.Account;
import edu.tarleton.cashregistermanager.login.Customer;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    public Map<Product, Integer> items = new HashMap<>();
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public double getSubtotal() {
        double subTotal = 0;
        for (Map.Entry<Product, Integer> listItem : items.entrySet()) {
            subTotal += listItem.getKey().getPrice() * listItem.getValue();
        }
        return subTotal;
    }

    public double getTax() {
        return 0.08 * getSubtotal();
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }
}
