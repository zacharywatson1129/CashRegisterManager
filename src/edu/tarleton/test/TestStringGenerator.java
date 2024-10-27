/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tarleton.test;

import edu.tarleton.cashregistermanager.logic.UniqueGenerator;

/**
 *
 * @author Zachary
 */
public class TestStringGenerator {
    
    public static void main(String[] args) {
        System.out.println("Random string generated: ");
        System.out.println(UniqueGenerator.generateUniqueID(5, 3));
    }
    
}
