
package data.week7;

import io.System;
import mainpackage.AutoRun;


public class Week7Level4Run  extends AutoRun
{

    public void auto(int week, int level) {
        start(week, level);
        System.autoFlush();
    }
    
    public void run(int week, int level) {
        start(week, level);
        System.flush();
    }

    private void start(int week, int level) {  
        System.out.header("Week " + week + ", Level " + level + ": starting");        
        String[] lines = { 
           "HV",
           "VVHH"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");   
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int[][] grid = allFlips(line);
            System.out.println(toString(grid));
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    private int[][] allFlips(String line) {
        final int[][] DEFAULT = {
            {1,2},
            {3,4}
        };
        int[][] grid = DEFAULT;
        for (int i = 0; i < line.length(); i++) {
            char direction = line.charAt(i);
            grid = flip(grid,direction);
        }
        return grid;
    }

    private String toString(int[][] grid) {
        String text = "";
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                text += grid[row][column] + " ";
            }
            text += "\n";
        }
        return text;
    }

    private int[][] flip(int[][] grid, char direction) {
        int[][] newGrid = {
            {0,0},
            {0,0}
        };
        if (direction == 'V') {
            newGrid[0][0] = grid[0][1];
            newGrid[0][1] = grid[0][0];
            newGrid[1][0] = grid[1][1];
            newGrid[1][1] = grid[1][0];            
        }
        else if (direction == 'H') {
            newGrid[1] = grid[0];
            newGrid[0] = grid[1];
        }
        return newGrid;
    }
    
}
