
/** required package class namespace */
package mainpackage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

 
/**
 * Display.java - description
 *
 * @author Mr. Wachs
 * @since Nov. 7, 2019, 1:07:47 p.m.
 */
public class Display 
{
    
    public boolean choose(int week, int level) {
        String title = "";
        if      (level == 1) title = "Week " + week + " - Monday Problem (Level " + level + ")";
        else if (level == 2) title = "Week " + week + " - Tuesday Problem (Level " + level + ")";
        else if (level == 3) title = "Week " + week + " - Wednesday Problem (Level " + level + ")";
        else if (level == 4) title = "Week " + week + " - Thursday Problem (Level " + level + ")";
        String filename = "/media/Week" + week + "Level" + level + ".png";
        Icon icon = new ImageIcon(getClass().getResource(filename));
        String[] choices = {
          "Input Test Values","Pre-set Test Values"  
        };        
        if (JOptionPane.showOptionDialog(null, "", title, 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, icon, 
                choices, choices[0]) == JOptionPane.YES_OPTION) return true;
        return false;
    }
    
}
