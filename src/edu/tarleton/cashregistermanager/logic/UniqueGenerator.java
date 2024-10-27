package edu.tarleton.cashregistermanager.logic;

import java.util.Random;

public class UniqueGenerator {
    
    public static String generateUniqueID(int numCharacters, int integers) {
        
        String output = "";
        Random rand = new Random();
        
        for (int i = 0; i < numCharacters; i++) {
            char c = (char)('a' + rand.nextInt(26));
            output += String.format("%c", c);
        }
        
        for (int i = 0; i < integers; i++) {
            output += String.format("%d", rand.nextInt(8));
        }
        
        return output;
    }
    
}
