
package data.week10;

import io.System;
import mainpackage.AutoRun;


public class Week10Level4Run  extends AutoRun
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
            ""
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        for (int lineCount = 0; lineCount < lines.length; lineCount++) {    
            
            
        }        
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
}
