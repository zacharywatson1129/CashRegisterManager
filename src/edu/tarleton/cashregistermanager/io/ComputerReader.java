package edu.tarleton.cashregistermanager.io;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import edu.tarleton.cashregistermanager.logic.Computer;
import edu.tarleton.cashregistermanager.logic.Desktop;
import edu.tarleton.cashregistermanager.logic.Laptop;
import edu.tarleton.cashregistermanager.logic.Processor;

public class ComputerReader {

    public ArrayList<Computer> readComputers() {
        ArrayList<Computer> output = new ArrayList<>();
        Path path = Paths.get("laptops.txt");
        try (BufferedReader br = Files.newBufferedReader(path)) {

            String s = "";
            while ((s = br.readLine()) != null) {
                String line[] = s.split(",");

                Laptop currentLaptop;

                String ID = line[0];
                String brand = line[1];
                String name = line[2];
                int ram = Integer.parseInt(line[3]);
                String processorBrand = line[4];
                String processorName = line[5];
                int processorCores = Integer.parseInt(line[6]);
                double processorMaxSpeed = Double.parseDouble(line[7]);
                int storage = Integer.parseInt(line[8]);
                String graphics = line[9];
                double price = Double.parseDouble(line[10]);
                int screenSize = Integer.parseInt(line[11]);
                int battery = Integer.parseInt(line[12]);

                currentLaptop = new Laptop(ID, brand, name, ram, new Processor(processorBrand, processorName, processorMaxSpeed, processorCores), storage, graphics,
                        price, screenSize, battery);
                output.add(currentLaptop);
                // brand, name, price, description

            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        path = Paths.get("desktops.txt");
        try (BufferedReader br = Files.newBufferedReader(path)) {

            String s = "";
            while ((s = br.readLine()) != null) {
                String line[] = s.split(",");

                Desktop currentDesktop;

                String ID = line[0];
                String brand = line[1];
                String name = line[2];
                int ram = Integer.parseInt(line[3]);
                String processorBrand = line[4];
                String processorName = line[5];
                int processorCores = Integer.parseInt(line[6]);
                double processorMaxSpeed = Double.parseDouble(line[7]);
                int storage = Integer.parseInt(line[8]);
                String graphics = line[9];
                double price = Double.parseDouble(line[10]);
                boolean includesMonitor = parseStringBool(line[11]);
                boolean includesSpeakers = parseStringBool(line[12]);
                boolean includesWifiBT = parseStringBool(line[13]);
                boolean includesDVD = parseStringBool(line[14]);
                
                
                currentDesktop = new Desktop(ID, brand, name, ram, storage,
                new Processor(processorBrand, processorName,processorMaxSpeed,processorCores),
                graphics,price,includesMonitor,includesSpeakers,includesWifiBT,includesDVD);
                
                /*
                * Stored in text file like this:
                * ID,brand,name,RAM,ProcessorBrand,ProcessorName,ProcessorCores,ProcessorMaxSpeed,StorageInGB,GraphicsCard,Price,Monitor,Speakers,WifiBT,DVD
                */
                output.add(currentDesktop);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output;
    }
    
    public boolean parseStringBool(String val) {
        if (val.equals("true")) {
            return true;
        }
        else {
            return false;
        }
    }

}
