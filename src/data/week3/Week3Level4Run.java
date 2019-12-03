
package data.week3;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;

public class Week3Level4Run  extends Problem
{

    public void start() {   
        System.out.header("Week 3, Level 4: starting");          
        String[] lines = { 
           "under development",         
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n"); 
        ArrayList<String> outputs = new ArrayList<>();        
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String text = lines[testCase];       
            
            
            outputs.add(text);
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        } 
        System.out.header("Week 3, Level 4: complete");
        System.flush();
    }

}
