package edu.tarleton.cashregistermanager.logic;

public class Processor {
	private String brand;
	private String name;
    private double maxSpeed; // measured in GHz
    private int numCores;

    public Processor(String brand, String name, double maxSpeed, int numCores) {
    	this.brand = brand;
    	this.name = name;
        this.maxSpeed = maxSpeed;
        this.numCores = numCores;
    }
    
    public String getBrand() {
    	return brand;
    }
    
    public String getName() {
    	return name;
    }
    
    public double getMaxSpeed() {
    	return maxSpeed;
    }
    
    public String getNumCores() {
    	if (numCores == 2) {
    		return "dual";
    	}
    	if (numCores == 4) {
    		return "quad";
    	}
    	return String.format("%d", numCores);
    }
}
