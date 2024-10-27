package edu.tarleton.cashregistermanager.login;

import edu.tarleton.cashregistermanager.io.ReceiptReader;
import edu.tarleton.cashregistermanager.logic.Receipt;
import edu.tarleton.cashregistermanager.logic.UniqueGenerator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private Customer customer;
    private List<String> orders;

    
    public Customer getCustomer() {
        return customer;
    }
    
    public void listAllReceipts() {
        for (int i = 0; i < orders.size(); i++) {
            System.out.printf("Receipt #%d:%n%n", i + 1);
            System.out.printf("%s%n", orders.get(i));
        }
    }
    
    public void placeOrder(Receipt r) {
        r.print();
    }

    public Account(Customer c) {
        this.customer = c;
        orders = ReceiptReader.loadReceipts(customer.getID());
    }

    /*
    This method registers a new account. It writes the new account to the text file, and returns a copy of the new account.
     */
    public static Account register(String firstName, String lastName, String email, String password) {

        // Create the account and add it to the list of accounts that are already on file.
        List<Account> accts = loadAccounts();
        Customer customer = new Customer(UniqueGenerator.generateUniqueID(4, 4), firstName, lastName, email, password);
        Account c = new Account(customer);
        // Keep the orders from being null. It's an empty list.
        c.orders = new ArrayList<String>();

        accts.add(c);

        // Now, overwrite the the text file with the current accounts + the new account.
        String pathToWriteTo = "customers.txt";
        Path file = Paths.get(pathToWriteTo);
        Charset charset = Charset.forName("US-ASCII");

        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            for (Account account : accts) {
                String lineToWrite = String.format("%s;%s;%s;%s;%s%n", account.customer.getID(), account.customer.getFirstName(), 
                        account.customer.getLastName(), account.customer.getEmail(), account.customer.getPassword());
                writer.write(lineToWrite);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return c;
    }

    /*
    Finds and returns the account associated with the username and password passed as arguments.
    Returns null if the account was not found.
     */
    public static Account loadAccount(String username, String password) {
        List<Account> accts = loadAccounts();
        for (Account account : accts) {
            if (account.customer.getEmail().equals(username) && account.customer.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    /*
    This method loads all accounts from the text file, and returns them in a list.
    If no accounts are found, the method returns null.
     */
    public static List<Account> loadAccounts() {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> output = new ArrayList<>();

        Path path = Paths.get("customers.txt");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            // Read through all the customers in the text file.
            String s = "";
            while ((s = br.readLine()) != null) {
                String line[] = s.split(";");
                String ID = line[0];
                String fName = line[1];
                String lName = line[2];
                String email = line[3];
                String password = line[4];
                Customer cust = new Customer(ID, fName, lName, email, password);
                customers.add(cust);
            }
            // Now, we associate every customer with an account, and load the orders associated with that particular account.
            for (Customer cust : customers) {
                Account account = new Account(cust);
                output.add(account);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
}
