
package data.week9;

import io.System;
import java.util.Scanner;
import mainpackage.AutoRun;


public class Week9Level4Run  extends AutoRun
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
            "2",
            "4",
            "0"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");
        String line = lines[0];
        int i = 0;
        while (!line.equals("0")) {
            int n = Integer.parseInt(line);
            makeRuler(n,(i+1));
            i++;
            line = lines[i];
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void makeRuler(int units, int count) {
        System.out.println("=CASE " + count + "=");
        
        
        
    }
    
}
