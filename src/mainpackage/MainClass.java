
package mainpackage;

import challenge.week1.Week1Level1;
import challenge.week1.Week1Level2;
import challenge.week1.Week1Level3;
import challenge.week1.Week1Level4;
import data.Week1Level1Run;
import javax.swing.JOptionPane;

public class MainClass 
{

    public static void main(String[] args) {
        final String TITLE = "Computer Science Challenge Club (CSCC at CSHC)";
        final String[] DAYS = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday"
        };
        final String[] WEEKS = {
            "Quit",
            "Week 1 - problems",
            "Week 2 - problems"
        };        
        final String[] LEVELS = {
            "Quit",
            "Level 1 - " + DAYS[0] + " Problem",
            "Level 2 - " + DAYS[1] + " Problem",
            "Level 3 - " + DAYS[2] + " Problem",
            "Level 4 - " + DAYS[3] + " Problem"
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
                    if (display.choose(1,DAYS[0])) new Week1Level1().main(args);
                    else                           new Week1Level1Run();
                }
                else if (choice.equals(LEVELS[2])) {
                    if (display.choose(1,DAYS[1])) new Week1Level2().main(args);
                    else                           new Week1Level1Run();
                }
                else if (choice.equals(LEVELS[3])) {
                    if (display.choose(1,DAYS[2])) new Week1Level3().main(args);
                    else                           new Week1Level1Run();
                } 
                else if (choice.equals(LEVELS[4])) {
                    if (display.choose(1,DAYS[3])) new Week1Level4().main(args);
                    else                           new Week1Level1Run();
                } 
            }
            else if (choice.equals(WEEKS[2])) System.exit(0); 
        } while (true);
    }

}
