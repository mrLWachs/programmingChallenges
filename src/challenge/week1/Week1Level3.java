
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;


public class Week1Level3 extends Problem
{

    public static void main(String[] args) {
        new Week1Level3().start();
    }
    
    public void start()  {
        int[][] grid = createGrid();                                            // Create the needed grid matrix
        while (check(grid) == false) {                                          // Loop to rotate grid until in correct position
            grid = rotate(grid);                                                // Rebuild grid after a rotation
        }        
        output(grid);                                                           // Output correct grid
    }

    private static int[][] createGrid() {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        int size = Integer.parseInt(line);                                      // Convert to the size of the grid
        int[][] grid = new int[size][size];                                     // Build matrix grid of that size
        for (int r = 0; r < grid.length; r++) {                                 // Traverse the rows of the matrix
            line = input.nextLine();                                            // Read in the next full line of input
            int[] values = getValues(line);                                     // Convert the line to array of integers
            for (int c = 0; c < grid[r].length; c++) {                          // Traverse the columns of the matrix
                grid[r][c] = values[c];                                         // Assign the single dimension array to matrix row
            }
        }
        return grid;                                                            // Return completed matrix
    }

    private static int[] getValues(String line) {
        String[] values = line.split("[ ]");                                    // Split the line into a string array
        int[] numbers = new int[values.length];                                 // Create an int array of the same size as string array
        for (int i = 0; i < numbers.length; i++) {                              // Traverse array
            numbers[i] = Integer.parseInt(values[i]);                           // Convert string into integer and assign to array
        }
        return numbers;                                                         // Return new array
    }

    private static boolean check(int[][] grid) {
        int highest = grid[0][0];                                               // Track highest vale starting at first location
        for (int row = 0; row < grid.length; row++) {                           // Traverse matrix rows
            if (grid[row][0] < highest) return false;                           // New location less than highest, return grid not correct
            else                        highest = grid[row][0];                 // New location is now the highest
            if (!checkColumn(grid,row)) return false;                           // Now check all the columns of this row, return if not correct
        }
        return true;                                                            // Return entire grid is correct
    }

    private static boolean checkColumn(int[][] grid, int row) {
        int highest = grid[row][0];                                             // Track highest vale starting at first location
        for (int c = 1; c < grid[row].length; c++) {                            // Traverse matrix columns
            if (grid[row][c] < highest) return false;                           // New location less than highest, return grid not correct
            else                        highest = grid[row][c];                 // New location is now the highest
        }
        return true;                                                            // Return this column is correct
    }
    
    private static int[][] rotate(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];                    // Create another matrix the same size
        int r = 0;                                                              // Track row
        for (int c = 0; c < grid.length; c++) {                                 // Traverse matrix columns
            int[] column = getColumn(grid,c);                                   // Create an array from this column of the matrix
            newGrid = fillRow(newGrid,column,r);                                // Assign this array to the row of the new matrix
            r++;                                                                // Advance to the next row
        }
        return newGrid;                                                         // Return new matrix representing a rotation
    }

    private static int[] getColumn(int[][] grid, int column) {
        int[] columnToGet = new int[grid.length];                               // Create array same size as matrix column
        for (int r = 0; r < grid.length; r++) {                                 // Traverse matrix row
            columnToGet[r] = grid[r][column];                                   // Assign matrix row and column to array
        }
        return columnToGet;                                                     // Return new array representing a column
    }

    private static int[][] fillRow(int[][] grid, int[] column, int row) {
        int[] reversed = reverse(column);                                       // Create new array from a reverse of the column
        for (int c = 0; c < grid.length; c++) {                                 // Traverse matrix column
            grid[row][c] = reversed[c];                                         // Assign reverse column index to original matrix column
        }
        return grid;                                                            // Return grid with reversed column
    }

    private static int[] reverse(int[] array) {
        int[] reverse = new int[array.length];                                  // Create new array same size of old array
        int index = 0;                                                          // Track current index location
        for (int i = array.length - 1; i >= 0; i--) {                           // Traverse old array in reverse
            reverse[index] = array[i];                                          // Assign spot from old array to new array at tracked index
            index++;                                                            // Advance index to next location
        }
        return reverse;                                                         // Return new array representing a reverse of old array
    }
    
    private static void output(int[][] grid) {
        String value = "";                                                      // Variable to store the output
        for (int r = 0; r < grid.length; r++) {                                 // Traverse matrix rows
            for (int c = 0; c < grid[r].length; c++) {                          // Traverse matrix columns
                value += grid[r][c] + " ";                                      // Add matrix location to output
            }
            value += "\n";                                                      // Add new line to output
        }
        System.out.println(value);                                              // Output the matrix
    }

}
