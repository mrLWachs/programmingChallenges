
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
            "1",
            "2",
            "3",
            "4",
            "5",
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
            makeRuler(n,(i+1));
            i++;
            line = lines[i];
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void output(String[][] grid, int count) {
        System.out.println("=CASE " + count + "=");
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == null) System.out.print(".");
                else                    System.out.print(grid[r][c]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    private void makeRuler(int n, int count) {
        int rows        = n + 1;
        int columns     = (int)(Math.pow(2, n)) + 1;
        String[][] grid = new String[rows][columns];
        
        int start  = 0;
        int end    = columns-1;
        int length = rows;
        
        fill(start,grid,length);
        fill(end,grid,length);
        
        length--;
         
        int mid = (start + end) / 2;
        
        fill(mid,grid,length);
        
        length--;
        
        int start1 = mid + 1;
        int end1   = end - 1;
        int mid1   = (start1 + end1) / 2;
                
        fill(mid1,grid,length);
        
        int start2 = start + 1;
        int end2   = mid - 1;
        int mid2   = (start2 + end2) / 2;
                
        fill(mid2,grid,length);
        
        output(grid,count);
        

    }

    private void fill(int column, String[][] grid, int length) {
        for (int i = 0; i < grid.length; i++) {
            if (i < length) grid[i][column] = "|";
            else            grid[i][column] = null;
        }
    }
   
    
}


        
//        int length = rows;
//        int index  = columns - 1;
//        
//        
//        for (int c = 0; c < columns; c++) {
//            
//            int column1 = index;
//                        
//            fill(column1,grid,length);
//            
//            index = index / 2;
//            
////            int column2 = column1 + index;
////            
////            fill(column2,grid,length);
//            
//            length--;
//        }
//        
//        
//        output(grid,count);

//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < columns; c++) {
//                if (r ==0) {
//                    grid[r][c] = "|";
//                }
//                else if (c ==0 || c == grid[r].length-1) {
//                    grid[r][c] = "|";
//                }
//                else {
//                    grid[r][c] = ".";
//                }                
//            }
//        }
        
        
        
        
        
        
        
//        for (int i = n; i >= 0; i--) {
//            
//            
//            
//            int exponent = i;
//            int smallest = (int)(Math.pow(2, exponent));
//            
////            System.out.println("exponent = " + exponent);
////            System.out.println("smallest = " + smallest);
//            
//            
//            for (int j = 0; j <= smallest; j++) {
//                System.out.print("|");
//            }
//            System.out.println("");
//        }
        
//        System.out.println("");