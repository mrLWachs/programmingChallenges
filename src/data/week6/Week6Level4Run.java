
package data.week6;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;

public class Week6Level4Run  extends Problem
{

    public void start() {   
        System.out.header("Week 6, Level 4: starting");          
        String[] lines = { 
           ""
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        outputs.add("");
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week 6, Level 4: complete");
        System.flush();
    }

}