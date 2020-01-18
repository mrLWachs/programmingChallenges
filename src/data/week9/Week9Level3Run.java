
package data.week9;

import io.System;
import java.util.Scanner;
import mainpackage.AutoRun;


public class Week9Level3Run  extends AutoRun
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
            "4",
            "5 6",
            "6 6",
            "4 3",
            "5 2"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");  
        String line = lines[0];
        int antoniaTotal = 100;
        int davidTotal   = 100;
        int testCases = Integer.parseInt(line);
        for (int i = 1; i <= testCases; i++) {
            line = lines[i];
            String[] values = line.split("[ ]");
            int antoniaRoll = Integer.parseInt(values[0]);
            int davidRoll   = Integer.parseInt(values[1]);
            if      (antoniaRoll < davidRoll) antoniaTotal -= davidRoll;
            else if (davidRoll < antoniaRoll) davidTotal   -= antoniaRoll;
        }
        System.out.println(antoniaTotal);
        System.out.println(davidTotal);
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
}
