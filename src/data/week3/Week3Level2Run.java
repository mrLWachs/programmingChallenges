
package data.week3;

import io.System;
import mainpackage.Problem;

public class Week3Level2Run  extends Problem
{

    final String ENTER = "enter";
    final String SPACE = " ";    
    final String DASH  = "-";    
    final String DOT   = ".";   
    final String[][] GRID = {
        {"A","B","C","D","E","F"},
        {"G","H","I","J","K","L"},
        {"M","N","O","P","Q","R"},
        {"S","T","U","V","W","X"},
        {"Y","Z",SPACE,DASH,DOT,ENTER}            
    };
    int currentRow    = 0;
    int currentColumn = 0;
    
    public void start() {   
        System.out.header("Week 3, Level 2: starting");          
        String[] lines = { 
           "GPS",
           "ECHO ROCK"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");        
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String text = lines[testCase];
             
            currentRow    = 0;
            currentColumn = 0;
            String line = text;
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
        System.out.header("Week 3, Level 2: complete");
        System.flush();
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
