package challenge.week8;

import java.util.Scanner;
import mainpackage.Problem;


public class Week8Level4 extends Problem
{

    public static void main(String[] args) {
        new Week8Level4().start();
    }
    
    public void start() {        
        Scanner input = new Scanner(System.in);  
        String line = input.nextLine();
        int testCases = Integer.parseInt(line);
        for (int testCase = 0; testCase < testCases; testCase++) {
            line = input.nextLine();
            String[] values = line.split("[ ]");
            int columns = Integer.parseInt(values[0]);
            int rows    = Integer.parseInt(values[1]);
            char[][] image = new char[rows][columns];
            for (int currentRow = 0; currentRow < rows; currentRow++) {
                line = input.nextLine();
                char[] row = line.toCharArray();
                image[currentRow] = row;
            }
            output(image);
            char[][] reverseImage = mirror(image);
            output(reverseImage);
        }
    }

    private void output(char[][] matrix) {
        String text = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                text += matrix[row][column];
            }
            text += "\n";
        }
        System.out.println(text);
    }

    private char[][] mirror(char[][] image) {
        int rows    = image.length;
        int columns = image[0].length;
        char[][] flip = new char[rows][columns];        
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            char[] row = reverse(image[currentRow]);
            flip[currentRow] = row;
        }
        return flip;
    }

    private char[] reverse(char[] array) {
        int mid   = array.length / 2;
        int start = 0;
        int end   = array.length - 1;
        for (int i = 0; i < mid; i++) {
            char front = array[start];
            char back  = array[end];
            array[start] = back;
            array[end]   = front;
            start++;
            end--;
        }        
        return array;
    }

}