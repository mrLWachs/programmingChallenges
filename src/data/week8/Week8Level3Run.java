
package data.week8;

import io.System;
import mainpackage.AutoRun;


public class Week8Level3Run  extends AutoRun
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
           "1987",
           "999"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");            
        for (int testCase = 0; testCase < lines.length; testCase++) {            
            String line = lines[testCase];
            int year = Integer.parseInt(line);
            distinctYears(year);             
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    private void distinctYears(int year) {
        do {            
            year++;
        } while (isNotDistinct("" + year));
        System.out.println(year);
    }

    private boolean isNotDistinct(String year) {
        char[] digits = year.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            char digit = digits[i];
            if (isInside(digit,digits,i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInside(char digit, char[] digits, int spotToSkip) {
        for (int i = 0; i < digits.length; i++) {
            if (i != spotToSkip) {
                if (digits[i] == digit) return true;
            }
        }
        return false;
    }

    
}
