
package challenge.week3;

import java.util.Scanner;
import mainpackage.Problem;


public class Week3Level2 extends Problem
{
        
    static final String ENTER = "enter";
    static final String SPACE = " ";    
    static final String DASH  = "-";    
    static final String DOT   = ".";   
    static final String[][] GRID = {
        {"A","B","C","D","E","F"},
        {"G","H","I","J","K","L"},
        {"M","N","O","P","Q","R"},
        {"S","T","U","V","W","X"},
        {"Y","Z",SPACE,DASH,DOT,ENTER}            
    };
    static int currentRow    = 0;
    static int currentColumn = 0;

    public static void main(String[] args) {
        new Week3Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line   = input.nextLine();
        line = line.toUpperCase();
        char[] characters = line.toCharArray();
        String[] values = new String[characters.length];
        for (int i = 0; i < characters.length; i++) {
            values[i] = characters[i] + "";
        }
        int totalMoves = 0;
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            totalMoves += getMoves(value);            
        }
        totalMoves += getMoves(ENTER);
        System.out.println(totalMoves);        
    }
    
    private int getMoves(String value) {
        int foundRow      = findRow(value);
        int foundColumn   = findColumn(value);
        int movesToRow    = findRowMoves(value,foundRow);
        int movesToColumn = findColumnMoves(value,foundColumn);
        int totalMoves    = movesToRow + movesToColumn;
        currentRow        = foundRow;
        currentColumn     = foundColumn;
        return totalMoves;
    }

    private int findRow(String value) {
        for (int r = 0; r < GRID.length; r++) {
            for (int c = 0; c < GRID[r].length; c++) {
                if (GRID[r][c].equals(value)) {
                    return r;
                }
            }
        }
        return 0;
    }

    private int findColumn(String value) {
        for (int r = 0; r < GRID.length; r++) {
            for (int c = 0; c < GRID[r].length; c++) {
                if (GRID[r][c].equals(value)) {
                    return c;
                }
            }
        }
        return 0;
    }

    private int findRowMoves(String value, int foundRow) {
        if (foundRow < currentRow)  return currentRow - foundRow;
        if (foundRow > currentRow)  return foundRow   - currentRow;
        return 0;
    }

    private int findColumnMoves(String value, int foundColumn) {
        if (foundColumn < currentColumn)  return currentColumn - foundColumn;
        if (foundColumn > currentColumn)  return foundColumn   - currentColumn;
        return 0;
    }
    
}
