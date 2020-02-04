
package data.week9;

import io.System;
import mainpackage.AutoRun;


public class Week9Level4Run  extends AutoRun
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
            "2",
            "4",          
            "0"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");
        String line = lines[0];
        int i = 0;
        while (!line.equals("0")) {
            int n = Integer.parseInt(line);
            System.out.println(makeRuler(n,(i+1)));
            i++;
            line = lines[i];
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private String makeRuler(int n, int count) {
        final String LINE  = "|";
        final String SPACE = " ";
        int old = 0;
        int rows        = n + 1;
        int columns     = (int)(Math.pow(2, n)) + 1;
        String[][] grid = new String[rows][columns];
        for (int r = 0; r < rows; r++) {
            if (r == 0) {
                for (int c = 0; c < columns; c++) {
                    grid[r][c] = LINE;
                }
            }
            else {
                int spaces = old * 2 + 1;
                old = spaces;                
                boolean isSpace = false;                
                for (int c = 0; c < columns; c++) {                    
                    if (!isSpace) {
                        grid[r][c] = LINE;
                        isSpace = true;
                    }
                    else {
                        for (int i = 0; i < spaces; i++) {
                            c++;
                            grid[r][c] = SPACE;
                        }
                        c--;
                        isSpace = false;
                    }                    
                }                
            }
        }
        String text = "=CASE " + count + "=\n";
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == null) grid[row][column] = SPACE;
                text += grid[row][column];
            }
            text += "\n";
        }
        text += "\n";
        return text;
    }
    
}
