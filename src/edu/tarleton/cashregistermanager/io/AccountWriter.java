package edu.tarleton.cashregistermanager.io;

import edu.tarleton.cashregistermanager.logic.Receipt;
import edu.tarleton.cashregistermanager.logic.UniqueGenerator;
import edu.tarleton.cashregistermanager.login.Customer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AccountWriter {
    
    public static void addReceipt(Customer customer, Receipt r) { 
        
        int folder = 1;
        String folderName = String.format("%d", folder);
        String uniqueName = UniqueGenerator.generateUniqueID(5,3);
        String pathToWriteTo = String.format("%s/%s.txt", folderName, uniqueName);
        Path file = Paths.get(pathToWriteTo);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(r.toString());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

}
