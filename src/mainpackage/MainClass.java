
package mainpackage;

import challenge.week1.Level1Monday;
import challenge.week1.Level2Tuesday;
import challenge.week1.Level3Wednesday;
import challenge.week1.Level4Thursday;
import javax.swing.JOptionPane;

public class MainClass 
{

    public static void main(String[] args) {
        final String TITLE = "Computer Science Challenge Club (CSCC at CSHC)";
        final String[] WEEK_SELECTIONS = {
            "Quit",
            "Week 1 - problems",
            "Week 2 - problems"
        };        
        final String[] DAY_SELECTIONS = {
            "Quit",
            "Level 1 - Monday Problem",
            "Level 2 - Tuesday Problem",
            "Level 3 - Wednesday Problem",
            "Level 4 - Thursday Problem"
        };
        final String PROMPT_1 = "Choose a week for the problems...";
        final String PROMPT_2 = "Choose a problem for this week...";
        String choice = "";
        do {
            choice = JOptionPane.showInputDialog(null, 
                PROMPT_1, TITLE, JOptionPane.QUESTION_MESSAGE, null, 
                WEEK_SELECTIONS, WEEK_SELECTIONS[0]).toString();
            if      (choice == null)               System.exit(0);
            else if (choice.equals(WEEK_SELECTIONS[0])) System.exit(0);
            else if (choice.equals(WEEK_SELECTIONS[1])) {
                choice = JOptionPane.showInputDialog(null, 
                    PROMPT_2, TITLE, JOptionPane.QUESTION_MESSAGE, null, 
                    DAY_SELECTIONS, DAY_SELECTIONS[0]).toString();
                if      (choice == null)                   System.exit(0);
                else if (choice.equals(DAY_SELECTIONS[0])) System.exit(0);
                else if (choice.equals(DAY_SELECTIONS[1])) {                    
                    new Display("Week 1: " + DAY_SELECTIONS[1], 
                            "Week1Monday.png");
                    new Level1Monday().main(args);
                }
                else if (choice.equals(DAY_SELECTIONS[2])) {
                    new Display("Week 1: " + DAY_SELECTIONS[2], 
                            "Week1Tuesday.png");
                    new Level2Tuesday().main(args);
                }
                else if (choice.equals(DAY_SELECTIONS[3])) {
                    new Display("Week 1: " + DAY_SELECTIONS[3], 
                            "Week1Wednesday.png");
                    new Level3Wednesday().main(args);
                } 
                else if (choice.equals(DAY_SELECTIONS[4])) {
                    new Display("Week 1: " + DAY_SELECTIONS[4], 
                            "Week1Thursday.png");
                    new Level4Thursday().main(args);
                } 
            }
            else if (choice.equals(WEEK_SELECTIONS[2])) System.exit(0); 
        } while (true);
    }

}
