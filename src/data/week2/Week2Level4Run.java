
package data.week2;

import io.System;
import mainpackage.Problem;

public class Week2Level4Run  extends Problem
{

   public void start() {      
        System.out.header("Week 2, Level 4: starting");
        String[] data = {
            "2",
            "10",
            "3 2 2 1 4 7 1 2 0 1",
            "5",
            "1 1 1 1 1"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        System.out.println("\nOutputs:\n");
        
        
        
        System.out.header("Week 2, Level 4: complete");
        System.flush();
   }

}
