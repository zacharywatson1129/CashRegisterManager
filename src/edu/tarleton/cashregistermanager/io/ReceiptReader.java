package edu.tarleton.cashregistermanager.io;

import edu.tarleton.cashregistermanager.logic.UniqueGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that reads receipts from text files.
 *
 * @author Zachary
 */
public class ReceiptReader {

    public String generateUniqueReceiptName() {
        try {
            String uniqueName = UniqueGenerator.generateUniqueID(8, 0);
            while (true) {
                if (isNameUnique("receipts", ".txt", uniqueName) == true) {
                    return uniqueName;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<String> loadReceipts(String customerID) {
        List<String> output = new ArrayList<>();

        try {
            // Get file paths for all receipts
            List<Path> receiptPaths = getFilePathsWithExtension("receipts", ".txt");

            // For every path, attempt to convert the line into a Receipt object.
            // Add every receipt object to receipts.
            for (Path p : receiptPaths) {

                BufferedReader br = Files.newBufferedReader(p);

                String s = "";
                String temp = "";
                int counter = 0;
                while ((s = br.readLine()) != null) {
                    if (counter == 0) {
                        // If the first line equals the customerID, we have a match.
                        if (!s.equals(customerID)) {
                            counter++;
                            continue;
                        }
                    } else {
                        temp += String.format("%s%n", s);
                    }
                    counter++;
                }
                br.close();
                // If our temp variable isn't blank (meaning we actually found a receipt with a matching ID)
                // We can add to the ID
                if (!temp.equals("")) {
                    output.add(temp);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }

    /**
     *
     * @param directory - This is the folder name to look in.
     * @param extension - The file extension to use.
     * @param fileName - The unique name to check.
     * @returns true if the name hasn't already been used, or false if the name
     * is already taken up.
     * @throws IOException since blah blah blah....
     *
     */
    public boolean isNameUnique(String directory, String extension, String fileName) throws IOException {
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(FileSystems.getDefault().getPath(directory));
        for (Path path : directoryStream) {
            if (path.getFileName().toString().endsWith(extension)) {
                if (path.getFileName().toString().contains(fileName)) {
                    return false;
                }
            }
        }
        directoryStream.close();
        return true;
    }

    /*
    Returns all files in the specified directory that end with the specified file extension.
     */
    private static List<Path> getFilePathsWithExtension(String directory, String extension) throws IOException {
        List<Path> output = new ArrayList<>();
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(FileSystems.getDefault().getPath(directory));
        for (Path path : directoryStream) {
            if (path.getFileName().toString().endsWith(extension)) {
                output.add(path);
            }
        }
        directoryStream.close();
        return output;
    }
}
