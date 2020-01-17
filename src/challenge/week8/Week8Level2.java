package challenge.week8;

import java.util.Scanner;
import mainpackage.Problem;


public class Week8Level2 extends Problem
{

    public static void main(String[] args) {
        new Week8Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);        
        int[][] square = new int[4][4];
        for (int row = 0; row < 4; row++) {
            String line = input.nextLine();
            String[] values = line.split("[ ]");
            for (int column = 0; column < values.length; column++) {
                square[row][column] = Integer.parseInt(values[column]);                
            }
        }
        isMagic(square);
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