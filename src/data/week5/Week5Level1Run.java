
package data.week5;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;

public class Week5Level1Run  extends AutoRun
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
           "4"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {      
            String line = lines[i];
            int n = Integer.parseInt(line);
            if      (n == 1)  outputs.add("1");
            else if (n == 2)  outputs.add("2");
            else if (n == 3)  outputs.add("2");
            else if (n == 4)  outputs.add("3");
            else if (n == 5)  outputs.add("3");
            else if (n == 6)  outputs.add("4");
            else if (n == 7)  outputs.add("4");
            else if (n == 8)  outputs.add("5");
            else if (n == 9)  outputs.add("5");
            else if (n == 10) outputs.add("6");
        }      
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

}
