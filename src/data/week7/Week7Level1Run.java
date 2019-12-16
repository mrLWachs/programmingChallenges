
package data.week7;

import io.System;
import mainpackage.Problem;


public class Week7Level1Run  extends Problem
{

    public void start() {   
        System.out.header("Week 7, Level 1: starting");          
        String[] lines = { 
           "No inputs!"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");            
        for (int i = 1; i <= 100; i++) {
            if (isFunctional(i)) {
                System.out.println(i);
            }
        }
        System.out.header("Week 7, Level 1: complete");
        System.flush();
    }

    private boolean isFunctional(int number) {
        double answer = (100 * Math.sin(number)) / (Math.pow(number, 3) - 
                (30 * Math.pow(number, 2)) + (200 * number));
        if (answer > 0) return true;
        return false;
    }
    
}
