package edu.tarleton.cashregistermanager.login;

public class AdminAccount extends Account {
    
    public AdminAccount() {
        super(new Customer("adminID123456", "admin", "admin", "admin", "12345678"));
        // super(null); // An admin account doesn't have a customer associated with it.
    }
    
}
