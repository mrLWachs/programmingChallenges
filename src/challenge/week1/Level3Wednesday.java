
package challenge.week1;

import java.util.Scanner;

public class Level3Wednesday 
{

    public static void main(String[] args) {
        int[][] grid = createGrid();
        int rotationcount = 0;
        while (check(grid) == false) {
            grid = rotate(grid);
            rotationcount++;
        }        
        System.out.println("Rotations " + rotationcount);
        output(grid);        
    }

    private static int[][] createGrid() {
        Scanner input = new Scanner(System.in);        
        String text = input.nextLine();
        int size = Integer.parseInt(text);
        int[][] grid = new int[size][size]; 
        for (int r = 0; r < grid.length; r++) {
            String line = input.nextLine();
            int[] values = getValues(line);
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = values[c];
            }
        }
        return grid;
    }

    private static int[] getValues(String line) {
        String[] values = line.split("[ ]");
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;   
    }

    private static boolean check(int[][] grid) {
        boolean checked = false;
        int highest = grid[0][0];
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] < highest) {
                return false;
            }
            else {
                highest = grid[row][0];
            }
            if (!checkColumn(grid,row)) return false;
        }
        return true;
    }

    private static boolean checkColumn(int[][] grid, int row) {
        int highest = grid[row][0];
        for (int c = 1; c < grid[row].length; c++) {
            if (grid[row][c] < highest) {
                return false;
            }
            else {
                highest = grid[row][c];
            }
        }
        return true;
    }
    
    private static int[][] rotate(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];
        int r = 0;
        for (int c = 0; c < grid.length; c++) {
            int[] column = getColumn(grid,c);
            newGrid = fillRow(newGrid,column,r);
            r++;
        }
        return newGrid;
    }

    private static int[] getColumn(int[][] grid, int column) {
        int[] columnToGet = new int[grid.length];
        for (int r = 0; r < grid.length; r++) {
            columnToGet[r] = grid[r][column];
        }
        return columnToGet;
    }

    private static int[][] fillRow(int[][] grid, int[] column, int row) {
        int[] reversed = reverse(column);
        for (int c = 0; c < grid.length; c++) {
            grid[row][c] = reversed[c];
        }
        return grid;
    }

    private static int[] reverse(int[] array) {
        int[] reverse = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reverse[index] = array[i];
            index++;
        }
        return reverse;
    }
    
    private static void output(int[][] grid) {
        String value = "";
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                value += grid[r][c] + " ";
            }
            value += "\n";
        }
        System.out.println(value);
    }

}
