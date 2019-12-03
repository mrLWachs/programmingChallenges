
package data.week3;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;

public class Week3Level4Run  extends Problem
{

    public void start() {   
        System.out.header("Week 3, Level 4: starting");          
        String[] lines = { 
           "3",
           "._._._.",
           "|     |",
           ". ._. .",
           "| | | |",
           "._. ._.",
           "       ",
           "       ",
           "7",
           "._._.   ._.    ",
           "|   |   | |    ",
           "._. .   . ._.  ",
           "  | |   |   |  ",
           "._. ._._.   ._.",
           "|             |",
           "._. ._._.   ._.",
           "  | |   |   |  ",
           "._. .   .   .  ",
           "|   |   |   |  ",
           ".   .   .   ._.",
           "|   |   |     |",
           ".   .   ._._._.",
           "|   |          ",
           "._._.          ",
           "0"           
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n"); 
        ArrayList<String> outputs = new ArrayList<>();        
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String line = lines[testCase];       
            
            while (!line.equals("0")) {
                int n = Integer.parseInt(line);
                int size = 2*n+1;
                char[][] grid = new char[size][size];
                for (int i = 0; i < size; i++) {
                    testCase++;
                    line = lines[testCase];
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
                outputs.add(text);
                testCase++;
                line = lines[testCase];
            }      
            
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        } 
        System.out.header("Week 3, Level 4: complete");
        System.flush();
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
