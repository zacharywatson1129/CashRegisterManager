package edu.tarleton.cashregistermanager.logic;

public abstract class Computer extends Product {

    protected final Processor processor;
    protected int ram = 8; // RAM measured in GB
    protected final int storage; // Memory measured in GB, amounts over 1000 GB will be returned in TB.
    protected final String gc;
    
    public String getGraphicsCard() {
    	return gc;
    }
    
    
    public String getStorage() {
        if (storage > 1000) {
            return String.format("%d TB", storage / 1000);
        } 
        else {
            return String.format("%d GB", storage);
        }
    }

    public Computer(String ID, String brand, String name, double price, Processor proc, int storage, String gc, int ram) {
        super(ID, brand, name, price);
        this.processor = proc;
        this.storage = storage;
        this.gc = gc;
        this.ram = ram;
    }
   
    public abstract String featuresFormat();
    public abstract String descriptionFormat();

    public String getCSVFormat() {
        StringBuilder builder = new StringBuilder();
        
        // ID,brand,name,processorID,motherboardID,graphicsCardID,RAM
        builder.append(this.getID());
        builder.append(',');
        builder.append(this.getBrand());
        builder.append(',');
        builder.append(this.getName());
        builder.append(',');
        
        
        String output = builder.toString();
        return output;
    }
    
    public Processor getProcessor() {
    	return processor;
    }
}
