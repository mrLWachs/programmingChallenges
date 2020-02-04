
package challenge.week9;

import java.util.Scanner;
import mainpackage.Problem;


public class Week9Level4 extends Problem
{

    public static void main(String[] args) {
        new Week9Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int i = 0;
        while (!line.equals("0")) {
            int n = Integer.parseInt(line);
            System.out.println(makeRuler(n,(i+1)));
            i++;
            line = input.nextLine();
        }
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