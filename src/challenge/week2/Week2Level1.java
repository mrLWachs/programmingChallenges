
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level1 extends Problem
{

    public static void main(String[] args) {
        new Week2Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        final String WIN  = "W";                                                // the win scenario
        int winCount  = 0;                                                      // track how many wins
        int result    = -1;                                                     // the various results
        for (int i = 0; i < 6; i++) {                                           // go through 6 lines of input
            String line = input.nextLine();                                     // read in the next full line of input
            if (line.equalsIgnoreCase(WIN)) winCount++;                         // if a win scenario occurs, count it
        }
        if      (winCount >= 5) result = 1;                                     // depending on how many wins, change result
        else if (winCount >= 3) result = 2;
        else if (winCount >= 1) result = 3;
        System.out.println(result);                                             // display final result
    }

}
