
package mainpackage;

import challenge.week1.Level1Monday;
import challenge.week1.Level2Tuesday;
import challenge.week1.Level3Wednesday;
import challenge.week1.Level4Thursday;
import data.Week1MondayRun;
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
        Display display = new Display();
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
                    if (display.choose(1,"Monday") == JOptionPane.YES_OPTION) {
                        new Level1Monday().main(args);
                    }
                    else {
                        new Week1MondayRun();
                    }
                }
                else if (choice.equals(DAY_SELECTIONS[2])) {
                    if (display.choose(1,"Tuesday") == JOptionPane.YES_OPTION) {
                        new Level2Tuesday().main(args);
                    }
                    else {
                        new Week1MondayRun();
                    }
                }
                else if (choice.equals(DAY_SELECTIONS[3])) {
                    if (display.choose(1,"Wednesday") == JOptionPane.YES_OPTION) {
                        new Level3Wednesday().main(args);
                    }
                    else {
                        new Week1MondayRun();
                    }
                } 
                else if (choice.equals(DAY_SELECTIONS[4])) {
                    if (display.choose(1,"Thursday") == JOptionPane.YES_OPTION) {
                        new Level4Thursday().main(args);
                    }
                    else {
                        new Week1MondayRun();
                    }
                } 
            }
            else if (choice.equals(WEEK_SELECTIONS[2])) System.exit(0); 
        } while (true);
    }

     
    

}
