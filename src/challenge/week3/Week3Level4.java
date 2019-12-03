
package challenge.week3;

import java.util.Scanner;
import mainpackage.Problem;


public class Week3Level4 extends Problem
{

    public static void main(String[] args) {
        new Week3Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        while (!line.equals("0")) {
            int n = Integer.parseInt(line);
            int size = 2*n+1;
            char[][] grid = new char[size][size];
            for (int i = 0; i < size; i++) {
                line = input.nextLine();
                char[] symbols = line.toCharArray();
                grid[i] = symbols;
            }       
            String text = "";
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[row].length; column++) {
                    char symbol = grid[row][column]; 
                    if (row    % 2 != 0 && 
                        column % 2 != 0 &&
                        symbol == ' ') {
                        text += countEdges(row,column,grid);
                    }
                    else {
                        text += symbol;
                    }
                }
                text += "\n";
            }
            System.out.println(text);
            line = input.nextLine();
        }        
    }
    
    private String countEdges(int r, int c,char[][] grid) {
        int count = 0;
        if (inBounds(r-1, c  ,grid)) {
            if (grid[r-1][c  ] == '_') count++;
            if (grid[r-1][c  ] == '|') count++;            
        }
        if (inBounds(r  , c-1,grid)) {
            if (grid[r  ][c-1] == '_') count++;
            if (grid[r  ][c-1] == '|') count++;            
        }
        if (inBounds(r  , c+1,grid)) {
            if (grid[r  ][c+1] == '_') count++;
            if (grid[r  ][c+1] == '|') count++;            
        }
        if (inBounds(r+1, c  ,grid)) {
            if (grid[r+1][c  ] == '_') count++;
            if (grid[r+1][c  ] == '|') count++;
        }
        return "" + count;
    }

    private boolean inBounds(int r, int c, char[][] grid) {
        int max = grid.length-1;
        if (r < 0)   return false;
        if (c < 0)   return false;
        if (r > max) return false;
        if (c > max) return false;
        return true;
    }
    
}
