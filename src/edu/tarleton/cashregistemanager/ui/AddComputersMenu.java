package edu.tarleton.cashregistemanager.ui;

import edu.tarleton.cashregistermanager.io.ComputerWriter;
import edu.tarleton.cashregistermanager.logic.InvalidMenuOptionException;
import edu.tarleton.cashregistermanager.logic.UniqueGenerator;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Zachary
 */
public class AddComputersMenu {

    public static void show(Scanner input) throws InvalidMenuOptionException {
        System.out.println("Add Computer Menu");
        System.out.println("-----------------------------");
        Menu addRemoveMenu = new Menu("Would you like to add a laptop or a desktop?", input);
        addRemoveMenu.addOption("Laptop");
        addRemoveMenu.addOption("Desktop");
        addRemoveMenu.setOptionsLogic((e) -> {
            if (e == 1) {
                addLaptop(input);
            }
            if (e == 2) {
                addDesktop(input);
            }

        });
        addRemoveMenu.display();
        // String userChoice = input.nextLine();
        // addRemoveMenu.parseInput(userChoice);
    }

    public static void addLaptop(Scanner input) {
        
        input.nextLine();

        System.out.println("Please fill out the following fields.");

        System.out.print("Brand: ");
        String brand = input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        int ram = Menu.requestNumbericalData("Amount of RAM (in GB):", input);
        /*System.out.print("Amount of ram (in GB): ");
        int ram = Integer.parseInt(input.nextLine());*/
        input.nextLine();

        System.out.print("Processor brand: ");
        String processorBrand = input.nextLine();

        System.out.println("Processor model/name: ");
        String processorName = input.nextLine();

        System.out.print("Processor Number of cores: ");
        int processorNumCores = Integer.parseInt(input.nextLine());
        
        input.nextLine();

        System.out.print("Processor max speed: ");
        double maxSpeed = Double.parseDouble(input.nextLine());
        
        input.nextLine();

        System.out.print("Storage (in GB): ");
        int storage = Integer.parseInt(input.nextLine());
        
        input.nextLine();

        // grpahics card  price screen size
        System.out.print("Graphics card: ");
        String graphics = input.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(input.nextLine());
        
        input.nextLine();

        System.out.print("Screen size: ");
        int screenSize = Integer.parseInt(input.nextLine());
        
        input.nextLine();

        System.out.print("How many hours of battery life does this laptop have: ");
        int batteryLife = Integer.parseInt(input.nextLine());
        
        input.nextLine();

        String writeText = String.format("%s,%s,%s,%d,%s,%s,%d,%.1f,%d,%s,%.2f,%s,%s",
                UniqueGenerator.generateUniqueID(4, 4), brand, name, ram,
                processorBrand, processorName, processorNumCores,
                maxSpeed, storage, graphics, price, screenSize, batteryLife);

        /*
                * Stored in text file like this:
                * ID,brand,name,ram,ProcessorBrand,Processor name,ProcessorCores,ProcessorSpeed,storage GB,graphicsCard,price,screenSize
         */
        try {
            ComputerWriter.WriteLaptop(writeText);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void addDesktop(Scanner input) {

        System.out.println("Please fill out the following fields.");

        System.out.print("Brand: ");
        String brand = input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Amount of ram (in GB): ");
        int ram = Integer.parseInt(input.nextLine());

        System.out.print("Processor brand: ");
        String processorBrand = input.nextLine();

        System.out.print("Processor model/name: ");
        String processorName = input.nextLine();

        System.out.print("Processor Number of cores: ");
        int processorNumCores = Integer.parseInt(input.nextLine());

        System.out.print("Processor max speed: ");
        double maxSpeed = Double.parseDouble(input.nextLine());

        System.out.print("Storage (in GB): ");
        int storage = Integer.parseInt(input.nextLine());

        // grpahics card  price screen size
        System.out.print("Graphics card: ");
        String graphics = input.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(input.nextLine());

        System.out.println("Does this have a monitor? (Enter [true] or [false])...");
        String hasMonitor = input.nextLine();

        System.out.println("Does this have speakers? (Enter [true] or [false])...");
        String hasSpeakers = input.nextLine();

        System.out.println("Does this have WIFI and Bluetooth? (Enter [true] or [false])...");
        String hasWifiBT = input.nextLine();

        System.out.println("Does this have a DVD Drive? (Enter [true] or [false])...");
        String DVDDrive = input.nextLine();

        String writeText = String.format("%s,%s,%s,%d,%s,%s,%d,%.1f,%d,%s,%.2f,%s,%s,%s,%s",
                UniqueGenerator.generateUniqueID(4, 4), brand, name, ram,
                processorBrand, processorName, processorNumCores,
                maxSpeed, storage, graphics, price, hasMonitor, hasSpeakers, hasWifiBT, DVDDrive);

        /*
        * Stored in text file like this:
        * ID,brand,name,ProcessorBrand,ProcessorName,ProcessorCores,ProcessorMaxSpeed,StorageInGB,GraphicsCard,Price,Monitor,Speakers,WifiBT,DVD
         */
        try {
            ComputerWriter.WriteDesktop(writeText);

        } catch (IOException ex) {
            //exception handling left as an exercise for the reader
            ex.printStackTrace();
        }

    }

    public static boolean parseBool(String val) {
        if (val.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
}
