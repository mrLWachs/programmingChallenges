
package data.week9;

import io.System;
import java.util.Scanner;
import mainpackage.AutoRun;


public class Week9Level1Run  extends AutoRun
{
    
    public void auto(int week, int level) {
        start(week, level);
        System.autoFlush();
    }
    
    public void run(int week, int level) {
        start(week, level);
        System.flush();
    }

    private void start(int week, int level) {   
        System.out.header("Week " + week + ", Level " + level + ": starting"); 
        String[] lines = { 
            "1",
            "7",
            "8",
            "31",
            "2",
            "18"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        for (int lineCount = 0; lineCount < lines.length; lineCount++) {    
            int month = Integer.parseInt(lines[lineCount]);
            lineCount++;
            int day   = Integer.parseInt(lines[lineCount]);
            check(month,day); 
        }        
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void check(int month, int day) {
        final int FEBRUARY = 2;
        final int DAY      = 18;
        if      (month == FEBRUARY && day == DAY) System.out.println("Special");
        else if (month == FEBRUARY && day <  DAY) System.out.println("Before");
        else if (month < FEBRUARY)                System.out.println("Before");
        else if (month == FEBRUARY && day >  DAY) System.out.println("After");
        else if (month >  FEBRUARY)               System.out.println("After"); 
    }
    
}
