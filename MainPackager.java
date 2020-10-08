
/**
 * 
 * @GrayKnight
 * @Chocolate factory assignment 11/27/10 2/8/18
 */
import javax.swing.JFrame;

public class MainPackager
{
	public static void main(String[] ArgsgrA)
	{
	    ChocolatePackagerGUI gk = new ChocolatePackagerGUI();
	    
	    JFrame buttonFrame = new JFrame("CPM Chocolate Factory 2018");
	    buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    buttonFrame.getContentPane().add(gk);
	    buttonFrame.pack();
	    buttonFrame.setLocation(225,30);
	    buttonFrame.setResizable(false);
	    buttonFrame.setVisible(true);
	    
	}
}