
package data.week8;

import io.System;
import mainpackage.AutoRun;


public class Week8Level1Run  extends AutoRun
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
        for (int i = 0; i < 14; i++) {
            System.out.println(binomialCoefficient(i));
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private int binomialCoefficient(int n) {
        if (n == 0) return 1;
        else return binomialCoefficient(n-1) * (4*n-2)/n;    
    }
    
}
