
package mainpackage;

import challenge.week1.Week1Level1;
import challenge.week1.Week1Level2;
import challenge.week1.Week1Level3;
import challenge.week1.Week1Level4;
import challenge.week2.Week2Level1;
import challenge.week2.Week2Level2;
import challenge.week2.Week2Level3;
import challenge.week2.Week2Level4;
import challenge.week3.Week3Level1;
import challenge.week3.Week3Level2;
import challenge.week3.Week3Level3;
import challenge.week3.Week3Level4;
import challenge.week4.Week4Level1;
import challenge.week4.Week4Level2;
import challenge.week4.Week4Level3;
import challenge.week4.Week4Level4;
import challenge.week5.Week5Level1;
import challenge.week5.Week5Level2;
import challenge.week5.Week5Level3;
import challenge.week5.Week5Level4;
import challenge.week6.Week6Level1;
import challenge.week6.Week6Level2;
import challenge.week6.Week6Level3;
import challenge.week6.Week6Level4;
import challenge.week7.Week7Level1;
import challenge.week7.Week7Level2;
import challenge.week7.Week7Level3;
import challenge.week7.Week7Level4;
import data.week1.Week1Level1Run;
import data.week1.Week1Level2Run;
import data.week1.Week1Level3Run;
import data.week1.Week1Level4Run;
import data.week2.Week2Level1Run;
import data.week2.Week2Level2Run;
import data.week2.Week2Level3Run;
import data.week2.Week2Level4Run;
import data.week3.Week3Level1Run;
import data.week3.Week3Level2Run;
import data.week3.Week3Level3Run;
import data.week3.Week3Level4Run;
import data.week4.Week4Level1Run;
import data.week4.Week4Level2Run;
import data.week4.Week4Level3Run;
import data.week4.Week4Level4Run;
import data.week5.Week5Level1Run;
import data.week5.Week5Level2Run;
import data.week5.Week5Level3Run;
import data.week5.Week5Level4Run;
import data.week6.Week6Level1Run;
import data.week6.Week6Level2Run;
import data.week6.Week6Level3Run;
import data.week6.Week6Level4Run;
import data.week7.Week7Level1Run;
import data.week7.Week7Level2Run;
import data.week7.Week7Level3Run;
import data.week7.Week7Level4Run;

public class Globals 
{

    public static final String TITLE = "Computer Science "
            + "Challenge Club (CSCC at CSHC)";
    public static final String[] WEEKS = {
        "Quit",
        "Week 1 Problems",
        "Week 2 Problems",
        "Week 3 Problems",
        "Week 4 Problems",
        "Week 5 Problems",
        "Week 6 Problems",
        "Week 7 Problems"
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
        },
        {  
            new Week3Level1(), 
            new Week3Level2(),
            new Week3Level3(), 
            new Week3Level4() 
        },
        {  
            new Week4Level1(), 
            new Week4Level2(),
            new Week4Level3(), 
            new Week4Level4() 
        },
        {  
            new Week5Level1(), 
            new Week5Level2(),
            new Week5Level3(), 
            new Week5Level4() 
        },
        {  
            new Week6Level1(), 
            new Week6Level2(),
            new Week6Level3(), 
            new Week6Level4() 
        },
        {  
            new Week7Level1(), 
            new Week7Level2(),
            new Week7Level3(), 
            new Week7Level4() 
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
        },
        { 
            new Week3Level1Run(), 
            new Week3Level2Run(),          
            new Week3Level3Run(), 
            new Week3Level4Run() 
        },
        { 
            new Week4Level1Run(), 
            new Week4Level2Run(),          
            new Week4Level3Run(), 
            new Week4Level4Run() 
        },
        { 
            new Week5Level1Run(), 
            new Week5Level2Run(),          
            new Week5Level3Run(), 
            new Week5Level4Run() 
        },
        { 
            new Week6Level1Run(), 
            new Week6Level2Run(),          
            new Week6Level3Run(), 
            new Week6Level4Run() 
        },
        { 
            new Week7Level1Run(), 
            new Week7Level2Run(),          
            new Week7Level3Run(), 
            new Week7Level4Run() 
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
