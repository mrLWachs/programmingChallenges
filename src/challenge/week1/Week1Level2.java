
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;

public class Week1Level2 extends Problem
{

    public static void main(String[] args) {
        new Week1Level2().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        int[] counts = new int[3];                                              // Create array to count instances of cards
        boolean[] counted = new boolean[3];                                     // Create array to flag if card encountered
        for (int i = 0; i < line.length(); i++) {                               // Traverse entire line of input
            char letter = line.charAt(i);                                       // Get current character
            if (letter == 'a') {                                                // Check if first card
                counts[0]++;                                                    // Increase card count by one
                counted[0] = true;                                              // Flag this card as counted
            }
            if (letter == 'b') {                                                // Check if second card
                counts[1]++;                                                    // Increase card count by one
                counted[1] = true;                                              // Flag this card as counted
            }
            if (letter == 'c') {                                                // Check if third card
                counts[2]++;                                                    // Increase card count by one
                counted[2] = true;                                              // Flag this card as counted
            }                
        }
        String output = "no set";                                               // Assume no set
        if (counted[0] && counted[1] && counted[2]) output = "set: abc";        // All flagged so full set
        if (counts[0] >= 3) output = "set of three: a";                         // Show count of this set
        if (counts[1] >= 3) output = "set of three: b";                         // Show count of this set
        if (counts[2] >= 3) output = "set of three: c";                         // Show count of this set
        System.out.println(output);                                             // Output final result
    }
    
}
