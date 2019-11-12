
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

    
    public int choose(int week, String day) {
        String title = "";
        if (day.equals("Monday")) {
            title = "Week " + week + " - Monday Problem (Level 1)";
        }
        else if (day.equals("Tuesday")) {
            title = "Week " + week + " - Tuesday Problem (Level 2)";
        }
        else if (day.equals("Wednesday")) {
            title = "Week " + week + " - Wednesday Problem (Level 3)";
        }
        else if (day.equals("Thursday")) {
            title = "Week " + week + " - Thursday Problem (Level 4)";
        }
        String filename = "/media/Week" + week + day + ".png";
        Icon icon = new ImageIcon(getClass().getResource(filename));
        String[] choices = {
          "Input Test Values","Pre-set Test Values"  
        };        
        return JOptionPane.showOptionDialog(null, "", title, 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, icon, choices, choices[0]);
    }
    
}
