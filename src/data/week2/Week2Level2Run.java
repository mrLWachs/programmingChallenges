
package data.week2;

import io.System;
import mainpackage.AutoRun;

public class Week2Level2Run  extends AutoRun
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
        String[][] data = {
            {"10","12"},  
            {"11","15"}
        };
        System.out.println("Inputs/Outputs:\n");
        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter lower limit of range");
            System.out.println(data[i][0]);
            String lowerInput = data[i][0];
            System.out.println("Enter upper limit of range");
            System.out.println(data[i][1]);
            String upperInput = data[i][1];
            int lower    = Integer.parseInt(lowerInput);
            int upper    = Integer.parseInt(upperInput);
            int rsaCount = 0;
            final int MAX_DIVISORS = 4;        
            for (int number = lower; number <= upper; number++) {
                int divisorCount = 0;
                for (int divisor = 1; divisor <= number; divisor++) {
                    if (number % divisor == 0) divisorCount++;
                }
                if (divisorCount == MAX_DIVISORS) rsaCount++;
            }
            System.out.println("The number of RAS numbers between " +
                    lower + " and " + upper + " is " + rsaCount + "\n");
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

}
