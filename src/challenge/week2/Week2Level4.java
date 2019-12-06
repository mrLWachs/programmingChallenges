package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level4 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level4().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        String line = input.nextLine();                                         // read in the next full line of input
        int totalTests = Integer.parseInt(line);                                // convert to integer for total tests
        String[] outputs = new String[totalTests];                              // create output array for all test cases
        for (int test = 0; test < totalTests; test++) {                         // loop though all test cases
            line = input.nextLine();                                            // read in the next full line of input
            String[] values = line.split("[ ]");                                // split the line into a string array
            int n = Integer.parseInt(values[0]);                                // get n value from index 0
            int t = Integer.parseInt(values[1]);                                // get t value from index 1
            char[][] grid = new char[n][n];                                     // create char matrix from n value
            for (int i = 0; i < n; i++) {                                       // traverse all rows
                line = input.nextLine();                                        // read in the next full line of input
                char[] row = line.toCharArray();                                // convert to a char array 
                grid[i] = row;                                                  // assign char array to row in matrix
            }
            showGrid(grid,0);                                                   // show the grid 
            for (int i = 1; i <= t; i++) {                                      // traverse all the generations
                grid = life(grid,i);                                            // apply the rules of life to a new grid
                showGrid(grid,i);                                               // show that grid
            }        
        }
        for (int i = 0; i < outputs.length; i++) {                              // traverse all outputs
            System.out.println(outputs[i]);                                     // output to the screen
        }
    }

    private char[][] life(char[][] grid, int generation) {
        final char ALIVE = 'X';                                                 // mark a living spot
        final char DEAD  = '_';                                                 // mark a dead spot
        int size = grid.length;                                                 // get the size of the grid
        char[][] nextGeneration = new char[size][size];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (isAlive(r,c,grid)) {
                    if      (count(r,c,grid) < 2) nextGeneration[r][c] = DEAD;
                    else if (count(r,c,grid) > 3) nextGeneration[r][c] = DEAD;
                    else                          nextGeneration[r][c] = ALIVE;
                }
                else {
                    if (count(r,c,grid) == 3) nextGeneration[r][c] = ALIVE;
                    else                      nextGeneration[r][c] = DEAD;
                }
            }
        }
        return nextGeneration;
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