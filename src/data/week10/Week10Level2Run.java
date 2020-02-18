
package data.week10;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;


public class Week10Level2Run  extends AutoRun
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
            "4",
            "6",
            "24",
            "30420",
            "10078"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        int currentLine = 0;
        int dataSets = Integer.parseInt(lines[currentLine]);
        for (int dataSet = 0; dataSet < dataSets; dataSet++) {
            currentLine++;
            int number = Integer.parseInt(lines[currentLine]);
            checkForNasty(number);
        }   
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void checkForNasty(int number) {
        ArrayList<Integer> factors = getFactors(number);
        if (checkNastySum(factors,number)) {
            System.out.println(number + " is nasty");
        }
        else {
            System.out.println(number + " is not nasty");
        }
    }

    private ArrayList<Integer> getFactors(int number) {
        
        return null;
    }

    private boolean checkNastySum(ArrayList<Integer> factors, int number) {
        
        return false;
    }
    
}
