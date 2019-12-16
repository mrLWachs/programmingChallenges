
package challenge.week7;

import java.util.Scanner;
import mainpackage.Problem;


public class Week7Level4 extends Problem
{

    public static void main(String[] args) {
        new Week7Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);        
        String line = input.nextLine();
        int[][] grid = allFlips(line);
        System.out.println(toString(grid));        
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
