/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tarleton.cashregistermanager.logic;

import java.util.Comparator;

/**
 *
 * @author Zachary Watson
 */
public class ProductSorter implements Comparator<Product> {
 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Product a, Product b) 
    { 
        return Double.compare(a.getPrice(), b.getPrice());
    } 

}
