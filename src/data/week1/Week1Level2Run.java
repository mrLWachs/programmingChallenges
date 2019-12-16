
package data.week1;

import io.System;
import mainpackage.AutoRun;

public class Week1Level2Run  extends AutoRun
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
        String[] cases = { "aaa","aab","aabc" };
        System.out.println("Inputs:\n");
        for (int i = 0; i < cases.length; i++) {
            System.out.println(cases[i]);
        }
        System.out.println("\nOutputs:\n");
        for (int i = 0; i < cases.length; i++) {
            int[] counts = new int[3];
            boolean[] counted = new boolean[3];   
            for (int j = 0; j < cases[i].length(); j++) {
                char letter = cases[i].charAt(j);
                if (letter == 'a') {                    
                    counts[0]++;
                    counted[0] = true;
                }
                if (letter == 'b') {
                    counts[1]++;
                    counted[1] = true;
                }
                if (letter == 'c') {
                    counts[2]++;
                    counted[2] = true;
                }                
            }
            String output = "no set";
            if (counted[0] && counted[1] && counted[2]) output = "set: abc";
            if (counts[0] >= 3) output = "set of three: a";
            if (counts[1] >= 3) output = "set of three: b";
            if (counts[2] >= 3) output = "set of three: c";
            System.out.println(output);  
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
}
