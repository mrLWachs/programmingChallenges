
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level3 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level3().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        int totalTests = Integer.parseInt(line);                                // Convert the line into the integer
        String[] outputs = new String[totalTests];                              // Create array for all the outputs
        for (int test = 0; test < totalTests; test++) {                         // Traverse all the tests
            line = input.nextLine();                                            // Read in the next full line of input
            int size = Integer.parseInt(line);                                  // Convert to the size integer
            line = input.nextLine();                                            // Read in the next full line of input
            String[] values = line.split("[ ]");                                // Split the line into a string array
            int[]    board  = new int[size];                                    // Create an integer array of the same size
            for (int i = 0; i < board.length; i++) {                            // Traverse the array
                board[i] = Integer.parseInt(values[i]);                         // Convert string to integer
            }
            final String WIN  = "Active player wins.";                          // Scenario for a win
            final String LOSE = "Active player loses.";                         // Scenario for a loss
            if (check(board)) outputs[test] = WIN;                              // Check for win, add to outputs
            else              outputs[test] = LOSE;                             // Add loss to outputs
        }
        for (int i = 0; i < outputs.length; i++) {                              // Traverse the outputs array
            System.out.println(outputs[i]);                                     // Output to user
        }        
    }

    private static boolean check(int[] board) {
        int       player  = 0;                                                  // Track current player
        int       end     = board.length - 1;                                   // Mark the end off the array
        boolean[] visited = new boolean[board.length];                          // Array of visited spots
        while(player < end && visited[player] != true) {                        // Loop til the end and not visited a spot yet
            int moves = board[player];                                          // Get the moves from the board
            visited[player] = true;                                             // Mark this spot on the board as visited
            if (moves % 2 == 0) player -= moves;                                // Move forward or backward if divisible by 2
            else                player += moves;                                // Move forward
            if (player >= end) return true;                                     // Reached the end of the board and won
        }
        return false;                                                           // Did not win
    }

}
