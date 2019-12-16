
package data.week7;

import io.System;
import mainpackage.AutoRun;


public class Week7Level1Run  extends AutoRun
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
           "No inputs!"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");            
        for (int i = 1; i <= 100; i++) {
            if (isFunctional(i)) {
                System.out.println(i);
            }
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private boolean isFunctional(int number) {
        double answer = (100 * Math.sin(number)) / (Math.pow(number, 3) - 
                (30 * Math.pow(number, 2)) + (200 * number));
        if (answer > 0) return true;
        return false;
    }
    
}
