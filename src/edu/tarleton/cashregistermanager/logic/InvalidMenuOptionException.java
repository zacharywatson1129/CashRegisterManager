package edu.tarleton.cashregistermanager.logic;

public class InvalidMenuOptionException extends Exception {
    @Override
    public void printStackTrace() {
        System.out.println("Invalid menu option.");
    }
}
