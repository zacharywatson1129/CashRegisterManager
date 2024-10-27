package edu.tarleton.cashregistermanager.logic;

/**
 * A helper class with functions useful for Strings.
 * @author Zachary Watson
 */
public class StringHelper {
    public static String Multiply(char repeat, int num)
    {
        String output = "";
        for (int i = 0; i < num; i++)
        {
            output += repeat;
        }
        return output;
    }

    public static String Multiply(char repeat, int num, char endCharacter)
    {
        String output = "";
        for (int i = 0; i < num; i++)
        {
            output += repeat;
        }
        output += endCharacter;
        return output;
    }
}
