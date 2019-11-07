
package mainpackage;

import challenge.week1.Level1Monday;
import challenge.week1.Level2Tuesday;
import challenge.week1.Level3Wednesday;
import challenge.week1.Level4Thursday;
import javax.swing.JOptionPane;

public class MainClass 
{

    public static void main(String[] args) {
        final String[] SELECTIONS = {
            "Quit",
            "Level 1 - Monday Problem",
            "Level 2 - Tuesday Problem",
            "Level 3 - Wednesday Problem",
            "Level 4 - Thursday Problem"
        };
        String choice = "";
        do {
            choice = JOptionPane.showInputDialog(null, 
                "Choose a problem...", 
                "Computer Science Challenge Club (CSCC at CSHC)", 
                JOptionPane.QUESTION_MESSAGE, null, SELECTIONS, 
                SELECTIONS[0]).toString();
            if      (choice == null) System.exit(0);
            else if (choice.equals(SELECTIONS[1])) new Level1Monday();
            else if (choice.equals(SELECTIONS[2])) new Level2Tuesday();
            else if (choice.equals(SELECTIONS[3])) new Level3Wednesday(); 
            else if (choice.equals(SELECTIONS[4])) new Level4Thursday(); 
        } while (!choice.equals(SELECTIONS[0]));
    }

}
