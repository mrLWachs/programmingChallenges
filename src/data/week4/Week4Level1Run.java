
package data.week4;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;

public class Week4Level1Run  extends AutoRun
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
           "20000",
           "60",
           "0.069"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {      
            String line = lines[i];
            int p = Integer.parseInt(line);    
            i++;
            line = lines[i];
            int n = Integer.parseInt(line);
            i++;
            line = lines[i];
            double r = Double.parseDouble(line);        
            double payment = p * r * Math.pow((1 + r),n) / (Math.pow((1 + r),n) - 1);
            outputs.add("The monthy payment is $" + payment); 
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

}
