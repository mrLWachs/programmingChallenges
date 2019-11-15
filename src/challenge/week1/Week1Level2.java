
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;

public class Week1Level2 extends Problem
{

    public static void main(String[] args) {
        new Week1Level2().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        String line = input.nextLine();                                         // read in the next full line of input
        int[] counts = new int[3];                                              // create array to count instances of cards
        boolean[] counted = new boolean[3];                                     // create array to flag if card encountered
        for (int i = 0; i < line.length(); i++) {                               // traverse entire line of input
            char letter = line.charAt(i);                                       // get current character
            if (letter == 'a') {                                                // check if first card
                counts[0]++;                                                    // increase card count by one
                counted[0] = true;                                              // flag this card as counted
            }
            if (letter == 'b') {                                                // check if second card
                counts[1]++;                                                    // increase card count by one
                counted[1] = true;                                              // flag this card as counted
            }
            if (letter == 'c') {                                                // check if third card
                counts[2]++;                                                    // increase card count by one
                counted[2] = true;                                              // flag this card as counted
            }                
        }
        String output = "no set";                                               // assume no set
        if (counted[0] && counted[1] && counted[2]) output = "set: abc";        // all flagged so full set
        if (counts[0] >= 3) output = "set of three: a";                         // show count of this set
        if (counts[1] >= 3) output = "set of three: b";                         // show count of this set
        if (counts[2] >= 3) output = "set of three: c";                         // show count of this set
        System.out.println(output);                                             // output final result
    }
    
}
