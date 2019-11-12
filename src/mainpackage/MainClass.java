
package mainpackage;

import challenge.week1.Week1Level1;
import challenge.week1.Week1Level2;
import challenge.week1.Week1Level3;
import challenge.week1.Week1Level4;
import challenge.week2.Week2Level1;
import challenge.week2.Week2Level2;
import data.week1.Week1Level1Run;
import data.week1.Week1Level2Run;
import data.week2.Week2Level1Run;
import data.week2.Week2Level2Run;
import javax.swing.JOptionPane;

public class MainClass 
{

    public static void main(String[] args) {
        final String TITLE = "Computer Science Challenge Club (CSCC at CSHC)";
        final String[] WEEKS = {
            "Quit",
            "Week 1 - problems",
            "Week 2 - problems",
            "Week 3 - problems (coming soon...)"
        };        
        final String[] LEVELS = {
            "Quit",
            "Level 1 - Problem",
            "Level 2 - Problem",
            "Level 3 - Problem",
            "Level 4 - Problem"
        };        
        final String PROMPT_1 = "Choose a week for the problems...";
        final String PROMPT_2 = "Choose a problem for this week...";
        Display display = new Display();
        String choice = "";
        do {
            choice = JOptionPane.showInputDialog(null, 
                PROMPT_1, TITLE, JOptionPane.QUESTION_MESSAGE, null, 
                WEEKS, WEEKS[0]).toString();
            if      (choice == null)          System.exit(0);
            else if (choice.equals(WEEKS[0])) System.exit(0);
            else if (choice.equals(WEEKS[1])) {
                choice = JOptionPane.showInputDialog(null, 
                    PROMPT_2, TITLE, JOptionPane.QUESTION_MESSAGE, null, 
                    LEVELS, LEVELS[0]).toString();
                if      (choice == null)           System.exit(0);
                else if (choice.equals(LEVELS[0])) System.exit(0);
                else if (choice.equals(LEVELS[1])) {         
                    if (display.choose(1,1)) new Week1Level1().main(args);
                    else                     new Week1Level1Run();
                }
                else if (choice.equals(LEVELS[2])) {
                    if (display.choose(1,2)) new Week1Level2().main(args);
                    else                     new Week1Level2Run();
                }
                else if (choice.equals(LEVELS[3])) {
                    if (display.choose(1,3)) new Week1Level3().main(args);
                    else                     new Week1Level1Run();
                } 
                else if (choice.equals(LEVELS[4])) {
                    if (display.choose(1,4)) new Week1Level4().main(args);
                    else                     new Week1Level1Run();
                } 
            }
            else if (choice.equals(WEEKS[2])) {
                choice = JOptionPane.showInputDialog(null, 
                    PROMPT_2, TITLE, JOptionPane.QUESTION_MESSAGE, null, 
                    LEVELS, LEVELS[0]).toString();
                if      (choice == null)           System.exit(0);
                else if (choice.equals(LEVELS[0])) System.exit(0);
                else if (choice.equals(LEVELS[1])) {         
                    if (display.choose(2,1)) new Week2Level1().main(args);
                    else                     new Week2Level1Run();
                }
                else if (choice.equals(LEVELS[2])) {         
                    if (display.choose(2,2)) new Week2Level2().main(args);
                    else                     new Week2Level2Run();
                }
            }
            else if (choice.equals(WEEKS[3])) System.exit(0); 
        } while (true);
    }

}
