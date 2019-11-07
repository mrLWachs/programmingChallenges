
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

    public Display(String title, String filename) {
        filename = "/media/" + filename;
        Icon icon = new ImageIcon(getClass().getResource(filename));
        JOptionPane.showMessageDialog(null, "", title, 
                JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
}
