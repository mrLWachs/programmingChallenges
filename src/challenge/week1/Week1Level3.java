
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;

public class Week1Level3 extends Problem
{

    public static void main(String[] args) {
        new Week1Level3().start();
    }
    
    public void start()  {
        int[][] grid = createGrid();                                            // create the needed grid matrix
        while (check(grid) == false) {                                          // loop to rotate grid until in correct position
            grid = rotate(grid);                                                // rebuild grid after a rotation
        }        
        output(grid);                                                           // output correct grid
    }

    private static int[][] createGrid() {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        String line = input.nextLine();                                         // read in the next full line of input
        int size = Integer.parseInt(line);                                      // convert to the size of the grid
        int[][] grid = new int[size][size];                                     // build matrix grid of that size
        for (int r = 0; r < grid.length; r++) {                                 // traverse the rows of the matrix
            line = input.nextLine();                                            // read in the next full line of input
            int[] values = getValues(line);                                     // convert the line to array of integers
            for (int c = 0; c < grid[r].length; c++) {                          // traverse the columns of the matrix
                grid[r][c] = values[c];                                         // assign the single dimension array to matrix row
            }
        }
        return grid;                                                            // return completed matrix
    }

    private static int[] getValues(String line) {
        String[] values = line.split("[ ]");                                    // split the line into a string array
        int[] numbers = new int[values.length];                                 // create an int array of the same size as string array
        for (int i = 0; i < numbers.length; i++) {                              // traverse array
            numbers[i] = Integer.parseInt(values[i]);                           // convert string into integer and assign to array
        }
        return numbers;                                                         // return new array
    }

    private static boolean check(int[][] grid) {
        int highest = grid[0][0];                                               // track highest vale starting at first location
        for (int row = 0; row < grid.length; row++) {                           // traverse matrix rows
            if (grid[row][0] < highest) return false;                           // new location less than highest, return grid not correct
            else                        highest = grid[row][0];                 // new location is now the highest
            if (!checkColumn(grid,row)) return false;                           // now check all the columns of this row, return if not correct
        }
        return true;                                                            // return entire grid is correct
    }

    private static boolean checkColumn(int[][] grid, int row) {
        int highest = grid[row][0];                                             // track highest vale starting at first location
        for (int c = 1; c < grid[row].length; c++) {                            // traverse matrix columns
            if (grid[row][c] < highest) return false;                           // new location less than highest, return grid not correct
            else                        highest = grid[row][c];                 // new location is now the highest
        }
        return true;                                                            // return this column is correct
    }
    
    private static int[][] rotate(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];                    // create another matrix the same size
        int r = 0;                                                              // track row
        for (int c = 0; c < grid.length; c++) {                                 // traverse matrix columns
            int[] column = getColumn(grid,c);                                   // create an array from this column of the matrix
            newGrid = fillRow(newGrid,column,r);                                // assign this array to the row of the new matrix
            r++;                                                                // advance to the next row
        }
        return newGrid;                                                         // return new matrix representing a rotation
    }

    private static int[] getColumn(int[][] grid, int column) {
        int[] columnToGet = new int[grid.length];                               // create array same size as matrix column
        for (int r = 0; r < grid.length; r++) {                                 // traverse matrix row
            columnToGet[r] = grid[r][column];                                   // assign matrix row and column to array
        }
        return columnToGet;                                                     // return new array representing a column
    }

    private static int[][] fillRow(int[][] grid, int[] column, int row) {
        int[] reversed = reverse(column);                                       // create new array from a reverse of the column
        for (int c = 0; c < grid.length; c++) {                                 // traverse matrix column
            grid[row][c] = reversed[c];                                         // assign reverse column index to original matrix column
        }
        return grid;                                                            // return grid with reversed column
    }

    private static int[] reverse(int[] array) {
        int[] reverse = new int[array.length];                                  // create new array same size of old array
        int index = 0;                                                          // track current index location
        for (int i = array.length - 1; i >= 0; i--) {                           // traverse old array in reverse
            reverse[index] = array[i];                                          // assign spot from old array to new array at tracked index
            index++;                                                            // advance index to next location
        }
        return reverse;                                                         // return new array representing a reverse of old array
    }
    
    private static void output(int[][] grid) {
        String value = "";                                                      // variable to store the output
        for (int r = 0; r < grid.length; r++) {                                 // traverse matrix rows
            for (int c = 0; c < grid[r].length; c++) {                          // traverse matrix columns
                value += grid[r][c] + " ";                                      // add matrix location to output
            }
            value += "\n";                                                      // add new line to output
        }
        System.out.println(value);                                              // output the matrix
    }

}
