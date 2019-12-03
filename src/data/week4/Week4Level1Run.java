
package data.week4;

import io.System;
import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;

public class Week4Level1Run  extends Problem
{

    public void start() {   
        System.out.header("Week 4, Level 1: starting");          
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
        System.out.header("Week 4, Level 1: complete");
        System.flush();
    }

}
