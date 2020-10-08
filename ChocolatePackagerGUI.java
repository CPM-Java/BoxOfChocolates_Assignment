
/**
 * GUI for the Chocolate Box chapter 7.
 * 
 * @author GrayKnight 
 * @version 1/29/03, 1/10/08, 1/23/18 
 */

import javax.swing.*;
import java.awt.*;  //these must be imported for GUI
import java.awt.event.*;
import java.awt.Color;

public class ChocolatePackagerGUI extends JPanel
{
    // instance variables and GUI objects
    private JTextArea boxArea, conflictsArea, removedArea;
    private JLabel spaceFiller, shipLbl;
    private FinalInspector fi = new FinalInspector();
    private JButton fillBoxBtn, conflictBtn, removeBtn;
    private ChocolateBox myChocolateBox;
    private final int CAPACITY = 9;
    private int boxNum = 1;

    /**
     * Constructor for objects of class drawkcabGUI
     */
    public ChocolatePackagerGUI()
    {
        myChocolateBox = new ChocolateBox();
        
        ButtonListener Listener = new ButtonListener();
        Font font = new Font("courier", Font.BOLD, 24);
        
        spaceFiller = new JLabel();
        spaceFiller.setPreferredSize(new Dimension(80,20));
        spaceFiller.setBackground(Color.BLACK);
        add(spaceFiller);
        
        shipLbl = new JLabel("Fill the Box with Chocolates.");
        shipLbl.setPreferredSize(new Dimension(580,30));
        shipLbl.setBackground(Color.BLACK);
        shipLbl.setForeground(Color.WHITE);
        shipLbl.setFont(font);
        add(shipLbl);
        
        String twoLines = "Fill\nBox";
        fillBoxBtn = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
        fillBoxBtn.addActionListener(Listener);
        fillBoxBtn.setPreferredSize(new Dimension(80,80));
        fillBoxBtn.setOpaque(true);
        fillBoxBtn.setBorderPainted(false);
        fillBoxBtn.setBackground(Color.RED);
        add(fillBoxBtn);
        
        boxArea = new JTextArea();
        boxArea.setEditable(false);
        boxArea.setPreferredSize(new Dimension(580,160));
        add(boxArea);
        
        twoLines = "View\nConflicts";
        conflictBtn = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
        conflictBtn.addActionListener(Listener);
        conflictBtn.setPreferredSize(new Dimension(80,80));
        conflictBtn.setOpaque(true);
        conflictBtn.setBorderPainted(false);
        conflictBtn.setBackground(Color.WHITE);
        add(conflictBtn);
        
        conflictsArea = new JTextArea();
        conflictsArea.setEditable(false);
        conflictsArea.setForeground(Color.RED);
        conflictsArea.setPreferredSize(new Dimension(580,160));
        add(conflictsArea);
        
        twoLines = "Remove\nConflict";
        removeBtn = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
        removeBtn.addActionListener(Listener);
        removeBtn.setPreferredSize(new Dimension(80,80));
        removeBtn.setOpaque(true);
        removeBtn.setBorderPainted(false);
        removeBtn.setBackground(Color.WHITE);
        add(removeBtn);
        
        removedArea = new JTextArea();
        removedArea.setEditable(false);
        removedArea.setPreferredSize(new Dimension(580,160));
        add(removedArea);
 
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(680, 530));//w,h
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {  
           int numChocs = myChocolateBox.getChocolateQuantity();
           
           //The "Fill Box" button was clicked
           if (event.getSource() == fillBoxBtn&& 
               fillBoxBtn.getBackground() == Color.RED)                
           {   
                if(numChocs == 0 || !myChocolateBox.checkForConflicts())
                {
                    for(int ct = numChocs; ct < CAPACITY; ct++) myChocolateBox.addChocolate();                
                    boxArea.setText("Box " + boxNum + " Contents:\n" + myChocolateBox.getBoxContents());
                }
                if(myChocolateBox.checkForConflicts()) // <--* 
                {
                    shipLbl.setText("Click 'View Conflicts'");
                    conflictBtn.setBackground(Color.RED);
                    fillBoxBtn.setBackground(Color.WHITE);                    
                }
                else if(myChocolateBox.getChocolateQuantity() == CAPACITY)
                {
                    removeBtn.setBackground(Color.RED);
                    String twoLines = "Final\nInspection";
                    removeBtn.setText("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
                    shipLbl.setText("Click 'Final Inspection'");
                    fillBoxBtn.setBackground(Color.WHITE);
                    conflictsArea.setText("Conflicts:\n");
                }
                removedArea.setText("Removed:\n");
           }
           
           //The "View Conflicts" button was clicked
           if (event.getSource() == conflictBtn)
           {
               if(myChocolateBox.checkForConflicts())// <--*
               {
                   conflictsArea.setText("Conflicts:\n" + 
                      myChocolateBox.getChocolateConflict());// <--*
                   conflictBtn.setBackground(Color.WHITE);
                   removeBtn.setBackground(Color.RED);
                   shipLbl.setText("Click 'Remove Conflict'");
                   
                }
               else if(numChocs < CAPACITY)
               {  // No Conflict
                   conflictsArea.setText("Conflicts:\n");
                   conflictBtn.setBackground(Color.WHITE);
                   removeBtn.setBackground(Color.WHITE);
                   shipLbl.setText("Click 'Fill Box'");
                   fillBoxBtn.setBackground(Color.RED);
                } 
           }
           
           //The "Remove Conflict" button was clicked
           if (event.getSource() == removeBtn && 
               removeBtn.getBackground() == Color.RED) 
           {               
               if (myChocolateBox.checkForConflicts()) // <--*
               {
                   removedArea.setText("Removed:\n" + myChocolateBox.removeFreshest()); // <--*
                   boxArea.setText("Box " + boxNum + " Contents:\n" + myChocolateBox.getBoxContents());
                   
                   //The "View Conflicts" button is virtually clicked to check for more conflicts
                   conflictBtn.doClick();
                }   
                
                else qualityControl();
           }
        }// end of actionPerformed() method
        
    }//end of ButtonListener class

    //private helper method
    private void qualityControl()
    {   
        String finalResults = fi.finalInspection(myChocolateBox);
        if(finalResults.equals("Pass"))
        {
            boxArea.setText("\n\n  * Chocolate Box Number " + boxNum + " Has Been Shipped! *");
            conflictsArea.setText("Conflicts:\n");
            removedArea.setText("Removed:\n");
            shipLbl.setText("Fill the Box with Chocolates.");
            
        }
        else
        {
            shipLbl.setText("Chocolate Box " + boxNum + " Has Been Destroyed!");
            removedArea.setText("CONFLICT DETECTED BY FINAL INSPECTOR:\n  *" + 
                 finalResults + "\nYou have at least one logic error in\n" +  
                 "   public boolean checkForConflicts()");
        }
        
        fillBoxBtn.setBackground(Color.RED);
        removeBtn.setBackground(Color.WHITE);
        String twoLines = "Remove\nConflict";
        removeBtn.setText("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>"); 
        myChocolateBox = new ChocolateBox();
        boxNum++;
    }
        
}//end of ChocolatePackagerGUI class
