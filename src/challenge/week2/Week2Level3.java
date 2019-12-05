
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level3 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level3().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        String line = input.nextLine();                                         // read in the next full line of input
        int totalTests = Integer.parseInt(line);                                // convert the line into the integer
        String[] outputs = new String[totalTests];                              // create array for all the outputs
        for (int test = 0; test < totalTests; test++) {                         // traverse all the tests
            line = input.nextLine();                                            // read in the next full line of input
            int size = Integer.parseInt(line);                                  // convert to the size integer
            line = input.nextLine();                                            // read in the next full line of input
            String[] values = line.split("[ ]");                                // split the line into a string array
            int[]    board  = new int[size];                                    // create an integer array of the same size
            for (int i = 0; i < board.length; i++) {                            // traverse the array
                board[i] = Integer.parseInt(values[i]);                         // convert string to integer
            }
            final String WIN  = "Active player wins.";                          // scenario for a win
            final String LOSE = "Active player loses.";                         // scenario for a loss
            if (check(board)) outputs[test] = WIN;                              // check for win, add to outputs
            else              outputs[test] = LOSE;                             // add loss to outputs
        }
        for (int i = 0; i < outputs.length; i++) {                              // traverse the outputs array
            System.out.println(outputs[i]);                                     // output to user
        }        
    }

    private static boolean check(int[] board) {
        int       player  = 0;                                                  // track current player
        int       end     = board.length - 1;                                   // mark the end off the array
        boolean[] visited = new boolean[board.length];                          // array of visited spots
        while(player < end && visited[player] != true) {                        // loop til the end and not visited a spot yet
            int moves = board[player];                                          // get the moves from the board
            visited[player] = true;                                             // mark this spot on the board as visited
            if (moves % 2 == 0) player -= moves;                                // move forward or backward if divisible by 2
            else                player += moves;                                // move forward
            if (player >= end) return true;                                     // reached the end of the board and won
        }
        return false;                                                           // did not win
    }

}
