
package data.week8;

import io.System;
import mainpackage.AutoRun;


public class Week8Level4Run  extends AutoRun
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
            "1",
            "20 7",
            "..#####......#####..",
            ".#.....#....#.....#.",
            ".#..........#.......",
            ".#...........#####..",
            ".#................#.",
            ".#.....#....#.....#.",
            "..#####......#####.."  
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");            
        
        String line = lines[0];
        int testCases = Integer.parseInt(line);
        int i = 0;
        for (int testCase = 0; testCase < testCases; testCase++) {
            i++;
            line = lines[i];
            String[] values = line.split("[ ]");
            int columns = Integer.parseInt(values[0]);
            int rows    = Integer.parseInt(values[1]);
            char[][] image = new char[rows][columns];
            for (int currentRow = 0; currentRow < rows; currentRow++) {
                i++;
                line = lines[i];
                char[] row = line.toCharArray();
                image[currentRow] = row;
            }
            output(image);
            char[][] reverseImage = mirror(image);
            output(reverseImage);
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
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
