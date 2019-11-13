
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;

public class Week1Level1 extends Problem
{
    
    public static void main(String[] args) {
        new Week1Level1().start();
    }

    public void start()  {
        Scanner input = new Scanner(System.in);     
        String line = input.nextLine();
        int totalCases = Integer.parseInt(line);
        String[] outputs = new String[totalCases];        
        for (int testCase = 1; testCase <= totalCases; testCase++) {
            line = input.nextLine();
            String[] values = line.split("[ ]");
            int    tP = Integer.parseInt(values[0]);
            int    tR = Integer.parseInt(values[1]);
            double k  = Double.parseDouble(values[2]);
            int    q  = Integer.parseInt(values[3]);
            int    m  = Integer.parseInt(values[4]);   
            double temperature = (double)tP;
            for (int min = 1; min <= m; min++) {                
                temperature = temperature +  k * (((double)tP) - 
                        (((double)tR) + (((double)min) * ((double)q))));
            }
            outputs[testCase-1] = "Case #" + testCase + " " + temperature;
        }
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i]);
        }
    }
        
}
