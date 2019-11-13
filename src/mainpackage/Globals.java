
package mainpackage;

import challenge.week1.Week1Level1;
import challenge.week1.Week1Level2;
import challenge.week1.Week1Level3;
import challenge.week1.Week1Level4;
import challenge.week2.Week2Level1;
import challenge.week2.Week2Level2;
import challenge.week2.Week2Level3;
import challenge.week2.Week2Level4;
import data.week1.Week1Level1Run;
import data.week1.Week1Level2Run;
import data.week1.Week1Level3Run;
import data.week1.Week1Level4Run;
import data.week2.Week2Level1Run;
import data.week2.Week2Level2Run;
import data.week2.Week2Level3Run;
import data.week2.Week2Level4Run;

public class Globals 
{

    public static final String TITLE = "Computer Science "
            + "Challenge Club (CSCC at CSHC)";
    public static final String[] WEEKS = {
        "Quit",
        "Week 1 Problems",
        "Week 2 Problems"
    };        
    public static final String[] LEVELS = {
        "Quit",
        "Level 1 Problem",
        "Level 2 Problem",
        "Level 3 Problem",
        "Level 4 Problem"
    };                
    public static Problem[][] problems = {
        { 
            new Week1Level1(), 
            new Week1Level2(),
            new Week1Level3(), 
            new Week1Level4() 
        },
        {  
            new Week2Level1(), 
            new Week2Level2(),
            new Week2Level3(), 
            new Week2Level4() 
        }
    };
    public static Problem[][] runs = {
        { 
            new Week1Level1Run(), 
            new Week1Level2Run(),          
            new Week1Level3Run(), 
            new Week1Level4Run() 
        },
        { 
            new Week2Level1Run(), 
            new Week2Level2Run(),          
            new Week2Level3Run(), 
            new Week2Level4Run() 
        }
    };
    public static final String PROMPT_1 = "Choose a week for the problems...";
    public static final String PROMPT_2 = "Choose a problem for this week...";
    public static Display display = new Display();
    
    public static boolean choose(int week, int level) {
        return display.choose(week, level);
    }
    
    public static void input(int week, int level) {
        problems[week-1][level-1].start();
    }
    
    public static void run(int week, int level) {
        runs[week-1][level-1].start();
    }
}