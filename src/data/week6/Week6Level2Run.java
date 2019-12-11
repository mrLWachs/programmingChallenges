
package data.week6;

import io.System;
import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;

public class Week6Level2Run  extends Problem
{

    public void start() {   
        System.out.header("Week 6, Level 2: starting");          
        String[] lines = { 
           "3",
           "3 2",
           "2 3",
           "2 4"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        String line = lines[0];
        int n = Integer.parseInt(line);
        for (int i = 1; i <= n; i++) {
            line = lines[i];            
            String[] values = line.split("[ ]");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            long answer = knuthsUpArrow(a,b);
            System.out.println(answer);
        }     
        System.out.header("Week 6, Level 2: complete");
        System.flush();
    }

    private long knuthsUpArrow(int a, int b) {
        if (b == 1) return (long)a;
        else return (long)Math.pow(a,knuthsUpArrow(a,b-1));
    }
    
}
