
/**
 * Chocolates are randomly assigned strings representing 
 * Chocolate Type, Nuts and Filling Type.
 * Time until expiration is represented by a randomly generated
 * integer between 1 and 12 representing months
 * 
 * @author GrayKnight 
 * @version 1/29/03, 1/10/08, 1/23/18 
 */

import java.util.Random;

public class Chocolate
{
    // instance variables
    private String myFilling;
    private String myChocolateType;
    private String myNutType;
    private int myExpiration; //months
    private Random r;
    private int myItemNumber;
    private static int ItemNumber = 0;

    /**
     * Constructor for objects of class Chocolate
     */
    public Chocolate()
    {
        r = new Random();
        setFilling();
        setNutType();
        setChocolateType();
        setExpirationDate();
        ItemNumber++;
        myItemNumber = ItemNumber;
    }
    
//****************Getter (Accessor) Methods****************
    public String getFilling()
    {
        return myFilling;
    }

    public String getNutType()
    {
        return myNutType;
    }

    public String getChocolateType()
    {
        return myChocolateType;
    }

    public double getExpiration()
    {
        return myExpiration;
    }
    
//****************toString Method****************
    public String toString()
    {
        String chocolateDescription = myChocolateType + " chocolate #" + myItemNumber + " contains " + 
                                myNutType + ", " + 
                                myFilling + " filling, " +
                                "and will expire in " +  myExpiration + " months.";
        return chocolateDescription;
    }
    
//****************Private Helper Methods****************
    private void setFilling()
    {
        int x = r.nextInt(4);

        if (x == 0) myFilling = "FRUIT";
        else if (x == 1 ) myFilling = "SOLID CHOCOLATE";
            else myFilling = "NOUGAT";
    }

       private void setNutType()
    {
        int x = r.nextInt(4);

        if (x == 0) myNutType = "PEANUTS";
        else if (x == 1 ) myNutType = "WALNUTS";
            else myNutType = "NO NUTS";
    }
    
//****************Setter (Mutator) Methods****************
    private void setChocolateType()
    {
        int x = r.nextInt(3);

        if (x == 0) myChocolateType = "DARK";
        else myChocolateType = "MILK";

    }

    private void setExpirationDate()
    {
        //months until freshness is no longer guaranteed
        myExpiration = (int)(r.nextDouble() * 12 + 1);
    }
    
//****************Static Methods****************
    public static int getItemNumber()
    {
        return ItemNumber;
    }
    public static void resetItemNumber()
    {
        ItemNumber = 0;
    }
}
