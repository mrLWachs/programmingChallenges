
package challenge.week3;

import java.util.Scanner;
import mainpackage.Problem;


public class Week3Level2 extends Problem
{
    
    public static void main(String[] args) {
        new Week3Level2().start();
    }
          
    static final String[][] GRID = {
        {"A","B","C","D","E","F"},
        {"G","H","I","J","K","L"},
        {"M","N","O","P","Q","R"},
        {"S","T","U","V","W","X"},
        {"Y","Z"," ","-",".","enter"}            
    };
    static int currentRow    = 0;
    static int currentColumn = 0;
    
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
        totalMoves += getMoves("enter");
        System.out.println(totalMoves);        
    }
    
    private int getMoves(String value) {
        int foundRow      = findRow(value);
        int foundColumn   = findColumn(value);
        int movesToRow    = findRowMoves(foundRow);
        int movesToColumn = findColumnMoves(foundColumn);
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

    private int findRowMoves(int foundRow) {
        if (foundRow < currentRow)  return currentRow - foundRow;
        if (foundRow > currentRow)  return foundRow   - currentRow;
        return 0;
    }

    private int findColumnMoves(int foundColumn) {
        if (foundColumn < currentColumn)  return currentColumn - foundColumn;
        if (foundColumn > currentColumn)  return foundColumn   - currentColumn;
        return 0;
    }
    
}
