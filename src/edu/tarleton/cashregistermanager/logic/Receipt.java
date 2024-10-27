package edu.tarleton.cashregistermanager.logic;

import edu.tarleton.cashregistermanager.io.ReceiptReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Receipt {
    
    private String customerID;
    private Cart c;
      
    
    public Receipt(Cart c) {
        this.c = c;
        if (c.getAccount() != null) {
        if (c.getAccount().getCustomer() != null) {
            customerID = c.getAccount().getCustomer().getID();
        } 
        
        
        }else {
            customerID = "guest";
        }
    }

    @Override
    public String toString() {
        
        String output = "";
        
        for (Map.Entry<Product, Integer> listItem : c.items.entrySet()) {
            output += String.format("%-45s $%8.2f %n", String.format("%s x%d", listItem.getKey().name, listItem.getValue()), listItem.getKey().getPrice());
        }
        
        output += StringHelper.Multiply('-', 54);
        output += String.format("%n");
        output += String.format("%45s $%8.2f %n", "Subtotal", c.getSubtotal());
        output += String.format("%45s $%8.2f %n", "Tax", c.getTax());
        output += String.format("%45s $%8.2f %n", "Total", c.getTotal());
        
        return output;
    }   

    public void print() {
               
        // Generate a unique name for our new Receipt.
        String name = UniqueGenerator.generateUniqueID(5, 3);
        name += ".txt";
        
        String pathToWriteTo = String.format("receipts/%s.txt", UniqueGenerator.generateUniqueID(4, 4));
        Path file = Paths.get(pathToWriteTo);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(this.customerID);
            writer.newLine();
            writer.write(this.toString());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
