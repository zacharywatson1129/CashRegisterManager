package edu.tarleton.cashregistermanager.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
Class with static methods for adding computers to the catalog.
*/
public class ComputerWriter {

    public static void WriteLaptop(String field) throws IOException {
        Files.write(Paths.get("laptops.txt"), field.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("laptops.txt"), String.format("%n").getBytes(), StandardOpenOption.APPEND);
    }

    public static void WriteDesktop(String field) throws IOException {
        Files.write(Paths.get("desktops.txt"), field.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("desktops.txt"), String.format("%n").getBytes(), StandardOpenOption.APPEND);
    }

}
