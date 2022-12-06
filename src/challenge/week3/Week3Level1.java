
package challenge.week3;

import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week3Level1 extends Problem
{

    public static void main(String[] args) {
        new Week3Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        ArrayList<String> outputs = new ArrayList<>();                          // Instantiate array list for outputs
        int index = 0;                                                          // Start an index count
        while (!line.equals("0")) {                                             // Loop until a "0" is encountered
            String message = "";                                                // Variable to add to the message
            int i = 0;                                                          // Second index counter
            boolean done = false;                                               // Flag to indicate when done
            while (i < line.length() && !done) {                                // Traverse all characters in line (or a "0" is encountered)
                char value = line.charAt(i);                                    // Read a character out of the line
                if (Character.isDigit(value)) {                                 // Character is a digit
                    if (value == '0') {                                         // The "0" is encountered
                        outputs.add("Case #" + index + ": " + message);         // Add message to the list of outputs
                        index++;                                                // Advance to next index
                        done = true;                                            // Flag as done
                    }
                    else {                                                      // Another digit encountered
                        i += Integer.parseInt("" + value);                      // Convert to integer and add to index "i"
                    }
                }
                if (!done) {                                                    // Not yet done with input
                    char character = line.charAt(i);                            // Read a character out of the line
                    if (character == '_') character = ' ';                      // Convert to space if "_" encountered
                    message += character;                                       // Concatinate character to message
                    i++;                                                        // Advance index "i" by one
                }
            }
            line = input.nextLine();                                            // Read in the next full line of input
        }
        for (int i = 0; i < outputs.size(); i++) {                              // Traverse outputs list
            System.out.println(outputs.get(i));                                 // Output each list item
        }
    }

}
