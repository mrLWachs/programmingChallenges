
package data.week9;

import io.System;
import java.util.Scanner;
import mainpackage.AutoRun;


public class Week9Level2Run  extends AutoRun
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
            "1 2 3",
            "7 9 12345679",
            "3 4 278",
            "0 0 0"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n"); 
        int i = 0;
        String line = lines[i];
        while (!line.equals("0 0 0")) {
            String[] values = line.split("[ ]");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);
            int z = Integer.parseInt(values[2]);
            i++;
            check(x,y,z,i);
            line = lines[i];
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void check(int x, int y, int z, int count) {        
        int answer = x*y*z;
        String text = "CASE " + count + ": " + answer;
        int times = occurances("" + x,"" + answer);
        if (times == y) text += " yes";
        else            text += " no";
        System.out.println(text);
    }

    private int occurances(String number, String sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            String digit = sequence.charAt(i) + "";
            if (number.equals(digit)) count++;
        }
        return count;
    }
    
}
