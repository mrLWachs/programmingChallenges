
package data.week1;


import io.System;
import mainpackage.Problem;

public class Week1Level1Run  extends Problem
{
    
    public void start() {   
        System.out.header("Week 1, Level 1: starting");
        String[][] cases = {
            {"425","60","-0.01","3","1"},
            {"425","60","-0.01","3","2"},
            {"425","60","-0.01","3","3"}
        }; /* tP, tR, k, q, m */
        System.out.println("Inputs:\n");
        System.out.println(cases.length);
        for (int i = 0; i < cases.length; i++) {
            String line = "";
            for (int j = 0; j < cases[i].length; j++) {
                line += cases[i][j] + " ";
            }
            System.out.println(line);
        }
        System.out.println("\nOutputs:\n");
        for (int c = 0; c < cases.length; c++) {
            int    tP = Integer.parseInt(   cases[c][0] );
            int    tR = Integer.parseInt(   cases[c][1] );
            double k  = Double.parseDouble( cases[c][2] );
            int    q  = Integer.parseInt(   cases[c][3] );
            int    m  = Integer.parseInt(   cases[c][4] );
            double temperature = (double)tP;
            for (int min = 1; min <= m; min++) {                
                temperature = temperature +  k * (((double)tP) - 
                        (((double)tR) + (((double)min) * ((double)q))));
            }
            System.out.println("Case #" + (c+1) + " " + temperature);
        }
        System.out.header("Week 1, Level 1: complete");
        System.flush();
    }
    
}
