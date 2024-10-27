package edu.tarleton.cashregistermanager.logic;

import java.util.Comparator;

/**
 * Represents any product.
 *
 * @author Zachary Watson
 */
public class Product implements Comparable<Product> {

	protected final String ID;
	protected String brand;
	protected String name;
	protected double price;

    public Product(String ID, String brand, String name, double price) {
        this.ID = ID;
        this.brand = brand;
    	this.name = name;
        this.price = price;
    }
    
    public String getID() {
    	return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        Product p = (Product) o;
        if (this.price == p.getPrice() && this.name.equals(p.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Product t) {
        return Double.compare(price, t.price);
    }
}
