
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;

public class Week1Level1 extends Problem
{
    
    public static void main(String[] args) {
        new Week1Level1().start();
    }

    public void start()  {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        String line = input.nextLine();                                         // read in the next full line of input
        int totalCases = Integer.parseInt(line);                                // convert to integer
        String[] outputs = new String[totalCases];                              // create array for output lines
        for (int testCase = 1; testCase <= totalCases; testCase++) {            // loop through all test cases
            line = input.nextLine();                                            // read in the next full line of input
            String[] values = line.split("[ ]");                                // split the line into a string array
            int    tP = Integer.parseInt(values[0]);                            // convert first index to temperature of pie
            int    tR = Integer.parseInt(values[1]);                            // convert second index to temperature of room
            double k  = Double.parseDouble(values[2]);                          // convert third index to constant k
            int    q  = Integer.parseInt(values[3]);                            // convert fourth index to degrees of increase
            int    m  = Integer.parseInt(values[4]);                            // convert fifth index to minutes of cooling
            double temperature = (double)tP;                                    // start final temoerature as same as pie
            for (int min = 1; min <= m; min++) {                                // loop through the minutes of cooling
                temperature = temperature +  k * (((double)tP) - 
                        (((double)tR) + (((double)min) * ((double)q))));        // formula to get new temperature
            }
            outputs[testCase-1] = "Case #" + testCase + " " + temperature;      // add output to array of outputs
        }
        for (int i = 0; i < outputs.length; i++) {                              // loop through all outputs
            System.out.println(outputs[i]);                                     // output the answers
        }
    }
        
}
