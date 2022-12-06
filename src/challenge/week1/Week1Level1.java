
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;


public class Week1Level1 extends Problem
{
    
    public static void main(String[] args) {
        new Week1Level1().start();
    }

    public void start()  {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        int totalCases = Integer.parseInt(line);                                // Convert to integer
        String[] outputs = new String[totalCases];                              // Create array for output lines
        for (int testCase = 1; testCase <= totalCases; testCase++) {            // Loop through all test cases
            line = input.nextLine();                                            // Read in the next full line of input
            String[] values = line.split("[ ]");                                // Split the line into a string array
            int    tP = Integer.parseInt(values[0]);                            // Convert first index to temperature of pie
            int    tR = Integer.parseInt(values[1]);                            // Convert second index to temperature of room
            double k  = Double.parseDouble(values[2]);                          // Convert third index to constant k
            int    q  = Integer.parseInt(values[3]);                            // Convert fourth index to degrees of increase
            int    m  = Integer.parseInt(values[4]);                            // Convert fifth index to minutes of cooling
            double temperature = (double)tP;                                    // Start final temoerature as same as pie
            for (int min = 1; min <= m; min++) {                                // Loop through the minutes of cooling
                temperature = temperature +  k * (((double)tP) - 
                        (((double)tR) + (((double)min) * ((double)q))));        // Formula to get new temperature
            }
            outputs[testCase-1] = "Case #" + testCase + " " + temperature;      // Add output to array of outputs
        }
        for (int i = 0; i < outputs.length; i++) {                              // Loop through all outputs
            System.out.println(outputs[i]);                                     // Output the answers
        }
    }
        
}
