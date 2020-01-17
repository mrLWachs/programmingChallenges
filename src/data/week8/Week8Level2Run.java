
package data.week8;

import io.System;
import java.util.Scanner;
import mainpackage.AutoRun;


public class Week8Level2Run  extends AutoRun
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
           "16 3 2 13",
           "5 10 11 8",
           "9 6 7 12",
           "4 15 14 1",
           "5 10 1 3",
           "10 4 2 3",
           "1 2 8 5",
           "3 3 5 0"            
        };
        System.out.println("Inputs:\n");
        for (int i = 1; i < lines.length; i++) {
            System.out.println(lines[i]);
            if (i == 4) System.out.println("");
        }
        System.out.println("\nOutputs:\n"); 
        int iterations = Integer.parseInt(lines[0]);
        int lineNumber = 1;
        for (int testCases = 0; testCases < iterations; testCases++) {
            int[][] square = new int[4][4];
            for (int row = 0; row < 4; row++) {
                String line = lines[lineNumber];
                lineNumber++;
                String[] values = line.split("[ ]");
                for (int column = 0; column < values.length; column++) {
                    square[row][column] = Integer.parseInt(values[column]);                
                }
            }
            isMagic(square);
            System.out.println("");
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void isMagic(int[][] square) {        
        int total = getRowTotal(0,square);
        for (int r = 0; r < 4; r++) {
            int newTotal = getRowTotal(r,square);
            if (newTotal != total) {
                System.out.println("Not Magic");
                return;
            }
        }
        for (int c = 0; c < 4; c++) {
            int newTotal = getColumnTotal(c,square);
            if (newTotal != total) {
                System.out.println("Not Magic");
                return;
            }
        }
        System.out.println("magic");
    }

    private int getRowTotal(int row, int[][] matrix) {
        int total = 0;
        for (int column = 0; column < matrix[row].length; column++) {
            total += matrix[row][column];
        }
        return total;
    }

    private int getColumnTotal(int column, int[][] matrix) {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            total += matrix[row][column];
        }
        return total;
    }
    
}
