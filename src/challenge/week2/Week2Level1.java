
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level1 extends Problem
{

    public static void main(String[] args) {
        new Week2Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        final String WIN  = "W";                                                // The win scenario
        int winCount  = 0;                                                      // Track how many wins
        int result    = -1;                                                     // The various results
        for (int i = 0; i < 6; i++) {                                           // Go through 6 lines of input
            String line = input.nextLine();                                     // Read in the next full line of input
            if (line.equalsIgnoreCase(WIN)) winCount++;                         // If a win scenario occurs, count it
        }
        if      (winCount >= 5) result = 1;                                     // Depending on how many wins, change result
        else if (winCount >= 3) result = 2;
        else if (winCount >= 1) result = 3;
        System.out.println(result);                                             // Display final result
    }

}
