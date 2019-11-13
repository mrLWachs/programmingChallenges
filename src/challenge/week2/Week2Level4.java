package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level4 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level4().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);  
        String line = input.nextLine();
        int totalTests = Integer.parseInt(line);
        String[] outputs = new String[totalTests];
        for (int test = 0; test < totalTests; test++) {
            line = input.nextLine();
            String[] values = line.split("[ ]");
            int n = Integer.parseInt(values[0]);
            int t = Integer.parseInt(values[1]);
            char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                line = input.nextLine();
                char[] row = line.toCharArray();
                grid[i] = row;
            }
            showGrid(grid,0);
            for (int i = 1; i <= t; i++) {
                grid = life(grid,i);
                showGrid(grid,i);
            }        
        }
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i]);
        }
    }

    private char[][] life(char[][] grid, int generation) {
        final char ALIVE = 'X';
        final char DEAD  = '_';        
        int size = grid.length;
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