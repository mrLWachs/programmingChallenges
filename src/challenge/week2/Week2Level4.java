package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level4 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level4().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        int totalTests = Integer.parseInt(line);                                // Convert to integer for total tests
        String[] outputs = new String[totalTests];                              // Create output array for all test cases
        for (int test = 0; test < totalTests; test++) {                         // Loop though all test cases
            line = input.nextLine();                                            // Read in the next full line of input
            String[] values = line.split("[ ]");                                // Split the line into a string array
            int n = Integer.parseInt(values[0]);                                // Get n value from index 0
            int t = Integer.parseInt(values[1]);                                // Get t value from index 1
            char[][] grid = new char[n][n];                                     // Create char matrix from n value
            for (int i = 0; i < n; i++) {                                       // Traverse all rows
                line = input.nextLine();                                        // Read in the next full line of input
                char[] row = line.toCharArray();                                // Convert to a char array 
                grid[i] = row;                                                  // Assign char array to row in matrix
            }
            showGrid(grid,0);                                                   // Show the grid 
            for (int i = 1; i <= t; i++) {                                      // Traverse all the generations
                grid = life(grid);                                              // Apply the rules of life to a new grid
                showGrid(grid,i);                                               // Show that grid
            }        
        }
        for (int i = 0; i < outputs.length; i++) {                              // Traverse all outputs
            System.out.println(outputs[i]);                                     // Output to the screen
        }
    }

    private char[][] life(char[][] grid) {
        final char ALIVE = 'X';                                                 // Mark a living spot
        final char DEAD  = '_';                                                 // Mark a dead spot
        int size = grid.length;                                                 // Get the size of the grid
        char[][] nextGeneration = new char[size][size];                         // Instatiate grid matrix
        for (int r = 0; r < grid.length; r++) {                                 // Traverse rows
            for (int c = 0; c < grid[r].length; c++) {                          // Traverse columns
                if (isAlive(r,c,grid)) {                                        // Check if cell if alive
                    if      (count(r,c,grid) < 2) nextGeneration[r][c] = DEAD;  // Rule to set to dead (in next generation)
                    else if (count(r,c,grid) > 3) nextGeneration[r][c] = DEAD;  // Rule to set to dead (in next generation)
                    else                          nextGeneration[r][c] = ALIVE; // Cell stays alive for next generation
                }
                else {                                                          // Cell is dead
                    if (count(r,c,grid) == 3) nextGeneration[r][c] = ALIVE;     // Rule to set to alive (in next generation)
                    else                      nextGeneration[r][c] = DEAD;      // Cell stays dead for next generation
                }
            }
        }
        return nextGeneration;                                                  // Next generation returned
    }
    
    private static void showGrid(char[][] grid, int generation) {
        String text = "CASE " + generation + "\n";
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                text += grid[r][c] + "";
            }
            text += "\n";
        }
        System.out.println(text);
    }

    private boolean isAlive(int row, int column, char[][] grid) {
        final char ALIVE = 'X';
        int size = grid.length;
        if (row    < 0 || row    >= size) return false;
        if (column < 0 || column >= size) return false;
        if (grid[row][column] == ALIVE) return true;
        return false;
    }

    private int count(int row, int column, char[][] grid) {
        int count = 0;
        if (isAlive(row - 1, column - 1, grid)) count++;
        if (isAlive(row    , column - 1, grid)) count++;
        if (isAlive(row + 1, column - 1, grid)) count++;        
        if (isAlive(row - 1, column    , grid)) count++;
        if (isAlive(row + 1, column    , grid)) count++;        
        if (isAlive(row - 1, column + 1, grid)) count++;
        if (isAlive(row    , column + 1, grid)) count++;
        if (isAlive(row + 1, column + 1, grid)) count++;        
        return count;
    }
    
}