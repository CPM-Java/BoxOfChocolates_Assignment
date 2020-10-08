
/**
 * Chapter 7 assignment
 * 
 * @author GrayKnight 
 * @version 1/29/03, 1/10/08, 1/23/18 
 */

import java.util.ArrayList;

public class ChocolateBox
{
    // instance variables
    private ArrayList<Chocolate> myChocolateList = new ArrayList<Chocolate>();
    private ArrayList<Chocolate> myConflictingChocolates = new ArrayList<Chocolate>();;
    private String myConflictStr;

    /**
     * Constructor for objects of class ChocolateBox
     * The ChocolatePackagerGUI creates a new ChocolateBox object
     * each time the "box" is shipped.
     */
    public ChocolateBox()
    { 
       Chocolate.resetItemNumber(); //static variable in the Chocolate class
       myConflictStr = "";
    }

    /**
     * creates a new chocolate.
     * 
     * Postcondition: adds the chocolate to myChocolateList, the virtual chocolate box.
     */
    public void addChocolate()
    {
        myChocolateList.add(new Chocolate());
    }


    /**
     * Determines if the chocolates are conflicting.
     * There must not be more Dark Chocolates than Milk Chocolates
     * There must not be more Chocolates with Walnuts than Peanuts
     * There must not be more Fruit Filled Chocolates than Nougat filled or Solid filled
     * 
     * Precondition: myChocolateList.size() != 0
     * Postconditions:
     *   Updates an instance Arraylist of chocolates that are conflicting, myConflictingChocolates.
     *   Updates the instance String myConflictStr with an explanation of the source of conflict.
     * 
     * @return true if the chocolates are conflicting otherwise false
     */ 
    public boolean checkForConflicts()
    {
        // checkForConflicts() method needs work
    return false; //stubbed off
    }
    
    /**
     * Postcondition: Adds conflicting chocolates to the instance String myConflictStr
     * 
     * @return a string showing the chocolates currently conflicting and why they are conflicting
     */
    public String getChocolateConflict()
    {

        return "getChocolateConflict() method needs work.";
    }
    
    /**
     * Postcondition: Finds and removes the freshest (highest time until expiration) of the conflicting chocolates 
     * from myConflictingChocolates and myChocolateList.
     * 
     * @return a string describing the removed chocolate.
     */
    public String removeFreshest()
    {   
        
        return "removeFreshest() method needs work.";
    }
    
    /**
     * @return a string showing the contents of myChocolateList.
     */ 
    public String getBoxContents()
    {
        String boxContentStr = "";
        for(int x = 0; x < myChocolateList.size(); x++)
        {
            boxContentStr += (myChocolateList.get(x)).toString() + "\n";
        }  
        return boxContentStr;
    }

    /**
     * @return an integer representing the number of chocolates in myChocolateList.
     */
    public int getChocolateQuantity()
    {
        return myChocolateList.size();
    }
    
    /**
     * @return myChocolateList.
     */
    public ArrayList<Chocolate> getChocolateList()
    {
        return myChocolateList;
    }
}
