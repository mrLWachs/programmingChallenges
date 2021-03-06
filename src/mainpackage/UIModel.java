
/** required package class namespace */
package mainpackage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import challenge.week1.Week1Level1;
import challenge.week1.Week1Level2;
import challenge.week1.Week1Level3;
import challenge.week1.Week1Level4;
import challenge.week10.Week10Level1;
import challenge.week10.Week10Level2;
import challenge.week10.Week10Level3;
import challenge.week10.Week10Level4;
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
import challenge.week8.Week8Level1;
import challenge.week8.Week8Level2;
import challenge.week8.Week8Level3;
import challenge.week8.Week8Level4;
import challenge.week9.Week9Level1;
import challenge.week9.Week9Level2;
import challenge.week9.Week9Level3;
import challenge.week9.Week9Level4;
import data.week1.Week1Level1Run;
import data.week1.Week1Level2Run;
import data.week1.Week1Level3Run;
import data.week1.Week1Level4Run;
import data.week10.Week10Level1Run;
import data.week10.Week10Level2Run;
import data.week10.Week10Level3Run;
import data.week10.Week10Level4Run;
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
import data.week8.Week8Level1Run;
import data.week8.Week8Level2Run;
import data.week8.Week8Level3Run;
import data.week8.Week8Level4Run;
import data.week9.Week9Level1Run;
import data.week9.Week9Level2Run;
import data.week9.Week9Level3Run;
import data.week9.Week9Level4Run;

 
/**
 * UIModel.java - description
 *
 * @author Mr. Wachs
 * @since Feb. 3, 2020, 8:58:33 a.m.
 */
public class UIModel 
{

    public final static Font     CONTROL_FONT             = UIManager.getFont("defaultFont");
    public final static Color    CONTROL_BACKGROUND       = UIManager.getColor("Panel.background");
    public final static Color    DEFAULT_FOREGROUND_COLOR = UIManager.getColor("Panel.foreground");
    public final static String   TITLE                    = "Mr. Wachs' Computer Science Challenges";
    public final static int      APP_WIDTH                = 427;
    public final static int      APP_HEIGHT               = 320;
    public final static String   PROMPT_1                 = "Choose a year for the problems...";
    public final static String   PROMPT_2                 = "Choose a week for the problems...";
    public final static String   PROMPT_3                 = "Choose a problem for this week...";
    
    public final static String[] WEEKS                    = {
        "Week 1", 
        "Week 2", 
        "Week 3", 
        "Week 4", 
        "Week 5", 
        "Week 6", 
        "Week 7", 
        "Week 8", 
        "Week 9", 
        "Week 10"
    };
    
    public final static String[] LEVELS                   = {
        "Level 1", 
        "Level 2", 
        "Level 3", 
        "Level 4"
    };    
    
    public final static String[] YEARS                    = {
        "2019-2020"
    };
    public static AutoRun[][] runs = {
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
            new Week5Level1Run(), new Week5Level2Run(), new Week5Level3Run(), new Week5Level4Run()}, {new Week6Level1Run(), new Week6Level2Run(), new Week6Level3Run(), new Week6Level4Run()}, {new Week7Level1Run(), new Week7Level2Run(), new Week7Level3Run(), new Week7Level4Run()}, {new Week8Level1Run(), new Week8Level2Run(), new Week8Level3Run(), new Week8Level4Run()}, {new Week9Level1Run(), new Week9Level2Run(), new Week9Level3Run(), new Week9Level4Run()}, {new Week10Level1Run(), new Week10Level2Run(), new Week10Level3Run(), new Week10Level4Run()}};
    public static Display display = new Display();
    public static Problem[][] problems = {{new Week1Level1(), new Week1Level2(), new Week1Level3(), new Week1Level4()}, {new Week2Level1(), new Week2Level2(), new Week2Level3(), new Week2Level4()}, {new Week3Level1(), new Week3Level2(), new Week3Level3(), new Week3Level4()}, {new Week4Level1(), new Week4Level2(), new Week4Level3(), new Week4Level4()}, {new Week5Level1(), new Week5Level2(), new Week5Level3(), new Week5Level4()}, {new Week6Level1(), new Week6Level2(), new Week6Level3(), new Week6Level4()}, {new Week7Level1(), new Week7Level2(), new Week7Level3(), new Week7Level4()}, {new Week8Level1(), new Week8Level2(), new Week8Level3(), new Week8Level4()}, {new Week9Level1(), new Week9Level2(), new Week9Level3(), new Week9Level4()}, {new Week10Level1(), new Week10Level2(), new Week10Level3(), new Week10Level4()}};

    public static boolean choose(int week, int level) {
        return display.choose(week, level);
    }

    public static void input(int week, int level) {
        problems[week - 1][level - 1].start();
    }

    public static void runAll() {
        for (int week = 0; week < runs.length; week++) {
            for (int level = 0; level < runs[week].length; level++) {
                display.showProblem(week + 1, level + 1);
                runs[week][level].auto(week + 1, level + 1);
            }
        }
    }

    public static void run(int week, int level) {
        runs[week - 1][level - 1].run(week, level);
    }
    
}
