package edu.tarleton.cashregistermanager.login;

public class Customer {

    public static int nextID;

    private String ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Customer(String ID, String firstName, String lastName, String email, String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void greet() {
        System.out.printf("Welcome, %s!%n", firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
